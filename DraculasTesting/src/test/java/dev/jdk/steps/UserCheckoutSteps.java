package dev.jdk.steps;

import dev.jdk.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCheckoutSteps {
    public WebDriver driver= LoginRunner.driver;

    @Given("user is on browse page")
    public void user_is_on_browse_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
    }

    @When("user clicks on buy now")
    public void user_clicks_on_buy_now() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"4\"]")));
        WebElement button=driver.findElement(By.xpath("//*[@id=\"4\"]"));
        button.click();
    }

    @Then("user should be redirected to payment page")
    public void user_should_be_redirected_to_payment_page() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Browse",driver.getTitle());
    }

    @When("The user clicks the browser back button")
    public void the_user_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().back();
    }

    @Then("The user should be on the browse page and the title of page is Browse Page")
    public void the_user_should_be_on_the_browse_page_and_the_title_of_page_is_browse_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        assertEquals("Browse",driver.getTitle());
    }

    @When("The user clicks on buy now")
    public void the_user_clicks_on_buy_now() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"4\"]")));
        WebElement button=driver.findElement(By.xpath("//*[@id=\"4\"]"));
        button.click();

    }

    @Then("user types in {string} into the name")
    public void user_types_in_into_the_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/payment.html");
        WebElement name=driver.findElement(By.xpath("//*[@id=\"name\"]"));
        name.sendKeys(string);
    }

    @Then("user types in {string} into the email")
    public void user_types_in_into_the_email(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement email=driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys(string);
    }

    @Then("user types in {string} into the city")
    public void user_types_in_into_the_city(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement city=driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys(string);
    }

    @Then("user types in {string} into the state")
    public void user_types_in_into_the_state(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement state=driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys(string);
    }

    @Then("user types in {string} into the contactno")
    public void user_types_in_into_the_contactno(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement contactno=driver.findElement(By.xpath("//*[@id=\"contactno\"]"));
        contactno.sendKeys(string);
    }

    @Then("user types in {string} into the country")
    public void user_types_in_into_the_country(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement country=driver.findElement(By.xpath("//*[@id=\"country\"]"));
        country.sendKeys(string);
    }

    @Then("user types in {string} into the streetaddress")
    public void user_types_in_into_the_streetaddress(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement streetaddress=driver.findElement(By.xpath("//*[@id=\"streetaddress\"]"));
        streetaddress.sendKeys(string);
    }

    @Then("user types in {string} into the zipcode")
    public void user_types_in_into_the_zipcode(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement zipcode=driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipcode.sendKeys(string);
    }

    @Then("user types in {string} into the cardno")
    public void user_types_in_into_the_cardno(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement cardnumber=driver.findElement(By.xpath("//*[@id=\"cardnumber\"]"));
        cardnumber.sendKeys(string);
    }

    @Then("user types in {string} into the expirydate")
    public void user_types_in_into_the_expirydate(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement expirydate=driver.findElement(By.xpath("//*[@id=\"expirydate\"]"));
        expirydate.sendKeys(string);
    }

    @Then("user types in {string} into the cvv")
    public void user_types_in_into_the_cvv(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement cvv=driver.findElement(By.xpath("//*[@id=\"cvv\"]"));
        cvv.sendKeys(string);
    }

    @Then("user clicks on proceed")
    public void user_clicks_on_proceed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement proceed=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/input[1]"));
        proceed.click();
    }

    @Then("user should be redirected to confirmation page")
    public void user_should_be_redirected_to_confirmation_page() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Checkout",driver.getTitle());
    }

    @Then("user clicks on cancel")
    public void user_clicks_on_cancel() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:8080/payment.html");
        WebElement cancel=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[3]/input[2]"));
        cancel.click();
    }

    @Then("user is redirected to browse page")
    public void user_is_redirected_to_browse_page() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Checkout",driver.getTitle());
    }
}
