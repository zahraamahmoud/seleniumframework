package tests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.helper;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class testbase extends AbstractTestNGCucumberTests
{
    public static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + "\\downloads";
    public static ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        return options;
    }

    @BeforeSuite
   @Parameters({"browser"})


   public void startdriver(@Optional("chrome") String browsername)
    {
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            driver = new ChromeDriver(chromeOption());
        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("edge")) {
            driver=new EdgeDriver();

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
    }
    @AfterMethod
    public void screenshotonfailure(ITestResult res) throws IOException {
       if(res.getStatus()==ITestResult.FAILURE){

           System.out.println("failed");
           System.out.println("taking screenshot.......");
           helper.capturescreenshot(driver, res.getName());
       }

    }

    @AfterSuite
    public void stopdriver(){

       driver.quit();
    }

}
