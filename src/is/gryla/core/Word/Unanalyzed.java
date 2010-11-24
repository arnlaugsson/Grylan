package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Unanalyzed {
    private String word;
    private WordClass type;

    private Unanalyzed(String word) {
        this.word = word;
        this.type = WordClass.UNANALYZED;
    }

    public static Unanalyzed resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        return new Unanalyzed(word);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
