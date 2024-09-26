import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageBase{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void EnterFirstName(String FirstName){
        WebElement FirstNameElement = driver.findElement(By.id("first-name"));
        SendText(FirstNameElement,FirstName);
    }

    public void EnterLastName(String LastName){
        WebElement LastNameElement = driver.findElement(By.id("last-name"));
        SendText(LastNameElement,LastName);
    }

    public void EnterPostalCode(String PostalCode){
        WebElement PostalCodeElement = driver.findElement(By.id("postal-code"));
        SendText(PostalCodeElement,PostalCode);
    }

    public void ClickOnContinueButton(){
        WebElement ContinueButtonElement = driver.findElement(By.xpath("//input[@type='submit']"));
        Clicking(ContinueButtonElement);
    }

    public HomePage ClickOnFinishButton(){
        WebElement FinishButtonElement = driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
        Clicking(FinishButtonElement);
        return new HomePage(driver);
    }

    public String GetCheckouttext(){
        WebElement OverviewText = driver.findElement(By.className("subheader"));
        return GetText(OverviewText);
    }

    public String GetCheckoutInfoTitle(){
        WebElement InfoTitle = driver.findElement(By.className("subheader"));
        return GetText(InfoTitle);
    }

    public String GetFinishtext(){
        WebElement FinishText = driver.findElement(By.className("subheader"));
        return GetText(FinishText);
    }

}
