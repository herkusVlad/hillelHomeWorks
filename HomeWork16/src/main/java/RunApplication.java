import Service.FileConverter;
import Service.FileFounder;
import Service.LogWriter;

public class RunApplication {

    public static void main(String[] args){
        String path = args.length == 0 ? "" : args[0];
        FileFounder founder = new FileFounder(path);
        LogWriter writer = new LogWriter(path);
        FileConverter converter = new FileConverter(founder.getFiles(),writer);
        converter.convert();
    }

}
