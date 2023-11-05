package yuyu.app.bosyuu.hbsekmos.hbseihowebsekmos;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutoku;
import yuyu.common.biz.bzdairiten.DairitenTesuuryouInfoSyutokuMockForSinkeiyaku;
import yuyu.common.biz.bzdairiten.DairitenTsrSyutokuYokenBean;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.KeisanPJyuutougk;
import yuyu.common.hozen.khcommon.KeisanPJyuutougkMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckSP;
import yuyu.common.sinkeiyaku.moschk.CheckSPMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusan;
import yuyu.common.sinkeiyaku.moschk.CheckSkTuusanMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhin;
import yuyu.common.sinkeiyaku.moschk.CheckTblMosSyouhinMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheck;
import yuyu.common.sinkeiyaku.moschk.SeihowebMosnaiCheckMockForSinkeiyaku;
import yuyu.common.sinkeiyaku.moschk.SetSP;
import yuyu.common.sinkeiyaku.moschk.SetSPMockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebSekMosOutputBean;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KzktourokuserviceTourokuKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TumitatekinHaibunWariKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ設計書申込書作成のメイン処理{@link HbSeihoWebSekMosImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings("unchecked")
public class HbSeihoWebSekMosTest_execPostForm2 extends AbstractTest {

    @Inject
    private HbSeihoWebSekMosImpl hbSeihoWebSekMosImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ設計書申込書作成";

    private final static String sheetName = "INデータ";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(SeihowebMosnaiCheck.class).to(SeihowebMosnaiCheckMockForSinkeiyaku.class);
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(DairitenTesuuryouInfoSyutoku.class).to(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class);
                bind(CheckTblMosSyouhin.class).to(CheckTblMosSyouhinMockForSinkeiyaku.class);
                bind(SetSP.class).to(SetSPMockForSinkeiyaku.class);
                bind(CheckSP.class).to(CheckSPMockForSinkeiyaku.class);
                bind(CheckSkTuusan.class).to(CheckSkTuusanMockForSinkeiyaku.class);
                bind(KeisanPJyuutougk.class).to(KeisanPJyuutougkMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebSekMosTest_execPostForm2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {

        SeihowebMosnaiCheckMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        SetSPMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        CheckSPMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        CheckSkTuusanMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
        KeisanPJyuutougkMockForSinkeiyaku.caller = HbSeihoWebSekMosTest_execPostForm2.class;
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebSekMosTest_execPostForm2.class, fileName, requestSheetName);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu());
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.caller = null;
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = null;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.caller = null;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = null;
        CheckTblMosSyouhinMockForSinkeiyaku.caller = null;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = null;
        SetSPMockForSinkeiyaku.caller = null;
        SetSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSPMockForSinkeiyaku.caller = null;
        CheckSPMockForSinkeiyaku.SYORIPTN = null;
        CheckSkTuusanMockForSinkeiyaku.caller = null;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = null;
        KeisanPJyuutougkMockForSinkeiyaku.caller = null;
        KeisanPJyuutougkMockForSinkeiyaku.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(0),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(0),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨試算基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MockObjectManager
        .assertArgumentPassed(HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "convAddressToDairiten", 1, "1200399");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "111AAbb", "設計書申込書作成親代理店コード");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exDateEquals(mosKihon.getMosymd(), BizDate.valueOf("20180101"), "申込日");
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.BLNK, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getSyksbyensitihsyutkhkkbn(), C_Tkhukaumu.NONE, "初期死亡時円換算最低保証特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.NONE, "重度介護前払特約付加区分");
        exClassificationEquals(mosKihon.getTeirituhaibunwarikbn(), C_TumitatekinHaibunWariKbn.BLNK, "定率部分配分割合区分");
        exClassificationEquals(mosKihon.getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(mosKihon.getSisuuhaibunwarikbn(), C_TumitatekinHaibunWariKbn.BLNK, "指数部分配分割合区分");
        exClassificationEquals(mosKihon.getTrhkjikakkbn(), C_TrhkjiKakKbn.KAKUNINZUMI, "取引時確認区分");
        exClassificationEquals(mosKihon.getKzktourokuservicetourokukbn(), C_KzktourokuserviceTourokuKbn.ARI, "ご家族登録サービス登録区分");
        exClassificationEquals(mosKihon.getKykdrtkykhukakbn(), C_Tkhukaumu.HUKA, "契約者代理特約付加区分");
        exClassificationEquals(mosKihon.getStdrsktkyhkkbn(), C_Tkhukaumu.HUKA, "被保険者代理特約付加区分");
        exClassificationEquals(mosKihon.getFstphrkkeirokbn(), C_FstphrkkeiroKbn.HURIKOMI, "初回保険料払込経路区分");
        exClassificationEquals(mosKihon.getHknsyuruino(), C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_19_SGARI, "保険種類番号");
        exClassificationEquals(mosKihon.getTeikisiharaitkykhkkbn(), C_Tkhukaumu.HUKA, "定期支払特約付加区分");

        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 7, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 2, "受取人種類別連番");
        HT_Uketorinin uketorinin4 = uketorinins.get(3);
        exClassificationEquals(uketorinin4.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin4.getUktsyurenno(), 2, "受取人種類別連番");
        exClassificationEquals(uketorinin4.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        HT_Uketorinin uketorinin5 = uketorinins.get(4);
        exClassificationEquals(uketorinin5.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin5.getUktsyurenno(), 3, "受取人種類別連番");
        exClassificationEquals(uketorinin5.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin5.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin5.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin5.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin5.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin5.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        exBizCalcbleEquals(uketorinin5.getUktbnwari(), BizNumber.valueOf(0), "受取人分割割合");
        exClassificationEquals(uketorinin5.getUkttsindousiteikbn(), C_TsindousiteiKbn.BLNK, "受取人通信先同一指定区分");
        exStringEquals(uketorinin5.getUktyno(), "", "受取人郵便番号");
        exStringEquals(uketorinin5.getUktadr1kj(), "", "受取人住所１（漢字）");
        exStringEquals(uketorinin5.getUktadr2kj(), "", "受取人住所２（漢字）");
        exStringEquals(uketorinin5.getUktadr3kj(), "", "受取人住所３（漢字）");
        exStringEquals(uketorinin5.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(uketorinin5.getGyoumuKousinTime(), "", "業務用更新時間");
        HT_Uketorinin uketorinin6 = uketorinins.get(5);
        exClassificationEquals(uketorinin6.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin6.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin6.getUktkbn(), C_UktKbn.TOUROKUKAZOKU1, "受取人区分");
        exStringEquals(uketorinin6.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin6.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin6.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin6.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin6.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        exBizCalcbleEquals(uketorinin6.getUktbnwari(), BizNumber.valueOf(0), "受取人分割割合");
        exClassificationEquals(uketorinin6.getUkttsindousiteikbn(), C_TsindousiteiKbn.BLNK, "受取人通信先同一指定区分");
        exStringEquals(uketorinin6.getUktyno(), "", "受取人郵便番号");
        exStringEquals(uketorinin6.getUktadr1kj(), "", "受取人住所１（漢字）");
        exStringEquals(uketorinin6.getUktadr2kj(), "", "受取人住所２（漢字）");
        exStringEquals(uketorinin6.getUktadr3kj(), "", "受取人住所３（漢字）");
        exStringEquals(uketorinin6.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(uketorinin6.getGyoumuKousinTime(), "", "業務用更新時間");
        HT_Uketorinin uketorinin7 = uketorinins.get(6);
        exClassificationEquals(uketorinin7.getUktsyukbn(), C_UktsyuKbn.KYKDRN, "受取人種類区分");
        exNumericEquals(uketorinin7.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin7.getUktkbn(), C_UktKbn.TOUROKUKAZOKU1, "受取人区分");
        exClassificationEquals(uketorinin7.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        exStringEquals(uketorinin7.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin7.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin7.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exBizCalcbleEquals(uketorinin7.getUktbnwari(), BizNumber.valueOf(0), "受取人分割割合");
        exDateEquals(uketorinin7.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin7.getUkttsindousiteikbn(), C_TsindousiteiKbn.BLNK, "受取人通信先同一指定区分");
        exStringEquals(uketorinin7.getUktyno(), "", "受取人郵便番号");
        exStringEquals(uketorinin7.getUktadr1kj(), "", "受取人住所１（漢字）");
        exStringEquals(uketorinin7.getUktadr2kj(), "", "受取人住所２（漢字）");
        exStringEquals(uketorinin7.getUktadr3kj(), "", "受取人住所３（漢字）");
        exStringEquals(uketorinin7.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(uketorinin7.getGyoumuKousinTime(), "", "業務用更新時間");

        HT_MosSyouhn mosSyouhn = mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0);
        exClassificationEquals(mosSyouhn.getSknenkinsyu(), C_Sknenkinsyu.KKTI10, "新契約年金種類");
        exNumericEquals(mosSyouhn.getHknkkn(), 10, "保険期間");

        List<HT_MosTrkKzk> mosTrkKzks = mosnaiCheckParam.getDataSyoriControl().getMosTrkKzks();
        exNumericEquals(mosTrkKzks.size(), 2, "申込登録家族テーブルリストのサイズ");
        HT_MosTrkKzk mosTrkKzk1 = mosTrkKzks.get(0);
        exClassificationEquals(mosTrkKzk1.getTrkkzkkbn(), C_TrkKzkKbn.TRKKZK1, "登録家族区分");
        exStringEquals(mosTrkKzk1.getTrkkzknmkn(), "カナナナナナカナナナナナカナナナナカ", "登録家族名（カナ）");
        exStringEquals(mosTrkKzk1.getTrkkzknmkj(), "家族漢字氏名名名名名漢", "登録家族名（漢字）");
        exClassificationEquals(mosTrkKzk1.getTrkkzknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "登録家族名漢字化不可区分");
        exClassificationEquals(mosTrkKzk1.getTrkkzksei(), C_Seibetu.MALE, "登録家族性別");
        exClassificationEquals(mosTrkKzk1.getTrkkzktdk(), C_Tdk.HGU, "登録家族続柄");
        exStringEquals(mosTrkKzk1.getTrkkzkyno(), "1001000", "登録家族郵便番号");
        exStringEquals(mosTrkKzk1.getTrkkzkadr1kj(), "家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１", "登録家族住所１（漢字）");
        exStringEquals(mosTrkKzk1.getTrkkzkadr2kj(), "家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３", "登録家族住所２（漢字）");
        exStringEquals(mosTrkKzk1.getTrkkzkadr3kj(), "住住", "登録家族住所３（漢字）");
        exDateEquals(mosTrkKzk1.getTrkkzkseiymd(), BizDate.valueOf(20160808), "登録家族生年月日");
        exClassificationEquals(mosTrkKzk1.getTrkkzktsindousiteikbn(), C_TsindousiteiKbn.BLNK, "登録家族通信先同一指定区分");
        exStringEquals(mosTrkKzk1.getTrkkzktelno(), "", "登録家族電話番号");
        exStringEquals(mosTrkKzk1.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(mosTrkKzk1.getGyoumuKousinTime(), "", "業務用更新時間");

        HT_MosTrkKzk mosTrkKzk2 = mosTrkKzks.get(1);
        exClassificationEquals(mosTrkKzk2.getTrkkzkkbn(), C_TrkKzkKbn.TRKKZK2, "登録家族区分");
        exStringEquals(mosTrkKzk2.getTrkkzknmkn(), "カナナナナナカナナナナナカナナナカカ", "登録家族名（カナ）");
        exStringEquals(mosTrkKzk2.getTrkkzknmkj(), "家族漢字氏名名名名漢漢", "登録家族名（漢字）");
        exClassificationEquals(mosTrkKzk2.getTrkkzknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "登録家族名漢字化不可区分");
        exClassificationEquals(mosTrkKzk2.getTrkkzksei(), C_Seibetu.FEMALE, "登録家族性別");
        exClassificationEquals(mosTrkKzk2.getTrkkzktdk(), C_Tdk.KO, "登録家族続柄");
        exStringEquals(mosTrkKzk2.getTrkkzkyno(), "2002000", "登録家族郵便番号");
        exStringEquals(mosTrkKzk2.getTrkkzkadr1kj(), "家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２", "登録家族住所１（漢字）");
        exStringEquals(mosTrkKzk2.getTrkkzkadr2kj(), "家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４", "登録家族住所２（漢字）");
        exStringEquals(mosTrkKzk2.getTrkkzkadr3kj(), "所所", "登録家族住所３（漢字）");
        exDateEquals(mosTrkKzk2.getTrkkzkseiymd(), BizDate.valueOf(20160909), "登録家族生年月日");
        exClassificationEquals(mosTrkKzk2.getTrkkzktsindousiteikbn(), C_TsindousiteiKbn.BLNK, "登録家族通信先同一指定区分");
        exStringEquals(mosTrkKzk2.getTrkkzktelno(), "", "登録家族電話番号");
        exStringEquals(mosTrkKzk2.getGyoumuKousinsyaId(), "", "業務用更新者ＩＤ");
        exStringEquals(mosTrkKzk2.getGyoumuKousinTime(), "", "業務用更新時間");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 0)
            , "カ　カナカナカナカナカナカナカナカナ", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 1)
            , C_Kojinhjn.KOJIN, "個人法人区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 0)
            , "ホケ　ホケンホケンホケンホケンホケン", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 1)
            , C_Kojinhjn.HJN, "個人法人区分");

        exStringEquals((String) MockObjectManager.getArgument(HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "convDairiten", 0, 1)
            , "0000000", "変換前代理店コード");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(0),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(0),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsRendouritu(), BizNumber.valueOf(300),
            "（ＩＷＳ）連動率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikateikisiharaigk(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨定期支払金額");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class, "exec", 0);
        exClassificationEquals(dairitenTsrSyutokuYokenBean.getHrktuukasyu(), C_Tuukasyu.USD, "払込通貨種類");
        exBizCalcbleEquals(dairitenTsrSyutokuYokenBean.getSyupHrktuuka(),
            BizCurrency.valueOf(12309876543.21, BizCurrencyTypes.DOLLAR),
            "主契約Ｐ（払込通貨）");
        exBizCalcbleEquals(dairitenTsrSyutokuYokenBean.getYenKnsnTekiRate(), BizNumber.valueOf(500.01), "円換算適用レート");
        MockObjectManager
        .assertArgumentPassed(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class, "exec", 1, null);

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "9408108", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.HUKA, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.BLNK, "重度介護前払特約付加区分");
        exClassificationEquals(mosKihon.getKzktourokuservicetourokukbn(), C_KzktourokuserviceTourokuKbn.ARI, "ご家族登録サービス登録区分");
        exClassificationEquals(mosKihon.getKykdrtkykhukakbn(), C_Tkhukaumu.HUKA, "契約者代理特約付加区分");
        exClassificationEquals(mosKihon.getStdrsktkyhkkbn(), C_Tkhukaumu.BLNK, "被保険者代理特約付加区分");
        exClassificationEquals(mosKihon.getFstphrkkeirokbn(), C_FstphrkkeiroKbn.HURIKOMI, "初回保険料払込経路区分");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 5, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 2, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin4 = uketorinins.get(3);
        exClassificationEquals(uketorinin4.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin4.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin4.getUktkbn(), C_UktKbn.TOUROKUKAZOKU2, "受取人区分");
        exStringEquals(uketorinin4.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin4.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin4.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin4.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin4.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin5 = uketorinins.get(4);
        exClassificationEquals(uketorinin5.getUktsyukbn(), C_UktsyuKbn.KYKDRN, "受取人種類区分");
        exNumericEquals(uketorinin5.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin5.getUktkbn(), C_UktKbn.TOUROKUKAZOKU2, "受取人区分");
        exClassificationEquals(uketorinin5.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");

        HT_MosSyouhn mosSyouhn = mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getRendouritu(), BizNumber.valueOf(0.030), "連動率");
        exBizCalcbleEquals(mosSyouhn.getTeikisiharaikin(), BizCurrency.valueOf(310, BizCurrencyTypes.DOLLAR), "定期支払金");

        List<HT_MosTrkKzk> mosTrkKzks = mosnaiCheckParam.getDataSyoriControl().getMosTrkKzks();
        exNumericEquals(mosTrkKzks.size(), 2, "申込登録家族テーブルリストのサイズ");
        HT_MosTrkKzk mosTrkKzk1 = mosTrkKzks.get(0);
        exClassificationEquals(mosTrkKzk1.getTrkkzkkbn(), C_TrkKzkKbn.TRKKZK1, "登録家族区分");
        exStringEquals(mosTrkKzk1.getTrkkzknmkn(), "カナナナナナカナナナナナカナナナナカ", "登録家族名（カナ）");
        exStringEquals(mosTrkKzk1.getTrkkzknmkj(), "家族漢字氏名名名名名漢", "登録家族名（漢字）");
        exClassificationEquals(mosTrkKzk1.getTrkkzknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "登録家族名漢字化不可区分");
        exClassificationEquals(mosTrkKzk1.getTrkkzksei(), C_Seibetu.MALE, "登録家族性別");
        exClassificationEquals(mosTrkKzk1.getTrkkzktdk(), C_Tdk.HGU, "登録家族続柄");
        exStringEquals(mosTrkKzk1.getTrkkzkyno(), "1001000", "登録家族郵便番号");
        exStringEquals(mosTrkKzk1.getTrkkzkadr1kj(), "家族住所１家族住所１家族住所１家族住所１家族住所１家族住所１", "登録家族住所１（漢字）");
        exStringEquals(mosTrkKzk1.getTrkkzkadr2kj(), "家族住所３家族住所３家族住所３家族住所３家族住所３家族住所３", "登録家族住所２（漢字）");
        exStringEquals(mosTrkKzk1.getTrkkzkadr3kj(), "住住", "登録家族住所３（漢字）");
        exDateEquals(mosTrkKzk1.getTrkkzkseiymd(), null, "登録家族生年月日");
        HT_MosTrkKzk mosTrkKzk2 = mosTrkKzks.get(1);
        exClassificationEquals(mosTrkKzk2.getTrkkzkkbn(), C_TrkKzkKbn.TRKKZK2, "登録家族区分");
        exStringEquals(mosTrkKzk2.getTrkkzknmkn(), "カナナナナナカナナナナナカナナナカカ", "登録家族名（カナ）");
        exStringEquals(mosTrkKzk2.getTrkkzknmkj(), "家族漢字氏名名名名漢漢", "登録家族名（漢字）");
        exClassificationEquals(mosTrkKzk2.getTrkkzknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "登録家族名漢字化不可区分");
        exClassificationEquals(mosTrkKzk2.getTrkkzksei(), C_Seibetu.FEMALE, "登録家族性別");
        exClassificationEquals(mosTrkKzk2.getTrkkzktdk(), C_Tdk.KO, "登録家族続柄");
        exStringEquals(mosTrkKzk2.getTrkkzkyno(), "2002000", "登録家族郵便番号");
        exStringEquals(mosTrkKzk2.getTrkkzkadr1kj(), "家族住所２家族住所２家族住所２家族住所２家族住所２家族住所２", "登録家族住所１（漢字）");
        exStringEquals(mosTrkKzk2.getTrkkzkadr2kj(), "家族住所４家族住所４家族住所４家族住所４家族住所４家族住所４", "登録家族住所２（漢字）");
        exStringEquals(mosTrkKzk2.getTrkkzkadr3kj(), "所所", "登録家族住所３（漢字）");
        exDateEquals(mosTrkKzk2.getTrkkzkseiymd(), null, "登録家族生年月日");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsRendouritu(), BizNumber.valueOf(300),
            "（ＩＷＳ）連動率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikateikisiharaigk(), BizNumber.valueOf(31000),
            "（ＩＷＳ）外貨定期支払金額");

        DairitenTsrSyutokuYokenBean dairitenTsrSyutokuYokenBean = (DairitenTsrSyutokuYokenBean) MockObjectManager
            .getArgument(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class, "exec", 0, 0);
        exBizCalcbleEquals(dairitenTsrSyutokuYokenBean.getYenKnsnTekiRate(), BizNumber.valueOf(500.01), "円換算適用レート");
        MockObjectManager
        .assertArgumentPassed(DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.class, "exec", 1, null);

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getKzktourokuservicetourokukbn(), C_KzktourokuserviceTourokuKbn.ARI, "ご家族登録サービス登録区分");
        exClassificationEquals(mosKihon.getKykdrtkykhukakbn(), C_Tkhukaumu.BLNK, "契約者代理特約付加区分");
        exClassificationEquals(mosKihon.getStdrsktkyhkkbn(), C_Tkhukaumu.HUKA, "被保険者代理特約付加区分");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 3, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");

        HT_MosSyouhn mosSyouhn = mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0);
        exBizCalcbleEquals(mosSyouhn.getRendouritu(), BizNumber.valueOf(0.030), "連動率");
        exBizCalcbleEquals(mosSyouhn.getTeikisiharaikin(), BizCurrency.valueOf(310, BizCurrencyTypes.DOLLAR), "定期支払金");

        List<HT_MosTrkKzk> mosTrkKzks = mosnaiCheckParam.getDataSyoriControl().getMosTrkKzks();
        exNumericEquals(mosTrkKzks.size(), 0, "申込登録家族テーブルリストのサイズ");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "親代理店コードエラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(1),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(5000),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(),
            BizNumber.valueOf(new BigDecimal("9999999999999")),
            "（ＩＷＳ）外貨試算基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5102152", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.NONE, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");
        exClassificationEquals(mosKihon.getKzktourokuservicetourokukbn(), C_KzktourokuserviceTourokuKbn.NONE, "ご家族登録サービス登録区分");
        exClassificationEquals(mosKihon.getKykdrtkykhukakbn(), C_Tkhukaumu.BLNK, "契約者代理特約付加区分");
        exClassificationEquals(mosKihon.getStdrsktkyhkkbn(), C_Tkhukaumu.BLNK, "被保険者代理特約付加区分");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 4, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 2, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), BizDate.valueOf(20160707), "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin4 = uketorinins.get(3);
        exClassificationEquals(uketorinin4.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin4.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin4.getUktkbn(), C_UktKbn.SBUK, "受取人区分");
        exStringEquals(uketorinin4.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin4.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin4.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin4.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin4.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");

        List<HT_MosTrkKzk> mosTrkKzks = mosnaiCheckParam.getDataSyoriControl().getMosTrkKzks();
        exNumericEquals(mosTrkKzks.size(), 0, "申込登録家族テーブルリストのサイズ");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A6"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171215"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 6, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 2, "受取人種類別連番");
        HT_Uketorinin uketorinin4 = uketorinins.get(3);
        exClassificationEquals(uketorinin4.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin4.getUktsyurenno(), 3, "受取人種類別連番");
        HT_Uketorinin uketorinin5 = uketorinins.get(4);
        exClassificationEquals(uketorinin5.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin5.getUktsyurenno(), 4, "受取人種類別連番");
        exClassificationEquals(uketorinin5.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin5.getUktnmkn(), "カカナナナナカナナナナナカナナナナナ", "受取人名（カナ）");
        exStringEquals(uketorinin5.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin5.getUkttdk(), C_Tdk.KO, "受取人続柄");
        exDateEquals(uketorinin5.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin5.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin6 = uketorinins.get(5);
        exClassificationEquals(uketorinin6.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin6.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin6.getUktkbn(), C_UktKbn.SBUK, "受取人区分");
        exStringEquals(uketorinin6.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin6.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin6.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin6.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin6.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");

    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A7"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171231"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 3, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "カナナナナカナナナナカナナナナカナナ", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "漢字受取人名名名名漢字", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), BizDate.valueOf(20160505), "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "カナナナナナカナナナナナカナナナナナ", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), BizDate.valueOf(20160606), "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.BLNK, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A8"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171215"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "111AAbb", "設計書申込書作成親代理店コード");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 3, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "カナナナナカナナナナカナナナナカナナ", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "漢字受取人名名名名漢字", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), BizDate.valueOf(20160505), "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "カナナナナナカナナナナナカナナナナナ", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), BizDate.valueOf(20160606), "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "被代理漢字氏名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.SHB, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), BizDate.valueOf(20161010), "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");

    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A9"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A10"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A11"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "満期受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A12"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字死亡受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A13"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "漢字満期受取人名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(160)
    public void testExecPostForm_A16() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A16"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "死亡受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(170)
    public void testExecPostForm_A17() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A17"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "満期受取人生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(180)
    public void testExecPostForm_A18() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A18"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください",
            "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(190)
    public void testExecPostForm_A19() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A19"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "保険種類番号エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(200)
    public void testExecPostForm_A20() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A20"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "契約者カナ氏名を正しく入力してください",
            "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

    }

    @Test
    @TestOrder(210)
    public void testExecPostForm_A21() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A21"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被保険者カナ氏名を正しく入力してください",
            "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 0)
            , "カ　カナカナカナカナカナカナカナカナ", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 1)
            , C_Kojinhjn.HJN, "個人法人区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 0)
            , "ホケ　ホケンホケンンケンホケンホケン", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 1)
            , C_Kojinhjn.KOJIN, "個人法人区分");

    }

    @Test
    @TestOrder(220)
    public void testExecPostForm_A22() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A22"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5100001", "設計書申込書作成親代理店コード");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 3, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "カナナナナカナナナナカナナナナカナナ", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "漢字受取人名名名名漢字", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), BizDate.valueOf(20160505), "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "カナナナナナカナナナナナカナナナナナ", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), BizDate.valueOf(20160606), "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.STDRSK, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin3.getUktnmkn(), "カナナナナナカナナナナナカナナカカカ", "受取人名（カナ）");
        exStringEquals(uketorinin3.getUktnmkj(), "被代理漢字氏名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin3.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin3.getUktseiymd(), null, "受取人生年月日");
        exClassificationEquals(uketorinin3.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
    }

    @Test
    @TestOrder(230)
    public void testExecPostForm_A23() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A23"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5100002", "設計書申込書作成親代理店コード");
        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 2, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin1.getUktnmkn(), "カナナナナカナナナナカナナナナカナナ", "受取人名（カナ）");
        exStringEquals(uketorinin1.getUktnmkj(), "漢字受取人名名名名漢字", "受取人名（漢字）");
        exClassificationEquals(uketorinin1.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin1.getUktseiymd(), BizDate.valueOf(20160505), "受取人生年月日");
        exClassificationEquals(uketorinin1.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.TOKUTEIMEIGI, "受取人区分");
        exStringEquals(uketorinin2.getUktnmkn(), "カナナナナナカナナナナナカナナナナナ", "受取人名（カナ）");
        exStringEquals(uketorinin2.getUktnmkj(), "漢字受取人名名名名名漢", "受取人名（漢字）");
        exClassificationEquals(uketorinin2.getUkttdk(), C_Tdk.HGU, "受取人続柄");
        exDateEquals(uketorinin2.getUktseiymd(), BizDate.valueOf(20160606), "受取人生年月日");
        exClassificationEquals(uketorinin2.getUktnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "受取人名漢字化不可区分");
    }

    @Test
    @TestOrder(240)
    public void testExecPostForm_A24() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A24"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "7200001", "設計書申込書作成親代理店コード");

    }

    @Test
    @TestOrder(250)
    public void testExecPostForm_A25() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A25"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "7300001", "設計書申込書作成親代理店コード");

    }

    @Test
    @TestOrder(260)
    public void testExecPostForm_A26() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A26"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "7100001", "設計書申込書作成親代理店コード");

    }

    @Test
    @TestOrder(270)
    public void testExecPostForm_A27() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A27"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5101378", "設計書申込書作成親代理店コード");

    }

    @Test
    @TestOrder(280)
    public void testExecPostForm_A28() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A28"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨試算基本Ｓ");
    }

    @Test
    @TestOrder(290)
    public void testExecPostForm_A29() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A29"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(300)
    public void testExecPostForm_A30() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A30"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), null, "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(0),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(0),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MockObjectManager
        .assertArgumentPassed(HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "convAddressToDairiten", 1, "1200399");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "111AAbb", "設計書申込書作成親代理店コード");

        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exDateEquals(mosKihon.getMosymd(), BizDate.valueOf("20180101"), "申込日");
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.BLNK, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getSyksbyensitihsyutkhkkbn(), C_Tkhukaumu.NONE, "初期死亡時円換算最低保証特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.NONE, "重度介護前払特約付加区分");
        exClassificationEquals(mosKihon.getTeirituhaibunwarikbn(), C_TumitatekinHaibunWariKbn.BLNK, "定率部分配分割合区分");
        exClassificationEquals(mosKihon.getSisuukbn(), C_Sisuukbn.BLNK, "指数区分");
        exClassificationEquals(mosKihon.getSisuuhaibunwarikbn(), C_TumitatekinHaibunWariKbn.BLNK, "指数部分配分割合区分");
        exClassificationEquals(mosKihon.getTrhkjikakkbn(), C_TrhkjiKakKbn.KAKUNINZUMI, "取引時確認区分");

        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 2, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.NKUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.KYK, "受取人区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.KYK, "受取人区分");

        HT_MosSyouhn mosSyouhn = mosnaiCheckParam.getDataSyoriControl().getMosSyouhns().get(0);
        exClassificationEquals(mosSyouhn.getSknenkinsyu(), C_Sknenkinsyu.KKTI10, "新契約年金種類");
        exNumericEquals(mosSyouhn.getHknkkn(), 10, "保険期間");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 0)
            , "カ　カナカナカナカナカナカナカナカナ", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 0, 1)
            , C_Kojinhjn.KOJIN, "個人法人区分");

        exStringEquals((String) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 0)
            , "ホケ　ホケンホケンホケンホケンホケン", "カナ名義人");
        exClassificationEquals((C_Kojinhjn) MockObjectManager.getArgument(CheckMeigininNmKana.class, "isCheckOK", 1, 1)
            , C_Kojinhjn.HJN, "個人法人区分");

        exStringEquals((String) MockObjectManager.getArgument(HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "convDairiten", 0, 1)
            , "0000000", "変換前代理店コード");
    }

    @Test
    @TestOrder(310)
    public void testExecPostForm_A31() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A31"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "作成区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(320)
    public void testExecPostForm_A32() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A32"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(1),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(5000),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(),
            BizNumber.valueOf(new BigDecimal("9999999999999")),
            "（ＩＷＳ）外貨試算基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5102152", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.NONE, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");
    }

    @Test
    @TestOrder(330)
    public void testExecPostForm_A33() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN3;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;
        KeisanPJyuutougkMockForSinkeiyaku.SYORIPTN = KeisanPJyuutougkMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A33"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171231"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(0),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(0),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(100000),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "9408108", "設計書申込書作成親代理店コード");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn(), C_UmuKbn.NONE,
            "設計書申込書作成払込資金入力有無区分");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.HUKA, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.BLNK, "重度介護前払特約付加区分");

        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 0)
            , BizCurrency.valueOf(0), "保険料（契約通貨）");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 1)
            , BizCurrency.valueOf(12309876543.21, BizCurrencyTypes.DOLLAR), "保険料（円貨）");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 2), 0, "被保険者年齢");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 3), 11, "払込期間");
        exClassificationEquals(
            (C_HrkkknsmnKbn) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 4),
            C_HrkkknsmnKbn.BLNK, "払込期間歳満期区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 5),
            BizDate.valueOf("20180101"), "契約日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanPJyuutougkMockForSinkeiyaku.class, "exec", 0, 6),
            BizDateYM.valueOf("201801"), "計算基準年月");
    }

    @Test
    @TestOrder(340)
    public void testExecPostForm_A34() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;
        KeisanPJyuutougkMockForSinkeiyaku.SYORIPTN = KeisanPJyuutougkMockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A34"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171231"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(25),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(225),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(100000),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率２");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "9408108", "設計書申込書作成親代理店コード");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn(), C_UmuKbn.ARI, "設計書申込書作成払込資金入力有無区分");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.HUKA, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.BLNK, "重度介護前払特約付加区分");
    }

    @Test
    @TestOrder(350)
    public void testExecPostForm_A35() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A35"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(mosnaiCheckParam.getYoteiKykymdKbn(), C_YoteikykymdKbn.AUTO, "予定契約日区分");

    }

    @Test
    @TestOrder(360)
    public void testExecPostForm_A36() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN8;
        KeisanPJyuutougkMockForSinkeiyaku.SYORIPTN = KeisanPJyuutougkMockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A36"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(0),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(0),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(0), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "0", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "0", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "0", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(0),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(0),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(0),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20181230"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(25),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(225),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(100000),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率２");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "9408108", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.HUKA, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.BLNK, "重度介護前払特約付加区分");
    }

    @Test
    @TestOrder(370)
    public void testExecPostForm_A37() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;
        KeisanPJyuutougkMockForSinkeiyaku.SYORIPTN = KeisanPJyuutougkMockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A37"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsKinyuukikancd(), "K007", "（ＩＷＳ）金融機関コード");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "2", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "2", "ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "2", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20181215"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(0),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(1250),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(100000),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率２");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "9408108", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.HUKA, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.BLNK, "重度介護前払特約付加区分");
    }

    @Test
    @TestOrder(380)
    public void testExecPostForm_A38() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        CheckTblMosSyouhinMockForSinkeiyaku.SYORIPTN = CheckTblMosSyouhinMockForSinkeiyaku.TESTPATTERN1;
        SetSPMockForSinkeiyaku.SYORIPTN = SetSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSPMockForSinkeiyaku.SYORIPTN = CheckSPMockForSinkeiyaku.TESTPATTERN1;
        CheckSkTuusanMockForSinkeiyaku.SYORIPTN = CheckSkTuusanMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A38"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20180115"),
            "（ＩＷＳ）代理店設計書有効期限年月日");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyusirrtfgu(), BizNumber.valueOf(1),
            "（ＩＷＳ）市場価格調整用利率負号");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSjkkktyouseiriritu(), BizNumber.valueOf(5000),
            "（ＩＷＳ）市場価格調整用利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTumitateriritu(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立利率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSetteibairitu(), BizNumber.valueOf(0),
            "（ＩＷＳ）設定倍率");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTmttknzkrtjygn(), BizNumber.valueOf(0),
            "（ＩＷＳ）積立金増加率上限値");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsNayosehumeikbn(), "0",
            "（ＩＷＳ）名寄せ不明区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSisuurendoup(), BizNumber.valueOf(2500),
            "（ＩＷＳ）指数連動部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsTeiritutumitatep(), BizNumber.valueOf(22500),
            "（ＩＷＳ）定率積立部分Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasisankihons(),
            BizNumber.valueOf(new BigDecimal("9999999999999")),
            "（ＩＷＳ）外貨試算基本Ｓ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu1(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率１");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu2(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu3(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率３");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu4(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率４");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsYoteijigyouhiritu5(), BizNumber.valueOf(0),
            "（ＩＷＳ）予定事業費率５");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsPwaribikirankkbn(), "1", "（ＩＷＳ）保険料割引ランク区分");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "5102152", "設計書申込書作成親代理店コード");
        HT_MosKihon mosKihon = mosnaiCheckParam.getDataSyoriControl().getMosKihon();
        exClassificationEquals(mosKihon.getTargettkhkkbn(), C_Tkhukaumu.NONE, "ターゲット特約付加区分");
        exClassificationEquals(mosKihon.getJyudkaigomehrtkhkkbn(), C_Tkhukaumu.HUKA, "重度介護前払特約付加区分");
    }

    @Test
    @TestOrder(390)
    public void testExecPostForm_A39() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A39"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族漢字氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(400)
    public void testExecPostForm_A40() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A40"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(410)
    public void testExecPostForm_A41() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A41"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族カナ氏名（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(420)
    public void testExecPostForm_A42() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A42"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理漢字氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(430)
    public void testExecPostForm_A43() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A43"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "ご家族生年月日（１人目）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(440)
    public void testExecPostForm_A44() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A44"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理カナ氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(450)
    public void testExecPostForm_A45() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A45"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理カナ氏名エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }


    @Test
    @TestOrder(460)
    public void testExecPostForm_A46() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A46"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(470)
    public void testExecPostForm_A47() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A47"));


        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "被代理生年月日エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(490)
    public void testExecPostForm_A49() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A49"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(20), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20180201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(500)
    public void testExecPostForm_A50() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A50"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(250), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(250), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(0), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20171231"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(510)
    public void testExecPostForm_A51() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A51"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(250), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(0), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20180201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(520)
    public void testExecPostForm_A52() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A52"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.valueOf(25000), "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(20), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20180201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(530)
    public void testExecPostForm_A53() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A53"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.ZERO, "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.ZERO, "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(250), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(250), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(0), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(0), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(540)
    public void testExecPostForm_A54() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN1;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A54"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(0), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(0), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(0), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(550)
    public void testExecPostForm_A55() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A55"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(0), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(1230987654321l), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.ZERO, "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.valueOf(1230987654321l), "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(0), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20170201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(560)
    public void testExecPostForm_A56() throws Exception {

        MockObjectManager.initialize();
        SeihowebMosnaiCheckMockForSinkeiyaku.SYORIPTN = SeihowebMosnaiCheckMockForSinkeiyaku.TESTPATTERN2;
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A56"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennoup(), BizNumber.valueOf(0), "（ＩＷＳ）前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikazennoup(), BizNumber.valueOf(0), "（ＩＷＳ）外貨前納Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("7894561230")), "（ＩＷＳ）払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyukykp(), BizNumber.valueOf(new BigDecimal("1230987654321")), "（ＩＷＳ）外貨払込通貨主契約Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyokaiharaikomip(), BizNumber.valueOf(250), "（ＩＷＳ）初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsHrktuukasyokaihrkp(), BizNumber.valueOf(250), "（ＩＷＳ）払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikahrktuukasyokaihrkp(), BizNumber.ZERO, "（ＩＷＳ）外貨払込通貨初回払込Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsikkatup(), BizNumber.valueOf(0), "（ＩＷＳ）一括払Ｐ");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSyotsryruigkn(), BizNumber.valueOf(1100),
            "（ＩＷＳ）初年度手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsNitsryruigkn(), BizNumber.valueOf(2100),
            "（ＩＷＳ）２年目以降手数料累計額（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsSougktsryn(), BizNumber.valueOf(3100), "（ＩＷＳ）総額手数料（数値）");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsryruigk(), BizNumber.valueOf(410000),
            "（ＩＷＳ）外貨初年度手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasyotsrytuukakbn(), "4", "（ＩＷＳ）外貨初年度手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsryruigkn(), BizNumber.valueOf(510000),
            "（ＩＷＳ）外貨２年目以降手数料累計額");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikanitsrytuukakbn(), "4", "（ＩＷＳ）外貨２年以降手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsry(), BizNumber.valueOf(610000),
            "（ＩＷＳ）外貨総額手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikasougktsrytuukakbn(), "4", "（ＩＷＳ）外貨総額手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrfsttsry(), BizNumber.valueOf(7100),
            "（ＩＷＳ）代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsDrtenshrkztsry(), BizNumber.valueOf(8100),
            "（ＩＷＳ）代理店支払継続手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrfsttsry(), BizNumber.valueOf(910000),
            "（ＩＷＳ）外貨代理店支払初回手数料");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsGaikadrtenshrkztsry(), BizNumber.valueOf(1100000),
            "（ＩＷＳ）外貨代理店支払継続手数料");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrfsttsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払初回手数料通貨区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsGkdrtenshrkztsrytukkbn(), "4", "（ＩＷＳ）外貨代理店支払継続手数料通貨区分");
        exBizCalcbleEquals(wsHbSeihoWebSekMosOutputBean.getIwsZennouwrbkrt(), BizNumber.valueOf(8), "（ＩＷＳ）前納割引率");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf("20180201"),
            "（ＩＷＳ）代理店設計書有効期限年月日");

    }

    @Test
    @TestOrder(570)
    public void testExecPostForm_A57() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN10;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5438000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A57"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "1", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(580)
    public void testExecPostForm_A58() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A58"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf(20210429), "（ＩＷＳ）代理店設計書有効期限年月日");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), null, "（ＩＷＳ）募集代理店名");

        MosnaiCheckParam mosnaiCheckParam = (MosnaiCheckParam) MockObjectManager.getArgument(
            SeihowebMosnaiCheckMockForSinkeiyaku.class, "exec", 0, 0);

        List<HT_Uketorinin> uketorinins = mosnaiCheckParam.getDataSyoriControl().getUketorinins();
        exNumericEquals(uketorinins.size(), 5, "受取人テーブルリストのサイズ");
        HT_Uketorinin uketorinin1 = uketorinins.get(0);
        exClassificationEquals(uketorinin1.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin1.getUktsyurenno(), 1, "受取人種類別連番");
        exClassificationEquals(uketorinin1.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
        HT_Uketorinin uketorinin2 = uketorinins.get(1);
        exClassificationEquals(uketorinin2.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin2.getUktsyurenno(), 2, "受取人種類別連番");
        exClassificationEquals(uketorinin2.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
        HT_Uketorinin uketorinin3 = uketorinins.get(2);
        exClassificationEquals(uketorinin3.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin3.getUktsyurenno(), 3, "受取人種類別連番");
        exClassificationEquals(uketorinin3.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
        HT_Uketorinin uketorinin4 = uketorinins.get(3);
        exClassificationEquals(uketorinin4.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin4.getUktsyurenno(), 4, "受取人種類別連番");
        exClassificationEquals(uketorinin4.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
        HT_Uketorinin uketorinin5 = uketorinins.get(4);
        exClassificationEquals(uketorinin5.getUktsyukbn(), C_UktsyuKbn.SBUKT, "受取人種類区分");
        exNumericEquals(uketorinin5.getUktsyurenno(), 5, "受取人種類別連番");
        exClassificationEquals(uketorinin5.getUktkbn(), C_UktKbn.HHKN, "受取人区分");
    }

    @Test
    @TestOrder(590)
    public void testExecPostForm_A59() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A59"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf(20210628), "（ＩＷＳ）代理店設計書有効期限年月日");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "漢字代理店名２２３４５６７８９０１２３", "（ＩＷＳ）募集代理店名");
    }

    @Test
    @TestOrder(600)
    public void testExecPostForm_A60() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A60"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf(20210512), "（ＩＷＳ）代理店設計書有効期限年月日");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "漢字代理店名３２３４５６７８９０１２３４", "（ＩＷＳ）募集代理店名");
    }

    @Test
    @TestOrder(610)
    public void testExecPostForm_A61() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.SYORIPTN = DairitenTesuuryouInfoSyutokuMockForSinkeiyaku.TESTPATTERN9;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("operatorId", "213456789012");
        pMap.add("orgCode", "5430000");
        pMap.add("methodName", "bosyuu.hbsekmos.hbseihowebsekmos.logdata");
        pMap.add("coopClass", "0");
        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A61"));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebSekMosImpl.execPostForm(pMap);

        System.out.println("★業務データ★：" + wsBzWebserviceResParamBean.getGyoumuData());

        WsHbSeihoWebSekMosOutputBean wsHbSeihoWebSekMosOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(),
            WsHbSeihoWebSekMosOutputBean.class);

        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmossakuseierroutkbn(), "0", "（ＩＷＳ）設計書申込書作成エラー出力区分");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exDateEquals(wsHbSeihoWebSekMosOutputBean.getIwsDairitensekykkigenymd(), BizDate.valueOf(20210515), "（ＩＷＳ）代理店設計書有効期限年月日");
        exStringEquals(wsHbSeihoWebSekMosOutputBean.getIwsBosyuudairitennm(), "漢字代理店名４２３４５６７８９０１２３４", "（ＩＷＳ）募集代理店名");
    }
}
