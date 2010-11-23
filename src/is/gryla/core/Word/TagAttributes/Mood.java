package is.gryla.core.Word.TagAttributes;

public enum Mood {
    /* Verbs */
    INFINITIVE,
    IMPERATIVE,
    INDICATIVE,
    SUBJUNCTIVE,
    SUPINE,
    PERSENT,    // Present participle
    PAST;       // Past particle

    public static Mood resolve(char c) {
        switch (c) {
            case 'n':
                return INFINITIVE;
            case 'b':
                return IMPERATIVE;
            case 'f':
                return INDICATIVE;
            case 'v':
                return SUBJUNCTIVE;
            case 's':
                return SUPINE;
            case 'l':
                return PERSENT;
            case 'þ':
                return PAST;
            default:
                throw new RuntimeException("No Mood available for '" + c + "'");
        }
    }
}
