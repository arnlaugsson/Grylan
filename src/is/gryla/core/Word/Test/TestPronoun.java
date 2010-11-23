package is.gryla.core.Word.Test;

import is.gryla.core.Word.Pronoun;

public class TestPronoun {
    public static void main(String[] args) {
        String testString1 = "hann fpken";
        String testString2 = "henni fpveþ";
        String testString3 = "þeirra fpkfe";

        Pronoun thisPronoun = Pronoun.resolve(testString1);
        Pronoun thatPronoun = Pronoun.resolve(testString2);
        Pronoun whatPronoun = Pronoun.resolve(testString3);

        System.out.println(thisPronoun.getWord() + "\t\t" +
                thisPronoun.getType() + "\t" +
                thisPronoun.getSubcategory() + "\t" +
                thisPronoun.getGender() + "\t" +
                thisPronoun.getNumber() + "\t" +
                thisPronoun.getCase());

        System.out.println(thatPronoun.getWord() + "\t\t" +
                thatPronoun.getType() + "\t" +
                thatPronoun.getSubcategory() + "\t" +
                thatPronoun.getGender() + "\t" +
                thatPronoun.getNumber() + "\t" +
                thatPronoun.getCase());

        System.out.println(whatPronoun.getWord() + "\t\t" +
                whatPronoun.getType() + "\t" +
                whatPronoun.getSubcategory() + "\t" +
                whatPronoun.getGender() + "\t" +
                whatPronoun.getNumber() + "\t" +
                whatPronoun.getCase());
    }
}
