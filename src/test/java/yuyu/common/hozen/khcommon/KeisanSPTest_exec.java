package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.BzGetPrate2;
import yuyu.common.biz.bzcommon.BzGetPrateMockForHozen;
import yuyu.common.hozen.khcommon.dba4keisansp.KeisanSPDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_RyourituKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * SP計算のメソッド {@link KeisanSP#exec(String, String, BizNumber, C_Hrkkaisuu, int, C_Hhknsei, C_HknkknsmnKbn,
 * int, int, C_Sdpd, BizCurrency, BizCurrency, C_Tuukasyu)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanSPTest_exec {

    @Inject
    private KeisanSP keisanSP;

    private final static String fileName = "UT_SP_単体テスト仕様書_SP計算";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanSPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllIkkatuKeisuu());
        bizDomManager.delete(bizDomManager.getAllIkkatuTekiyouNo2());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzGetPrate2.class).to(BzGetPrateMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        BzGetPrateMockForHozen.caller = KeisanSPTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.caller = null;
        BzGetPrateMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN1;

        String syouhnCd = "ﾕｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "EIC0001", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), null, "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 0), "ﾕｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(1.1234), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 4), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 5), 100, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 7), 15, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 8), 20, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 9), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_RyourituKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 12), C_RyourituKbn.OTHER, "料率区分");

    }

    @Test
    @TestOrder(10)
    public void testExec_A2() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN2;

        String syouhnCd = "ﾆｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1236);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.NEN;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "EIC0001", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), null, "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 2), BizNumber.valueOf(1.1236), "予定利率");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 3), "", "一括払適用分類１");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 4), "", "一括払適用分類２");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 5), "", "一括払適用分類３");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 6), 0, "年１回年２回払表示");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 7), 12, "経過月数");

    }

    @Test
    @TestOrder(1010)
    public void testExec_B1() {

        String syouhnCd = "ﾕA";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500000, BizCurrencyTypes.YEN);
        BizCurrency hknRyou = BizCurrency.valueOf(100000, BizCurrencyTypes.YEN);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 0;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(500000, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

    }

    @Test
    @TestOrder(1020)
    public void testExec_B2() {

        String syouhnCd = "ﾕｹ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), null, "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

    }

    @Test
    @TestOrder(1030)
    public void testExec_B3() {

        String syouhnCd = "ﾕﾍ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.PD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

    }

    @Test
    @TestOrder(1040)
    public void testExec_B4() {

        String syouhnCd = "ﾕﾁ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.TUKI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

    }

    @Test
    @TestOrder(1050)
    public void testExec_B5() {

        String syouhnCd = "ﾕﾁ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.TUKI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.PD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.AU_DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.AU_DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.AUD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), null, "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), null, "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), null, "払別乗数");

    }

    @Test
    @TestOrder(2010)
    public void testExec_C1() {

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN2;

        String syouhnCd = "ﾕｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 100;
        C_Hhknsei hhknSei = C_Hhknsei.MALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(0.55, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), null, "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), BizNumber.valueOf(0.001111), "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), BizNumber.valueOf(0), "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), BizNumber.valueOf(0), "払別乗数");

    }

    @Test
    @TestOrder(2020)
    public void testExec_C2() {

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN3;

        String syouhnCd = "ﾕｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        int hhknNen = 10;
        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.PD;
        BizCurrency hknKingaku = BizCurrency.valueOf(5, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.ITIJIBARAI;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(999999.81, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), BizNumber.valueOf(999.999999), "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), BizNumber.valueOf(999.999801), "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), BizNumber.valueOf(0), "払別乗数");

    }

    @Test
    @TestOrder(2030)
    public void testExec_C3() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN2;

        String syouhnCd = "ﾆｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.TUKI;
        int hhknNen = 10;
        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.SD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(3, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.KOUHURI;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), BizCurrency.valueOf(0.55, BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(keisanSP.getS(), null, "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), BizNumber.valueOf(0.001111), "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), BizNumber.valueOf(0), "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), BizNumber.valueOf(1), "払別乗数");

        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(1.1234), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 4), C_Hhknsei.FEMALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 5), 10, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 7), 15, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 8), 20, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_RyourituKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 12), C_RyourituKbn.KOUHURI, "料率区分");

    }

    @Test
    @TestOrder(2040)
    public void testExec_C4() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN4;

        String syouhnCd = "ﾆｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.NEN;
        int hhknNen = 10;
        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.PD;
        BizCurrency hknKingaku = BizCurrency.valueOf(50000, BizCurrencyTypes.YEN);
        BizCurrency hknRyou = BizCurrency.valueOf(1000000, BizCurrencyTypes.YEN);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.JPY;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HARAIMAN;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(25800, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), BizNumber.valueOf(0.001111), "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), BizNumber.valueOf(0.1234), "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), BizNumber.valueOf(4.8), "払別乗数");

        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(1.1234), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 4), C_Hhknsei.FEMALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 5), 10, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 7), 15, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 8), 20, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 10), C_Tuukasyu.JPY, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_RyourituKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 12), C_RyourituKbn.KOUHURI, "料率区分");

        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 2), BizNumber.valueOf(1.1234), "予定利率");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 3), "", "一括払適用分類１");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 4), "", "一括払適用分類２");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 5), "", "一括払適用分類３");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 6), 0, "年１回年２回払表示");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 7), 12, "経過月数");

    }

    @Test
    @TestOrder(2050)
    public void testExec_C5() {

        MockObjectManager.initialize();

        BzGetPrateMockForHozen.SYORIPTN = BzGetPrateMockForHozen.TESTPATTERN5;

        String syouhnCd = "ﾆｱ";
        String ryouritusdNo = "J";
        BizNumber yoteiRiritu = BizNumber.valueOf(1.1235);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.HALFY;
        int hhknNen = 10;
        C_Hhknsei hhknSei = C_Hhknsei.FEMALE;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        int hknkkn = 15;
        int hrkkkn = 20;
        C_Sdpd sdpd = C_Sdpd.PD;
        BizCurrency hknKingaku = BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR);
        BizCurrency hknRyou = BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR);
        C_Tuukasyu keiyakuTuukasyu = C_Tuukasyu.USD;
        C_Kykjyoutai kykjyoutai = C_Kykjyoutai.HRKMTYUU;
        int dai1hknkkn = 5;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn resultKbn = keisanSP.exec(syouhnCd, ryouritusdNo, yoteiRiritu, haraikomikaisuu, hhknNen, hhknSei,
            hknkknsmnKbn, hknkkn, hrkkkn, sdpd, hknKingaku, hknRyou, keiyakuTuukasyu, kykjyoutai, dai1hknkkn, hrkkeiro);

        exStringEquals(keisanSP.getMsgid(), "", "メッセージID");
        exClassificationEquals(resultKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanSP.getP(), null, "保険料");
        exBizCalcbleEquals(keisanSP.getS(), BizCurrency.valueOf(208340, BizCurrencyTypes.DOLLAR), "保険金額");
        exBizCalcbleEquals(keisanSP.getPRate(), BizNumber.valueOf(0.111), "Ｐレート");
        exBizCalcbleEquals(keisanSP.getPSRate(), BizNumber.valueOf(999.999801), "Ｐ建Ｓレート");
        exBizCalcbleEquals(keisanSP.getHrbtJyousu(), BizNumber.valueOf(4.8), "払別乗数");

        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(1.1235), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 3), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 4), C_Hhknsei.FEMALE, "被保険者性別");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 5), 10, "被保険者年齢");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 7), 15, "保険期間");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 8), 20, "払込期間");
        exClassificationEquals((C_Kykjyoutai) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 9), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 10), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((int) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 11), 5, "第１保険期間");
        exClassificationEquals((C_RyourituKbn) MockObjectManager.getArgument(BzGetPrateMockForHozen.class, "exec", 0, 12), C_RyourituKbn.KOUHURI, "料率区分");

        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 0), "ﾆｱ", "商品コード");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 1), "J", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 2), BizNumber.valueOf(1.1235), "予定利率");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 3), "", "一括払適用分類１");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 4), "", "一括払適用分類２");
        exStringEquals((String) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 5), "", "一括払適用分類３");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 6), 0, "年１回年２回払表示");
        exNumericEquals((Integer) MockObjectManager.getArgument(KeisanSPDao.class, "getIkkatuKeisuu", 0, 7), 6, "経過月数");

    }
}
