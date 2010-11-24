package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Unanalyzed implements InterfaceWord {
    private String word;
    private WordClass type;

    private Unanalyzed(String word) {
        this.word = word;
        this.type = WordClass.UNANALYZED;
    }

    public static Unanalyzed resolve(String word){
        return new Unanalyzed(word);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
