package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Adjective extends AbstractWord {
    private String word;
    private WordClass type;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;
    private Declension declension;
    private Degree degree;

    private Adjective(String word, GenderPerson genderPerson, Number number, Case ncase, Declension declension, Degree degree, int count) {
        this.word = word;
        this.type = WordClass.ADJECTIVE;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
        this.declension = declension;
        this.degree = degree;
        this.countNumber = count;
    }

    public static Adjective resolve(String word, String tag, int count) {
        GenderPerson genderPerson = GenderPerson.resolve(tag.charAt(1));
        Number number = Number.resolve(tag.charAt(2));
        Case ncase = Case.resolve(tag.charAt(3));
        Declension declension = Declension.resolve(tag.charAt(4));

        Degree degree = Degree.NONE;

        if (tag.length() == 6){
            degree = Degree.resolve(tag.charAt(5));
        }

        return new Adjective(word, genderPerson, number, ncase, declension, degree, count);
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

    public Declension getDeclension() {
        return declension;
    }

    public Degree getDegree() {
        return degree;
    }
}
