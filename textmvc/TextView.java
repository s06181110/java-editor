package textmvc;

import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextArea;

/**
 * TextView
 */
@SuppressWarnings("serial")
public class TextView extends JTextArea{
    protected TextModel model;
    protected TextController controller;

    public TextView (TextModel aModel) {
        super();
        this.model = aModel;
        this.model.addDependent(this);
        this.controller = new TextController();
        this.setFont(new Font("Monospaced", Font.PLAIN, 14));
        return;
    }

    public TextController getController() {
        return this.controller;
    }

    public TextModel getModel(){
        return this.model;
    }

    public void paintComponent(Graphics aGraphics){
        super.paintComponent(aGraphics);
        return;
    }

    public void release() {
        model.removeDependent(this);
        return;
    }

    public void update() {
        this.repaint(0, 0, this.getWidth(), this.getHeight());
        return;
    }

}