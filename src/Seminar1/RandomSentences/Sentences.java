package Seminar1.RandomSentences;

public class Sentences {
    public Sentences() {
        String article[] = {"the ", "a ", "one ", "some ", "any "},
                noun[] = {"boy", "girl", "dog", "town", "car"},
                verb[] = {" drove", " jumped", " ran", " walked", " skipped"},
                preposition[] = {" to ", " from ", " over ", " under ", " on "};

//        public static StringBuilder getSentences(){
//
//        }
        // randomly create sentence
        for (int j = 1; j <= 20; j++) {
            int article1 = (int) (Math.random() * 5);
            int noun1 = (int) (Math.random() * 5);
            int verb1 = (int) (Math.random() * 5);
            int preposition2 = (int) (Math.random() * 5);
            int article2 = (int) (Math.random() * 5);
            int noun2 = (int) (Math.random() * 5);

            StringBuilder stringBuilder = new StringBuilder();

// concatenate words and add period
            stringBuilder.append(
                    article[article1]
                            + noun[noun1]
                            + verb[verb1]
                            + preposition[preposition2]
                            + article[article2]
                            + noun[noun2] + ".\n");

// capitalize first letter
            stringBuilder.setCharAt(
                    0, Character.toUpperCase(stringBuilder.charAt(0)));
            stringBuilder.append(stringBuilder.toString());
        }
    }

    // execute application
    public static void main(String args[]) {
        Sentences application = new Sentences();

    }

} // end class Sentences

