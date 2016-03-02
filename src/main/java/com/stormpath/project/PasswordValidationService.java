
package com.stormpath.project;

import java.util.regex.Pattern;

public class PasswordValidationService {


    public boolean checkPassword(String target) {

        boolean caseCheck;
        boolean lengthCheck;
        boolean substringCheck;

        if (target == null)
            return false;

        caseCheck = caseUtil(target);
        lengthCheck = caseCheck ? rangeUtil(target) : false;
        substringCheck = (caseCheck && lengthCheck) ? patternUtil(target) : false;

        return caseCheck && lengthCheck && substringCheck;
    }

    private boolean regexUtil(String regex, String s) {
        boolean found = Pattern.compile(regex).matcher(s).find();
        return found;
    }

    private boolean caseUtil(String str) {
        boolean lowercase = regexUtil("[a-z]", str);
        boolean numeric = regexUtil("[0-9]", str);
        boolean uppercase = regexUtil("[A-Z]", str);

        if ((lowercase && numeric) && !uppercase) {
            return true;
        }

        return false;
    }

    private boolean rangeUtil(String str) {
        boolean acceptableRange = str.length() >= 5 && str.length() <= 12;

        return acceptableRange;
    }

    private boolean patternUtil(String str) {
        boolean patternExists = regexUtil("(\\w{2,})\\1", str);

        return !patternExists;
    }

}
