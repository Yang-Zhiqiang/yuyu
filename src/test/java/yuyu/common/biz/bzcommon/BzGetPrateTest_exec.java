package yuyu.common.biz.bzcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_RateGetErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzGetDrateクラスのメソッド {@link BzGetPrate#exec(String, String, BizNumber, C_Hrkkaisuu, C_Hhknsei, int, C_HknkknsmnKbn, int, int)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetPrateTest_exec {

    @Inject
    private BzGetPrate bzGetPrate;

    private final static String fileName = "UT_SP_単体テスト仕様書_Ｐレート取得処理";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetPrateTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllRateP());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzGetPrateBean bzGetPrateBean = bzGetPrate.exec(
            "1234"
            , "632"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 10
            , C_HknkknsmnKbn.NENMANKI
            , 15
            , 20);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(bzGetPrateBean.getRateGetErrorKbn(), C_RateGetErrorKbn.TARGETERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzGetPrateBean bzGetPrateBean = bzGetPrate.exec("2345"
            , "632"
            , BizNumber.valueOf(1.1234)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.MALE
            , 10
            , C_HknkknsmnKbn.NENMANKI
            , 15
            , 20);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("Ｐレート", bzGetPrateBean.getPrate(), BizNumber.valueOf(111.001111));
        assertEquals("Ｐ建Ｓレート", bzGetPrateBean.getPsRate(), BizNumber.valueOf(222.002222));
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzGetPrateBean bzGetPrateBean = bzGetPrate.exec("2345"
            , "732"
            , BizNumber.valueOf(0.0034)
            , C_Hrkkaisuu.ITIJI
            , C_Hhknsei.FEMALE
            , 10
            , C_HknkknsmnKbn.SAIMANKI
            , 15
            , 20);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("Ｐレート", bzGetPrateBean.getPrate(), BizNumber.valueOf(33.003333));
        assertEquals("Ｐ建Ｓレート", bzGetPrateBean.getPsRate(), BizNumber.valueOf(44.004444));
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzGetPrateBean bzGetPrateBean = bzGetPrate.exec("2345"
            , "832"
            , BizNumber.valueOf(0.0004)
            , C_Hrkkaisuu.HALFY
            , C_Hhknsei.FEMALE
            , 10
            , C_HknkknsmnKbn.SAIMANKI
            , 15
            , 20);

        exClassificationEquals(bzGetPrateBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
        assertEquals("Ｐレート", bzGetPrateBean.getPrate(), BizNumber.valueOf(55.005555));
        assertEquals("Ｐ建Ｓレート", bzGetPrateBean.getPsRate(), BizNumber.valueOf(66.006666));
    }

}
