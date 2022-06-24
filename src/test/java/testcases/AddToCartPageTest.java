package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCart;

import java.io.IOException;
import java.time.Duration;

public class AddToCartPageTest {
    WebDriver driver;
    AddToCart addToCart;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/AddtoCartReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DESKTOP-BL7IB8U");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("UserName", "Sunita Shakya");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Addtocart test");
        htmlReporter.config().setReportName("AddtoCart report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1)
    public void verifyProductPrices() throws InterruptedException {
        test = extent.createTest("verify product", "Test Passed");
        addToCart = new AddToCart(driver);
        addToCart.clickonproduct();
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void addProductToCart() throws InterruptedException {
        test = extent.createTest("Add product to the cart", "Test Passed");

        addToCart = new AddToCart(driver);
        Thread.sleep(3000);
        addToCart.productionDescription();
        Thread.sleep(3000);

    }
    @Test(priority=3)
    public void AddQuantity() throws InterruptedException {
        test = extent.createTest("Add Quanity", "Test Passed");
        addToCart.clickPageBox();
        addToCart.clickOnAddToCart();
        Thread.sleep(5000);

    }

    @Test(priority=4)
    public void refreshpage() throws InterruptedException {
        test = extent.createTest("RefreshPage", "Test Passed");
        driver.navigate().refresh();
        Thread.sleep(5000);
        addToCart.AddToCart2();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void UpdateQuantity() throws InterruptedException {
        test = extent.createTest("UpdateQuantity", "Test Passed");
        addToCart.clearCart();
        addToCart.changeQuantity("2");
        Thread.sleep(5000);
        addToCart.updateCart();
        Thread.sleep(5000);

    }

    @Test(priority = 6)
    public void removeItemFromCart() throws InterruptedException {
        test = extent.createTest("Remove Items", "Test Passed");
        addToCart.clearCart();
        Thread.sleep(5000);
        addToCart.changeQuantity("0");
        Thread.sleep(5000);
        addToCart.body();
        Thread.sleep(5000);
        driver.close();

    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }


}
