package yuyu.app.base.system.kadoutimegrouptouroku;

import static yuyu.app.base.system.kadoutimegrouptouroku.GenKadouTimeGroupTourokuConstants.*;
import static yuyu.app.base.system.kadoutimegrouptouroku.GenKadouTimeGroupTourokuSelector.*;
import static yuyu.app.base.system.kadoutimegrouptouroku.SeleniumKadouTimeGroupTourokuConstants.*;

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
 * Selenium を使った 稼働時間グループ登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumKadouTimeGroupTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "kadoutimegrouptouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumKadouTimeGroupTourokuDB     kadouTimeGroupTourokuDB;

    private AS_Kinou                            kadouTimeGroupTouroku;

    @Before
    public void beforeTest() {
        kadouTimeGroupTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0004() {

        kadouTimeGroupTourokuDB.createTestB0004_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0004_01();

    }

    @Test
    public void testB0005() {

        kadouTimeGroupTourokuDB.createTestB0005_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        kadouTimeGroupTourokuDB.createTestB0006_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0006_01();

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.createTestB0004_01();

    }

    @Test
    public void testB0007() {

        kadouTimeGroupTourokuDB.createTestB0007_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        kadouTimeGroupTourokuDB.createTestB0008_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0008_01();

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0009() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.close(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0010() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0011() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0012() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0013() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0014() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.close(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0015() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0016() {

        kadouTimeGroupTourokuDB.createTestB0016_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        kadouTimeGroupTourokuDB.createTestB0017_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              ALREADYHOLIDAYGROUPCD);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        kadouTimeGroupTourokuDB.deleteTestB0017_01();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0018() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0019() {

        kadouTimeGroupTourokuDB.createTestB0019_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        kadouTimeGroupTourokuDB.createTestB0020_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, NEWKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.close(kadouTimeGroupTouroku);

    }

    @Test
    public void testB0022() {

        kadouTimeGroupTourokuDB.createTestB0022_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0022_01();
    }

    @Test
    public void testB0023() {

        kadouTimeGroupTourokuDB.createTestB0023_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0023_01();
    }

    @Test
    public void testB0024() {

        kadouTimeGroupTourokuDB.createTestB0024_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.close(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestB0024_01();

    }

    @Test
    public void testL0001() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,              ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        kadouTimeGroupTourokuDB.createTestL0006_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        kadouTimeGroupTourokuDB.createTestL0007_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        kadouTimeGroupTourokuDB.createTestL0008_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        kadouTimeGroupTourokuDB.createTestL0009_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        kadouTimeGroupTourokuDB.createTestL0010_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        kadouTimeGroupTourokuDB.createTestL0011_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        kadouTimeGroupTourokuDB.createTestL0012_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        kadouTimeGroupTourokuDB.createTestL0013_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        kadouTimeGroupTourokuDB.createTestL0014_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        kadouTimeGroupTourokuDB.createTestL0016_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        kadouTimeGroupTourokuDB.createTestL0017_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0018() {

        kadouTimeGroupTourokuDB.createTestL0018_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0019() {

        kadouTimeGroupTourokuDB.createTestL0019_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0020() {

        kadouTimeGroupTourokuDB.createTestL0020_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0021() {

        kadouTimeGroupTourokuDB.createTestL0021_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0022() {

        kadouTimeGroupTourokuDB.createTestL0022_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0023() {

        kadouTimeGroupTourokuDB.createTestL0023_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0024() {

        kadouTimeGroupTourokuDB.createTestL0024_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0025() {

        kadouTimeGroupTourokuDB.createTestL0025_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0026() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0027() {

        kadouTimeGroupTourokuDB.createTestL0027_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

    }

    @Test
    public void testL0028() {

        kadouTimeGroupTourokuDB.createTestL0028_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0028_01();

    }

    @Test
    public void testL0029() {

        kadouTimeGroupTourokuDB.createTestL0029_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0029_01();

    }

    @Test
    public void testL0030() {

        kadouTimeGroupTourokuDB.createTestL0030_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        kadouTimeGroupTourokuDB.createTestL0031_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        kadouTimeGroupTourokuDB.createTestL0032_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  NEWKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0032_01();

    }

    @Test
    public void testL0033() {

        kadouTimeGroupTourokuDB.createTestL0033_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0033_01();

    }

    @Test
    public void testL0034() {

        kadouTimeGroupTourokuDB.createTestL0034_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0034_01();

    }

    @Test
    public void testL0035() {

        kadouTimeGroupTourokuDB.createTestL0035_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0035_01();

    }

    @Test
    public void testL0036() {

        kadouTimeGroupTourokuDB.createTestL0036_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0036_01();

    }

    @Test
    public void testL0037() {

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0037_01();

    }

    @Test
    public void testL0038() {

        kadouTimeGroupTourokuDB.createTestL0038_01();

        pkgWebApp.openKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          NEWKADOUTIMEGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, NEWKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(kadouTimeGroupTouroku);
        pkgWebApp.assertTitle(kadouTimeGroupTouroku);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFOLIST_KADOUTIMEGROUPCD, ALREADYKADOUTIMEGROUPCD);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPNM,          ALREADYKADOUTIMEGROUPNM);
        pkgWebApp.setToKubun(DDID_KADOUTIMEGROUPINFO_HOLIDAYGROUPCD,  ALREADYKADOUTIMEGROUP_HOLIDAYGROUPNM);
        pkgWebApp.setToTextBox(DDID_KADOUTIMEGROUPINFO_KADOUTIMEGROUPDESCRIPTION, ALREADYKADOUTIMEGROUPBIKOU);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTKEY);
        pkgWebApp.takeScreenshot(kadouTimeGroupTouroku);

        kadouTimeGroupTourokuDB.deleteTestL0038_01();

    }
}

