package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
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
 * 通算用契約情報パラメータクラスのメソッド {@link TuusanKeiyakuInfoParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class TuusanKeiyakuInfoParamTest_Properties {

    private C_SkeikikeiyakuKbn skeiKikeiyakuKbn = C_SkeikikeiyakuKbn.KIKEIYAKU;
    private C_SntkhouKbn sntkhouKbn = C_SntkhouKbn.HJY;
    private BizDate kijyunYmd = BizDate.valueOf(20160418);
    private BizDate kykYmd = BizDate.valueOf(20160419);
    private int hhknNen = 25;
    private C_Hrkkaisuu hrkKaisuu = C_Hrkkaisuu.HALFY;
    private BizCurrency kihonS = BizCurrency.valueOf(100);
    private BizCurrency itijibrp = BizCurrency.valueOf(200);
    private BizCurrency jituHsgk = BizCurrency.valueOf(300);
    private BizCurrency nkGnsgk = BizCurrency.valueOf(400);
    private BizCurrency tkhKihonS = BizCurrency.valueOf(500);
    private C_UmuKbn syuusinhknUmu = C_UmuKbn.ARI;
    private C_UmuKbn stsnUmu = C_UmuKbn.ARI;
    private C_UmuKbn nkgnsTuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn nenbtSouSbusTuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn souKktJituHsgkTuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn msnyNenbtSbusTuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn kktJituHsgk1TuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn kktJituHsgk2TuusanUmu = C_UmuKbn.ARI;
    private C_UmuKbn kykDrtenTuusanUmuKbn = C_UmuKbn.ARI;
    private C_UmuKbn itijibrpTsnUmu = C_UmuKbn.ARI;
    private C_TkthknsyruitsnKbn tktHknsyruiTsnKbn = C_TkthknsyruitsnKbn.SNTKTUUKHIJYNSYSNHKN;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testProperties_A1(){

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);

        tuusanKeiyakuInfoParam.setSkeiKikeiyakuKbn(skeiKikeiyakuKbn);
        tuusanKeiyakuInfoParam.setSntkhouKbn(sntkhouKbn);
        tuusanKeiyakuInfoParam.setKijyunYmd(kijyunYmd);
        tuusanKeiyakuInfoParam.setKykYmd(kykYmd);
        tuusanKeiyakuInfoParam.setHhknNen(hhknNen);
        tuusanKeiyakuInfoParam.setHrkKaisuu(hrkKaisuu);
        tuusanKeiyakuInfoParam.setKihonS(kihonS);
        tuusanKeiyakuInfoParam.setItijibrp(itijibrp);
        tuusanKeiyakuInfoParam.setJituHsgk(jituHsgk);
        tuusanKeiyakuInfoParam.setNkgnsgk(nkGnsgk);
        tuusanKeiyakuInfoParam.setTkhKihonS(tkhKihonS);
        tuusanKeiyakuInfoParam.setSyuusinhknUmu(syuusinhknUmu);
        tuusanKeiyakuInfoParam.setStsnUmu(stsnUmu);
        tuusanKeiyakuInfoParam.setNkgnsTuusanUmu(nkgnsTuusanUmu);
        tuusanKeiyakuInfoParam.setNenbtSouSbusTuusanUmu(nenbtSouSbusTuusanUmu);
        tuusanKeiyakuInfoParam.setSouKktJituHsgkTuusanUmu(souKktJituHsgkTuusanUmu);
        tuusanKeiyakuInfoParam.setMsnyNenbtSbusTuusanUmu(msnyNenbtSbusTuusanUmu);
        tuusanKeiyakuInfoParam.setKktJituHsgk1TuusanUmu(kktJituHsgk1TuusanUmu);
        tuusanKeiyakuInfoParam.setKktJituHsgk2TuusanUmu(kktJituHsgk2TuusanUmu);
        tuusanKeiyakuInfoParam.setKykDrtenTuusanUmuKbn(kykDrtenTuusanUmuKbn);
        tuusanKeiyakuInfoParam.setItijibrpTsnUmu(itijibrpTsnUmu);
        tuusanKeiyakuInfoParam.setTktHknsyruiTsnKbn(tktHknsyruiTsnKbn);

        exClassificationEquals(tuusanKeiyakuInfoParam.getSkeiKikeiyakuKbn() ,skeiKikeiyakuKbn , "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSntkhouKbn() ,sntkhouKbn , "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam.getKijyunYmd() ,kijyunYmd , "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam.getKykYmd(), kykYmd, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam.getHhknNen(), hhknNen, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam.getHrkKaisuu(), hrkKaisuu, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getKihonS(), kihonS, "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getItijibrp(), itijibrp, "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getJituHsgk(), jituHsgk, "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getNkgnsgk(), nkGnsgk, "年金原資額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam.getTkhKihonS(), tkhKihonS, "通計保留用基本S");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSyuusinhknUmu(), syuusinhknUmu, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getStsnUmu(), stsnUmu, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNkgnsTuusanUmu(), nkgnsTuusanUmu, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getNenbtSouSbusTuusanUmu(), nenbtSouSbusTuusanUmu, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getSouKktJituHsgkTuusanUmu(), souKktJituHsgkTuusanUmu, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getMsnyNenbtSbusTuusanUmu(), msnyNenbtSbusTuusanUmu, "未成年用年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk1TuusanUmu(), kktJituHsgk1TuusanUmu, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKktJituHsgk2TuusanUmu(), kktJituHsgk2TuusanUmu, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getKykDrtenTuusanUmuKbn() ,kykDrtenTuusanUmuKbn , "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getItijibrpTsnUmu() ,itijibrpTsnUmu , "一時払Ｐ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam.getTktHknsyruiTsnKbn() ,tktHknsyruiTsnKbn , "特定保険種類通算区分");

    }

    @Test
    @TestOrder(20)
    public void testProperties_A2(){

        TuusanKeiyakuInfoParam tuusanKeiyakuInfoParam1 = SWAKInjector.getInstance(TuusanKeiyakuInfoParam.class);

        exClassificationEquals(tuusanKeiyakuInfoParam1.getSkeiKikeiyakuKbn() ,null , "新契約既契約区分");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSntkhouKbn() ,null , "選択方法区分");
        exDateEquals(tuusanKeiyakuInfoParam1.getKijyunYmd() ,null , "基準年月日");
        exDateEquals(tuusanKeiyakuInfoParam1.getKykYmd(), null, "契約日");
        exNumericEquals(tuusanKeiyakuInfoParam1.getHhknNen(), 0, "被保険者年齢");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getHrkKaisuu(), null, "払込回数");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getKihonS(), null, "基本Ｓ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getItijibrp(), null, "一時払Ｐ");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getJituHsgk(), null, "実保障額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getNkgnsgk(), null, "年金原資額");
        exBizCalcbleEquals(tuusanKeiyakuInfoParam1.getTkhKihonS(), null, "通計保留用基本S");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSyuusinhknUmu(), null, "終身保険有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getStsnUmu(), null, "Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getNkgnsTuusanUmu(), null, "年金原資通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getNenbtSouSbusTuusanUmu(), null, "年齢別総死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getSouKktJituHsgkTuusanUmu(), null, "総告知書実質保障額通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getMsnyNenbtSbusTuusanUmu(), null, "未成年用年齢別死亡Ｓ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKktJituHsgk1TuusanUmu(), null, "告知書実保障額１通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKktJituHsgk2TuusanUmu(), null, "告知書実保障額２通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getKykDrtenTuusanUmuKbn() ,null , "契約者同一代理店通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getItijibrpTsnUmu() ,null , "一時払Ｐ通算有無");
        exClassificationEquals(tuusanKeiyakuInfoParam1.getTktHknsyruiTsnKbn() ,null , "特定保険種類通算区分");

    }
}
