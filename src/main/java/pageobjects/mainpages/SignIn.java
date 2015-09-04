package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;

/**
 * Created by cku04 on 02/09/2015.
 */
public class SignIn extends Page {

    WebElement userName, pass;
    WebElement signIn;

    public SignIn() {
        userName = new Element().elementByXpath("//android.widget.EditText[@content-desc='Username']");
        pass = new Element().elementByXpath("//android.view.View[@content-desc='Password']/following-sibling::android.view.View/android.widget.EditText");
        signIn = new Element().elementByXpath("//android.widget.Button[@content-desc='Sign in']");
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
        signedIn = true;
    }

    public void signIn(String user, String password) {
        enterUsername(user)
                .enterPassword(password)
                .clickSignInButton();
    }


}
