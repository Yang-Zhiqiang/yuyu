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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataSksMockForKhansyuu;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksMockForKhansyuu;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksParam;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.ascommon.SetMinusUriagebiMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 入金共通処理クラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec5 {

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    private AS_Kinou asKinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_入金共通処理";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(AnsyuuCommonSiwake.class).to(AnsyuuCommonSiwakeMockForKhansyuu.class);
                bind(SetYuuyokknmanryobi.class).to(SetYuuyokknmanryobiMockForKhansyuu.class);
                bind(EditKoujyonaiyouTbl.class).to(EditKoujyonaiyouTblMockForKhansyuu.class);
                bind(EditDairitenTesuuryouTbl.class).to(EditDairitenTesuuryouTblMockForKhansyuu.class);
                bind(BzDenpyouDataSks.class).to(BzDenpyouDataSksMockForKhansyuu.class);
                bind(CreditHnknTuutiSks.class).to(CreditHnknTuutiSksMockForKhansyuu.class);
                bind(SetMinusUriagebi.class).to(SetMinusUriagebiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        EditKoujyonaiyouTblMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        BzDenpyouDataSksMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        CreditHnknTuutiSksMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
        SetMinusUriagebiMockForKhansyuu.caller = CommonNyuukinTest_exec5.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec5.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @AfterClass
    public static void testClear() {
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
        EditKoujyonaiyouTblMockForKhansyuu.caller = null;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = null;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = null;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = null;
        BzDenpyouDataSksMockForKhansyuu.caller = null;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = null;
        CreditHnknTuutiSksMockForKhansyuu.caller = null;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = null;
        SetMinusUriagebiMockForKhansyuu.caller = null;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_E1() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806345915");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("12806345915");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("12806345915");
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000000000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160101"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160101));
        nyuukinTRParam.setCreditkessaiyouno("22345678901234567890123456");
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.RINJI);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000000000L), "仮受金額");

        IT_SyuunouHenknRireki oSyuunouHenknRireki = commonNyuukin.getSyuunouHenknRireki();
        exStringEquals(oSyuunouHenknRireki.getSyono(), "12806345915", "証券番号");
        exStringEquals(oSyuunouHenknRireki.getDenrenno(), "100001", "伝票データ連番");
        exNumericEquals(oSyuunouHenknRireki.getEdano(), 10, "枝番号");
        exDateEquals(oSyuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf("20151230"), "伝票起票日");
        exDateEquals(oSyuunouHenknRireki.getShrymd(), BizDate.valueOf("20151231"), "支払日");
        exClassificationEquals(oSyuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exBizCalcbleEquals(oSyuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exStringEquals(oSyuunouHenknRireki.getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), "12806345915", "証券番号");
        exStringEquals(itKhDenpyoDataList.get(1).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(1).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(1).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(1).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(1).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSyorisosikicd(), "12340000", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(1).getSyusyouhncd(), "001", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(1).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 1, 0);
        exStringEquals(ansyuuCommonSiwakeInBean.getKinouId(), "khcommon", "機能ＩＤ");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getDensysKbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(ansyuuCommonSiwakeInBean.getSyouhinCd(), "ﾕｹ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(1).getSyouhnsdno(), 1, "商品世代番号");
        exDateEquals(ansyuuCommonSiwakeInBean.getDenYmd(), BizDate.valueOf("20151230"), "伝票日付");
        exDateEquals(ansyuuCommonSiwakeInBean.getSyoriYmd(), BizDate.valueOf("20160103"), "処理年月日");
        exDateEquals(ansyuuCommonSiwakeInBean.getKykYmd(), BizDate.valueOf("20151122"), "契約日");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getShrhousiteiKbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(ansyuuCommonSiwakeInBean.getSyono(), "12806345915", "証券番号");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.BLNK, "収納代行社コード");
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = ansyuuCommonSiwakeInBean.getAnsyuuTaisyouGkBeanLst();
        exNumericEquals(ansyuuTaisyouGkBeanLst.size(), 2, "対象金額リスト件数");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(0).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getTaisyouGk(), BizCurrency.valueOf(1000000000000L), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getKeiyakutuukaGk(), BizCurrency.valueOf(1000000000000L), "契約通貨金額");

        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(1).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.CREDITTORIKESIGK, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getTaisyouGk(), BizCurrency.valueOf(1000000000000L), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getKeiyakutuukaGk(), BizCurrency.valueOf(1000000000000L), "契約通貨金額");

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBeanParam = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(BzDenpyouDataSksMockForKhansyuu.class, "execKh", 1, 0);
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyono(), "12806345915", "（ＩＢ）証券番号");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbHuridenatesakicd(), "1234", "（ＩＢ）振替伝票宛先部課コード");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbTantocd(), C_TantouCdKbn.KAIYAKU, "（ＩＢ）担当コード");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbDenymd(), BizDate.valueOf("20210226"), "（ＩＢ）伝票日付");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbTuukasyu(), C_Tuukasyu.JPY, "（ＩＢ）通貨種類");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbHuridenskskbn(), C_HuridensksKbn.BLNK, "（ＩＢ）振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "（ＩＢ）伝票用返金方法区分");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbDenshrhoukbn(), C_DenshrhouKbn.BLNK, "（ＩＢ）伝票用支払方法区分");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbSyoriymd(), BizDate.valueOf("20160103"), "（ＩＢ）処理年月日");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyoricd(), "RG9F", "（ＩＢ）処理コード");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyorisosikicd(), "12340000", "（ＩＢ）処理組織コード");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbKyktuukasyu(), C_Tuukasyu.JPY, "（ＩＢ）契約通貨種類");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbGyoumuKousinsyaId(), "JUnit", "（ＩＢ）業務用更新者ＩＤ");
        exBooleanEquals(bzDenpyouDataTourokuBeanParam.getIbKakokawaserateshiteiflg(), false, "（ＩＢ）過去為替レート指定フラグ");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbKakokawaserateshiteiymd(), null, "（ＩＢ）過去為替レート指定年月日");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbShrhousiteiKbn(), C_ShrhousiteiKbn.BLNK, "（IB）支払方法指定区分");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(bzDenpyouDataTourokuBeanParam.getIbSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(bzDenpyouDataTourokuBeanParam.getBzSiwakeMeisaiBeanList().size(), 1, "仕訳明細リストの件数");

        khozenCommonParam = (KhozenCommonParam)MockObjectManager.getArgument(CreditHnknTuutiSksMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(khozenCommonParam.getFunctionId(), "khcommon", "機能ID");
        CreditHnknTuutiSksParam creditHnknTuutiSksParam = (CreditHnknTuutiSksParam)MockObjectManager.getArgument(CreditHnknTuutiSksMockForKhansyuu.class, "exec", 0, 1);
        exStringEquals(creditHnknTuutiSksParam.getDenrenno(), "100001", "伝票データ連番");
        exNumericEquals(creditHnknTuutiSksParam.getEdano(), 10, "枝番号");
        exDateEquals(creditHnknTuutiSksParam.getDenymd(), BizDate.valueOf("20151230"), "伝票起票日");
        exDateEquals(creditHnknTuutiSksParam.getTyouhyouymd(), BizDate.valueOf("20160103"), "帳票作成日");
        exStringEquals(creditHnknTuutiSksParam.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(creditHnknTuutiSksParam.getHassoukbn(), C_HassouKbn.BLNK, "発送区分");
        exClassificationEquals(creditHnknTuutiSksParam.getShrriyuukbn(), C_ShrriyuuKbn.BLNK, "支払理由区分");
        exDateEquals(creditHnknTuutiSksParam.getUriageseikyuuymd(), BizDate.valueOf("20151231"), "売上請求日");
        exClassificationEquals(creditHnknTuutiSksParam.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exBizCalcbleEquals(creditHnknTuutiSksParam.getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exClassificationEquals(creditHnknTuutiSksParam.getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exDateEquals(creditHnknTuutiSksParam.getUriageymd(), BizDate.valueOf("20160101"), "売上日");
        exBizCalcbleEquals(creditHnknTuutiSksParam.getUriagegk(), BizCurrency.valueOf(1000000000000L), "売上金額");
        exDateYMEquals(creditHnknTuutiSksParam.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(creditHnknTuutiSksParam.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(creditHnknTuutiSksParam.getJyutoukaisuum(), 1, "充当回数（月）");
        exStringEquals(creditHnknTuutiSksParam.getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");
        exStringEquals(creditHnknTuutiSksParam.getAnsyuKihon().getSyono(), "12806345915", "案内収納基本テーブルの証券番号");
        exStringEquals(creditHnknTuutiSksParam.getKykKihon().getSyono(), "12806345915", "契約基本テーブルの証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(SetMinusUriagebiMockForKhansyuu.class, "exec", 0, 0), BizDate.valueOf("20160103"), "処理年月日");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_E2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN3;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("12806345926");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("12806345926");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("12806345926");
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000000000L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160101"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160101));
        nyuukinTRParam.setCreditkessaiyouno("22345678901234567890123456");
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.RINJI);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000000000L), "仮受金額");

        IT_SyuunouHenknRireki oSyuunouHenknRireki = commonNyuukin.getSyuunouHenknRireki();
        exStringEquals(oSyuunouHenknRireki.getSyono(), "12806345926", "証券番号");
        exStringEquals(oSyuunouHenknRireki.getDenrenno(), "100001", "伝票データ連番");
        exNumericEquals(oSyuunouHenknRireki.getEdano(), 0, "枝番号");
        exDateEquals(oSyuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf("20151230"), "伝票起票日");
        exDateEquals(oSyuunouHenknRireki.getShrymd(), BizDate.valueOf("20151231"), "支払日");
        exClassificationEquals(oSyuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exBizCalcbleEquals(oSyuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exStringEquals(oSyuunouHenknRireki.getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 4, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(2).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(2).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(2).getSyono(), "12806345926", "証券番号");
        exStringEquals(itKhDenpyoDataList.get(2).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(2).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(2).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(2).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(2).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(2).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(2).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(2).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(2).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(2).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(2).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(2).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(2).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(2).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(2).getSyorisosikicd(), "12340000", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(2).getSyusyouhncd(), "001", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(2).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(2).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(2).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(2).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(2).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(3).getEdano(), 11, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(3).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(3).getSyono(), "12806345926", "証券番号");
        exStringEquals(itKhDenpyoDataList.get(3).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(3).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(3).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(3).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(3).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(3).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(3).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(3).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(3).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(3).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(3).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(3).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(3).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(3).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(3).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(3).getSyorisosikicd(), "12340000", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(3).getSyusyouhncd(), "001", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(3).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(3).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(3).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(3).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(3).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
    }
}