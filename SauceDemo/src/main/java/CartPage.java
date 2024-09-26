import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends PageBase{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String GetCartTitle(){
        WebElement CartLabel = driver.findElement(By.className("subheader"));
        return GetText(CartLabel);
    }

    public HomePage ClickOnContinueShoppingButton(){
        WebElement ContinueShoppingButton = driver.findElement(By.xpath("//a[@class='btn_secondary']"));
        Clicking(ContinueShoppingButton);
        return new HomePage(driver);
    }

    public CheckoutPage ClickOnCheckOutButton(){
        WebElement CheckOutButton = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        Clicking(CheckOutButton);
        return new CheckoutPage(driver);
    }


}
