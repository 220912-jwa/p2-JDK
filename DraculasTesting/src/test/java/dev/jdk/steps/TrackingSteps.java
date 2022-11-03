package dev.jdk.steps;

import dev.jdk.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackingSteps {
    public WebDriver driver= LoginRunner.driver;
    @Given("user is on tracking page")
    public void user_is_on_tracking_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/trackingsystem.html");
    }

    @When("user types in {string} into the tracking no")
    public void user_types_in_into_the_tracking_no(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement input=driver.findElement(By.xpath("//*[@id=\"textinput\"]"));
        input.sendKeys(string);
        WebElement submit=driver.findElement(By.xpath("//*[@id=\"check\"]"));
        submit.click();
    }

    @Then("user should see a modal with details")
    public void user_should_see_a_modal_with_details() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("myModal")));
    }

    @Then("user clicks on close modal")
    public void user_clicks_on_close_modal() {
        // Write code here that turns the phrase above into concrete actions

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[1]/button")));
        WebElement close=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button"));
        close.click();
    }
    @Then("user should see an alert")
    public void user_should_see_an_alert() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
