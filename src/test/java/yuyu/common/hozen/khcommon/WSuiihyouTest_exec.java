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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約返戻金推移表作成クラスのメソッド {@link WSuiihyou#exec(String, int, String, BizNumber, C_Hrkkaisuu,
 * C_HknkknsmnKbn, int, int, int, C_Hhknsei, BizCurrency, BizDate, BizDate, String, C_Tuukasyu, BizDateYM)}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WSuiihyouTest_exec {

    @Inject
    private WSuiihyou WSuiihyou;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約返戻金推移表作成";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWMockForHozen.caller = WSuiihyouTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(WSuiihyouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager. getAllKawaseRate());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(105);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 0, "実行結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161103));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201711"), "計算年日");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.045), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.055), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.035), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVAARINONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou.getMvaariwup(), BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(Suiihyou.getMvaariwsame(), BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(Suiihyou.getMvaariwdown(), BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyendaka(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyenkijyun(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyenyasu(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyendaka(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyenkijyun(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyenyasu(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyendaka(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyenkijyun(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyenyasu(),
            BizCurrency.valueOf(70), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(55), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(Suiihyou.getMvanonewsame(), BizCurrency.valueOf(70), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(70), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(70), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(70), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(55), "ＭＶＡ適用外保険料積立金");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(56);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(0);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou1 = wSuiihyouLst.get(0);

        exNumericEquals(Suiihyou1.getKeikanensuu(), 1, "経過年数");
        exDateEquals(Suiihyou1.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou1.getCalcym(), BizDateYM.valueOf("201711"), "計算年日");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou1.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou1.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou1.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou2 = wSuiihyouLst.get(1);

        exNumericEquals(Suiihyou2.getKeikanensuu(), 2, "経過年数");
        exDateEquals(Suiihyou2.getCalckijyunymd(), BizDate.valueOf("20181031"), "計算基準日");
        exDateYMEquals(Suiihyou2.getCalcym(), BizDateYM.valueOf("201811"), "計算年日");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou2.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou2.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou2.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou2.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou3 = wSuiihyouLst.get(2);

        exNumericEquals(Suiihyou3.getKeikanensuu(), 3, "経過年数");
        exDateEquals(Suiihyou3.getCalckijyunymd(), BizDate.valueOf("20191031"), "計算基準日");
        exDateYMEquals(Suiihyou3.getCalcym(), BizDateYM.valueOf("201911"), "計算年日");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou3.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou3.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou3.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou3.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou4 = wSuiihyouLst.get(48);

        exNumericEquals(Suiihyou4.getKeikanensuu(), 49, "経過年数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(56);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20061101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161103));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(9);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou1 = wSuiihyouLst.get(0);

        exNumericEquals(Suiihyou1.getKeikanensuu(), 11, "経過年数");
        exDateEquals(Suiihyou1.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou1.getCalcym(), BizDateYM.valueOf("201711"), "計算年日");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou1.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou1.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou1.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou2 = wSuiihyouLst.get(1);

        exNumericEquals(Suiihyou2.getKeikanensuu(), 12, "経過年数");
        exDateEquals(Suiihyou2.getCalckijyunymd(), BizDate.valueOf("20181031"), "計算基準日");
        exDateYMEquals(Suiihyou2.getCalcym(), BizDateYM.valueOf("201811"), "計算年日");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou2.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou2.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou2.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou2.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou3 = wSuiihyouLst.get(2);

        exNumericEquals(Suiihyou3.getKeikanensuu(), 13, "経過年数");
        exDateEquals(Suiihyou3.getCalckijyunymd(), BizDate.valueOf("20191031"), "計算基準日");
        exDateYMEquals(Suiihyou3.getCalcym(), BizDateYM.valueOf("201911"), "計算年日");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(100.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(110.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(120.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou3.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou3.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou3.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou3.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou39 = wSuiihyouLst.get(38);

        exNumericEquals(Suiihyou39.getKeikanensuu(), 49, "経過年数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(56);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20071101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(0);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou1 = wSuiihyouLst.get(0);

        exNumericEquals(Suiihyou1.getKeikanensuu(), 10, "経過年数");
        exDateEquals(Suiihyou1.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou1.getCalcym(), BizDateYM.valueOf("201711"), "計算年日");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(200.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(210.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(220.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou1.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou1.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou1.getSuiihyousyubetu(), "01", "推移表種別");
        exBizCalcbleEquals(Suiihyou1.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou1.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou2 = wSuiihyouLst.get(1);

        exNumericEquals(Suiihyou2.getKeikanensuu(), 11, "経過年数");
        exDateEquals(Suiihyou2.getCalckijyunymd(), BizDate.valueOf("20181031"), "計算基準日");
        exDateYMEquals(Suiihyou2.getCalcym(), BizDateYM.valueOf("201811"), "計算年日");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(200.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(210.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(220.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou2.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou2.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou2.getSuiihyousyubetu(), "01", "推移表種別");
        exBizCalcbleEquals(Suiihyou2.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou2.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou2.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou3 = wSuiihyouLst.get(2);

        exNumericEquals(Suiihyou3.getKeikanensuu(), 12, "経過年数");
        exDateEquals(Suiihyou3.getCalckijyunymd(), BizDate.valueOf("20191031"), "計算基準日");
        exDateYMEquals(Suiihyou3.getCalcym(), BizDateYM.valueOf("201911"), "計算年日");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(200.25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(210.25), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(220.25), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou3.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou3.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou3.getSuiihyousyubetu(), "01", "推移表種別");
        exBizCalcbleEquals(Suiihyou3.getMvanonewsame(), BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyendaka(),
            BizCurrency.valueOf(100), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenkijyun(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(Suiihyou3.getMvanonewyensameyenyasu(),
            BizCurrency.valueOf(100), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(Suiihyou3.getMvanoneptumitatekin(), BizCurrency.valueOf(68), "ＭＶＡ適用外保険料積立金");

        IT_Suiihyou Suiihyou40 = wSuiihyouLst.get(39);

        exNumericEquals(Suiihyou40.getKeikanensuu(), 49, "経過年数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(98);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20071101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(12);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.HUYOU);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201711"), "計算年日");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.045), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.055), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.035), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(Suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyendaka(),
            BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyenkijyun(),
            BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrateyenyasu(),
            BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrategkyendaka(),
            BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(Suiihyou.getYenknsnkwsrategkyenyasu(),
            BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(),
            C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
        exStringEquals(Suiihyou.getSuiihyousyubetu(), "04", "推移表種別");
        exBizCalcbleEquals(Suiihyou.getMvaariwup(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(Suiihyou.getMvaariwsame(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(Suiihyou.getMvaariwdown(), BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyendaka(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyenkijyun(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyenupyenyasu(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyendaka(),
            BizCurrency.valueOf(55), "ＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyenkijyun(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyensameyenyasu(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyendaka(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyenkijyun(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(Suiihyou.getMvaariwyendownyenyasu(),
            BizCurrency.valueOf(55), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(Suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(55), "ＭＶＡ適用保険料積立金");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN4;

        try {
            WSuiihyou.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN5;

        WSuiihyou.setYenkansannYhKbn(C_YouhiKbn.YOU);

        try{
            WSuiihyou.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN6;

        try{
            WSuiihyou.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161031));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN7;

        try{
            WSuiihyou.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_B1() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20160229));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20150302));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20160228"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201601"), "計算年月");
    }

    @Test
    @TestOrder(120)
    public void testExec_B2() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20161101));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20161101));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20171031"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201711"), "計算年月");
    }

    @Test
    @TestOrder(130)
    public void testExec_B3() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20160229));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20160320));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20170228"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201702"), "計算年月");
    }

    @Test
    @TestOrder(140)
    public void testExec_B4() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        keisanWExtBean.setSyouhncd("M110");
        keisanWExtBean.setSyouhnsdno(0);
        keisanWExtBean.setRyouritusdno("1");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.5));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(11);
        keisanWExtBean.setHrkkkn(10);
        keisanWExtBean.setHhknnen(104);
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(70));
        keisanWExtBean.setKykymd(BizDate.valueOf(20160203));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20161104));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20160202));
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.045));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(1);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyou.exec(wSuiihyouParam);

        IT_Suiihyou Suiihyou = wSuiihyouLst.get(0);

        exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20160202"), "計算基準日");
        exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("201602"), "計算年月");
    }
}
