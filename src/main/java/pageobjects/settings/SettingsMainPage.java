package pageobjects.settings;

import org.openqa.selenium.NoSuchElementException;
import pagecomponents.TextView;
import pageobjects.mainpages.SignIn;
import pageobjects.mainpages.SignOut;
import pageobjects.settings.help.HelpInfoMenu;
import pageobjects.settings.settingsmenu.SettingsSubMenuPage;

/**
 * Created by chandan on 8/24/2015.
 */
public class SettingsMainPage extends SettingsAbstract {

    TextView signin, signout, settings, help, skyAccount, config;

    public SettingsMainPage() {
        settings = new TextView("Settings");
        help = new TextView("Help & Info");
        skyAccount = new TextView("Sky Account");
//        config = new TextView("Select config");
    }

    public SignIn clickSignIn() {
        try {
            signin = new TextView("Sign in");
            signin.click();
        } catch (NoSuchElementException e) {
            log.info("User was already logged in.");
            pressBack();
            return null;
        }
        return new SignIn();
    }

    public SignOut clickSignOut() {
        try {
            signout = new TextView("Sign Out");
            signout.click();
        } catch (NoSuchElementException e) {
            log.info("User was not logged in.");
            pressBack();
            return null;
        }
        return new SignOut();
    }

    public SettingsSubMenuPage goToSettingsSubMenu() {
        log.info("");
        settings.click();
        return new SettingsSubMenuPage();
    }

    public HelpInfoMenu goToHelpInfoMenu() {
        help.click();
        return new HelpInfoMenu();
    }

    public SkyAccount goToSkyAccount() {
        log.info("");
        skyAccount.click();
        return new SkyAccount();
    }

    public boolean isSignInDisplayed() {
        boolean displayed;
        displayed = new TextView("Sign in").isDisplayed();
        pressBack();
        return displayed;
    }

    public boolean isSignOutDisplayed() {
        boolean displayed;
        displayed = new TextView("Sign Out").isDisplayed();
        pressBack();
        return displayed;
    }

    //Not available on signed build
/*
    public SelectConfig goToConfig() {
        config.click();
        return new SelectConfig();
    }
*/



}
