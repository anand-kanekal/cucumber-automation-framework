package stepdefinitions;

import com.automation.framework.pages.common.MenuComponent;
import com.automation.framework.pages.common.SearchComponent;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GlobalSearchTest {

    WebDriver driver;

    MenuComponent menuComponent;
    SearchComponent searchComponent;

    @Given("the user is on Cucumber home page")
    public void the_user_is_on_cucumber_home_page() {
        driver = new ChromeDriver();
        driver.get("https://cucumber.io/");
    }

    @When("the user clicks on search")
    public void the_user_clicks_on_search() throws InterruptedException {
        menuComponent = new MenuComponent(driver);
        Thread.sleep(5000);
        menuComponent.clickOnSearch();
    }

    @When("enters search text")
    public void enters_search_text() {
        searchComponent = new SearchComponent(driver);
        searchComponent.enterSearchText("Cucumber for Jira");
    }

    @Then("search results should be loaded")
    public void search_results_should_be_loaded() {
        List<WebElement> searchResults = searchComponent.getSearchResults();
        Assert.isTrue(!searchResults.isEmpty(), "Search results are not loaded");
    }
}
