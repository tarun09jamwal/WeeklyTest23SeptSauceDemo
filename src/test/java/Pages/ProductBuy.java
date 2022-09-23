package Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ProductBuy {
    WebDriver driver;

    By loginButton = By.xpath("//input[@id='login-button']");
    By verifyPage = By.xpath("//span[contains(text(),'Products')]");
    By addToCartButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    By cartLink = By.xpath("//a[@class='shopping_cart_link']");
    By verifyCart = By.xpath("//span[contains(text(),'Your Cart')]");
    By checkoutButton = By.xpath("//button[@id='checkout']");
    By firstName = By.xpath("//input[@id='first-name']");
    By lastName = By.xpath("//input[@id='last-name']");
    By postalCode = By.xpath("//input[@id='postal-code']");
    By continueButton = By.xpath("//input[@id='continue']");
    By productVerify = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    By finish = By.xpath("//button[@id='finish']");
    By backHomeButton = By.xpath("//button[@id='back-to-products']");

    By product = By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
    By productPrice = By.xpath("//div[@class='inventory_item_price']");

    public ProductBuy(WebDriver driver) {
        this.driver = driver;
    }

    public void LoginButton() {
        driver.findElement(loginButton).click();
    }

    public void VerifyHomePage() {
        String actual = driver.findElement(verifyPage).getText();
        Assert.isTrue(actual.equals("PRODUCTS"), "Expected result does not match with actual result");
    }

    public void AddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void Cart() {
        driver.findElement(cartLink).click();
        String actual = driver.findElement(verifyCart).getText();
        Assert.isTrue(actual.equals("YOUR CART"), "Expected result does not match with actual result");
        String actualProduct = driver.findElement(product).getText();
        Assert.isTrue(actualProduct.equals("Sauce Labs Backpack"), "Expected result does not match with actual result");
        String actualPrice = driver.findElement(productPrice).getText();
        Assert.isTrue(actualPrice.equals("$29.99"), "Expected result does not match with actual result");

    }

    public void UserInformation() throws IOException {
        driver.findElement(checkoutButton).click();
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//saucedemo.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String firstname = sheet.getRow(1).getCell(2).getStringCellValue();
        String lastname = sheet.getRow(1).getCell(3).getStringCellValue();
        String postalcode = sheet.getRow(1).getCell(4).getStringCellValue();
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(postalCode).sendKeys(postalcode);
        driver.findElement(continueButton).click();
    }

    public void VerifyProduct() {
        String actual = driver.findElement(productVerify).getText();
        Assert.isTrue(actual.equals("Sauce Labs Backpack"), "Expected result does not match with actual result");
        driver.findElement(finish).click();
    }

    public void BackHomeButton() {
        driver.findElement(backHomeButton).click();

    }
}
