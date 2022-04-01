package fr.aseure.tp005;

interface EmailFilter {
    // The filter method returns true if the email should be kept and false if
    // it should be discarded, i.e. filtered out.
    boolean filter(String email);
}