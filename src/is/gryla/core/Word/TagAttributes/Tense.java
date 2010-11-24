package is.gryla.core.Word.TagAttributes;

public enum Tense {
    /* Verbs */
    PRESENT,
    PAST,
    NO_TENSE;

    public static Tense resolve(char c) {
        switch (c) {
            case 'n':
                return PRESENT;
            case 'þ':
                return PAST;
            default:
                throw new RuntimeException("No Tense available for pronoun '" + c + "'");
        }
    }
}
