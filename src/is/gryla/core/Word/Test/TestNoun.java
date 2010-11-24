package is.gryla.core.Word.Test;

import is.gryla.core.Word.Noun;

public class TestNoun {
    public static void main(String[] args) {
        String testString1 = "borðið nheng";
        String testString2 = "borð nhen";
        String testString3 = "Hamarinn nkeogö";

        String[] first = testString1.split(" ",2);
        String[] secon = testString2.split(" ",2);
        String[] third = testString3.split(" ",2);

        Noun thisNoun = Noun.resolve(first[0],first[1]);
        Noun thatNoun = Noun.resolve(secon[0],secon[1]);
        Noun whatNoun = Noun.resolve(third[0],third[1]);

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