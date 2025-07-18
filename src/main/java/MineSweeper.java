public class MineSweeper {
    public static void main(String[] args) {

        System.out.println("Welcome to Minesweeper!");
        System.out.println();

        while (true) {
            InputReader inputReader = new ConsoleInputReader();

            int sizeofGrid = inputReader.readInt();

            int numberOfMines = inputReader.readInt(sizeofGrid);
            Board board = new Board(sizeofGrid, numberOfMines);

            IGameFunctions game = new GameFunctions(board);

            game.placeMines();
            game.calculateNeighboringMines();

            while (true) {
                game.printBoard();
                String revealCoordinates = inputReader.readLine(sizeofGrid);
                int revealNosOfSquares= game.revealSquare(revealCoordinates,sizeofGrid);
                if (revealNosOfSquares==-1) {
                    System.out.println("Oh no, you detonated a mine! Game over.");
                    break;
                } else {
                    System.out.println("This square contains " + revealNosOfSquares + " adjacent mine");
                }

                if (game.hasPlayerWonCheck()) {
                    System.out.println("Congratulations, you have won the game!");
                    break;
                }
            }

            System.out.println("\n Press any key to play again or type 'q' to quit:");
            Boolean ans=inputReader.readResponse();

            if(!ans){
                System.out.println("Thanks for playing");
                inputReader.close();
                break;
            }
        }
    }
}





