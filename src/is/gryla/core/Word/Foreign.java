package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Foreign extends AbstractWord {
    private String word;
    private WordClass type;

    private Foreign(String word, int count){
        this.word = word;
        this.type = WordClass.FOREIGN;
        this.countNumber = count;
    }

    public static Foreign parse(String word, int count){
        return new Foreign(word,count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
