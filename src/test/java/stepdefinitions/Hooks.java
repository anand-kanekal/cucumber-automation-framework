package stepdefinitions;

import com.automation.framework.core.browser.BrowserManager;
import com.automation.framework.core.browser.DriverHandler;
import io.cucumber.java.*;

import java.io.IOException;

public class Hooks {

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {
        BrowserManager.getInstance().killDriverProcess();
        System.out.println("Before all executed");
    }

    @Before
    public void setUpBrowser(Scenario scenario) {
        System.out.println("Executing scenario " + scenario.getName() + " with thread " + Thread.currentThread().threadId());
        BrowserManager.getInstance().openBrowser();
    }

    @After
    public void after() {
        BrowserManager.getInstance().closeBrowser();
    }

    @AfterAll
    public static void afterAll() {
        DriverHandler.unload();
        System.out.println("After all executed");
    }
}
