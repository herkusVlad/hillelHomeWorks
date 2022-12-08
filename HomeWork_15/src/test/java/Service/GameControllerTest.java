package Service;

import DTO.GameItem;
import DTO.GameResult;
import DTO.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameControllerTest {

    @Test
    public void computerWin(){
        GameResult resultScis = new GameController.FakeController(
                new Player().setGameItem(GameItem.PAPER),
                GameItem.SCISSORS).winner();
        GameResult resultPaper = new GameController.FakeController(
                new Player().setGameItem(GameItem.ROCK),
                GameItem.PAPER).winner();
        GameResult resultRock = new GameController.FakeController(
                new Player().setGameItem(GameItem.SCISSORS),
                GameItem.ROCK).winner();

        Assertions.assertTrue(GameResult.COMPUTER == resultScis);
        Assertions.assertTrue(GameResult.COMPUTER == resultPaper);
        Assertions.assertTrue(GameResult.COMPUTER == resultRock);
    }

    @Test
    public void playerWin(){
        GameResult resultScis = new GameController.FakeController(
                new Player().setGameItem(GameItem.SCISSORS),
                GameItem.PAPER).winner();
        GameResult resultPaper = new GameController.FakeController(
                new Player().setGameItem(GameItem.PAPER),
                GameItem.ROCK).winner();
        GameResult resultRock = new GameController.FakeController(
                new Player().setGameItem(GameItem.ROCK),
                GameItem.SCISSORS).winner();

        Assertions.assertTrue(GameResult.PLAYER == resultScis);
        Assertions.assertTrue(GameResult.PLAYER == resultPaper);
        Assertions.assertTrue(GameResult.PLAYER == resultRock);
    }

    @Test
    public void draw(){
        GameResult resultScis = new GameController.FakeController(
                new Player().setGameItem(GameItem.SCISSORS),
                GameItem.SCISSORS).winner();
        GameResult resultPaper = new GameController.FakeController(
                new Player().setGameItem(GameItem.PAPER),
                GameItem.PAPER).winner();
        GameResult resultRock = new GameController.FakeController(
                new Player().setGameItem(GameItem.ROCK),
                GameItem.ROCK).winner();

        Assertions.assertTrue(GameResult.DRAW == resultScis);
        Assertions.assertTrue(GameResult.DRAW == resultPaper);
        Assertions.assertTrue(GameResult.DRAW == resultRock);
    }

    @Test
    public void computerLose(){
        GameResult resultScis = new GameController.FakeController(
                new Player().setGameItem(GameItem.SCISSORS),
                GameItem.PAPER).winner();
        GameResult resultPaper = new GameController.FakeController(
                new Player().setGameItem(GameItem.PAPER),
                GameItem.ROCK).winner();
        GameResult resultRock = new GameController.FakeController(
                new Player().setGameItem(GameItem.ROCK),
                GameItem.SCISSORS).winner();

        Assertions.assertFalse(GameResult.COMPUTER == resultScis);
        Assertions.assertFalse(GameResult.COMPUTER == resultPaper);
        Assertions.assertFalse(GameResult.COMPUTER == resultRock);
    }

    @Test
    public void playerLose(){
        GameResult resultScis = new GameController.FakeController(
                new Player().setGameItem(GameItem.PAPER),
                GameItem.SCISSORS).winner();
        GameResult resultPaper = new GameController.FakeController(
                new Player().setGameItem(GameItem.ROCK),
                GameItem.PAPER).winner();
        GameResult resultRock = new GameController.FakeController(
                new Player().setGameItem(GameItem.SCISSORS),
                GameItem.ROCK).winner();

        Assertions.assertFalse(GameResult.PLAYER == resultScis);
        Assertions.assertFalse(GameResult.PLAYER == resultPaper);
        Assertions.assertFalse(GameResult.PLAYER == resultRock);
    }
}