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
import pages.GiftCardPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GiftCardPageTest {
    WebDriver driver;
    GiftCardPage giftCardPage;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;



    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/GiftCard.html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DESKTOP-BL7IB8U");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sunita Shakya");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle(" report");
        htmlReporter.config().setReportName("Google Search and Download Pictures Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @BeforeTest
    public void launchBrowser() {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }
        @Test
                public void ApplyGiftCard() throws InterruptedException, IOException {
            test = extent.createTest("giftcard validation testcase", "Test Passed");
            giftCardPage= new GiftCardPage(driver);
            giftCardPage.clickonproduct();
            Thread.sleep(5000);
            giftCardPage.productDescription();
            Thread.sleep(5000);
            giftCardPage.clickPageBox();
            Thread.sleep(5000);
            giftCardPage.clickOnAddToCart();
            Thread.sleep(5000);
            giftCardPage.AddToCart2();

            giftCardPage.clickCheckOut();
            Thread.sleep(10000);
            giftCardPage.inputDiscountCode("SAVE");
            giftCardPage.clickSubmitButton();
            Thread.sleep(5000);

            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/test/resources/Screenshot/GiftCARD.png"));
            driver.close();
        }
    @AfterSuite
    public void tearDown()
    {
        extent.flush();


        }}


