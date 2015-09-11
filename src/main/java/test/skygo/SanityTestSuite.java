package test.skygo;

/**
 * Created by cku04 on 26/08/2015.
 */

import core.Testcase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        SignInTest.class,
        SearchTest.class,
        HelpInfoNavigation.class,
        StartupCharlesTest.class,
        SettingsNavigation.class,
        VideoPlayerTest.class,
        FreeWheelTest.class,
        SignOutTest.class


})

public class SanityTestSuite extends Testcase {

}
