package fankick.utilities;

public interface FileConstants extends ObjectConstants {

	String HOME = System.getProperty("test.home", "./");

	String RESOURCES_HOME = HOME + "resources/";

	String DRIVERS_HOME = RESOURCES_HOME + "drivers/";

	String CHROMEDRIVER = DRIVERS_HOME + "chromedriver.exe";

	String FIREFOXDRIVER = DRIVERS_HOME + "geckodriver.exe";

	String SERVER_PROPERTIES = RESOURCES_HOME + "server.properties";
	
	String OBJECT_PROPERTIES = RESOURCES_HOME + "object.properties";

}
