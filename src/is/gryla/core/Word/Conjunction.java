package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.ConjunctionCategory;
import is.gryla.core.Word.TagAttributes.WordClass;

public class Conjunction implements InterfaceWord {
    private String word;
    private WordClass type;
    private ConjunctionCategory category;

    private Conjunction(String word, ConjunctionCategory category) {
        this.word = word;
        this.type = WordClass.CONJUNCTION;
        this.category = category;
    }

    public static Conjunction resolve(String word, String tag){
        ConjunctionCategory category = ConjunctionCategory.resolve(tag.charAt(1));

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
