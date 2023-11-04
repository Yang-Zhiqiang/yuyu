package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
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
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込消却予定日設定のメソッド {@link SetMossykykyoteiymd#setMosskykyoteiymdHuseiritu(
 * HT_SyoriCTL, BizDate, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMossykykyoteiymdTest_setMosskykyoteiymdHuseiritu {

    private static final String mosNo1 = "980000012";

    private static final String mosNo2 = "980000020";

    private static final String mosNo3 = "980000038";

    private static final String mosNo4 = "980000046";

    private static final String mosNo5 = "980000053";

    private static final String mosNo6 = "980000061";

    private static final String mosNo7 = "980000079";

    private static final String mosNo8 = "980000087";

    private static final String mosNo9 = "980000095";

    private static final String mosNo10 = "980000103";

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_申込消却予定日設定";

    private final static String sheetName = "INデータ";

    @Inject
    private SetMossykykyoteiymd setMossykykyoteiymd;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetMossykykyoteiymdTest_setMosskykyoteiymdHuseiritu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ02", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllMosnoKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL1, BizDate.valueOf(20160101), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000001");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20170331), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A2() {

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL2, BizDate.valueOf(20160201), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000002");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20160531), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }


    @Test
    @TestOrder(30)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A3() {

        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL3, BizDate.valueOf(20160301), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000003");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20160630), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A4() {

        HT_SyoriCTL syoriCTL4 = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL4, BizDate.valueOf(20160301), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000004");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20160729), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A5() {

        HT_SyoriCTL syoriCTL5 = sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL5, BizDate.valueOf(20130201), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000005");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20130531), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A6() {

        HT_SyoriCTL syoriCTL6 = sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL6, BizDate.valueOf(20130301), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000006");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20130628), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A7() {

        HT_SyoriCTL syoriCTL7 = sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL7, BizDate.valueOf(20130401), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000007");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20130830), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A8() {

        HT_SyoriCTL syoriCTL8 = sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL8, BizDate.valueOf(20130401), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000008");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20130830), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A9() {

        HT_SyoriCTL syoriCTL9 = sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL9, BizDate.valueOf(20150201), null);

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000009");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20160428), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testSetMosskykyoteiymdHuseiritu_A10() {

        HT_SyoriCTL syoriCTL10 = sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        setMossykykyoteiymd.setMosskykyoteiymdHuseiritu(syoriCTL10, BizDate.valueOf(20150401), null);

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000010");

        assertNull(mosnoKanri);
    }
}
