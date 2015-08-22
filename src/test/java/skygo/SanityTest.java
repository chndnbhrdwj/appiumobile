package skygo;

import org.junit.Test;
import pageobjects.HomePage;

/**
 * Created by cku04 on 17/08/2015.
 */
public class SanityTest{

    @Test
    public void testIt() throws Exception{
    new HomePage()
            .gotToMenuListPage()
            .goToSkyMoviesPage()
            .clickShowcaseItem()
            .watchProgram()
            .videoViewDisplayed();

    }
}
