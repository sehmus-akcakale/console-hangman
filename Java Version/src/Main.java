public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String word = game.getWord();
        game.play(word);
    }
}