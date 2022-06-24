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

public class RegistrationPageTest {

    WebDriver driver;
    Registration registration1;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;



    @BeforeSuite
    public void setUpReport() {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
         htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/Report.html");
        //htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "C:\\Users\\shakya\\Desktop\\Capstone1\\test-output\\RegistrationReport.html");
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
    public void launchBrowser() throws IOException {
        driver = SelectBrowser.StartBrowser("Chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.alexandnova.com/");
    }

    @Test(priority = 1)
    public void NewUserRegistrationPage() throws InterruptedException {
        test = extent.createTest("New Regisgtration", "Test Passed");
        registration1 = new Registration(driver);
        registration1.clickAccount();
        registration1.clickRegister();
        Thread.sleep(10000);
    }

    @Test(priority = 2)

    public void VerifyRegisterNewUser() throws InterruptedException {
        test = extent.createTest("Verify registration", "Test Passed");
        registration1 = new Registration(driver);
        Thread.sleep(10000);
        registration1.clickAccount();
        registration1.clickRegister();
        Thread.sleep(10000);
        registration1.inputFirstName("sunita");
        registration1.inputLastName("shakya");
        registration1.inputEmailId("sunitashakya@rocketmail.com");
        registration1.inputPassword("1234567");
        Thread.sleep(10000);
        registration1.ClickSignUpRegister();
        Thread.sleep(20000);

    }

    @Test(priority = 3)
    public void EmailValidation() throws IOException, InterruptedException {
        test = extent.createTest("ValidateEmail", "Test Passed");
        registration1 = new Registration(driver);
        Thread.sleep(10000);
        registration1.clickAccount();
        Thread.sleep(10000);
        registration1.clickRegister();
        Thread.sleep(10000);
        registration1.inputFirstName("sunita");
        registration1.inputLastName("shakya");
        registration1.inputEmailId("@rocketmail.com");
        registration1.inputPassword("1234567");
        Thread.sleep(10000);
        registration1.ClickSignUpRegister();
        Thread.sleep(10000);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/Screenshot/RegistrationPage"));
        driver.quit();



    }

    @Test(priority = 4)
    public void Register_without_mandatory_field() throws InterruptedException, IOException {
        test = extent.createTest("InvalidRegistration", "Test Passed");
        registration1 = new Registration(driver);
        registration1.clickAccount();
        Thread.sleep(30000);
        registration1.clickRegister();
        Thread.sleep(30000);
        registration1.ClickSignUpRegister();
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("src/test/resources/Screenshot/InvalidRegistrattion.png"));
    }
    @Test(priority = 5)
    public void PasswordValidation() throws IOException, InterruptedException {
        test = extent.createTest("PassValidation", "Test Passed");
        registration1 = new Registration(driver);
        Thread.sleep(10000);
        registration1.clickAccount();
        Thread.sleep(10000);
        registration1.clickRegister();
        Thread.sleep(10000);
        registration1.inputFirstName("sunita");
        registration1.inputLastName("shakya");
        registration1.inputEmailId("sunitashakya@rocketmail.com");
        registration1.inputPassword("123");
        Thread.sleep(10000);
        registration1.ClickSignUpRegister();
        Thread.sleep(10000);

    String actualmessage= registration1.getErrorMessage();
    String expected = "SorrySorry! Please try that again";
        Assert.assertEquals(expected,actualmessage);


    }
    @AfterSuite

    public void tearDown()
    {
        extent.flush();
    }}









