import DTO.Computer;
import DTO.GameResult;
import DTO.Player;
import Service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Scanner;

public class RunApplication {
    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger liveCycle = LoggerFactory.getLogger("live");
    private static final Logger result = LoggerFactory.getLogger("result");

    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        GameController gameController = new GameControllerImpl(player, computer);

        Scanner scanner = new Scanner(System.in);
        logger.info("Hello, enter your name : ");
        player.setName(scanner.nextLine());

        DataConverter dataConverter = new DataConverterImpl();
        logger.info("Player name : ".concat(player.getName()));
        int countGame = 0;
        String endGame = "y";
        String countPlayerGame = "";
        do {
            logger.info("How many game are you want play?");
            countGame = scanner.nextInt();
            countPlayerGame = String.valueOf(countGame);
            gameController.startGame();
            do {
                String value = "1";
                GameResult roundWinner;

                logger.info("Enter your value : ");
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
                logger.info(roundInfo);
                liveCycle.info(roundInfo);
                countGame--;
            } while (countGame > 0);
            String totalInfo = "Total winner is " + gameController.endGame()+". Count rounds : "+ countPlayerGame;
            logger.info(totalInfo);
            result.info(totalInfo);

            logger.info("Do you want play again ? ");
            endGame = scanner.nextLine().charAt(0) + "";
        } while (!endGame.equalsIgnoreCase("n"));
        logger.info("See you later^_^");
    }
}
