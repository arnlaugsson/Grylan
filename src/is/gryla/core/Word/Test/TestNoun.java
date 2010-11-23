package is.gryla.core.Word.Test;

import is.gryla.core.Word.Noun;

public class TestNoun {
    public static void main(String[] args) {
        String testString1 = "borðið nheng";
        String testString2 = "borð nhen";
        String testString3 = "Hamarinn nkeogö";

        Noun thisNoun = Noun.resolve(testString1);
        Noun thatNoun = Noun.resolve(testString2);
        Noun whatNoun = Noun.resolve(testString3);

        System.out.println(thisNoun.getWord() + "\t\t" +
                thisNoun.getType() + "\t" +
                thisNoun.getGender() + "\t" +
                thisNoun.getNumber() + "\t" +
                thisNoun.getCase() + "\t" +
                thisNoun.getArticle() + "\t" +
                thisNoun.getProper());

        System.out.println(thatNoun.getWord() + "\t\t" +
                thatNoun.getType() + "\t" +
                thatNoun.getGender() + "\t" +
                thatNoun.getNumber() + "\t" +
                thatNoun.getCase() + "\t" +
                thatNoun.getArticle() + "\t" +
                thatNoun.getProper());

        System.out.println(whatNoun.getWord() + "\t" +
                whatNoun.getType() + "\t" +
                whatNoun.getGender() + "\t" +
                whatNoun.getNumber() + "\t" +
                whatNoun.getCase() + "\t" +
                whatNoun.getArticle() + "\t" +
                whatNoun.getProper());
    }
}