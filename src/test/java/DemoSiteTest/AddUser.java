package DemoSiteTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {



    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    WebElement userNameInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    WebElement passwordInput;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    WebElement saveButton;

    @FindBy(xpath ="/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    WebElement loginTab;

Excel excel = new Excel();

    public void inputNewUser(){


        userNameInput.click();
        userNameInput.sendKeys(excel.username.getStringCellValue());

        passwordInput.click();
        passwordInput.sendKeys(excel.password.getStringCellValue());

    }

    public void clickSave(){
        saveButton.click();
    }

    public void clickLoginTab(){
        loginTab.click();
    }






}
