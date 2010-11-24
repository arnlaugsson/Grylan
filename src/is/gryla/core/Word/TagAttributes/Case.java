package is.gryla.core.Word.TagAttributes;

public enum Case {
    /* Nouns and adjectives */
    NOMINATIVE, //  n - nefnifall
    ACCUSATIVE, //  o - þolfall
    DATIVE,     //  þ - þágufall
    GENATIVE,   //  e - eignafall
    NO_CASE;    // For verbs except in past participle

    public static Case resolve(char c) {
        switch (c) {
            case 'n':
                return NOMINATIVE;
            case 'o':
                return ACCUSATIVE;
            case 'þ':
                return DATIVE;
            case 'e':
                return GENATIVE;
            case '_':
                return NO_CASE;
            default:
                throw new RuntimeException("No case available for '" + c + "'");
        }
    }
}
