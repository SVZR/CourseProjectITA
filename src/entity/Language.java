package entity;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Language {

    public static Map<String, Locale> LANG = new HashMap<>();

    static {
        LANG.put("eng", new Locale("en", "US"));
        LANG.put("rus", new Locale("ru", "RU"));
    }

    public static Locale getLocale(String lang) {
        return LANG.get(lang);
    }
}