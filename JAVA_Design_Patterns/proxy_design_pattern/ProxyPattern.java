package proxy_design_pattern;

// DatabaseExecuter interface defines the executeDatabase method for database execution
interface DatabaseExecuter {
	void executeDatabase(String query) throws Exception;
}

// DatabaseExecuterImpl class implements the DatabaseExecuter interface to perform actual database execution
class DatabaseExecuterImpl implements DatabaseExecuter {
	@Override
	public void executeDatabase(String query) throws Exception {
		System.out.println("Going to execute Query: " + query);
	}
}

// DatabaseExecuterProxy class is a proxy that controls access to the actual DatabaseExecuterImpl
class DatabaseExecuterProxy implements DatabaseExecuter {
	boolean ifAdmin;
	DatabaseExecuterImpl dbExecuter;

	public DatabaseExecuterProxy(String name, String passwd) {
		if (name.equals("Admin") && passwd.equals("Admin@123")) {
			ifAdmin = true;
		}
		dbExecuter = new DatabaseExecuterImpl();
	}

	@Override
	public void executeDatabase(String query) throws Exception {
		if (ifAdmin) {
			dbExecuter.executeDatabase(query);
		} else {
			if (query.equals("DELETE")) {
				throw new Exception("DELETE not allowed for non-admin user");
			} else {
				dbExecuter.executeDatabase(query);
			}
		}
	}
}

public class ProxyPattern {
	public static void main(String[] args) throws Exception {
		// Create a non-admin proxy with incorrect query
		DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuter.executeDatabase("DELEE");

		// Create a non-admin proxy with DELETE query
		DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		nonAdminExecuterDELETE.executeDatabase("DELETE");

		// Create an admin proxy with DELETE query
		DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
		adminExecuter.executeDatabase("DELETE");
	}
}
