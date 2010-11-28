package is.gryla.core.Word.TagAttributes;

public enum WordClass {
    /*
    WordClass helps determine what kind of a wordclass the parser should generate.
    With the helper function parse() you can find out what type of a class you should create.
     */
    NOUN,
    ADJECTIVE,
    PRONOUN,
    ARTICLE,
    NUMERAL,
    VERB,
    ADVERB,
    CONJUNCTION,
    FOREIGN,
    UNANALYZED,
    MISCELLENOUS;

    public static WordClass parse(char c) {
        switch (c) {
            case 'n':
                return NOUN;
            case 'l':
                return ADJECTIVE;
            case 'f':
                return PRONOUN;
            case 'g':
                return ARTICLE;
            case 't':
                return NUMERAL;
            case 's':
                return VERB;
            case 'a':
                return ADVERB;
            case 'c':
                return CONJUNCTION;
            case 'e':
                return FOREIGN;
            case 'x':
                return UNANALYZED;
            default:
                throw new RuntimeException("No word class available for '" + c + "'");
        }
    }
}
