package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CheckOutPage {
    WebDriver driver;


    By shopboxfield = By.xpath("//a[@id='navigation-shop']");
    By bookField= By.xpath("//a[contains(text(),'Elephant Opposites Early Education Cloth Book')]");

    By addcartbox = By.xpath("//body[1]/div[3]/div[1]/section[1]/div[1]/div[2]/div[1]/form[1]/div[4]/input[1]");


    By topcartbox = By.xpath("//header/div[1]/div[1]/div[2]/div[2]/a[1]");

    By chckoutbox = By.xpath("//span[contains(text(),'Checkout')]");

    By emailfieldcheckout = By.cssSelector("#checkout_email");

    By continuetoshoppingbutton = By.cssSelector("#continue_button");

    By firstnamefield = By.id("checkout_shipping_address_first_name");

    By lastnamefield = By.id("checkout_shipping_address_last_name");

    By addressfield = By.xpath("//input[@id='checkout_shipping_address_address1']");

    By cityfield = By.xpath("//input[@id='checkout_shipping_address_city']");

    By zipzodefield = By.xpath("//input[@id='checkout_shipping_address_zip']");

    By phonenumberfield = By.id("checkout_shipping_address_phone");

    By continuetopaymentfield= By.id("continue_button");

    By paynowfield=By.cssSelector("#continue_button");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void paymentsection() {
        driver.findElement(shopboxfield).click();
        driver.findElement(bookField).click();


    }
    public void addtothecartoncheckout() {

        driver.findElement(addcartbox).click();
    }
    public void addcartcheckout() {

        driver.findElement(topcartbox).click();
        driver.findElement(chckoutbox).click();
    }
    public void InvalidPayment() {
        driver.findElement(emailfieldcheckout).sendKeys("sunitashakya@rocketmail.com");

    }
    public void FirstNameLastName() {
        driver.findElement(firstnamefield).sendKeys("sunita");
        driver.findElement(lastnamefield).sendKeys("shakya");
        driver.findElement(addressfield).sendKeys("260 monares ln");
    }

    public void AddressInfo()
    {
        driver.findElement(cityfield).sendKeys("erie");
        driver.findElement(zipzodefield).sendKeys("80516");
        driver.findElement(phonenumberfield).sendKeys("7201231234");
        driver.findElement(continuetoshoppingbutton).click();
    }

    public void paymentInfo()
    {
        driver.findElement(continuetopaymentfield).click();
        driver.findElement(paynowfield).click();
    }


}
