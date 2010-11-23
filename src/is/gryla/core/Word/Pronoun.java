package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Pronoun {
    private String word;
    private WordClass type;
    private Subcategory subcategory;
    private Gender gender;
    private Number number;
    private Case ncase;

    public Pronoun(String word, Subcategory subcategory, Gender gender, Number number, Case ncase) {
        this.word = word;
        this.type = WordClass.PRONOUN;
        this.subcategory = subcategory;
        this.gender = gender;
        this.number = number;
        this.ncase = ncase;
    }

    public static Pronoun resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        Subcategory subcategory = Subcategory.resolve(sep[1].charAt(1));
        Gender gender = Gender.resolve(sep[1].charAt(2));
        Number number = Number.resolve(sep[1].charAt(3));
        Case ncase = Case.resolve(sep[1].charAt(4));

        return new Pronoun(word, subcategory, gender, number, ncase);
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

    public Gender getGender() {
        return gender;
    }

    public Number getNumber() {
        return number;
    }

    public Case getCase() {
        return ncase;
    }
}
