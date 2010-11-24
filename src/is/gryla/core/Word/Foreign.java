package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.WordClass;

public class Foreign {
    private String word;
    private WordClass type;

    private Foreign(String word){
        this.word = word;
        this.type = WordClass.FOREIGN;
    }

    public static Foreign resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        return new Foreign(word);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }
}
