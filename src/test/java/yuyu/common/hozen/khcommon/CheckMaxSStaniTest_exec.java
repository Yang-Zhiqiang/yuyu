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
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

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
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckMaxSStaniクラスのメソッド {@link CheckMaxSStani#exec(String,int,int,C_Tuukasyu,BizDate,BM_SyouhnZokusei,BizCurrency,BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMaxSStaniTest_exec {

    @Inject
    private CheckMaxSStani checkMaxSStani;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_最高ＳＳ単位チェック";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckMaxSStaniTest_exec.class, fileName, sheetName);

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
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("A001", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("A002", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("A003", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("A004", 1));
        bizDomManager.delete(bizDomManager.getAllChkJhSaikouSSTani());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A001", 1);
        try {
            checkMaxSStani.exec("A001", 1, 55, C_Tuukasyu.JPY, BizDate.valueOf("20161001"),
                syouhnZokusei, BizCurrency.valueOf(5000), BizCurrency.valueOf(2000));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最高ＳＳ単位チェックマスタ事方書にデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A002", 1);
        try {
            checkMaxSStani.exec("A002", 1, 55, C_Tuukasyu.JPY, BizDate.valueOf("20161001"),
                syouhnZokusei, BizCurrency.valueOf(5000), BizCurrency.valueOf(2000));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "商品０２の手術給付金が事方書の最高手術給付金の4,999 円をオーバーしています。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A003", 1);
        boolean warningUmuFlg = checkMaxSStani.exec("A003", 1, 65, C_Tuukasyu.JPY, BizDate.valueOf("20161001"),
            syouhnZokusei, BizCurrency.valueOf(5000), BizCurrency.valueOf(2000));
        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A004", 1);
        boolean warningUmuFlg = checkMaxSStani.exec("A004", 1, 75, C_Tuukasyu.USD, BizDate.valueOf("20161001"),
            syouhnZokusei, BizCurrency.valueOf(3000, BizCurrencyTypes.DOLLAR), BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR));
        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
        exNumericEquals(checkMaxSStani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMaxSStani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A002", 1);

        boolean warningUmuFlg = checkMaxSStani.exec("A002", 1, 55, C_Tuukasyu.JPY, BizDate.valueOf("20161001"),
            syouhnZokusei, BizCurrency.valueOf(0), BizCurrency.valueOf(2000));

        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
        exNumericEquals(checkMaxSStani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMaxSStani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A002", 1);
        try {
            checkMaxSStani.exec("A002", 1, 55, null, BizDate.valueOf("20161001"),
                syouhnZokusei, BizCurrency.valueOf(5000), BizCurrency.valueOf(2000));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。基準判定用Ｓ計算処理でエラーが発生しました。", "エラーメッセージ");
            throw e;
        }
    }

}
