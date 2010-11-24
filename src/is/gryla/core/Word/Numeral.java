package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Numeral {
    private String word;
    private WordClass type;
    private NumeralCategory category;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;

    private Numeral(String word, NumeralCategory category, GenderPerson genderPerson, Number number, Case ncase) {
        this.word = word;
        this.type = WordClass.NUMERAL;
        this.category = category;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
    }

    public static Numeral resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        NumeralCategory category = NumeralCategory.resolve(sep[1].charAt(1));
        GenderPerson genderPerson = GenderPerson.resolve(sep[1].charAt(2));
        Number number = Number.resolve(sep[1].charAt(3));
        Case ncase = Case.resolve(sep[1].charAt(4));

        return new Numeral(word,category, genderPerson,number,ncase);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public NumeralCategory getCategory() {
        return category;
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
