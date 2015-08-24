package pageobjects;

import pagecomponents.Button;
import pagecomponents.ImageView;
import pageobjects.mainpages.HomePage;

/**
 * Created by chandan on 8/22/2015.
 */
public class ProgramDetailPage extends HomePage {

    Button buttonWatch, buttonDownload;
    ImageView programImage;

    public ProgramDetailPage() {
        //buttonDownload = new Button("Download");
        buttonWatch = new Button("Watch");
        programImage = new ImageView("com.bskyb.skygo:id/programme_image");
    }

    public Player watchProgram() {
        buttonWatch.click();
        return new Player();
    }

}
