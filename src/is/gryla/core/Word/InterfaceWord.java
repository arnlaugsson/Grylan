package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public interface InterfaceWord {
    public WordClass getType();
    public String getWord();
    public int getCount();
    public AdverbCategory getAdverbCategory();
    public Case getCase();
    public ConjunctionCategory getConjunctionCategory();
    public Declension getDeclension();
    public Degree getDegree();
    public GenderPerson getGenderPerson();
    public Mood getMood();
    public Number getNumber();
    public NumeralCategory getNumeralCategory();
    public Proper getProper();
    public Subcategory getSubcategory();
    public SuffixedArticle getSuffixedArticle();
    public Tense getTense();
    public Voice getVoice();
}
