package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	public static InputStream input;
	public static Properties prop;

	public static void getAttributes() {
		prop = new Properties();
		input = null;

		try {

			input = new FileInputStream("C:\\Users\\ciprian.faladau\\eclipse-workspace\\testNG\\Resource\\Configuation.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			Constants.USERNAME = prop.getProperty("userName");
			Constants.PASS = prop.getProperty("pass");
			Constants.INVALID_PASS = prop.getProperty("invalidPass");
			Constants.URL = prop.getProperty("url");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
	}
}
