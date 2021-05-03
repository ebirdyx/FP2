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
    public static void main(String args[]) {
        JFileChooser fileChooser = new JFileChooser();
        MorseCode morseCode = new MorseCode();
        //Creating the Frame
        JFrame frame = new JFrame("Morse Coding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu encryptionMenu = new JMenu("Encryption");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(encryptionMenu);
        JMenuItem openFileItem = new JMenuItem("Open");
        JMenuItem saveFileItem = new JMenuItem("Save");
        JMenuItem closeItem = new JMenuItem("Quit");
        fileMenu.add(openFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.add(closeItem);

        JMenuItem searchItem = new JMenuItem("Search");
        JMenuItem replaceItem = new JMenuItem("Replace");
        editMenu.add(searchItem);
        editMenu.add(replaceItem);

        JMenuItem morseEncodeItem = new JMenuItem("Morse Encode");
        JMenuItem morseDecodeItem = new JMenuItem("Morse decode");
        encryptionMenu.add(morseEncodeItem);
        encryptionMenu.add(morseDecodeItem);

        // Text Area at the Center
        JTextArea textPanel = new JTextArea();

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


                try {
                    int beginIndex = 0;
                    while (textPanel.getText().indexOf(searchWord,beginIndex) > -1)  //check if there is a match
                    {
                        int p0 = textPanel.getText().indexOf(searchWord,beginIndex);
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
                String searchWord = JOptionPane.showInputDialog("Replace: ");


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
    }
}
