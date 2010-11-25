package is.gryla.core.Word.TagAttributes;

public enum ConjunctionCategory {
    /* Conjunctions */
    INFINITIVE,     // Sign of infinitive
    RELATIVIZER,
    NONE;

    public static ConjunctionCategory resolve(char c) {
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
