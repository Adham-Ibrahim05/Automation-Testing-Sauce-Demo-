import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void EnterUserName(String UserName){
        WebElement UserNameElement = driver.findElement(By.id("user-name"));
        SendText(UserNameElement,UserName);
    }

    public void EnterPassword(String Password){
        WebElement PasswordElement = driver.findElement(By.id("password"));
        SendText(PasswordElement,Password);
    }

    public HomePage ClickOnLoginButton(){
        WebElement LoginButtonElement = driver.findElement(By.id("login-button"));
        Clicking(LoginButtonElement);
        return new HomePage(driver);
    }

    public String GetErrorMessage(){
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        return GetText(ErrorMessage);
    }
}
