package yuyu.def.biz.manager;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getChkNenreiHani2CountByPkHhknsei() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getChkNenreiHani2CountByPkHhknsei {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getChkNenreiHani2CountByPkHhknsei";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getChkNenreiHani2CountByPkHhknsei(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(30),
            BizNumber.valueOf(1.1234),
            7);

        exNumericEquals(count, 0, "件数");
    }

    @Transactional
    public static void insertSubData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getChkNenreiHani2CountByPkHhknsei.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        if(bizDomManager.getAllChkNenreiHani2().size() > 0){
            bizDomManager.delete(bizDomManager.getAllChkNenreiHani2());
        }
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult() {

        insertSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getChkNenreiHani2CountByPkHhknsei(
            C_Channelcd.SMBC,
            "ｱ1",
            10,
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(30),
            BizNumber.valueOf(1.1234),
            7);

        exNumericEquals(count, 0, "件数");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getChkNenreiHani2CountByPkHhknsei(
            C_Channelcd.MIZUHO,
            "ｱ1",
            10,
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(30),
            BizNumber.valueOf(1.1234),
            7);

        exNumericEquals(count, 1, "件数");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getChkNenreiHani2CountByPkHhknsei(
            C_Channelcd.SMTB,
            "ｱ1",
            10,
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(30),
            BizNumber.valueOf(1.1234),
            7);

        exNumericEquals(count, 3, "件数");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blankCondition() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        Long count = bizDomManager.getChkNenreiHani2CountByPkHhknsei(
            C_Channelcd.SMTB,
            "",
            10,
            4,
            C_KataKbn.HONNIN,
            5,
            C_HknkknsmnKbn.SAIMANKI,
            6,
            C_HrkkknsmnKbn.NENMANKI,
            BizNumber.valueOf(30),
            BizNumber.valueOf(1.1234),
            7);

        exNumericEquals(count, 0, "件数");
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
