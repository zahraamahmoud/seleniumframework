package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;

public class jsondatareader {
    public String lname,fname,email,password;

    public void jsonReader() throws IOException, ParseException {

        String filepath=System.getProperty("user.dir")+"/src/test/java/data/userdata.json";
        File sourcefile=new File(filepath);
        JSONParser parser=new JSONParser();
        JSONArray jarray=(JSONArray) parser.parse(new FileReader(sourcefile));
        for(Object jsonob:jarray){
           JSONObject person=(JSONObject) jsonob;
            fname=(String) person.get( "frstname");
            lname=(String) person.get( "lastname");
            email=(String) person.get( "email");
            password=(String) person.get( "password");


        }

    }
}
