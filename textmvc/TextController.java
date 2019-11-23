package textmvc;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 * TextController
 */
public class TextController extends MouseInputAdapter implements KeyListener {
    private TextModel model;
    private TextView view;

    public TextController() {
        super();
        this.model = null;
        this.view = null;

        return;
    }

    public void setModel(TextModel aModel) {
        this.model = aModel;
        return;
    }

    public void setView(TextView aView) {
        this.view = aView;
        return;
    }

    public TextModel getModel() {
        return this.model;
    }

    public TextView getView() {
        return this.view;
    }

    public void KeyPressed(KeyEvent aKeyEvent){
        return;
    }

    public void keyReleased(KeyEvent aKeyEvent){
        return;
    }

    public void keyTyped(KeyEvent aKeyEvent){
        if (aKeyEvent.getKeyChar() == (char)11) {
            int start;
            int length;
            String text;

            start = this.view.getCaretPosition();
            text = this.model.contents();
            text = this.model.getString(start, text.length() - start);
            length = text.indexOf("\n");
            if (length == 0) { length = 1; }
            if (length == -1) {length = text.length(); }
            this.view.setSelectionStart(start);
            this.view.setSelectionEnd(start + length);
            this.view.cut();
        }
        if (aKeyEvent.getKeyChar() == (char)15) {
            int start;

            start = this.view.getCaretPosition();
            this.view.replaceRange("\n", start, start);
        }
        if (aKeyEvent.getKeyChar() == (char)25) {
            this.view.paste();
        }

        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}