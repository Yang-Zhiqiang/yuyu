package yuyu.common.biz.bznayose;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKh;
import yuyu.def.db.entity.BT_TjtIdouNyNk;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取消用当日異動内容削除クラスのメソッド {@link BzTrksTjtIdouNaiyouSakujyo#exec(BzTrksTjtIdouNaiyouSakujyoBean )}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzTrksTjtIdouNaiyouSakujyoTest_exec {

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書_取消用当日異動内容削除";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzTrksTjtIdouNaiyouSakujyoTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyKh());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNyNk());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean = null;

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.SYONO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("12806345661");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.SYONO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("12806345672");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);
        bizDomManager.flush();
        List<BT_TjtIdouNyKh> tjtIdouNyKhLst1 =
            bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("12806345672", "ykno10000187654321");
        List<BT_TjtIdouNyKh> tjtIdouNyKhLst2 =
            bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("12806345672", "ykno10000187654322");
        List<BT_TjtIdouNyKh> tjtIdouNyKhLst3 =
            bizDomManager.getTjtIdouNyKhsBySyonoYoukyuuno("12806345694", "ykno10000187654324");

        exNumericEquals(tjtIdouNyKhLst1.size(), 0, "件数");
        exNumericEquals(tjtIdouNyKhLst2.size(), 1, "件数");
        exNumericEquals(tjtIdouNyKhLst3.size(), 1, "件数");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.MOSNO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("860000033");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.MOSNO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("860000017");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        bizDomManager.flush();

        List<BT_TjtIdouNySk> tjtIdouNySkLst1 =
            bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("860000017", "ykno10000187654321");
        List<BT_TjtIdouNySk> tjtIdouNySkLst2 =
            bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("860000017", "ykno10000187654322");
        List<BT_TjtIdouNySk> tjtIdouNySkLst3 =
            bizDomManager.getTjtIdouNySksByMosnoYoukyuuno("860000041", "ykno10000187654324");

        exNumericEquals(tjtIdouNySkLst1.size(), 0, "件数");
        exNumericEquals(tjtIdouNySkLst2.size(), 1, "件数");
        exNumericEquals(tjtIdouNySkLst3.size(), 1, "件数");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.NKSYSYNO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("17807000038");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.NKSYSYNO);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("17807000016");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        bizDomManager.flush();

        List<BT_TjtIdouNyNk> tjtIdouNyKhLst1 = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("17807000016", "ykno10000187654321");
        List<BT_TjtIdouNyNk> tjtIdouNyKhLst2 = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("17807000016", "ykno10000187654322");
        List<BT_TjtIdouNyNk> tjtIdouNyKhLst3 = bizDomManager.getTjtIdouNyNksByNksysynoYoukyuuno("17807000049", "ykno10000187654324");

        exNumericEquals(tjtIdouNyKhLst1.size(), 0, "件数");
        exNumericEquals(tjtIdouNyKhLst2.size(), 1, "件数");
        exNumericEquals(tjtIdouNyKhLst3.size(), 1, "件数");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "当日異動内容削除結果区分");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        BzTrksTjtIdouNaiyouSakujyoBean bzTrksTjtIdouNaiyouSakujyoBean = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyoBean.class);
        BzTrksTjtIdouNaiyouSakujyo bzTrksTjtIdouNaiyouSakujyo = SWAKInjector.
            getInstance(BzTrksTjtIdouNaiyouSakujyo.class);

        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNoKbn(C_Huho2kyknoKbn.BLNK);
        bzTrksTjtIdouNaiyouSakujyoBean.setHuho2KykNo("17807000016");
        bzTrksTjtIdouNaiyouSakujyoBean.setYoukyuuNo("ykno10000187654321");

        C_ErrorKbn errorKbn = bzTrksTjtIdouNaiyouSakujyo.exec(bzTrksTjtIdouNaiyouSakujyoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "当日異動内容削除結果区分");
    }
}
