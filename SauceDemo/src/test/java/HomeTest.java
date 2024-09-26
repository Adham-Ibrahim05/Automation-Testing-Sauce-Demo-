import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTest {

    protected WebDriver driver;
    HomePage homePage;
    CartPage cartPage;

    @BeforeTest
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/inventory.html");

        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 2)
    public void AddProductsToCart()
    {
        homePage = new HomePage(driver);
        //String Expected = "REMOVE";
        homePage.AddFirstProductToCart();
        String Actual1 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        String Expected1 = "1";
        Assert.assertEquals(Actual1,Expected1);
        homePage.AddSecondProductToCart();
        String Expected2 = "2";
        String Actual2 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        Assert.assertEquals(Actual2,Expected2);
        cartPage = homePage.ClickOnCartBadge();
        String ExpectedCartText = "Your Cart";
        String ActualCartText  =  driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(ActualCartText,ExpectedCartText);
    }
}
