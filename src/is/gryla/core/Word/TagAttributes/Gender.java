package is.gryla.core.Word.TagAttributes;

public enum Gender {
    MALE,       // KK
    FEMALE,     // KVK
    NEUTER;     // HVK

    public static Gender resolve(char c) {
        switch (c) {
            case 'k':
                return MALE;
            case 'v':
                return FEMALE;
            case 'h':
                return NEUTER;
            default:
                throw new RuntimeException("No gender available for '" + c + "'");
        }
    }
}
