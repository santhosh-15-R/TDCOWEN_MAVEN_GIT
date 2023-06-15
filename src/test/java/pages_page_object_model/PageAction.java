package pages_page_object_model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;



public class PageAction {



    //private static final Logger LOGGER = null;

    public PageAction highlightElement(WebElement webElement, WebDriver webDriver) {


        //if element is initially hidden (style="visibility: hidden"), framework will force it to be shown and highlight with dashed-blue

        if (Objects.nonNull(webElement.getAttribute("style"))) {

            if (webElement.getAttribute("style").contains("visibility: hidden")) {

                ((JavascriptExecutor) webDriver)

                        .executeScript("arguments[0].setAttribute('style', 'border: 2px dashed blue;');", webElement);
                return this;
            }
        }

        //if element not hidden and available, it'll highlight with dashed-red

        ((JavascriptExecutor) webDriver)

                .executeScript("arguments[0].setAttribute('style', 'border: 2px dashed red;');", webElement);

        return this;

    }

    //Methods to habdle waits

    private Wait<WebDriver> defaultWait(WebDriver driver) {
        return fluentWait(driver, getTimeout());
    }

    private Wait<WebDriver> fluentWait(WebDriver driver, long timeout) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout)).pollingEvery(Duration.ofMillis(getTimeout())).ignoring(NoSuchElementException.class);
    }

    private int getTimeout() {
        return Integer.parseInt("40");
    }

    public void WaitForElementToLoad(WebDriver driver, String Xpath) {
        defaultWait(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
    }

    public void WaitForElementToLoad(WebDriver driver, WebElement element) {

        try {
            defaultWait(driver).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
           // webBase.logger.info("Element %s is not loaded"+ element + e);
        }
    }

    public void WaitForElementToBeClickable(WebDriver driver, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            //webBase.logger.info("Element %s is not loaded"+ element + e);
        }
    }



}
