package yuyu.app.base.menu.passwordhenkou;

import static yuyu.app.base.menu.passwordhenkou.PasswordHenkouConstants.*;
import static yuyu.app.base.menu.passwordhenkou.PasswordHenkouSelector.*;
import static yuyu.app.base.menu.passwordhenkou.SeleniumPasswordHenkouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.web.message.MessageManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.selenium.PackageAdminTest;

/**
 * ブラウザテストツール Selenium を使って メニュー 機能をテストします。<br />
 * <ul>
 *  <li>DBは「初期データ」の状態であることが前提です。</li>
 *  <li>このテストを実行する前に、予め base-pkg Webアプリケーション（tomcat）を起動しておいてください。</li>
 * </ul>
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumPasswordHenkouTest extends PackageAdminTest{

    private static final String targetKinouId = "passwordhenkou";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumPasswordHenkouDB            passwordHenkouDB;

    private AS_Kinou                            passwordHenkou;

    @Before
    public void beforeTest() {
        passwordHenkou = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();
    }

    @Test
    public void testB0001() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);

    }

    @Test
    public void testB0002() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);

    }

    @Test
    public void testB0003() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_OLDPASSWORD,     EXISTINGPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORD,        MODIFIEDPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORDKAKUNIN, MODIFIEDPASSWORD);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(passwordHenkou);

        passwordHenkouDB.modifiedTestB0003_01();

    }

    @Test
    public void testB0004() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_OLDPASSWORD,     EXISTINGPASSWORD);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);

    }

    @Test
    public void testB0005() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.closeNewWindow();

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

    }

    @Test
    public void testB0006() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_OLDPASSWORD,     EXISTINGPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORD,        MODIFIEDPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORDKAKUNIN, MODIFIEDPASSWORD);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);

        passwordHenkouDB.modifiedTestB0006_01();

    }

    @Test
    public void testB0007() {

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_OLDPASSWORD,     EXISTINGPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORD,        MODIFIEDPASSWORD);
        pkgWebApp.setToTextBox(DDID_PASSWORDINPUT_PASSWORDKAKUNIN, MODIFIEDPASSWORD);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.closeNewWindow();

        pkgWebApp.takeScreenshot(passwordHenkou);
        pkgWebApp.openNewWindowClick("passwordHenkouBtn");

        passwordHenkouDB.modifiedTestB0007_01();

    }
}
