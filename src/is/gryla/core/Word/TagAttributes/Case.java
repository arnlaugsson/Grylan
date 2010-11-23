package is.gryla.core.Word.TagAttributes;

public enum Case {
    NOMINATIVE, //  n - nefnifall
    ACCUSATIVE, //  o - þolfall
    DATIVE,     //  þ - þágufall
    GENATIVE;   //  e - eignafall

    public static Case resolve(char c) {
        switch (c) {
            case 'n':
                return NOMINATIVE;
            case 'o':
                return ACCUSATIVE;
            case 'þ':
                return DATIVE;
            case 'e':
                return GENATIVE;
            default:
                throw new RuntimeException("No case available for '" + c + "'");
        }
    }
}
