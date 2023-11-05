package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 入金共通処理クラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec6 {

    private final static String syoNo1 = "12806345960";

    private final static String syoNo2 = "12806345971";

    private final static String syoNo3 = "12806345982";

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
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec6.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec6.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec6.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
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
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_F1() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo1);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20161003"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(null);
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(2000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160930));
        nyuukinTRParam.setKzHurikaeBankCd(null);
        nyuukinTRParam.setKzHurikaeSitenCd(null);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20161003"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(2000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo1, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20161003"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(2000), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160930"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), null, "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160930"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo1, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo1, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20161003"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), null, "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 0, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("2000")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20160930"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20160930"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "20161003", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "1012001", "出納組織コード");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_F2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo2);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo2);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160202"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201609"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151230));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160203"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20180202"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20151230));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 2, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(1).getSyono(), syoNo2, "証券番号");
        exNumericEquals(kariukekinLst.get(1).getKrkno(), 2, "仮受番号");
        exDateEquals(kariukekinLst.get(1).getKrkkeijyoymd(), BizDate.valueOf("20160202"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(1).getKrkgk(), BizCurrency.valueOf(1000), "仮受金額");
        exDateEquals(kariukekinLst.get(1).getHasseidenymd(), BizDate.valueOf("20160129"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(1).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(1).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(1).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(1).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(kariukekinLst.get(1).getJyuutouym(), BizDateYM.valueOf("201609"), "充当年月");
        exNumericEquals(kariukekinLst.get(1).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(1).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(1).getRyosyuymd(), BizDate.valueOf("20151230"), "領収日");
        exStringEquals(kariukekinLst.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(1).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo2, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_F3() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201609"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20150301));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20150103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo3, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20150301"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201609"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20150301"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo3, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo3, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.BLNK, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf(201609), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 0, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("0")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20150301"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20150301"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "1001", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "101", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_F4() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201609"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20150301));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20150103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setDenymd(BizDate.valueOf("20160105"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 2, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo3, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(0), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20150301"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.PMENYOUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201609"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 0, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20150301"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo3, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());
    }

}