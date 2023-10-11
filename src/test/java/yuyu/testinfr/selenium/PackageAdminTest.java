package yuyu.testinfr.selenium;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(SWAKTestRunner.class)
public abstract class PackageAdminTest {

    private static final String userId   = "administrator";
    private static final String password = "password";

    protected static PackageWebApp pkgWebApp = SWAKInjector.getInstance(PackageWebApp.class);

    @BeforeClass
    public static void setup() {
        pkgWebApp.open();
        pkgWebApp.login(userId, password);
    }

    @AfterClass
    public static void teardown() {
        pkgWebApp.logout();
        pkgWebApp.quit();
    }

}
