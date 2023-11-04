package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForSinkeiyaku;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 返金クラスのメソッド {@link Henkin#exec(MosnaiCheckParam, C_HnknhouKbn, HT_KouzaJyouhou, BizCurrency, C_Tuukasyu)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HenkinTest_exec extends AbstractTest {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private Henkin henkin;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT_SP_単体テスト仕様書_返金";

    private final static String sheetName = "INデータ_20160811";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HenkinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikakanzanMockForSinkeiyaku.caller = HenkinTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanGaikakanzanMockForSinkeiyaku.caller = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllKanjyouKamoku());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.TOUKYK_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.JPY);
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 12, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(2).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(3).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(4).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(4).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(4).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(4).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(4).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(5).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(5).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(5).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(5).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(5).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(6).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(6).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(6).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(6).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(6).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(7).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(7).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(7).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(7).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(7).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(8).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(8).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(8).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(8).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(8).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(9).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(9).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(9).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getDengyoumucd(), "", "伝票用業務コード");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(9).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(9).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(10).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSeg1cd(), C_Segcd.BLNK,
            "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSeg2cd(), C_Segcd.BLNK,
            "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(10).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(10).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(10).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(10).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(11).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getMosno(), "791112220", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(11).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(11).getKeiyakutuukagk(), BizCurrency.valueOf(100), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakutyouseiflg() , false, "貸借調整フラグ");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getDengyoumucd(), "5650", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(11).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(11).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 3, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getGyoumucd(),
            C_Gyoumucd.GK_YENSOUKIN_SK, "業務コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSyono(), "791112220", "証券番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSoukingk(), BizCurrency.valueOf(10), "送金金額");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getGaikataikagk(), BizCurrency.valueOf(100),
            "外貨対価額");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getSoukinkwsrate(), BizNumber.valueOf(0.0125),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getGyoumucd(),
            C_Gyoumucd.GK_YENSOUKIN_SK, "業務コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSyono(), "791112220", "証券番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSoukingk(), BizCurrency.valueOf(10), "送金金額");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getGaikataikagk(), BizCurrency.valueOf(100),
            "外貨対価額");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getSoukinkwsrate(), BizNumber.valueOf(0.0125),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getGyoumucd(),
            C_Gyoumucd.GK_YENSOUKIN_SK, "業務コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exDateEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSyono(), "791112220", "証券番号");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSoukingk(), BizCurrency.valueOf(10), "送金金額");
        exClassificationEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getGaikataikagk(), BizCurrency.valueOf(100),
            "外貨対価額");
        exBizCalcbleEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getSoukinkwsrate(), BizNumber.valueOf(0.0125),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkFBSoukinDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 3, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exNumericEquals(henkinLst.get(0).getZenhnknrenno(), 0, "全額返金連番");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.TOUKYK_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160404), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(henkinLst.get(1).getMosno(), "791112220", "申込番号");
        exNumericEquals(henkinLst.get(1).getRenno(), 2, "連番");
        exDateEquals(henkinLst.get(1).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exNumericEquals(henkinLst.get(0).getZenhnknrenno(), 0, "全額返金連番");
        exBizCalcbleEquals(henkinLst.get(1).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(1).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(1).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(1).getHnknhoukbn(), C_HnknhouKbn.TOUKYK_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(1).getHnknymd(), BizDate.valueOf(20160404), "返金日");
        exClassificationEquals(henkinLst.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(1).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(1).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(1).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(1).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(1).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(1).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(1).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(1).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(1).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(henkinLst.get(2).getMosno(), "791112220", "申込番号");
        exNumericEquals(henkinLst.get(2).getRenno(), 3, "連番");
        exDateEquals(henkinLst.get(2).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exNumericEquals(henkinLst.get(0).getZenhnknrenno(), 0, "全額返金連番");
        exBizCalcbleEquals(henkinLst.get(2).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(2).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(2).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(2).getHnknhoukbn(), C_HnknhouKbn.TOUKYK_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(2).getHnknymd(), BizDate.valueOf(20160404), "返金日");
        exClassificationEquals(henkinLst.get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(2).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(2).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(2).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(2).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(2).getKzmeiginmkn(), "カナナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(2).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(2).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(2).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(2).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.DANTAIHNKN_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 4, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112238", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),
            BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKeiyakutuukagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112238", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),
            BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKeiyakutuukagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112238", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_USD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(2).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(),
            BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKeiyakutuukagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "56500", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosno(), "791112238", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(3).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiymd(),
            BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKeiyakutuukagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengyoumucd(), "56500", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 1, "件数");
        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGkgyoumucd(),
            C_Gkgyoumucd.GK_GKSOUKIN_SK, "外貨業務コード");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"),
            "処理年月日");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getMosno(), "791112238", "申込番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBanknmej(), "RESONA BANK, LTD.", "銀行名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitencd(), "005", "支店コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitennmej(), "TENRI", "支店名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKzmeiginmei(), "ナカカナ", "口座名義人名（英字）");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrtuukasyu(), C_Tuukasyu.USD,
            "支払通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGaikashrgk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "外貨支払額");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK,
            "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getCrossrateshrgk(),
            BizCurrency.valueOf(0), "クロスレート支払額");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSoukinkwsrate(), BizNumber.valueOf(0),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.USD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.DANTAIHNKN_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160405), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカカナ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KOUZASITEI, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.EUR);
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.PHURIKZ, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.EURO), C_Tuukasyu.EUR);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112253", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exNumericEquals(henkinLst.get(0).getZenhnknrenno(), 1, "全額返金連番");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.EUR, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.PHURIKZ, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "1001", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "001", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinLst.size(), 3, "件数");
        exClassificationEquals(nyuukinLst.get(0).getZenhnknkbn(), C_ZenhnknKbn.SUMI, "全額返金区分");
        exNumericEquals(nyuukinLst.get(0).getZenhnknrenno(), 1, "全額返金連番");
        exStringEquals(nyuukinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nyuukinLst.get(1).getZenhnknkbn(), C_ZenhnknKbn.SUMI, "全額返金区分");
        exNumericEquals(nyuukinLst.get(1).getZenhnknrenno(), 1, "全額返金連番");
        exStringEquals(nyuukinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nyuukinLst.get(2).getZenhnknkbn(), C_ZenhnknKbn.SUMI, "全額返金区分");
        exNumericEquals(nyuukinLst.get(2).getZenhnknrenno(), 1, "全額返金連番");
        exStringEquals(nyuukinLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");


    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.TOUKYK_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.AU_DOLLAR), C_Tuukasyu.AUD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), C_UmuKbn.NONE, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112261", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.PHURIKZ, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "1001", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "001", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinLst.size(), 1, "件数");
        exClassificationEquals(nyuukinLst.get(0).getZenhnknkbn(), C_ZenhnknKbn.SUMI, "全額返金区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.DANTAIHNKN_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.BLNK);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 4, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112279", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112279", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112279", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(2).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosno(), "791112279", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(3).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 1, "件数");
        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGkgyoumucd(),
            C_Gkgyoumucd.SETTEI_HUKA, "外貨業務コード");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"),
            "処理年月日");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyono(), "791112279", "証券番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBanknmej(), "RESONA BANK, LTD.", "銀行名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitencd(), "005", "支店コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitennmej(), "TENRI", "支店名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKzmeiginmei(), "ナカカナ", "口座名義人名（英字）");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrtuukasyu(), C_Tuukasyu.BLNK,
            "支払通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGaikashrgk(), BizCurrency.valueOf(10),
            "外貨支払額");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK,
            "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getCrossrateshrgk(),
            BizCurrency.valueOf(0), "クロスレート支払額");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSoukinkwsrate(), BizNumber.valueOf(0),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.DANTAIHNKN_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160405), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカカナ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {
        try {
            kinou.setSyoricd("RA43");
            changeSystemDate(BizDate.valueOf(2016, 4, 01));
            KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
            mosnaiCheckParam.setKinouID("Henkin");
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150604162000000");
            henkin.exec(mosnaiCheckParam, C_HnknhouKbn.DANTAIHNKN_KOUZA, kouzaJyouhou,
                BizCurrency.valueOf(1), C_Tuukasyu.BLNK);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。口座情報が取得できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.JPY);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112295", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112295", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(0),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(10),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112295", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.KARIUKE, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160404), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112303", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112303", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112303", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.USD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.KARIUKE, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160404), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.EURO), C_Tuukasyu.EUR);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112311", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.EURO),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112311", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.EURO),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112311", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.EUR, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.KARIUKE, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf("20160404"), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        MockObjectManager.initialize();
        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.AU_DOLLAR), C_Tuukasyu.AUD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112329", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112329", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_AUD,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112329", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.KARIUKE, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf("20160404"), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");


    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.BLNK);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112337", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112337", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK,
            "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(), BizCurrency.valueOf(10),
            "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112337", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.KARIUKE, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf("20160404"), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.BLNK, kouzaJyouhou,
            BizCurrency.valueOf(1), C_Tuukasyu.BLNK);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 0, "件数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        try {
            kinou.setSyoricd("RA43");
            changeSystemDate(BizDate.valueOf(2016, 4, 01));
            KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
            mosnaiCheckParam.setKinouID("Henkin");
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150604162000000");
            henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KOUZASITEI, kouzaJyouhou,
                BizCurrency.valueOf(1), C_Tuukasyu.JPY);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。為替レートが取得できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        try {
            kinou.setSyoricd("RA43");
            changeSystemDate(BizDate.valueOf(2016, 4, 01));
            KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
            MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
            HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
            mosnaiCheckParam.setKinouID("Henkin");
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150604162000000");
            henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KOUZASITEI, kouzaJyouhou,
                BizCurrency.valueOf(1 ,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。銀行情報が取得できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KOUZASITEI, kouzaJyouhou,
            BizCurrency.valueOf(0 ,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112394");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.BLNK, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.PHURIKZ, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.AU_DOLLAR), C_Tuukasyu.AUD);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112402", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exNumericEquals(henkinLst.get(0).getZenhnknrenno(), 2, "全額返金連番");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.PHURIKZ, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160401), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "1001", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "001", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukins();
        exNumericEquals(nyuukinLst.size(), 1, "件数");
        exClassificationEquals(nyuukinLst.get(0).getZenhnknkbn(), C_ZenhnknKbn.SUMI, "全額返金区分");
        exNumericEquals(nyuukinLst.get(0).getZenhnknrenno(), 3, "全額返金連番");
        exStringEquals(nyuukinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nyuukinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }


    @Test
    @TestOrder(200)
    public void testExec_A20() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.DANTAIHNKN_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1, BizCurrencyTypes.AU_DOLLAR), C_Tuukasyu.AUD);
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 4, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112410", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(0.10, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112410", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKeiyakutuukagk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112410", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SINKEIYAKUFB_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(),
            BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(2).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKeiyakutuukagk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "56500", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosno(), "791112410", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSuitoubumoncd(), "521", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengaikagk(),
            BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDenyenkagk(), BizCurrency.valueOf(0),
            "伝票金額（円）");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoriYmd(), BizDate.valueOf("20160401"), "処理年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyorisosikicd(), "5650000", "処理組織コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKessantyouseikbn(),
            C_KessantyouseiKbn.BLNK, "決算調整区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getNaibukeiyakukbn(), C_NaibuKeiyakuKbn.BLNK,
            "内部契約区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getTekiyoukbn(), C_TekiyouKbn.BLNK, "摘要区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDensyorikbn(), C_DensyoriKbn.FP_HNKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(3).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyusyouhncd(), "", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKeiyakutuukagk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "契約通貨金額");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getDengyoumucd(), "56500", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(3).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 1, "件数");
        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI,
            "伝票用システム区分");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGkgyoumucd(),
            C_Gkgyoumucd.GK_GKSOUKIN_SK, "外貨業務コード");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getTantositucd(),
            C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyorisosikicd(), "5650000", "処理組織コード");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSyoriYmd(), BizDate.valueOf("20160401"),
            "処理年月日");
        exDateEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getDenymd(), BizDate.valueOf("20160405"), "伝票日付");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getMosno(), "791112410", "申込番号");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrhousiteikbn(),
            C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getBanknmej(), "RESONA BANK, LTD.", "銀行名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitencd(), "005", "支店コード");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSitennmej(), "TENRI", "支店名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKzmeiginmei(), "ナカナカ", "口座名義人名（英字）");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getShrtuukasyu(), C_Tuukasyu.AUD,
            "支払通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGaikashrgk(),
            BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "外貨支払額");
        exClassificationEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK,
            "契約通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getCrossrateshrgk(),
            BizCurrency.valueOf(0), "クロスレート支払額");
        exBizCalcbleEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getSoukinkwsrate(), BizNumber.valueOf(0),
            "送金用為替レート");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinKinou(), "Henkin", "業務用更新機能ＩＤ");
        exStringEquals(henkinOutBean.getSkGaikaFBSoukinDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exClassificationEquals(syoriCTL.getNyknnrkumu(), null, "入金入力有無");

        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112410", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), BizDate.valueOf("20160401"), "返金処理日");
        exStringEquals(henkinLst.get(0).getHenkinsyoritime(), "20150604162000000", "返金処理日時");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(0.1, BizCurrencyTypes.AU_DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), null, "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.DANTAIHNKN_KOUZA, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), BizDate.valueOf(20160405), "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "0010", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "005", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "K001", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "ナカナカ", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 2, "枝番号");
        exStringEquals(henkinLst.get(0).getPkakindenrenno(), "", "Ｐ過金伝票データ連番");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 0, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }
    @Test
    @TestOrder(210)
    public void testExec_A21() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.DANTAIHNKN_KOUZA, kouzaJyouhou,
            BizCurrency.valueOf(1, BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN, "勘定科目コード");

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SINKEIYAKUFB, "勘定科目コード");

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SINKEIYAKUFB, "勘定科目コード");

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(3).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");

    }
    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        KeisanGaikakanzanMockForSinkeiyaku.SYORIPTN = KeisanGaikakanzanMockForSinkeiyaku.TESTPATTERN1;
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");
        HT_KouzaJyouhou kouzaJyouhou = syoriCTL.getKouzaJyouhou();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.exec(mosnaiCheckParam, C_HnknhouKbn.KARIUKE, kouzaJyouhou,
            BizCurrency.valueOf(1 ,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD);

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN,
            "勘定科目コード");

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP,
            "勘定科目コード");

    }
}
