package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約返戻金推移表作成（年金３）クラスのメソッド {@link WSuiihyouNenkin3#exec(String, int, String, BizNumber,
 * C_Hrkkaisuu, C_HknkknsmnKbn, int, int, int, C_Hhknsei, BizCurrency, BizDate, BizDate, String, C_Tuukasyu, BizDateYM)}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WSuiihyouNenkin3Test_exec {

    @Inject
    private WSuiihyouNenkin3 WSuiihyouNenkin3;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約返戻金推移表作成（年金３）";

    private final static String sheetName = "INデータ";

    @Inject
    private static Logger logger;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWItijiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(KeisanTmHntiSisuuRendouTmttkn.class).to(KeisanTmHntiSisuuRendouTmttknMock.class);
                bind(KeisanSisuuRendouNkTmttkn.class).to(KeisanSisuuRendouNkTmttknMock.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWMockForHozen.caller = WSuiihyouNenkin3Test_exec.class;
        KeisanTmHntiSisuuRendouTmttknMock.caller = WSuiihyouNenkin3Test_exec.class;
        KeisanSisuuRendouNkTmttknMock.caller = WSuiihyouNenkin3Test_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanTmHntiSisuuRendouTmttknMock.caller = null;
        KeisanTmHntiSisuuRendouTmttknMock.SYORIPTN = null;
        KeisanSisuuRendouNkTmttknMock.caller = null;
        KeisanSisuuRendouNkTmttknMock.SYORIPTN = null;
    }

    private WSuiihyouParam makeWSuiihyouParam() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(keisanWExtBean.getTuukasyu());
        keisanWExtBean.setSyouhncd("ﾕﾍ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        keisanWExtBean.setHknkkn(10);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(50);
        keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(3000, currencyType));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(3000, currencyType));
        keisanWExtBean.setKykymd(BizDate.valueOf(20201001));
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.0336));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.0275));
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.013));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20201001));
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(202010));
        keisanWExtBean.setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(0), currencyType));
        keisanWExtBean.setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(0), currencyType));
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20201001));
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(10);
        wSuiihyouParam.setTargetTkykKijyungk(BizCurrency.valueOf(new BigDecimal(350000), BizCurrencyTypes.YEN));

        return wSuiihyouParam;
    }


    @Test
    @TestOrder(10)
    public void testExec_A01() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A02() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A03() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A04() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A05() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A06() {

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A07() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanSisuuRendouNkTmttknMock.SYORIPTN = KeisanSisuuRendouNkTmttknMock.TESTPATTERN2;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。指数連動年金積立金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A08() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanSisuuRendouNkTmttknMock.SYORIPTN = null;

        KeisanTmHntiSisuuRendouTmttknMock.SYORIPTN = KeisanTmHntiSisuuRendouTmttknMock.TESTPATTERN2;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);

        try {
            WSuiihyouNenkin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。積増判定時指数連動積立金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_B01() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanTmHntiSisuuRendouTmttknMock.SYORIPTN = null;
        KeisanSisuuRendouNkTmttknMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20291201));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
        wSuiihyouParam.getKeisanWExtBean().setTmttkntaisyouym(BizDateYM.valueOf(202910));
        wSuiihyouParam.getKeisanWExtBean().setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(3829.67), currencyType));
        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);
        SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(0);
        displayContents(Suiihyou);
        displayContents(suiihyouExtBean);

        exNumericEquals(wSuiihyouLst.size(), 1, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 1, "推移表拡張Bean件数");
        checkWSuiihyou_TKeika10(Suiihyou, currencyType, yenYouhiKbn);
    }

    @Test
    @TestOrder(120)
    public void testExec_B02() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
        wSuiihyouParam.getKeisanWExtBean().setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));
        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 11, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 11, "推移表拡張Bean件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(cnt);

            displayContents(Suiihyou);
            displayContents(suiihyouExtBean);

            exStringEquals(Suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_TKeika0(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    checkWSuiihyou_TKeika1(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 2:
                    checkWSuiihyou_TKeika2(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 8:
                    checkWSuiihyou_TKeika8(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 9:
                    checkWSuiihyou_TKeika9(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 10:
                    checkWSuiihyou_TKeika10(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }


    @Test
    @TestOrder(130)
    public void testExec_B03() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(0));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY);
        wSuiihyouParam.getKeisanWExtBean().setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));
        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;
        WSuiihyouNenkin3.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 10, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 10, "推移表拡張Bean件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(cnt);

            displayContents(Suiihyou);
            displayContents(suiihyouExtBean);

            exStringEquals(Suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_TKeika1(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    checkWSuiihyou_TKeika2(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 7:
                    checkWSuiihyou_TKeika8(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 8:
                    checkWSuiihyou_TKeika9(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 9:
                    checkWSuiihyou_TKeika10(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(210)
    public void testExec_C01() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20300301));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        wSuiihyouParam.setRendouRitu(BizNumber.valueOf(0.82));
        wSuiihyouParam.getKeisanWExtBean().setTmttkntaisyouym(BizDateYM.valueOf(202910));
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));
        List<BizNumber> tmmshanteiSisuuList2 = new ArrayList<BizNumber>();
        for (int i = 0; i < 1; i++) {
            tmmshanteiSisuuList2.add(BizNumber.valueOf(0.95));
        }
        wSuiihyouParam.setTmmshanteiSisuuList2(tmmshanteiSisuuList2);
        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 1, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 1, "推移表拡張Bean件数");
        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);
        SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(0);

        displayContents(Suiihyou);
        displayContents(suiihyouExtBean);

        exNumericEquals(wSuiihyouLst.size(), 1, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 1, "推移表拡張Bean件数");
        checkWSuiihyou_SKeika10_1(Suiihyou, currencyType, yenYouhiKbn);
        exNumericEquals(suiihyouExtBean.getSisuuUpCount1(), 1, "指数上昇回数");
        exNumericEquals(suiihyouExtBean.getSisuuDownCount1(), 0, "指数下落回数");
    }

    @Test
    @TestOrder(220)
    public void testExec_C02() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201001));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        wSuiihyouParam.setRendouRitu(BizNumber.valueOf(0.82));
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));
        List<BizNumber> tmmshanteiSisuuList3 = new ArrayList<BizNumber>();
        for (int i = 0; i < 10; i++) {
            tmmshanteiSisuuList3.add(BizNumber.valueOf(0.95));
        }
        wSuiihyouParam.setTmmshanteiSisuuList3(tmmshanteiSisuuList3);
        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;
        WSuiihyouNenkin3.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 11, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 11, "推移表拡張Bean件数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuUpCount1(), 8, "指数上昇回数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuDownCount1(), 2, "指数下落回数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(cnt);

            displayContents(Suiihyou);
            displayContents(suiihyouExtBean);

            exStringEquals(Suiihyou.getSuiihyousyubetu(), "05", "推移表種別");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_SKeika0_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika0_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    checkWSuiihyou_SKeika1_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika1_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 2:
                    checkWSuiihyou_SKeika2_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika2_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 8:
                    checkWSuiihyou_SKeika8_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika8_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 9:
                    checkWSuiihyou_SKeika9_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika9_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 10:
                    checkWSuiihyou_SKeika10_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    checkWSuiihyou_SKeika10_Only3(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(230)
    public void testExec_C03() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20220518));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        wSuiihyouParam.setRendouRitu(BizNumber.valueOf(0.82));
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;
        WSuiihyouNenkin3.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 11, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 11, "推移表拡張Bean件数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuUpCount1(), 8, "指数上昇回数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuDownCount1(), 2, "指数下落回数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(cnt);

            displayContents(Suiihyou);
            displayContents(suiihyouExtBean);

            exStringEquals(Suiihyou.getSuiihyousyubetu(), "11", "推移表種別");
            checkWSuiihyou3_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_SKeika0_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    checkWSuiihyou_SKeika1_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 2:
                    checkWSuiihyou_SKeika2_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 8:
                    checkWSuiihyou_SKeika8_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 9:
                    checkWSuiihyou_SKeika9_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 10:
                    checkWSuiihyou_SKeika10_Only12(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }


    @Test
    @TestOrder(240)
    public void testExec_C04() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20220518));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());
        wSuiihyouParam.setSisuurendourate(BizNumber.valueOf(100));
        wSuiihyouParam.setTmttknhaibunjyoutai(C_TmttknhaibunjyoutaiKbn.SISUU_ONLY);
        wSuiihyouParam.setRendouRitu(BizNumber.valueOf(0.82));
        wSuiihyouParam.setTmmshanteiSisuuList2(null);
        wSuiihyouParam.getKeisanWExtBean().setTmttknhaneisisuu(BizNumber.valueOf(100));
        wSuiihyouParam.getKeisanWExtBean().setTeiritutmttkngk(BizCurrency.valueOf(new BigDecimal(0), currencyType));
        wSuiihyouParam.getKeisanWExtBean().setSisuurendoutmttkngk(BizCurrency.valueOf(new BigDecimal(3000), currencyType));
        wSuiihyouParam.getKeisanWExtBean().setTmttkntaisyouym(BizDateYM.valueOf(202110));

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;
        WSuiihyouNenkin3.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouNenkin3.exec(wSuiihyouParam);
        List<SuiihyouExtBean> suiihyouExtBeanLst = WSuiihyouNenkin3.getSuiihyouExtBeanLst();

        exNumericEquals(wSuiihyouLst.size(), 9, "推移表レコード件数");
        exNumericEquals(suiihyouExtBeanLst.size(), 9, "推移表拡張Bean件数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuUpCount1(), 7, "指数上昇回数");
        exNumericEquals(suiihyouExtBeanLst.get(suiihyouExtBeanLst.size()-1).getSisuuDownCount1(), 2, "指数下落回数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            SuiihyouExtBean suiihyouExtBean = suiihyouExtBeanLst.get(cnt);

            displayContents(Suiihyou);
            displayContents(suiihyouExtBean);

            exStringEquals(Suiihyou.getSuiihyousyubetu(), "12", "推移表種別");
            checkWSuiihyou2_Default(Suiihyou);
            checkWSuiihyou3_Default(Suiihyou);
            switch (cnt) {
                case 0:
                    checkWSuiihyou_SKeika2_Only1(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_SKeika3_Only1(Suiihyou, currencyType);
                    break;
                case 3:
                    checkWSuiihyou_SKeika5_Only1(Suiihyou, currencyType);
                    break;
                case 6:
                    checkWSuiihyou_SKeika8_Only1(Suiihyou, currencyType);
                    break;
                case 8:
                    checkWSuiihyou_SKeika10_Only1(Suiihyou, currencyType);
                    break;
                default:
                    break;
            }
        }
    }

    private void checkWSuiihyouOther_Default(IT_Suiihyou suiihyou){
        exStringEquals(suiihyou.getKbnkey(), null, "区分キー");
        exStringEquals(suiihyou.getSyono(), null, "証券番号");
        exDateEquals(suiihyou.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(suiihyou.getKyktuukasyu(), C_Tuukasyu.BLNK , "契約通貨種類");

        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
    }

    private void checkWSuiihyou1_YenNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
    }

    private void checkWSuiihyou2_YenNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
    }

    private void checkWSuiihyou3_YenNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
    }

    private void checkWSuiihyou2_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        checkWSuiihyou2_SjkkktusirrtNone(suiihyou);
        checkWSuiihyou2_MVAAriDefault(suiihyou);
        checkWSuiihyou2_MVANoneDefault(suiihyou);
        checkWSuiihyou2_YenNone(suiihyou);
    }

    private void checkWSuiihyou3_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        checkWSuiihyou3_SjkkktusirrtNone(suiihyou);
        checkWSuiihyou3_MVAAriDefault(suiihyou);
        checkWSuiihyou3_MVANoneDefault(suiihyou);
        checkWSuiihyou3_YenNone(suiihyou);
    }

    private void checkWSuiihyou1_MVANoneDefault(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
    }

    private void checkWSuiihyou2_MVANoneDefault(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
    }

    private void checkWSuiihyou3_MVANoneDefault(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
    }

    private void checkWSuiihyou1_MVAAriDefault(IT_Suiihyou suiihyou){
        checkWSuiihyou1_SjkkktusirrtNone(suiihyou);
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
    }

    private void checkWSuiihyou2_MVAAriDefault(IT_Suiihyou suiihyou){
        checkWSuiihyou2_SjkkktusirrtNone(suiihyou);
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
    }

    private void checkWSuiihyou3_MVAAriDefault(IT_Suiihyou suiihyou){
        checkWSuiihyou3_SjkkktusirrtNone(suiihyou);
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
    }

    private void checkWSuiihyou1_SjkkktusirrtNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.ZERO, "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.ZERO, "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.ZERO, "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）");
    }

    private void checkWSuiihyou2_SjkkktusirrtNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.ZERO, "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.ZERO, "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.ZERO, "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）２");
    }

    private void checkWSuiihyou3_SjkkktusirrtNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
    }

    private void checkWSuiihyou1_Sjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.0436), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.0336), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.0236), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");
    }

    private void checkWSuiihyou2_Sjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.valueOf(0.0436), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.valueOf(0.0336), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.valueOf(0.0236), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）２");
    }

    private void checkWSuiihyou3_Sjkkktusirrt(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.valueOf(0.0436), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame3(), BizNumber.valueOf(0.0336), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.valueOf(0.0236), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）３");
    }

    private void checkWSuiihyou1_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(113.41), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(123.41), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(133.41), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
    }

    private void checkWSuiihyou2_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(113.41), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(123.41), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(133.41), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
    }

    private void checkWSuiihyou3_KawaseRate(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(113.41), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(123.41), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(133.41), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
    }

    private void checkWSuiihyou_TKeika0(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20201001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2698.64, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(2971.12, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3274.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2548.64, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2821.12, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3124.18, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(280000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVANoneDefault(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_TKeika1(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3082.5, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2802.36, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3055.78, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3334.92, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2667.36, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2920.78, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3199.92, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(3082.5, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(300000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(320000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVANoneDefault(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_TKeika2(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3167.27, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2910.07, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3142.86, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3396.8, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2790.07, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3022.86, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3276.8, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(3167.27, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVANoneDefault(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_TKeika8(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 8, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20281001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202810), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3727.17, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3649.08, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3719.96, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3792.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3619.08, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3689.96, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3762.93, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(3727.17, currencyType), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(440000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(480000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(490000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(460000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(500000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVANoneDefault(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_TKeika9(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 9, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20291001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202910), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3829.67, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3789.34, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3825.96, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3863.3, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3774.34, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3810.96, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3848.3, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(3829.67, currencyType), "（１）積立金内訳１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "（２）積立金内訳１");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(460000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(500000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(470000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(500000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(510000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVANoneDefault(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_TKeika10(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 10, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20301001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "03", "推移表種別");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(3934.99, currencyType), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(3934.99, currencyType), "ＭＶＡ適用外解約返戻金額");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(440000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(480000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(520000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
        }
        checkWSuiihyou1_MVAAriDefault(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika10_1(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 10, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20301001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "11", "推移表種別");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.041), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(350000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(380000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(410000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(340000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(370000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(400000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
        checkWSuiihyou1_MVAAriDefault(suiihyou);
        checkWSuiihyou2_MVAAriDefault(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }


    private void checkWSuiihyou_SKeika0_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20201001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2698.64, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(2971.12, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3274.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2548.64, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2821.12, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3124.18, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou2_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(2698.64, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(2971.12, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(3274.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(2548.64, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(2821.12, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(3124.18, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(280000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(280000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika1_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.041), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2839.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3095.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3378.74, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2704.18, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2960.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3243.74, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou2_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0.041), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(2839.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(3095.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(3378.74, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(2704.18, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(2960.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(3243.74, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(300000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(300000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
    }


    private void checkWSuiihyou_SKeika2_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(-0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2869.4, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3098.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3349.32, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2749.4, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2978.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3229.32, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou2_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(2869.4, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(3098.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(3349.32, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(2749.4, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(2978.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(3229.32, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
    }


    private void checkWSuiihyou_SKeika8_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 8, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20281001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202810), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410005339), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3817.95, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3737.96, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3810.57, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3885.31, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3707.96, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3780.57, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3855.31, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3817.95, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou2_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(3523.11, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(3449.3, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(3516.3, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(3585.27, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(3419.3, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(3486.3, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(3555.27, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(3523.11, currencyType), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(490000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(460000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(500000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(510000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(420000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(460000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(430000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(470000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
    }


    private void checkWSuiihyou_SKeika9_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 9, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20291001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202910), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410000678), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3974.49, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3932.63, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3970.64, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(4009.4, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3917.63, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3955.64, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3994.4, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3974.49, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou2_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0.0410001242), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(3667.56, currencyType), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(3628.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(3664.01, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(3699.77, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(3613.93, currencyType), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(3649.01, currencyType), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(3684.77, currencyType), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(3667.56, currencyType), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(440000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(480000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(520000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(440000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(480000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(520000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(490000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(530000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(440000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(480000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(480000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(450000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(490000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyouOther_Default(suiihyou);
    }


    private void checkWSuiihyou_SKeika10_Only12(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 10, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20301001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410003228), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(4137.45, currencyType), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(4137.45, currencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(-0.05), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(3667.56, currencyType), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(3667.56, currencyType), "ＭＶＡ適用外解約返戻金額２");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou1_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(460000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(510000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(550000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
            checkWSuiihyou2_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(410000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(450000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(480000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        }
        else{
            checkWSuiihyou1_YenNone(suiihyou);
            checkWSuiihyou2_YenNone(suiihyou);
        }
        checkWSuiihyou1_MVAAriDefault(suiihyou);
        checkWSuiihyou2_MVAAriDefault(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika0_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20201001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(2698.64, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(2971.12, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(3274.18, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(2548.64, currencyType), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(2821.12, currencyType), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(3124.18, currencyType), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(280000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
    }

    private void checkWSuiihyou_SKeika1_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20211001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202110), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(-0.05), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(2727.36, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(2974, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(3245.67, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(2592.36, currencyType), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(2839, currencyType), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(3110.67, currencyType), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(290000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(310000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(320000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
    }

    private void checkWSuiihyou_SKeika2_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(-0.05), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(2756.39, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(2976.88, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(3217.41, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(2636.39, currencyType), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(2856.88, currencyType), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(3097.41, currencyType), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(290000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(320000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(320000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(410000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
    }

    private void checkWSuiihyou_SKeika8_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 8, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20281001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202810), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(-0.05), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(2937.15, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(2994.2, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(3052.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(2907.15, currencyType), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(2964.2, currencyType), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(3022.93, currencyType), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(320000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(350000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(380000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
    }

    private void checkWSuiihyou_SKeika9_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 9, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20291001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202910), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(-0.05), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(2968.4, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(2997.1, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(3026.35, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(2953.4, currencyType), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(2982.1, currencyType), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(3011.35, currencyType), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(3000, currencyType), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(330000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(360000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(390000), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(340000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(370000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(400000), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
    }

    private void checkWSuiihyou_SKeika10_Only3(IT_Suiihyou suiihyou, CurrencyType currencyType, C_YouhiKbn yenYouhiKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 10, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20301001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        checkWSuiihyou3_SjkkktusirrtNone(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(-0.05), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(3000, currencyType), "ＭＶＡ適用外解約返戻金額３");
        if(C_YouhiKbn.YOU.eq(yenYouhiKbn)){
            checkWSuiihyou3_KawaseRate(suiihyou);
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(340000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(370000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(400000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        }
        else{
            checkWSuiihyou3_YenNone(suiihyou);
        }
        checkWSuiihyou3_MVAAriDefault(suiihyou);
    }

    private void checkWSuiihyou_SKeika2_Only1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20221001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202210), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.041), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2869.4, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3098.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3349.32, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2749.4, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2978.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3229.32, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou1_YenNone(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika3_Only1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 3, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20231001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202310), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(-0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3123, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(2899.94, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3101.93, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3320.16, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(2794.94, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(2996.93, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3215.16, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3123, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou1_YenNone(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika5_Only1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 5, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20251001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202510), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410001957), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3384.35, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3209.87, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3368.02, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3535.62, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3134.87, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3293.02, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3460.62, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3384.35, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou1_YenNone(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika8_Only1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 8, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20281001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202810), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        checkWSuiihyou1_Sjkkktusirrt(suiihyou);
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(-0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(3667.57, currencyType), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(3590.73, currencyType), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(3660.48, currencyType), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(3732.28, currencyType), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(3560.73, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(3630.48, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(3702.28, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(3667.57, currencyType), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou1_YenNone(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void checkWSuiihyou_SKeika10_Only1(IT_Suiihyou suiihyou, CurrencyType currencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 10, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20301001), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203010), "計算年日");
        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0.05), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0.0410000678), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(3974.49, currencyType), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(3974.49, currencyType), "ＭＶＡ適用外解約返戻金額");
        checkWSuiihyou1_YenNone(suiihyou);
        checkWSuiihyou1_MVAAriDefault(suiihyou);
        checkWSuiihyouOther_Default(suiihyou);
    }

    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算年月 = {}", pSuiihyou.getCalcym());
        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("▲ 解約返戻金計算の設定値");
    }

    private void displayContents(SuiihyouExtBean pSuiihyouExtBean) {
        logger.debug("▼ 推移表拡張Beanの設定値");
        logger.debug("│ ★解約控除率 = {}", pSuiihyouExtBean.getKaiyakuKjRitu());
        logger.debug("│ ★解約控除額 = {}", pSuiihyouExtBean.getKaiyakuKjgk());
        logger.debug("│ ★指数上昇回数１ = {}", pSuiihyouExtBean.getSisuuUpCount1());
        logger.debug("│ ★指数下落回数１ = {}", pSuiihyouExtBean.getSisuuDownCount1());
        logger.debug("▲ 推移表拡張Beanの設定値");
    }
}
