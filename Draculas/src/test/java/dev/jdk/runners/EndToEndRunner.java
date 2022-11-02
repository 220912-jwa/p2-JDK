package dev.jdk.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"}, glue={"dev.jdk.steps"})

public class EndToEndRunner {
    public static WebDriver driver = null;
    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void endTests()
    {
        driver.close();
    }

}
