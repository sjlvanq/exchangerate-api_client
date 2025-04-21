package exchangerate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Config {
	public static Properties props;
	
	public static void init() {
		Properties defaultProps = new Properties();
		defaultProps.setProperty("api.host","exchangerate-api.com");
		defaultProps.setProperty("api.key","000000000000000000000000");
		defaultProps.setProperty("api.version","/v6/");
		defaultProps.setProperty("con.timeout","3000");
		defaultProps.setProperty("api.ssl","true");
		props = new Properties(defaultProps);
        
		//String FileLocation = "";
		try {
			FileInputStream propsFileStream = new FileInputStream("exchangerate/config.xml");
            props.loadFromXML(propsFileStream);
        } catch (InvalidPropertiesFormatException e) {
        	System.err.println(Messages.get("config.corrupt"));
        } catch (IOException e) {
        	System.err.println(Messages.get("config.load-failed"));
		}
		
		// No admiten especificación en config.xml
		props.setProperty("base.author", "\nSjlvanq, Ⓒ 2025");
	}
	
	public static String prop(String key) {
		return props.getProperty(key);
	}
}
