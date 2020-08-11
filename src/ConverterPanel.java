import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public class ConverterPanel extends JPanel {
    JPanel top;
    JLabel topLabel;
    JPanel center;
    JPanel fromBase;
    JLabel fromBaseLabel;
    JTextField fromBaseInput;
    JPanel toBase;
    JLabel toBaseLabel;
    JTextField toBaseInput;
    JPanel numPanel;
    JLabel numLabel;
    JTextField numInput;
    JButton convert;
    JButton clear;
    JTextArea output;
    JPanel space;
    JScrollPane scrollPane;
    ArrayList<String> letters;
    ArrayList<Integer> numbers;
    Map<String, Integer> letterMapping;

    public ConverterPanel() {
        top = new JPanel();
        topLabel = new JLabel();
        center = new JPanel();
        fromBase = new JPanel();
        fromBaseLabel = new JLabel();
        fromBaseInput = new JTextField();
        toBase = new JPanel();
        toBaseLabel = new JLabel();
        toBaseInput = new JTextField();
        numPanel = new JPanel();
        numLabel = new JLabel();
        numInput = new JTextField();
        convert = new JButton();
        clear = new JButton();
        output = new JTextArea(2, 30);
        space = new JPanel();
        space.setPreferredSize(new Dimension(200, 20));
        scrollPane = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // Letter/number mapping
        letterMapping = new HashMap<>();
        letterMapping.put("A", 10);
        letterMapping.put("B", 11);
        letterMapping.put("C", 12);
        letterMapping.put("D", 13);
        letterMapping.put("E", 14);
        letterMapping.put("F", 15);
        letterMapping.put("G", 16);
        letterMapping.put("H", 17);
        letterMapping.put("I", 18);
        letterMapping.put("J", 19);
        letterMapping.put("K", 20);
        letterMapping.put("L", 21);
        letterMapping.put("M", 22);
        letterMapping.put("N", 23);
        letterMapping.put("O", 24);
        letterMapping.put("P", 25);
        letterMapping.put("Q", 26);
        letterMapping.put("R", 27);
        letterMapping.put("S", 28);
        letterMapping.put("T", 29);
        letterMapping.put("U", 30);
        letterMapping.put("V", 31);
        letterMapping.put("W", 32);
        letterMapping.put("X", 33);
        letterMapping.put("Y", 34);
        letterMapping.put("Z", 35);

        // A-Z in ArrayList
        letters = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            letters.add(String.valueOf(c));
        }
        // add space b/c user might add a space in text field that still results in a valid value
        // for example: "    12   " --> should still yield as valid
        letters.add(" ");

        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        // Title panel/label config
        top.setBackground(new Color(255, 220, 150));
        Font title = new Font("Georgia", Font.BOLD, 25);
        topLabel.setText("Welcome to the Base Converter!");
        topLabel.setFont(title);
        topLabel.setForeground(Color.BLACK);
        top.add(topLabel);

        // Center panel config
        center.setPreferredSize(new Dimension(350, 300));
        center.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        center.add(fromBase, BorderLayout.EAST);
        center.add(toBase, BorderLayout.EAST);
        center.add(numPanel, BorderLayout.EAST);
        center.add(convert, BorderLayout.CENTER);
        center.add(clear, BorderLayout.CENTER);
        center.add(space);
        center.add(scrollPane);

        fromBase.add(fromBaseLabel);
        fromBase.add(fromBaseInput, BorderLayout.EAST);
        fromBaseLabel.setText("Convert From Base ");
        fromBaseLabel.setFont(new Font("Arial", Font.BOLD, 20));
        fromBaseLabel.setForeground(new Color(140, 160, 255));
        fromBaseInput.setPreferredSize(new Dimension(100, 30));
        fromBaseInput.setFont(new Font("Helvetica", Font.BOLD, 20));

        toBase.add(toBaseLabel);
        toBase.add(toBaseInput);
        toBaseLabel.setText("Convert To Base ");
        toBaseLabel.setFont(new Font("Arial", Font.BOLD, 20));
        toBaseLabel.setForeground(new Color(225, 125, 255));
        toBaseInput.setPreferredSize(new Dimension(125, 30));
        toBaseInput.setFont(new Font("Helvetica", Font.BOLD, 20));

        numPanel.add(numLabel);
        numPanel.add(numInput);
        numLabel.setText("Enter Value ");
        numLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numLabel.setForeground(new Color(255, 100, 113));
        numInput.setPreferredSize(new Dimension(173, 30));
        numInput.setFont(new Font("Helvetica", Font.BOLD, 20));

        // Buttons config:

        // Convert button
        convert.setFocusPainted(false);
        convert.setPreferredSize(new Dimension(100, 40));
        convert.setText("Convert");
        convert.setFont(new Font("Courier New", Font.PLAIN, 15));
        convert.setBackground(new Color(150, 255, 120));
        convert.addActionListener(new Listener());

        // Clear button
        clear.setFocusPainted(false);
        clear.setPreferredSize(new Dimension(100, 40));
        clear.setText("Clear");
        clear.setFont(new Font("Courier New", Font.PLAIN, 15));
        clear.setBackground(new Color(255, 172, 145));
        clear.addActionListener(new Listener());

        // Output text area config
        output.setEditable(false);
        TitledBorder outputBorder = new TitledBorder("Output");
        outputBorder.setTitleFont(new Font("Arial", Font.BOLD, 25));
        outputBorder.setTitleColor(new Color(255, 111, 0));
        scrollPane.setBorder(outputBorder);

        // Add components to primary panel
        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        setBackground(new Color(225, 255, 230));
    }

    public boolean baseValid(String a) {
        try {
            Integer.parseInt(a);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return Integer.parseInt(a) >= 2 && Integer.parseInt(a) <= 36;
    }

    public boolean isNumeric(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Are letters valid?
    public boolean letterValid(char c, int base) {
        if (letterMapping.containsKey(String.valueOf(c).toUpperCase())) {
            return letterMapping.get(String.valueOf(c).toUpperCase()) < base;
        }
        return false;
    }

    public boolean isAcceptable(String a, int base) {
        int x = 0;

        // Get rid of spaces for "value" text field
        a = a.replaceAll("\\s+","");
        numInput.setText(a);

        if (a.length() == 0) {
            x = -1;
        }

        for (int i = 0; i < a.length(); i++) {
            Predicate<String> equalsIgnoreCase = String.valueOf(a.charAt(i))::equalsIgnoreCase;
            if (a.charAt(i) == '-' && i != 0) {
                x = -1;
            }
            if (isNumeric(a.charAt(i))) {
                int o = Integer.parseInt(String.valueOf(a.charAt(i)));
                // You can't use a number greater than or equal to the base
                if (numbers.contains(o) && o >= base) {
                    x = -1;
                }
            } else if (letters.stream().anyMatch(equalsIgnoreCase)) {
                // letters can only be used for bases between 11 and 36 (inclusive)
                if (letters.stream().anyMatch(equalsIgnoreCase) && (!(base > 10 && base <= 36))) {
                    x = -1;
                }
                // Integer value of character must be less than base
                if (!(letterValid(a.charAt(i), base))) {
                    x = -1;
                }
            }
        }
        return x == 0;
    }

    public void clearAll() {
        output.setText("");
        fromBaseInput.setText("");
        toBaseInput.setText("");
        numInput.setText("");
    }

    public double toDecimal(String value, int base) {
        double[] decValue;
        StringBuilder valids = new StringBuilder();
        StringBuilder finalValue = new StringBuilder();
        double temp = 0;

        for (int i = 0; i < value.length(); i++) {
            if (isNumeric(value.charAt(i)) || letters.stream().anyMatch(String.valueOf(value.charAt(i))::equalsIgnoreCase) || value.charAt(i) == '-') {
                if (value.charAt(i) != ' ') {
                    valids.append(value.charAt(i));
                }
                if (value.charAt(i) == '-') {
                    DecimalToBaseX.isNegative = true;
                }
            }
        }

        decValue = new double[valids.length()];
        for (int i = 0; i < valids.length(); i++) {
            if (isNumeric(valids.charAt(i))) {
                // Converts numeric values to decimal value
                decValue[i] = ((Math.pow(base, (valids.length() - i - 1))) * Double.parseDouble(String.valueOf(valids.charAt(i))));
                System.out.println("element i: " + decValue[i]);
            }
            if (letters.stream().anyMatch(String.valueOf(valids.charAt(i))::equalsIgnoreCase) && valids.charAt(i) != ' ') {
                // Converts letters to their corresponding decimal equivalent using the letters --> integer HashMap
                decValue[i] = ((Math.pow(base, (valids.length() - i - 1))) * letterMapping.get(String.valueOf(valids.charAt(i)).toUpperCase()));
            }
        }
        for (double j : decValue) {
            temp += j;
        }
        finalValue.append(temp);
        System.out.println(finalValue.toString());
        return Double.parseDouble(finalValue.toString());
    }

    private class Listener extends DecimalToBaseX implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear all text fields
            if (e.getSource() == clear) {
                numInput.setBackground(Color.WHITE);
                fromBaseInput.setBackground(Color.WHITE);
                toBaseInput.setBackground(Color.WHITE);
                clearAll();
            }
            if (e.getSource() == convert) {
                // Get rid of white spaces for "to base" and "from base" text fields
                toBaseInput.setText(toBaseInput.getText().replaceAll("\\s+",""));
                fromBaseInput.setText(fromBaseInput.getText().replaceAll("\\s+",""));
                if (!(baseValid(toBaseInput.getText()))) {
                    JOptionPane.showMessageDialog(null, "\"TO BASE VALUE\" MUST BE A VALID POSITIVE INTEGER GREATER THAN 1 AND LESS THAN 36");
                    toBaseInput.setBackground(new Color(255, 129, 129));
                }
                if (!(baseValid(fromBaseInput.getText()))) {
                    JOptionPane.showMessageDialog(null, "\"FROM BASE\" VALUE MUST BE A VALID POSITIVE INTEGER GREATER THAN 1 AND LESS THAN 36");
                    fromBaseInput.setBackground(new Color(255, 129, 129));

                }
                if (baseValid(toBaseInput.getText())) {
                    if (Integer.parseInt(toBaseInput.getText()) < 2 || Integer.parseInt(toBaseInput.getText()) > 36) {
                        toBaseInput.setBackground(new Color(255, 129, 129));
                        JOptionPane.showMessageDialog(null, "\"TO BASE\" VALUE MUST BE VALID POSITIVE INTEGER GREATER THAN 1 AND LESS THAN 36");
                    }
                }
                if (baseValid(fromBaseInput.getText())) {
                    if (Integer.parseInt(fromBaseInput.getText()) < 2 || Integer.parseInt(fromBaseInput.getText()) > 36) {
                        fromBaseInput.setBackground(new Color(255, 129, 129));
                        JOptionPane.showMessageDialog(null, "\"FROM BASE\" VALUE MUST BE VALID POSITIVE INTEGER GREATER THAN 1 AND LESS THAN 36");
                    }
                }
                if (baseValid(toBaseInput.getText()) && baseValid(fromBaseInput.getText())) {
                    fromBaseInput.setBackground(Color.WHITE);
                    toBaseInput.setBackground(Color.WHITE);
                    if (isAcceptable(numInput.getText(), Integer.parseInt(fromBaseInput.getText()))) {
                        if (!DecimalToBaseX.algorithm(toDecimal(numInput.getText(), Integer.parseInt(fromBaseInput.getText())), Integer.parseInt(toBaseInput.getText())).equals("invalid")) {
                            numInput.setBackground(Color.WHITE);
                            fromBaseInput.setBackground(Color.WHITE);
                            toBaseInput.setBackground(Color.WHITE);
                            output.setText(DecimalToBaseX.algorithm(toDecimal(numInput.getText(), Integer.parseInt(fromBaseInput.getText())), Integer.parseInt(toBaseInput.getText())));
                            DecimalToBaseX.isNegative = false;
                        } else {
                            numInput.setBackground(new Color(255, 129, 129));
                        }
                    } else {
                        numInput.setBackground(new Color(255, 129, 129));
                    }
                }
            }
        }
    }
}
