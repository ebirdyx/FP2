package MiniProject;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GUI {

    public static void replacePane(JFrame frame, JTextArea textPanel) {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(0, 2, 2, 2));
        JTextField findField = new JTextField(5);
        JTextField replaceField = new JTextField(5);
        JLabel findLabel = new JLabel("Find: ");
        JLabel replaceLabel = new JLabel("Replace: ");

        panel.add(findLabel);
        panel.add(findField);
        panel.add(replaceLabel);
        panel.add(replaceField);

        //    ImageIcon icon = new ImageIcon(); //path
        int option = JOptionPane.showConfirmDialog(frame, panel, "Replace", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            int beginIndex = 0;
            while (textPanel.getText().indexOf(findField.getText(), beginIndex) > -1) {
                int match = textPanel.getText().indexOf(findField.getText());
                int endMatch = match + findField.getText().length();

                textPanel.replaceRange(replaceField.getText(), match, endMatch);
                beginIndex = endMatch;
            }
        }
    }

    public static void main(String args[]) {
        JFileChooser fileChooser = new JFileChooser();
        MorseCode morseCode = new MorseCode();
        SpellChecker spellChecker = new SpellChecker();

        //Creating the Frame
        JFrame frame = new JFrame("MiniProject");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);

        Font font = new Font(Font.SERIF,Font.BOLD,32);

        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(font);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu encryptionMenu = new JMenu("Encryption");
        JMenu spellCheckerMenu = new JMenu("SpellChecker");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(encryptionMenu);
        menuBar.add(spellCheckerMenu);
        JMenuItem openFileItem = new JMenuItem("Open");
        JMenuItem saveFileItem = new JMenuItem("Save");
        JMenuItem closeItem = new JMenuItem("Quit");
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(closeItem);

        JMenuItem searchItem = new JMenuItem("Search");
        JMenuItem replaceItem = new JMenuItem("Replace");
        JMenuItem removeHighlightItem = new JMenuItem("Remove highlight");
        editMenu.add(searchItem);
        editMenu.add(replaceItem);
        editMenu.add(removeHighlightItem);

        JMenuItem morseEncodeItem = new JMenuItem("Morse Encode");
        JMenuItem morseDecodeItem = new JMenuItem("Morse decode");
        encryptionMenu.add(morseEncodeItem);
        encryptionMenu.add(morseDecodeItem);

        JMenuItem checkSpellItem = new JMenuItem("Check spelling");
        spellCheckerMenu.add(checkSpellItem);

        // Text Area at the Center
        JTextArea textPanel = new JTextArea();
        textPanel.setFont(font);

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, textPanel);
        frame.setVisible(true);

        //set current directory for fileChooser
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        openFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // user selects a file
                    File selectedFile = fileChooser.getSelectedFile();

                    Path fileName = Path.of(selectedFile.toURI());

                    try {
                        textPanel.setText(Files.readString(fileName));
                    } catch (IOException ioException) {
                        JOptionPane.showConfirmDialog(fileChooser, "Cannot read file: " + selectedFile.getName(), "Error", JOptionPane.DEFAULT_OPTION);
                    }

                }

            }
        });


        saveFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    // user selects a file
                    File selectedFile = fileChooser.getSelectedFile();

                    Path fileName = Path.of(selectedFile.toURI());

                    try {
                        Files.writeString(fileName, textPanel.getText());
                    } catch (IOException ioException) {
                        JOptionPane.showConfirmDialog(fileChooser, "Cannot write file: " + selectedFile.getName(), "Error", JOptionPane.DEFAULT_OPTION);
                    }

                }
            }
        });

        searchItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchWord = JOptionPane.showInputDialog("Find: ");

                Highlighter highlighter = textPanel.getHighlighter();
                Highlighter.HighlightPainter painter =
                        new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);

                if (searchWord == null)
                    return;
                                          //TODO change to regex
                try {
                    int beginIndex = 0;
                    while (textPanel.getText().indexOf(searchWord, beginIndex) > -1)  //check if there is a match
                    {
                        int p0 = textPanel.getText().indexOf(searchWord, beginIndex);
                        int p1 = p0 + searchWord.length();
                        highlighter.addHighlight(p0, p1, painter);
                        beginIndex = p1; // the next time the while loop is called it will start from p1
                    }
                } catch (BadLocationException badLocationException) {
                    badLocationException.printStackTrace();
                }
            }
        });

        replaceItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replacePane(frame, textPanel);

            }
        });

        morseEncodeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.setText(morseCode.textToMorsCode(textPanel.getText()));
            }
        });

        morseDecodeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.setText(morseCode.morsCodeToText(textPanel.getText()));
            }
        });

        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        checkSpellItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textPanel.getText();
                String[] words = content.split(" ");

                Highlighter highlighter = textPanel.getHighlighter();
                Highlighter.HighlightPainter painter =
                        new DefaultHighlighter.DefaultHighlightPainter(Color.pink);

                int beginIndex = 0;

                for (int i = 0; i < words.length; i++) {
                    boolean correct = spellChecker.spellCheck(words[i]);

                    if (!correct) {
                        //highlight the misspelled words
                        try {
                            highlighter.addHighlight(beginIndex, beginIndex + words[i].length(), painter);
                        } catch (BadLocationException badLocationException) {
                            badLocationException.printStackTrace();
                        }
                    }

                    beginIndex += words[i].length() + 1;  // account for the space when we split
                }

            }
        });

        removeHighlightItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Highlighter highlighter = textPanel.getHighlighter();
                highlighter.removeAllHighlights();

            }
        });
    }
}
