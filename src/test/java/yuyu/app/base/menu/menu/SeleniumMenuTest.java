package yuyu.app.base.menu.menu;

import static yuyu.app.base.menu.login.GenLoginConstants.*;
import static yuyu.app.base.menu.menu.GenMenuConstants.*;
import static yuyu.app.base.menu.menu.GenMenuSelector.*;
import static yuyu.app.base.menu.menu.SeleniumMenuConstants.*;

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
 * ブラウザテストツール Selenium を使って メニュー 機能をテストします。<br />
 * <ul>
 *  <li>DBは「初期データ」の状態であることが前提です。</li>
 *  <li>このテストを実行する前に、予め base-pkg Webアプリケーション（tomcat）を起動しておいてください。</li>
 * </ul>
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumMenuTest {


    private static final String targetKinouId = "menu";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    private AS_Kinou                            menu;

    @Inject
    private PackageWebApp                       basePkg;

    @Before
    public void beforeTest() {
        menu        = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        basePkg.close();
    }

    @Test
    public void testB0001() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);

    }

    @Test
    public void testB0002() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.takeScreenshot(menu);

    }

    @Test
    public void testB0003() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(MYMENUTOUROKUBTN_MENUFOOTERBUTTONS);

        basePkg.assertPageNo(PAGENO_MYMENUTOUROKU);
        basePkg.takeScreenshot(menu);

    }

    @Test
    public void testB0004() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);

        basePkg.takeScreenshot(menu);
        basePkg.closeNewWindow();

    }

    @Test
    public void testB0005() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.openNewWindowClick(ROLETOUROKULINK);

        basePkg.takeScreenshot(menu);
        basePkg.closeNewWindow();

    }

    @Test
    public void testB0006() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(LOGINBTN);

        basePkg.takeScreenshot(menu);
        basePkg.clickLink(LOGINGAMENHELINK);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);

    }

    @Test
    public void testB0007() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(MYMENUTOUROKUBTN_MENUFOOTERBUTTONS);

        basePkg.assertPageNo(PAGENO_MYMENUTOUROKU);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(KAKUTEIBTN_MYMENUTOUROKUBUTTONS);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);

    }

    @Test
    public void testB0008() {

        basePkg.open();
        basePkg.takeScreenshot(menu);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.setToTextBox(DDID_LOGININPUT_USERID,   LOGINUSERID);
        basePkg.setToTextBox(DDID_LOGININPUT_PASSWORD, LOGINPASSWORD);
        basePkg.clickButton(LOGINBTN);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(MYMENUTOUROKUBTN_MENUFOOTERBUTTONS);

        basePkg.assertPageNo(PAGENO_MYMENUTOUROKU);
        basePkg.takeScreenshot(menu);
        basePkg.clickButton(TORIKESIBTN_MYMENUTOUROKUBUTTONS);

        basePkg.assertPageNo(PAGENO_LOGIN);
        basePkg.takeScreenshot(menu);

    }
}
