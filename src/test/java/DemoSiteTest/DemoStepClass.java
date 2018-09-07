package DemoSiteTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class DemoStepClass {


    WebDriver myWebDriver;

    HomePage homePage = PageFactory.initElements(myWebDriver, HomePage.class);
    AddUser addUser = PageFactory.initElements(myWebDriver, AddUser.class);
    LoginUser loginUser = PageFactory.initElements(myWebDriver, LoginUser.class);
    static ExtentReports extent;
    static ExtentTest test;



    @Before
    public void setUp(String DemoSiteTest){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Liam\\Desktop\\chromedriver.exe");
        myWebDriver = new ChromeDriver();
        myWebDriver.manage().window().maximize();
        String url = "http://thedemosite.co.uk/index.php";
        myWebDriver.get(url);
        extent= new ExtentReports("C:\\Users\\Admin\\Desktop\\extentAssessLogin.html", true);
        test = extent.startTest(DemoSiteTest);

        try{
            assertEquals("http://thedemosite.co.uk/index.php", myWebDriver.getCurrentUrl());
            test.log(LogStatus.PASS, "Web page loaded correctly");
        } catch (AssertionError e){
            test.log(LogStatus.FAIL, "Unable to load index page");
        }

    }

    @Given("^the Add User Tab$")
    public void the_Add_User_Tab() {
        // Write code here that turns the phrase above into concrete actions

        homePage.clickAddUser(myWebDriver);

        try{
            assertEquals("http://thedemosite.co.uk/addauser.php", myWebDriver.getCurrentUrl());
            test.log(LogStatus.PASS, "User creation page loaded");
        } catch (AssertionError e){
            test.log(LogStatus.FAIL, "unable to load user creation page");
        }

    }

    @When("^I fill out new login details$")
    public void i_fill_out_new_login_details() throws Throwable {
        addUser.inputNewUser();
    }

    @When("^I click save$")
    public void i_click_save() throws Throwable {
        addUser.clickSave();
    }

    @When("^I go to the Login Tab$")public void i_go_to_the_Login_Tab() throws Throwable {

        addUser.clickLoginTab();

    }

    @Then("^I can login with the new account$")
    public void i_can_login_with_the_new_account() throws Throwable {

        loginUser.inputNewUser();
        loginUser.clickLogin();
        try {
            assertEquals("**Successful Login**", loginUser.successMessage());
            test.log(LogStatus.PASS, "new user successfully logged in");
        }catch (AssertionError e){
            test.log(LogStatus.FAIL, "unable to log in with new user");
        }
    }
}
