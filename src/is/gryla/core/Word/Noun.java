package is.gryla.core.Word;

import is.gryla.core.Word.TagAttributes.*;
import is.gryla.core.Word.TagAttributes.Number;

public class Noun {
    private String word;
    private WordClass aClass;
    private Gender gender;
    private Number number;
    private Case ncase;
    private Article article;
    private Proper proper;

    private Noun(String word, Gender gender, is.gryla.core.Word.TagAttributes.Number number, Case ncase, Article article, Proper proper) {
        this.word = word;
        this.aClass = WordClass.NOUN;
        this.gender = gender;
        this.number = number;
        this.ncase = ncase;
        this.article = article;
        this.proper = proper;
    }

    public static Noun resolve(String in) {
        String[] sep = in.split(" ", 2);
        String word = sep[0];
        
        Gender gender = Gender.resolve(sep[1].charAt(1));
        Number number = Number.resolve(sep[1].charAt(2));
        Case ncase = Case.resolve(sep[1].charAt(3));

        Article article = Article.resolve('_'); // Default no
        Proper proper = Proper.resolve('_');    // Default no

        if (sep[1].length() == 5) {
            char next = sep[1].charAt(4);
            if (next == 'g') {
                article = Article.resolve(next);    // 5-th letter says it has a suffixed article
                proper = Proper.resolve('_');       // But not a proper noun
            } else {
                article = Article.resolve('-');     // 5-th letter says it's not a suffixed article
                proper = Proper.resolve(next);      // Must be a Proper noun without article
            }
        } else if (sep[1].length() == 6) {
            article = Article.resolve(sep[1].charAt(4));    // Suffixed article
            proper = Proper.resolve(sep[1].charAt(5));      // And a proper noun
        }

        return new Noun(word, gender, number, ncase, article, proper);
    }

    public String getWord() {
        return word;
    }

    public WordClass getType() {
        return aClass;
    }

    public Gender getGender() {
        return gender;
    }

    public Number getNumber() {
        return number;
    }

    public Case getCase() {
        return ncase;
    }

    public Article getArticle() {
        return article;
    }

    public Proper getProper() {
        return proper;
    }
}
