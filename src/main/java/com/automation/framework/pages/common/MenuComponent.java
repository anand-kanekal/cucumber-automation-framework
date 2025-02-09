package com.automation.framework.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuComponent {

    WebDriver driver;

    @FindBy(css = "li[class='nav-item nav-item-search']>a")
    public WebElement SEARCH_BUTTON;

    public MenuComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSearch() {
        SEARCH_BUTTON.click();
    }

}
