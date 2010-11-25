package is.gryla.core.Word.TagAttributes;

public enum GenderPerson {
    /* This enum is for both gender and person */
    /* Nouns, adjectives, pronouns and verbs*/
    MALE,       // KK
    FEMALE,     // KVK
    NEUTER,     // HVK
    FIRST,      // 1st for pronouns
    SECOND,     // 2nd for pronouns
    THIRD,      // 3rd for verbs (except past participle)
    UNSPECIFIED,
    NONE;

    public static GenderPerson resolve(char c) {
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
            case '3':
                return THIRD;
            case 'x':
                return UNSPECIFIED;
            default:
                throw new RuntimeException("No gender available for '" + c + "'");
        }
    }
}
