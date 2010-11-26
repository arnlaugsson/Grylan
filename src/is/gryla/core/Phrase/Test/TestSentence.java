package is.gryla.core.Phrase.Test;

import is.gryla.core.Phrase.Phrase;
import is.gryla.core.Rules.RuleRunner;
import is.gryla.core.Word.AbstractWord;
import is.gryla.core.Word.InterfaceWord;

import java.util.ArrayList;
import java.util.Arrays;

public class TestSentence {
    public static void main(String[] args) {
        String thisString = "{*SUBJ> [NP Sigurður nken-m Árnason nken-m NP] *SUBJ>} [VP átti sfg3eþ VP] {*OBJ< [NP [APs [AP fallegan lkeosf AP] [CP og c CP] [AP góðan lkeosf AP] APs] hest nkeo NP] *OBJ<} [SCP sem ct SCP] [VPb þótti sfg3eþ VPb] {*SUBJ< [NP ekkert fohen [AP betra lhenvm AP] NP] *SUBJ<} [CP en c CP] [VPi að cn leika sng VPi] {*OBJ< [NP sér fpkeþ NP] *OBJ<} [PP í aþ [NP stöðuvatninu nheþg NP] PP] . .";

        Phrase thisPhrase = Phrase.start(thisString);
        ArrayList<InterfaceWord> words = thisPhrase.getAllWords();
        RuleRunner roadRunner = new RuleRunner();

        roadRunner.run(thisPhrase);

        InterfaceWord[] array = new InterfaceWord[words.size()];

        int i = 0;
        int[] sizeList = new int[words.size()];

        for (InterfaceWord iword : words){
            array[i] = iword;
            //System.out.println(iword.getWord());
            int y = iword.getCount();
            sizeList[i] = y;
            i++;
        }

        Arrays.sort(sizeList);
        InterfaceWord[] array2 = new InterfaceWord[sizeList.length];
        for (int z : sizeList){
            for (InterfaceWord iword : words){
                if (iword.getCount() == z){
                    array2[z] = iword;
                }
            }
        }

        for (InterfaceWord iword : array2){
            System.out.println(iword.getCount() + " - " + iword.getWord());
        }

        // Sigurður Árnason átti fallegan og góðan hest sem þótti ekkert betra en að leika sér í stöðuvatninu.
    }
}
