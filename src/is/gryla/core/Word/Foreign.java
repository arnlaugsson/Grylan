package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Foreign implements InterfaceWord {
    private String word;
    private WordClass type;

    private Foreign(String word){
        this.word = word;
        this.type = WordClass.FOREIGN;
    }

    public static Foreign resolve(String word){
        return new Foreign(word);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
