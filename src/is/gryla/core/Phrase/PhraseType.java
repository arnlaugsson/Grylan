package is.gryla.core.Phrase;

public enum PhraseType{

    ROOT,   // An entire sentence :D   

    // Start with '[' and end with ']'
    AdvP,   // Adverb phrase
    AP,     // Adjective phrase
    NP,     // Noun phrase
    NPq,
    PP,     // Prepositional phrase
    VP,     // Verb phrase
    CP,     // Coordination conjunction
    SCP,    // Subordinating conjunction
    InjP,   // Interjection
    APs,    // Adjective phrases
    NPs,    // Noun phrases
    MWE,    // Multi-word expressions

    // Start with '{*' and end with '*}'
    QUAL,   // See IceParser paper
    SUBJ,
    OBJ,
    OBJAP,
    OBJNOM,
    IOBJ,
    COMP,
    TIMEX;

    public static PhraseType resolve(String s){
        try {
            return PhraseType.valueOf(s);
        }
        catch (Exception e) {
            throw new RuntimeException("No phrase available for '" + s + "'");
        }
    }
}