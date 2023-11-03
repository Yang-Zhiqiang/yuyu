package yuyu.app.base.system.userkensaku;

import static yuyu.app.base.system.userkensaku.GenUserKensakuConstants.*;
import static yuyu.app.base.system.userkensaku.GenUserKensakuSelector.*;
import static yuyu.app.base.system.userkensaku.SeleniumUserKensakuConstants.*;

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
 * Selenium を使った ユーザー検索 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumUserKensakuTest extends PackageAdminTest {

    private static final String targetKinouId1 = "usertouroku";
    private static final String targetKinouId2 = "userkensaku";

    @Inject
    private BaseDomManager                       domManager;

    @Inject
    private MessageManager                       msgManager;

    @Inject
    private SeleniumUserKensakuDB                userKensakuDB;

    private AS_Kinou                             userTouroku;
    private AS_Kinou                             userKensaku;

    @Before
    public void beforeTest() {
        userTouroku = domManager.getKinou(targetKinouId1);
        userKensaku = domManager.getKinou(targetKinouId2);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0002(){

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(HEADERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0003(){

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0004(){

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERINFO_USERID, NOTUSERID);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0005(){

        userKensakuDB.createTestB0005_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_NO);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        userKensakuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006(){

        userKensakuDB.createTestB0006_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        userKensakuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007(){

        userKensakuDB.createTestB0007_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        userKensakuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008(){

        userKensakuDB.createTestB0008_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        userKensakuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009(){

        userKensakuDB.createTestB0009_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        userKensakuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010(){

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.closeChildWindow();

        pkgWebApp.takeScreenshot(userTouroku);

    }

    @Test
    public void testB0011(){

        userKensakuDB.createTestB0011_01();

        pkgWebApp.openKinou(userTouroku);
        pkgWebApp.assertTitle(userTouroku);
        pkgWebApp.takeScreenshot(userKensaku);

        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userKensaku);
        pkgWebApp.clickSearchButton(USERSENTAKULINK);

        pkgWebApp.takeScreenshot(userKensaku);

        userKensakuDB.deleteTestB0011_01();

    }
}

