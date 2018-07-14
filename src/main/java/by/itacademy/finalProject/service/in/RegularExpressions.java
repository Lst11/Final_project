package by.itacademy.finalProject.service.in;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public double getNumber(String numberInString) {
        Pattern pattern = Pattern.compile("^([0-9])*[.,]");
        StringBuffer buffer = new StringBuffer(numberInString);
        Matcher matcher = pattern.matcher(numberInString);
        while (matcher.find()) {
            StringBuffer match = new StringBuffer(matcher.group());
            int length = match.length();
            String firstPart = match.substring(0, length - 1);
            String secondPart = buffer.substring(length);
            StringBuffer result = new StringBuffer(firstPart + "." + secondPart);
            String resultStr = result.toString();
            return Double.parseDouble(resultStr);
        }
        return Double.parseDouble(numberInString);
    }


}
