package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Verb implements InterfaceWord {
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

    public static Verb resolve(String word, String tag){
        Mood mood = Mood.resolve(tag.charAt(1));
        Voice voice = Voice.resolve(tag.charAt(2));

        GenderPerson genderPerson = GenderPerson.NONE;
        Tense tense = Tense.NO_TENSE;   // Default, then we set either tense or case
        Case ncase = Case.NO_CASE;      // depending on the genderPerson (past participle or other kind of verb)
        Number number = Number.NONE;

        if (tag.length() > 3){
            genderPerson = GenderPerson.resolve(tag.charAt(3));
            number = Number.resolve(tag.charAt(4));

            tense = Tense.NO_TENSE;   // Default, then we set either tense or case
            ncase = Case.NO_CASE;      // depending on the genderPerson (past participle or other kind of verb)

            if (genderPerson == GenderPerson.FIRST || genderPerson == GenderPerson.SECOND || genderPerson == GenderPerson.THIRD){
                // Verb is not past participle
                tense = Tense.resolve(tag.charAt(5));
            }
            else{
                ncase = Case.resolve(tag.charAt(5));
            }   
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
