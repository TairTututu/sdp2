package decorator_design_pattern;

// Dress interface represents the basic component
interface Dress {
	public void assemble();
}

// BasicDress class implements the Dress interface, representing a basic dress
class BasicDress implements Dress {
	@Override
	public void assemble() {
		System.out.println("Basic Dress Features");
	}
}

// DressDecorator class is an abstract decorator class implementing the Dress interface
class DressDecorator implements Dress {
	protected Dress dress;

	public DressDecorator(Dress c) {
		this.dress = c;
	}

	@Override
	public void assemble() {
		this.dress.assemble();
	}
}

// CasualDress class is a concrete decorator adding casual features to a dress
class CasualDress extends DressDecorator {
	public CasualDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Casual Dress Features");
	}
}

// SportyDress class is a concrete decorator adding sporty features to a dress
class SportyDress extends DressDecorator {
	public SportyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Sporty Dress Features");
	}
}

// FancyDress class is a concrete decorator adding fancy features to a dress
class FancyDress extends DressDecorator {
	public FancyDress(Dress c) {
		super(c);
	}

	@Override
	public void assemble() {
		super.assemble();
		System.out.println("Adding Fancy Dress Features");
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		// Create various dress combinations using decorators

		// Sporty Dress on top of Basic Dress
		Dress sportyDress = new SportyDress(new BasicDress());
		sportyDress.assemble();
		System.out.println();

		// Fancy Dress on top of Basic Dress
		Dress fancyDress = new FancyDress(new BasicDress());
		fancyDress.assemble();
		System.out.println();

		// Casual Dress on top of Basic Dress
		Dress casualDress = new CasualDress(new BasicDress());
		casualDress.assemble();
		System.out.println();

		// Sporty Dress on top of Fancy Dress on top of Basic Dress
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
		System.out.println();

		// Casual Dress on top of Fancy Dress on top of Basic Dress
		Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
		casualFancyDress.assemble();
	}
}
