package yuyu.app.base.system.useritiranhyou;

import static yuyu.app.base.system.useritiranhyou.GenUserItiranhyouConstants.*;
import static yuyu.app.base.system.useritiranhyou.GenUserItiranhyouSelector.*;
import static yuyu.app.base.system.useritiranhyou.SeleniumUserItiranhyouConstants.*;

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
 * Selenium を使った 稼働時間登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumUserItiranhyouTest extends PackageAdminTest {

    private static final String targetKinouId = "useritiranhyou";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumUserItiranhyouDB            userItiranhyouDB;

    private AS_Kinou                            userItiranhyou;

    @Before
    public void beforeTest() {
        userItiranhyou = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userItiranhyou);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.openNewWindowClick(KAKUTEIBTN_FOOTERBUTTONS);

        pkgWebApp.closeNewWindow();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userItiranhyou);

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.openNewWindowClick(KAKUTEIBTN_FOOTERBUTTONS);

        pkgWebApp.takeScreenshot(userItiranhyou);
        pkgWebApp.closeNewWindow();

    }

    @Test
    public void testB0005() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userItiranhyou);
        pkgWebApp.close(userItiranhyou);

    }

    @Test
    public void testB0006() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.openNewWindowClick(KAKUTEIBTN_FOOTERBUTTONS);

        pkgWebApp.closeNewWindow();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userItiranhyou);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userItiranhyou);

    }

    @Test
    public void testB0007() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.openNewWindowClick(KAKUTEIBTN_FOOTERBUTTONS);

        pkgWebApp.closeNewWindow();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userItiranhyou);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_FOOTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userItiranhyou);

    }

    @Test
    public void testB0008() {

        pkgWebApp.openKinou(userItiranhyou);
        pkgWebApp.assertTitle(userItiranhyou);
        pkgWebApp.takeScreenshot(userItiranhyou);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.openNewWindowClick(KAKUTEIBTN_FOOTERBUTTONS);

        pkgWebApp.closeNewWindow();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userItiranhyou);
        pkgWebApp.close(userItiranhyou);

    }
}

