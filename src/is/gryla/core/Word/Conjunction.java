package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.ConjunctionCategory;
import is.gryla.core.Word.TagAttributes.WordClass;

public class Conjunction  extends AbstractWord {
    private String word;
    private WordClass type;
    private ConjunctionCategory category;

    private Conjunction(String word, ConjunctionCategory category, int count) {
        this.word = word;
        this.type = WordClass.CONJUNCTION;
        this.category = category;
        this.countNumber = count;
    }

    public static Conjunction resolve(String word, String tag, int count){
        try{
            ConjunctionCategory category = ConjunctionCategory.NONE;
            if (tag.charAt(1) == 'n' || tag.charAt(1) == 't'){
                category = ConjunctionCategory.resolve(tag.charAt(1));
            }
            
            return new Conjunction(word, category,count);
        }
        catch (StringIndexOutOfBoundsException e){
            return new Conjunction(word,ConjunctionCategory.NONE, count);
        }
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
