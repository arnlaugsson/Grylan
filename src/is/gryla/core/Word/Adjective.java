package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Adjective {
    private String word;
    private WordClass type;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;
    private Declension declension;
    private Degree degree;

    private Adjective(String word, GenderPerson genderPerson, Number number, Case ncase, Declension declension, Degree degree) {
        this.word = word;
        this.type = WordClass.ADJECTIVE;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
        this.declension = declension;
        this.degree = degree;
    }

    public static Adjective resolve(String in) {
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        GenderPerson genderPerson = GenderPerson.resolve(sep[1].charAt(1));
        Number number = Number.resolve(sep[1].charAt(2));
        Case ncase = Case.resolve(sep[1].charAt(3));
        Declension declension = Declension.resolve(sep[1].charAt(4));
        Degree degree = Degree.resolve(sep[1].charAt(5));

        return new Adjective(word, genderPerson, number, ncase, declension, degree);
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

    public Declension getDeclension() {
        return declension;
    }

    public Degree getDegree() {
        return degree;
    }
}
