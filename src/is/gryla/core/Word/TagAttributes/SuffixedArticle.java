package is.gryla.core.Word.TagAttributes;

public enum SuffixedArticle {
    /* Nouns */
    SUFFIXED,       // Viðbættur greinir
    NO_ARTICLE;     // Ekki viðbættur greinir

    public static SuffixedArticle parse(char c) {
        switch (c) {
            case 'g':
                return SUFFIXED;
            case '-':
                return NO_ARTICLE;
            default:
                throw new RuntimeException("No case available for '" + c + "'");
        }
    }
}
