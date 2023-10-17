package yuyu.app.base.system.usergrouptouroku;

import static yuyu.app.base.system.usergrouptouroku.GenUserGroupTourokuConstants.*;
import static yuyu.app.base.system.usergrouptouroku.GenUserGroupTourokuSelector.*;
import static yuyu.app.base.system.usergrouptouroku.SeleniumUserGroupTourokuConstants.*;

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
 * Selenium を使った ユーザーグループ登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumUserGroupTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "usergrouptouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumUserGroupTourokuDB          userGroupTourokuDB;

    private AS_Kinou                            userGroupTouroku;

    @Before
    public void beforeTest() {
        userGroupTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.openChildWindowClick(USERGROUPKENSAKUBTN);

        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0005() {

        userGroupTourokuDB.createTestB0005_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        userGroupTourokuDB.createTestB0006_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0008() {

        userGroupTourokuDB.createTestB0008_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0010() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.close(userGroupTouroku);

    }

    @Test
    public void testB0011() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0012() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0013() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM,      NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0014() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0015() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.close(userGroupTouroku);

    }

    @Test
    public void testB0016() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM,      NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0017() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM,      NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testB0018() {

        userGroupTourokuDB.createTestB0018_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        userGroupTourokuDB.createTestB0019_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        userGroupTourokuDB.createTestB0020_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      NEWUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM,      NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.close(userGroupTouroku);

    }

    @Test
    public void testB0022() {

        userGroupTourokuDB.createTestB0022_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0022_01();

    }

    @Test
    public void testB0023() {

        userGroupTourokuDB.createTestB0023_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0023_01();

    }

    @Test
    public void testB0024() {

        userGroupTourokuDB.createTestB0024_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD,      ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.close(userGroupTouroku);

        userGroupTourokuDB.deleteTestB0024_01();

    }

    @Test
    public void testL0001() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        userGroupTourokuDB.createTestL0008_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        userGroupTourokuDB.createTestL0009_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        userGroupTourokuDB.createTestL0010_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        userGroupTourokuDB.createTestL0011_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        userGroupTourokuDB.createTestL0012_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        userGroupTourokuDB.createTestL0013_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        userGroupTourokuDB.createTestL0014_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        userGroupTourokuDB.createTestL0015_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        userGroupTourokuDB.createTestL0016_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0017_01();

    }

    @Test
    public void testL0018() {

        userGroupTourokuDB.createTestL0018_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0018_01();

    }

    @Test
    public void testL0019() {

        userGroupTourokuDB.createTestL0019_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0020() {

        userGroupTourokuDB.createTestL0020_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0021() {

        userGroupTourokuDB.createTestL0021_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0022() {

        userGroupTourokuDB.createTestL0022_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0023() {

        userGroupTourokuDB.createTestL0023_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0024() {

        userGroupTourokuDB.createTestL0024_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0025() {

        userGroupTourokuDB.createTestL0025_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0026() {

        userGroupTourokuDB.createTestL0026_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0027() {

        userGroupTourokuDB.createTestL0027_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0028() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0029() {

        userGroupTourokuDB.createTestL0029_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

    }

    @Test
    public void testL0030() {

        userGroupTourokuDB.createTestL0030_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        userGroupTourokuDB.createTestL0031_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        userGroupTourokuDB.createTestL0032_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0032_01();

    }

    @Test
    public void testL0033() {

        userGroupTourokuDB.createTestL0033_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0033_01();

    }

    @Test
    public void testL0034() {

        userGroupTourokuDB.createTestL0034_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0034_01();

    }

    @Test
    public void testL0035() {

        userGroupTourokuDB.createTestL0035_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0035_01();

    }

    @Test
    public void testL0036() {

        userGroupTourokuDB.createTestL0036_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0036_01();

    }

    @Test
    public void testL0037() {

        userGroupTourokuDB.createTestL0037_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0037_01();

    }

    @Test
    public void testL0038() {

        userGroupTourokuDB.createTestL0038_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0038_01();

    }

    @Test
    public void testL0039() {

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0039_01();

    }

    @Test
    public void testL0040() {

        userGroupTourokuDB.createTestL0040_01();

        pkgWebApp.openKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(HENKOUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, NEWUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, NEWUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(userGroupTouroku);
        pkgWebApp.assertTitle(userGroupTouroku);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPCD, ALREADYUSERGROUPCD);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPNM, ALREADYUSERGROUPNM);
        pkgWebApp.setToTextBox(DDID_USERGROUPINFO_USERGROUPSETUMEI, ALREADYUSERGROUPSETUMEI);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(userGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(userGroupTouroku);

        userGroupTourokuDB.deleteTestL0040_01();

    }
}

