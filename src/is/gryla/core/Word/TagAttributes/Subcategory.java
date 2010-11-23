package is.gryla.core.Word.TagAttributes;

public enum Subcategory {
    /* Pronoun */
    DEMONSTRATIVE,
    REFLEXIVE,
    POSSESSIVE,
    INDEFINITE,
    PERSONAL,
    INTERROGATIVE,
    RELATIVE;

    public static Subcategory resolve(char c) {
        switch (c) {
            case 'a':
                return DEMONSTRATIVE;
            case 'b':
                return REFLEXIVE;
            case 'e':
                return POSSESSIVE;
            case 'o':
                return INDEFINITE;
            case 'p':
                return PERSONAL;
            case 's':
                return INTERROGATIVE;
            case 't':
                return RELATIVE;
            default:
                throw new RuntimeException("No Subcategory available for pronoun '" + c + "'");
        }
    }
}
