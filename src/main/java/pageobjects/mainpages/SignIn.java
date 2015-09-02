package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Element;
import pagecomponents.TextView;

/**
 * Created by cku04 on 02/09/2015.
 */
public class SignIn extends Page {

    TextView signWithSkyId;
    WebElement userName, pass;
    WebElement signIn;

    public SignIn() {
        signWithSkyId = new TextView("Sign in with Sky iD");
        userName = new Element().elementByXpath("//android.widget.EditText[@content-desc='Username']");
        pass = new Element().elementByXpath("//android.view.View[@content-desc='Password']/following-sibling::android.view.View/android.widget.EditText");
        signIn = new Element().elementByXpath("//android.widget.Button[@content-desc='Sign in']");
    }

    public SignIn enterUsername(String user) {
        userName.clear();
        userName.sendKeys(user);
        return this;
    }

    public SignIn enterPassword(String password) {
        pass.clear();
        pass.sendKeys(password);
        return this;
    }

    public HomePage clickSignInButton() {
        signIn.click();
        signedIn = true;
        return new HomePage();
    }

    public HomePage signIn(String user, String password) {
        return enterUsername(user)
                .enterPassword(password)
                .clickSignInButton();
    }


}
