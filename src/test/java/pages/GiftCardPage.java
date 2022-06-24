package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCardPage {

        WebDriver driver;
    By BabyGear= By.xpath("//a[@id='navigation-baby-gears']");
    By productBook= By.xpath("//a[contains(text(),'Velcro Enlightenment Busy Book Toys')]");

    By productpage= By.xpath("//label[contains(text(),'15PAGES')]");

    By addtocartbutton= By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]");

    By openaddtocart= By.xpath("//a[contains(text(),'View cart')]");
    By checkoutfield=By.xpath("//span[contains(text(),'Checkout')]");
    By topcartfield= By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]/span[1]");
    By DiscountCode=By.cssSelector("#checkout_reduction_code");
    By SubmitButton= By.xpath("//button[@id='checkout_submit']");
    public GiftCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickonproduct()
    {
        driver.findElement(BabyGear).click();
    }

    public void productDescription()
    {
        driver.findElement(productBook).click();
    }

    public void clickPageBox()
    {
        driver.findElement(productpage).click();
    }

    public void clickOnAddToCart()
    {
        driver.findElement(addtocartbutton).click();
    }
    public void clickCheckOut()
    {
        driver.findElement(checkoutfield).click();
    }
    public void AddToCart2()
    {
        driver.findElement(topcartfield).click();
    }
    public void inputDiscountCode(String arg) {driver.findElement(DiscountCode).sendKeys(arg);}
public void clickSubmitButton (){driver.findElement(SubmitButton);
    }}


