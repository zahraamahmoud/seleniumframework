package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productreviewpage extends pagebase{
    public productreviewpage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="AddProductReview_Title")
    WebElement reviewtitle;
    @FindBy(id="AddProductReview_ReviewText")
    WebElement reviewtxt;
    @FindBy(id="addproductrating_2")
    WebElement badradiobtn;
    @FindBy(name="add-review")
    WebElement addreviewbtn;
    @FindBy(css="div.result")
    public WebElement successmessage;
    public void addreview(String title,String txt)
    {
      settext(reviewtitle,title);
      settext(reviewtxt,txt);
      clickbutton(badradiobtn);
      clickbutton(addreviewbtn);

    }

}
