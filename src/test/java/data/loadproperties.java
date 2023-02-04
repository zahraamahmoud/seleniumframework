package data;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadproperties {
    //read properities from the folder
  public static Properties userdata=loadproperties(System.getProperty("user.dir")+"/src/test/java/properties/userdata.properties");

  private static @NotNull Properties loadproperties(String path){
      Properties pro=new Properties();
      // stream for reading the file
        try {
            FileInputStream stream=new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("error ocurred"+e.getMessage());
           // throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("error ocurred"+e.getMessage());
            //throw new RuntimeException(e);
        }
        return pro;
    }



}
