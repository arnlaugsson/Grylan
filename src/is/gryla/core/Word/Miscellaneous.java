package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Miscellaneous extends AbstractWord {
    private String word;
    private WordClass type;

    private Miscellaneous(String word, int count){
        this.word = word;
        this.type = WordClass.FOREIGN;
        this.countNumber = count;
    }

    public static Miscellaneous resolve(String word, int count){
        return new Miscellaneous(word,count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
