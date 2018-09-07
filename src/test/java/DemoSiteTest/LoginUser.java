package DemoSiteTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUser {



    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
    WebElement userNameInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
    WebElement passwordInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
    WebElement loginButton;

    @FindBy(xpath ="/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
    WebElement successMessage;

Excel excel = new Excel();

    public void inputNewUser(){


        userNameInput.click();
        userNameInput.sendKeys(excel.username.getStringCellValue());

        passwordInput.click();
        passwordInput.sendKeys(excel.password.getStringCellValue());

    }

    public void clickLogin(){
        loginButton.click();
    }

    public String successMessage (){
       return successMessage.getText();
    }






}
