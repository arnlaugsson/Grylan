package is.gryla.core.Word.TagAttributes;

public enum Proper {
    /* Nouns */
    PERSON,     // Persóna
    PLACE,      // Örnefni
    OTHER,      // Annað
    NOT_PROPER; // Ekki Proper

    public static Proper resolve(char c) {
        switch (c) {
            case 'm':
                return PERSON;
            case 'ö':
                return PLACE;
            case 's':
                return OTHER;
            default:
                throw new RuntimeException("No Proper-noun available for '" + c + "'");
        }
    }
}
