package is.gryla.core.Phrase.Test;

import is.gryla.core.Phrase.Phrase;

public class TestSentence {
    public static void main(String[] args) {
        String thisString = "{*SUBJ> [NP Sigurður nken-m Árnason nken-m NP] *SUBJ>} [VP átti sfg3eþ VP] {*OBJ< [NP [APs [AP fallegan lkeosf AP] [CP og c CP] [AP góðan lkeosf AP] APs] hest nkeo NP] *OBJ<} [SCP sem ct SCP] [VPb þótti sfg3eþ VPb] {*SUBJ< [NP ekkert fohen [AP betra lhenvm AP] NP] *SUBJ<} [CP en c CP] [VPi að cn leika sng VPi] {*OBJ< [NP sér fpkeþ NP] *OBJ<} [PP í aþ [NP stöðuvatninu nheþg NP] PP] . .";

        Phrase thisPhrase = Phrase.start(thisString);
        int i = 0;
    }
}
