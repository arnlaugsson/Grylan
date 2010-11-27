package is.gryla.core.Errors;

import java.util.ArrayList;

public class Error {
    private int pos;
    private String ident;
    private int rule;
    private ArrayList<String> listCorrection;

    public Error(int pos, String ident, int rule, ArrayList<String> listCorrection) {
        this.pos = pos;
        this.ident = ident;
        this.rule = rule;
        this.listCorrection = listCorrection;
    }

    public String toString(){
        return Integer.toString(this.pos) + " " + ident + " " + Integer.toString(this.rule) + " [" + "]"; // TODO: vantar corrections!
    }

    public int getPos() {
        return pos;
    }

    public String getIdent() {
        return ident;
    }

    public int getRule() {
        return rule;
    }

    public ArrayList<String> getListCorrection() {
        return listCorrection;
    }
}
