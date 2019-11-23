package textmvc;

import java.util.ArrayList;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * TextModel
 */
@SuppressWarnings("serial")
public class TextModel extends PlainDocument {
    protected ArrayList<TextView> dependents;

    public TextModel (){
        super();
        this.dependents = new ArrayList<TextView>();
        return;
    }

    public void addDependent(TextView aView) {
        this.dependents.add(aView);
        return;
    }

    public void changed() {
        for (TextView each : dependents) { each.update(); }
        return;
    }

    protected String contents() {
        String aString;
        aString = "";
        aString = this.getString(0, super.getLength());
        return aString;
    }

    public void contents(String aString) {
        try { super.replace(0, super.getLength(), aString, null); }
        catch (BadLocationException anError) { anError.printStackTrace(); }
        return;
    }

    public TextView removeDependent(TextView aView) {
        this.dependents.remove(aView);
        return aView;
    }

    public String getString(int start, int length) {
        String aString;
        aString = "";
        try {aString = this.getText(start, length); }
        catch (BadLocationException anError) { anError.printStackTrace(); }
        return aString;
    }
}