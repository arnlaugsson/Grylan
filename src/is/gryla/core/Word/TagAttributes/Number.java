package is.gryla.core.Word.TagAttributes;

public enum Number {
    SINGULAR,   // eintala, e
    PLURAL;     // fleirtala, f

    public static Number resolve(char c) {
        switch (c) {
            case 'e':
                return SINGULAR;
            case 'f':
                return PLURAL;
            default:
                throw new RuntimeException("No number available for '" + c + "'");
        }
    }
}
