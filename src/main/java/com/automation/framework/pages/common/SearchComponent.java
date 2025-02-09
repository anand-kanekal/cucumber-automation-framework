package com.automation.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchComponent {

    WebDriver driver;

    @FindBy(css = "input[name='search']")
    public WebElement SEARCH_INPUT;

    @FindBy(css = "div[class='result-list']>a")
    public List<WebElement> SEARCH_RESULTS;

    public SearchComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchText(String text) {
        SEARCH_INPUT.sendKeys(text);
    }

    public List<WebElement> getSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElements(SEARCH_RESULTS));
    }
}
