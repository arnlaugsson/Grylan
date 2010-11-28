package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.Case;
import is.gryla.core.Word.TagAttributes.GenderPerson;
import is.gryla.core.Word.TagAttributes.Number;
import is.gryla.core.Word.TagAttributes.WordClass;


public class Article extends AbstractWord {
    private String word;
    private WordClass type;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;

    private Article(String word, GenderPerson genderPerson, Number number, Case ncase, int count) {
        this.word = word;
        this.type = WordClass.ARTICLE;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase ;
        this.countNumber = count;
    }

    public static Article parse(String word, String tag, int count) {
        GenderPerson genderPerson = GenderPerson.parse(tag.charAt(1));
        Number number = Number.parse(tag.charAt(2));
        Case ncase = Case.parse(tag.charAt(3));

        return new Article(word, genderPerson, number, ncase, count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public GenderPerson getGenderPerson() {
        return genderPerson;
    }

    public Number getNumber() {
        return number;
    }

    public Case getCase() {
        return ncase;
    }
}
