package Service;

import DTO.Computer;
import DTO.GameItem;
import DTO.GameResult;
import DTO.Player;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.ResourceBundle;

@Data
public class GameControllerImpl implements GameController{
    private Player player;
    private Computer computer;
    private GameResult winner;

    private ResourceBundle bundle;
    private static final Logger liveCycle = LoggerFactory.getLogger("live");
    private static final Logger logger = LoggerFactory.getLogger("stdout");

    public GameControllerImpl(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public GameControllerImpl(Player player, Computer computer, ResourceBundle bundle) {
        this.player = player;
        this.computer = computer;
        this.bundle = bundle;
    }

    public void startGame() {
        logger.info(bundle.getString("game_start"));
        liveCycle.info(bundle.getString("game_start"));
        logger.info(bundle.getString("game_info"));
        player.setCountGame(0);
        player.setCountWinGame(0);
        player.setCountLoseGame(0);
    }

    public GameResult winner() {
        winner = GameResult.COMPUTER;
        GameItem cItem = computer.getItem();
        logger.info(bundle.getString("com_value") + cItem);
        liveCycle.info(bundle.getString("com_value") + cItem);
        liveCycle.info(bundle.getString("player_value") + player.getItem());
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

    public GameResult endGame() {
        GameResult result = GameResult.DRAW;
        if(player.getCountWinGame() > player.getCountLoseGame()){
            result =  GameResult.PLAYER;
        }else if(player.getCountWinGame() < player.getCountLoseGame()){
            result = GameResult.COMPUTER;
        }else{
            result = GameResult.DRAW;
        }
        return result;
    }

    @Override
    public GameResult endRound() {
        player.setCountGame(player.getCountGame()+1);
        if(winner == GameResult.PLAYER){
            player.setCountWinGame(player.getCountWinGame()+1);
        }else if(winner == GameResult.COMPUTER){
            player.setCountLoseGame(player.getCountLoseGame()+1);
        }
        return winner;
    }
}
