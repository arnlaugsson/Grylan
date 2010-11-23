package is.gryla.core.Word.TagAttributes;

public enum Voice {
    /* Verbs */
    ACTIVE,
    MIDDLE;

    public static Voice resolve(char c) {
        switch (c) {
            case 'g':
                return ACTIVE;
            case 'm':
                return MIDDLE;
            default:
                throw new RuntimeException("No Voice available for '" + c + "'");
        }
    }
}
