package WebUI_Contains_All_Info_WebDriver;
//This class is Base for every testcases
//All basic things are done here

import Utils.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import extent__generate_report.ExtentManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages_page_object_model.AdmnPageObject;
import pages_page_object_model.loginPageObjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class TestBase {

    public ReadConfig config;
    public static WebDriver driver;
    public ExtentReports reports;
    public ExtentTest test;
    AdmnPageObject admnPageObject;
    pages_page_object_model.loginPageObjects loginPageObjects;

    @AfterSuite
    public void tearDown() {
        flushReports();
        driver.quit();
    }

    @BeforeClass
    public void launchBrowser(){
        config = new ReadConfig();
        /*ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/

        String selectedBrowser ="Chrome";

        // Instantiate the appropriate WebDriver based on the selected browser

        if ("Chrome".equals(selectedBrowser)) {
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("Edge".equals(selectedBrowser)) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser selected: " + selectedBrowser);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(config.getUrl());
        //for zoom out(80%)
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String zoomJS = "document.body.style.zoom='80.0%'";
        js.executeScript(zoomJS);
        admnPageObject = new AdmnPageObject(driver);
        loginPageObjects = new loginPageObjects(driver);
    }

    @AfterClass
    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void  Login() throws IOException {
        loginPageObjects.sendUserID(config.getuserID());
        loginPageObjects.sendPassword(config.getPassword());
        loginPageObjects.clickLoginwithPassword();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException {
        if (result.getStatus() == 2) {
            System.out.println(" Test failled info : " + result.getThrowable().getMessage());
            try {
                String errorMsg = result.getThrowable().getMessage();

                if (errorMsg.trim().contains("expected")) {
                    errorMsg = errorMsg.trim().split("expected")[0].trim();
                }
                reportFailure(errorMsg);
            } catch (NullPointerException e) {
            }
        }
        Thread.sleep(4000);
        admnPageObject.logout();

    }

    public void flushReports() {
        if (reports != null) {
            reports.flush();
        }
    }

    public void initReports(String scenarioName) {
        reports = ExtentManager.getInstance(System.getProperty("user.dir"));
        test = reports.createTest(scenarioName);
        test.log(Status.INFO, "Starting Test : " + scenarioName);
    }

    public void reportFailure(String errorMsg) {
         takeScreenshot(errorMsg);
    }
    public void infoLog(String msg) {
        test.log(Status.INFO, msg);
    }
    public void stepPass(String msg) throws IOException {
        takeScreenshotForInfo(msg);
    }
    public void stepSkip(String msg) throws IOException {
        test.log(Status.SKIP, msg);
        takeScreenshotForInfo();
    }
    public void takeScreenshot(String errorLog) {
        Date date = new Date();
        String screenshotFile = date.toString().replaceAll(":","_").replaceAll(" ","_")+".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
            InputStream in = new FileInputStream(ExtentManager.screenshotFolderPath + screenshotFile);
            byte[] imageBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            test.log(Status.FAIL,errorLog, MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshotForInfo(String infoMsg) throws IOException {
        Date date = new Date();
        String screenshotFile = date.toString().replaceAll(":","_").replaceAll(" ","_")+".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
            InputStream in = new FileInputStream(ExtentManager.screenshotFolderPath + screenshotFile);
            byte[] imageBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            test.log(Status.PASS,infoMsg, MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void takeScreenshotForInfo() throws IOException {

        Date date = new Date();
        String screenshotFile = date.toString().replaceAll(":","_").replaceAll(" ","_")+".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
            InputStream in = new FileInputStream(ExtentManager.screenshotFolderPath + screenshotFile);
            byte[] imageBytes = IOUtils.toByteArray(in);
            String base64 = Base64.getEncoder().encodeToString(imageBytes);
            test.log(Status.PASS,"", MediaEntityBuilder.createScreenCaptureFromBase64String("data:image/png;base64,"+base64).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
