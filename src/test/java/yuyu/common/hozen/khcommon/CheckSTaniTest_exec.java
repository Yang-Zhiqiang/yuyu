package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizCurrency;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.TestOrder;

/**
 * Ｓ単位チェックククラスのメソッド {@link CheckSTani#exec(String, int, int, C_Tuukasyu, BM_SyouhnZokusei, BizCurrency)} テスト用クラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class CheckSTaniTest_exec {

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_Ｓ単位チェック";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckSTaniTest_exec.class, fileName, sheetName);

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
        bizDomManager.delete(bizDomManager.getAllChkSTani());

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("0004", 1);
        CheckSTani checkSTani = SWAKInjector.getInstance(CheckSTani.class);
        try {
            checkSTani.exec("0004", 1, 2, C_Tuukasyu.JPY,
                syouhnZokusei, BizCurrency.valueOf(0));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。Ｓ単位チェックマスタが取得できません。", "エラーメッセージ");
            exNumericEquals(checkSTani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
            exNumericEquals(checkSTani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
            throw e;

        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("1002", 2);
        CheckSTani checkSTani = SWAKInjector.getInstance(CheckSTani.class);

        try {
            checkSTani.exec("1002", 2, 3, C_Tuukasyu.USD,
                syouhnZokusei, BizCurrency.valueOf(10001));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "商品０２の手術給付金が1,000 円単位でないため、処理できません。", "エラーメッセージ");
            exNumericEquals(checkSTani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
            exNumericEquals(checkSTani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
            throw e;
        }
    }

    @Test()
    @TestOrder(30)
    public void testExec_A3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("10003", 2);
        CheckSTani checkSTani = SWAKInjector.getInstance(CheckSTani.class);

        boolean warningUmuFlg = checkSTani.exec("1003", 2, 3, C_Tuukasyu.USD,
            syouhnZokusei, BizCurrency.valueOf(10000));

        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
        exNumericEquals(checkSTani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkSTani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

}