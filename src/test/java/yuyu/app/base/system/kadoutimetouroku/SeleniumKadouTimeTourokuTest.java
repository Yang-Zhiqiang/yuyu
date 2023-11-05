package yuyu.app.base.system.kadoutimetouroku;

import static yuyu.app.base.system.kadoutimetouroku.GenKadouTimeTourokuConstants.*;
import static yuyu.app.base.system.kadoutimetouroku.GenKadouTimeTourokuSelector.*;
import static yuyu.app.base.system.kadoutimetouroku.SeleniumKadouTimeTourokuConstants.*;

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
public class SeleniumKadouTimeTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "kadoutimetouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumKadouTimeTourokuDB          kadouTimeTourokuDB;

    private AS_Kinou                            kadouTimeTouroku;

    @Before
    public void beforeTest() {
        kadouTimeTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

    }

    @Test
    public void testB0003() {

        kadouTimeTourokuDB.createTestB0003_01();
        kadouTimeTourokuDB.createTestB0003_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0003_01();

    }

    @Test
    public void testB0004() {

        kadouTimeTourokuDB.createTestB0004_01();
        kadouTimeTourokuDB.createTestB0004_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0004_01();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

    }

    @Test
    public void testB0005() {

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.close(kadouTimeTouroku);

    }

    @Test
    public void testB0006() {

        kadouTimeTourokuDB.createTestB0006_01();
        kadouTimeTourokuDB.createTestB0006_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0006_01();

    }

    @Test
    public void testB0007() {

        kadouTimeTourokuDB.createTestB0007_01();
        kadouTimeTourokuDB.createTestB0007_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        kadouTimeTourokuDB.createTestB0008_01();
        kadouTimeTourokuDB.createTestB0008_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYSELECTKEY_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0008_01();

    }

    @Test
    public void testB0009() {

        kadouTimeTourokuDB.createTestB0009_01();
        kadouTimeTourokuDB.createTestB0009_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.close(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010() {

        kadouTimeTourokuDB.createTestB0010_01();
        kadouTimeTourokuDB.createTestB0010_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        kadouTimeTourokuDB.createTestB0011_01();
        kadouTimeTourokuDB.createTestB0011_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0011_01();

    }

    @Test
    public void testB0012() {

        kadouTimeTourokuDB.createTestB0012_01();
        kadouTimeTourokuDB.createTestB0012_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0012_01();

    }

    @Test
    public void testB0013() {

        kadouTimeTourokuDB.createTestB0013_01();
        kadouTimeTourokuDB.createTestB0013_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0013_01();

    }

    @Test
    public void testB0014() {

        kadouTimeTourokuDB.createTestB0014_01();
        kadouTimeTourokuDB.createTestB0014_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.close(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0014_01();

    }

    @Test
    public void testB0015() {

        kadouTimeTourokuDB.createTestB0015_01();
        kadouTimeTourokuDB.createTestB0015_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0015_01();

    }

    @Test
    public void testB0016() {

        kadouTimeTourokuDB.createTestB0016_01();
        kadouTimeTourokuDB.createTestB0016_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        kadouTimeTourokuDB.createTestB0017_01();
        kadouTimeTourokuDB.createTestB0017_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        kadouTimeTourokuDB.createTestB0018_01();
        kadouTimeTourokuDB.createTestB0018_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.close(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        kadouTimeTourokuDB.createTestB0019_01();
        kadouTimeTourokuDB.createTestB0019_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        kadouTimeTourokuDB.createTestB0020_01();
        kadouTimeTourokuDB.createTestB0020_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        kadouTimeTourokuDB.createTestB0021_01();
        kadouTimeTourokuDB.createTestB0021_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.close(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestB0021_01();

    }

    @Test
    public void testL0001() {

        kadouTimeTourokuDB.createTestL0001_01();
        kadouTimeTourokuDB.createTestL0001_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        kadouTimeTourokuDB.createTestL0002_01();
        kadouTimeTourokuDB.createTestL0002_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        kadouTimeTourokuDB.createTestL0003_01();
        kadouTimeTourokuDB.createTestL0003_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        kadouTimeTourokuDB.createTestL0004_01();
        kadouTimeTourokuDB.createTestL0004_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        kadouTimeTourokuDB.createTestL0005_01();
        kadouTimeTourokuDB.createTestL0005_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        kadouTimeTourokuDB.createTestL0006_01();
        kadouTimeTourokuDB.createTestL0006_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        kadouTimeTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        kadouTimeTourokuDB.createTestL0007_01();
        kadouTimeTourokuDB.createTestL0007_02();

        pkgWebApp.openKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN2);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeTouroku);
        pkgWebApp.assertTitle(kadouTimeTouroku);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(KADOUTIMEGROUPCD);

        pkgWebApp.assertPageNo(PAGENO_SELECTKEY);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_KADOUTIMEINFOINPUT_KADOUTIMESITEIKBN, MODIFIEDKADOUTIMESITEIKBN3);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        kadouTimeTourokuDB.deleteTestL0007_01();

    }
}

