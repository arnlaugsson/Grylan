package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Noun  extends AbstractWord {
    private String word;
    private WordClass type;
    private GenderPerson genderPerson;
    private Number number;
    private Case ncase;
    private SuffixedArticle article;
    private Proper proper;

    private Noun(String word, GenderPerson genderPerson, Number number, Case ncase, SuffixedArticle article, Proper proper, int count) {
        this.word = word;
        this.type = WordClass.NOUN;
        this.genderPerson = genderPerson;
        this.number = number;
        this.ncase = ncase;
        this.article = article;
        this.proper = proper;
        this.countNumber = count;
    }

    public static Noun parse(String word,String tag,int count) {
        GenderPerson genderPerson = GenderPerson.parse(tag.charAt(1));
        Number number = Number.parse(tag.charAt(2));
        Case ncase = Case.parse(tag.charAt(3));

        SuffixedArticle article = SuffixedArticle.NO_ARTICLE; // Default no
        Proper proper = Proper.NOT_PROPER;    // Default no

        if (tag.length() == 5) {
            // 5th letter in a noun always represent an suffixed article
            article = SuffixedArticle.SUFFIXED;
        } else if (tag.length() == 6){
            article = SuffixedArticle.parse(tag.charAt(4));
            proper = Proper.parse(tag.charAt(5));
        }

        return new Noun(word, genderPerson, number, ncase, article, proper, count);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return type;
    }

    public GenderPerson getGenderPerson() {
        return genderPerson;
    }

    public Number getNumber() {
        return number;
    }

    public Case getCase() {
        return ncase;
    }

    public SuffixedArticle getSuffixedArticle() {
        return article;
    }

    public Proper getProper() {
        return proper;
    }
}
