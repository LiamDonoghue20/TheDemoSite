package DemoSiteTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

        WebDriver myWebDriver;
        WebDriverWait wait = new WebDriverWait(myWebDriver, 10);

        @FindBy(linkText = "3. Add a User")
        WebElement addUserTab;



        public HomePage(WebDriver myWebDriver){

            this.myWebDriver = myWebDriver;

        }


        public void clickAddUser(WebDriver myWebDriver){
            Actions action = new Actions(myWebDriver);

            wait.until(ExpectedConditions.visibilityOf(addUserTab));
                action.click(addUserTab);
        }


}
