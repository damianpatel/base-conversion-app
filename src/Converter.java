import javax.swing.*;
import java.awt.*;

public class Converter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Base Converter");
        ConverterPanel panel = new ConverterPanel();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(500, 400));
        frame.setResizable(false);
        // Add icon
        ImageIcon img = new ImageIcon("src/brain.jpg");
        frame.setIconImage(img.getImage());

        frame.pack();
        frame.setVisible(true);
    }
}
