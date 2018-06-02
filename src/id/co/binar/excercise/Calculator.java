package id.co.binar.excercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Calculator extends JFrame {
    private int firstNumber;
    private int secondNumber;
    private String sign;
    private String displayedText;
    private String pressedText;
    private JTextField display;
    private ActionListener actionlistener;
    private JPanel panel = new JPanel();
    private JPanel panelDisplay = new JPanel();


    final String[] buttonNames = {
            "7", "8", "9", "/",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "AC", "0", "+", "="};

    public Calculator(int w, int h, Color color) {
        super("Calculator");
        Container container = getContentPane();
        setSize(w, h);
        container.setBackground(color);

        display = new JTextField("");

        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(5, 3, 0, 0));
        container.add(panel, BorderLayout.CENTER);
        panelDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        panelDisplay.add(display);
        container.add(panelDisplay, BorderLayout.NORTH);

        Font font = new Font("Normal", Font.BOLD, 40);
        display.setPreferredSize(new Dimension(400, 60));
        display.setFont(font);

        initActionListener();
        initButtons(container, panel);
        setWindowListener();

        setVisible(true);
    }

    private void initActionListener() {
        actionlistener = e -> {
            JButton x = (JButton) e.getSource();

            // Set displayed text in text field
            displayedText = display.getText();
            // get the selected button
            pressedText = x.getText();

            // If variable "pressedText" have value "+" or "-" or "*" or "/", then :
            // 1. Save "Integer.parseInt(displayedText)" to variable "firstNumber"
            // 2. Set variable "sign" with value "pressedText"
            // 3. Set "displayedText" and "pressedText" with empty string ("")

            // If variable "pressedText" have value "AC", then :
            // 1. Set "displayedText" and "pressedText" with empty string ("")
            // 2. Set "firstNumber" and "secondNumber" to 0

            // If variable "pressedText" have value "=", then :
            // 1. Set "pressedText" to empty string ("")
            // 2. Set "secondNumber" with value "Integer.parseInt(displayedText)"
            // 3. call method "calculateResult(firstNumber, secondNumber, sign)"

            // show result to textfield
            display.setText(displayedText + pressedText);
        };
    }

    private void calculateResult(float firstNumber, float secondNumber, String sign) {
        float result = 0;
        // do calculation based on sign here
        
        // until here
        displayedText = String.valueOf(result);
    }

    private void setWindowListener() {
        addWindowListener(new WindowListener() {
            public void windowActivated(WindowEvent e) {
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            public void windowDeactivated(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowOpened(WindowEvent e) {
            }
        });
    }

    private void initButtons(Container container, JPanel panel) {
        for (String ButtonName : buttonNames) {
            JButton button = new JButton(ButtonName);
            button.setAlignmentX(Component.TOP_ALIGNMENT);
            button.addActionListener(actionlistener);
            container.add(button, BorderLayout.LINE_START);
            Font font2 = new Font("Normal", Font.BOLD, 16);
            button.setFont(font2);
            panel.add(button);
        }
    }

    public static void main(String[] a) {
        new Calculator(400, 600, Color.WHITE);
    }
}
