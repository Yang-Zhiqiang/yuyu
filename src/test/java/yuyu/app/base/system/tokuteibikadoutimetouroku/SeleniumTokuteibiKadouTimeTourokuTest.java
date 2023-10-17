package yuyu.app.base.system.tokuteibikadoutimetouroku;

import static yuyu.app.base.system.tokuteibikadoutimetouroku.GenTokuteibiKadouTimeTourokuConstants.*;
import static yuyu.app.base.system.tokuteibikadoutimetouroku.GenTokuteibiKadouTimeTourokuSelector.*;
import static yuyu.app.base.system.tokuteibikadoutimetouroku.SeleniumTokuteibiKadouTimeTourokuConstants.*;

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
 * Selenium を使った 特定日稼働時間登録 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumTokuteibiKadouTimeTourokuTest extends PackageAdminTest {

    private static final String targetKinouId = "tokuteibikadoutimetouroku";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumTokuteibiKadouTimeTourokuDB tokuteibiKadouTimeTourokuDB;

    private AS_Kinou                            tokuteibiKadouTimeTouroku;

    @Before
    public void beforeTest() {
        tokuteibiKadouTimeTouroku = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0003() {

        tokuteibiKadouTimeTourokuDB.createTestB0003_01();
        tokuteibiKadouTimeTourokuDB.createTestB0003_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0003_01();

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0005() {

        tokuteibiKadouTimeTourokuDB.createTestB0005_01();
        tokuteibiKadouTimeTourokuDB.createTestB0005_02();
        tokuteibiKadouTimeTourokuDB.createTestB0005_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        tokuteibiKadouTimeTourokuDB.createTestB0006_01();
        tokuteibiKadouTimeTourokuDB.createTestB0006_02();
        tokuteibiKadouTimeTourokuDB.createTestB0006_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0006_01();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0007() {

        tokuteibiKadouTimeTourokuDB.createTestB0007_01();
        tokuteibiKadouTimeTourokuDB.createTestB0007_02();
        tokuteibiKadouTimeTourokuDB.createTestB0007_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        tokuteibiKadouTimeTourokuDB.createTestB0008_01();
        tokuteibiKadouTimeTourokuDB.createTestB0008_02();
        tokuteibiKadouTimeTourokuDB.createTestB0008_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0008_01();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0009() {

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.close(tokuteibiKadouTimeTouroku);

    }

    @Test
    public void testB0010() {

        tokuteibiKadouTimeTourokuDB.createTestB0010_01();
        tokuteibiKadouTimeTourokuDB.createTestB0010_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        tokuteibiKadouTimeTourokuDB.createTestB0011_01();
        tokuteibiKadouTimeTourokuDB.createTestB0011_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0011_01();

    }

    @Test
    public void testB0012() {

        tokuteibiKadouTimeTourokuDB.createTestB0012_01();
        tokuteibiKadouTimeTourokuDB.createTestB0012_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0012_01();

    }

    @Test
    public void testB0013() {

        tokuteibiKadouTimeTourokuDB.createTestB0013_01();
        tokuteibiKadouTimeTourokuDB.createTestB0013_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0013_01();

    }

    @Test
    public void testB0014() {

        tokuteibiKadouTimeTourokuDB.createTestB0014_01();
        tokuteibiKadouTimeTourokuDB.createTestB0014_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.close(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0014_01();

    }

    @Test
    public void testB0015() {

        tokuteibiKadouTimeTourokuDB.createTestB0015_01();
        tokuteibiKadouTimeTourokuDB.createTestB0015_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0015_01();

    }

    @Test
    public void testB0016() {

        tokuteibiKadouTimeTourokuDB.createTestB0016_01();
        tokuteibiKadouTimeTourokuDB.createTestB0016_02();
        tokuteibiKadouTimeTourokuDB.createTestB0016_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        tokuteibiKadouTimeTourokuDB.createTestB0017_01();
        tokuteibiKadouTimeTourokuDB.createTestB0017_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        tokuteibiKadouTimeTourokuDB.createTestB0018_01();
        tokuteibiKadouTimeTourokuDB.createTestB0018_02();
        tokuteibiKadouTimeTourokuDB.createTestB0018_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        tokuteibiKadouTimeTourokuDB.createTestB0019_01();
        tokuteibiKadouTimeTourokuDB.createTestB0019_02();
        tokuteibiKadouTimeTourokuDB.createTestB0019_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        tokuteibiKadouTimeTourokuDB.createTestB0020_01();
        tokuteibiKadouTimeTourokuDB.createTestB0020_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.close(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        tokuteibiKadouTimeTourokuDB.createTestB0021_01();
        tokuteibiKadouTimeTourokuDB.createTestB0021_02();
        tokuteibiKadouTimeTourokuDB.createTestB0021_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0021_01();

    }

    @Test
    public void testB0022() {

        tokuteibiKadouTimeTourokuDB.createTestB0022_01();
        tokuteibiKadouTimeTourokuDB.createTestB0022_02();
        tokuteibiKadouTimeTourokuDB.createTestB0022_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0022_01();

    }

    @Test
    public void testB0023() {

        tokuteibiKadouTimeTourokuDB.createTestB0023_01();
        tokuteibiKadouTimeTourokuDB.createTestB0023_02();
        tokuteibiKadouTimeTourokuDB.createTestB0023_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.close(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestB0023_01();

    }

    @Test
    public void testL0001() {

        tokuteibiKadouTimeTourokuDB.createTestL0001_01();
        tokuteibiKadouTimeTourokuDB.createTestL0001_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0001_01();

    }

    @Test
    public void testL0002() {

        tokuteibiKadouTimeTourokuDB.createTestL0002_01();
        tokuteibiKadouTimeTourokuDB.createTestL0002_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0002_01();

    }

    @Test
    public void testL0003() {

        tokuteibiKadouTimeTourokuDB.createTestL0003_01();
        tokuteibiKadouTimeTourokuDB.createTestL0003_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0003_01();

    }

    @Test
    public void testL0004() {

        tokuteibiKadouTimeTourokuDB.createTestL0004_01();
        tokuteibiKadouTimeTourokuDB.createTestL0004_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0004_01();

    }

    @Test
    public void testL0005() {

        tokuteibiKadouTimeTourokuDB.createTestL0005_01();
        tokuteibiKadouTimeTourokuDB.createTestL0005_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0005_01();

    }

    @Test
    public void testL0006() {

        tokuteibiKadouTimeTourokuDB.createTestL0006_01();
        tokuteibiKadouTimeTourokuDB.createTestL0006_02();
        tokuteibiKadouTimeTourokuDB.createTestL0006_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0006_01();

    }

    @Test
    public void testL0007() {

        tokuteibiKadouTimeTourokuDB.createTestL0007_01();
        tokuteibiKadouTimeTourokuDB.createTestL0007_02();
        tokuteibiKadouTimeTourokuDB.createTestL0007_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0007_01();

    }

    @Test
    public void testL0008() {

        tokuteibiKadouTimeTourokuDB.createTestL0008_01();
        tokuteibiKadouTimeTourokuDB.createTestL0008_02();
        tokuteibiKadouTimeTourokuDB.createTestL0008_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0008_01();

    }

    @Test
    public void testL0009() {

        tokuteibiKadouTimeTourokuDB.createTestL0009_01();
        tokuteibiKadouTimeTourokuDB.createTestL0009_02();
        tokuteibiKadouTimeTourokuDB.createTestL0009_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0009_01();

    }

    @Test
    public void testL0010() {

        tokuteibiKadouTimeTourokuDB.createTestL0010_01();
        tokuteibiKadouTimeTourokuDB.createTestL0010_02();
        tokuteibiKadouTimeTourokuDB.createTestL0010_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0010_01();

    }

    @Test
    public void testL0011() {

        tokuteibiKadouTimeTourokuDB.createTestL0011_01();
        tokuteibiKadouTimeTourokuDB.createTestL0011_02();
        tokuteibiKadouTimeTourokuDB.createTestL0011_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0011_01();

    }

    @Test
    public void testL0012() {

        tokuteibiKadouTimeTourokuDB.createTestL0012_01();
        tokuteibiKadouTimeTourokuDB.createTestL0012_02();
        tokuteibiKadouTimeTourokuDB.createTestL0012_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0012_01();

    }

    @Test
    public void testL0013() {

        tokuteibiKadouTimeTourokuDB.createTestL0013_01();
        tokuteibiKadouTimeTourokuDB.createTestL0013_02();
        tokuteibiKadouTimeTourokuDB.createTestL0013_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0013_01();

    }

    @Test
    public void testL0014() {

        tokuteibiKadouTimeTourokuDB.createTestL0014_01();
        tokuteibiKadouTimeTourokuDB.createTestL0014_02();
        tokuteibiKadouTimeTourokuDB.createTestL0014_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0014_01();

    }

    @Test
    public void testL0015() {

        tokuteibiKadouTimeTourokuDB.createTestL0015_01();
        tokuteibiKadouTimeTourokuDB.createTestL0015_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0015_01();

    }

    @Test
    public void testL0016() {

        tokuteibiKadouTimeTourokuDB.createTestL0016_01();
        tokuteibiKadouTimeTourokuDB.createTestL0016_02();
        tokuteibiKadouTimeTourokuDB.createTestL0016_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, ALREADYSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0016_01();

    }

    @Test
    public void testL0017() {

        tokuteibiKadouTimeTourokuDB.createTestL0017_01();
        tokuteibiKadouTimeTourokuDB.createTestL0017_02();
        tokuteibiKadouTimeTourokuDB.createTestL0017_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0017_01();

    }

    @Test
    public void testL0018() {

        tokuteibiKadouTimeTourokuDB.createTestL0018_01();
        tokuteibiKadouTimeTourokuDB.createTestL0018_02();
        tokuteibiKadouTimeTourokuDB.createTestL0018_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0018_01();

    }

    @Test
    public void testL0019() {

        tokuteibiKadouTimeTourokuDB.createTestL0019_01();
        tokuteibiKadouTimeTourokuDB.createTestL0019_02();
        tokuteibiKadouTimeTourokuDB.createTestL0019_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0019_01();

    }

    @Test
    public void testL0020() {

        tokuteibiKadouTimeTourokuDB.createTestL0020_01();
        tokuteibiKadouTimeTourokuDB.createTestL0020_02();
        tokuteibiKadouTimeTourokuDB.createTestL0020_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0020_01();

    }

    @Test
    public void testL0021() {

        tokuteibiKadouTimeTourokuDB.createTestL0021_01();
        tokuteibiKadouTimeTourokuDB.createTestL0021_02();
        tokuteibiKadouTimeTourokuDB.createTestL0021_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0021_01();

    }

    @Test
    public void testL0022() {

        tokuteibiKadouTimeTourokuDB.createTestL0022_01();
        tokuteibiKadouTimeTourokuDB.createTestL0022_02();
        tokuteibiKadouTimeTourokuDB.createTestL0022_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0022_01();

    }

    @Test
    public void testL0023() {

        tokuteibiKadouTimeTourokuDB.createTestL0023_01();
        tokuteibiKadouTimeTourokuDB.createTestL0023_02();
        tokuteibiKadouTimeTourokuDB.createTestL0023_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0023_01();

    }

    @Test
    public void testL0024() {

        tokuteibiKadouTimeTourokuDB.createTestL0024_01();
        tokuteibiKadouTimeTourokuDB.createTestL0024_02();
        tokuteibiKadouTimeTourokuDB.createTestL0024_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0024_01();

    }

    @Test
    public void testL0025() {

        tokuteibiKadouTimeTourokuDB.createTestL0025_01();
        tokuteibiKadouTimeTourokuDB.createTestL0025_02();
        tokuteibiKadouTimeTourokuDB.createTestL0025_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0025_01();

    }

    @Test
    public void testL0026() {

        tokuteibiKadouTimeTourokuDB.createTestL0026_01();
        tokuteibiKadouTimeTourokuDB.createTestL0026_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0026_01();

    }

    @Test
    public void testL0027() {

        tokuteibiKadouTimeTourokuDB.createTestL0027_01();
        tokuteibiKadouTimeTourokuDB.createTestL0027_02();
        tokuteibiKadouTimeTourokuDB.createTestL0027_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0027_01();

    }

    @Test
    public void testL0028() {

        tokuteibiKadouTimeTourokuDB.createTestL0028_01();
        tokuteibiKadouTimeTourokuDB.createTestL0028_02();
        tokuteibiKadouTimeTourokuDB.createTestL0028_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0028_01();

    }

    @Test
    public void testL0029() {

        tokuteibiKadouTimeTourokuDB.createTestL0029_01();
        tokuteibiKadouTimeTourokuDB.createTestL0029_02();
        tokuteibiKadouTimeTourokuDB.createTestL0029_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0029_01();

    }

    @Test
    public void testL0030() {

        tokuteibiKadouTimeTourokuDB.createTestL0030_01();
        tokuteibiKadouTimeTourokuDB.createTestL0030_02();
        tokuteibiKadouTimeTourokuDB.createTestL0030_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0030_01();

    }

    @Test
    public void testL0031() {

        tokuteibiKadouTimeTourokuDB.createTestL0031_01();
        tokuteibiKadouTimeTourokuDB.createTestL0031_02();
        tokuteibiKadouTimeTourokuDB.createTestL0031_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYINPUTCONTENTS_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0031_01();

    }

    @Test
    public void testL0032() {

        tokuteibiKadouTimeTourokuDB.createTestL0032_01();
        tokuteibiKadouTimeTourokuDB.createTestL0032_02();
        tokuteibiKadouTimeTourokuDB.createTestL0032_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0032_01();

    }

    @Test
    public void testL0033() {

        tokuteibiKadouTimeTourokuDB.createTestL0033_01();
        tokuteibiKadouTimeTourokuDB.createTestL0033_02();
        tokuteibiKadouTimeTourokuDB.createTestL0033_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0033_01();

    }

    @Test
    public void testL0034() {

        tokuteibiKadouTimeTourokuDB.createTestL0034_01();
        tokuteibiKadouTimeTourokuDB.createTestL0034_02();
        tokuteibiKadouTimeTourokuDB.createTestL0034_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(MODORUBTNBYCONFIRM_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0034_01();

    }

    @Test
    public void testL0035() {

        tokuteibiKadouTimeTourokuDB.createTestL0035_01();
        tokuteibiKadouTimeTourokuDB.createTestL0035_02();
        tokuteibiKadouTimeTourokuDB.createTestL0035_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0035_01();

    }

    @Test
    public void testL0036() {

        tokuteibiKadouTimeTourokuDB.createTestL0036_01();
        tokuteibiKadouTimeTourokuDB.createTestL0036_02();
        tokuteibiKadouTimeTourokuDB.createTestL0036_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0036_01();

    }

    @Test
    public void testL0037() {

        tokuteibiKadouTimeTourokuDB.createTestL0037_01();
        tokuteibiKadouTimeTourokuDB.createTestL0037_02();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0037_01();

    }

    @Test
    public void testL0038() {

        tokuteibiKadouTimeTourokuDB.createTestL0038_01();
        tokuteibiKadouTimeTourokuDB.createTestL0038_02();
        tokuteibiKadouTimeTourokuDB.createTestL0038_03();

        pkgWebApp.openKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.clickButton(HENKOULINK);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, MODIFIEDSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaToNewWindow();

        pkgWebApp.haitaOpenKinou(tokuteibiKadouTimeTouroku);
        pkgWebApp.assertTitle(tokuteibiKadouTimeTouroku);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SAKUJYOLINK);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);


        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToTextBox(DDID_KEYINFO_KADOUTIMESITEIYMD, tokuteibiKadouTimeTourokuDB.getSeirekiWareki());
        pkgWebApp.setToCheckBox(DDID_KADOUTIMEGROUPLIST_COMMONCHECKBOX, 1, true);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(TOUROKUBTN_BUTTONINPUTKEY);

        pkgWebApp.assertPageNo(PAGENO_INPUTCONTENTS);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.setToKubun(DDID_TOKUTEIBIKADOUTIMEINFO_KADOUTIMESITEIKBN, NEWSITEIKBN);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUNINBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_CONFIRM);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(KAKUTEIBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.haitaClose();

        pkgWebApp.assertPageNo(PAGENO_RESULT);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);
        pkgWebApp.clickButton(SYOKIGAMENHEBTN_BUTTONINPUTCONTENTS);

        pkgWebApp.assertPageNo(PAGENO_SELECTDATA);
        pkgWebApp.takeScreenshot(tokuteibiKadouTimeTouroku);

        tokuteibiKadouTimeTourokuDB.deleteTestL0038_01();

    }
}

