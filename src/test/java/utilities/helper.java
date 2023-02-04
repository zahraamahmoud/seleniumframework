package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class helper {
    //method to take screenshot when testcase fails
    public static void capturescreenshot(WebDriver driver,String screenshotname) throws IOException {
        Path dest= Paths.get("./screenshots",screenshotname+".png");
        Files.createDirectories(dest.getParent());
        FileOutputStream out=new FileOutputStream(dest.toString());
        TakesScreenshot ts=(TakesScreenshot)driver;
        out.write(ts.getScreenshotAs(OutputType.BYTES));
        out.close();
    }
}
