package pages_page_object_model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class loginPageObjects {
    WebDriver driver;

    public loginPageObjects(WebDriver rdriver)
    {
        driver =rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath="//*[@type='email']")
     WebElement enterUserID;

    @FindBy(xpath="//*[@type='password']")
     WebElement enterPassword;
    @FindBy(xpath="//*[@aria-label='Login with Password']")
     WebElement LoginwithPassword;



    public  void sendUserID(String userid)  {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(enterUserID));

        element.clear();
        element.sendKeys(userid);
    }
    public  void sendPassword(String password)
    {
        enterPassword.clear();
        enterPassword.sendKeys(password);
    }
    public  void clickLoginwithPassword()
    {  JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", LoginwithPassword);

    }








   /* public WebElement waitUntilElementFound(By by, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver,Duration.of(10000, ChronoUnit.SECONDS));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }*/

/*   WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));*/


}

