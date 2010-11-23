package is.gryla.core.Word;
import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Adjective {
    private String word;
    private WordClass type;
    private Gender gender;
    private Number number;
    private Case ncase;
    private Declension declension;
    private Degree degree;

    private Adjective(String word, Gender gender, Number number, Case ncase, Declension declension, Degree degree) {
        this.word = word;
        this.type = WordClass.ADJECTIVE;
        this.gender = gender;
        this.number = number;
        this.ncase = ncase;
        this.declension = declension;
        this.degree = degree;
    }

    public static Adjective resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];
        
        Gender gender = Gender.resolve(sep[1].charAt(1));
        Number number = Number.resolve(sep[1].charAt(2));
        Case ncase = Case.resolve(sep[1].charAt(3));
        Declension declension = Declension.resolve(sep[1].charAt(4));
        Degree degree = Degree.resolve(sep[1].charAt(5));

        return new Adjective(word, gender, number, ncase, declension, degree);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
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

    public Declension getDeclension() {
        return declension;
    }

    public Degree getDegree() {
        return degree;
    }
}
