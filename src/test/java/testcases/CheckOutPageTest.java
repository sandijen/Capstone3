package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import library.SelectBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddToCart;
import pages.CheckOutPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CheckOutPageTest {
    WebDriver driver;
    CheckOutPage checkOutPage;


    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setupReport() {

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Checkoutreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", " ray.home-server.local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("UserName", "Sunita Shakya");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Check out");
        htmlReporter.config().setReportName("Check out");
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
    public void givepaymentoption() throws InterruptedException {
        test = extent.createTest("give payment option", "Test Passed");

        checkOutPage =  new CheckOutPage(driver);
        checkOutPage.paymentsection();
        Thread.sleep(3000);
        checkOutPage.addtothecartoncheckout();
        Thread.sleep(3000);
        checkOutPage.addcartcheckout();
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void paymentForm() throws InterruptedException, IOException {
        test = extent.createTest("creditcard  testcase", "Test Passed");

        checkOutPage.InvalidPayment();
        Thread.sleep(5000);
        checkOutPage.FirstNameLastName();
        Thread.sleep(5000);
        checkOutPage.AddressInfo();
        Thread.sleep(10000);
        checkOutPage.paymentInfo();
        Thread.sleep(3000);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/ScreenShot/Checkout.png"));

        driver.close();
    }

    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }

}