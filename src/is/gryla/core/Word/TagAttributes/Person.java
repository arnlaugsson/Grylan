package is.gryla.core.Word.TagAttributes;

public enum Person {
    /* Verbs */
    FIRST,
    SECOND,
    THIRD;

    public static Person resolve(char c) {
        switch (c) {
            case '1':
                return FIRST;
            case '2':
                return SECOND;
            case '3':
                return THIRD;

            default:
                throw new RuntimeException("No Person available for pronoun '" + c + "'");
        }
    }
}
