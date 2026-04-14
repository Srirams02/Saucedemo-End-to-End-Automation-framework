package base;

import com.codeborne.selenide.Configuration;
import config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {

    @BeforeMethod
    public void setUp() {

        // ✅ Basic configuration
        Configuration.browser = ConfigManager.get("browser");
        Configuration.baseUrl = ConfigManager.get("base.url");
        Configuration.timeout = Long.parseLong(ConfigManager.get("timeout"));
        Configuration.headless = false;
        Configuration.screenshots = true;
        Configuration.savePageSource = true;
        Configuration.timeout = 10000;

        // ✅ Chrome setup
        ChromeOptions options = new ChromeOptions();

        // 🔹 Use fresh browser profile (fix popup issue)
        options.addArguments("--incognito");

        // 🔹 Disable password manager
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);

        // 🔹 Disable notifications
        options.addArguments("--disable-notifications");

        Configuration.browserCapabilities = options;

        // ✅ Start browser
        open("/");

        // ✅ Maximize window properly
        WebDriver driver = getWebDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}