import DTO.Computer;
import DTO.Player;
import Service.DataConverter;
import Service.DataConverterImpl;
import Service.GameController;
import Service.GameControllerImpl;

import java.util.Locale;
import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        Player player = new Player();
        Computer computer = new Computer();

        GameController gameController = new GameControllerImpl(player,computer);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, enter your name : ");
        player.setName(scanner.nextLine());

        DataConverter dataConverter = new DataConverterImpl();
        int countGame = 0;
        String endGame = "y";
        do{
            System.out.print("How many game are you want play?");
            countGame = scanner.nextInt();

            gameController.startGame();
            do{
                String value = "1";
                System.out.print("Enter your value : ");
                value = scanner.nextLine();
                if(value.isEmpty()){
                    value =  scanner.nextLine();
                }
                if(value.toLowerCase(Locale.ROOT).equals("stop")){
                    break;
                }
                player.setGameItem(dataConverter.convert(value));
                gameController.winner();
                gameController.endRound();
                countGame--;
            }while(countGame>0);
            gameController.endGame();

            System.out.println("Do you want play again ? ");
            endGame = scanner.nextLine().charAt(0)+"";
        }while (!endGame.equalsIgnoreCase("n"));
        System.out.println("See you later^_^");
    }
}
