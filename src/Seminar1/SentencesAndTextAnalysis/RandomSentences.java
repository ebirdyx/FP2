package Seminar1.SentencesAndTextAnalysis;

import java.util.Random;

class Words {

    private String[] article;
    private String[] noun;
    private String[] verb;
    private String[] preposition;
    private Random rand = new Random();

    public Words() {
        article = new String[]{"the", "a", "one", "some", "any"};
        noun = new String[]{"boy", "girl", "dog", "town", "car"};
        verb = new String[]{"drove", "jumped", "ran", "walked", "skipped"};
        preposition = new String[]{"to", "from", "over", "under", "on"};
    }

    public String getArticle() {
        return article[rand.nextInt(article.length)];
    }

    public String getNoun() {
        return noun[rand.nextInt(noun.length)];
    }

    public String getVerb() {
        return verb[rand.nextInt(verb.length)];
    }

    public String getPreposition() {
        return preposition[rand.nextInt(preposition.length)];
    }
}

class Sentence {

    private Words word = new Words();

    public String getSentence() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(word.getArticle() + " ");

        stringBuilder.append(word.getNoun() + " ");

        stringBuilder.append(word.getVerb() + " ");

        stringBuilder.append(word.getPreposition() + " ");

        stringBuilder.append(word.getArticle() + " ");

        stringBuilder.append(word.getNoun());

        return stringBuilder.toString();

    }

}

class Main {

    public static void formRandomSentences() {
        Sentence sentence = new Sentence();

        for (int i = 1; i <= 20; i++) {

            System.out.println(sentence.getSentence());
        }
    }

    public static void main(String[] args) {
        formRandomSentences();
    }

}
