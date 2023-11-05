package yuyu.app.base.system.kinouteigitouroku;

import static yuyu.app.base.system.kinouteigitouroku.GenKinouTeigiTourokuConstants.*;
import static yuyu.app.base.system.kinouteigitouroku.GenKinouTeigiTourokuSelector.*;
import static yuyu.app.base.system.kinouteigitouroku.SeleniumKinouTeigiTourokuConstants.*;

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
 * Selenium を使った 機能定義登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumKinouTeigiTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "kinouteigitouroku";

    @Inject
    private BaseDomManager                       domManager;

    @Inject
    private MessageManager                       msgManager;

    @Inject
    private SeleniumKinouTeigiTourokuDB          kinouTeigiTourokuDB;

    private AS_Kinou                             kinouTeigiTouroku;

    @Before
    public void beforeTest() {
        kinouTeigiTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();
    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SEARCHBTN_BUTTONSELECT);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

    }

    @Test
    public void testB0004() {

        kinouTeigiTourokuDB.createTestB0004_01();
        kinouTeigiTourokuDB.createTestB0004_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0004_01();

    }

    @Test
    public void testB0005() {

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.close(kinouTeigiTouroku);

    }

    @Test
    public void testB0006() {

        kinouTeigiTourokuDB.createTestB0006_01();
        kinouTeigiTourokuDB.createTestB0006_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007() {

        kinouTeigiTourokuDB.createTestB0007_01();
        kinouTeigiTourokuDB.createTestB0007_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        kinouTeigiTourokuDB.createTestB0008_01();
        kinouTeigiTourokuDB.createTestB0008_02();
        kinouTeigiTourokuDB.createTestB0008_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        kinouTeigiTourokuDB.deleteTestB0008_02();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 3, true);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009() {

        kinouTeigiTourokuDB.createTestB0009_01();
        kinouTeigiTourokuDB.createTestB0009_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(ALLCHECKBTN_BUTTONCHECK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010() {

        kinouTeigiTourokuDB.createTestB0010_01();
        kinouTeigiTourokuDB.createTestB0010_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(ALLUNCHECKBTN_BUTTONCHECK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        kinouTeigiTourokuDB.createTestB0011_01();
        kinouTeigiTourokuDB.createTestB0011_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0011_01();

    }

    @Test
    public void testB0012() {

        kinouTeigiTourokuDB.createTestB0012_01();
        kinouTeigiTourokuDB.createTestB0012_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.close(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0012_01();

    }

    @Test
    public void testB0013() {

        kinouTeigiTourokuDB.createTestB0013_01();
        kinouTeigiTourokuDB.createTestB0013_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0013_01();

    }

    @Test
    public void testB0014() {

        kinouTeigiTourokuDB.createTestB0014_01();
        kinouTeigiTourokuDB.createTestB0014_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0014_01();

    }

    @Test
    public void testB0015() {

        kinouTeigiTourokuDB.createTestB0015_01();
        kinouTeigiTourokuDB.createTestB0015_02();
        kinouTeigiTourokuDB.createTestB0015_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 3, true);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        kinouTeigiTourokuDB.deleteTestB0015_02();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0015_01();

    }

    @Test
    public void testB0016() {

        kinouTeigiTourokuDB.createTestB0016_01();
        kinouTeigiTourokuDB.createTestB0016_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 3, true);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        kinouTeigiTourokuDB.createTestB0017_01();
        kinouTeigiTourokuDB.createTestB0017_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 3, true);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.close(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        kinouTeigiTourokuDB.createTestB0018_01();
        kinouTeigiTourokuDB.createTestB0018_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        kinouTeigiTourokuDB.createTestB0019_01();
        kinouTeigiTourokuDB.createTestB0019_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        kinouTeigiTourokuDB.createTestB0020_01();
        kinouTeigiTourokuDB.createTestB0020_02();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.close(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testL0001() {

        kinouTeigiTourokuDB.createTestL0001_01();
        kinouTeigiTourokuDB.createTestL0001_02();
        kinouTeigiTourokuDB.createTestL0001_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        kinouTeigiTourokuDB.createTestL0002_01();
        kinouTeigiTourokuDB.createTestL0002_02();
        kinouTeigiTourokuDB.createTestL0002_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        kinouTeigiTourokuDB.createTestL0003_01();
        kinouTeigiTourokuDB.createTestL0003_02();
        kinouTeigiTourokuDB.createTestL0003_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        kinouTeigiTourokuDB.createTestL0004_01();
        kinouTeigiTourokuDB.createTestL0004_02();
        kinouTeigiTourokuDB.createTestL0004_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        kinouTeigiTourokuDB.createTestL0005_01();
        kinouTeigiTourokuDB.createTestL0005_02();
        kinouTeigiTourokuDB.createTestL0005_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        kinouTeigiTourokuDB.createTestL0006_01();
        kinouTeigiTourokuDB.createTestL0006_02();
        kinouTeigiTourokuDB.createTestL0006_03();
        kinouTeigiTourokuDB.createTestL0006_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        kinouTeigiTourokuDB.createTestL0007_01();
        kinouTeigiTourokuDB.createTestL0007_02();
        kinouTeigiTourokuDB.createTestL0007_03();
        kinouTeigiTourokuDB.createTestL0007_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        kinouTeigiTourokuDB.createTestL0008_01();
        kinouTeigiTourokuDB.createTestL0008_02();
        kinouTeigiTourokuDB.createTestL0008_03();
        kinouTeigiTourokuDB.createTestL0008_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        kinouTeigiTourokuDB.createTestL0009_01();
        kinouTeigiTourokuDB.createTestL0009_02();
        kinouTeigiTourokuDB.createTestL0009_03();
        kinouTeigiTourokuDB.createTestL0009_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        kinouTeigiTourokuDB.createTestL0010_01();
        kinouTeigiTourokuDB.createTestL0010_02();
        kinouTeigiTourokuDB.createTestL0010_03();
        kinouTeigiTourokuDB.createTestL0010_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        kinouTeigiTourokuDB.createTestL0011_01();
        kinouTeigiTourokuDB.createTestL0011_02();
        kinouTeigiTourokuDB.createTestL0011_03();
        kinouTeigiTourokuDB.createTestL0011_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        kinouTeigiTourokuDB.createTestL0012_01();
        kinouTeigiTourokuDB.createTestL0012_02();
        kinouTeigiTourokuDB.createTestL0012_03();
        kinouTeigiTourokuDB.createTestL0012_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        kinouTeigiTourokuDB.createTestL0013_01();
        kinouTeigiTourokuDB.createTestL0013_02();
        kinouTeigiTourokuDB.createTestL0013_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        kinouTeigiTourokuDB.createTestL0014_01();
        kinouTeigiTourokuDB.createTestL0014_02();
        kinouTeigiTourokuDB.createTestL0014_03();
        kinouTeigiTourokuDB.createTestL0014_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        kinouTeigiTourokuDB.createTestL0015_01();
        kinouTeigiTourokuDB.createTestL0015_02();
        kinouTeigiTourokuDB.createTestL0015_03();
        kinouTeigiTourokuDB.createTestL0015_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        kinouTeigiTourokuDB.createTestL0016_01();
        kinouTeigiTourokuDB.createTestL0016_02();
        kinouTeigiTourokuDB.createTestL0016_03();
        kinouTeigiTourokuDB.createTestL0016_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        kinouTeigiTourokuDB.createTestL0017_01();
        kinouTeigiTourokuDB.createTestL0017_02();
        kinouTeigiTourokuDB.createTestL0017_03();
        kinouTeigiTourokuDB.createTestL0017_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0017_01();

    }

    @Test
    public void testL0018() {

        kinouTeigiTourokuDB.createTestL0018_01();
        kinouTeigiTourokuDB.createTestL0018_02();
        kinouTeigiTourokuDB.createTestL0018_03();
        kinouTeigiTourokuDB.createTestL0018_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0018_01();

    }

    @Test
    public void testL0019() {

        kinouTeigiTourokuDB.createTestL0019_01();
        kinouTeigiTourokuDB.createTestL0019_02();
        kinouTeigiTourokuDB.createTestL0019_03();
        kinouTeigiTourokuDB.createTestL0019_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0019_01();

    }

    @Test
    public void testL0020() {

        kinouTeigiTourokuDB.createTestL0020_01();
        kinouTeigiTourokuDB.createTestL0020_02();
        kinouTeigiTourokuDB.createTestL0020_03();
        kinouTeigiTourokuDB.createTestL0020_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0020_01();

    }

    @Test
    public void testL0021() {

        kinouTeigiTourokuDB.createTestL0021_01();
        kinouTeigiTourokuDB.createTestL0021_02();
        kinouTeigiTourokuDB.createTestL0021_03();
        kinouTeigiTourokuDB.createTestL0021_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0021_01();

    }

    @Test
    public void testL0022() {

        kinouTeigiTourokuDB.createTestL0022_01();
        kinouTeigiTourokuDB.createTestL0022_02();
        kinouTeigiTourokuDB.createTestL0022_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0022_01();

    }

    @Test
    public void testL0023() {

        kinouTeigiTourokuDB.createTestL0023_01();
        kinouTeigiTourokuDB.createTestL0023_02();
        kinouTeigiTourokuDB.createTestL0023_03();
        kinouTeigiTourokuDB.createTestL0023_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0023_01();

    }

    @Test
    public void testL0024() {

        kinouTeigiTourokuDB.createTestL0024_01();
        kinouTeigiTourokuDB.createTestL0024_02();
        kinouTeigiTourokuDB.createTestL0024_03();
        kinouTeigiTourokuDB.createTestL0024_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0024_01();

    }

    @Test
    public void testL0025() {

        kinouTeigiTourokuDB.createTestL0025_01();
        kinouTeigiTourokuDB.createTestL0025_02();
        kinouTeigiTourokuDB.createTestL0025_03();
        kinouTeigiTourokuDB.createTestL0025_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0025_01();

    }

    @Test
    public void testL0026() {

        kinouTeigiTourokuDB.createTestL0026_01();
        kinouTeigiTourokuDB.createTestL0026_02();
        kinouTeigiTourokuDB.createTestL0026_03();
        kinouTeigiTourokuDB.createTestL0026_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0026_01();

    }

    @Test
    public void testL0027() {

        kinouTeigiTourokuDB.createTestL0027_01();
        kinouTeigiTourokuDB.createTestL0027_02();
        kinouTeigiTourokuDB.createTestL0027_03();
        kinouTeigiTourokuDB.createTestL0027_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0027_01();

    }

    @Test
    public void testL0028() {

        kinouTeigiTourokuDB.createTestL0028_01();
        kinouTeigiTourokuDB.createTestL0028_02();
        kinouTeigiTourokuDB.createTestL0028_03();
        kinouTeigiTourokuDB.createTestL0028_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0028_01();

    }

    @Test
    public void testL0029() {

        kinouTeigiTourokuDB.createTestL0029_01();
        kinouTeigiTourokuDB.createTestL0029_02();
        kinouTeigiTourokuDB.createTestL0029_03();
        kinouTeigiTourokuDB.createTestL0029_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0029_01();

    }

    @Test
    public void testL0030() {

        kinouTeigiTourokuDB.createTestL0030_01();
        kinouTeigiTourokuDB.createTestL0030_02();
        kinouTeigiTourokuDB.createTestL0030_03();
        kinouTeigiTourokuDB.createTestL0030_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        kinouTeigiTourokuDB.createTestL0031_01();
        kinouTeigiTourokuDB.createTestL0031_02();
        kinouTeigiTourokuDB.createTestL0031_03();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        kinouTeigiTourokuDB.createTestL0032_01();
        kinouTeigiTourokuDB.createTestL0032_02();
        kinouTeigiTourokuDB.createTestL0032_03();
        kinouTeigiTourokuDB.createTestL0032_04();

        pkgWebApp.openKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID2);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kinouTeigiTouroku);
        pkgWebApp.assertTitle(kinouTeigiTouroku);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX, 0, false);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.setToCheckBox(DDID_KENGENSETTEILIST_COMMONCHECKBOX,0, true);
        pkgWebApp.setToKubun(DDID_KENGENSETTEILIST_SIBORIKOMIID, 0, ALREADYKINOUMODESIBORIKOMIID1);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kinouTeigiTouroku);

        kinouTeigiTourokuDB.deleteTestL0032_01();

    }
}

