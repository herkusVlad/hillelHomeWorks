package Service;

import DTO.GameItem;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.Objects;

@Data
public class DataConverterImpl implements DataConverter{
    private static final Logger error = LoggerFactory.getLogger("error");
    @Override
    public GameItem convert(String str) {
        if(Objects.isNull(str) || str.isEmpty()){
            error.error("Not correct value.");
            throw new GameError("Not correct value.");
        }
        str = str.toLowerCase(Locale.ROOT);
        if(GameItem.PAPER.toString().startsWith(str) && GameItem.PAPER.toString().contains(str)){
            return GameItem.PAPER;
        }else if (GameItem.ROCK.toString().startsWith(str) && GameItem.ROCK.toString().contains(str)){
            return GameItem.ROCK;
        }else if(GameItem.SCISSORS.toString().startsWith(str) && GameItem.SCISSORS.toString().contains(str)){
            return GameItem.SCISSORS;
        }

        error.error("Not correct value.");
        throw new GameError("Not correct value.");
    }
}
