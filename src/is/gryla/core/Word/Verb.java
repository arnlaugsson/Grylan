package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Verb {
    private String word;        // All verbs
    private WordClass type;     // All verbs
    private Mood mood;          // All verbs
    private Voice voice;        // All verbs
    private GenderPerson genderPerson;      // Either person or gender depending type of verb
    private Number number;      // All verbs
    private Tense tense;        // Verbs except past participle
    private Case ncase;         // Past participle verbs

    private Verb(String word, Mood mood, Voice voice, GenderPerson genderPerson, Number number, Tense tense, Case ncase) {
        this.word = word;
        this.type = WordClass.VERB;
        this.mood = mood;
        this.voice = voice;
        this.genderPerson = genderPerson;
        this.number = number;
        this.tense = tense;
        this.ncase = ncase;
    }

    public static Verb resolve(String in){
        String[] sep = in.split(" ", 2);
        String word = sep[0];

        Mood mood = Mood.resolve(sep[1].charAt(1));
        Voice voice = Voice.resolve(sep[1].charAt(2));
        GenderPerson genderPerson = GenderPerson.resolve(sep[1].charAt(3));
        Number number = Number.resolve(sep[1].charAt(4));

        Tense tense = Tense.NO_TENSE;   // Default, then we set either tense or case
        Case ncase = Case.NO_CASE;      // depending on the genderPerson (past participle or other kind of verb)

        if (genderPerson == GenderPerson.FIRST || genderPerson == GenderPerson.SECOND || genderPerson == GenderPerson.THIRD){
            // Verb is not past participle
            tense = Tense.resolve(sep[1].charAt(5));
        }
        else{
            ncase = Case.resolve(sep[1].charAt(5));
        }
        
        return new Verb(word, mood, voice, genderPerson, number, tense, ncase);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public Mood getMood() {
        return mood;
    }

    public Voice getVoice() {
        return voice;
    }

    public GenderPerson getGenderPerson() {
        return genderPerson;
    }

    public Number getNumber() {
        return number;
    }

    public Tense getTense() {
        return tense;
    }

    public Case getCase() {
        return ncase;
    }
}
