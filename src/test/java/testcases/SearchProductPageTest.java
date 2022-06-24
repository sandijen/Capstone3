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
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SearchProductPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SearchProductPageTest {
    WebDriver driver;
    SearchProductPage productPage;
    private static ExtentReports extent;

    private static ExtentHtmlReporter htmlReporter;

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
    public void launchBrowser() throws IOException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }
        @Test(priority =8)
        public void Search_without_Entering_Productname() {
            productPage = new SearchProductPage(driver);
            productPage.clickSearchButton();

        }

    @Test(priority =9)
    public void Search_By_Productname() throws IOException, InterruptedException {
        productPage = new SearchProductPage(driver);

        productPage.searchByProductName("baby shoes");
        Thread.sleep(5000);
        productPage.clickSearchButton();
        Thread.sleep(5000);
          Assert.assertEquals("BABY SHOES | Alex + Nova",driver.getTitle());
          Thread.sleep(5000);
          File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(file,new File("src/test/resources/Screenshot/productsearch.png"));

    }}







