package Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class FileConverter {
    private HashMap<File,Boolean> files;
    private LogWriter logWriter;
    private String convertFile(File file, boolean toJson) throws IOException {
        InputStream inputStream = Files.newInputStream(file.toPath());
        try{
            if(toJson){
                ObjectMapper yamlReader = new ObjectMapper(new YAMLFactory());
                Object obj = yamlReader.readValue(inputStream, Object.class);

                ObjectMapper jsonWriter = new ObjectMapper();
                return jsonWriter.writeValueAsString(obj);
            }else{
                ObjectMapper jsonReader= new ObjectMapper(new JsonFactory());
                Object obj = jsonReader.readValue(file, Object.class);
                ObjectMapper jsonWriter = new ObjectMapper();
                JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonWriter.writeValueAsString(obj));

                String yaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
                return yaml;
            }

        }catch (Exception e){
            e.printStackTrace();
            return "";
        }finally {
            inputStream.close();
        }
    }

    public void convert(){
        files.forEach((k,v)->{
            File file;
            String data;
            try{
                if(v){
                    file = new File(k.getParent(),File.separator.concat(k.getName().substring(0,k.getName().indexOf('.')) + ".json"));
                }else{
                    file = new File(k.getParent(),File.separator.concat(k.getName().substring(0,k.getName().indexOf('.')) + ".yaml"));
                }

                if(!file.exists()){
                    file.createNewFile();
                    long time = System.currentTimeMillis();
                    data = convertFile(k, v);
                    time = System.currentTimeMillis() - time;

                    FileWriter writer = new FileWriter(file);
                    writer.write(data);
                    writer.close();
                    logWriter.write(k.getName(),file.getName(),time+"ms",
                            Files.size(k.toPath())+"bytes",
                            Files.size(file.toPath())+"bytes");
                }else{
                    logWriter.write(file.getName());
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

}
