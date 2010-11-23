package is.gryla.core.Word.TagAttributes;

public enum Article {
    SUFFIXED,   // Viðbættur greinir
    NO_ARTICLE;          // Ekki viðbættur greinir

    public static Article resolve(char c) {
        switch (c) {
            case 'g':
                return SUFFIXED;
            case '_':
                return NO_ARTICLE;
            default:
                throw new RuntimeException("No case available for '" + c + "'");
        }
    }
}
