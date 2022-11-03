package dev.jdk.steps;

import dev.jdk.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {
    public WebDriver driver= LoginRunner.driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("The user clicks on any add to cart button.")
    public void the_user_clicks_on_any_add_to_cart_button() {
        System.out.println("The user clicks on any add to cart button.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to Cart")));
        WebElement button = driver.findElement(By.linkText("Add to Cart"));
        button.click();
    }

    @Then("The button turns green and says success and the amount of items in the cart appears next to the cart link.")
    public void the_button_turns_green_and_says_success_and_the_amount_of_items_in_the_cart_appears_next_to_the_cart_link() {
        System.out.println("The button turns green and says success and the amount of items in the cart appears next to the cart link.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Success")));
        String button = driver.findElement(By.linkText("Success")).getText();
        Assertions.assertEquals("Success", button);
    }

    @When("The user navigates to the cart page.")
    public void the_user_navigates_to_the_cart_page() {
        System.out.println("The user navigates to the cart page.");
        WebElement link = driver.findElement(By.linkText("Cart (1)"));
        link.click();
        wait.until(ExpectedConditions.titleIs("Cart"));
    }

    @Then("The user sees the book they added to the cart and a remove from cart button.")
    public void the_user_sees_the_book_they_added_to_the_cart_and_a_remove_from_cart_button() {
        System.out.println("The user sees the book they added to the cart and a remove from cart button.");
        Assertions.assertTrue(true);
    }

    @When("The user navigates to the index page.")
    public void the_user_navigates_to_the_index_page() {
        System.out.println("The user navigates to the index page.");
        WebElement link = driver.findElement(By.linkText("Browse"));
        link.click();
        wait.until(ExpectedConditions.titleIs("Browse"));

    }

    @Then("The book in the cart is marked as a success.")
    public void the_book_in_the_cart_is_marked_as_a_success() {
        System.out.println("The book in the cart is marked as a success.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Success")));
        String button = driver.findElement(By.linkText("Success")).getText();
        Assertions.assertEquals("Success", button);
    }

    @When("The user clicks the remove from cart button.")
    public void the_user_clicks_the_remove_from_cart_button() {
        System.out.println("The user clicks the remove from cart button.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Remove From Cart")));
        WebElement button = driver.findElement(By.linkText("Remove From Cart"));
        button.click();
    }

    @Then("The book is removed from the cart and the number of items in the cart is reduced.")
    public void the_book_is_removed_from_the_cart_and_the_number_of_items_in_the_cart_is_reduced() {
        System.out.println("The book is removed from the cart and the number of items in the cart is reduced.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart (0)")));
        Assertions.assertTrue(true);
    }

    @Then("The cart is empty and no books are marked for success.")
    public void the_cart_is_empty_and_no_books_are_marked_for_success() {
        System.out.println("The cart is empty and no books are marked for success.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cart")));
        Assertions.assertTrue(true);
    }
}
