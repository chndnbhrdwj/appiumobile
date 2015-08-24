package pageobjects;

import pagecomponents.Button;

/**
 * Created by chandan on 8/22/2015.
 */
public class ProgramDetailPageVod extends ProgramDetailPage {

    Button buttonDownload;

    public ProgramDetailPageVod() {
        buttonDownload = new Button("Download");
    }

    public Player watchProgram() {
        buttonWatch.click();
        return new Player();
    }

}
