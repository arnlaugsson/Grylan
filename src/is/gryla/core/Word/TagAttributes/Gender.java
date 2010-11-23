package is.gryla.core.Word.TagAttributes;

public enum Gender {
    /* Nouns, adjectives and pronouns */
    MALE,       // KK
    FEMALE,     // KVK
    NEUTER,     // HVK
    FIRST,      // 1st for pronouns
    SECOND,     // 2nd for pronouns
    UNSPECIFIED;

    public static Gender resolve(char c) {
        switch (c) {
            case 'k':
                return MALE;
            case 'v':
                return FEMALE;
            case 'h':
                return NEUTER;
            case '1':
                return FIRST;
            case '2':
                return SECOND;
            case 'x':
                return UNSPECIFIED;
            default:
                throw new RuntimeException("No gender available for '" + c + "'");
        }
    }
}
