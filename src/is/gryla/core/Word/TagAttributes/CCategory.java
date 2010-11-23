package is.gryla.core.Word.TagAttributes;

public enum CCategory {
    /* Conjunctions */
    INFINITIVE,     // Sign of infinitive
    RELATIVIZER;

    public static CCategory resolve(char c) {
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
