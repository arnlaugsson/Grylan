package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.Case;
import is.gryla.core.Word.TagAttributes.GenderPerson;
import is.gryla.core.Word.TagAttributes.Number;
import is.gryla.core.Word.TagAttributes.WordClass;


public class Article implements InterfaceWord {
    private String word;
    private WordClass type;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;

    private Article(String word, GenderPerson genderPerson, Number number, Case ncase) {
        this.word = word;
        this.type = WordClass.ARTICLE;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
    }

    public static Article resolve(String word, String tag) {
        GenderPerson genderPerson = GenderPerson.resolve(tag.charAt(1));
        Number number = Number.resolve(tag.charAt(2));
        Case ncase = Case.resolve(tag.charAt(3));

        return new Article(word, genderPerson, number, ncase);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public GenderPerson getGender() {
        return genderPerson;
    }

    public Number getNumber() {
        return number;
    }

    public Case getCase() {
        return ncase;
    }
}
