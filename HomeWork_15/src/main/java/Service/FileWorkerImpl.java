package Service;

import java.awt.image.ImagingOpException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class FileWorkerImpl implements FileWorker {
    private Path path;
    private File file;

    private String fileName;

    public FileWorkerImpl(String fileName){
        this.fileName = fileName;
    }

    @Override
    public boolean isCreated() {
        String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
        if (!Objects.isNull(file) && file.exists() && file.getName().contains(date)) {
           return true;
        }
        return create(fileName);
    }

    @Override
    public boolean write(String data) {
        System.out.println();
        if(isCreated()){
            try(FileWriter fileWriter = new FileWriter(file,true)){
                fileWriter.write(data);
                fileWriter.close();
                return true;
            } catch (IOException e) {
               return false;
            }
        }
        return false;
    }

    @Override
    public boolean create(String fileName) {
        this.fileName = fileName;
        String nameFile = fileName +"_"+ new SimpleDateFormat("ddMMyyyy").format(new Date()) + ".txt";
        Path getPath = Paths.get("").toAbsolutePath();

        if(Objects.isNull(file)){
            file = new File(getPath.toString(),File.separator.concat(nameFile));
        }
        try{
            file.createNewFile();
            return true;
        }catch (IOException e){
            return false;
        }
    }
}
