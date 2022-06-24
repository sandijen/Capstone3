package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {
    WebDriver driver;
    By BabyGear= By.xpath("//a[@id='navigation-baby-gears']");

    By productBook= By.xpath("//a[contains(text(),'Velcro Enlightenment Busy Book Toys')]");

    By productpage= By.xpath("//label[contains(text(),'15PAGES')]");

    By addtocartbutton= By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]");

    By openaddtocart= By.xpath("//a[contains(text(),'View cart')]");

    By changequantity= By.xpath("//input[@id='updates_41195469897781']");

    By clearquantity=By.xpath("//input[@id='updates_41195469897781']");
    By topcartfield= By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]/span[1]");

    By updatecartbutton= By.xpath("//body/div[@id='keyboard-nav-3']/div[@id='shopify-section-cart']/section[1]/form[1]/div[1]/div[1]/div[2]/input[1]");

    By backtoaddcartbutton= By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]");

    By cleartozero= By.xpath("//input[@id='updates_41195469897781']");

    By checkoutfield=By.xpath("//span[contains(text(),'Checkout')]");

    By giftcardfield= By.cssSelector("#checkout_reduction_code");

    By applygiftcardfield= By.xpath("//button[@id='checkout_submit']");

    By bodyfield= By.cssSelector("body");


    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }



    public void clickonproduct()
    {
        driver.findElement(BabyGear).click();
    }

    public void productionDescription()
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
    public void AddToCart2()
    {
        driver.findElement(topcartfield).click();
    }

    public void openAddtoCart()
    {
        driver.findElement(openaddtocart).click();
    }



    public void clearCart()
    {
        driver.findElement(clearquantity).clear();
    }
    public void changeQuantity(String arg)
    {
        driver.findElement(clearquantity).sendKeys(arg);
    }

    public void updateCart()

    {
        driver.findElement(updatecartbutton).click();
    }

    public void clickquantity()
    {
        driver.findElement(cleartozero).click();
    }

    public void clickoncheckout()
    {
        driver.findElement(checkoutfield).click();
    }

    public void inputgiftcardinfo(String arg)
    {
        driver.findElement(giftcardfield).sendKeys(arg);
    }

    public void clickonapplygiftcard()
    {
        driver.findElement(applygiftcardfield).click();
    }

    public void body()
    {
        driver.findElement(bodyfield).click();
    }


}
