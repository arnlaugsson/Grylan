package is.gryla.core.Word.TagAttributes;

public enum ACategory {
    /* Adverb and preposition */
    DOES_NOT,       // Does not govern case
    EXCLAMATION,
    ACCUSATIVE,     // Governs accusative
    DATIVE,         // Governs dative
    GENITIVE;       // Governs genitive

    public static ACategory resolve(char c) {
        switch (c) {
            case 'a':
                return DOES_NOT;
            case 'u':
                return EXCLAMATION;
            case 'o':
                return ACCUSATIVE;
            case 'þ':
                return DATIVE;
            case 'e':
                return GENITIVE;
            default:
                throw new RuntimeException("No Category available for '" + c + "'");
        }
    }
}
