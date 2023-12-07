package task3;

import java.util.regex.*;

public class UrlValidator {
    public static void main(String[] args) {
        String[] urls = {
                "http://www.onet.pl",
                "https://mail.google.com",
                "http://wiadmosci.onet.pl",
                "http://onet.pl"
        };

        String urlRegex = "^(http|https)://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:/[a-zA-Z0-9._%+-]+)*$";
        Pattern pattern = Pattern.compile(urlRegex);

        for (String url : urls) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                System.out.println(url + " - Poprawny URL.");
            } else {
                System.out.println(url + " - Niepoprawny URL.");
            }
        }
    }
}