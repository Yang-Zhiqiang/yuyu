package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
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
 * 商品属性ユーティリティのメソッド {@link SyouhinUtil#getSyouhnNmList(List<String>, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SyouhinUtilTest_getSyouhnNmList {

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
            testDataAndTblMap = testDataMaker.getInData(SyouhinUtilTest_getSyouhnNmList.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
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
    @Transactional
    @TestOrder(10)
    public void testGetSyouhnNmList_F1() {
        List<String> syouhnNmsLst = new ArrayList<>();
        BizDate sysDate = null;

        List<String> syouhnNmLst = syouhinUtil.getSyouhnNmList(syouhnNmsLst, sysDate);
        exNumericEquals(syouhnNmLst.size(), 0, "商品名リストの件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testGetSyouhnNmList_F2() {
        List<String> syouhnNmsLst = new ArrayList<>();
        syouhnNmsLst.add("M110");

        BizDate sysDate = null;

        List<String> syouhnNmLst =  syouhinUtil.getSyouhnNmList(syouhnNmsLst, sysDate);
        exNumericEquals(syouhnNmLst.size(), 1, "商品名リストの件数");
        exStringEquals(syouhnNmLst.get(0), null, "商品名");
    }

    @Test
    @TestOrder(30)
    public void testGetSyouhnNmList_F3() {
        List<String> syouhnNmsLst = new ArrayList<>();
        syouhnNmsLst.add("M110");
        BizDate sysDate = BizDate.valueOf("20150612");


        List<String> syouhnNmLst = syouhinUtil.getSyouhnNmList(syouhnNmsLst, sysDate);
        exNumericEquals(syouhnNmLst.size(), 1, "商品名リストの件数");
        exStringEquals(syouhnNmLst.get(0), "入院保険", "商品名");
    }

    @Test
    @TestOrder(40)
    public void testGetSyouhnNmList_F4() {
        List<String> syouhnNmsLst = new ArrayList<>();
        syouhnNmsLst.add("M110");
        syouhnNmsLst.add("M120");
        syouhnNmsLst.add("MB10");
        BizDate sysDate = BizDate.valueOf("20150613");


        List<String> syouhnNmLst = syouhinUtil.getSyouhnNmList(syouhnNmsLst, sysDate);
        exNumericEquals(syouhnNmLst.size(), 3, "商品名リストの件数");
        exStringEquals(syouhnNmLst.get(0), "入院保険", "商品名");
        exStringEquals(syouhnNmLst.get(1), "長期入院保険", "商品名");
        exStringEquals(syouhnNmLst.get(2), "手術特約", "商品名");
    }
}
