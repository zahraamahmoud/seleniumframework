package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.Homepage;
import pages.Userregisterationpage;
import tests.testbase;

public class userregisteration extends testbase {

    Homepage homeobjct;
    Userregisterationpage registerobject;
    Faker fakedata=new Faker();
    String fname=fakedata.name().firstName();
    String lname= fakedata.name().lastName();
    String email=fakedata.internet().emailAddress();
    String pass=fakedata.number().digits(8).toString();

    @Given("user is in the homepage")
    public void user_is_in_the_homepage() {
        homeobjct=new Homepage(driver);
       Assert.assertTrue(homeobjct.registerlink.isDisplayed());

    }
    @When("I click on register link")
    public void i_click_on_register_link() {
        homeobjct=new Homepage(driver);
        homeobjct.openRegisterationpage();
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
    }
    @When("I entered the user data")
    public void i_entered_the_user_data() {
        registerobject=new Userregisterationpage(driver);
        registerobject.userregisteration(fname,lname,email,pass);
    }
   @When("I entered {string},{string},{string},{string}")
   public void i_entered(String fname, String lname, String email, String pass) {
       registerobject=new Userregisterationpage(driver);
       registerobject.userregisteration(fname,lname,email,pass);
   }

    @Then("registeration page displayed successfully")
    public void registeration_page_displayed_successfully() {
        registerobject=new Userregisterationpage(driver);
        Assert.assertTrue(registerobject.successmessage.getText().contains("completed"));
    }

}
