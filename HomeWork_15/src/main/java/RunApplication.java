import DTO.Computer;
import DTO.GameResult;
import DTO.Player;
import Service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RunApplication {
    private static final Logger logger = LoggerFactory.getLogger("stdout");
    private static final Logger liveCycle = LoggerFactory.getLogger("live");
    private static final Logger result = LoggerFactory.getLogger("result");

    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        Locale defLocale = new Locale("ua");
        if (args.length != 0) {
            defLocale = new Locale(args[0]);
        }

        ResourceBundle
                resourceBundle = ResourceBundle.getBundle("messages", defLocale);

        GameController gameController = new GameControllerImpl(player, computer,resourceBundle);
        Scanner scanner = new Scanner(System.in);
        logger.info(resourceBundle.getString("hello"));
        player.setName(scanner.nextLine());

        DataConverter dataConverter = new DataConverterImpl();
        logger.info(resourceBundle.getString("name").concat(player.getName()));
        int countGame = 0;
        String endGame = "y";
        String countPlayerGame = "";
        do {
            logger.info(resourceBundle.getString("count_game"));
            countGame = scanner.nextInt();
            countPlayerGame = String.valueOf(countGame);
            gameController.startGame();
            do {
                String value = "1";
                GameResult roundWinner;

                logger.info(resourceBundle.getString("value"));
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

                String roundInfo = resourceBundle.getString("win_step_first") + player.getCountGame() +
                        resourceBundle.getString("win_step_second") + roundWinner;
                logger.info(roundInfo);
                liveCycle.info(roundInfo);
                countGame--;
            } while (countGame > 0);
            String totalInfo = resourceBundle.getString("total_win_first") + gameController.endGame()+
                    resourceBundle.getString("total_win_second")+ countPlayerGame;
            logger.info(totalInfo);
            result.info(totalInfo);

            logger.info(resourceBundle.getString("play_again"));
            endGame = scanner.nextLine().charAt(0) + "";
        } while (!endGame.equalsIgnoreCase("n"));
        logger.info(resourceBundle.getString("bye"));
    }
}
