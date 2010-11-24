package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.AdverbCategory;
import is.gryla.core.Word.TagAttributes.Degree;
import is.gryla.core.Word.TagAttributes.WordClass;

public class AdverbPreposition {
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

    public static AdverbPreposition resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        AdverbCategory category = AdverbCategory.resolve(sep[1].charAt(1));
        Degree degree = Degree.resolve(sep[1].charAt(2));

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
