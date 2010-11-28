package is.gryla.core.Word.TagAttributes;

public enum Degree {
    /* Adjectives */
    POSITIVE,       // Frumstig
    COMPARATIVE,    // Miðstig
    SUPERLATIVE,    // Efsta stig
    NONE;

    public static Degree parse(char c) {
        switch (c) {
            case 'f':
                return POSITIVE;
            case 'm':
                return COMPARATIVE;
            case 'e':
                return SUPERLATIVE;
            default:
                throw new RuntimeException("No degree available for '" + c + "'");
        }
    }
}
