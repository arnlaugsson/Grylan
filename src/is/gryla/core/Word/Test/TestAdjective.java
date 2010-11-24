package is.gryla.core.Word.Test;

import is.gryla.core.Word.Adjective;
import is.gryla.core.Word.TagAttributes.GenderPerson;

import java.util.ArrayList;
import java.util.List;

public class TestAdjective {
    public static void main(String[] args) {
        String testString1 = "ljótur lkensf";
        String testString2 = "ljótari lkenvm";
        String testString3 = "fallegasta lvenve";

        String[] first = testString1.split(" ",2);
        String[] secon = testString2.split(" ",2);
        String[] third = testString3.split(" ",2);

        Adjective thisAdjective = Adjective.resolve(first[0],first[1]);
        Adjective thatAdjective = Adjective.resolve(secon[0],secon[1]);
        Adjective whatAdjective = Adjective.resolve(third[0],third[1]);

        System.out.println(thisAdjective.getWord() + "\t\t" +
                thisAdjective.getType() + "\t" +
                thisAdjective.getGender() + "\t" +
                thisAdjective.getNumber() + "\t" +
                thisAdjective.getCase() + "\t" +
                thisAdjective.getDeclension() + "\t" +
                thisAdjective.getDegree());

        System.out.println(thatAdjective.getWord() + "\t\t" +
                thatAdjective.getType() + "\t" +
                thatAdjective.getGender() + "\t" +
                thatAdjective.getNumber() + "\t" +
                thatAdjective.getCase() + "\t" +
                thatAdjective.getDeclension() + "\t" +
                thatAdjective.getDegree());

        System.out.println(whatAdjective.getWord() + "\t" +
                whatAdjective.getType() + "\t" +
                whatAdjective.getGender() + "\t" +
                whatAdjective.getNumber() + "\t" +
                whatAdjective.getCase() + "\t" +
                whatAdjective.getDeclension() + "\t" +
                whatAdjective.getDegree());

        Adjective[] thisList = {thisAdjective,thatAdjective, whatAdjective};

        GenderPerson firstGen = thisAdjective.getGender();
        for (int i=1; i < thisList.length; i++){
            if (thisList[i].getGender() != firstGen){
                throw new RuntimeException("Genders of adjective " + thisList[i].getWord() + " does not match " + thisList[0].getWord() + " gender.");
            }
        }
        
    }
}
