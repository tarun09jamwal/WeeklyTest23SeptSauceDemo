package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class ProductBuy extends BaseClass {
    @Given("clicks on login button")
    public void clicks_on_login_button() throws IOException {
        Setup();
        pageFactory.getProductBuy().LoginButton();
        System.out.println("User clicked on the login button");
    }

    @When("user is navigated to the product page and verify the page")
    public void user_is_navigated_to_the_product_page_and_verify_the_page() {
        pageFactory.getProductBuy().VerifyHomePage();
        System.out.println("user is navigated to the product page and verified the page");
    }

    @When("click on any add to cart button")
    public void click_on_any_add_to_cart_button() {
        pageFactory.getProductBuy().AddToCartButton();
        System.out.println("user click on any add to cart button");
    }

    @When("navigate to the carts button and verify the page")
    public void navigate_to_the_carts_button_and_verify_the_page() {
        pageFactory.getProductBuy().Cart();
        System.out.println("user navigate to the carts button and verified the page");
    }

    @Then("click on checkout fill the billing information and click continue")
    public void click_on_checkout_fill_the_billing_information_and_click_continue() throws IOException {
        pageFactory.getProductBuy().UserInformation();
        System.out.println("user clicked on checkout fill the your information and clicked continue");
    }

    @Then("Verify the item in overview page and click finish button")
    public void verify_the_item_in_overview_page_and_click_finish_button() {
        pageFactory.getProductBuy().VerifyProduct();
        System.out.println("user verified the item in overview page and click finish button");

    }

    @Then("click on back home button")
    public void click_on_back_home_button() {
        pageFactory.getProductBuy().BackHomeButton();
        System.out.println("user is logged out and browser closes");
    }

}
