package pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class pagebase {

    protected WebDriver driver;
    //create constructor
    public JavascriptExecutor jse;
    public Actions action;

    public pagebase(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    protected static void clickbutton(@NotNull WebElement button)
    {
        button.click();
    }
    protected static void settext(@NotNull WebElement txtelement, String value)
    {
      txtelement.sendKeys(value);
    }
    protected static void cleartxt(@NotNull WebElement txt)
    {
       txt.clear();
    }

    public void scrolltoproductpart(){
        jse.executeScript("scrollBy(0,1080)");

    }
    public void scrolltobottom(){
        jse.executeScript("scrollBy(0,2500)");

    }

}



