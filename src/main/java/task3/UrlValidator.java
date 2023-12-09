package task3;

import java.util.regex.*;


public class UrlValidator {
    private String urlRegex;

    public UrlValidator() {
        this.urlRegex = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9._%+-]+)*$";
    }

    public boolean validateURL(String url) {
        Pattern pattern = Pattern.compile(urlRegex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}