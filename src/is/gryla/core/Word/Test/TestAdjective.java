package is.gryla.core.Word.Test;

import is.gryla.core.Word.Adjective;

public class TestAdjective {
    public static void main(String[] args) {
        String testString1 = "ljótur lkensf";
        String testString2 = "ljótari lkenvm";
        String testString3 = "fallegasta lvenve";

        Adjective thisAdjective = Adjective.resolve(testString1);
        Adjective thatAdjective = Adjective.resolve(testString2);
        Adjective whatAdjective = Adjective.resolve(testString3);

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
    }
}
