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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getSyouhnNm_Ryaku5(String, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getSyouhnNm_Ryaku5 {

    private final static String fileName = "UT_SP_単体テスト仕様書_商品属性ユーティリティ";

    private final static String sheetName = "テストデータ";

    @Inject
    private SyouhinUtil syouhinUtil;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_getSyouhnNm_Ryaku5.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }
    @Test
    @TestOrder(10)
    public void testGetSyouhnNm_Ryaku5_D1() {
        String syouhnCd = null;
        BizDate sysDate = null;

        String syouhnNm = syouhinUtil.getSyouhnNm_Ryaku5(syouhnCd, sysDate);
        exStringEquals(syouhnNm, null, "商品名（略称５文字)");

    }

    @Test
    @TestOrder(20)
    public void testGetSyouhnNm_Ryaku5_D2() {
        String syouhnCd = "";
        BizDate sysDate = BizDate.valueOf("20150612");
        String syouhnNm = syouhinUtil.getSyouhnNm_Ryaku5(syouhnCd, sysDate);
        exStringEquals(syouhnNm, null, "商品名（略称５文字)");

    }

    @Test
    @TestOrder(30)
    public void testGetSyouhnNm_Ryaku5_D3() {
        String syouhnCd = "T110";
        BizDate sysDate = BizDate.valueOf("20150612");
        String syouhnNm = syouhinUtil.getSyouhnNm_Ryaku5(syouhnCd, sysDate);
        exStringEquals(syouhnNm, "T1", "商品名（略称５文字）");

    }
}
