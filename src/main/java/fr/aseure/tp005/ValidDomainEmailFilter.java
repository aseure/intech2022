package fr.aseure.tp005;

import java.util.regex.Pattern;

class ValidDomainEmailFilter implements EmailFilter {
    private final Pattern pattern;

    public ValidDomainEmailFilter() {
        this.pattern = Pattern.compile("@[a-zA-Z0-9.]+");
    }

    @Override
    public boolean filter(String email) {
        return pattern.matcher(email).find();
    }
}