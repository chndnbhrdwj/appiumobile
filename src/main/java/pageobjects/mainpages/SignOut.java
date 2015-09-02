package pageobjects.mainpages;

import org.openqa.selenium.WebElement;
import pagecomponents.Button;
import pagecomponents.TextView;

/**
 * Created by cku04 on 02/09/2015.
 */
public class SignOut extends Page {

    TextView signoutHeader;
    WebElement userName, pass;
    Button signout;

    public SignOut() {
        signoutHeader = new TextView("Sign Out");
        signout = new Button("Sign Out");
    }

    private HomePage clickSignOutButton() {
        signout.click();
        signedIn = false;
        return new HomePage();
    }

    public HomePage signOut() {
        return clickSignOutButton();
    }


}
