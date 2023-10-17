package yuyu.app.base.menu.login;

import static yuyu.app.base.menu.login.GenLoginConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.selenium.PackageWebApp;

/**
 * Selenium を使って、ログイン機能の動作をテストします。
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumLoginTest {


    private static final String targetKinouId = "login";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    private AS_Kinou                            login;

    @Inject
    private PackageWebApp                       basePkg;

    @Before
    public void beforeTest() {
        login = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        basePkg.close();
    }

    @Test
    public void testB0001() {

        basePkg.open();
        basePkg.takeScreenshot(login);

    }

    @Test
    public void testB0002() {

        basePkg.open();
        basePkg.takeScreenshot(login);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(login);
        //basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        //basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        //basePkg.clickButton(LOGINBTN_BUTTONLOGIN);

        basePkg.takeScreenshot(login);

    }

    @Test
    public void testB0003() {

        basePkg.open();
        basePkg.takeScreenshot(login);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(login);
        //basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        //basePkg.clickButton(LOGINBTN_BUTTONLOGIN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(login);

    }
}
