import org.opencart.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.time.Duration;

/**
 * Base class for UI tests with reusable helper methods for Selenium WebDriver.
 */
public abstract class BaseTest<T> {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected T page;
    protected Class<T> classPage = null;

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    public void setupMethod() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);

            wait = new WebDriverWait(driver, Duration.ofSeconds(Config.TIMEOUT));
            page = initPage();
            log.info("WebDriver initialized and window maximized.");
            log.info("Opening homepage.");
            openProject();
            log.info("Homepage opened successfully.");
        } catch (Exception e) {
            log.error("Error during setupMethod: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void teardownMethod() {
        try {
            if (!Config.DEBUG) {
                driver.quit();
                log.info("WebDriver closed.");
            }
        } catch (Exception e) {
            log.error("Error during teardownMethod: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    protected T initPage() {
        try {
            Constructor<T> constructor = classPage.getConstructor(WebDriver.class, WebDriverWait.class);
            return constructor.newInstance(driver, wait);
        } catch (Exception e) {
            log.error("Error initializing page object: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    protected void openProject() {
        driver.get(Config.BASE_URL);
    }
}
