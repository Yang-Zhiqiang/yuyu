package yuyu.app.base.log.batchjyoukyousyoukai;

import static yuyu.app.base.log.batchjyoukyousyoukai.GenBatchJyoukyouSyoukaiConstants.*;
import static yuyu.app.base.log.batchjyoukyousyoukai.GenBatchJyoukyouSyoukaiSelector.*;
import static yuyu.app.base.log.batchjyoukyousyoukai.SeleniumBatchJyoukyouSyoukaiConstants.*;

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
 * Selenium を使った バッチ状況照会 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumBatchJyoukyouSyoukaiTest extends PackageAdminTest {

    private static final String targetKinouId = "batchjyoukyousyoukai";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumBatchJyoukyouSyoukaiDB      batchJyoukyouSyoukaiDB;

    private AS_Kinou                            batchJyoukyouSyoukai;

    @Before
    public void beforeTest() {
        batchJyoukyouSyoukai = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(JIDOUKOUSINSINAIBTN_KOUSINBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(JIDOUKOUSINSURUBTN_KOUSINBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0004() {

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(JIDOUKOUSINSINAIBTN_KOUSINBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0005() {

        batchJyoukyouSyoukaiDB.createTestB0005_01();
        batchJyoukyouSyoukaiDB.createTestB0005_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTON);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0005_01();

    }

    @Test
    public void testB0006() {

        batchJyoukyouSyoukaiDB.deleteTestB0006_01();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTON);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0007() {

        batchJyoukyouSyoukaiDB.createTestB0007_01();
        batchJyoukyouSyoukaiDB.createTestB0007_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0007_01();

    }

    @Test
    public void testB0008() {

        batchJyoukyouSyoukaiDB.createTestB0008_01();
        batchJyoukyouSyoukaiDB.createTestB0008_02();
        batchJyoukyouSyoukaiDB.createTestB0008_03();
        batchJyoukyouSyoukaiDB.createTestB0008_04();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.openNewWindowClick(TYOUHYOULINK);

        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.closeNewWindow();

        batchJyoukyouSyoukaiDB.deleteTestB0008_01();
        batchJyoukyouSyoukaiDB.deleteTestB0008_02();

    }

    @Test
    public void testB0009() {

        batchJyoukyouSyoukaiDB.createTestB0009_01();
        batchJyoukyouSyoukaiDB.createTestB0009_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(KOUSINBTN_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0009_01();

    }

    @Test
    public void testB0010() {

        batchJyoukyouSyoukaiDB.createTestB0010_01();
        batchJyoukyouSyoukaiDB.createTestB0010_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_NO);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0010_01();

    }

    @Test
    public void testB0011() {

        batchJyoukyouSyoukaiDB.createTestB0011_01();
        batchJyoukyouSyoukaiDB.createTestB0011_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0011_01();

    }

    @Test
    public void testB0012() {

        batchJyoukyouSyoukaiDB.createTestB0012_01();
        batchJyoukyouSyoukaiDB.createTestB0012_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0012_01();

    }

    @Test
    public void testB0013() {

        batchJyoukyouSyoukaiDB.createTestB0013_01();
        batchJyoukyouSyoukaiDB.createTestB0013_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0013_01();

    }

    @Test
    public void testB0014() {

        batchJyoukyouSyoukaiDB.createTestB0014_01();
        batchJyoukyouSyoukaiDB.createTestB0014_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(GAIYOUPAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0014_01();

    }

    @Test
    public void testB0015() {

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.close(batchJyoukyouSyoukai);

    }

    @Test
    public void testB0016() {

        batchJyoukyouSyoukaiDB.createTestB0016_01();
        batchJyoukyouSyoukaiDB.createTestB0016_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0016_01();

    }

    @Test
    public void testB0017() {

        batchJyoukyouSyoukaiDB.createTestB0017_01();
        batchJyoukyouSyoukaiDB.createTestB0017_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(MODORUBTNBYGAIYOU_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0017_01();

    }

    @Test
    public void testB0018() {

        batchJyoukyouSyoukaiDB.createTestB0018_01();
        batchJyoukyouSyoukaiDB.createTestB0018_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(TYUUDANBTN_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0018_01();

    }

    @Test
    public void testB0019() {

        batchJyoukyouSyoukaiDB.createTestB0019_01();
        batchJyoukyouSyoukaiDB.createTestB0019_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.openNewWindowClick(INSATUBTN_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_PRINT);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.closeNewWindow();

        batchJyoukyouSyoukaiDB.deleteTestB0019_01();

    }

    @Test
    public void testB0020() {

        batchJyoukyouSyoukaiDB.createTestB0020_01();
        batchJyoukyouSyoukaiDB.createTestB0020_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_NO);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0020_01();

    }

    @Test
    public void testB0021() {

        batchJyoukyouSyoukaiDB.createTestB0021_01();
        batchJyoukyouSyoukaiDB.createTestB0021_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0021_01();

    }

    @Test
    public void testB0022() {

        batchJyoukyouSyoukaiDB.createTestB0022_01();
        batchJyoukyouSyoukaiDB.createTestB0022_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0022_01();

    }

    @Test
    public void testB0023() {

        batchJyoukyouSyoukaiDB.createTestB0023_01();
        batchJyoukyouSyoukaiDB.createTestB0023_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0023_01();

    }

    @Test
    public void testB0024() {

        batchJyoukyouSyoukaiDB.createTestB0024_01();
        batchJyoukyouSyoukaiDB.createTestB0024_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickSearchButton(LOGPAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0024_01();

    }

    @Test
    public void testB0025() {

        batchJyoukyouSyoukaiDB.createTestB0025_01();
        batchJyoukyouSyoukaiDB.createTestB0025_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.close(batchJyoukyouSyoukai);

        batchJyoukyouSyoukaiDB.deleteTestB0025_01();

    }

    @Test
    public void testB0026() {

        batchJyoukyouSyoukaiDB.createTestB0026_01();
        batchJyoukyouSyoukaiDB.createTestB0026_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.openNewWindowClick(INSATUBTN_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_PRINT);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.closeNewWindow();

        batchJyoukyouSyoukaiDB.deleteTestB0026_01();

    }

    //    @Test
    //    public void testB0027() {
    //
    //        batchJyoukyouSyoukaiDB.createTestB0027_01();
    //        batchJyoukyouSyoukaiDB.createTestB0027_02();
    //
    //        basePkg.openKinou(batchJyoukyouSyoukai);
    //        basePkg.assertTitle(batchJyoukyouSyoukai);
    //        basePkg.takeScreenshot(batchJyoukyouSyoukai);
    //
    //        basePkg.assertPageNo(PAGENO_SUMMARY);
    //        basePkg.takeScreenshot(batchJyoukyouSyoukai);
    //        basePkg.clickButton(SYOUSAILINK);
    //
    //        basePkg.assertPageNo(PAGENO_DETAIL);
    //        basePkg.takeScreenshot(batchJyoukyouSyoukai);
    //        basePkg.openNewWindowClick(INSATUBTN_FOTTERBUTTONS);
    //
    //        basePkg.assertPageNo(PAGENO_PRINT);
    //        basePkg.takeScreenshot(batchJyoukyouSyoukai);
    //        basePkg.openNewWindowClick(INSATUBTN_FOTTERBUTTONS);
    //
    //        basePkg.takeScreenshot(batchJyoukyouSyoukai);
    //        basePkg.closeNewWindow();
    //
    //        basePkg.closeNewWindow();
    //
    //        batchJyoukyouSyoukaiDB.deleteTestB0027_01();
    //
    //    }

    @Test
    public void testB0028() {

        batchJyoukyouSyoukaiDB.createTestB0028_01();
        batchJyoukyouSyoukaiDB.createTestB0028_02();

        pkgWebApp.openKinou(batchJyoukyouSyoukai);
        pkgWebApp.assertTitle(batchJyoukyouSyoukai);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SUMMARY);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.clickButton(SYOUSAILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.openNewWindowClick(INSATUGAMENBTN_FOTTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_PRINT);
        pkgWebApp.takeScreenshot(batchJyoukyouSyoukai);
        pkgWebApp.closeNewWindow();

        batchJyoukyouSyoukaiDB.deleteTestB0028_01();

    }
}

