package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
    static WebDriver driver;
    By AccountField = By.id("customer_login_link");
    By RegisterField = By.xpath("//a[contains(text(),'Register')]");
    By Firstname= By.id("ispbxii_1");
    By LastName= By.id("ispbxii_2");

    By Password= By.name("customer[password]");
   //
   // By SignUpRegister = By.xpath("//*[@id=\"create_customer\"]/div[5]/input");
    By SignUpRegister = By.xpath("/html/body/div[3]/div[2]/form/div[5]/input");
     By errorMessage = By.id("errMsg");
    By loginButton= By.xpath("/html/body/div[3]/div[2]/div[1]/form/div[3]/input");
    By LoginEmail= By.name("customer[email]");






    public Registration(WebDriver driver) {this.driver = driver;    }
    public void clickAccount(){driver.findElement(AccountField).click();    }

    public void clickRegister(){driver.findElement(RegisterField).click();}

    public void inputFirstName(String arg){driver.findElement(Firstname).sendKeys(arg);}
    public void inputLastName(String arg){driver.findElement(LastName).sendKeys(arg);}
    public void inputEmailId(String arg){driver.findElement(LoginEmail).sendKeys(arg);}
    public void inputPassword(String arg){driver.findElement(Password).sendKeys(arg);}
    public void ClickSignUpRegister(){driver.findElement(SignUpRegister).click();}

    public String getErrorMessage()
    {
        return  driver.findElement(errorMessage).getText();
    }
     public void clickLoginButton(){driver.findElement(loginButton).click();}}


