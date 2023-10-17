package yuyu.app.base.system.rolekensaku;

import static yuyu.app.base.system.rolekensaku.GenRoleKensakuConstants.*;
import static yuyu.app.base.system.rolekensaku.GenRoleKensakuSelector.*;
import static yuyu.app.base.system.rolekensaku.SeleniumRoleKensakuConstants.*;

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
 * Selenium を使った ロール検索 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumRoleKensakuTest extends PackageAdminTest {

    private static final String targetKinouId1 = "roletouroku";
    private static final String targetKinouId2 = "rolekensaku";

    @Inject
    private BaseDomManager                       domManager;

    @Inject
    private MessageManager                       msgManager;

    @Inject
    private SeleniumRoleKensakuDB                roleKensakuDB;

    private AS_Kinou                             roleTouroku;
    private AS_Kinou                             roleKensaku;

    @Before
    public void beforeTest() {
        roleTouroku = domManager.getKinou(targetKinouId1);
        roleKensaku = domManager.getKinou(targetKinouId2);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();
    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0002(){

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0003(){

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0004(){

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_ROLECD, NOTROLECD);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0005(){

        roleKensakuDB.createTestB0005_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_NO);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        roleKensakuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006(){

        roleKensakuDB.createTestB0006_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        roleKensakuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007(){

        roleKensakuDB.createTestB0007_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        roleKensakuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008(){

        roleKensakuDB.createTestB0008_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        roleKensakuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009(){

        roleKensakuDB.createTestB0009_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(PAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        roleKensakuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010(){

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.closeChildWindow();

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0011(){

        roleKensakuDB.createTestB0011_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleKensaku);

        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleKensaku);
        pkgWebApp.clickButton(ROLECDLINK);

        pkgWebApp.takeScreenshot(roleKensaku);

        roleKensakuDB.deleteTestB0011_01();

    }
}

