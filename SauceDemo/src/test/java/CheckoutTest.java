import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest {
    protected WebDriver driver;
    CheckoutPage checkoutPage;
    CartPage cartPage;
    HomePage homePage;


    @BeforeTest
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/checkout-step-one.html");

        homePage = new HomePage(driver);
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 3)
    public void ValidData()
    {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.EnterFirstName("Adham");
        checkoutPage.EnterLastName("Ibrahim");
        checkoutPage.EnterPostalCode("11511");
        checkoutPage.ClickOnContinueButton();
        String ExpectedResult = "Checkout: Overview";
        String ActualResult = checkoutPage.GetCheckouttext();
        Assert.assertEquals(ActualResult , ExpectedResult);
        checkoutPage.ClickOnFinishButton();
        String ExpectedFinishResult = "Finish";
        String ActualFinishResult = checkoutPage.GetFinishtext();
        Assert.assertEquals(ActualFinishResult , ExpectedFinishResult);
    }

    @Test(priority = 5)
    public void InvalidData()
    {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.EnterFirstName("");
        checkoutPage.EnterLastName("");
        checkoutPage.EnterPostalCode("");
        checkoutPage.ClickOnContinueButton();
        String ExpectedResult = "Error: First Name is required";
        String ActualResult = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3")).getText();
        Assert.assertEquals(ActualResult , ExpectedResult);

    }

    @AfterTest
    public void Exit()
    {
        homePage.ClickOnBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        homePage.ClickOnLogout();
        driver.quit();
    }
}
