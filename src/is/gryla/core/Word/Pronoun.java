package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Pronoun  extends AbstractWord {
    private String word;
    private WordClass type;
    private Subcategory subcategory;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;

    private Pronoun(String word, Subcategory subcategory, GenderPerson genderPerson, Number number, Case ncase, int count) {
        this.word = word;
        this.type = WordClass.PRONOUN;
        this.subcategory = subcategory;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
        this.countNumber = count;
    }

    public static Pronoun parse(String word, String tag,int count) {
        Subcategory subcategory = Subcategory.parse(tag.charAt(1));
        GenderPerson genderPerson = GenderPerson.parse(tag.charAt(2));
        Number number = Number.parse(tag.charAt(3));
        Case ncase = Case.parse(tag.charAt(4));

        return new Pronoun(word, subcategory, genderPerson, number, ncase,count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public Subcategory getSubcategory() {
        return subcategory;
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
