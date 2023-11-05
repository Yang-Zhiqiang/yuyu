package yuyu.app.base.system.usergroupkensaku;

import static yuyu.app.base.system.usergroupkensaku.GenUserGroupKensakuConstants.*;
import static yuyu.app.base.system.usergroupkensaku.GenUserGroupKensakuSelector.*;
import static yuyu.app.base.system.usergroupkensaku.SeleniumUserGroupKensakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.selenium.PackageAdminTest;

/**
 * Selenium を使った ユーザーグループ検索 機能の統合テストです。
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumUserGroupKensakuTest extends PackageAdminTest {

    private static final String targetKinouId1 = "usergrouptouroku";
    private static final String targetKinouId2 = "usergroupkensaku";

    @Inject
    private BaseDomManager                       domManager;

    @Inject
    private SeleniumUserGroupKensakuDB           userGroupKensakuDB;

    private AS_Kinou                             userGroupTouroku;
    private AS_Kinou                             userGroupKensaku;

    @Before
    public void beforeTest() {
        userGroupTouroku = domManager.getKinou(targetKinouId1);
        userGroupKensaku = domManager.getKinou(targetKinouId2);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testA0001() {

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(A_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testA0002() {

        userGroupKensakuDB.createTestA0002_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(A_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestA0002_01();

    }

    @Test
    public void testA0003() {

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(A_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testA0004() {

        userGroupKensakuDB.createTestA0004_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(A_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestA0004_01();

    }

    @Test
    public void testA0005() {

        userGroupKensakuDB.createTestA0005_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(A_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestA0005_01();
    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickButton(B_FUNCTIONNAME);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0003() {

        userGroupKensakuDB.createTestB0003_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0003_01();

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0005() {

        userGroupKensakuDB.createTestB0005_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_NO);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        userGroupKensakuDB.createTestB0006_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_R);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007() {

        userGroupKensakuDB.createTestB0007_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, B_ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_RR);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_L);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        userGroupKensakuDB.createTestB0008_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, B_ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_RR);

        pkgWebApp.getPageHTMLSource(userGroupKensaku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009() {

        userGroupKensakuDB.createTestB0009_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, B_ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_RR);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_PAGELINK_LL);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010() {

        userGroupKensakuDB.createTestB0010_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        pkgWebApp.takeScreenshot(userGroupKensaku);

        userGroupKensakuDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        userGroupKensakuDB.createTestB0011_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(B_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, B_ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(B_USERGROUPIDSENTAKU);

        pkgWebApp.takeScreenshot(userGroupKensaku);

        userGroupKensakuDB.deleteTestB0011_01();

    }

    @Test
    public void testC0001() {

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testC0002() {

        userGroupKensakuDB.createTestC0002_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickButton(C_FUNCTIONNAME);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0002_01();
    }

    @Test
    public void testC0003() {

        userGroupKensakuDB.createTestC0003_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0003_01();

    }

    @Test
    public void testC0004() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }


    @Test
    public void testC0005() {

        userGroupKensakuDB.createTestC0005_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_NO);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0005_01();

    }

    @Test
    public void testC0006() {

        userGroupKensakuDB.createTestC0006_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_R);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0006_01();

    }

    @Test
    public void testC0007() {

        userGroupKensakuDB.createTestC0007_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_RR);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_L);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0007_01();

    }

    @Test
    public void testC0008() {

        userGroupKensakuDB.createTestC0008_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_RR);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0008_01();

    }

    @Test
    public void testC0009() {

        userGroupKensakuDB.createTestC0009_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_RR);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_PAGELINK_LL);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0009_01();

    }

    @Test
    public void testC0010() {

        userGroupKensakuDB.createTestC0010_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_NOTUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestC0010_01();

    }

    @Test
    public void testC0011() {

        userGroupKensakuDB.createTestC0011_01();

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupKensaku);

        pkgWebApp.openChildWindowClick(C_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, C_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, C_ALREADYUSERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(C_USERGROUPIDSENTAKU);

        pkgWebApp.takeScreenshot(userGroupKensaku);

        userGroupKensakuDB.deleteTestC0011_01();

    }

    @Test
    public void testE0001() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(E_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, E_USERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, E_USERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testE0002() {

        userGroupKensakuDB.createTestE0002_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(E_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, E_USERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, E_USERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestE0002_01();

    }

    @Test
    public void testF0001() {

        userGroupKensakuDB.createTestF0001_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, F_USERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, F_USERGROUPNM);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestF0001_01();

    }

    @Test
    public void testF0002() {

        userGroupKensakuDB.createTestF0002_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, F_USERGROUPCD001);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestF0002_01();

    }

    @Test
    public void testF0003() {

        userGroupKensakuDB.createTestF0003_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, F_USERGROUPCD002);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestF0003_01();

    }

    @Test
    public void testF0004() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, F_USERGROUPCD003);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testF0005() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, F_USERGROUPCD004);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testF0006() {

        userGroupKensakuDB.createTestF0006_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, F_USERGROUPNM001);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestF0006_01();
    }


    @Test
    public void testF0007() {

        userGroupKensakuDB.createTestF0007_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(F_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, F_USERGROUPNM002);
        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestF0007_01();
    }

    @Test
    public void testH0001() {

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(H_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testH0002() {

        userGroupKensakuDB.createTestH0002_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(H_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestH0002_01();
    }

    @Test
    public void testL0001() {

        userGroupKensakuDB.createTestL0001_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(L_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, L_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, L_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, L_NOTUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, L_NOTUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, L_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, L_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestL0001_01();
    }

    @Test
    public void testL0002() {

        userGroupKensakuDB.createTestL0002_01();

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(L_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, L_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, L_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickButton(L_FUNCTIONNAME);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, L_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, L_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestL0002_01();
    }

    @Test
    public void testO0001() {

        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_NOTUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_NOTUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testO0002() {

        userGroupKensakuDB.createTestO0002_01();
        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestO0002_01();

    }

    @Test
    public void testO0003() {

        userGroupKensakuDB.createTestO0003_01();
        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestO0003_01();
    }

    @Test
    public void testO0004() {

        userGroupKensakuDB.createTestO0004_01();
        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestO0004_01();
    }

    @Test
    public void testO0005() {

        userGroupKensakuDB.createTestO0005_01();
        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestO0005_01();
    }

    @Test
    public void testO0006() {

        userGroupKensakuDB.createTestO0006_01();
        pkgWebApp.outCsv(userGroupKensaku, true);

        pkgWebApp.openKinou(userGroupTouroku);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.openChildWindowClick(O_USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPCD, O_ALREADYUSERGROUPCD);
        pkgWebApp.setToTextBox(DDID_SEARCHINFO_USERGROUPNM, O_ALREADYUSERGROUPNM);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.clickSearchButton(SEARCHBTN_BUTTONSERCH);

        pkgWebApp.takeScreenshot(userGroupKensaku);
        pkgWebApp.closeChildWindow();

        userGroupKensakuDB.deleteTestO0006_01();
    }
}

