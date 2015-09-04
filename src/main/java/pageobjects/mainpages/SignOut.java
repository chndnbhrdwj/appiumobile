package pageobjects.mainpages;

import pagecomponents.Button;
import pagecomponents.TextView;

/**
 * Created by cku04 on 02/09/2015.
 */
public class SignOut extends Page {

    TextView signoutHeader;
    Button signout;

    public SignOut() {
        signoutHeader = new TextView("Sign Out");
        signout = new Button("Sign Out");
    }

    private void clickSignOutButton() {
        signout.click();
    }

    public void signOut() {
        clickSignOutButton();
    }


}
