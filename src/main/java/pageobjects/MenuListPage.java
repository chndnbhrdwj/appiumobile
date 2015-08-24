package pageobjects;

import pagecomponents.TextView;

/**
 * Created by cku04 on 20/08/2015.
 */
public class MenuListPage extends Page {

    TextView onNow, catchUp, skyBoxSets, skyMovies, downloads;

    public MenuListPage() {
        onNow = new TextView("On Now");
        catchUp = new TextView("Catch Up");
        skyBoxSets = new TextView("Sky Box Sets");
        skyMovies = new TextView("Sky Movies");
        downloads = new TextView("Downloads");
    }

    public OnNowPage goToOnNowPage() {
        onNow.click();
        return new OnNowPage();
    }

    public CatchUpPage goToCatchUpPage() {
        catchUp.click();
        return new CatchUpPage();
    }

    public SkyBoxSetsPage goToSkyBoxSetsPage() {
        skyBoxSets.click();
        return new SkyBoxSetsPage();
    }

    public SkyMoviesPage goToSkyMoviesPage() {
        skyMovies.click();
        return new SkyMoviesPage();
    }

    public DownloadsPage goToDownloadsPage() {
        downloads.click();
        return new DownloadsPage();
    }

}
