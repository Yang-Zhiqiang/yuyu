package yuyu.app.base.system.holidaytouroku;

import static yuyu.app.base.system.holidaytouroku.GenHolidayTourokuConstants.*;
import static yuyu.app.base.system.holidaytouroku.GenHolidayTourokuSelector.*;
import static yuyu.app.base.system.holidaytouroku.SeleniumHolidayTourokuConstants.*;

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
 * Selenium を使った 休日登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumHolidayTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "holidaytouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumHolidayTourokuDB            holidayTourokuDB;

    private AS_Kinou                            holidayTouroku;

    @Before
    public void beforeTest() {
        holidayTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testB0003() {

        holidayTourokuDB.createTestB0003_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0003_01();

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.close(holidayTouroku);

    }

    @Test
    public void testB0005() {

        holidayTourokuDB.createTestB0005_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        holidayTourokuDB.createTestB0006_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007() {

        holidayTourokuDB.createTestB0007_01();
        holidayTourokuDB.createTestB0007_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        holidayTourokuDB.createTestB0008_01();
        holidayTourokuDB.createTestB0008_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009() {

        holidayTourokuDB.createTestB0009_01();
        holidayTourokuDB.createTestB0009_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010() {

        holidayTourokuDB.createTestB0010_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYSELECTKEY_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        holidayTourokuDB.createTestB0011_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.close(holidayTouroku);

        holidayTourokuDB.deleteTestB0011_01();

    }

    @Test
    public void testB0012() {

        holidayTourokuDB.createTestB0012_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0012_01();

    }

    @Test
    public void testB0013() {

        holidayTourokuDB.createTestB0013_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0013_01();

    }

    @Test
    public void testB0014() {

        holidayTourokuDB.createTestB0014_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0014_01();

    }

    @Test
    public void testB0015() {

        holidayTourokuDB.createTestB0015_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0015_01();

    }

    @Test
    public void testB0016() {

        holidayTourokuDB.createTestB0016_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.close(holidayTouroku);

        holidayTourokuDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        holidayTourokuDB.createTestB0017_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        holidayTourokuDB.createTestB0018_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        holidayTourokuDB.createTestB0019_01();
        holidayTourokuDB.createTestB0019_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        holidayTourokuDB.createTestB0020_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, NEWHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.close(holidayTouroku);

        holidayTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        holidayTourokuDB.createTestB0021_01();
        holidayTourokuDB.createTestB0021_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0021_01();

    }

    @Test
    public void testB0022() {

        holidayTourokuDB.createTestB0022_01();
        holidayTourokuDB.createTestB0022_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestB0022_01();

    }

    @Test
    public void testB0023() {

        holidayTourokuDB.createTestB0023_01();
        holidayTourokuDB.createTestB0023_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.close(holidayTouroku);

        holidayTourokuDB.deleteTestB0023_01();

    }

    @Test
    public void testL0001() {

        holidayTourokuDB.createTestL0001_01();
        holidayTourokuDB.createTestL0001_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        holidayTourokuDB.createTestL0002_01();
        holidayTourokuDB.createTestL0002_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        holidayTourokuDB.createTestL0003_01();
        holidayTourokuDB.createTestL0003_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        holidayTourokuDB.createTestL0004_01();
        holidayTourokuDB.createTestL0004_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        holidayTourokuDB.createTestL0005_01();
        holidayTourokuDB.createTestL0005_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        holidayTourokuDB.createTestL0006_01();
        holidayTourokuDB.createTestL0006_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        holidayTourokuDB.createTestL0007_01();
        holidayTourokuDB.createTestL0007_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        holidayTourokuDB.createTestL0008_01();
        holidayTourokuDB.createTestL0008_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        holidayTourokuDB.createTestL0009_01();
        holidayTourokuDB.createTestL0009_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        holidayTourokuDB.createTestL0010_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, ALREADYHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        holidayTourokuDB.createTestL0011_01();
        holidayTourokuDB.createTestL0011_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, ALREADYHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

        holidayTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        holidayTourokuDB.createTestL0012_01();
        holidayTourokuDB.createTestL0012_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0013() {

        holidayTourokuDB.createTestL0013_01();
        holidayTourokuDB.createTestL0013_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0014() {

        holidayTourokuDB.createTestL0014_01();
        holidayTourokuDB.createTestL0014_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0015() {

        holidayTourokuDB.createTestL0015_01();
        holidayTourokuDB.createTestL0015_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0016() {

        holidayTourokuDB.createTestL0016_01();
        holidayTourokuDB.createTestL0016_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0017() {

        holidayTourokuDB.createTestL0017_01();
        holidayTourokuDB.createTestL0017_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0018() {

        holidayTourokuDB.createTestL0018_01();
        holidayTourokuDB.createTestL0018_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0019() {

        holidayTourokuDB.createTestL0019_01();
        holidayTourokuDB.createTestL0019_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0020() {

        holidayTourokuDB.createTestL0020_01();
        holidayTourokuDB.createTestL0020_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0021() {

        holidayTourokuDB.createTestL0021_01();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERN_HOLIDAYPATTERNNM, ALREADYHOLIDAYPATTERNNM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDFROM, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.setToTextBox(DDID_HOLIDAYPATTERNINFOINPUT_TEKIYOUYMDTO, holidayTourokuDB.getSeirekiWareki());
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

    }

    @Test
    public void testL0022() {

        holidayTourokuDB.createTestL0022_01();
        holidayTourokuDB.createTestL0022_02();

        pkgWebApp.openKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.setToKubun(DDID_HOLIDAYPATTERNINFOINPUT_LEGALHOLIDAYKBN, NEWHOLIDAYLEGALHOLIDAYKBN);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(holidayTouroku);
        pkgWebApp.assertTitle(holidayTouroku);
        pkgWebApp.takeScreenshot(holidayTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HOLIDAYGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(holidayTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(holidayTouroku);

    }

}

