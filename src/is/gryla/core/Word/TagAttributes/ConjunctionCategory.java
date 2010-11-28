package is.gryla.core.Word.TagAttributes;

public enum ConjunctionCategory {
    /* Conjunctions */
    INFINITIVE,     // Sign of infinitive
    RELATIVIZER,
    NONE;

    public static ConjunctionCategory parse(char c) {
        switch (c) {
            case 'n':
                return INFINITIVE;
            case 't':
                return RELATIVIZER;
            default:
                throw new RuntimeException("No Category available for '" + c + "'");
        }
    }
}
