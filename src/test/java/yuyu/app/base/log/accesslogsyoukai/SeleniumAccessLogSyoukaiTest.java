package yuyu.app.base.log.accesslogsyoukai;

import static yuyu.app.base.log.accesslogsyoukai.GenAccessLogSyoukaiConstants.*;
import static yuyu.app.base.log.accesslogsyoukai.GenAccessLogSyoukaiSelector.*;
import static yuyu.app.base.log.accesslogsyoukai.SeleniumAccessLogSyoukaiConstants.*;

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
 * Selenium を使った アクセスログ照会 機能の統合テストです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class SeleniumAccessLogSyoukaiTest extends PackageAdminTest {

    private static final String targetKinouId = "accesslogsyoukai";

    @Inject
    private BaseDomManager                      domManager;

    @Inject
    private MessageManager                      msgManager;

    @Inject
    private SeleniumAccessLogSyoukaiDB          accessLogSyoukaiDB;

    private AS_Kinou                            accessLogSyoukai;

    @Before
    public void beforeTest() {
        accessLogSyoukai = domManager.getKinou(targetKinouId);
    }

    @After
    public void afterTest() {
        pkgWebApp.close();

    }

    @Test
    public void testB0001() {

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0002() {

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0003() {

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.openChildWindowClick(USERKENSAKUBTN);

        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.closeChildWindow();

    }

    @Test
    public void testB0004() {

        accessLogSyoukaiDB.deleteTestB0004_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0005() {

        accessLogSyoukaiDB.deleteTestB0005_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.setToTextBox(DDID_SEARCHCONDITIONS_USERID, KENSAKUUSERID);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0006() {

        accessLogSyoukaiDB.deleteTestB0006_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(HYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0007() {

        accessLogSyoukaiDB.deleteTestB0007_01();

        accessLogSyoukaiDB.createTestB0007_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0008() {

        accessLogSyoukaiDB.deleteTestB0008_01();

        accessLogSyoukaiDB.createTestB0008_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0009() {

        accessLogSyoukaiDB.deleteTestB0009_01();

        accessLogSyoukaiDB.createTestB0009_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0010() {

        accessLogSyoukaiDB.deleteTestB0010_01();

        accessLogSyoukaiDB.createTestB0010_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0011() {

        accessLogSyoukaiDB.deleteTestB0011_01();

        accessLogSyoukaiDB.createTestB0011_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(PAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0012() {

        accessLogSyoukaiDB.deleteTestB0012_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.close(accessLogSyoukai);

    }

    @Test
    public void testB0013() {

        accessLogSyoukaiDB.deleteTestB0013_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(HYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(FUNCTIONNAME);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0014() {

        accessLogSyoukaiDB.deleteTestB0014_01();

        accessLogSyoukaiDB.createTestB0014_01();
        accessLogSyoukaiDB.createTestB0014_02();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGHYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_NO);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0015() {

        accessLogSyoukaiDB.deleteTestB0015_01();

        accessLogSyoukaiDB.createTestB0015_01();
        accessLogSyoukaiDB.createTestB0015_02();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGHYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0016() {

        accessLogSyoukaiDB.deleteTestB0016_01();

        accessLogSyoukaiDB.createTestB0016_01();
        accessLogSyoukaiDB.createTestB0016_02();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGHYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_R);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_L);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0017() {

        accessLogSyoukaiDB.deleteTestB0017_01();

        accessLogSyoukaiDB.createTestB0017_01();
        accessLogSyoukaiDB.createTestB0017_02();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGHYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0018() {

        accessLogSyoukaiDB.deleteTestB0018_01();

        accessLogSyoukaiDB.createTestB0018_01();
        accessLogSyoukaiDB.createTestB0018_02();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGHYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_RR);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(LOGPAGELINK_LL);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0019() {

        accessLogSyoukaiDB.deleteTestB0019_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(HYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(MODORUBTNBYSYOUSAI_FOOTERBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

    }

    @Test
    public void testB0020() {

        accessLogSyoukaiDB.deleteTestB0020_01();

        pkgWebApp.openKinou(accessLogSyoukai);
        pkgWebApp.assertTitle(accessLogSyoukai);
        pkgWebApp.takeScreenshot(accessLogSyoukai);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(SEARCHBTN_SEARCHBUTTONS);

        pkgWebApp.assertPageNo(PAGENO_SEARCH);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.clickButton(HYOUJILINK);

        pkgWebApp.assertPageNo(PAGENO_DETAIL);
        pkgWebApp.takeScreenshot(accessLogSyoukai);
        pkgWebApp.close(accessLogSyoukai);

        accessLogSyoukaiDB.deleteTestB0020_01();

    }
}

