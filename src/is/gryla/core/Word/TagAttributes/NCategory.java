package is.gryla.core.Word.TagAttributes;

public enum NCategory {
    /* Numeral */
    CARDINAL,
    NUMERIC,    // Numeric constant
    PERCENTAGE;

    public static NCategory resolve(char c) {
        switch (c) {
            case 'f':
                return CARDINAL;
            case 'o':
                return NUMERIC;
            case 'p':
                return PERCENTAGE;
            default:
                throw new RuntimeException("No number available for '" + c + "'");
        }
    }
}
