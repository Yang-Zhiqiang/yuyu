package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.message.Message;
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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.GetKawaseRateMockForSiharai;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikin;
import yuyu.common.biz.bzcommon.KeisanAzukariGanrikinMockForSiharai;
import yuyu.common.biz.bzcommon.KeisanTienrisoku;
import yuyu.common.biz.bzcommon.KeisanTienrisokuMockForSiharai;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForSiharai;
import yuyu.common.hozen.haitou.KeisanDCommonSibou;
import yuyu.common.hozen.haitou.KeisanDCommonSibouMockForSiharai;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiP;
import yuyu.common.hozen.khcommon.KeisanMsyMkeiPMockForSiharai;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmd;
import yuyu.common.siharai.chksk.ChkSubSknnKaisiYmdMockForSiharai;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSettei;
import yuyu.common.siharai.chksk.SiSKNaiyouChkkekkaSetteiMockForSiharai;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuukasanUmuKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknKknKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HushrSyousaiKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 支払金額計算クラスのメソッド {@link SiSiharaiKingakuKeisan#exec(SiSiharaiKingakuKeisanBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSiharaiKingakuKeisanTest_exec extends AbstractTest {

    @Inject
    private SiSiharaiKingakuKeisan siShrKngkKeisan;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_支払金額計算";

    private final static String sheetName = "INデータ";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(KeisanTienrisoku.class).to(KeisanTienrisokuMockForSiharai.class);
                bind(CalcHkHtykeihi.class).to(CalcHkHtykeihiMockForSiharai.class);
                bind(GetKawaseRate.class).to(GetKawaseRateMockForSiharai.class);
                bind(ChkSubSknnKaisiYmd.class).to(ChkSubSknnKaisiYmdMockForSiharai.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForSiharai.class);
                bind(KeisanDCommonSibou.class).to(KeisanDCommonSibouMockForSiharai.class);
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForSiharai.class);
                bind(KeisanMsyMkeiP.class).to(KeisanMsyMkeiPMockForSiharai.class);
                bind(KeisanAzukariGanrikin.class).to(KeisanAzukariGanrikinMockForSiharai.class);
                bind(SiSKNaiyouChkkekkaSettei.class).to(SiSKNaiyouChkkekkaSetteiMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        GetKawaseRateMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanAzukariGanrikinMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanTienrisokuMockForSiharai.caller = null;
        KeisanTienrisokuMockForSiharai.SYORIPTN = null;
        CalcHkHtykeihiMockForSiharai.caller = null;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = null;
        GetKawaseRateMockForSiharai.caller = null;
        GetKawaseRateMockForSiharai.SYORIPTN = null;
        ChkSubSknnKaisiYmdMockForSiharai.caller = null;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = null;
        CalcHkShrKngkMockForSiharai.caller = null;
        CalcHkShrKngkMockForSiharai.SYORIPTN = null;
        CalcHkShrKngkMockForSiharai.mode = null;
        KeisanDCommonSibouMockForSiharai.caller = null;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForSiharai.caller = null;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = null;
        KeisanMsyMkeiPMockForSiharai.caller = null;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = null;
        KeisanAzukariGanrikinMockForSiharai.caller = null;
        KeisanAzukariGanrikinMockForSiharai.SYORIPTN = null;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.caller = null;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiSiharaiKingakuKeisanTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
        siharaiDomManager.delete(siharaiDomManager.getAllSkNaiyouChk());
    }
    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiSiDetailParamBean() == null, true, "支払明細パラメータBeanリスト件数");
        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.BLNK, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), null, "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(0), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(0), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.BLNK, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(0), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(0), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(0), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(0), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(0), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(0), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(0), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(0), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(0), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), null, "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(0), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.BLNK, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(0), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(0), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.BLNK, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(0), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(0), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(0), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(0), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(0), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(0), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(0), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(0), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(0), "（分割後）円貨換算結果金額");

        exBooleanEquals(siShrKngkKeisan.getEditDshrTukiDKoumokuBean() == null, true, "Ｄ支払統計配当金項目編集用Bean");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.BLNK);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo(null);
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200103"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160103"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.BLNK);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200104"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160104"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(null);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160105"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200106"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160106"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.BLNK);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200107"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(null);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }
    @Test
    @TestOrder(80)
    public void testExec_A8() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200108"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160108"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(null);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200109"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160109"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(null);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(95)
    public void testExec_A9_2() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200109"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160109"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.HUKA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        MockObjectManager.initialize();

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200110"));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160110"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiKykKihon(new JT_SiKykKihon());
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.BLNK);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBA1056", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "支払金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        MockObjectManager.initialize();
        GetKawaseRateMockForSiharai.SYORIPTN = GetKawaseRateMockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200111"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(BizDate.valueOf("20100111"));
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160111"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn0 = new JT_SiKykSyouhn();
        siKykSyouhn0.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn0.setKykymd(BizDate.valueOf("20190119"));
        siKykSyouhn0.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhnList.add(siKykSyouhn0);
        JT_SiKykSyouhn siKykSyouhn1 = new JT_SiKykSyouhn();
        siKykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
        siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.EUR);
        siKykSyouhnList.add(siKykSyouhn1);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EJA1008", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "20100111", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();

        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200114"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.valueOf(101.14));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160114"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKykymd(BizDate.valueOf("20150101"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBF0129", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "保険金額計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        GetKawaseRateMockForSiharai.SYORIPTN = GetKawaseRateMockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200115"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.valueOf(101.15));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160115"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn0 = new JT_SiKykSyouhn();
        siKykSyouhn0.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn0.setKykymd(BizDate.valueOf("20150101"));
        siKykSyouhn0.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhnList.add(siKykSyouhn0);
        JT_SiKykSyouhn siKykSyouhn1 = new JT_SiKykSyouhn();
        siKykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
        siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.EUR);
        siKykSyouhnList.add(siKykSyouhn1);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.SONOTA);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EJA1008", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "20200115", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();
        GetKawaseRateMockForSiharai.SYORIPTN = GetKawaseRateMockForSiharai.TESTPATTERN10;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("12345678901");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200111"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(BizDate.valueOf("20100112"));
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160111"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn0 = new JT_SiKykSyouhn();
        siKykSyouhn0.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn0.setKykymd(BizDate.valueOf("20150101"));
        siKykSyouhn0.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhnList.add(siKykSyouhn0);
        JT_SiKykSyouhn siKykSyouhn1 = new JT_SiKykSyouhn();
        siKykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
        siKykSyouhn1.setKyktuukasyu(C_Tuukasyu.EUR);
        siKykSyouhnList.add(siKykSyouhn1);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EJA1008", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "20181123", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();

        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);
        siShrKngkKeisanBean.setSyoNo("17806000013");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20200111"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(BizDate.valueOf("20100112"));
        siShrKngkKeisanBean.setKawaseRate(BizNumber.valueOf(17.01));
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20160111"));
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.BLNK);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.JS);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("17806000013");
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("17806000013");
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setKykymd(BizDate.valueOf("20150101"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);

        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EBF0129", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "配当共通計算", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190607"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190613"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());

        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt1 = new JT_SiUkt();
        siUkt1.setSyono("20808000060");
        siUkt1.setHkuktsyu(C_Hkuktsyu.SONOTA);
        siUkt1.setUktsyurenno(1);
        siUkt1.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        siUktList.add(siUkt1);
        JT_SiUkt siUkt2 = new JT_SiUkt();
        siUkt2.setSyono("20808000060");
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktsyurenno(1);
        siUkt2.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        siUktList.add(siUkt2);
        siShrKngkKeisanBean.getSiKykKihon().setSiUkts(siUktList);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EJA1008", "メッセージＩＤ");
        exStringEquals(String.valueOf(msg0.getMessageArgs()[0]), "20190607", "メッセージ引数1");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.SEIJYOU, "支払金額計算後チェック結果区分");
    }


    @Test
    @TestOrder(210)
    public void testExec_B1() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;


        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.valueOf(101.99));
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.valueOf(102.99));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.BLNK);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(101.99), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(102.99), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
    }

    @Test
    @TestOrder(220)
    public void testExec_B2() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.BLNK);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190610"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.83), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.83), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
    }


    @Test
    @TestOrder(230)
    public void testExec_B3() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190610"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
    }

    @Test
    @TestOrder(240)
    public void testExec_B4() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(BizDate.valueOf("20190613"));
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190610"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190613"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.89), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.89), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190613"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.89), "税務用為替レート");
    }

    @Test
    @TestOrder(250)
    public void testExec_B5() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190613"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());

        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siShrKngkKeisanBean.getSiKykKihon().setSiUkts(siUktList);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190610"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190613"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.89), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.89), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190610"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(121.34), "税務用為替レート");
    }

    @Test
    @TestOrder(260)
    public void testExec_B6() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190613"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());

        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt1 = new JT_SiUkt();
        siUkt1.setSyono("20808000060");
        siUkt1.setHkuktsyu(C_Hkuktsyu.SONOTA);
        siUkt1.setUktsyurenno(1);
        siUkt1.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        siUktList.add(siUkt1);
        JT_SiUkt siUkt2 = new JT_SiUkt();
        siUkt2.setSyono("20808000060");
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktsyurenno(1);
        siUkt2.setUktkbn(C_UktKbn.TOKUTEIMEIGI);
        siUktList.add(siUkt2);
        siShrKngkKeisanBean.getSiKykKihon().setSiUkts(siUktList);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190610"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190613"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.89), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.89), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190610"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.34), "税務用為替レート");
    }

    @Test
    @TestOrder(270)
    public void testExec_B7() {
        testClear();
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN2;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN2;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestKawaseRate();

        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.GAIKASIHARAI);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190610"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190613"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.KYKDAIRININ);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());

        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siShrKngkKeisanBean.getSiKykKihon().setSiUkts(siUktList);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190610"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190613"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.89), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.89), "外貨換算為替レート");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190610"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(121.34), "税務用為替レート");
    }


    @Test
    @TestOrder(310)
    public void testExec_C1_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 2, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBean1 = siShrKngkKeisan.getSiSiDetailParamBean().get(1);
        exNumericEquals(siSiDetailParamBean1.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean1.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean1.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean1.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean1.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean1.getKyuuhucd(), "B010", "給付コード");
        exNumericEquals(siSiDetailParamBean1.getRenno(), 2, "連番");
        exClassificationEquals(siSiDetailParamBean1.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean1.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean1.getKanjyoukmkcd(), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean1.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean1.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean1.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean1.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkg(), BizCurrency.valueOf(0, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean1.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean1.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean1.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean1.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean1.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean1.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean1.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean1.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamegamen(), "災害死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamereport(), "災害死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean1.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean1.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean1.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean1.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(320)
    public void testExec_C1_2() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.ARI);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.12));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
    }


    @Test
    @TestOrder(330)
    public void testExec_C1_3() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN4;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Saisatei();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.SAISATEI);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 2, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(0, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBean1 = siShrKngkKeisan.getSiSiDetailParamBean().get(1);
        exNumericEquals(siSiDetailParamBean1.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean1.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean1.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean1.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean1.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean1.getKyuuhucd(), "B010", "給付コード");
        exNumericEquals(siSiDetailParamBean1.getRenno(), 2, "連番");
        exClassificationEquals(siSiDetailParamBean1.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean1.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean1.getKanjyoukmkcd(), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean1.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean1.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean1.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean1.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkg(), BizCurrency.valueOf(18000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean1.getYenkyhgk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean1.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean1.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean1.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean1.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean1.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean1.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean1.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamegamen(), "災害死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamereport(), "災害死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean1.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean1.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean1.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean1.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(18000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(18000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "災害死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(120850000L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(1000000L, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(120850000L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(18000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(18000000L, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(18000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        exBooleanEquals(siShrKngkKeisan.getEditDshrTukiDKoumokuBean() == null, true, "Ｄ支払統計配当金項目編集用Bean");

    }

    @Test
    @TestOrder(340)
    public void testExec_C1_4() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN4;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Saisatei();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.SAISATEI);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 2, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBean1 = siShrKngkKeisan.getSiSiDetailParamBean().get(1);
        exNumericEquals(siSiDetailParamBean1.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean1.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean1.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean1.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean1.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean1.getKyuuhucd(), "B010", "給付コード");
        exNumericEquals(siSiDetailParamBean1.getRenno(), 2, "連番");
        exClassificationEquals(siSiDetailParamBean1.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean1.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean1.getKanjyoukmkcd(), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean1.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean1.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean1.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean1.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkg(), BizCurrency.valueOf(0, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean1.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean1.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean1.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean1.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean1.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean1.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean1.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean1.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamegamen(), "災害死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamereport(), "災害死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean1.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean1.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean1.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean1.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(0, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(0, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), null, "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        exBooleanEquals(siShrKngkKeisan.getEditDshrTukiDKoumokuBean() == null, true, "Ｄ支払統計配当金項目編集用Bean");

    }


    @Test
    @TestOrder(350)
    public void testExec_C1_5() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN5;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20260609"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20260611"));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20260609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20260611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI2HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20260611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(360)
    public void testExec_C1_6() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN6;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20310609"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20310611"));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20310609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20310611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI3HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20310611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054452051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(370)
    public void testExec_C1_7() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setYobidasimotoKinouId("sibikintyusyutu");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 2, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");
        SiSiDetailParamBean siSiDetailParamBean1 = siShrKngkKeisan.getSiSiDetailParamBean().get(1);
        exNumericEquals(siSiDetailParamBean1.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean1.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean1.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean1.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean1.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean1.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean1.getKyuuhucd(), "B010", "給付コード");
        exNumericEquals(siSiDetailParamBean1.getRenno(), 2, "連番");
        exClassificationEquals(siSiDetailParamBean1.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean1.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SAIGAIHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean1.getKanjyoukmkcd(), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean1.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean1.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean1.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean1.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkg(), BizCurrency.valueOf(0, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean1.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean1.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean1.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean1.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean1.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean1.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean1.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean1.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean1.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamegamen(), "災害死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean1.getKyuuhunamereport(), "災害死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean1.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean1.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean1.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean1.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean1.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(17000000, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000000, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        exBooleanEquals(siShrKngkKeisan.getEditDshrTukiDKoumokuBean() == null, true, "Ｄ支払統計配当金項目編集用Bean");

    }


    @Test
    @TestOrder(380)
    public void testExec_C1_8() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN5;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN4;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20260609"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20260611"));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(17000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20260609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20260611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(17000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI2HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(17000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(18000000L, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20260611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(17000000, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), null, "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), null, "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(410)
    public void testExec_C2_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN7;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Yen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕA", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "A011", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建終身保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(510)
    public void testExec_C3_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN8;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestCascade();

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕｹ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "C010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(510)
    public void testExec_C4_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190530"));
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().getSiKykSyouhns().get(0).setKykymd(BizDate.valueOf("20190601"));
        siShrKngkKeisanBean.getSiKykKihon().getSiKykSyouhns().get(0).setSknnkaisiymd(BizDate.valueOf("20190520"));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190530"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(520)
    public void testExec_C4_2() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN1;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = KeisanZennouSeisanGk2MockForSiharai.TESTPATTERN1;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.ZENNOU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1574052051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(24620.44, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13024637.27, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1574052051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(3002051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(24637.27, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(24620.44, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13024637.27, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1574052051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(3002051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(24637.27, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(530)
    public void testExec_C4_3() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571092061L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201907"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(328.36, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(40010, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13000345.19, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571092061L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(42061L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(345.19, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(328.36, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(40010, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13000345.19, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571092061L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(42061L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(345.19, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(540)
    public void testExec_C4_4() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = KeisanZennouSeisanGk2MockForSiharai.TESTPATTERN1;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.ZENNOU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1574092061L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201907"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(328.36, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(40010, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(24620.44, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13024965.63, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1574092061L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(3042061L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(24965.63, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(328.36, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(40010, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(24620.44, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13024965.63, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1574092061L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(3042061L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(24965.63, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(550)
    public void testExec_C4_5() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN3;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20191009"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20191011"));
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20191009"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20191011"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20191011"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1570972713L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 4, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(656.5, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(79339, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(12999360.34, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1570972713L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(12999343.5, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1570970662L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(328.23, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(328.27, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(656.5, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(79339, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(12999360.34, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1570972713L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(12999343.5, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1570970662L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(560)
    public void testExec_C4_6() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = KeisanZennouSeisanGk2MockForSiharai.TESTPATTERN1;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN2;
        KeisanAzukariGanrikinMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanAzukariGanrikinMockForSiharai.SYORIPTN = KeisanAzukariGanrikinMockForSiharai.TESTPATTERN4;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(70));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.ZENNOU);
        siShrKngkKeisanBean.getSiKykKihon().setKrkgk(BizCurrency.valueOf(14000, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(70), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(9100000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1099735000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1574132355L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201907"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(328.36, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(40010, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(24620.44, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(216.69, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(26294, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(13294, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(13000, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(106.69, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(114.9, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(14000, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13025297.21, BizCurrencyTypes.DOLLAR), "支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1574132355L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(3069061L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(25187.21, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000110L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571063294L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(5.75, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(700, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(6.04, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(735, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(229.85, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(28007, BizCurrencyTypes.YEN), "（分割後）円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(17234.31, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(2100000L, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(77, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(9100, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(151.69, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(18406, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(80.43, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(9800, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(9117708.04, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1101892648L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2148342L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(17631.04, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(9100077L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1099744306L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(570)
    public void testExec_C4_7() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN9;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN3;
        KeisanAzukariGanrikinMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanAzukariGanrikinMockForSiharai.SYORIPTN = KeisanAzukariGanrikinMockForSiharai.TESTPATTERN4;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestDuo();
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20191009"));
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20191011"));
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(70));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANARI);
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().setKrkgk(BizCurrency.valueOf(14000, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕﾁ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "D010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20191009"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20191011"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(70), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(9100000.01, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1099735002L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20191011"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571013007L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 4, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(656.5, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(79339, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(216.69, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(26294, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(13294, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(13000, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(106.69, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(114.9, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(14000, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(12999691.92, BizCurrencyTypes.DOLLAR), "支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571013007L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(29051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(238.42, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(12999453.5, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1570983956L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(328.23, BizCurrencyTypes.DOLLAR), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(328.27, BizCurrencyTypes.DOLLAR), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(5.75, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(700, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(6.04, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(735, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(459.55, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(55537, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(77, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(9100, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(151.69, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(18406, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(80.43, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(9800, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(9099784.35, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1099709106L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(20335L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(166.89, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(9099617.46, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1099688771L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(710)
    public void testExec_C5_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN10;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestCascadeYen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾕB", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "C011", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_HUTUU, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡給付金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡給付金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡給付金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuusyonendojikaiikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収初年度次回以降Ｐ");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuujinendoikoup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収次年度以降Ｐ");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }

    @Test
    @TestOrder(810)
    public void testExec_C6_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN13;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN4;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBorelo();
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190530"));
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().getSiKykSyouhns().get(0).setKykymd(BizDate.valueOf("20190601"));
        siShrKngkKeisanBean.getSiKykKihon().getSiKykSyouhns().get(0).setSknnkaisiymd(BizDate.valueOf("20190520"));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190530"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13000016.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571052051L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051L, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

        EditDshrTukiDKoumokuBean editDshrDKBean = siShrKngkKeisan.getEditDshrTukiDKoumokuBean();
        exDateEquals(editDshrDKBean.getCalckijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(editDshrDKBean.getSyoriYmd2(), BizDate.valueOf("20190612"), "処理年月日２");
        exBizCalcbleEquals(editDshrDKBean.getHaitoushrKin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当支払金");

    }


    @Test
    @TestOrder(820)
    public void testExec_C6_2() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN13;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = KeisanZennouSeisanGk2MockForSiharai.TESTPATTERN3;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN5;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBorelo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.ZENNOU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1575330141L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201907"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(48340, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(35000, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(4229750L, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(13035416.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1575330141L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(13035400L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1575328090L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(48340, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(35000, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(4229750L, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(13035416.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1575330141L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(13035400L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1575328090L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(820)
    public void testExec_C6_3() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN13;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN6;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBorelo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().setKrkgk(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571013711L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 4, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");

        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(48340, BizCurrencyTypes.YEN), "円貨未収保険料");

        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(82.07, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(10000, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(12999698.91, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571013711L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(12051, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(98.91, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(12999600L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571001660L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(400, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(48340, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(82.07, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(10000, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(12999698.91, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571013711L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(12051, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(98.91, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(12999600L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571001660L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }

    @Test
    @TestOrder(840)
    public void testExec_C6_4() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN13;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN7;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBorelo();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().setHrkkaisuu(C_Hrkkaisuu.HALFY);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(18000000L, currencyType), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(13000000L, currencyType), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, currencyType), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), BizDate.valueOf("20190611"), "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(120.85), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(13000000L, currencyType), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, currencyType), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, currencyType), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, currencyType), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, currencyType), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, currencyType), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, currencyType), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, currencyType), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, currencyType), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(12000000L,BizCurrencyTypes.DOLLAR), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(1450200000L, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(11100000L, BizCurrencyTypes.DOLLAR), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(1341435000L, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(11200000L, BizCurrencyTypes.DOLLAR), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(1353520000L, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.DOLLAR), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(11300000L, BizCurrencyTypes.DOLLAR), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(13000000L, BizCurrencyTypes.DOLLAR), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.DAI1HKNKKN, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(18000000L, currencyType), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(2175300000L, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(13000000L, currencyType), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(1571050000L, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, currencyType), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), BizDate.valueOf("20190611"), "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(120.85), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(1571003711L, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(121.85), "外貨換算為替レート");
        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "円貨配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "円貨その他配当金");

        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 6, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(72510, BizCurrencyTypes.YEN), "円貨未収保険料");

        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 2, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201911"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(24170, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(12999616.84, BizCurrencyTypes.DOLLAR), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(1571003711L, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(2051, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(12999600L, BizCurrencyTypes.DOLLAR), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(1571001660L, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(8.22, BizCurrencyTypes.DOLLAR), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(8.62, BizCurrencyTypes.DOLLAR), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(72510, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(24170, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(12999616.84, BizCurrencyTypes.DOLLAR), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(1571003711L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(2051, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(16.84, BizCurrencyTypes.DOLLAR), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(12999600L, BizCurrencyTypes.DOLLAR), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(1571001660L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(850)
    public void testExec_C6_5() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN14;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN8;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBoreloYen();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(27002051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(860)
    public void testExec_C6_6() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN14;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanZennouSeisanGk2MockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanZennouSeisanGk2MockForSiharai.SYORIPTN = KeisanZennouSeisanGk2MockForSiharai.TESTPATTERN1;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN9;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBoreloYen();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.ZENNOU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, true, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 0, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");

        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 4, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201907"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(40000L, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(30042051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(40000L, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(3000000L, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(30042051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(30040000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(30040000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(30040000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(870)
    public void testExec_C6_7() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN14;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN10;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBoreloYen();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        siShrKngkKeisanBean.getSiKykKihon().setKrkgk(BizCurrency.valueOf(10000, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, true, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");

        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 4, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(40000L, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");

        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 0, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), null, "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(10000, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(26972051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(40000L, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(10000, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(26972051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(880)
    public void testExec_C6_8() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN14;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        KeisanMsyMkeiPMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanMsyMkeiPMockForSiharai.SYORIPTN = KeisanMsyMkeiPMockForSiharai.TESTPATTERN11;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestBoreloYen();
        siShrKngkKeisanBean.getSiKykKihon().setKykjyoutai(C_Kykjyoutai.HRKMTYUU);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exBooleanEquals(siShrKngkKeisan.getSiDetailMisyuupBeans().size() == 0, false, "明細未収保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getDetailMikeikapBeans().size() == 0, false, "明細未経過保険料Beanリスト");

        exBooleanEquals(siShrKngkKeisan.getSiNenkinInfoBean() == null, true, "年金情報パラメータBean");

        exNumericEquals(siShrKngkKeisan.getSiSiDetailParamBean().size(), 1, "支払明細パラメータBeanリスト件数");
        SiSiDetailParamBean siSiDetailParamBean0 = siShrKngkKeisan.getSiSiDetailParamBean().get(0);
        exNumericEquals(siSiDetailParamBean0.getUketukeno(), 1, "受付番号");
        exClassificationEquals(siSiDetailParamBean0.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exStringEquals(siSiDetailParamBean0.getSyouhncd(), "ﾆｱ", "商品コード");
        exClassificationEquals(siSiDetailParamBean0.getKyhgndkatakbn(), C_KyhgndkataKbn.BLNK, "給付限度型区分");
        exNumericEquals(siSiDetailParamBean0.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(siSiDetailParamBean0.getKyksyouhnrenno(), 11, "契約商品連番");
        exStringEquals(siSiDetailParamBean0.getKyuuhucd(), "E010", "給付コード");
        exNumericEquals(siSiDetailParamBean0.getRenno(), 1, "連番");
        exClassificationEquals(siSiDetailParamBean0.getKyuuhukbn(), C_KyuuhuKbn.SIBOU, "給付区分");
        exClassificationEquals(siSiDetailParamBean0.getHokenkinsyuruikbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals(siSiDetailParamBean0.getKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY, "勘定科目コード");
        exClassificationEquals(siSiDetailParamBean0.getChecktaisyouumukbn(), C_UmuKbn.NONE, "チェック対象有無区分");
        exClassificationEquals(siSiDetailParamBean0.getNitigakuhokenkngkkbn(), C_NitigakuHokenKngkKbn.HGAKU, "日額・保険金額区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getNitigakuhokenkngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "日額・保険金額");
        exNumericEquals(siSiDetailParamBean0.getNissuubairitu(), 0, "日数・倍率");
        exClassificationEquals(siSiDetailParamBean0.getKyhkintanikbn(), C_KyhkinTaniKbn.BLNK, "給付金単位区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkg(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "給付金額");
        exBizCalcbleEquals(siSiDetailParamBean0.getYenkyhgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算給付金額");
        exNumericEquals(siSiDetailParamBean0.getHutanponissuu(), 0, "不担保日数");
        exDateEquals(siSiDetailParamBean0.getShrriyuugaitouymd(), null, "支払理由該当日");
        exClassificationEquals(siSiDetailParamBean0.getHknskgnkkntgtumukbn(), C_UmuKbn.NONE, "保険金削減期間対象有無区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getHokenkinshrwariai(), BizNumber.valueOf(0), "保険金支払割合");
        exStringEquals(siSiDetailParamBean0.getBikoumsg1(), "", "備考MSG１");
        exStringEquals(siSiDetailParamBean0.getBikoumsg2(), "", "備考MSG２");
        exStringEquals(siSiDetailParamBean0.getBikoumsg3(), "", "備考MSG３");
        exStringEquals(siSiDetailParamBean0.getBikoumsg4(), "", "備考MSG４");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmgm(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（画面用）");
        exStringEquals(siSiDetailParamBean0.getSyouhnnmtyhy(), "低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険", "商品名（帳票用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamegamen(), "死亡保険金", "給付名（画面用）");
        exStringEquals(siSiDetailParamBean0.getKyuuhunamereport(), "死亡保険金", "給付名（帳票用）");
        exClassificationEquals(siSiDetailParamBean0.getShrkekkakbn(), C_ShrKekkaKbn.SHR, "支払結果区分");
        exClassificationEquals(siSiDetailParamBean0.getHushrsyousaikbn(), C_HushrSyousaiKbn.BLNK, "不支払詳細区分");
        exBizCalcbleEquals(siSiDetailParamBean0.getKyhkngkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "給付金額合計");
        exBizCalcbleEquals(siSiDetailParamBean0.getSitihsyutkyumaeyenhknkngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "最低保証適用前円換算保険金額");
        exStringEquals(siSiDetailParamBean0.getUtiwakeparam(), "", "内訳パラメータ");

        SiHkkingakuSisanParamBean siHkkSsnPrmBean = siShrKngkKeisan.getSiHkkingakuSisanParamBean();

        exClassificationEquals(siHkkSsnPrmBean.getSUketoriHouhouKbn(), C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, "保険金受取方法区分");
        exDateEquals(siHkkSsnPrmBean.getCalcKijyunYmd(), BizDate.valueOf("20190609"), "計算基準日");
        exDateEquals(siHkkSsnPrmBean.getKnsnKijyunYmd(), null, "換算基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKawaseRate(), BizNumber.valueOf(0), "為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getUktBnWari(), BizNumber.valueOf(100), "受取人分割割合");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenknGk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険金額");
        exDateEquals(siHkkSsnPrmBean.getNkKknSetYmd(), null, "年金基金設定日");
        exDateEquals(siHkkSsnPrmBean.getNkShrStartYmd(), null, "年金支払開始日");
        exClassificationEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKbn(), C_Nstknsyu.KAKUTEINENKIN, "年金支払特約年金種類区分");
        exNumericEquals(siHkkSsnPrmBean.getNkShrTkykNksyuKkn(), 0, "年金支払特約年金期間");
        exClassificationEquals(siHkkSsnPrmBean.getBnShrKaisuu(), C_Bnshrkaisuu.BLNK, "分割支払回数");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkKknJyutouGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkKknJyutouGk(), BizCurrency.valueOf(0), "円換算年金基金充当金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTienRsk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTienRsk(), BizCurrency.valueOf(0), "円換算遅延利息");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkGns(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkGns(), BizCurrency.valueOf(0), "円換算年金原資");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkNengk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkNengk(), BizCurrency.valueOf(0), "円換算年金年額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBnktnkGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenBnktnkGk(), BizCurrency.valueOf(0), "円換算分割年金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHtyKeihi(), BizCurrency.valueOf(17000000L, BizCurrencyTypes.YEN), "必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHtyKeihi(), BizCurrency.valueOf(2054450000L, BizCurrencyTypes.YEN), "円換算必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getNkHtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenNkhtyKeihi(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算年金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getItjknhtyKeihi(), BizCurrency.valueOf(17000001L, BizCurrencyTypes.YEN), "一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenItjknhtyKeihi(), BizCurrency.valueOf(2054450001L, BizCurrencyTypes.YEN), "円換算一時金必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getShrkykhtykeihi(), BizCurrency.valueOf(2054450002L, BizCurrencyTypes.YEN), "支払時契約者必要経費");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKaiyakuHr(), BizCurrency.valueOf(22000000L,BizCurrencyTypes.YEN), "解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKaiyakuHr(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(21100000L, BizCurrencyTypes.YEN), "死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdKaiyakuhenreiknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日解約返戻金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getTutaknGk(), BizCurrency.valueOf(23000000L, BizCurrencyTypes.YEN), "積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenTutaknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbymdTmttKnGk(), BizCurrency.valueOf(21200000L, BizCurrencyTypes.YEN), "死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbymdTmttKnGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡日積立金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHokenryoustGk(), BizCurrency.valueOf(24000000L, BizCurrencyTypes.YEN), "保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenHokenryoustGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算保険料相当額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getPruikei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "保険料累計");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuKisanYmd(), null, "遅延利息開始日");
        exDateEquals(siHkkSsnPrmBean.getTienRisokuSyuryouYmd(), null, "遅延利息終了日");
        exNumericEquals(siHkkSsnPrmBean.getTienRskNissuu(), 0, "遅延日数");
        exDateEquals(siHkkSsnPrmBean.getShrYmd(), BizDate.getSysDate().addBusinessDays(1), "支払伝票日付");
        exClassificationEquals(siHkkSsnPrmBean.getKykTuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(siHkkSsnPrmBean.getShrTuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoHokenKngk(), BizCurrency.valueOf(27000000L, BizCurrencyTypes.YEN), "（分割後）保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円換算保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getHokenkinsyuruiKbn(), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exStringEquals(siHkkSsnPrmBean.getHokenkinsyurui(), "死亡保険金", "保険金種類");
        exClassificationEquals(siHkkSsnPrmBean.getHknKknKbn(), C_HknKknKbn.BLNK, "保険期間区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getKihonHokenKngk(), BizCurrency.valueOf(21000000L, BizCurrencyTypes.YEN), "基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenKihonHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算基本保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSbHokenKngk(), BizCurrency.valueOf(25000000L, BizCurrencyTypes.YEN), "死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSbHokenKngk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算死亡保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "災害保険金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenSaigaiS(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算災害保険金額");
        exClassificationEquals(siHkkSsnPrmBean.getSykSbYenSitiHsyuTkTekiUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約適用有無");
        exBizCalcbleEquals(siHkkSsnPrmBean.getInitSbjiYenkasSiteiHsygk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "初期死亡時円換算最低保証額");
        exClassificationEquals(siHkkSsnPrmBean.getUktKyksyaTdk(), C_UktKyksyaTdk.KYKHNN, "受取人契約者続柄");
        exDateEquals(siHkkSsnPrmBean.getZeimukwsratekjnymd(), null, "税務用為替レート基準日");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimukwsrate(), BizNumber.valueOf(0), "税務用為替レート");
        exBizCalcbleEquals(siHkkSsnPrmBean.getZeimuYenHokenknGk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税務用円換算保険金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkwsrate(), BizNumber.valueOf(0), "外貨換算為替レート");

        exClassificationEquals(siHkkSsnPrmBean.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "（配当金情報）内定確定区分");
        exBizCalcbleEquals(siHkkSsnPrmBean.getHaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他配当金");

        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuuy(), 0, "未収保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMisyuupjyuutoukaisuum(), 6, "未収保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMisyuupjyuutouym(), BizDateYM.valueOf("201907"), "未収保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMisyuup(), BizCurrency.valueOf(60000L, BizCurrencyTypes.YEN), "未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未収保険料");

        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuuy(), 0, "未経過保険料充当回数（年）");
        exNumericEquals(siHkkSsnPrmBean.getMikeikapjyuutoukaisuum(), 2, "未経過保険料充当回数（月）");
        exDateYMEquals(siHkkSsnPrmBean.getMikeikapjyuutouym(), BizDateYM.valueOf("201911"), "未経過保険料充当年月");
        exBizCalcbleEquals(siHkkSsnPrmBean.getMikeikap(), BizCurrency.valueOf(20000L, BizCurrencyTypes.YEN), "未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨未経過保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getAzukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenzitkazukarikingksttk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円換算税適預り金額（指定通貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "税適預り金額（円貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnzitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getSonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "その他精算額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkasonotaseisangk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨その他精算額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getKrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getShrgkkei(), BizCurrency.valueOf(26962051L, BizCurrencyTypes.YEN), "支払額合計");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkashrgkgoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨支払額合計");

        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getYenkaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "円貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugohaitoukin(), BizCurrency.valueOf(1001, BizCurrencyTypes.YEN), "（分割後）配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugosonotahaitoukin(), BizCurrency.valueOf(1050, BizCurrencyTypes.YEN), "（分割後）その他配当金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkasonotahaitoukin(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨その他配当金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomisyuup(), BizCurrency.valueOf(60000L, BizCurrencyTypes.YEN), "（分割後）未収保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamisyuup(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugomikeikap(), BizCurrency.valueOf(20000L, BizCurrencyTypes.YEN), "（分割後）未経過保険料");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkamikeikap(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨未収保険料");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugozennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）前納精算金");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkazennouseisank(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨前納精算金");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingksiteituuka(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（指定通貨）");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoZitkazukarikingkyen(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）税適預り金額（円貨）");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）預り金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkaazukarikingk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨預り金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugokrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）仮受金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkakrkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）円貨仮受金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugogoukeigk(), BizCurrency.valueOf(26962051L, BizCurrencyTypes.YEN), "（分割後）合計金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoyenkagoukeigk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨合計金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsntskgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoGaikaknsnkkkgk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（分割後）外貨換算結果金額");

        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsntskgk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨換算対象金額");
        exBizCalcbleEquals(siHkkSsnPrmBean.getBunkatugoYenkaknsnkkkgk(), BizCurrency.valueOf(26960000L, BizCurrencyTypes.YEN), "（分割後）円貨換算結果金額");

    }


    @Test
    @TestOrder(1010)
    public void testExec_D1_1() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN2;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1034", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");

    }


    @Test
    @TestOrder(1020)
    public void testExec_D1_2() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1044", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");

    }

    @Test
    @TestOrder(1030)
    public void testExec_D1_3() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN7;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Yen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZA);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1044", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");

    }


    @Test
    @TestOrder(1040)
    public void testExec_D1_4() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setUktMnmeigiBangou(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 12, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(6), "WBF0162", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(7), "受取人ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(8), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(9), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(10), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(11), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1050)
    public void testExec_D1_5() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.SONOTA);
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setKykMnmeigiBango(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WBF0162", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1060)
    public void testExec_D1_6() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN7;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Yen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setUktMnmeigiBangou(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 12, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(6), "WBF0162", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(7), "受取人ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(8), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(9), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(10), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(11), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1070)
    public void testExec_D1_7() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN7;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Yen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.SONOTA);
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setKykMnmeigiBango(null);

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WBF0162", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1080)
    public void testExec_D1_8() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN11;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 12, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(6), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(7), "受取人ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(8), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(9), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(10), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(11), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1090)
    public void testExec_D1_9() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN12;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Yen();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.KYKDAIRININ);
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 12, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "契約者ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(6), "WJA1036", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(7), "受取人ＭＮ名義番号", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(8), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(9), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(10), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(11), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }


    @Test
    @TestOrder(1100)
    public void testExec_D1_10() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN11;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.TETUDUKI_SATEIHUYOU);
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setKykMnmeigiBango(null);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.getSiKykKihon().setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
        siShrKngkKeisanBean.getSiKykKihon().setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(2000000, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1054", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }

    @Test
    @TestOrder(1110)
    public void testExec_D1_11() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN4;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN4;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Saisatei();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.SAISATEI);
        siShrKngkKeisanBean.setKykMnmeigiBango(null);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.getSiKykKihon().setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
        siShrKngkKeisanBean.getSiKykKihon().setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(3000000000L, BizCurrencyTypes.YEN));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 12, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1054", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(6), "WJA1055", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(7), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(8), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(9), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(10), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(11), "", "警告メッセージ[5]");
        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.WARNING, "支払金額計算後チェック結果区分");
    }


    @Test
    @TestOrder(1120)
    public void testExec_D1_12() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN4;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN4;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;

        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2Saisatei();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.SAISATEI);
        siShrKngkKeisanBean.setSyoNo("20808000093");
        siShrKngkKeisanBean.getSiKykKihon().setSyono("20808000093");
        siShrKngkKeisanBean.getSiKykKihon().getSiKykSyouhns().get(0).setSyono("20808000093");
        siShrKngkKeisanBean.getSiKykKihon().getSiUkts().get(0).setSyono("20808000093");

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 0, "支払金額計算結果エラーメッセージ件数");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 6, "支払金額計算結果警告メッセージ件数");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(0), "WJA1055", "警告メッセージ[0]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(1), "", "警告メッセージ[1]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(2), "", "警告メッセージ[2]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(3), "", "警告メッセージ[3]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(4), "", "警告メッセージ[4]");
        exStringEquals(siShrKngkKeisan.getWarnMsg().get(5), "", "警告メッセージ[5]");
    }


    @Test
    @TestOrder(1200)
    public void testExec_D1_20() {
        testClear();
        KeisanTienrisokuMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanTienrisokuMockForSiharai.SYORIPTN = KeisanTienrisokuMockForSiharai.TESTPATTERN1;
        ChkSubSknnKaisiYmdMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        ChkSubSknnKaisiYmdMockForSiharai.SYORIPTN = ChkSubSknnKaisiYmdMockForSiharai.TESTPATTERN1;
        CalcHkShrKngkMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkShrKngkMockForSiharai.SYORIPTN = CalcHkShrKngkMockForSiharai.TESTPATTERN3;
        KeisanDCommonSibouMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        KeisanDCommonSibouMockForSiharai.SYORIPTN = KeisanDCommonSibouMockForSiharai.TESTPATTERN3;
        CalcHkHtykeihiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        CalcHkHtykeihiMockForSiharai.SYORIPTN = CalcHkHtykeihiMockForSiharai.TESTPATTERN2;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.caller = SiSiharaiKingakuKeisanTest_exec.class;
        SiSKNaiyouChkkekkaSetteiMockForSiharai.SYORIPTN = SiSKNaiyouChkkekkaSetteiMockForSiharai.TESTPATTERN9;


        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = setCommonValueForTestK2();
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));

        C_ErrorKbn errorKbn = siShrKngkKeisan.exec(siShrKngkKeisanBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");

        exNumericEquals(siShrKngkKeisan.getErrMsg().size(), 1, "支払金額計算結果エラーメッセージ件数");
        Message msg0 = siShrKngkKeisan.getErrMsg().getMessages().get(0);
        exStringEquals(msg0.getMessageId(), "EXX9999", "メッセージＩＤ");
        exNumericEquals(siShrKngkKeisan.getWarnMsg().size(), 0, "支払金額計算結果警告メッセージ件数");

        exClassificationEquals(siShrKngkKeisan.getCSKNaiyouChkkekkaKbn(), C_SKNaiyouChkkekkaKbn.ERROR, "支払金額計算後チェック結果区分");

    }

    private SiSiharaiKingakuKeisanBean setCommonValueForTestKawaseRate() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.BLNK);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.ARI);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(1111111111111L, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(77777777777L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(55555555555L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("商品名（画面用）２－６");
        siKykSyouhn.setSyouhnnmtyhy("商品名（帳票用）２－６");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }

    private SiSiharaiKingakuKeisanBean setCommonValueForTestK2() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhn.setSyouhnnmtyhy("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }

    private SiSiharaiKingakuKeisanBean setCommonValueForTestK2Saisatei() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000071");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SG);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.SAISATEI);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000071");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000071");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(18000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(17000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhn.setSyouhnnmtyhy("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000071");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }


    private SiSiharaiKingakuKeisanBean setCommonValueForTestK2Yen() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.YEN;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕA");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        siKykSyouhn.setSyouhnnmgm("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhn.setSyouhnnmtyhy("５年ごと利差配当付指定通貨建終身保険（一時払い）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }


    private SiSiharaiKingakuKeisanBean setCommonValueForTestCascade() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕｹ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20180901"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20180820"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）");
        siKykSyouhn.setSyouhnnmtyhy("５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }



    private SiSiharaiKingakuKeisanBean setCommonValueForTestDuo() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕﾁ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20180901"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20180820"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）");
        siKykSyouhn.setSyouhnnmtyhy("予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }


    private SiSiharaiKingakuKeisanBean setCommonValueForTestCascadeYen() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.YEN;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾕB");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20150206"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        siKykSyouhn.setSyouhnnmgm("５年ごと利差配当付指定通貨建個人年金保険（一時払い）");
        siKykSyouhn.setSyouhnnmtyhy("５年ごと利差配当付指定通貨建個人年金保険（一時払い）");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }

    private SiSiharaiKingakuKeisanBean setCommonValueForTestBorelo() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.DOLLAR;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾆｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20180901"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20180820"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        siKykSyouhn.setSyouhnnmgm("低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険");
        siKykSyouhn.setSyouhnnmtyhy("低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }

    private SiSiharaiKingakuKeisanBean setCommonValueForTestBoreloYen() {
        SiSiharaiKingakuKeisanBean siShrKngkKeisanBean = SWAKInjector.getInstance(SiSiharaiKingakuKeisanBean.class);

        CurrencyType currencyType = BizCurrencyTypes.YEN;
        siShrKngkKeisanBean.setSyoNo("20808000060");
        siShrKngkKeisanBean.setSeikyuuSyubetu(C_SeikyuuSyubetu.SB);
        siShrKngkKeisanBean.setCalcKijyunYmd(BizDate.valueOf("20190609"));
        siShrKngkKeisanBean.setKnsnKijyunYmd(null);
        siShrKngkKeisanBean.setKawaseRate(BizNumber.optional());
        siShrKngkKeisanBean.setUktBnWari(BizNumber.valueOf(100.00));
        siShrKngkKeisanBean.setHasuuKasanHyouji(C_HasuukasanUmuKbn.HASUUKASANNASI);
        siShrKngkKeisanBean.setInputShrhouSiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siShrKngkKeisanBean.setSyoruiUkeYmd(BizDate.valueOf("20190611"));
        siShrKngkKeisanBean.setHubiKanryouYmd(null);
        siShrKngkKeisanBean.setRikoukiTyuutuudanNissuu(0);
        siShrKngkKeisanBean.setSinsaGendoKknKbn(C_SinsaGendoKknKbn.BD5);
        siShrKngkKeisanBean.setSUketoriHouhouKbn(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN);
        siShrKngkKeisanBean.setSiharaiTuukaKbn(C_SiharaiTuukaKbn.YENSIHARAI);
        siShrKngkKeisanBean.setNkShrTkykNksyuKbn(C_Nstknsyu.KAKUTEINENKIN);
        siShrKngkKeisanBean.setNkShrTkykNksyuKkn(0);
        siShrKngkKeisanBean.setBnShrKaisuu(C_Bnshrkaisuu.BLNK);
        siShrKngkKeisanBean.setNkKknJyutouGk(BizCurrency.valueOf(0, currencyType));
        siShrKngkKeisanBean.setNkHaitoukinuketorihouKbn(C_NkHaitoukinuketorihouKbn.NONE);
        siShrKngkKeisanBean.setSiHonninKakninKbn(C_SiHonninKakninKekkaKbn.KOUZASYORUI);
        siShrKngkKeisanBean.setKeisanKahiKbn(C_KahiKbn.KA);
        siShrKngkKeisanBean.setYobidasimotoKinouId("sisateisb");
        siShrKngkKeisanBean.setSikinouModeIdKbn(C_SikinouModeIdKbn.SATEI1);
        siShrKngkKeisanBean.setSiinKbn(C_SiinKbn.SP);
        siShrKngkKeisanBean.setSaisateiKbn(C_SaisateiKbn.BLNK);
        siShrKngkKeisanBean.setUktMnmeigiBangou("001");
        siShrKngkKeisanBean.setKykMnmeigiBango("001");
        siShrKngkKeisanBean.setBankCd("0009");
        siShrKngkKeisanBean.setKaiyakusjkkktyouseirirituUmKbn(C_UmuKbn.NONE);
        siShrKngkKeisanBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0));
        siShrKngkKeisanBean.setSeikyuusyaKbn(C_SeikyuusyaKbn.UKTHONNIN);
        siShrKngkKeisanBean.setGaikaknsnKwsrate(BizNumber.optional());
        siShrKngkKeisanBean.setSyoriYmd(null);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("20808000060");
        siKykKihon.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siKykKihon.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);
        siKykKihon.setSbuktnin(1);
        siKykKihon.setHksknnkaisiymd(null);
        siKykKihon.setInitsbjiyensitihsytkhukaumu(C_UmuKbn.NONE);
        siKykKihon.setInitsbjiyenkasaiteihsygk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        siKykKihon.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        List<JT_SiKykSyouhn> siKykSyouhnList = new ArrayList<>();
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSyono("20808000060");
        siKykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
        siKykSyouhn.setSyouhncd("ﾆｱ");
        siKykSyouhn.setKyhgndkatakbn(C_KyhgndkataKbn.BLNK);
        siKykSyouhn.setSyouhnsdno(1);
        siKykSyouhn.setKyksyouhnrenno(11);
        siKykSyouhn.setRyouritusdno("206");
        siKykSyouhn.setYoteiriritu(BizNumber.valueOf(0.2061));
        siKykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        siKykSyouhn.setHknkkn(22);
        siKykSyouhn.setHrkkkn(33);
        siKykSyouhn.setHhknnen(44);
        siKykSyouhn.setHhknsei(C_Hhknsei.MALE);
        siKykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(2.0601));
        siKykSyouhn.setKihons(BizCurrency.valueOf(11000000L, currencyType));
        siKykSyouhn.setHokenryou(BizCurrency.valueOf(14000000L, currencyType));
        siKykSyouhn.setKykymd(BizDate.valueOf("20180901"));
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf("20180820"));
        siKykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        siKykSyouhn.setSyouhnnmgm("低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険");
        siKykSyouhn.setSyouhnnmtyhy("低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険");
        siKykSyouhnList.add(siKykSyouhn);
        siKykKihon.setSiKykSyouhns(siKykSyouhnList);
        List<JT_SiUkt> siUktList = new ArrayList<>();
        JT_SiUkt siUkt = new JT_SiUkt();
        siUkt.setSyono("20808000060");
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktsyurenno(1);
        siUkt.setUktkbn(C_UktKbn.KYK);
        siUktList.add(siUkt);
        siKykKihon.setSiUkts(siUktList);
        siShrKngkKeisanBean.setSiKykKihon(siKykKihon);

        return siShrKngkKeisanBean;
    }

}