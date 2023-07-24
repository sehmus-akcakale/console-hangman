import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Game {

    public String getWord(){
        Random random = new Random();
        int index = random.nextInt(Words.words.length);
        return Words.words[index];
    }
    public void play(String word){
        Scanner input = new Scanner(System.in);

        String[] question = new String[word.length()];
        int lives = 6;
        ArrayList<String> guessedLetters = new ArrayList<>();
        ArrayList<String> guessedWords = new ArrayList<>();
        boolean guessed = false;
        System.out.println("Game started !");
        System.out.println(displayHangman(lives));
        System.out.println(displayQuestion(question));



        while (!guessed && (lives > 0)){
            String guess ;
            guess = input.nextLine();
            if(guess.length() == 1 ){

                if (guessedLetters.contains(guess.toLowerCase())){
                    System.out.println("You've already guessed character "+ guess + " .");

                }else if (!word.contains(guess)){
                    System.out.println("You've made an incorrect guess.");
                    guessedLetters.add(guess.toLowerCase());
                    lives--;

                }else{
                    System.out.println("Great, you've made a correct guess!");
                    guessedLetters.add(guess.toLowerCase());
                    placeTheWord(word,guess, question);

                }

            }else if (guess.length() == word.length()){
                if (guessedWords.contains(guess.toLowerCase())){
                    System.out.println("You've already guessed word "+ guess+ " .");

                }else if (!guess.toLowerCase().equals(word)){
                    System.out.println("You've made an incorrect guess.");
                    guessedWords.add(guess);
                    lives--;

                }else{
                    System.out.println("Great, you've guessed the word!");
                    guessed = true;
                }

            }else {
                System.out.println("You've made an invalid guess.");
            }
            System.out.println(displayHangman(lives));
            System.out.println(displayQuestion(question));
            System.out.println("Remaning lives: "+ lives);
            System.out.println("Previously guessed letter:" + displayQuessed(guessedLetters));
            System.out.println("Previously guessed words:" + displayQuessed(guessedWords));

        }
        if(lives > 0 && guessed){
            System.out.println("Congrats, you've won the game!");
        }else{
            System.out.println("You've lost the game. The word was "+ word + ".");
        }



    }
    public String displayQuestion(String[] question){
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < question.length ; i++){
            if(question[i] == null){
                str.append("_");
            }else{
                str.append(question[i]);
            }
        }
        return str.toString();
    }
    public String displayQuessed(ArrayList<String> arr){
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < arr.size();i++ ){
            str.append(" ").append(arr.get(i));
        }
        str.append(" ]");
        return str.toString();
    }



    public void placeTheWord(String word,String guess,String[]question){
        String[] wordList = word.split("");
        for(int i = 0 ; i < wordList.length ; i++){
            if(guess.equals(wordList[i])){
                question[i] = guess;
            }
        }
    }

    public String displayHangman(int lives) {
        String[] hangmanSymbols = {
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========",

                "  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "========="
        };
        return hangmanSymbols[lives];
    }



}
