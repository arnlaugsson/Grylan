package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Unanalyzed  extends AbstractWord {
    private String word;
    private WordClass type;

    private Unanalyzed(String word,int count) {
        this.word = word;
        this.type = WordClass.UNANALYZED;
        this.countNumber = count;
    }

    public static Unanalyzed resolve(String word,int count){
        return new Unanalyzed(word,count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
