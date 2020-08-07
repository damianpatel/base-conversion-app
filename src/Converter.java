import javax.swing.*;
import java.awt.*;

public class Converter {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ConverterPanel panel = new ConverterPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(500, 500));

        frame.pack();
        frame.setVisible(true);
    }
}
