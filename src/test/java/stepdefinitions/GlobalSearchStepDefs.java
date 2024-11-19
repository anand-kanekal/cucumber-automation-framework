package stepdefinitions;

import com.automation.framework.constants.Path;
import com.automation.framework.core.browser.DriverHandler;
import com.automation.framework.pages.common.MenuComponent;
import com.automation.framework.pages.common.SearchComponent;
import com.automation.framework.pages.common.dialog.CookiesDialog;
import com.automation.framework.core.utils.PropertyFileManager;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;
import java.util.Properties;

public class GlobalSearchStepDefs {

    private static final Properties browserProperties;

    MenuComponent menuComponent;
    SearchComponent searchComponent;

    static {
        browserProperties = new Properties();
        PropertyFileManager.getInstance().loadProperties(browserProperties, Path.MAIN_RESOURCES + File.separator + "config" + File.separator + "application.properties");
    }

    @Given("the user is on Cucumber home page")
    public void the_user_is_on_cucumber_home_page() {
        DriverHandler.getDriver().get(browserProperties.getProperty("url"));
    }

    @When("the user clicks on search")
    public void the_user_clicks_on_search() {
        menuComponent = new MenuComponent(DriverHandler.getDriver());
        CookiesDialog cookiesDialog = new CookiesDialog(DriverHandler.getDriver());

        // Dismiss cookie settings
        cookiesDialog.waitForCookiesDialog()
                     .clickOnCookiesSettings()
                     .clickOnDenyAll();

        menuComponent.clickOnSearch();
        throw new RuntimeException("Intentional failure");
    }

    @When("enters search text")
    public void enters_search_text() {
        searchComponent = new SearchComponent(DriverHandler.getDriver());
        searchComponent.enterSearchText("Cucumber for Jira");
    }

    @Then("search results should be loaded")
    public void search_results_should_be_loaded() {
       List<WebElement> searchResults = searchComponent.getSearchResults();
       Assert.isTrue(!searchResults.isEmpty(), "Search results are not loaded");
    }
}
