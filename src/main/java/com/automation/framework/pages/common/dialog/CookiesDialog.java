package com.automation.framework.pages.common.dialog;

import com.automation.framework.core.utils.ActionUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesDialog {

    @FindBy(css = "div[aria-describedby='ch2-dialog-description'][role='dialog']")
    public static WebElement COOKIES_DIALOG;

    @FindBy(xpath = "//button[text()='Cookie settings']")
    public static WebElement COOKIES_SETTINGS_BUTTON;

    @FindBy(xpath = "//button[text()='Deny all']")
    public static WebElement DENY_ALL;

    public CookiesDialog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public CookiesDialog waitForCookiesDialog() {
        ActionUtils.waitForVisibilityOf(COOKIES_DIALOG, ActionUtils.SHORT_TIMEOUT);
        return this;
    }

    public CookiesDialog clickOnCookiesSettings() {
        WebElement cookiesSettingsButton = ActionUtils.waitForVisibilityOf(COOKIES_SETTINGS_BUTTON, ActionUtils.SHORT_TIMEOUT);
        ActionUtils.clickOn(cookiesSettingsButton);
        return this;
    }

    public CookiesDialog clickOnDenyAll() {
        WebElement denyAllButton = ActionUtils.waitForVisibilityOf(DENY_ALL, ActionUtils.SHORT_TIMEOUT);
        ActionUtils.clickOn(denyAllButton);
        return this;
    }
}
