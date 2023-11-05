package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SkeikikeiyakuKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 通算処理クラスのメソッド {@link Tuusan#exec(List, TakeiyakuTuusanInfoParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TuusanTest_exec {

    @Inject
    private Tuusan tuusan;

    @Test
    @TestOrder(10)
    public void testExec_A1(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20160505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(50, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(250, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(14);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(51, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTkhKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam2 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam2.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam2.setKijyunYmd(BizDate.valueOf("20160505"));
        tuusanKeiyakuInfoParam2.setKykYmd(BizDate.valueOf("20160505"));

        tuusanKeiyakuInfoParam2.setStsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setKihonS(BizCurrency.valueOf(50, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam2.setSntkhouKbn(C_SntkhouKbn.SYOKUGYOU);
        tuusanKeiyakuInfoParam2.setSouKktJituHsgkTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setJituHsgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam2.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam2.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam2.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam2.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam2.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setHhknNen(14);

        tuusanKeiyakuInfoParam2.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam2.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam2.setItijibrp(BizCurrency.valueOf(51, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam2.setTkhKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam2);

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam3 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam3.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam3.setKijyunYmd(BizDate.valueOf("20160505"));
        tuusanKeiyakuInfoParam3.setKykYmd(BizDate.valueOf("20160506"));

        tuusanKeiyakuInfoParam3.setStsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setKihonS(BizCurrency.valueOf(50, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam3.setSntkhouKbn(C_SntkhouKbn.HJY);
        tuusanKeiyakuInfoParam3.setSouKktJituHsgkTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setJituHsgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam3.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam3.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam3.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam3.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam3.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setHhknNen(14);

        tuusanKeiyakuInfoParam3.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam3.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam3.setItijibrp(BizCurrency.valueOf(51, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam3.setTkhKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam3);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(19, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(71, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.ARI, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.ARI, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.ARI, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.ARI, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.ARI, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.ARI, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.ARI, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.ARI, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.ARI, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.ARI, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.ARI, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(60, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(61, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(66, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(267, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(168, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(119, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(71, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(71, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(null);
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(14);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTkhKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuSouSibouSUmu(), C_UmuKbn.ARI, "通算年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20150505"));
        tuusanKeiyakuInfoParam1.setKykYmd(null);

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(14);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTkhKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(-2, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(-2, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(-2, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.ARI, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20170505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(15);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(19, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.ARI, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.ARI, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.ARI, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.ARI, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(17, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(19, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.ARI, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");


    }

    @Test
    @TestOrder(50)
    public void testExec_A5(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20180505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(16);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.BLNK);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(19, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.ARI, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.ARI, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(17, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(19, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.NONE, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20200505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setHhknNen(16);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.ARI, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(17, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.NONE, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN, "特定保険種類通算区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.SKEI);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20200505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setHhknNen(16);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(17, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = null;

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= null;

        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = null;

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20170505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(578.9, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(28, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setHhknNen(16);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(50, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.ARI, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(45, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(100, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.NONE, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(50, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.BLNK, "特定保険種類通算区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20210505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(578.9, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.ITIJI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.NONE);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(16);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.NONE, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.NONE, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.NONE, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(10, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(12, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(16, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(17, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(-1, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12(){

        List<TuusanKeiyakuInfoParam> pTuusanKeiyakuInfoParamLst= new ArrayList<>();

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);
        tuusanKeiyakuInfoParam1.setSkeiKikeiyakuKbn(C_SkeikikeiyakuKbn.KIKEIYAKU);
        tuusanKeiyakuInfoParam1.setKijyunYmd(BizDate.valueOf("20170505"));
        tuusanKeiyakuInfoParam1.setKykYmd(BizDate.valueOf("20150504"));

        tuusanKeiyakuInfoParam1.setStsnUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKihonS(BizCurrency.valueOf(50, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setSntkhouKbn(C_SntkhouKbn.KKT);
        tuusanKeiyakuInfoParam1.setSouKktJituHsgkTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setJituHsgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setNkgnsgk(BizCurrency.valueOf(250, BizCurrencyTypes.YEN));

        tuusanKeiyakuInfoParam1.setKktJituHsgk1TuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setKktJituHsgk2TuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setHrkKaisuu(C_Hrkkaisuu.TUKI);
        tuusanKeiyakuInfoParam1.setNkgnsTuusanUmu(C_UmuKbn.ARI);

        tuusanKeiyakuInfoParam1.setMsnyNenbtSbusTuusanUmu(C_UmuKbn.ARI);
        tuusanKeiyakuInfoParam1.setSyuusinhknUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setHhknNen(15);

        tuusanKeiyakuInfoParam1.setNenbtSouSbusTuusanUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrpTsnUmu(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setKykDrtenTuusanUmuKbn(C_UmuKbn.NONE);
        tuusanKeiyakuInfoParam1.setItijibrp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        tuusanKeiyakuInfoParam1.setTktHknsyruiTsnKbn(C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN);

        pTuusanKeiyakuInfoParamLst.add(tuusanKeiyakuInfoParam1);
        TakeiyakuTuusanInfoParam pTakeiyakuTuusanInfoParam = SWAKInjector.getInstance(TakeiyakuTuusanInfoParam.class);
        pTakeiyakuTuusanInfoParam.setTsnSibouS(BizCurrency.valueOf(10, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaS(BizCurrency.valueOf(11, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaS(BizCurrency.valueOf(12, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSouKktJituHsgk(BizCurrency.valueOf(13, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk1(BizCurrency.valueOf(14, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktJituHsgk2(BizCurrency.valueOf(15, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKktItijibrSysnJs(BizCurrency.valueOf(16, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNkgns(BizCurrency.valueOf(17, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnMsnyNenbtSousbus(BizCurrency.valueOf(18, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNenbtItijibrSsbs(BizCurrency.valueOf(19, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnItijibrSysnp(BizCurrency.valueOf(20, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setKykDrtenTsns(BizCurrency.valueOf(21, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenMikeikaHtnknS(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnNinenKeikaDfp(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnKetSibouS(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        pTakeiyakuTuusanInfoParam.setTsnSntktuukaHijynSysns(BizCurrency.valueOf(200, BizCurrencyTypes.YEN));

        tuusan.exec(pTuusanKeiyakuInfoParamLst, pTakeiyakuTuusanInfoParam);

        exClassificationEquals(tuusan.getTuusanSouSibouSUmu(), C_UmuKbn.ARI, "通算総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenMikeikaSouSibouSUmu(), C_UmuKbn.NONE, "通算２年未経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusan2NenKeikaSouSibouSUmu(), C_UmuKbn.ARI, "通算２年経過総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanSouKokurtisyoJituHosyougakuUmu(), C_UmuKbn.NONE, "通算総告知書実保障額有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1Umu(), C_UmuKbn.NONE, "通算告知書実保障額１有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2Umu(), C_UmuKbn.NONE, "通算告知書実保障額２有無");
        exClassificationEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoSUmu(), C_UmuKbn.ARI, "通算告知書一時払終身等除Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenkinGensiUmu(), C_UmuKbn.ARI, "通算年金原資有無");
        exClassificationEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouSUmu(), C_UmuKbn.NONE, "通算未成年用年齢別総死亡Ｓ有無");
        exClassificationEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouSUmu(), C_UmuKbn.NONE, "通算年齢別一時払総死亡Ｓ有無");
        exClassificationEquals(tuusan.getItijibrpTsnUmu(), C_UmuKbn.NONE, "一時払Ｐ通算有無");
        exClassificationEquals(tuusan.getKeiyakusyaDouituDairitenTuusanSUmu(), C_UmuKbn.NONE, "契約者同一代理店通算Ｓ有無");
        exBizCalcbleEquals(tuusan.getTuusanSouSibouS(), BizCurrency.valueOf(60, BizCurrencyTypes.YEN), "通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenMikeikaSouSibouS(), BizCurrency.valueOf(11, BizCurrencyTypes.YEN), "通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusan2NenKeikaSouSibouS(), BizCurrency.valueOf(62, BizCurrencyTypes.YEN), "通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanSouKokurtisyoJituHosyougaku(), BizCurrency.valueOf(13, BizCurrencyTypes.YEN), "通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku1(), BizCurrency.valueOf(14, BizCurrencyTypes.YEN), "通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoJituHosyougaku2(), BizCurrency.valueOf(15, BizCurrencyTypes.YEN), "通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTuusanKokurtisyoItijibaraiSyuusintoujoS(), BizCurrency.valueOf(66, BizCurrencyTypes.YEN), "通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenkinGensi(), BizCurrency.valueOf(267, BizCurrencyTypes.YEN), "通算年金原資");
        exBizCalcbleEquals(tuusan.getTuusanMiseinenyouNenreibetuSouSibouS(), BizCurrency.valueOf(18, BizCurrencyTypes.YEN), "通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanNenreibetuItijibaraiSouSibouS(), BizCurrency.valueOf(19, BizCurrencyTypes.YEN), "通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnItijibrSysnP(), BizCurrency.valueOf(20, BizCurrencyTypes.YEN), "通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getKeiyakusyaDouituDairitenTuusanS(), BizCurrency.valueOf(21, BizCurrencyTypes.YEN), "契約者同一代理店通算Ｓ");
        exBizCalcbleEquals(tuusan.getTuusanKetteiSouSouSibouS(), BizCurrency.valueOf(150, BizCurrencyTypes.YEN), "通算決定総死亡Ｓ");
        exClassificationEquals(tuusan.getTuusanKetteiSouSibouSUmu(), C_UmuKbn.ARI, "通算決定総死亡Ｓ有無");
        exBizCalcbleEquals(tuusan.getTsnSntktuukaHijynSysnS(), BizCurrency.valueOf(250, BizCurrencyTypes.YEN), "通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTktHknsyruiTsnKbn(), C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN, "特定保険種類通算区分");


        MockObjectManager.initialize();

    }

}
