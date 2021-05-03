package MiniProject;

import java.util.HashMap;

public class MorseCode {
    public HashMap<String, String> textToMorseCode = new HashMap<>();
    public HashMap<String, String> morseCodeToText = new HashMap<>();

    public MorseCode() {
        textToMorseCode.put("A", "._");
        textToMorseCode.put("B", "_...");
        textToMorseCode.put("C", "_._.");
        textToMorseCode.put("D", "_..");
        textToMorseCode.put("E", ".");
        textToMorseCode.put("F", ".._.");
        textToMorseCode.put("G", "__.");
        textToMorseCode.put("H", "....");
        textToMorseCode.put("I", "..");
        textToMorseCode.put("J", ".___");
        textToMorseCode.put("K", "_._");
        textToMorseCode.put("L", "._..");
        textToMorseCode.put("M", "__");
        textToMorseCode.put("N", "_.");
        textToMorseCode.put("O", "___");
        textToMorseCode.put("P", ".__.");
        textToMorseCode.put("Q", "__._");
        textToMorseCode.put("R", "._.");
        textToMorseCode.put("S", "...");
        textToMorseCode.put("T", "_");
        textToMorseCode.put("U", ".._");
        textToMorseCode.put("V", "..._");
        textToMorseCode.put("W", ".__");
        textToMorseCode.put("X", "_.._");
        textToMorseCode.put("Y", "_.__");
        textToMorseCode.put("Z", "__..");
        textToMorseCode.put("1", ".____");
        textToMorseCode.put("2", "..___");
        textToMorseCode.put("3", "...__");
        textToMorseCode.put("4", "...._");
        textToMorseCode.put("5", ".....");
        textToMorseCode.put("6", "_....");
        textToMorseCode.put("7", "__...");
        textToMorseCode.put("8", "___..");
        textToMorseCode.put("9", "____.");
        textToMorseCode.put("0", "_____");

        morseCodeToText.put("._", "A");
        morseCodeToText.put("_...", "B");
        morseCodeToText.put("_._.", "C");
        morseCodeToText.put("_..", "D");
        morseCodeToText.put(".", "E");
        morseCodeToText.put(".._.", "F");
        morseCodeToText.put("__.", "G");
        morseCodeToText.put("....", "H");
        morseCodeToText.put("..", "I");
        morseCodeToText.put(".___", "J");
        morseCodeToText.put("_._", "K");
        morseCodeToText.put("._..", "L");
        morseCodeToText.put("__", "M");
        morseCodeToText.put("_.", "N");
        morseCodeToText.put("___", "O");
        morseCodeToText.put(".__.", "P");
        morseCodeToText.put("__._", "Q");
        morseCodeToText.put("._.", "R");
        morseCodeToText.put("...", "S");
        morseCodeToText.put("_", "T");
        morseCodeToText.put(".._", "U");
        morseCodeToText.put("..._", "V");
        morseCodeToText.put(".__", "W");
        morseCodeToText.put("_.._", "X");
        morseCodeToText.put("_.__", "Y");
        morseCodeToText.put("__..", "Z");
        morseCodeToText.put(".____", "1");
        morseCodeToText.put("..___", "2");
        morseCodeToText.put("...__", "3");
        morseCodeToText.put("...._", "4");
        morseCodeToText.put(".....", "5");
        morseCodeToText.put("_....", "6");
        morseCodeToText.put("__...", "7");
        morseCodeToText.put("___..", "8");
        morseCodeToText.put("____.", "9");
        morseCodeToText.put("_____", "0");
    }

    public String textToMorsCode(String s) {

        s = s.toUpperCase();
        String codeWords = "";

        for (String word : s.split(" ")) {
            for (int i = 0; i < word.length(); i++) {
                codeWords += textToMorseCode.get(word.substring(i, i + 1)) + " ";
            }
            codeWords += " ";
        }
        return codeWords;
    }

    public String morsCodeToText(String s) {

        String originalValue = "";

        for (String word : s.split(" ")) {
            for (String letter : word.split(" ")) {
                originalValue += morseCodeToText.get(letter);
            }
            originalValue += " ";
        }
        return originalValue;

    }

}