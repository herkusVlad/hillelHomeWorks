package Service;

import java.io.File;
import java.io.IOException;

public interface FileWorker {
    boolean isCreated();
    boolean write(String data);

    boolean create(String fileName);
}
