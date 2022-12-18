import DTO.Computer;
import DTO.GameResult;
import DTO.Player;
import Service.*;

import java.util.Locale;
import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        GameController gameController = new GameControllerImpl(player, computer);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, enter your name : ");
        player.setName(scanner.nextLine());

        DataConverter dataConverter = new DataConverterImpl();
        FileWorker fileWorker = new FileWorkerImpl("my_games");
        StringBuilder gameResult = new StringBuilder();
        fileWorker.write("Player name : ".concat(player.getName()).concat("\n"));
        int countGame = 0;
        String endGame = "y";
        do {
            System.out.print("How many game are you want play?");
            countGame = scanner.nextInt();

            gameController.startGame();
            do {
                String value = "1";
                GameResult roundWinner;

                System.out.print("Enter your value : ");
                value = scanner.nextLine();
                if (value.isEmpty()) {
                    value = scanner.nextLine();
                }
                if (value.toLowerCase(Locale.ROOT).equals("stop")) {
                    break;
                }
                player.setGameItem(dataConverter.convert(value));
                gameController.winner();
                roundWinner = gameController.endRound();

                String roundInfo = "Win in " + player.getCountGame() + " round is " + roundWinner;
                System.out.println(roundInfo);
                gameResult.append("\t").append(roundInfo).append("\n");
                countGame--;
            } while (countGame > 0);
            String totalInfo = "Total winner is " + gameController.endGame();
            System.out.println(totalInfo);

            gameResult.insert(0, totalInfo + "\n").append("\n\n");
            fileWorker.write(gameResult.toString());
            gameResult = new StringBuilder();

            System.out.print("Do you want play again ? ");
            endGame = scanner.nextLine().charAt(0) + "";
        } while (!endGame.equalsIgnoreCase("n"));
        System.out.println("See you later^_^");
    }
}
