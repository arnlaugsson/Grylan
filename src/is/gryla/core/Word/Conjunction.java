package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.ConjunctionCategory;
import is.gryla.core.Word.TagAttributes.WordClass;

public class Conjunction {
    private String word;
    private WordClass type;
    private ConjunctionCategory category;

    private Conjunction(String word, ConjunctionCategory category) {
        this.word = word;
        this.type = WordClass.CONJUNCTION;
        this.category = category;
    }

    public static Conjunction resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        ConjunctionCategory category = ConjunctionCategory.resolve(sep[1].charAt(1));

        return new Conjunction(word, category);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public ConjunctionCategory getCategory() {
        return category;
    }
}
