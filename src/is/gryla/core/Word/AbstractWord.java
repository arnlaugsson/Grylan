package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public abstract class AbstractWord implements InterfaceWord{
    abstract public WordClass getType();

    public int countNumber;
    private String word;

    public int getCount(){
        return this.countNumber;
    }

    public String getWord(){
        return this.word;
    }

    public AdverbCategory getAdverbCategory(){
        return null;
    }
    public Case getCase(){
       return null;
    }
    public ConjunctionCategory getConjunctionCategory(){
        return null;
    }
    public Declension getDeclension(){
        return null;
    }
    public Degree getDegree(){
        return null;
    }
    public GenderPerson getGenderPerson(){
        return null;
    }
    public Mood getMood(){
        return null;
    }
    public Number getNumber(){
        return null;
    }
    public NumeralCategory getNumeralCategory(){
        return null;
    }
    public Proper getProper(){
        return null;
    }
    public Subcategory getSubcategory(){
        return null;
    }
    public SuffixedArticle getSuffixedArticle(){
        return null;
    }
    public Tense getTense(){
        return null;
    }
    public Voice getVoice(){
        return null;
    }
}
