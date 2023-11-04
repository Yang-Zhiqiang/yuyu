package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 取扱年齢範囲チェッククラスのメソッド {@link CheckNenreiHani#exec(String pSyouhnCd, int pSyouhnsdNo,
   C_KataKbn pKataKbn, int pHknKkn, C_HknkknsmnKbn pHknkknSmnKbn, int pHrkKkn, C_HrkkknsmnKbn pHrkkknSmnKbn,
   BizNumber pYoteiRiritu, BM_SyouhnZokusei pSyouhnZokusei, C_Hhknsei pHanteiyouHhknsei, int pHanteiyouHhknnen,
   C_Channelcd pChannelcd)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckNenreiHaniTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_取扱年齢範囲チェック";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckNenreiHaniTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkJhNenreiHani());
        bizDomManager.delete(bizDomManager.getAllChkNenreiHani());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);

        String syouhnCd = "AAA";
        int syouhnsdNo = 1;
        C_KataKbn kataKbn = C_KataKbn.HONNIN;
        int hknKkn = 1;
        C_HknkknsmnKbn hknkknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hrkKkn = 99;
        C_HrkkknsmnKbn hrkkknSmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizNumber yoteiRiritu = BizNumber.valueOf(1);
        int dai1hknkkn = 1;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品名テスト");
        C_Hhknsei hanteiyouHhknsei = C_Hhknsei.MALE;
        int hanteiyouHhknnen = 30;
        C_Channelcd channelCD = C_Channelcd.TIGIN;

        boolean result = checkNenreiHani.exec(syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
            hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen, channelCD);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkNenreiHani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkNenreiHani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }


    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {

        CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);

        String syouhnCd = "AAA";
        int syouhnsdNo = 1;
        C_KataKbn kataKbn = C_KataKbn.HONNIN;
        int hknKkn = 1;
        C_HknkknsmnKbn hknkknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hrkKkn = 99;
        C_HrkkknsmnKbn hrkkknSmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizNumber yoteiRiritu = BizNumber.valueOf(1);
        int dai1hknkkn = 1;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品名テスト");
        C_Hhknsei hanteiyouHhknsei = C_Hhknsei.MALE;
        int hanteiyouHhknnen = 33;
        C_Channelcd channelCD = C_Channelcd.TIGIN;

        try {
            checkNenreiHani.exec(syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
                hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen, channelCD);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "商品名テストの事方書の契約可能期間・年齢範囲外です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);

        String syouhnCd = "AAA";
        int syouhnsdNo = 1;
        C_KataKbn kataKbn = C_KataKbn.HONNIN;
        int hknKkn = 1;
        C_HknkknsmnKbn hknkknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hrkKkn = 99;
        C_HrkkknsmnKbn hrkkknSmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizNumber yoteiRiritu = BizNumber.valueOf(1);
        int dai1hknkkn = 1;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品名テスト");
        C_Hhknsei hanteiyouHhknsei = C_Hhknsei.MALE;
        int hanteiyouHhknnen = 32;
        C_Channelcd channelCD = C_Channelcd.TIGIN;

        boolean result = checkNenreiHani.exec(syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
            hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen, channelCD);

        exBooleanEquals(result, false, "ワーニング有無フラグ");

        exNumericEquals(checkNenreiHani.getWarningMsgIdList().size(), 1, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkNenreiHani.getWarningMsgList().size(), 1, "ワーニングメッセージリストの件数");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_A4() {

        CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);

        String syouhnCd = "ﾕﾁ";
        int syouhnsdNo = 1;
        C_KataKbn kataKbn = C_KataKbn.HONNIN;
        int hknKkn = 40;
        C_HknkknsmnKbn hknkknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hrkKkn = 99;
        C_HrkkknsmnKbn hrkkknSmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizNumber yoteiRiritu = BizNumber.valueOf(1);
        int dai1hknkkn = 1;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品名テスト");
        C_Hhknsei hanteiyouHhknsei = C_Hhknsei.MALE;
        int hanteiyouHhknnen = 30;
        C_Channelcd channelCD = C_Channelcd.TIGIN;

        checkNenreiHani.exec(syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
            hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen, channelCD);

        try {
            checkNenreiHani.exec( syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
                hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen,channelCD);
        } catch (BizLogicException e) {
            exStringEquals(e.getMessage(), "商品名テストの事方書の契約可能期間・年齢範囲外です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        CheckNenreiHani checkNenreiHani = SWAKInjector.getInstance(CheckNenreiHani.class);

        String syouhnCd = "ﾕﾁ";
        int syouhnsdNo = 1;
        C_KataKbn kataKbn = C_KataKbn.HONNIN;
        int hknKkn = 40;
        C_HknkknsmnKbn hknkknSmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hrkKkn = 99;
        C_HrkkknsmnKbn hrkkknSmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizNumber yoteiRiritu = BizNumber.valueOf(1);
        int dai1hknkkn = 1;
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhnnm("商品名テスト");
        C_Hhknsei hanteiyouHhknsei = C_Hhknsei.MALE;
        int hanteiyouHhknnen = 29;
        C_Channelcd channelCD = C_Channelcd.TIGIN;

        boolean result = checkNenreiHani.exec(syouhnCd, syouhnsdNo, kataKbn, hknKkn, hknkknSmnKbn, hrkKkn,
            hrkkknSmnKbn, yoteiRiritu, dai1hknkkn, syouhnZokusei, hanteiyouHhknsei, hanteiyouHhknnen, channelCD);

        exBooleanEquals(result, true, "ワーニング有無フラグ");

        exNumericEquals(checkNenreiHani.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリストの件数");
        exNumericEquals(checkNenreiHani.getWarningMsgList().size(), 0, "ワーニングメッセージリストの件数");
    }
}
