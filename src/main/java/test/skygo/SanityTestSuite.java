package test.skygo;

/**
 * Created by cku04 on 26/08/2015.
 */

import core.Testcase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        SanityTest.class,
        StartupCharlesTest.class

})

public class SanityTestSuite extends Testcase {

}
