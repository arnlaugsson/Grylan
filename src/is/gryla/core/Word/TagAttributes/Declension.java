package is.gryla.core.Word.TagAttributes;

public enum Declension {
    /* Adjectives */
    STRONG,
    WEAK;

    public static Declension parse(char c) {
        switch (c) {
            case 'v':
                return STRONG;
            case 's':
                return WEAK;
            default:
                throw new RuntimeException("No declension available for '" + c + "'");
        }
    }
}
