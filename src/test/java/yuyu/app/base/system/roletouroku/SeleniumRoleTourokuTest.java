package yuyu.app.base.system.roletouroku;

import static yuyu.app.base.system.roletouroku.GenRoleTourokuConstants.*;
import static yuyu.app.base.system.roletouroku.GenRoleTourokuSelector.*;
import static yuyu.app.base.system.roletouroku.SeleniumRoleTourokuConstants.*;

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
 * Selenium を使った ロール登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumRoleTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "roletouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumRoleTourokuDB               roleTourokuDB;

    private AS_Kinou                            roleTouroku;

    @Before
    public void beforeTest() {
        roleTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0004() {

        roleTourokuDB.createTestB0004_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0004_01();

    }

    @Test
    public void testB0005() {

        roleTourokuDB.createTestB0005_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0007() {

        roleTourokuDB.createTestB0007_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0009() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.openChildWindowClick(ROLEKENSAKUBTN);

        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0010() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.close(roleTouroku);

    }

    @Test
    public void testB0011() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0012() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0013() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0014() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0015() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.close(roleTouroku);

    }

    @Test
    public void testB0016() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM, NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0017() {

        roleTourokuDB.createTestB0017_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testB0019() {

        roleTourokuDB.createTestB0019_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        roleTourokuDB.createTestB0020_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.close(roleTouroku);

    }

    @Test
    public void testB0022() {

        roleTourokuDB.createTestB0022_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0022_01();

    }

    @Test
    public void testB0023() {

        roleTourokuDB.createTestB0023_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestB0023_01();

    }

    @Test
    public void testB0024() {

        roleTourokuDB.createTestB0024_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD, ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.close(roleTouroku);

        roleTourokuDB.deleteTestB0024_01();

    }

    @Test
    public void testL0001() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      NEWROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        roleTourokuDB.createTestL0008_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        roleTourokuDB.createTestL0009_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        roleTourokuDB.createTestL0010_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        roleTourokuDB.createTestL0011_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        roleTourokuDB.createTestL0012_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        roleTourokuDB.createTestL0013_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        roleTourokuDB.createTestL0014_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        roleTourokuDB.createTestL0015_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        roleTourokuDB.createTestL0016_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0017_01();

    }

    @Test
    public void testL0018() {

        roleTourokuDB.createTestL0018_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0018_01();

    }

    @Test
    public void testL0019() {

        roleTourokuDB.createTestL0019_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0020() {

        roleTourokuDB.createTestL0020_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0021() {

        roleTourokuDB.createTestL0021_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0022() {

        roleTourokuDB.createTestL0022_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0023() {

        roleTourokuDB.createTestL0023_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0024() {

        roleTourokuDB.createTestL0024_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0025() {

        roleTourokuDB.createTestL0025_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0026() {

        roleTourokuDB.createTestL0026_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0027() {

        roleTourokuDB.createTestL0027_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0028() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0029() {

        roleTourokuDB.createTestL0029_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

    }

    @Test
    public void testL0030() {

        roleTourokuDB.createTestL0030_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        roleTourokuDB.createTestL0031_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        roleTourokuDB.createTestL0032_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0032_01();

    }

    @Test
    public void testL0033() {

        roleTourokuDB.createTestL0033_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0033_01();

    }

    @Test
    public void testL0034() {

        roleTourokuDB.createTestL0034_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0034_01();

    }

    @Test
    public void testL0035() {

        roleTourokuDB.createTestL0035_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0035_01();

    }

    @Test
    public void testL0036() {

        roleTourokuDB.createTestL0036_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0036_01();

    }

    @Test
    public void testL0037() {

        roleTourokuDB.createTestL0037_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0037_01();

    }

    @Test
    public void testL0038() {

        roleTourokuDB.createTestL0038_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0038_01();

    }

    @Test
    public void testL0039() {

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0039_01();

    }

    @Test
    public void testL0040() {

        roleTourokuDB.createTestL0040_01();

        pkgWebApp.openKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      NEWROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, NEWROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(roleTouroku);
        pkgWebApp.assertTitle(roleTouroku);
        pkgWebApp.takeScreenshot(roleTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLECD,      ALREADYROLECD);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLENM,      ALREADYROLENM);
        pkgWebApp.setToTextBox(DDID_KEYINFO_ROLESETUMEI, ALREADYROLESETUMEI);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(roleTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(roleTouroku);

        roleTourokuDB.deleteTestL0040_01();

    }
}

