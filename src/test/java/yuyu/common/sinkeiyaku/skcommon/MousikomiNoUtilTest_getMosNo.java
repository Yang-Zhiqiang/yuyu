package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込番号採番クラスのメソッド {@link MousikomiNoUtil#getMosNo(C_SkeijimuKbn,C_MosUketukeKbn,String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class MousikomiNoUtilTest_getMosNo extends AbstractTest {

    @Inject
    private MousikomiNoUtil mousikomiNoUtil;

    private final static String fileName = "UT_SP_単体テスト仕様書_申込番号採番";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testGetMosNo_A1() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "879111110", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("87911111");

        exStringEquals(mosnoKanri.getMosno8keta(), "87911111", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

        HT_MosnoKanri mosnoKanri7 = sinkeiyakuDomManager.getMosnoKanri("97001202");
        if (null == mosnoKanri7) {
            mosnoKanri7 = new HT_MosnoKanri("97001202");
            mosnoKanri7.setSaibankahikbn(C_KahiKbn.HUKA);
            mosnoKanri7.setSaibanymd(BizDate.valueOf("20120809"));
            sinkeiyakuDomManager.insert(mosnoKanri7);
        }

        HT_MosnoKanri mosnoKanri8 = sinkeiyakuDomManager.getMosnoKanri("98001301");
        if (null == mosnoKanri8) {
            mosnoKanri8 = new HT_MosnoKanri("98001301");
            mosnoKanri8.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri8.setSaibanymd(BizDate.valueOf("20120810"));
            sinkeiyakuDomManager.insert(mosnoKanri8);
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    @Transactional
    public void testGetMosNo_A2() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 2));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testGetMosNo_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 3));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "980013015", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98001301");

        exStringEquals(mosnoKanri.getMosno8keta(), "98001301", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

        HT_MosnoKanri mosnoKanri9 = sinkeiyakuDomManager.getMosnoKanri("97001401");
        if (null == mosnoKanri9) {
            mosnoKanri9 = new HT_MosnoKanri("97001401");
            mosnoKanri9.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri9.setSaibanymd(BizDate.valueOf("20120811"));
            sinkeiyakuDomManager.insert(mosnoKanri9);
        }

        HT_MosnoKanri mosnoKanri10 = sinkeiyakuDomManager.getMosnoKanri("88001501");
        if (null == mosnoKanri10) {
            mosnoKanri10 = new HT_MosnoKanri("88001501");
            mosnoKanri10.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri10.setSaibanymd(BizDate.valueOf("20120812"));
            sinkeiyakuDomManager.insert(mosnoKanri10);
        }

        HT_MosnoKanri mosnoKanri21 = sinkeiyakuDomManager.getMosnoKanri("88001502");
        if (null == mosnoKanri21) {
            mosnoKanri21 = new HT_MosnoKanri("88001502");
            mosnoKanri21.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri21.setSaibanymd(BizDate.valueOf("20120811"));
            sinkeiyakuDomManager.insert(mosnoKanri21);
        }
    }


    @Test
    @TestOrder(40)
    @Transactional
    public void testGetMosNo_A4() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.MIZUHO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 4));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "970014015", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("97001401");

        exStringEquals(mosnoKanri.getMosno8keta(), "97001401", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }


    @Test
    @TestOrder(50)
    @Transactional
    public void testGetMosNo_A5() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 5));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "880015029", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88001502");

        exStringEquals(mosnoKanri.getMosno8keta(), "88001502", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

        HT_MosnoKanri mosnoKanri11 = sinkeiyakuDomManager.getMosnoKanri("88001701");
        if (null == mosnoKanri11) {
            mosnoKanri11 = new HT_MosnoKanri("88001701");
            mosnoKanri11.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri11.setSaibanymd(BizDate.valueOf("20120813"));
            sinkeiyakuDomManager.insert(mosnoKanri11);
        }

        HT_MosnoKanri mosnoKanri12 = sinkeiyakuDomManager.getMosnoKanri("98011201");
        if (null == mosnoKanri12) {
            mosnoKanri12 = new HT_MosnoKanri("98011201");
            mosnoKanri12.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri12.setSaibanymd(BizDate.valueOf("20130928"));
            sinkeiyakuDomManager.insert(mosnoKanri12);
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    @Transactional
    public void testGetMosNo_A6() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.BLNK;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SIRYOUSEIKYUU;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test
    @TestOrder(70)
    @Transactional
    public void testGetMosNo_A7() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 7));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "880017017", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88001701");

        exStringEquals(mosnoKanri.getMosno8keta(), "88001701", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(80)
    @Transactional
    public void testGetMosNo_A8() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 01));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(110)
    @Transactional
    public void testGetMosNo_A11() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testGetMosNo_A12() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 12));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "980112015", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98011201");

        exStringEquals(mosnoKanri.getMosno8keta(), "98011201", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());

        HT_MosnoKanri mosnoKanri13 = sinkeiyakuDomManager.getMosnoKanri("98011701");
        if (null == mosnoKanri13) {
            mosnoKanri13 = new HT_MosnoKanri("98011701");
            mosnoKanri13.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri13.setSaibanymd(BizDate.valueOf("20130929"));
            sinkeiyakuDomManager.insert(mosnoKanri13);
        }

        HT_MosnoKanri mosnoKanri14 = sinkeiyakuDomManager.getMosnoKanri("98011801");
        if (null == mosnoKanri14) {
            mosnoKanri14 = new HT_MosnoKanri("98011801");
            mosnoKanri14.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri14.setSaibanymd(BizDate.valueOf("20130930"));
            sinkeiyakuDomManager.insert(mosnoKanri14);
        }

        HT_MosnoKanri mosnoKanri15 = sinkeiyakuDomManager.getMosnoKanri("98011901");
        if (null == mosnoKanri15) {
            mosnoKanri15 = new HT_MosnoKanri("98011901");
            mosnoKanri15.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri15.setSaibanymd(BizDate.valueOf("20130930"));
            sinkeiyakuDomManager.insert(mosnoKanri15);
        }

        HT_MosnoKanri mosnoKanri16 = sinkeiyakuDomManager.getMosnoKanri("97002997");
        if (null == mosnoKanri16) {
            mosnoKanri16 = new HT_MosnoKanri("97002997");
            mosnoKanri16.setSaibankahikbn(C_KahiKbn.KA);
            mosnoKanri16.setSaibanymd(BizDate.valueOf("20130930"));
            sinkeiyakuDomManager.insert(mosnoKanri16);
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(130)
    @Transactional
    public void testGetMosNo_A13() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    @Transactional
    public void testGetMosNo_A14() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(150)
    @Transactional
    public void testGetMosNo_A15() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.MIZUHO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(160)
    @Transactional
    public void testGetMosNo_A16() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.DIRECT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testGetMosNo_A17() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "980117014", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98011701");

        exStringEquals(mosnoKanri.getMosno8keta(), "98011701", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }



    @Test
    @TestOrder(180)
    @Transactional
    public void testGetMosNo_A18() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 2, 28));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "980118012", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98011801");

        exStringEquals(mosnoKanri.getMosno8keta(), "98011801", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 4, 28), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }


    @Test
    @TestOrder(190)
    @Transactional
    public void testGetMosNo_A19() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 10, 31));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "980119010", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98011901");

        exStringEquals(mosnoKanri.getMosno8keta(), "98011901", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016,12, 30), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }


    @Test
    @TestOrder(200)
    @Transactional
    public void testGetMosNo_A20() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 12, 31));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "970029971", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("97002997");

        exStringEquals(mosnoKanri.getMosno8keta(), "97002997", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2017, 2, 28), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(360)
    @Transactional
    public void testGetMosNo_A21() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(370)
    @Transactional
    public void testGetMosNo_A22() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(380)
    @Transactional
    public void testGetMosNo_A23() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 6));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }

    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testGetMosNo_A24() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "787800036", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("78780003");

        exStringEquals(mosnoKanri.getMosno8keta(), "78780003", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testGetMosNo_A25() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "797900099", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("79790009");

        exStringEquals(mosnoKanri.getMosno8keta(), "79790009", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testGetMosNo_A26() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "787800010", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("78780001");

        exStringEquals(mosnoKanri.getMosno8keta(), "78780001", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testGetMosNo_A27() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900012", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990001");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990001", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(430)
    @Transactional
    public void testGetMosNo_A28() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900020", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990002");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990002", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(440)
    @Transactional
    public void testGetMosNo_A29() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900038", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990003");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990003", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(450)
    @Transactional
    public void testGetMosNo_A30() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900046", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990004");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990004", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(460)
    @Transactional
    public void testGetMosNo_A31() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900053", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990005");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990005", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(470)
    @Transactional
    public void testGetMosNo_A32() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 17));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "999900061", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("99990006");

        exStringEquals(mosnoKanri.getMosno8keta(), "99990006", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.getSysDate(), "採番日");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(480)
    @Transactional
    public void testGetMosNo_A33() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 2));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(488)
    @Transactional
    public void ins_34() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(490)
    @Transactional
    public void testGetMosNo_A34() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "870012358", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("87001235");

        exStringEquals(mosnoKanri.getMosno8keta(), "87001235", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(500)
    @Transactional
    public void testGetMosNo_A35() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "860000017", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("86000001");

        exStringEquals(mosnoKanri.getMosno8keta(), "86000001", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(510)
    @Transactional
    public void testGetMosNo_A36() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "870012341", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("87001234");

        exStringEquals(mosnoKanri.getMosno8keta(), "87001234", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(520)
    @Transactional
    public void testGetMosNo_A37() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "880000013", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88000001");

        exStringEquals(mosnoKanri.getMosno8keta(), "88000001", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(530)
    @Transactional
    public void testGetMosNo_A38() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "780000014", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("78000001");

        exStringEquals(mosnoKanri.getMosno8keta(), "78000001", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(540)
    @Transactional
    public void testGetMosNo_A39() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "799999990", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("79999999");

        exStringEquals(mosnoKanri.getMosno8keta(), "79999999", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA,
            "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");

    }

    @Test
    @TestOrder(541)
    @Transactional
    public void testGetMosNo_A40() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "889999991", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88999999");

        exStringEquals(mosnoKanri.getMosno8keta(), "88999999", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA, "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(542)
    @Transactional
    public void ins_41() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(543)
    @Transactional
    public void testGetMosNo_A41() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "886999994", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88699999");

        exStringEquals(mosnoKanri.getMosno8keta(), "88699999", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA, "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(544)
    @Transactional
    public void testGetMosNo_A42() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "887000008", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88700000");

        exStringEquals(mosnoKanri.getMosno8keta(), "88700000", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA, "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(545)
    @Transactional
    public void ins_43() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(546)
    @Transactional
    public void testGetMosNo_A43() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        String mosNo = mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        exStringEquals(mosNo, "887000024", "申込番号");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("88700002");

        exStringEquals(mosnoKanri.getMosno8keta(), "88700002", "申込番号（８桁）");
        exClassificationEquals(mosnoKanri.getSaibankahikbn(), C_KahiKbn.HUKA, "採番可否区分");
        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(2016, 10, 31), "申込消却予定日");
        exDateEquals(mosnoKanri.getSaibanymd(), BizDate.valueOf(2015, 8, 1), "採番日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "LBUser001", "業務用更新者ID");
    }

    @Test
    @TestOrder(547)
    @Transactional
    public void ins_44() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(548)
    @Transactional
    public void testGetMosNo_A44() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(549)
    @Transactional
    public void ins_45() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(MousikomiNoUtilTest_getMosNo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(550)
    @Transactional
    public void testGetMosNo_A45() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String sousasyaCd = "LBUser001";

        changeSystemDate(BizDate.valueOf(2015, 8, 1));

        try {
            mousikomiNoUtil.getMosNo(skeijimuKbn, mosUketukeKbn, sousasyaCd);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }

    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testGetMosChannel_B1() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "86", "申込番号チャネル");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testGetMosChannel_B2() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "97", "申込番号チャネル");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testGetMosChannel_B3() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "98", "申込番号チャネル");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testGetMosChannel_B4() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.MIZUHO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "97", "申込番号チャネル");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(250)
    @Transactional
    public void testGetMosChannel_B5() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.DIRECT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(260)
    @Transactional
    public void testGetMosChannel_B6() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.BLNK;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testGetMosChannel_B7() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "78", "申込番号チャネル");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testGetMosChannel_B8() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "78", "申込番号チャネル");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testGetMosChannel_B9() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.MOSKIT;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "78", "申込番号チャネル");
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testGetMosChannel_B10() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testGetMosChannel_B11() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testGetMosChannel_B12() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.SEIHOWEB;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testGetMosChannel_B13() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testGetMosChannel_B14() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.NIHONYUUBIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testGetMosChannel_B15() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.KANPOSEIMEI;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESS;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "99", "申込番号チャネル");

        insertTestData();
    }

    @Test
    @TestOrder(351)
    @Transactional
    public void testGetMosChannel_B16() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.TIGINSINKIN;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        String mosChannel = mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        exStringEquals(mosChannel, "88", "申込番号チャネル");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(352)
    @Transactional
    public void testGetMosChannel_B17() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.BLNK;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(353)
    @Transactional
    public void testGetMosChannel_B18() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMBC;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(354)
    @Transactional
    public void testGetMosChannel_B19() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SMTB;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(355)
    @Transactional
    public void testGetMosChannel_B20() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.MIZUHO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(356)
    @Transactional
    public void testGetMosChannel_B21() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.SHOP;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }


    @Test(expected = CommonBizAppException.class)
    @TestOrder(357)
    @Transactional
    public void testGetMosChannel_B22() {

        C_SkeijimuKbn skeijimuKbn = C_SkeijimuKbn.YUUTYO;

        C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;

        try {
            mousikomiNoUtil.getMosChannel(skeijimuKbn, mosUketukeKbn);

        } catch (CommonBizAppException ex) {

            exStringEquals(ex.getMessage(), "システム整合性エラーです。", "メッセージ");

            throw ex;
        }
    }
}
