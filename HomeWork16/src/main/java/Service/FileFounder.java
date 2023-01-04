package Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FileFounder {
    private String path;
    private HashMap<File,Boolean> files;

    public FileFounder(){
        path = "";
        files = new HashMap<>();
    };

    public FileFounder(String path){
        this();
        this.path = path;
    }

    public HashMap<File,Boolean> getFiles(){
        Path getPath;
        if(path.isEmpty()){
           getPath = Paths.get("").toAbsolutePath();
        }else{
           getPath =  Paths.get(path);
        }
        File directory = new File(getPath.toAbsolutePath().toString());
        File[] files = directory.listFiles();
        Arrays.stream(files).forEach(e->{
            if(e.getName().endsWith(".yaml")){
                this.files.put(e,true);
            }else if(e.getName().endsWith(".json")){
                this.files.put(e,false);
            }
        });
        return this.files;
    }
}
