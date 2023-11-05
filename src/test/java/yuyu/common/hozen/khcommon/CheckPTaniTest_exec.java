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
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * CheckPTaniクラスのメソッド {@link CheckPTani#exec(String, C_Hrkkaisuu, Integer, C_Channelcd, C_Tuukasyu, BM_SyouhnZokusei, BizCurrency)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckPTaniTest_exec {

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_Ｐ単位チェック";

    private final static String sheetName = "テストデータ";


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
        bizDomManager.delete(bizDomManager.getAllChkHrkPTani());

    }
    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);

        String pSyouhnCd = "ﾕﾂ";
        C_Hrkkaisuu pHrkKaisuu = C_Hrkkaisuu.ITIJI;
        Integer pSyouhnsdno = 1;
        C_Channelcd pChannelcd = C_Channelcd.TIGIN;
        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhnCd, pSyouhnsdno);
        BizCurrency pHntiP = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        try {
            checkPTani.exec(pSyouhnCd, pHrkKaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu, pSyouhnZokusei, pHntiP);
        } catch(CommonBizAppException e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。払込Ｐ単位チェックマスタが取得できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);

        String pSyouhnCd = "ﾕﾁ";
        C_Hrkkaisuu pHrkKaisuu = C_Hrkkaisuu.ITIJI;
        Integer pSyouhnsdno = 1;
        C_Channelcd pChannelcd = C_Channelcd.TIGIN;
        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhnCd, pSyouhnsdno);
        BizCurrency pHntiP = BizCurrency.valueOf(1600, BizCurrencyTypes.YEN);

        try {
            checkPTani.exec(pSyouhnCd, pHrkKaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu, pSyouhnZokusei, pHntiP);
        } catch(BizLogicException e) {

            exStringEquals(e.getMessage(), "円商品名の払込保険料が1,000 円単位でないため、処理できません。", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);

        String pSyouhnCd = "ﾕﾁ";
        C_Hrkkaisuu pHrkKaisuu = C_Hrkkaisuu.ITIJI;
        Integer pSyouhnsdno = 2;
        C_Channelcd pChannelcd = C_Channelcd.TIGIN;
        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.USD;
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhnCd, pSyouhnsdno);
        BizCurrency pHntiP = BizCurrency.valueOf(1400, BizCurrencyTypes.DOLLAR);

        try {
            checkPTani.exec(pSyouhnCd, pHrkKaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu, pSyouhnZokusei, pHntiP);
        } catch(BizLogicException e) {

            exStringEquals(e.getMessage(), "米ドル商品名の払込保険料が1,000.00 米ドル単位でないため、処理できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);

        String pSyouhnCd = "ﾕﾁ";
        C_Hrkkaisuu pHrkKaisuu = C_Hrkkaisuu.ITIJI;
        Integer pSyouhnsdno = 1;
        C_Channelcd pChannelcd = C_Channelcd.TIGIN;
        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.JPY;
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhnCd, pSyouhnsdno);
        BizCurrency pHntiP = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);

        boolean preturn = checkPTani.exec(pSyouhnCd, pHrkKaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu, pSyouhnZokusei, pHntiP);

        exBooleanEquals(preturn, false, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        CheckPTani checkPTani = SWAKInjector.getInstance(CheckPTani.class);

        String pSyouhnCd = "ﾕﾁ";
        C_Hrkkaisuu pHrkKaisuu = C_Hrkkaisuu.ITIJI;
        Integer pSyouhnsdno = 2;
        C_Channelcd pChannelcd = C_Channelcd.TIGIN;
        C_Tuukasyu pHrktuukasyu = C_Tuukasyu.USD;
        BM_SyouhnZokusei pSyouhnZokusei = bizDomManager.getSyouhnZokusei(pSyouhnCd, pSyouhnsdno);
        BizCurrency pHntiP = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);

        boolean preturn = checkPTani.exec(pSyouhnCd, pHrkKaisuu, pSyouhnsdno, pChannelcd, pHrktuukasyu, pSyouhnZokusei, pHntiP);

        exBooleanEquals(preturn, true, "処理結果");
        exNumericEquals(checkPTani.getWarningMsgIdList().size(), 0 ,"ワーニングメッセージIDリスト");
        exNumericEquals(checkPTani.getWarningMsgList().size(), 0 ,"ワーニングメッセージリスト");

    }
}
