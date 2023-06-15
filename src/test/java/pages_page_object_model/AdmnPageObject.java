package pages_page_object_model;

//import jdk.internal.org.jline.utils.OSUtils;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.io.IOException;
import java.time.Duration;
import java.util.Random;

public class AdmnPageObject {
    Random rand = new Random();
    WebDriver driver;
    PageAction pageAction;
    // Actions actions = new Actions(driver);

    public AdmnPageObject(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(rdriver, this);
        pageAction = new PageAction();
    }


    @FindBy(xpath = ("//*[text()='Admin']"))
    static WebElement ADMIN;
    @FindBy(id = ("navbar-nav__admin"))
    static WebElement ADMINmh;

    @FindBy(xpath = ("(//div[contains(@class,'dx-dropdowneditor')]/div[@class='dx-texteditor-container'])[1]"))
    static WebElement client;
    @FindBy(xpath = ("//div[text()='yannis']"))
    static WebElement clientname;

    @FindBy(xpath = "//input[@type='file']")
    static WebElement browseFile;

    @FindBy(xpath = "//*[text()='Apply Mapping']")
    private WebElement applyMapping;


    @FindBy(xpath = "//div[@class='header__profile']")
    private WebElement HeaderProfile;
    @FindBy(xpath = "//a[@aria-label='Logout of user session']")
    private WebElement Logout;


    //div[@class='header__profile']


//input[@type='file']


    public void clickAdmin() {
        Actions action = new Actions(driver);
        action.moveToElement(ADMINmh).perform();
        ADMIN.click();
    }

    public void selectClient() {
        client.click();
        clientname.click();
    }

    public void uploadBrowseFile() throws InterruptedException, IOException {
        Thread.sleep(3000);

        browseFile.sendKeys("C:\\TDC\\MavenTDC\\src\\test\\resources\\testdata_(store_excel_files__contains_datas)\\2021_trade_data_DuplicateRow.csv");

        Thread.sleep(1000);
        applyMapping.click();
        Thread.sleep(5000);
       /* String filePath = "C:\\\\TD-COWEN\\\\CSV_file\\\\2021_trade_data_DuplicateRow.csv";
        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("document.getElementByXpath('//a[@aria-label='Click to browse files on your device']').value='" + filePath + "';");*/

    }


    public void validateFileupload(String OV1, String OV2) throws InterruptedException {
        Thread.sleep(3000);
        WebElement data = driver.findElement(By.xpath("(//table//tbody)[2]//tr[1]"));

        String record = data.getText().trim().replace("\n", "");
        System.out.println("records are ==================>:" + record);

        if (record.contains(OV1) && record.contains(OV2)) {
            WebElement errorRows = driver.findElement(By.xpath("((//table//tbody)[2]//tr[1]/td[5])//button"));
            errorRows.click();
            WebElement checkerrorRowCount = driver.findElement(By.xpath("(//span[@class='wdx-interactive-popover-row__value'])[3]"));
            String errorStrValue = checkerrorRowCount.getText();

            System.out.println( "errorRowValue===================="+errorStrValue);
            int number = Integer.parseInt(errorStrValue);

            if (number != 0) {

                driver.findElement(By.xpath("//span[text()='Amend Errors']")).click();
                Thread.sleep(10000);
            } else if (number == 0) {
                System.out.println("===============>No error records found");
            }

        }

    }
    //span[@class='description']
    public void uploadPdfBrowseFile() throws InterruptedException, IOException {
        Thread.sleep(3000);

        browseFile.sendKeys("C:\\TDC\\MavenTDC\\src\\test\\resources\\testdata_(store_excel_files__contains_datas)\\pdf_sample_data.pdf");

        Thread.sleep(1000);

    }

    public void PDFError() throws InterruptedException {
        Thread.sleep(3000);
        WebElement data = driver.findElement(By.xpath("//span[@class='description']"));
        String Error = data.getText();

        int actual = 1;
        int expected = 2;

        Assert.assertEquals(actual, expected, Error);
    }

    public void logout() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(HeaderProfile).perform();
        Thread.sleep(2000);
        Logout.click();
    }



    }

