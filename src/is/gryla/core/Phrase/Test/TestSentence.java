package is.gryla.core.Phrase.Test;

import is.gryla.core.Phrase.Phrase;

public class TestSentence {
    public static void main(String[] args) {
        String thisString = "{*SUBJ> [NP Sigurður nken-m Árnason nken-m NP] *SUBJ>}\n[VP átti sfg3eþ VP]\n{*OBJ< [NP [APs [AP fallegan lkeosf AP] [CP og c CP] [AP góðan lkeosf AP] APs] hest nkeo NP] *OBJ<}\n[SCP sem ct SCP]\n[VPb þótti sfg3eþ VPb]\n{*SUBJ< [NP ekkert fohen [AP betra lhenvm AP] NP] *SUBJ<}\n[CP en c CP]\n[VPi að cn leika sng VPi]\n{*OBJ< [NP sér fpkeþ NP] *OBJ<}\n[PP í aþ [NP stöðuvatninu nheþg NP] PP]\n. .";

        Phrase thisPhrase = Phrase.start(thisString);
    }
}
