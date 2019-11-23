package textmvc;

import javax.swing.JFrame;

public class Example extends Object {

    public static void main(String[] args) {
        TextModel aModel = new TextModel();
        TextView aView = new TextView(aModel);

        JFrame aWindow = new JFrame("Example");
        aWindow.getContentPane().add(aView);
        aWindow.setMinimumSize(Constants.MinimumWindowSize);
        aWindow.setSize(Constants.DefaultWindowSize);
        aWindow.setResizable(true);
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.setVisible(true);

        return;
    }
}