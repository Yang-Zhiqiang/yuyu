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
 * 申込消却予定日設定のメソッド {@link SetMossykykyoteiymd#setMosskykyoteiymdSeiritu(
 * HT_SyoriCTL, BizDate, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetMossykykyoteiymdTest_setMosskykyoteiymdSeiritu {

    private static final String mosNo1 = "980000012";

    private static final String mosNo2 = "980000020";

    private static final String mosNo3 = "980000038";

    private static final String mosNo4 = "980000046";

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
            testDataAndTblMap = testDataMaker.getInData(SetMossykykyoteiymdTest_setMosskykyoteiymdSeiritu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ01", testDataAndTblMap);
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
    public void testSetMosskykyoteiymdSeiritu_A1() {

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        setMossykykyoteiymd.setMosskykyoteiymdSeiritu(syoriCTL1, BizDate.valueOf(20161101), "user01234567890");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000001");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20170228), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user01234567890", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testSetMosskykyoteiymdSeiritu_A2() {

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        setMossykykyoteiymd.setMosskykyoteiymdSeiritu(syoriCTL2, BizDate.valueOf(20161201), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000002");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20170428), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testSetMosskykyoteiymdSeiritu_A3() {

        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        setMossykykyoteiymd.setMosskykyoteiymdSeiritu(syoriCTL3, BizDate.valueOf(20161001), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000003");

        exDateEquals(mosnoKanri.getMossykykyoteiymd(), BizDate.valueOf(20170131), "申込消却予定日");
        exStringEquals(mosnoKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSetMosskykyoteiymdSeiritu_A4() {

        HT_SyoriCTL syoriCTL4 = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        setMossykykyoteiymd.setMosskykyoteiymdSeiritu(syoriCTL4, BizDate.valueOf(20161001), "user001");

        HT_MosnoKanri mosnoKanri = sinkeiyakuDomManager.getMosnoKanri("98000004");

        assertNull(mosnoKanri);
    }
}
