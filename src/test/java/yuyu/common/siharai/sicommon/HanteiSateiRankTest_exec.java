package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMockForSiharai;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.infr.kinoumode.KinouMode;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 査定ランク判定のメソッド{@link HanteiSateiRank#exec(HanteiSateiRankBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiSateiRankTest_exec extends AbstractTest{

    @Inject
    private HanteiSateiRank hanteiSateiRank;

    @Inject
    private KinouMode kinouMode;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = HanteiSateiRankTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        BzSakuinTsnSyoukaiMqMockForSiharai.caller = null;
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void test_A1() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono(null);
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.BLNK, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(20)
    public void test_A2() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000080");
        hanteiSateiRankBean.setSeikyuuSyubetu(null);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.BLNK, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(30)
    public void test_A3() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000080");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(null);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.BLNK, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(40)
    public void test_A4() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000080");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(null);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.BLNK, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(45)
    public void test_A5() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000080");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(null);
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.BLNK, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(50)
    public void test_B1() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN1;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000165");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        kinouMode.setKinouMode("satei2");
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "18810000165", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(51)
    public void test_B1a() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN1;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000165");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        kinouMode.setKinouMode("satei3");
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(60)
    public void test_B2() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN2;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000187");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "18810000187", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(61)
    public void test_B2a() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN2;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000187");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(61)
    public void test_B2b() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN6;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000187");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(62)
    public void test_B2c() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN6;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000187");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(70)
    public void test_B3() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN3;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("18810000198");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KYH);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "18810000198", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(80)
    public void test_B4() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000116");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KOUSG);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.ERROR);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000116", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(90)
    public void test_B5() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000127");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000127", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(100)
    public void test_B6() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000127");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.ERROR);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000127", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(110)
    public void test_B7() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000127");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000127", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(120)
    public void test_B8() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.KOUSG);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000138", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(130)
    public void test_B9() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN4;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000138", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(140)
    public void test_B10() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.TOKUNIN);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000138", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(150)
    public void test_B11() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000138", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(160)
    public void test_B12() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei2");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager
            .getArgument(BzSakuinTsnSyoukaiMqMockForSiharai.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI,
            "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.SYONO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "17806000138", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN,
            "索引通算対象者区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK,
            "索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), null, "索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK,
            "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), null, "通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), BizDate.valueOf(20170905), "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "契約者同一代理店通算Ｓ照会要否区分");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準年月日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU,
            "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.HUYOU, "ハンド決定要否照会要否区分");
    }

    @Test
    @TestOrder(170)
    public void test_B13() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("input");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(180)
    public void test_B14() {
        changeSystemDate(BizDate.valueOf(20170905));
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(190)
    public void test_B15() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.YOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.WARNING);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(200)
    public void test_B16() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(210)
    public void test_B17() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.ERROR);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(220)
    public void test_B18() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN5;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.TOKUNIN);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(230)
    public void test_B19() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN3;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(240)
    public void test_B20() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN2;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("tenken");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), true, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.HUYOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.NONE, "査定３次回送有無区分");
    }

    @Test
    @TestOrder(250)
    public void test_B21() {
        changeSystemDate(BizDate.valueOf(20170905));
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSiharai.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSiharai.TESTPATTERN2;
        HanteiSateiRankBean hanteiSateiRankBean = SWAKInjector.getInstance(HanteiSateiRankBean.class);
        hanteiSateiRankBean.setSyono("17806000138");
        hanteiSateiRankBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        hanteiSateiRankBean.setSateiYouhiKbn(C_SateiYouhiKbn.HUYOU);
        hanteiSateiRankBean.setSKNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn.SEIJYOU);
        hanteiSateiRankBean.setSaisateikbn(C_SaisateiKbn.BLNK);
        YuyuSiharaiConfig.getInstance().setSatei3YouhiGk(BizCurrency.valueOf(50000000));
        kinouMode.setKinouMode("satei3");
        HanteiSateiRankKekkaBean hanteiSateiRankKekkaBean = hanteiSateiRank.exec(hanteiSateiRankBean);
        exBooleanEquals(hanteiSateiRankKekkaBean.getSateiRankuHanteiKekka(), false, "査定ランク判定結果");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiYouhiKbn(), C_SateiYouhiKbn.YOU, "査定要否区分");
        exClassificationEquals(hanteiSateiRankKekkaBean.getSateiSanjikaisouUmuKbn(), C_UmuKbn.ARI, "査定３次回送有無区分");
    }
}
