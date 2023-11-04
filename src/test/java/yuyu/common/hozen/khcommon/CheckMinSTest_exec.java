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
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckMinSクラスのメソッド {@link CheckMinS#exec(String,int,C_HrkkknsmnKbn,int,C_Tuukasyu,BizDate,BM_SyouhnZokusei,BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMinSTest_exec {

    @Inject
    private CheckMinS checkMinS;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_最低Ｓチェック";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckMinSTest_exec.class, fileName, sheetName);

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
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiS());

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A001", 1);
        try {
            checkMinS.exec("A001", 1, C_HrkkknsmnKbn.NENMANKI, 55,
                C_Tuukasyu.JPY, syouhnZokusei, BizCurrency.valueOf(3000));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｓ事方書チェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A002", 1);
        try {
            checkMinS.exec("A002", 1, C_HrkkknsmnKbn.NENMANKI, 55,
                C_Tuukasyu.JPY, syouhnZokusei, BizCurrency.valueOf(3000));
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "商品０２の手術給付金が事方書の最低手術給付金の3,001 円に未達です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test()
    @TestOrder(30)
    public void testExec_A3() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A003", 1);
        boolean warningUmuFlg = checkMinS.exec("A003", 1, C_HrkkknsmnKbn.NENMANKI, 65,
            C_Tuukasyu.JPY, syouhnZokusei, BizCurrency.valueOf(3000));
        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
    }

    @Test()
    @TestOrder(40)
    public void testExec_A4() {
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("A004", 1);
        boolean warningUmuFlg = checkMinS.exec("A004", 1, C_HrkkknsmnKbn.NENMANKI, 75,
            C_Tuukasyu.USD, syouhnZokusei, BizCurrency.valueOf(3000, BizCurrencyTypes.DOLLAR));
        exBooleanEquals(warningUmuFlg, true, "ワーニング有無フラグ");
        exNumericEquals(checkMinS.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinS.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }
}
