package Service;

import DTO.Computer;
import DTO.GameItem;
import DTO.GameResult;
import DTO.Player;
import lombok.Data;

@Data
public class GameControllerImpl implements GameController{
    private Player player;
    private Computer computer;
    private GameResult winner;

    public GameControllerImpl(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void startGame() {
        System.out.println("Game is started! Good luck!");
        System.out.println("If you will want end game enter: stop");
        System.out.println("You can type value in short style. Paper = p, Scissors = s, Rock = r");
        player.setCountGame(0);
        player.setCountWinGame(0);
        player.setCountLoseGame(0);
    }

    public GameResult winner() {
        winner = GameResult.COMPUTER;
        GameItem cItem = computer.getItem();
        System.out.println("Computer value : " + cItem);
        if(player.getItem() == cItem){
            winner = GameResult.DRAW;
            return winner;
        }
        if(player.getItem() == GameItem.PAPER && cItem == GameItem.ROCK){
             winner = GameResult.PLAYER;
        }else if(player.getItem() == GameItem.ROCK && cItem == GameItem.SCISSORS){
            winner = GameResult.PLAYER;
        }else if(player.getItem() == GameItem.SCISSORS && cItem == GameItem.PAPER){
            winner = GameResult.PLAYER;
        }
        return winner;
    }

    public void endGame() {
        if(player.getCountWinGame() > player.getCountLoseGame()){
            System.out.println("Total winner is " + GameResult.PLAYER);
        }else if(player.getCountWinGame() < player.getCountLoseGame()){
            System.out.println("Total winner is " + GameResult.COMPUTER);
        }else{
            System.out.println("Total winner is " + GameResult.DRAW);
        }
        System.out.println();
    }

    @Override
    public void endRound() {
        player.setCountGame(player.getCountGame()+1);
        if(winner == GameResult.PLAYER){
            player.setCountWinGame(player.getCountWinGame()+1);
        }else if(winner == GameResult.COMPUTER){
            player.setCountLoseGame(player.getCountLoseGame()+1);
        }
        System.out.println("Win in "+player.getCountGame()+" round is " + winner.toString());
    }
}
