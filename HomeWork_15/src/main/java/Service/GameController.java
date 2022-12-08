package Service;

import DTO.Computer;
import DTO.GameItem;
import DTO.GameResult;
import DTO.Player;

public interface GameController {
    void startGame();
    GameResult winner();
    void endGame();

    void endRound();

    final class FakeController implements GameController{

        private Player pFake;
        private GameItem cItem;

        public FakeController(Player player, GameItem gameItem){
            pFake = player;
            cItem = gameItem;
        }
        @Override
        public void startGame() {

        }

        @Override
        public GameResult winner() {
            if(pFake.getItem() == cItem){
                return GameResult.DRAW;
            }
            if(pFake.getItem() == GameItem.PAPER && cItem == GameItem.ROCK){
                return GameResult.PLAYER;
            }else if(pFake.getItem() == GameItem.ROCK && cItem == GameItem.SCISSORS){
                return GameResult.PLAYER;
            }else if(pFake.getItem() == GameItem.SCISSORS && cItem == GameItem.PAPER){
                return GameResult.PLAYER;
            }
            return GameResult.COMPUTER;
        }

        @Override
        public void endGame() {

        }

        @Override
        public void endRound() {

        }
    }
}
