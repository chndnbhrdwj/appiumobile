package pageobjects.mainpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by cku04 on 02/09/2015.
 */
public class SignIn extends Page {

    WebElement userName, pass;
    WebElement signIn;

    public SignIn() {
        //userName = waitForElement(By.xpath("//android.widget.EditText[@content-desc='Username']"), 10);
        userName = waitForElement(By.xpath("//android.view.View[@content-desc='Username']/following-sibling::android.view.View[1]/android.widget.EditText"), 10);
        pass = new Element().elementByXpath("//android.view.View[@content-desc='Password']/following-sibling::android.view.View/android.widget.EditText");
        signIn = new Element().elementByXpath("//android.widget.Button[@resource-id='signinButton']");
    }

    private SignIn enterUsername(String user) {
        userName.clear();
        userName.sendKeys(user);
        return this;
    }

    private SignIn enterPassword(String password) {
        pass.clear();
        pass.sendKeys(password);
        return this;
    }

    private void clickSignInButton() {
        driver.hideKeyboard();
        signIn.click();
    }

    public void signIn(String user, String password) {
        enterUsername(user)
                .enterPassword(password)
                .clickSignInButton();
        closeSplashScreen();
    }
}
