package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.AdverbCategory;
import is.gryla.core.Word.TagAttributes.Degree;
import is.gryla.core.Word.TagAttributes.WordClass;

public class AdverbPreposition extends AbstractWord {
    private String word;
    private WordClass type;
    private AdverbCategory category;
    private Degree degree;

    private AdverbPreposition(String word, AdverbCategory category, Degree degree, int count) {
        this.word = word;
        this.type = WordClass.ADVERB;
        this.category = category;
        this.degree = degree;
        this.countNumber = count;
    }

    public static AdverbPreposition resolve(String word, String tag, int count){
        AdverbCategory category = AdverbCategory.resolve(tag.charAt(1));
        Degree degree = Degree.NONE;

        if (tag.length() > 2){
            degree = Degree.resolve(tag.charAt(2));
        }

        return new AdverbPreposition(word,category,degree,count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public AdverbCategory getCategory() {
        return category;
    }

    public Degree getDegree() {
        return degree;
    }
}
