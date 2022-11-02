package dev.jdk.steps;

import dev.jdk.runners.EndToEndRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BrowseSteps {
    WebDriver driver = EndToEndRunner.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @Given("The user is on the index page.")
    public void the_user_is_on_the_index_page() {
        System.out.println("The user is on the index page.");
        driver.navigate().to("http://localhost:63342/Draculas/html/index.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Browse")));

    }

    @When("The user clicks the {string} link.")
    public void the_user_clicks_the_link(String string) {
        System.out.println("The user clicks the {string} link.");
        WebElement link = driver.findElement(By.linkText(string));
        link.click();
        wait.until(ExpectedConditions.titleIs(string));
    }

    @Then("the user will be on the {string} page.")
    public void the_user_will_be_on_the_page(String string) {
        System.out.println("The user will be on the {string} page.");
        String title = driver.getTitle();
        Assertions.assertEquals(string,title);
    }

    @When("The user selects {string} option.")
    public void the_user_selects_option(String string) {
        System.out.println("The user selects {string} option.");
        WebElement selector = driver.findElement(By.className(string));
        selector.sendKeys(string);
    }

    @When("The user clicks the {string} button.")
    public void the_user_clicks_the_button(String string) {
        System.out.println("The user clicks the {string} button.");
        WebElement button = driver.findElement(By.linkText(string));
        button.click();
    }

    @Then("the user should see only {string} books.")
    public void the_user_should_see_only_books(String string) {
        System.out.println("the user should see only {string} books.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(string)));
        String filter = driver.findElement(By.id(string)).getText();
        if(string.equals("Bram"))
        {
            string = string + " Stoker";
        }
        Assertions.assertEquals(string, filter);
    }
}
