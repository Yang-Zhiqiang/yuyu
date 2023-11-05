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
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 返金クラスのメソッド {@link Henkin#execPkakin(MosnaiCheckParam, BizCurrency, C_Tuukasyu, C_HenkinriyuuKbn)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HenkinTest_execPkakin extends AbstractTest {

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
            testDataAndTblMap = testDataMaker.getInData(HenkinTest_execPkakin.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        KeisanGaikakanzanMockForSinkeiyaku.caller = HenkinTest_execPkakin.class;
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

    }

    @Test
    @TestOrder(10)
    public void testExecPkakin_A1() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112402");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(1), C_Tuukasyu.JPY, C_HenkinriyuuKbn.MIAWASEENKI);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112402", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenyenkagk(), BizCurrency.valueOf(1),
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.MIAWASEENKI,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112402", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(1),
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "D001", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "DB01", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ2", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.MIAWASEENKI,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160401"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "B001", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 2, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112402", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), null, "業務用更新時間");

        exStringEquals(henkinLst.get(1).getMosno(), "791112402", "申込番号");
        exNumericEquals(henkinLst.get(1).getRenno(), 2, "連番");
        exDateEquals(henkinLst.get(1).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(1).getHnkngk(), BizCurrency.valueOf(1), "返金額");
        exClassificationEquals(henkinLst.get(1).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(1).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(1).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(1).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.MIAWASEENKI, "返金理由区分");
        exStringEquals(henkinLst.get(1).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(1).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(1).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(1).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(1).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(1).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(1).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(1).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecPkakin_A2() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112410");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100), C_Tuukasyu.USD, C_HenkinriyuuKbn.MOS_TORIKESI);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
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
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "勘定科目コード");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(0).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.MOS_TORIKESI,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),  BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 2, "商品世代番号");
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
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, "勘定科目コード");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
            "伝票処理区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasuitososhikicd(), "5650000",
            "Ａ扱者出納組織コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKykymd(), BizDate.valueOf("20160610"), "契約日");
        exDateYMEquals(henkinOutBean.getSkDenpyoDataList().get(1).getBosyuuym(), BizDateYM.valueOf("201606"), "募集年月");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatsukaishasoshikicd(), "", "Ａ扱者組織コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyadaibosyuucd(), "", "Ａ扱者代表募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyusyouhncd(), "ｱ1", "主契約商品コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSdpdkbn(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHrkkeiro(), C_Hrkkeiro.CREDIT, "払込経路");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSknnkaisiymd(), BizDate.valueOf("20160611"), "責任開始日");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosymd(), BizDate.valueOf("20160612"), "申込日");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.MOS_TORIKESI,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160331"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "999", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),  BizDate.valueOf("20160331"), "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 2, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 2, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112410", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), null, "業務用更新時間");

        exStringEquals(henkinLst.get(1).getMosno(), "791112410", "申込番号");
        exNumericEquals(henkinLst.get(1).getRenno(), 2, "連番");
        exDateEquals(henkinLst.get(1).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(1).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(1).getHnkntuukasyu(), C_Tuukasyu.USD, "返金通貨種類");
        exDateEquals(henkinLst.get(1).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(1).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(1).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.MOS_TORIKESI, "返金理由区分");
        exStringEquals(henkinLst.get(1).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(1).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(1).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(1).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(1).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(1).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(1).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(1).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    public void testExecPkakin_A3() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112428");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100), C_Tuukasyu.EUR, C_HenkinriyuuKbn.YUUKOUKKNKKA);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112428", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.YUUKOUKKNKKA,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112428", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.YUUKOUKKNKKA,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 2, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112428", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), null, "業務用更新時間");

        exStringEquals(henkinLst.get(1).getMosno(), "791112428", "申込番号");
        exNumericEquals(henkinLst.get(1).getRenno(), 2, "連番");
        exDateEquals(henkinLst.get(1).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(1).getHnkngk(), BizCurrency.valueOf(10, BizCurrencyTypes.EURO), "返金額");
        exClassificationEquals(henkinLst.get(1).getHnkntuukasyu(), C_Tuukasyu.EUR, "返金通貨種類");
        exDateEquals(henkinLst.get(1).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(1).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(1).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.YUUKOUKKNKKA, "返金理由区分");
        exStringEquals(henkinLst.get(1).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(1).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(1).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(1).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(1).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(1).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(1).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(1).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExecPkakin_A4() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112436");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR), C_Tuukasyu.AUD, C_HenkinriyuuKbn.HENKINKIBOU);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 3, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112436", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(10, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112436", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 3, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112436", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(),
            BizCurrency.valueOf(-90, BizCurrencyTypes.AU_DOLLAR), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 2, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112436", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), null, "業務用更新時間");

        exStringEquals(henkinLst.get(1).getMosno(), "791112436", "申込番号");
        exNumericEquals(henkinLst.get(1).getRenno(), 2, "連番");
        exDateEquals(henkinLst.get(1).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(1).getHnkngk(), BizCurrency.valueOf(100, BizCurrencyTypes.AU_DOLLAR), "返金額");
        exClassificationEquals(henkinLst.get(1).getHnkntuukasyu(), C_Tuukasyu.AUD, "返金通貨種類");
        exDateEquals(henkinLst.get(1).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(1).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(1).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU, "返金理由区分");
        exStringEquals(henkinLst.get(1).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(1).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(1).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(1).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(1).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(1).getSrgohnknumu(), C_UmuKbn.ARI, "成立後返金有無");
        exNumericEquals(henkinLst.get(1).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(1).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(50)
    public void testExecPkakin_A5() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112444");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100), C_Tuukasyu.BLNK, C_HenkinriyuuKbn.BLNK);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 2, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112444", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(100), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
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
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112444", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.BLNK, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(100), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_KKN,
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
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112444", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(100), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.BLNK, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.BLNK, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    public void testExecPkakin_A6() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112451");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100), C_Tuukasyu.JPY, C_HenkinriyuuKbn.HENKINKIBOU);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 3, "件数");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getMosno(), "791112451", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(0).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getMosno(), "791112451", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDenyenkagk(), BizCurrency.valueOf(100),
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(1).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getEdano(), 3, "枝番号");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getMosno(), "791112451", "申込番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHuridenatesakicd(), "565", "振替伝票宛先部課コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTantocd(),
            C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenymd(), BizDate.valueOf("20160404"), "伝票日付");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA,
            "貸借区分");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSuitoubumoncd(), "565", "出納部門コード");
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenkawaserate(), BizNumber.ZERO, "伝票用為替レート");
        exBizCalcbleEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDenyenkagk(), BizCurrency.valueOf(-100),
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDensyorikbn(), C_DensyoriKbn.FP_HNKNKB,
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
        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(2).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU,
            "返金理由区分");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getFstpryosyuymd(), BizDate.valueOf("20160402"),
            "初回Ｐ領収日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getAatkisyabosyuucd(), "", "Ａ扱者募集人コード");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getRyouritusdno(), "", "料率世代番号");
        exBooleanEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(henkinOutBean.getSkDenpyoDataList().get(2).getKakokawaserateshiteiymd(),  null, "過去為替レート指定年月日");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getDengyoumucd(), "", "伝票用業務コード");
        exNumericEquals(henkinOutBean.getSkDenpyoDataList().get(2).getSyouhnsdno(), 0, "商品世代番号");
        exStringEquals(henkinOutBean.getSkDenpyoDataList().get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 1, "件数");
        exStringEquals(henkinLst.get(0).getMosno(), "791112451", "申込番号");
        exNumericEquals(henkinLst.get(0).getRenno(), 1, "連番");
        exDateEquals(henkinLst.get(0).getHnknsyoriymd(), null, "返金処理日");
        exBizCalcbleEquals(henkinLst.get(0).getHnkngk(), BizCurrency.valueOf(100), "返金額");
        exClassificationEquals(henkinLst.get(0).getHnkntuukasyu(), C_Tuukasyu.JPY, "返金通貨種類");
        exDateEquals(henkinLst.get(0).getPkakinsyoriymd(), BizDate.valueOf(20160401), "Ｐ過金処理日");
        exClassificationEquals(henkinLst.get(0).getHnknhoukbn(), C_HnknhouKbn.BLNK, "返金方法区分");
        exDateEquals(henkinLst.get(0).getHnknymd(), null, "返金日");
        exClassificationEquals(henkinLst.get(0).getHnknriyuukbn(), C_HenkinriyuuKbn.HENKINKIBOU, "返金理由区分");
        exStringEquals(henkinLst.get(0).getBankcd(), "", "銀行コード");
        exStringEquals(henkinLst.get(0).getSitencd(), "", "支店コード");
        exClassificationEquals(henkinLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(henkinLst.get(0).getKouzano(), "", "口座番号");
        exStringEquals(henkinLst.get(0).getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(henkinLst.get(0).getSrgohnknumu(), C_UmuKbn.NONE, "成立後返金有無");
        exNumericEquals(henkinLst.get(0).getEdano(), 0, "枝番号");
        exNumericEquals(henkinLst.get(0).getPkakindenedano(), 2, "Ｐ過金伝票枝番号");
        exStringEquals(henkinLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(henkinLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    public void testExecPkakin_A7() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112469");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(0), C_Tuukasyu.JPY, C_HenkinriyuuKbn.HENKINKIBOU);

        exNumericEquals(henkinOutBean.getSkDenpyoDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkFBSoukinDataList().size(), 0, "件数");

        exNumericEquals(henkinOutBean.getSkGaikaFBSoukinDataList().size(), 0, "件数");
        List<HT_Henkin> henkinLst = syoriCTL.getHenkins();
        exNumericEquals(henkinLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExecPkakin_A8() {

        kinou.setSyoricd("RA43");
        changeSystemDate(BizDate.valueOf(2016, 4, 01));
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20160401));
        mosnaiCheckParam.setKinouID("Henkin");
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000000");
        HenkinOutBean henkinOutBean = henkin.execPkakin(mosnaiCheckParam, BizCurrency.valueOf(100), C_Tuukasyu.USD, C_HenkinriyuuKbn.MOS_TORIKESI);

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(0).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI, "勘定科目コード");

        exClassificationEquals(henkinOutBean.getSkDenpyoDataList().get(1).getKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN, "勘定科目コード");
    }
}
