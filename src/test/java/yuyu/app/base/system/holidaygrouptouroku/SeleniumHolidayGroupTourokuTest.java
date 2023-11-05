package yuyu.app.base.system.holidaygrouptouroku;

import static yuyu.app.base.system.holidaygrouptouroku.GenHolidayGroupTourokuConstants.*;
import static yuyu.app.base.system.holidaygrouptouroku.GenHolidayGroupTourokuSelector.*;
import static yuyu.app.base.system.holidaygrouptouroku.SeleniumHolidayGroupTourokuConstants.*;

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
 * Selenium を使った 休日グループ登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumHolidayGroupTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "holidaygrouptouroku";

    @Inject
    private BaseDomManager                       domManager;

    @Inject
    private MessageManager                       msgManager;

    @Inject
    private SeleniumHolidayGroupTourokuDB        holidayGroupTourokuDB;

    private AS_Kinou                             holidayGroupTouroku;

    @Before
    public void beforeTest() {
        holidayGroupTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();
    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD, NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0004() {

        holidayGroupTourokuDB.createTestB0004_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD, ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0004_01();

    }

    @Test
    public void testB0005() {

        holidayGroupTourokuDB.createTestB0005_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        holidayGroupTourokuDB.createTestB0006_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0006_01();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0007() {

        holidayGroupTourokuDB.createTestB0007_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0009() {

        holidayGroupTourokuDB.createTestB0008_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0008_01();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0010() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.close(holidayGroupTouroku);

    }

    @Test
    public void testB0011() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD, NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0012() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0013() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0014() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0015() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,      NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.close(holidayGroupTouroku);

    }

    @Test
    public void testB0016() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0017() {

        holidayGroupTourokuDB.createTestB0017_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        holidayGroupTourokuDB.createTestB0018_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        holidayGroupTourokuDB.createTestB0018_02();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0018_02();
        holidayGroupTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testB0020() {

        holidayGroupTourokuDB.createTestB0020_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        holidayGroupTourokuDB.createTestB0021_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0021_01();

    }

    @Test
    public void testB0022() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.close(holidayGroupTouroku);

    }

    @Test
    public void testB0023() {

        holidayGroupTourokuDB.createTestB0023_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0023_01();

    }

    @Test
    public void testB0024() {

        holidayGroupTourokuDB.createTestB0024_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0024_01();

    }

    @Test
    public void testB0025() {

        holidayGroupTourokuDB.createTestB0025_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.close(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestB0025_01();

    }

    @Test
    public void testL0001() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          NEWHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        holidayGroupTourokuDB.createTestL0006_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        holidayGroupTourokuDB.createTestL0007_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        holidayGroupTourokuDB.createTestL0008_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        holidayGroupTourokuDB.createTestL0009_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        holidayGroupTourokuDB.createTestL0010_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        holidayGroupTourokuDB.createTestL0011_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        holidayGroupTourokuDB.createTestL0012_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        holidayGroupTourokuDB.createTestL0013_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        holidayGroupTourokuDB.createTestL0014_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        holidayGroupTourokuDB.createTestL0016_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        holidayGroupTourokuDB.createTestL0017_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0018() {

        holidayGroupTourokuDB.createTestL0018_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0019() {

        holidayGroupTourokuDB.createTestL0019_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0020() {

        holidayGroupTourokuDB.createTestL0020_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0021() {

        holidayGroupTourokuDB.createTestL0021_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0022() {

        holidayGroupTourokuDB.createTestL0022_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0023() {

        holidayGroupTourokuDB.createTestL0023_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0024() {

        holidayGroupTourokuDB.createTestL0024_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0025() {

        holidayGroupTourokuDB.createTestL0025_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0026() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0027() {

        holidayGroupTourokuDB.createTestL0027_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

    }

    @Test
    public void testL0028() {

        holidayGroupTourokuDB.createTestL0028_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0028_01();

    }

    @Test
    public void testL0029() {

        holidayGroupTourokuDB.createTestL0029_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0029_01();

    }

    @Test
    public void testL0030() {

        holidayGroupTourokuDB.createTestL0030_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        holidayGroupTourokuDB.createTestL0031_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        holidayGroupTourokuDB.createTestL0032_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0032_01();

    }

    @Test
    public void testL0033() {

        holidayGroupTourokuDB.createTestL0033_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0033_01();

    }

    @Test
    public void testL0034() {

        holidayGroupTourokuDB.createTestL0034_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0034_01();

    }

    @Test
    public void testL0035() {

        holidayGroupTourokuDB.createTestL0035_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0035_01();

    }

    @Test
    public void testL0036() {

        holidayGroupTourokuDB.createTestL0036_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0036_01();

    }

    @Test
    public void testL0037() {

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0037_01();

    }

    @Test
    public void testL0038() {

        holidayGroupTourokuDB.createTestL0038_01();

        pkgWebApp.openKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          NEWHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, NEWHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayGroupTouroku);
        pkgWebApp.assertTitle(holidayGroupTouroku);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPCD,          ALREADYHOLIDAYGROUPCD);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPNM,          ALREADYHOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_HOLIDAYGROUPINFO_HOLIDAYGROUPDESCRIPTION, ALREADYHOLIDAYGROUPBIKOU);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(holidayGroupTouroku);

        holidayGroupTourokuDB.deleteTestL0038_01();

    }
}

