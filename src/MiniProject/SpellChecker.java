package MiniProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SpellChecker {
    ArrayList<String> wordList = new ArrayList<>();

    public SpellChecker() {
        Scanner s = null;
        try {
            Path root = Paths.get(".").normalize().toAbsolutePath();   //to get current project path
            File file = new File(root.toString() + File.separator + "src\\MiniProject\\words.txt");
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNext()) {
            wordList.add(s.next());
        }
        s.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        SpellChecker spellChecker = new SpellChecker();
        System.out.println(spellChecker.spellCheck("hi"));
//        for (int i = 0; i < spellChecker.wordList.size() ; i++){
//            System.out.println(spellChecker.wordList.get(i));
//
//        }

    }


    public boolean spellCheck(String word) {
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).toLowerCase(Locale.ROOT).equals(word.toLowerCase(Locale.ROOT)))
                return true;
        }
        return false;
    }


}
