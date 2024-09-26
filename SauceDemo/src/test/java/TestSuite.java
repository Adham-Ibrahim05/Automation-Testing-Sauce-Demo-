import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSuite {

   protected WebDriver driver;
   HomePage homePage;
   CheckoutPage checkoutPage;
   LoginPage loginPage;
   CartPage cartPage;


   @BeforeTest
    public void Setup()
   {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com/v1/index.html");

       loginPage = new LoginPage(driver);
       homePage = new HomePage(driver);
       cartPage = new CartPage(driver);
       checkoutPage = new CheckoutPage(driver);

   }

   @Test
    public void ValidLogin()
   {
       loginPage.EnterUserName("standard_user");
       loginPage.EnterPassword("secret_sauce");
       homePage = loginPage.ClickOnLoginButton();
       Assert.assertEquals(homePage.GetHomeTitle(),"Products");
   }

   @Test(dependsOnMethods = "ValidLogin")
    public void AddItemToCart()
   {
       homePage.AddFirstProductToCart();
       Assert.assertEquals(homePage.GetTotalItem(),"1");
   }

    @Test(dependsOnMethods = "AddItemToCart")
    public void GoToCart()
    {
        cartPage = homePage.ClickOnCartBadge();
        Assert.assertEquals(driver.findElement(By.className("subheader")).getText(),"Your Cart");
    }

    @Test(dependsOnMethods = "GoToCart")
    public void BackToHomePage()
    {
        homePage = cartPage.ClickOnContinueShoppingButton();
        Assert.assertEquals(homePage.GetHomeTitle(),"Products");
    }

    @Test(dependsOnMethods = "BackToHomePage")
    public void AddAnotherItemToCart()
    {
        homePage.AddSecondProductToCart();
        Assert.assertEquals(homePage.GetTotalItem(),"2");
        cartPage = homePage.ClickOnCartBadge();
        Assert.assertEquals(cartPage.GetCartTitle(),"Your Cart");
    }

    @Test(dependsOnMethods = "AddAnotherItemToCart")
    public void GoToCheckout()
    {
        checkoutPage = cartPage.ClickOnCheckOutButton();
        Assert.assertEquals(checkoutPage.GetCheckoutInfoTitle(),"Checkout: Your Information");
    }

    @Test(dependsOnMethods = "GoToCheckout")
    public void ValidCheckoutData()
    {
        checkoutPage.EnterFirstName("Adham");
        checkoutPage.EnterLastName("Ibrahim");
        checkoutPage.EnterPostalCode("11511");
        checkoutPage.ClickOnContinueButton();
        Assert.assertEquals(checkoutPage.GetCheckouttext(),"Checkout: Overview");
    }

    @Test(dependsOnMethods = "ValidCheckoutData")
    public void CheckFinish()
    {
        checkoutPage.ClickOnFinishButton();
        Assert.assertEquals(checkoutPage.GetFinishtext(),"Finish");
    }

    @AfterTest
    public void Quit()
    {
        homePage.ClickOnBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        homePage.ClickOnLogout();
        driver.quit();
    }
}
