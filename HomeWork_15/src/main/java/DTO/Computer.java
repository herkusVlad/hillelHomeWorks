package DTO;

import Service.ItemService;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Data
@Accessors(chain = true)
public class Computer implements ItemService {
    private final String name = "BOT";
    private GameItem gameItem;

    public Computer(){
        gameItem = GameItem.ROCK;
    }

    public GameItem getItem() {
        gameItem = randomItem();
        return gameItem;
    }

    private GameItem randomItem(){
        List<GameItem> list = Arrays.asList(GameItem.values());
        Collections.shuffle(list);
        return list.get(new Random().nextInt(3));
    }
}
