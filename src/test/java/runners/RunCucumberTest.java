package runners;

import com.automation.framework.core.browser.BrowserManager;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.*;

import java.io.IOException;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@SelectPackages("stepdefinitions")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions")
public class RunCucumberTest {

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {
        BrowserManager.getInstance().killDriverProcess();
    }

    @AfterAll
    public static void afterAll() {
        BrowserManager.getInstance().closeBrowser();
    }
}
