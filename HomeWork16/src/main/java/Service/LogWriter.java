package Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class LogWriter {
    private File file;
    private Path path;

    public LogWriter() {
        path = Paths.get("").toAbsolutePath();
    }

    ;

    public LogWriter(String path) {
        this();
        if (!Objects.isNull(path) && !path.isEmpty()) {
            this.path = Paths.get(path).toAbsolutePath();
        }
    }

    public void write(String name, String newName, String time, String size, String newSize) {
        if (isCreated()) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(name + " -> " + newName + ", " + time + ", " + size + " -> " + newSize + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String name) {
        if (isCreated()) {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("File " + name + " not written\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isCreated() {
        File file = new File(path.toString(), "result.log");
        if (!Objects.isNull(this.file) && file.exists() && file.getName().contains("result.log")) {
            return true;
        }
        return createFile();
    }

    private boolean createFile() {
        try {
            file = new File(path.toString(), "result.log");
            file.createNewFile();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
