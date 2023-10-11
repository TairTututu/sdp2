package adapter_design_pattern;

// Create an interface WebDriver which collects two methods
interface WebDriver {
	// Create 2 public voids
	public void getElement();
	public void selectElement();
}

// Create a class ChromeDriver which implements WebDriver methods
class ChromeDriver implements WebDriver {
	@Override
	public void getElement() {
		// Implementing the getElement method for ChromeDriver
		System.out.println("Get element from ChromeDriver");
	}

	@Override
	public void selectElement() {
		// Implementing the selectElement method for ChromeDriver
		System.out.println("Select element from ChromeDriver");
	}
}

class IEDriver {
	public void findElement() {
		// Implementing the findElement method for IEDriver
		System.out.println("Find element from IEDriver");
	}

	public void clickElement() {
		// Implementing the clickElement method for IEDriver
		System.out.println("Click element from IEDriver");
	}
}

class WebDriverAdapter implements WebDriver {
	IEDriver ieDriver;

	public WebDriverAdapter(IEDriver ieDriver) {
		// Constructor for the WebDriverAdapter, taking an IEDriver instance
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement() {
		// Implementing the getElement method by delegating to IEDriver's findElement
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		// Implementing the selectElement method by delegating to IEDriver's clickElement
		ieDriver.clickElement();
	}
}

public class AdapterPattern {
	public static void main(String[] args) {
		ChromeDriver a = new ChromeDriver();
		a.getElement();
		a.selectElement();

		IEDriver e = new IEDriver();
		e.findElement();
		e.clickElement();

		// Create a WebDriverAdapter to adapt IEDriver to the WebDriver interface
		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement();
		wID.selectElement();
	}
}
