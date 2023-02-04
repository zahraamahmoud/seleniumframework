package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class orderdetailspage extends pagebase{
    public orderdetailspage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Print")
    WebElement printlink;
    @FindBy(linkText = "PDF Invoice")
    WebElement pdflink;
    public void printorderdetails(){
        clickbutton(printlink);
    }
    public void downloadpdf(){
        clickbutton(pdflink);
    }
}
