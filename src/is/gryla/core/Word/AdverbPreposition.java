package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.AdverbCategory;
import is.gryla.core.Word.TagAttributes.Degree;
import is.gryla.core.Word.TagAttributes.WordClass;

public class AdverbPreposition implements InterfaceWord {
    private String word;
    private WordClass type;
    private AdverbCategory category;
    private Degree degree;

    private AdverbPreposition(String word, AdverbCategory category, Degree degree) {
        this.word = word;
        this.type = WordClass.ADVERB;
        this.category = category;
        this.degree = degree;
    }

    public static AdverbPreposition resolve(String word, String tag){
        AdverbCategory category = AdverbCategory.resolve(tag.charAt(1));
        Degree degree = Degree.NONE;

        if (tag.length() > 2){
            degree = Degree.resolve(tag.charAt(2));
        }

        return new AdverbPreposition(word,category,degree);
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
