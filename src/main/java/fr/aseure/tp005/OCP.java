package fr.aseure.tp005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OCP {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "foo@intech.com",
                "bar@intech.com",
                "baz@gmail.com",
                "invalid@"
        );

        List<EmailFilter> filters = Arrays.asList(
                new ValidDomainEmailFilter(),
                new ValidIntechEmailFilter()
        );

        List<String> validEmails = filterInvalidEmails(emails, filters);

        for (String e : validEmails) {
            System.out.println(e);
        }
    }

    static List<String> filterInvalidEmails(List<String> emails, List<EmailFilter> filters) {
        List<String> validEmails = new ArrayList<>();

        for (String e : emails) {
            boolean isValid = true;
            for (EmailFilter f : filters) {
                isValid &= f.filter(e);
            }
            if (isValid) {
                validEmails.add(e);
            }
        }

        return validEmails;
    }
}