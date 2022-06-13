package IO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSDT {
    private final String SDT_REGEX = "^0[0-9]{9}$";

    public ValidateSDT() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(SDT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
