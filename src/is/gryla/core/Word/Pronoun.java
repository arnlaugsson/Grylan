package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Pronoun implements InterfaceWord {
    private String word;
    private WordClass type;
    private Subcategory subcategory;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;

    private Pronoun(String word, Subcategory subcategory, GenderPerson genderPerson, Number number, Case ncase) {
        this.word = word;
        this.type = WordClass.PRONOUN;
        this.subcategory = subcategory;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
    }

    public static Pronoun resolve(String word, String tag) {
        Subcategory subcategory = Subcategory.resolve(tag.charAt(1));
        GenderPerson genderPerson = GenderPerson.resolve(tag.charAt(2));
        Number number = Number.resolve(tag.charAt(3));
        Case ncase = Case.resolve(tag.charAt(4));

        return new Pronoun(word, subcategory, genderPerson, number, ncase);
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
