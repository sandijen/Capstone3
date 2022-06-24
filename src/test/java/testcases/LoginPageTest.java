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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Registration;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LoginPageTest {

    WebDriver driver;
    Registration registration1;

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Report/LoginReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "DESKTOP-BL7IB8U");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Sunita Shakya");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Login Page");
        htmlReporter.config().setReportName("Login Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);

    }

    @BeforeTest
    public void launchBrowser() throws IOException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        driver.get("https://www.alexandnova.com/");
    }
        @Test(priority = 7)

    public void Positive_login() throws IOException, InterruptedException {
            test = extent.createTest("valid user id testcase", "Test Passed");
        registration1 = new Registration(driver);
            registration1.clickAccount();
            Thread.sleep(3000);
            registration1.inputEmailId("sunitashakya@rocketmail.com");
            registration1.inputPassword("1234567");
            Thread.sleep(3000);
            registration1.clickLoginButton();
            Thread.sleep(3000);


            driver.close();
    }
    @Test(priority = 6)

    public void Login_With_Wrong_Password() throws IOException, InterruptedException {
        test = extent.createTest("wrong password user id testcase", "Test Passed");
        registration1 = new Registration(driver);
        registration1.clickAccount();
        Thread.sleep(5000);
        registration1.inputEmailId("sunita@rocketmail.com");
        registration1.inputPassword("1234");

        Thread.sleep(5000);
        registration1.clickLoginButton();
        Thread.sleep(5000);

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/test/resources/Screenshot/Login.png"));

        String actualmessage=registration1.getErrorMessage();
        String expected = "Sorry! Please try that again.";
        Assert.assertEquals(expected,actualmessage);

    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }
}










