import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {
    protected WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @DataProvider(name="ValidUserData")
    public  Object[][] ValidData()
    {
        return new Object[][]{
                {"standard_user","secret_sauce"}};
    }

    @DataProvider(name="InvalidUserData")
    public Object[][] InvalidData()
    {
        return new Object[][]{
                {" "," "},
                {"problem_user","secret_sauce123"},
                {"lockeduser","secretsauce"},
                {"performance","secret_sauce"}};
    }

    @BeforeMethod
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    @Test(dataProvider = "ValidUserData",priority = 1)
    public void ValidLoginTest(String username,String password){
        loginPage = new LoginPage(driver);
        loginPage.EnterUserName(username);
        loginPage.EnterPassword(password);
        homePage = loginPage.ClickOnLoginButton();
        String Expected = "Products";
        String Actual = homePage.GetHomeTitle();
        Assert.assertEquals(Actual , Expected);
    }

    @Test(dataProvider = "InvalidUserData" , priority = 6)
    public void InValidLoginTest(String username,String password){
        loginPage = new LoginPage(driver);
        loginPage.EnterUserName(username);
        loginPage.EnterPassword(password);
        homePage = loginPage.ClickOnLoginButton();
        String Expected = "Epic sadface: Username and password do not match any user in this service";
        String Actual = loginPage.GetErrorMessage();
        Assert.assertEquals(Actual , Expected);
    }
}
