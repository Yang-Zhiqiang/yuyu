package yuyu.common.siharai.sicommon;

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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.KeisanWExt;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険金額計算クラスのメソッド {@link CalcHkShrKngk#exec(String, Integer, String, BizNumber, C_Hrkkaisuu,
            C_HknkknsmnKbn, Integer, Integer, Integer, C_Hhknsei, BizCurrency, BizDate, BizDate, String, C_Tuukasyu,
            Integer, Integer, C_SiinKbn, C_HokenkinsyuruiKbn, BizCurrency, C_UmuKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CalcHkShrKngkTest_exec {

    @Inject
    private CalcHkShrKngk calcHkShrKngk;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金額計算";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CalcHkShrKngkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕｱ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕｻ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾕﾅ", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ﾆｱ", 1));
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanWExt.class).to(KeisanWExtMockForSiharai.class);
                bind(CalcHkShrKngkItijibrSysn.class).to(CalcHkShrKngkItijibrSysnMockForSiharai.class);
                bind(CalcHkShrKngkItijibrKojinNk.class).to(CalcHkShrKngkItijibrKojinNkMockForSiharai.class);
                bind(CalcHkKngkHijynbrKojinNk.class).to(CalcHkKngkHijynbrKojinNkMockForSiharai.class);
                bind(GetSibouymdW.class).to(GetSibouymdWMockForSiharai.class);
                bind(CalcHkKngkHijynbrSysn.class).to(CalcHkKngkHijynbrSysnMockForSiharai.class);

            }
        });
    }

    @BeforeClass
    public static void testInit(){
        MockObjectManager.initialize();

        KeisanWExtMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
        CalcHkShrKngkItijibrSysnMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
        CalcHkShrKngkItijibrKojinNkMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
        CalcHkKngkHijynbrKojinNkMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
        GetSibouymdWMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
        CalcHkKngkHijynbrSysnMockForSiharai.caller = CalcHkShrKngkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWExtMockForSiharai.caller = null;
        KeisanWExtMockForSiharai.SYORIPTN = null;
        CalcHkShrKngkItijibrSysnMockForSiharai.caller = null;
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = null;
        CalcHkShrKngkItijibrKojinNkMockForSiharai.caller = null;
        CalcHkShrKngkItijibrKojinNkMockForSiharai.SYORIPTN = null;
        CalcHkKngkHijynbrKojinNkMockForSiharai.caller = null;
        CalcHkKngkHijynbrKojinNkMockForSiharai.SYORIPTN = null;
        GetSibouymdWMockForSiharai.caller = null;
        GetSibouymdWMockForSiharai.SYORIPTN = null;
        CalcHkKngkHijynbrSysnMockForSiharai.caller = null;
        CalcHkKngkHijynbrSysnMockForSiharai.SYORIPTN = null;
    }

    @Test
    @TestOrder(100)
    public void testExec_A01() {
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrSysnMockForSiharai.TESTPATTERN1;
        String syohinCd = "ﾕｱ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR);
        BizDate kykymd = BizDate.valueOf(20160201);
        BizDate calckijyunymd = BizDate.valueOf(20200201);
        String syoukenNo = "20000000001";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;
        Integer dai1HknKkn = 5;
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.4321);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.2345);
        BizDateYM tmttkntaisyouYm = BizDateYM.valueOf(202012);
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(1.2345);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = BizDate.valueOf(20170201);
        C_Sdpd sdpdkbn = C_Sdpd.BLNK;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")),
            "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR), "保険料累計");

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = (CalcHkShrKngkInputBean) MockObjectManager.getArgument(CalcHkShrKngkItijibrSysnMockForSiharai.class, "exec", 0, 0);
        exStringEquals(calcHkShrKngkInputBean.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(calcHkShrKngkInputBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(calcHkShrKngkInputBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(calcHkShrKngkInputBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(calcHkShrKngkInputBean.getHrkkkn(), 78, "払込期間");
        exNumericEquals(calcHkShrKngkInputBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(calcHkShrKngkInputBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exDateEquals(calcHkShrKngkInputBean.getKykymd(), BizDate.valueOf(20160201), "契約日");
        exDateEquals(calcHkShrKngkInputBean.getCalckijyunymd(), BizDate.valueOf(20200201), "計算基準日");
        exStringEquals(calcHkShrKngkInputBean.getSyono(), "20000000001", "証券番号");
        exClassificationEquals(calcHkShrKngkInputBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals(calcHkShrKngkInputBean.getDai1hknkkn(), 5, "第１保険期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSiinkbn(), C_SiinKbn.SG, "死因区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.4321), "解約時市場価格調整用利率");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.2345), "契約時市場価格調整用利率");
        exDateYMEquals(calcHkShrKngkInputBean.getTmttkntaisyouym(),BizDateYM.valueOf(202012), "積立金対象年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTumitateriritu(), BizNumber.valueOf(1.2345), "積立利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkknsmnKbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exDateYMEquals(calcHkShrKngkInputBean.getJkipjytYm(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getPtmttKngk(), null, "保険料積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihrkmPStgk(), null, "既払込保険料相当額");
        exDateEquals(calcHkShrKngkInputBean.getFstPryosyuYmd(), null, "初回保険料領収日");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteirrthendohosyuRiritu(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exClassificationEquals(calcHkShrKngkInputBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exDateEquals(calcHkShrKngkInputBean.getYendthnkYmd(), BizDate.valueOf(20170201), "円建変更日");
        exClassificationEquals(calcHkShrKngkInputBean.getSdpdkbn(), C_Sdpd.BLNK, "Ｓ建Ｐ建区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");

    }

    @Test
    @TestOrder(110)
    public void testExec_A02() {
        CalcHkShrKngkItijibrKojinNkMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrKojinNkMockForSiharai.TESTPATTERN1;
        String syohinCd = "ﾕｻ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR);
        BizDate kykymd = BizDate.valueOf(20160203);
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000003";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;
        Integer dai1HknKkn = 0;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.1234);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.5432);
        BizDateYM tmttkntaisyouYm = BizDateYM.valueOf(202012);
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(1.2345);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "保険料累計");

    }

    @Test
    @TestOrder(200)
    public void testExec_B01() {
        String syoukenNo = null;
        BizDate calckijyunymd = BizDate.valueOf(20200201);
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(210)
    public void testExec_B02() {
        String syoukenNo = "20000000001";
        BizDate calckijyunymd = null;
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(300)
    public void testExec_C01() {
        String syoukenNo = "20000000001";
        BizDate calckijyunymd = BizDate.valueOf(20200201);
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(400)
    public void testExec_D01() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrSysnMockForSiharai.TESTPATTERN1;
        String syoukenNo = "20000000001";
        BizDate calckijyunymd = BizDate.valueOf(20200201);
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");

        exStringEquals((String) MockObjectManager.getArgument(KeisanWExtMockForSiharai.class, "exec", 0, 0),
            "20000000001", "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWExtMockForSiharai.class, "exec", 0, 1),
            BizDate.valueOf(20200201), "計算基準日");

    }

    @Test
    @TestOrder(410)
    public void testExec_D02() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN2;
        CalcHkShrKngkItijibrKojinNkMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrKojinNkMockForSiharai.TESTPATTERN1;
        String syoukenNo = "20000000003";
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "保険料累計");

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = (CalcHkShrKngkInputBean) MockObjectManager.getArgument(CalcHkShrKngkItijibrKojinNkMockForSiharai.class, "exec", 1, 0);

        exStringEquals(calcHkShrKngkInputBean.getSyouhncd(), "ﾕｻ", "商品コード");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(calcHkShrKngkInputBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "保険期間歳満期区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(calcHkShrKngkInputBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(calcHkShrKngkInputBean.getHrkkkn(), 78, "払込期間");
        exNumericEquals(calcHkShrKngkInputBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(calcHkShrKngkInputBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exDateEquals(calcHkShrKngkInputBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exDateEquals(calcHkShrKngkInputBean.getCalckijyunymd(), BizDate.valueOf(20200203), "計算基準日");
        exStringEquals(calcHkShrKngkInputBean.getSyono(), "20000000003", "証券番号");
        exClassificationEquals(calcHkShrKngkInputBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exNumericEquals(calcHkShrKngkInputBean.getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSiinkbn(), C_SiinKbn.BLNK, "死因区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.BLNK, "保険金種類区分");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR), "保険料");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.1234), "解約時市場価格調整用利率");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.5432), "契約時市場価格調整用利率");
        exDateYMEquals(calcHkShrKngkInputBean.getTmttkntaisyouym(),BizDateYM.valueOf(202012), "積立金対象年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTumitateriritu(), BizNumber.valueOf(1.2345), "積立利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkknsmnKbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exDateYMEquals(calcHkShrKngkInputBean.getJkipjytYm(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getPtmttKngk(), null, "保険料積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihrkmPStgk(), null, "既払込保険料相当額");
        exDateEquals(calcHkShrKngkInputBean.getFstPryosyuYmd(), null, "初回保険料領収日");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteirrthendohosyuRiritu(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exClassificationEquals(calcHkShrKngkInputBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exDateEquals(calcHkShrKngkInputBean.getYendthnkYmd(), BizDate.valueOf(20170203), "円建変更日");
        exClassificationEquals(calcHkShrKngkInputBean.getSdpdkbn(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");

    }

    @Test
    @TestOrder(500)
    public void testExec_E01() {
        CalcHkShrKngkItijibrKojinNkMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrKojinNkMockForSiharai.TESTPATTERN2;
        String syohinCd = "ﾕｻ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR);
        BizDate kykymd = null;
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000003";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;
        Integer dai1HknKkn = 0;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(0);
        BizDateYM tmttkntaisyouYm = BizDateYM.valueOf(202012);
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(1.2345);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;


        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(510)
    public void testExec_E02() {
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrSysnMockForSiharai.TESTPATTERN2;
        String syohinCd = "ﾕｱ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR);
        BizDate kykymd = BizDate.valueOf(20160201);
        BizDate calckijyunymd = null;
        String syoukenNo = "20000000001";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;
        Integer dai1HknKkn = 5;
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.4321);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.2345);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(520)
    public void testExec_E03() {
        CalcHkKngkHijynbrKojinNkMockForSiharai.SYORIPTN = CalcHkKngkHijynbrKojinNkMockForSiharai.TESTPATTERN2;
        String syohinCd = "ﾕﾅ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.NEN;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 2;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR);
        BizDate kykymd = null;
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000005";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;
        Integer dai1HknKkn = 0;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(0);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizDateYM jkipjytYm = BizDateYM.valueOf(202002);
        BizCurrency ptmttKngk = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency kihrkmPStgk = BizCurrency.valueOf(Long.valueOf("7000004000007"), BizCurrencyTypes.AU_DOLLAR);
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0.5432);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.HRKMTYUU;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(530)
    public void testExec_E04() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN3;
        CalcHkKngkHijynbrKojinNkMockForSiharai.SYORIPTN = CalcHkKngkHijynbrKojinNkMockForSiharai.TESTPATTERN1;
        GetSibouymdWMockForSiharai.SYORIPTN = GetSibouymdWMockForSiharai.TESTPATTERN2;
        String syoukenNo = "20000000005";
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000008000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(540)
    public void testExec_E05() {
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrSysnMockForSiharai.TESTPATTERN2;
        String syohinCd = "ﾕﾊ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR);
        BizDate kykymd = BizDate.valueOf(20160201);
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000001";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;
        Integer dai1HknKkn = 5;
        C_SiinKbn siinKbn = C_SiinKbn.SG;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.4321);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.2345);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(550)
    public void testExec_E06() {
        CalcHkKngkHijynbrSysnMockForSiharai.SYORIPTN = CalcHkKngkHijynbrSysnMockForSiharai.TESTPATTERN2;
        String syohinCd = "ﾆｱ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.NEN;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.NENMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 2;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR);
        BizDate kykymd = null;
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000005";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;
        Integer dai1HknKkn = 0;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(0);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.NENMANKI;
        BizDateYM jkipjytYm = BizDateYM.valueOf(202002);
        BizCurrency ptmttKngk = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency kihrkmPStgk = BizCurrency.valueOf(Long.valueOf("7000004000007"), BizCurrencyTypes.AU_DOLLAR);
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0.5432);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.HRKMTYUU;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("0")), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0")), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0")), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }

    @Test
    @TestOrder(560)
    public void testExec_E07() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN4;
        CalcHkKngkHijynbrSysnMockForSiharai.SYORIPTN = CalcHkKngkHijynbrSysnMockForSiharai.TESTPATTERN1;
        GetSibouymdWMockForSiharai.SYORIPTN = GetSibouymdWMockForSiharai.TESTPATTERN2;
        String syoukenNo = "20000000005";
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000008000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("0")), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("0")), "保険料累計");
    }


    @Test
    @TestOrder(600)
    public void testExec_F01() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN3;
        CalcHkKngkHijynbrKojinNkMockForSiharai.SYORIPTN = CalcHkKngkHijynbrKojinNkMockForSiharai.TESTPATTERN1;
        GetSibouymdWMockForSiharai.SYORIPTN = GetSibouymdWMockForSiharai.TESTPATTERN1;
        String syoukenNo = "20000000005";
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000006000006"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000004000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000008000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("7700007000077"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("9900009000099"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("5500005000055"),
            BizCurrencyTypes.AU_DOLLAR), "保険料累計");

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = (CalcHkShrKngkInputBean) MockObjectManager.getArgument(GetSibouymdWMockForSiharai.class, "exec", 2, 0);
        exStringEquals(calcHkShrKngkInputBean.getSyouhncd(), "ﾕﾅ", "商品コード");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(calcHkShrKngkInputBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(calcHkShrKngkInputBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(calcHkShrKngkInputBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(calcHkShrKngkInputBean.getHrkkkn(), 2, "払込期間");
        exNumericEquals(calcHkShrKngkInputBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(calcHkShrKngkInputBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exDateEquals(calcHkShrKngkInputBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exDateEquals(calcHkShrKngkInputBean.getCalckijyunymd(), BizDate.valueOf(20200204), "計算基準日");
        exStringEquals(calcHkShrKngkInputBean.getSyono(), "20000000005", "証券番号");
        exClassificationEquals(calcHkShrKngkInputBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exNumericEquals(calcHkShrKngkInputBean.getDai1hknkkn(), 0, "第１保険期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSiinkbn(), C_SiinKbn.BLNK, "死因区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.BLNK, "保険金種類区分");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR), "保険料");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exDateYMEquals(calcHkShrKngkInputBean.getTmttkntaisyouym(),null, "積立金対象年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkknsmnKbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exDateYMEquals(calcHkShrKngkInputBean.getJkipjytYm(), BizDateYM.valueOf(202002), "次回Ｐ充当年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getPtmttKngk(), BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR), "保険料積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihrkmPStgk(), BizCurrency.valueOf(Long.valueOf("9000009000009"), BizCurrencyTypes.AU_DOLLAR), "既払込保険料相当額");
        exDateEquals(calcHkShrKngkInputBean.getFstPryosyuYmd(), null, "初回保険料領収日");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteirrthendohosyuRiritu(), BizNumber.valueOf(0.1234), "予定利率変動時保証利率");
        exClassificationEquals(calcHkShrKngkInputBean.getKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(calcHkShrKngkInputBean.getYendthnkYmd(), BizDate.valueOf(20170203), "円建変更日");
        exClassificationEquals(calcHkShrKngkInputBean.getSdpdkbn(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");


    }

    @Test
    @TestOrder(610)
    public void testExec_F02() {
        CalcHkShrKngkItijibrSysnMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrSysnMockForSiharai.TESTPATTERN1;
        String syohinCd = "ﾕﾉ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR);
        BizDate kykymd = BizDate.valueOf(20190201);
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        String syoukenNo = "20000000001";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.USD;
        Integer dai1HknKkn = 2;
        C_SiinKbn siinKbn = C_SiinKbn.SP;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.SBHOKENKIN;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.4321);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.2345);
        BizDateYM tmttkntaisyouYm = null;
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN);
        BizNumber tumitateRiritu = BizNumber.valueOf(0);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("5000004000005"),
            BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("9000001000009"),
            BizCurrencyTypes.DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("0")),
            "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("6000002000006"),
            BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.DOLLAR), "保険料累計");

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = (CalcHkShrKngkInputBean) MockObjectManager.getArgument(CalcHkShrKngkItijibrSysnMockForSiharai.class, "exec", 3, 0);
        exStringEquals(calcHkShrKngkInputBean.getSyouhncd(), "ﾕﾉ", "商品コード");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(calcHkShrKngkInputBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(calcHkShrKngkInputBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(calcHkShrKngkInputBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(calcHkShrKngkInputBean.getHrkkkn(), 78, "払込期間");
        exNumericEquals(calcHkShrKngkInputBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(calcHkShrKngkInputBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihons(), BizCurrency.valueOf(Long.valueOf("9000001000009"), BizCurrencyTypes.DOLLAR), "基本Ｓ");
        exDateEquals(calcHkShrKngkInputBean.getKykymd(), BizDate.valueOf(20190201), "契約日");
        exDateEquals(calcHkShrKngkInputBean.getCalckijyunymd(), BizDate.valueOf(20200203), "計算基準日");
        exStringEquals(calcHkShrKngkInputBean.getSyono(), "20000000001", "証券番号");
        exClassificationEquals(calcHkShrKngkInputBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exNumericEquals(calcHkShrKngkInputBean.getDai1hknkkn(), 2, "第１保険期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSiinkbn(), C_SiinKbn.SP, "死因区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("5000004000005"), BizCurrencyTypes.DOLLAR), "保険料");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0.4321), "解約時市場価格調整用利率");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(1.2345), "契約時市場価格調整用利率");
        exDateYMEquals(calcHkShrKngkInputBean.getTmttkntaisyouym(), null, "積立金対象年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.YEN), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkknsmnKbn(), C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exDateYMEquals(calcHkShrKngkInputBean.getJkipjytYm(), null, "次回Ｐ充当年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getPtmttKngk(), null, "保険料積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihrkmPStgk(), null, "既払込保険料相当額");
        exDateEquals(calcHkShrKngkInputBean.getFstPryosyuYmd(), null, "初回保険料領収日");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteirrthendohosyuRiritu(), BizNumber.valueOf(0), "予定利率変動時保証利率");
        exClassificationEquals(calcHkShrKngkInputBean.getKykJyoutai(), C_Kykjyoutai.ITIJIBARAI, "契約状態");
        exDateEquals(calcHkShrKngkInputBean.getYendthnkYmd(), null, "円建変更日");
        exClassificationEquals(calcHkShrKngkInputBean.getSdpdkbn(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnZokusei().getMvatekikkn(), 15, "商品属性マスタ．ＭＶＡ適用期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSyouhnZokusei().getHknkknbunruikbn(), C_HknkknBunruiKbn.SECOND, "保険期間分類区分");

    }

    @Test
    @TestOrder(620)
    public void testExec_F03() {
        CalcHkShrKngkItijibrKojinNkMockForSiharai.SYORIPTN = CalcHkShrKngkItijibrKojinNkMockForSiharai.TESTPATTERN1;
        String syohinCd = "ﾕﾍ";
        Integer syouhnsdno = 1;
        String ryouritusdNo = "789";
        BizNumber yoteiRiritu = BizNumber.valueOf(0.1234);
        C_Hrkkaisuu haraikomikaisuu = C_Hrkkaisuu.ITIJI;
        C_HknkknsmnKbn hknkknsmnKbn = C_HknkknsmnKbn.SAIMANKI;
        Integer hknKkn = 56;
        Integer hrkKkn = 78;
        Integer hhknnen = 90;
        C_Hhknsei hhknsei = C_Hhknsei.MALE;
        BizCurrency kihons = BizCurrency.valueOf(Long.valueOf("2000001000002"), BizCurrencyTypes.AU_DOLLAR);
        BizDate kykymd = BizDate.valueOf(20200801);
        BizDate calckijyunymd = BizDate.valueOf(20200903);
        String syoukenNo = "20000000003";
        C_Tuukasyu tuukaSyu = C_Tuukasyu.AUD;
        Integer dai1HknKkn = 0;
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        BizCurrency hokenryou = BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber kaiyakuSjkTsRitu = BizNumber.valueOf(0.1234);
        BizNumber kyksjkkktsrrt = BizNumber.valueOf(1.5432);
        BizDateYM tmttkntaisyouYm = BizDateYM.valueOf(202012);
        BizCurrency teiritutmttKngk = BizCurrency.valueOf(Long.valueOf("1000000"), BizCurrencyTypes.AU_DOLLAR);
        BizCurrency sisuurendoutmttKngk = BizCurrency.valueOf(Long.valueOf("1200000"), BizCurrencyTypes.AU_DOLLAR);
        BizNumber tumitateRiritu = BizNumber.valueOf(1.2345);
        C_HrkkknsmnKbn hrkkknsmnKbn = C_HrkkknsmnKbn.BLNK;
        BizDateYM jkipjytYm = null;
        BizCurrency ptmttKngk = null;
        BizCurrency kihrkmPStgk = null;
        BizDate fstPryosyuYmd = null;
        BizNumber yoteirrthendohosyuRiritu = BizNumber.valueOf(0);
        C_Kykjyoutai kykJyoutai = C_Kykjyoutai.ITIJIBARAI;
        BizDate yendthnkymd = null;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.exec(syohinCd, syouhnsdno, ryouritusdNo, yoteiRiritu, haraikomikaisuu,
            hknkknsmnKbn, hknKkn, hrkKkn, hhknnen, hhknsei, kihons, kykymd, calckijyunymd, syoukenNo, tuukaSyu,
            dai1HknKkn, siinKbn, hokenkinsyuruikbn, hokenryou, kaiyakuSjkTsRitu, kyksjkkktsrrt,
            tmttkntaisyouYm, teiritutmttKngk, sisuurendoutmttKngk, tumitateRiritu, hrkkknsmnKbn, jkipjytYm, ptmttKngk,
            kihrkmPStgk, fstPryosyuYmd, yoteirrthendohosyuRiritu, kykJyoutai, yendthnkymd, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("2000001000002"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000004000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getTeirituTmttkngk(), BizCurrency.valueOf(Long.valueOf("3000000"),
            BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSisuurendouTmttkngk(), BizCurrency.valueOf(Long.valueOf("3400000"),
            BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("8000002000008"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("4000003000004"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(),
            BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "保険料累計");

    }

    @Test
    @TestOrder(630)
    public void testExec_F04() {
        KeisanWExtMockForSiharai.SYORIPTN = KeisanWExtMockForSiharai.TESTPATTERN4;
        CalcHkKngkHijynbrSysnMockForSiharai.SYORIPTN = CalcHkKngkHijynbrSysnMockForSiharai.TESTPATTERN1;
        GetSibouymdWMockForSiharai.SYORIPTN = GetSibouymdWMockForSiharai.TESTPATTERN1;
        String syoukenNo = "20000000005";
        BizDate calckijyunymd = BizDate.valueOf(20200203);
        C_SiinKbn siinKbn = C_SiinKbn.BLNK;
        C_HokenkinsyuruiKbn hokenkinsyuruikbn = C_HokenkinsyuruiKbn.BLNK;
        C_Sdpd sdpdkbn = C_Sdpd.PD;
        C_Hrkkeiro hrkkeiro = C_Hrkkeiro.BLNK;

        C_ErrorKbn errorKbn = calcHkShrKngk.execByKeisanWExt(syoukenNo, calckijyunymd,
            siinKbn, hokenkinsyuruikbn, sdpdkbn, hrkkeiro);
        CalcHkShrKngkBean calcHkShrKngkBean = calcHkShrKngk.getCalcHkShrKngkBean();

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"),
            BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exBizCalcbleEquals(calcHkShrKngkBean.getKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("7700007000077"),
            BizCurrencyTypes.AU_DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getTmttKnGk(), BizCurrency.valueOf(Long.valueOf("9900009000099"),
            BizCurrencyTypes.AU_DOLLAR), "積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenryoustGk(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料相当額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSibousGk(), BizCurrency.valueOf(Long.valueOf("7000007000007"),
            BizCurrencyTypes.AU_DOLLAR), "死亡保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSaigaisGk(), BizCurrency.valueOf(Long.valueOf("0"),
            BizCurrencyTypes.AU_DOLLAR), "災害保険金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getHokenknGk(), BizCurrency.valueOf(Long.valueOf("8000008000008"),
            BizCurrencyTypes.AU_DOLLAR), "保険金額");
        exClassificationEquals(calcHkShrKngkBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(Long.valueOf("7700007000077"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getSbymdTmttKnGk(), BizCurrency.valueOf(Long.valueOf("9900009000099"),
            BizCurrencyTypes.AU_DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(calcHkShrKngkBean.getPruikei(), BizCurrency.valueOf(Long.valueOf("9000009000009"),
            BizCurrencyTypes.AU_DOLLAR), "保険料累計");

        CalcHkShrKngkInputBean calcHkShrKngkInputBean = (CalcHkShrKngkInputBean) MockObjectManager.getArgument(GetSibouymdWMockForSiharai.class, "exec", 3, 0);
        exStringEquals(calcHkShrKngkInputBean.getSyouhncd(), "ﾆｱ", "商品コード");
        exNumericEquals(calcHkShrKngkInputBean.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(calcHkShrKngkInputBean.getRyouritusdno(), "789", "料率世代番号");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteiriritu(), BizNumber.valueOf(0.1234), "予定利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkaisuu(), C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals(calcHkShrKngkInputBean.getHknkknsmnkbn(), C_HknkknsmnKbn.NENMANKI, "保険期間歳満期区分");
        exNumericEquals(calcHkShrKngkInputBean.getHknkkn(), 56, "保険期間");
        exNumericEquals(calcHkShrKngkInputBean.getHrkkkn(), 2, "払込期間");
        exNumericEquals(calcHkShrKngkInputBean.getHhknnen(), 90, "被保険者年齢");
        exClassificationEquals(calcHkShrKngkInputBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihons(), BizCurrency.valueOf(Long.valueOf("3000003000003"), BizCurrencyTypes.AU_DOLLAR), "基本Ｓ");
        exDateEquals(calcHkShrKngkInputBean.getKykymd(), BizDate.valueOf(20160203), "契約日");
        exDateEquals(calcHkShrKngkInputBean.getCalckijyunymd(), BizDate.valueOf(20200204), "計算基準日");
        exStringEquals(calcHkShrKngkInputBean.getSyono(), "20000000005", "証券番号");
        exClassificationEquals(calcHkShrKngkInputBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exNumericEquals(calcHkShrKngkInputBean.getDai1hknkkn(), 1, "第１保険期間");
        exClassificationEquals(calcHkShrKngkInputBean.getSiinkbn(), C_SiinKbn.BLNK, "死因区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.BLNK, "保険金種類区分");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getHokenryou(), BizCurrency.valueOf(Long.valueOf("9000004000009"), BizCurrencyTypes.AU_DOLLAR), "保険料");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKaiyakusjkkktyouseiriritu(), BizNumber.valueOf(0), "解約時市場価格調整用利率");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(0), "契約時市場価格調整用利率");
        exDateYMEquals(calcHkShrKngkInputBean.getTmttkntaisyouym(),null, "積立金対象年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTeiritutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "定率積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getSisuurendoutmttkngk(), BizCurrency.valueOf(Long.valueOf("0"), BizCurrencyTypes.AU_DOLLAR), "指数連動積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getTumitateriritu(), BizNumber.valueOf(0), "積立利率");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkknsmnKbn(), C_HrkkknsmnKbn.NENMANKI, "払込期間歳満期区分");
        exDateYMEquals(calcHkShrKngkInputBean.getJkipjytYm(), BizDateYM.valueOf(202002), "次回Ｐ充当年月");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getPtmttKngk(), BizCurrency.valueOf(Long.valueOf("4000004000004"), BizCurrencyTypes.AU_DOLLAR), "保険料積立金額");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getKihrkmPStgk(), BizCurrency.valueOf(Long.valueOf("9000009000009"), BizCurrencyTypes.AU_DOLLAR), "既払込保険料相当額");
        exDateEquals(calcHkShrKngkInputBean.getFstPryosyuYmd(), null, "初回保険料領収日");
        exBizCalcbleEquals(calcHkShrKngkInputBean.getYoteirrthendohosyuRiritu(), BizNumber.valueOf(0.1234), "予定利率変動時保証利率");
        exClassificationEquals(calcHkShrKngkInputBean.getKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exDateEquals(calcHkShrKngkInputBean.getYendthnkYmd(), BizDate.valueOf(20170203), "円建変更日");
        exClassificationEquals(calcHkShrKngkInputBean.getSdpdkbn(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals(calcHkShrKngkInputBean.getHrkkeiro(), C_Hrkkeiro.BLNK, "払込経路");

    }

}
