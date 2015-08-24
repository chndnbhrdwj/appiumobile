package pageobjects.settings.help;

import pagecomponents.TextView;

/**
 * Created by chandan on 8/24/2015.
 */
public class HelpInfoMenu {

    TextView faq, moreSkyGoExtra, termsConditions, privacyCookies, licenses, about, skyUkApps;

    public HelpInfoMenu() {
        faq = new TextView("FAQs");
        moreSkyGoExtra = new TextView("More about Sky Go Extra");
        termsConditions = new TextView("Terms & Conditions");
        privacyCookies = new TextView("Privacy and Cookies");
        licenses = new TextView("Licenses");
        about = new TextView("About");
        skyUkApps = new TextView("Sky UK Apps");
    }

    public Faqs goToFaqs() {
        faq.click();
        return new Faqs();
    }

    public MoreSkyGoExtra goToMoreSkyGoExtra() {
        moreSkyGoExtra.click();
        return new MoreSkyGoExtra();
    }

    public TermsConditions goToTermsConditions() {
        termsConditions.click();
        return new TermsConditions();
    }

    public PrivacyCookies goToPrivacyCookies() {
        privacyCookies.click();
        return new PrivacyCookies();
    }

    public Licenses goToLicenses() {
        licenses.click();
        return new Licenses();
    }

    public About goToAbout() {
        about.click();
        return new About();
    }

    public SkyUKApps goToSkyUKApps() {
        skyUkApps.click();
        return new SkyUKApps();
    }


}
