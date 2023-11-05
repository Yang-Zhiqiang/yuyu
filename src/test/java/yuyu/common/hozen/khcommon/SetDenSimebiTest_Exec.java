package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_DensimeNenkanSchedule;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 伝票締切日設定クラスのメソッド {@link SetDenSimebi#exec(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetDenSimebiTest_Exec {

    @Inject
    private SetDenSimebi setDenSimebi;

    private final static String fileName = "UT_SP_単体テスト仕様書_伝票締切日設定";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetDenSimebiTest_Exec.class, fileName, sheetName);
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
        BM_DensimeNenkanSchedule densimeNenkanSchedule = bizDomManager.getDensimeNenkanSchedule(BizDateYM.valueOf("201306"));
        BM_DensimeNenkanSchedule densimeNenkanSchedule2 = bizDomManager.getDensimeNenkanSchedule(BizDateYM.valueOf("201307"));
        bizDomManager.delete(densimeNenkanSchedule);
        bizDomManager.delete(densimeNenkanSchedule2);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        try {

            setDenSimebi.exec(BizDate.valueOf("20130812"));

        } catch (AssertionError e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。伝票締切日年間スケジュールマスタに201308月分のデータが存在しません。 ", "エラーメッセージ");
            throw e;
        }


    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        BizDate resultDate = setDenSimebi.exec(BizDate.valueOf("20130612"));

        exDateEquals(resultDate, BizDate.valueOf("20130612"), "前月伝票締切日");
    }

}
