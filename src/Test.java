import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * Created by Bryan on 5/4/16.
 */
public class Test extends JFrame {

    private JFrame frame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    private JPanel newControlPanel;

    int numCorrect;
    int mathType = 0;
    int choice = 0;
    Random rand = new Random();

    public Test (){
        prepareGUI();
    }

    public static void main(String[] args){
        Test test = new Test();
        test.getDifficultyType();
    }

    private void prepareGUI(){
        frame = new JFrame("Math Tutor");
        frame.setSize(400,400);
        frame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        controlPanel.setLayout(new FlowLayout());

        frame.add(headerLabel);
        frame.add(controlPanel);
        frame.add(statusLabel);
        frame.setVisible(true);
    }

    public void getDifficultyType(){

        headerLabel.setText("Please select difficulty type");

        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");

        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = 1;
                getMathType(choice);
            }

        });

        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = 2;
                getMathType(choice);

            }
        });

        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                choice = 3;
                getMathType(choice);
            }
        });


        controlPanel.add(easy);
        controlPanel.add(medium);
        controlPanel.add(hard);
        frame.setVisible(true);
    }


    public void getMathType(int i) {
        newControlPanel = new JPanel();
        newControlPanel.setLayout(new FlowLayout());
        frame.add(newControlPanel);

        if(i == 1) {
            System.out.println("Selected Easy");
        } else if (i == 2) {
            System.out.println("Selected Medium");
        } else {
            System.out.println("Selected Hard");
        }

        JButton addition = new JButton("Addition");
        JButton subtraction = new JButton("Subtration");
        JButton multiply = new JButton("Multiplication");
        JButton division = new JButton("Division");

        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mathType = 1;

                for (int i = 0; i < 10; i++)
                    if (choice == 1) {
                        addition(randomNumber(1), randomNumber(1));
                    } else if (choice == 2) {
                        addition(randomNumber(2), randomNumber(2));
                    } else {
                        addition(randomNumber(3), randomNumber(3));
                    }
                printReport();

            }
        });

        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mathType = 2;
                for (int i = 0; i < 10; i++)
                    if (choice == 1) {
                        subtraction(randomNumber(1), randomNumber(1));
                    } else if (choice == 2) {
                        subtraction(randomNumber(2), randomNumber(2));
                    } else {
                        subtraction(randomNumber(3), randomNumber(3));
                    }
                printReport();
            }
        });

        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mathType = 3;
                for (int i = 0; i < 10; i++)
                    if (choice == 1) {
                        multiplication(randomNumber(4), randomNumber(4));
                    } else if (choice == 2) {
                        multiplication(randomNumber(5), randomNumber(5));
                    } else {
                        multiplication(randomNumber(6), randomNumber(6));
                    }
                printReport();

            }
        });

        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mathType = 4;
                int a;
                int b;

                for (int i = 0; i < 10; i++) {
                    if (choice == 1) {
                        do {
                            a = randomNumber(4);
                            b = randomNumber(4);
                        } while (!isEvenlyDivisable(a, b));
                        division(a, b);
                    } else if (choice == 2) {
                        do {
                            a = randomNumber(5);
                            b = randomNumber(5);
                        } while (!isEvenlyDivisable(a, b));
                        division(a, b);
                    } else {
                        do {
                            a = randomNumber(6);
                            b = randomNumber(6);
                        } while (!isEvenlyDivisable(a, b));
                        division(a, b);
                    }
                }
                printReport();

            }
        });

        newControlPanel.add(addition);
        newControlPanel.add(subtraction);
        newControlPanel.add(multiply);
        newControlPanel.add(division);
        frame.setVisible(true);
    }

    private JPanel createNewPanel() {
        JPanel localJPanel = new JPanel();
        localJPanel.setLayout(new FlowLayout());
        return localJPanel;
    }

    public void addition(int num1, int num2) {
        String textChoice2 = JOptionPane.showInputDialog("What is " + num1 + " + " + num2 + "? ");
        int answer = Integer.parseInt(textChoice2);
        if (num1 + num2 == answer)
        {
            numCorrect++;
        }
    }

    public void subtraction(int num1, int num2) {
        if (num1 > num2) {
            String textChoice3 = JOptionPane.showInputDialog("What is " + num1 + " - " + num2 + "? ");
            int answer = Integer.parseInt(textChoice3);
            if (num1 - num2 == answer) {
                numCorrect++;
            } else {
                String textChoice4 = JOptionPane.showInputDialog("What is " + num2 + " - " + num1 + "? ");
                answer = Integer.parseInt(textChoice4);
                if (num2 - num1 == answer) {
                    numCorrect++;
                }
            }
        }
    }

    public void multiplication(int num1, int num2) {
        String textChoice5 = JOptionPane.showInputDialog("What is " + num1 + " * " + num2 + "? ");
        int answer = Integer.parseInt(textChoice5);
        if (num1 * num2 == answer) {
            numCorrect++;
        }
    }

    public void division(int num1, int num2) {
        if (num1 > num2) {
            String textChoice3 = JOptionPane.showInputDialog("What is " + num1 + " / " + num2 + "? ");
            int answer = Integer.parseInt(textChoice3);
            if (num1 / num2 == answer) {
                numCorrect++;
            }
        } else {
            String textChoice4 = JOptionPane.showInputDialog("What is " + num2 + " / " + num1 + "? ");
            int answer = Integer.parseInt(textChoice4);
            if (num2 / num1 == answer) {
                numCorrect++;
            }
        }
    }

    public int randomNumber(int c) {
        if(c == 1) {
            return (int)rand.nextInt(50) +1;
        } else if (c == 2) {
            return (int)rand.nextInt(90) +10;
        } else if (c == 3) {
            return (int)rand.nextInt(900) +100;
        } else if (c == 4) {
            return (int)rand.nextInt(12) +1;
        } else if (c == 5) {
            return (int)rand.nextInt(40) +10;
        } else {
            return (int)rand.nextInt(990) +10;
        }


    }


    public boolean isEvenlyDivisable(int a, int b) {
        return a % b == 0;
    }



    public void printReport() {
        double win = 10.0;
        double percent = numCorrect / win * 100;

        if (percent < 75) {
            if (mathType == 1)
                statusLabel.setText("<html>Number of correct responses: " + numCorrect + "/" + 10 + "\n" +
                        "Your percentage: " + percent + "% <br/>" +
                        "Please see your teacher for help with Addition</html>");
            else if (mathType == 2)
                statusLabel.setText("<html>Number of correct responses: " + numCorrect + "/" + 10 + "<br/>" +
                        "Your percentage: " + percent + "% <br/>" +
                        "Please see your teacher for help with Subtraction</html>");
            else if (mathType == 3)
                statusLabel.setText("<html>Number of correct responses: " + numCorrect + "/" + 10 + "<br/>" +
                        "Your percentage: " + percent + "% <br/>" +
                        "Please see your teacher for help with Multiplication</html>");
            else {
                statusLabel.setText("<html>Number of correct responses: " + numCorrect + "/" + 10 + "<br/>" +
                        "Your percentage: " + percent + "% <br/>" +
                        "Please see your teacher for help with Division</html>");
            }
            if (percent > 75) {
                statusLabel.setText("<html>Number of correct responses: " + numCorrect + "/" + 10 + "<br/>" +
                        "Your percentage: " + percent + "% <br/>" +
                        "Good Job!</html>");
            }
        }
    }

}