package pages;

import javafx.util.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchBar getSearchBar() {
        SearchBar searchBar = new SearchBar();
        searchBar.waitForLoad();
        return searchBar;
    }

    public SlideShowBar getFeaturedBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[2]/section/section/div/div[3]"),
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[2]/section/section/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getExclusiveBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[5]/div/section/div/div[3]"),
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[5]/div/section/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getStreamingBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[6]/section/div/div/div[2]/div/div[3]"),
            By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[6]/section/div/div/div[2]/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getComingSoonBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[7]/section[2]/div/div/div/div[3]"),
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[7]/section[2]/div/div/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getWatchSoonBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[7]/section[3]/div/div/div/div[3]"),
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[7]/section[3]/div/div/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getEditorsPickBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[1]/div/div[3]"),
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[1]/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }

    public SlideShowBar getBornTodayBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[2]/div/div/div/div[3]"),
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[2]/div/div/div/div[1]")
        );
        slideShowBar.waitForLoad();
        return slideShowBar;
    }
    public SlideShowBar getTopNewsBar() {
        SlideShowBar slideShowBar = new SlideShowBar(
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[3]/div/div/div[1]/div/div[3]"),
                By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/div[8]/div/section[3]/div/div/div[1]/div/div[1]")
        );
       // slideShowBar.waitForLoad();
        return slideShowBar;
    }


    public class SearchBar {
        public void insertSearchQuery(String text) {
            webDriver.findElement(By.id("suggestion-search")).sendKeys(text);
        }
        public SearchResultsPage performSearchQuery() {
            webDriver.findElement(By.cssSelector("#suggestion-search-button")).click();
            return new SearchResultsPage(webDriver);
        }
        private boolean isSearchTextAreaPresent() {
            return !webDriver.findElements(By.id("suggestion-search")).isEmpty();

        }
        public void waitForLoad() {
            System.out.println("here");
            new WebDriverWait(webDriver, 120)
                    .until(driver -> isSearchTextAreaPresent());
        }
    }

    public class SlideShowBar {
        private By rightButtonCondition;
        private By leftButtonCondition;

        public SlideShowBar(By rightButtonCondition, By leftButtonCondition) {
            this.rightButtonCondition = rightButtonCondition;
            this.leftButtonCondition = leftButtonCondition;
        }

        public void slideRight() {
            new WebDriverWait(webDriver, 120)
                    .until(ExpectedConditions.visibilityOf(webDriver.findElement(rightButtonCondition)))
                    .click(); // waiting for load and clicking right button
            new WebDriverWait(webDriver, 120)
                    .until(driver -> isLeftButtonPresent()); // waiting until the slideshow is over and left button is visible
        }
        public void slideLeft() {
            webDriver.findElement(leftButtonCondition).click();
        }
        public void waitForLoad() {
            new WebDriverWait(webDriver, 120) // 120 because sometimes it takes imdb to load :)
                    .until(driver -> isRightButtonPresent());
        }
        public boolean isRightButtonPresent() {
            WebElement rightButton = webDriver.findElement(rightButtonCondition);
            Actions action = new Actions(webDriver);
            action.moveToElement(rightButton).perform();
            return rightButton.isDisplayed();
        }
        public boolean isLeftButtonPresent() {
            WebElement leftButton = webDriver.findElement(leftButtonCondition);
            Actions action = new Actions(webDriver);
            action.moveToElement(leftButton).perform();
            return leftButton.isDisplayed();
        }
    }
}
