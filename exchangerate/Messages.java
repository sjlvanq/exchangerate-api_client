package exchangerate;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.PropertyResourceBundle;
import java.util.MissingResourceException;

public class Messages {
	//private static Locale locale = Locale.of("pt","BR");
	private static Locale locale = Locale.getDefault();
	private static ResourceBundle bundle= PropertyResourceBundle.getBundle("exchangerate/i18n/lang", locale);

    public static void setLocale(Locale newLocale) {
        locale = newLocale;
        bundle = PropertyResourceBundle.getBundle("i18n.lang", locale);
    }
    
    public static void setLocale(String language, String country) {
        setLocale(Locale.of(language, country));
    }
    
    public static String get(String key) {
    	try {
    		return bundle.getString(key);
    	} catch (MissingResourceException e) {
    		return "#i18n error#";
    	}
    }

}

