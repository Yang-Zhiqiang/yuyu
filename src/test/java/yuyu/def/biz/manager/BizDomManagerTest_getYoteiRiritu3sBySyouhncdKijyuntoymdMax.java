package yuyu.def.biz.manager;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritu3sBySyouhncdKijyuntoymdMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritu3sBySyouhncdKijyuntoymdMax {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getYoteiRiritu3sBySyouhncdKijyuntoymdMax";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu3> yoteiRiritu3List = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax("2222");

        exNumericEquals(yoteiRiritu3List.size(), 0, "件数");
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getYoteiRiritu3sBySyouhncdKijyuntoymdMax.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu3());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu3> yoteiRiritu3List = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax("1011");

        exNumericEquals(yoteiRiritu3List.size(), 0, "件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu3> yoteiRiritu3List = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax("2222");

        exNumericEquals(yoteiRiritu3List.size(), 1, "件数");
        exStringEquals(yoteiRiritu3List.get(0).getSyouhncd(), "2222", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(0).getYoteiriritutkybr1(), "1", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(0).getYoteiriritutkybr2(), "1", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(0).getKijyunfromymd(), BizDate.valueOf(20200101), "基準日自");
        exDateEquals(yoteiRiritu3List.get(0).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu3> yoteiRiritu3List = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax("3333");

        exNumericEquals(yoteiRiritu3List.size(), 5, "件数");
        exStringEquals(yoteiRiritu3List.get(0).getSyouhncd(), "3333", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(0).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(0).getYoteiriritutkybr1(), "1", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(0).getYoteiriritutkybr2(), "1", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(0).getKijyunfromymd(), BizDate.valueOf(20200101), "基準日自");
        exDateEquals(yoteiRiritu3List.get(0).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");

        exStringEquals(yoteiRiritu3List.get(1).getSyouhncd(), "3333", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(1).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(1).getYoteiriritutkybr1(), "1", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(1).getYoteiriritutkybr2(), "1", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(1).getKijyunfromymd(), BizDate.valueOf(20200102), "基準日自");
        exDateEquals(yoteiRiritu3List.get(1).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");

        exStringEquals(yoteiRiritu3List.get(2).getSyouhncd(), "3333", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(2).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(2).getYoteiriritutkybr1(), "1", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(2).getYoteiriritutkybr2(), "2", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(2).getKijyunfromymd(), BizDate.valueOf(20200101), "基準日自");
        exDateEquals(yoteiRiritu3List.get(2).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");

        exStringEquals(yoteiRiritu3List.get(3).getSyouhncd(), "3333", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(3).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(3).getYoteiriritutkybr1(), "2", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(3).getYoteiriritutkybr2(), "1", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(3).getKijyunfromymd(), BizDate.valueOf(20200101), "基準日自");
        exDateEquals(yoteiRiritu3List.get(3).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");

        exStringEquals(yoteiRiritu3List.get(4).getSyouhncd(), "3333", "商品コード");
        exClassificationEquals(yoteiRiritu3List.get(4).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(yoteiRiritu3List.get(4).getYoteiriritutkybr1(), "1", "予定利率適用分類１");
        exStringEquals(yoteiRiritu3List.get(4).getYoteiriritutkybr2(), "1", "予定利率適用分類２");
        exDateEquals(yoteiRiritu3List.get(4).getKijyunfromymd(), BizDate.valueOf(20200101), "基準日自");
        exDateEquals(yoteiRiritu3List.get(4).getKijyuntoymd(), BizDate.valueOf(20201231), "基準日至");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu3> yoteiRiritu3List = bizDomManager.getYoteiRiritu3sBySyouhncdKijyuntoymdMax("");

        exNumericEquals(yoteiRiritu3List.size(), 0, "件数");
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
