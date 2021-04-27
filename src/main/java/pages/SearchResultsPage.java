package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
    private WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForLoadAndVerify() {
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnTitlePresent());
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnNamePresent());
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnKeywordPresent());
        new WebDriverWait(webDriver, 120)
                .until(driver -> isResultBasedOnCompanyPresent());
    }
    private boolean isResultBasedOnTitlePresent() {
        WebElement tbodyOfTitleResult = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody"));
        Actions action = new Actions(webDriver);
        action.moveToElement(tbodyOfTitleResult).perform();
        return tbodyOfTitleResult.isDisplayed();
    }

    private boolean isResultBasedOnNamePresent() {
        WebElement tbodyOfNameResult = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/table/tbody"));
        Actions action = new Actions(webDriver);
        action.moveToElement(tbodyOfNameResult).perform();
        return tbodyOfNameResult.isDisplayed();
    }

    private boolean isResultBasedOnKeywordPresent() {
        WebElement tbodyOfKeywordResult = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[4]/table/tbody"));
        Actions action = new Actions(webDriver);
        action.moveToElement(tbodyOfKeywordResult).perform();
        return tbodyOfKeywordResult.isDisplayed();
    }

    private boolean isResultBasedOnCompanyPresent() {
        WebElement tbodyOfCompanyResult = webDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div[5]/table/tbody"));
        Actions action = new Actions(webDriver);
        action.moveToElement(tbodyOfCompanyResult).perform();
        return tbodyOfCompanyResult.isDisplayed();
    }

}
