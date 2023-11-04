package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

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
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 最低Ｐチェックのメソッド {@link CheckMinP#exec(String, int, C_Tuukasyu, int,C_HrkkknsmnKbn, BizCurrency, BizCurrency,
        int, C_Hrkkaisuu, BM_SyouhnZokusei, C_Channelcd,C_UmuKbn, C_UmuKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckMinPTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_最低Ｐチェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckMinPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkJhSaiteiP());
        bizDomManager.delete(bizDomManager.getAllChkSaiteiP());
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testExec_A1() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾁ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(4999);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10001);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０１");

        C_Channelcd channelcd = C_Channelcd.TIGIN;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "円貨払込額が販売基準の最低保険料に未達です。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "SH02";

        int syouhnsdNo = 3;

        int hrkkkn = 100;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(4999);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10001);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０２");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。年歳満期変換処理が実行できませんでした。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "SH03";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(4999);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10001);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０３");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。最低Ｐ事方書チェックマスタにデータが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_A4() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾂ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(4999);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(9999);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０４");

        C_Channelcd channelcd = C_Channelcd.TIGIN;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "商品０４の払込保険料が事方書の最低保険料の10,000 円に未達です。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾃ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(4999);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０５");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。最低Ｐチェックマスタにデータが存在しません。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾄ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5001);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10001);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０６");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾅ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10001);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０７");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testExec_A8() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾆ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(10000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０８");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        try {
            checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou, pPharaikomisougaku, hhknnen,
                hrkkaisuu, syouhnZokusei, channelcd);

        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "円貨払込額の合計額が販売基準の最低保険料に未達です。",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾇ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品０９");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾈ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品１０");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾁ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品１１");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "ﾕﾂ";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.TUKI;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品１２");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        CheckMinP checkMinP = SWAKInjector.getInstance(CheckMinP.class);

        String syouhnCd = "SH13";

        int syouhnsdNo = 3;

        int hrkkkn = 1;

        C_HrkkknsmnKbn pHrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;

        BizCurrency pHokenryou = BizCurrency.valueOf(5000);

        BizCurrency pPharaikomisougaku = BizCurrency.valueOf(10000);

        int hhknnen = 30;

        C_Hrkkaisuu hrkkaisuu = C_Hrkkaisuu.HALFY;

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品１３");

        C_Channelcd channelcd = C_Channelcd.SHOP;

        boolean result = checkMinP.exec(syouhnCd, syouhnsdNo, hrkkkn, pHrkkknsmnKbn, pHokenryou,
            pPharaikomisougaku, hhknnen, hrkkaisuu, syouhnZokusei, channelcd);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkMinP.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkMinP.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }
}
