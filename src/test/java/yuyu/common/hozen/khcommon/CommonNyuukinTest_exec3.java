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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataSksMockForKhansyuu;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSks;
import yuyu.common.hozen.ascommon.CreditHnknTuutiSksMockForKhansyuu;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.GetasPRsTuukaMockForKhansyuu;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuMockForKhansyuu;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.ascommon.SetMinusUriagebiMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_CreditUriageSeikyuuKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
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
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_Krkseisanzumiflg;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NykshrKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tkiktannaitukisuu;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BT_SikinIdouRireki;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Kariukekin;
import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.def.db.entity.IT_KouzaHnknTuuti;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.entity.IT_SyuunouHenknRireki;
import yuyu.def.db.entity.IT_Tokusin;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 入金共通処理クラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec3 extends AbstractTest {

    private final static String syoNo2 = "12806345801";

    private final static String syoNo3 = "12806345812";

    private final static String syoNo4 = "12806345823";

    private final static String syoNo5 = "12806345834";

    private final static String syoNo6 = "12806345845";

    private final static String syoNo7 = "12806345856";

    private final static String syoNo8 = "12806345867";

    private final static String syoNo9 = "12806345878";

    private final static String syoNo10 = "12806345889";

    private final static String syoNo11 = "11810111200";

    private final static String syoNo12 = "11809111402";

    private final static String syoNo13 = "11810111211";

    private final static String syoNo14 = "11810111255";

    private final static String syoNo15 = "11810111266";

    private final static String syoNo18 = "17806000312";

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private AS_Kinou asKinou;

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
                bind(KeisanIkkatuWaribikiKikan.class).to(KeisanIkkatuWaribikiKikanMockForKhansyuu.class);
                bind(HanteiTetuduki.class).to(HanteiTetudukiMockForKhansyuu.class);
                bind(GetasPRsTuuka.class).to(GetasPRsTuukaMockForKhansyuu.class);
                bind(KeisanRsgaku.class).to(KeisanRsgakuMockForKhansyuu.class);
                bind(CreditHnknTuutiSks.class).to(CreditHnknTuutiSksMockForKhansyuu.class);
                bind(SetMinusUriagebi.class).to(SetMinusUriagebiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        EditKoujyonaiyouTblMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        BzDenpyouDataSksMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        GetasPRsTuukaMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        KeisanRsgakuMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        CreditHnknTuutiSksMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
        SetMinusUriagebiMockForKhansyuu.caller = CommonNyuukinTest_exec3.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec3.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
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
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;
        GetasPRsTuukaMockForKhansyuu.caller = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = null;
        KeisanRsgakuMockForKhansyuu.caller = null;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = null;
        CreditHnknTuutiSksMockForKhansyuu.caller = null;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = null;
        SetMinusUriagebiMockForKhansyuu.caller = null;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllDensimeNenkanSchedule());
    }

    @Test
    @TestOrder(10)
    public void testExec_C1() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("11807111303");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(5000), "仮受金額");
        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_C2() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo2);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo2);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(2000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20151201));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        try{
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。口座TBLにデータが存在しません。", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_C3() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;
        baseUserInfo.getUser().setUserId("JUnit");

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(new BigDecimal("2100000000000")));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(null);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170201"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160103));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo3, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160103"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 11, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード ");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
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
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 11, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "1001", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "101", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
        exClassificationEquals(itNyuukinKakusyouData.getSyuudaikocd(), C_Syuudaikocd.SIS, "収納代行社コード");

        MockObjectManager.assertNotCalled(EditDairitenTesuuryouTblMockForKhansyuu.class, "setBatchSyoriYmd");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_C4() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN4;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;
        baseUserInfo.getUser().setUserId("JUnit");

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo4);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160201"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf(20160201));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170201"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160201));
        nyuukinTRParam.setCreditkessaiyouno("22345678901234567890123456");
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);


        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 1, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo4, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201603"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201603"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(new BigDecimal("3000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20200814), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160201"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20160201"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        List<BT_SikinIdouRireki> sikinIdouRirekiList = bizDomManager.getAllSikinIdouRireki();
        exNumericEquals(sikinIdouRirekiList.size(), 0, "資金移動用履歴テーブル件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo4, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201604"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160601"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_Tokusin tokusin = itAnsyuKihon.getTokusin();
        assertNull(tokusin);

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo4, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE, "勘定科目コード");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", " 主契約商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo4, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20160201"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 1, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("10")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20160201"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");
        exClassificationEquals(itNyuukinKakusyouData.getCredituriageseikyuukbn(), C_CreditUriageSeikyuuKbn.TUUJYOU, "クレジットカード売上請求区分");

        khozenCommonParam = (KhozenCommonParam)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 0);
        assertNotNull(khozenCommonParam.getAnsyuuKihon(syoNo4));
        exStringEquals((String)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 1), syoNo4, "証券番号");
        exClassificationEquals((C_TsrysyoriKbn)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 2), C_TsrysyoriKbn.KEIZOKUPNYUUKIN, "手数料処理区分");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 3), BizDateYM.valueOf("201603"), "効力発生年月");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 4), 0, "入金回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 5), 1, "入金回数（月）");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 6), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 7), BizCurrency.valueOf(0), "一括払保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 8), BizDate.valueOf("20160201"), "入金日");
        assertNull(MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 9));

        exDateEquals(
            (BizDate) MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "setBatchSyoriYmd", 0, 0),
            BizDate.valueOf("20160201"), "バッチ処理年月日");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_C5() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo5);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo5);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
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
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160101));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000000000L), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();

        IT_Tokusin tokusin = itAnsyuKihon.getTokusin();
        assertNull(tokusin);

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo5, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "001", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), syoNo5, "証券番号");
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

        IT_KhFBSoukinData khFBSoukinData = commonNyuukin.getKhFBSoukinData();

        exStringEquals(khFBSoukinData.getSyono(), syoNo5, "証券番号");
        exNumericEquals(khFBSoukinData.getEdano(), 10, "枝番号");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(khFBSoukinData.getSyoricd(), "RG9F", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "12340000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160103"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20160106"), "伝票日付");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "9900", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "008", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "234567890123", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(1000000000000L), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo5, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 1, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal(1000000000000L)), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20160101"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "20160103", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "1012001", "出納組織コード");

        List<IT_SyuunouHenknRireki> syuunouHenknRirekiLst = itAnsyuKihon.getSyuunouHenknRirekis();
        exNumericEquals(syuunouHenknRirekiLst.size(), 1, "収納返金履歴テーブルリスト件数");
        exNumericEquals(syuunouHenknRirekiLst.get(0).getEdano(), 10, "枝番号");
        exStringEquals(syuunouHenknRirekiLst.get(0).getSyono(), syoNo5, "証券番号");
        exDateEquals(syuunouHenknRirekiLst.get(0).getDenkihyouymd(), BizDate.valueOf("20160103"), "伝票起票日");
        exDateEquals(syuunouHenknRirekiLst.get(0).getShrymd(), BizDate.valueOf("20160106"), "支払日");
        exClassificationEquals(syuunouHenknRirekiLst.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRirekiLst.get(0).getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exClassificationEquals(syuunouHenknRirekiLst.get(0).getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(syuunouHenknRirekiLst.get(0).getBankcd(), "9900", "銀行コード");
        exStringEquals(syuunouHenknRirekiLst.get(0).getSitencd(), "008", "支店コード");
        exClassificationEquals(syuunouHenknRirekiLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(syuunouHenknRirekiLst.get(0).getKouzano(), "234567890123", "口座番号");
        exStringEquals(syuunouHenknRirekiLst.get(0).getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exStringEquals(syuunouHenknRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KouzaHnknTuuti> kouzaHnknTuutiLst = itKykKihon.getKouzaHnknTuutis();
        exNumericEquals(kouzaHnknTuutiLst.size(), 1, "契約保全伝票データテーブルリスト件数");
        exStringEquals(kouzaHnknTuutiLst.get(0).getSyono(), syoNo5, "証券番号");
        exNumericEquals(kouzaHnknTuutiLst.get(0).getEdano(), 10, "枝番号");
        exDateEquals(kouzaHnknTuutiLst.get(0).getTyouhyouymd(), BizDate.valueOf("20160103"), "帳票作成日");
        exClassificationEquals(kouzaHnknTuutiLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exStringEquals(kouzaHnknTuutiLst.get(0).getShskyno(), "1234567", "送付先郵便番号");
        exStringEquals(kouzaHnknTuutiLst.get(0).getShsadr1kj(), "通信先住所１通信先住所１通信先住所１通信先住所１通信先住所１", "送付先住所１（漢字）（３０桁）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getShsadr2kj(), "通信先住所２通信先住所２通信先住所２通信先住所２通信先住所２", "送付先住所２（漢字）（３０桁）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getShsadr3kj(), "通信先住所３通信先住所３通信先住所３通信先住所３通信先住所３", "送付先住所３（漢字）（３０桁）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getShsnmkj(), "契約者名契約者名契約者名契約者", "送付先氏名（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawasesosikinmkj(), "スミセイコールセンタースミセイ", "問合せ先組織名（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseyno(), "540-8512", "問合せ先郵便番号");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseadr1kj(), "大阪市中央区城見大阪市中央区城", "問合せ先住所１（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseadr2kj(), "１－４－３５１２３４５６７８９", "問合せ先住所２（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseadr3kj(), "組織窓口用漢字組織住所３３３３", "問合せ先住所３（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawasetelno(), "0120-506-08111", "問合せ先電話番号");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseteluktkkanou1(), "受付時間　　午前９時～午後６時", "問合せ先電話受付可能時間１");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawaseteluktkkanou2(), "　　　（土・日・祝日・年末年始除く）", "問合せ先電話受付可能時間２");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawasesosikinmkj2(), "", "第２問合せ先組織名（漢字）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getToiawasetelno2(), "", "第２問合せ先電話番号");
        exDateEquals(kouzaHnknTuutiLst.get(0).getHurikomiymd(), BizDate.valueOf("20160106"), "振込日");
        exBizCalcbleEquals(kouzaHnknTuutiLst.get(0).getShrgk(), BizCurrency.valueOf(1000000000000L), "支払金額");
        exClassificationEquals(kouzaHnknTuutiLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exStringEquals(kouzaHnknTuutiLst.get(0).getBankcd(), "9900", "銀行コード");
        exStringEquals(kouzaHnknTuutiLst.get(0).getSitencd(), "008", "支店コード");
        exClassificationEquals(kouzaHnknTuutiLst.get(0).getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(kouzaHnknTuutiLst.get(0).getKouzano(), "234567890123", "口座番号");
        exStringEquals(kouzaHnknTuutiLst.get(0).getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exDateEquals(kouzaHnknTuutiLst.get(0).getRyosyuymd(), BizDate.valueOf("20160101"), "領収日");
        exBizCalcbleEquals(kouzaHnknTuutiLst.get(0).getRsgaku(), BizCurrency.valueOf(1000000000000L), "領収金額");
        exDateYMEquals(kouzaHnknTuutiLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kouzaHnknTuutiLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kouzaHnknTuutiLst.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exStringEquals(kouzaHnknTuutiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_SyuunouHenknRireki oSyuunouHenknRireki = commonNyuukin.getSyuunouHenknRireki();
        exNumericEquals(oSyuunouHenknRireki.getEdano(), 10, "枝番号");
        exStringEquals(oSyuunouHenknRireki.getSyono(), syoNo5, "証券番号");
        exDateEquals(oSyuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf("20160103"), "伝票起票日");
        exDateEquals(oSyuunouHenknRireki.getShrymd(), BizDate.valueOf("20160106"), "支払日");
        exClassificationEquals(oSyuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exBizCalcbleEquals(oSyuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exClassificationEquals(oSyuunouHenknRireki.getShrriyuukbn(), C_ShrriyuuKbn.HARAIKOMIHUYOU, "支払理由区分");
        exStringEquals(oSyuunouHenknRireki.getBankcd(), "9900", "銀行コード");
        exStringEquals(oSyuunouHenknRireki.getSitencd(), "008", "支店コード");
        exClassificationEquals(oSyuunouHenknRireki.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(oSyuunouHenknRireki.getKouzano(), "234567890123", "口座番号");
        exStringEquals(oSyuunouHenknRireki.getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exStringEquals(oSyuunouHenknRireki.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBeanParam = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(BzDenpyouDataSksMockForKhansyuu.class, "execKh", 0, 0);
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyono(), "12806345834", "（ＩＢ）証券番号");
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
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbDensyorisyousaikbn(), null, "（ＩＢ）伝票用処理詳細区分");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyouhncd(), "ﾕｹ", "（ＩＢ）主契約商品コード");
        exNumericEquals(bzDenpyouDataTourokuBeanParam.getIbSyouhnsdno(), 1, "（IB）商品世代番号");
        exNumericEquals(bzDenpyouDataTourokuBeanParam.getBzSiwakeMeisaiBeanList().size(), 1, "仕訳明細リストの件数");

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_C6() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo6);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo6);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160105"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(2000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151230"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160106"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(2000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 2, "仮受金テーブルリスト件数");
        exStringEquals(itKariukekinList.get(1).getSyono(), syoNo6, "証券番号");
        exNumericEquals(itKariukekinList.get(1).getKrkno(), 2, "仮受番号");
        exDateEquals(itKariukekinList.get(1).getKrkkeijyoymd(), BizDate.valueOf("20160105"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekinList.get(1).getKrkgk(), BizCurrency.valueOf(new BigDecimal("2000")), "仮受金額");
        exDateEquals(itKariukekinList.get(1).getHasseidenymd(), BizDate.valueOf("20151230"), "発生伝票日付");
        exDateEquals(itKariukekinList.get(1).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(itKariukekinList.get(1).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(itKariukekinList.get(1).getKrkriyuukbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(itKariukekinList.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekinList.get(1).getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(itKariukekinList.get(1).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itKariukekinList.get(1).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekinList.get(1).getJyutoukaisuum(), 1, "充当回数（月）");
        exDateEquals(itKariukekinList.get(1).getRyosyuymd(), BizDate.valueOf("20151230"), "領収日");
        exStringEquals(itKariukekinList.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itKariukekinList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekinList.get(1).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();

        IT_Tokusin tokusin = itAnsyuKihon.getTokusin();
        assertNotNull(tokusin);

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo6, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード ");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo6, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20160105"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 1, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("2000")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20151230"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20151230"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "20160105", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "1012001", "出納組織コード");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(ansyuuCommonSiwakeInBean.getKinouId(), "khcommon", "機能ＩＤ");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getDensysKbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exDateEquals(ansyuuCommonSiwakeInBean.getDenYmd(), BizDate.valueOf("20151230"), "伝票日付");
        exDateEquals(ansyuuCommonSiwakeInBean.getSyoriYmd(), BizDate.valueOf("20160105"), "処理年月日");
        exDateEquals(ansyuuCommonSiwakeInBean.getKykYmd(), BizDate.valueOf("20151122"), "契約日");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getNykkeiro(), C_Nykkeiro.BANK, "保全入金経路");
        exStringEquals(ansyuuCommonSiwakeInBean.getSuitouSoshikiCd(), "1012001", "出納組織コード");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getShrhousiteiKbn(), null, "支払方法指定区分");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = ansyuuCommonSiwakeInBean.getAnsyuuTaisyouGkBeanLst();
        exNumericEquals(ansyuuTaisyouGkBeanLst.size(), 2, "対象金額リスト件数");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(0).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getTaisyouGk(), BizCurrency.valueOf(2000), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getKeiyakutuukaGk(), BizCurrency.valueOf(2000), "契約通貨金額");
        exDateEquals(ansyuuTaisyouGkBeanLst.get(0).getNykdenYmd(), null, "入金伝票日付");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(0).getHrkkaisuu(), null, "払込回数");
        exDateYMEquals(ansyuuTaisyouGkBeanLst.get(0).getJyutouStartYm(), null, "充当開始年月");
        assertNull(ansyuuTaisyouGkBeanLst.get(0).getJyutouKaisuuY());
        assertNull(ansyuuTaisyouGkBeanLst.get(0).getJyutouKaisuuM());

        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(1).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getTaisyouGk(), BizCurrency.valueOf(2000), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getKeiyakutuukaGk(), BizCurrency.valueOf(2000), "契約通貨金額");
        exDateEquals(ansyuuTaisyouGkBeanLst.get(1).getNykdenYmd(), null, "入金伝票日付");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(1).getHrkkaisuu(), null, "払込回数");
        exDateYMEquals(ansyuuTaisyouGkBeanLst.get(1).getJyutouStartYm(), null, "充当開始年月");
        assertNull(ansyuuTaisyouGkBeanLst.get(1).getJyutouKaisuuY());
        assertNull(ansyuuTaisyouGkBeanLst.get(1).getJyutouKaisuuM());

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean)MockObjectManager.getArgument(BzDenpyouDataSksMockForKhansyuu.class, "execKh", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDensyorisyousaikbn(), C_DenSyorisyousaiKbn.CREDIT, "（ＩＢ）伝票用処理詳細区分");

        IT_Kariukekin itKariukekin = commonNyuukin.getKariukekin();
        exNumericEquals(itKariukekin.getKrkno(), 2, "仮受番号");
        exDateEquals(itKariukekin.getKrkkeijyoymd(), BizDate.valueOf("20160105"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekin.getKrkgk(), BizCurrency.valueOf(2000), "仮受金額");
        exDateEquals(itKariukekin.getHasseidenymd(), BizDate.valueOf("20151230"), "発生伝票日付");
        exClassificationEquals(itKariukekin.getKrkriyuukbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(itKariukekin.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekin.getNykkeiro(), C_Nykkeiro.BANK, "入金経路");
        exDateYMEquals(itKariukekin.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itKariukekin.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekin.getJyutoukaisuum(), 1, "充当回数（月）");
        exDateEquals(itKariukekin.getRyosyuymd(), BizDate.valueOf("20151230"), "領収日");
        exClassificationEquals(itKariukekin.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itKariukekin.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(itKariukekin.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ID");
        exStringEquals(itKariukekin.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekin.getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_C7() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN4;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo7);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo7);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KYHKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151201"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20151201));
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 3, "入金実績履歴テーブルリスト件数");

        exStringEquals(nyknJissekiRirekiLst.get(2).getSyono(), syoNo7, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201603"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getRenno(), 10, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(2).getJyutouendym(), BizDateYM.valueOf("201603"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getRsgaku(), BizCurrency.valueOf(new BigDecimal("3000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(2).getRyosyukwsratekjymd(), BizDate.valueOf(20200814), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getIktwaribikikgk(), BizCurrency.valueOf(500), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(2).getRyosyuymd(), BizDate.valueOf("20151201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(2).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(2).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(2).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(2).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(2).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(2).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(0, itKariukekinList.size(), "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo7, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201604"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160401"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo7, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード ");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(ansyuuCommonSiwakeInBean.getKinouId(), "khcommon", "機能ＩＤ");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getDensysKbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exDateEquals(ansyuuCommonSiwakeInBean.getDenYmd(), BizDate.valueOf("20160103"), "伝票日付");
        exDateEquals(ansyuuCommonSiwakeInBean.getSyoriYmd(), BizDate.valueOf("20160103"), "処理年月日");
        exDateEquals(ansyuuCommonSiwakeInBean.getKykYmd(), BizDate.valueOf("20151122"), "契約日");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getNykkeiro(), C_Nykkeiro.KYHKIN, "保全入金経路");
        exStringEquals(ansyuuCommonSiwakeInBean.getSuitouSoshikiCd(), null, "出納組織コード");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getShrhousiteiKbn(), null, "支払方法指定区分");
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");
        List<AnsyuuTaisyouGkBean> ansyuuTaisyouGkBeanLst = ansyuuCommonSiwakeInBean.getAnsyuuTaisyouGkBeanLst();
        exNumericEquals(ansyuuTaisyouGkBeanLst.size(), 2, "対象金額リスト件数");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(0).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getTaisyouGk(), BizCurrency.valueOf(1), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(0).getKeiyakutuukaGk(), BizCurrency.valueOf(1), "契約通貨金額");
        exDateEquals(ansyuuTaisyouGkBeanLst.get(0).getNykdenYmd(), null, "入金伝票日付");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(0).getHrkkaisuu(), null, "払込回数");
        exDateYMEquals(ansyuuTaisyouGkBeanLst.get(0).getJyutouStartYm(), null, "充当開始年月");
        assertNull(ansyuuTaisyouGkBeanLst.get(0).getJyutouKaisuuY());
        assertNull(ansyuuTaisyouGkBeanLst.get(0).getJyutouKaisuuM());

        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(1).getKhDengkSyuruiKbn(), C_KhDengkSyuruiKbn.KEIJYOUP, "金額種類");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getTaisyouGk(), BizCurrency.valueOf(1), "対象金額");
        exBizCalcbleEquals(ansyuuTaisyouGkBeanLst.get(1).getKeiyakutuukaGk(), BizCurrency.valueOf(1), "契約通貨金額");
        exDateEquals(ansyuuTaisyouGkBeanLst.get(1).getNykdenYmd(), null, "入金伝票日付");
        exClassificationEquals(ansyuuTaisyouGkBeanLst.get(1).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exDateYMEquals(ansyuuTaisyouGkBeanLst.get(1).getJyutouStartYm(), BizDateYM.valueOf(201603), "充当開始年月");
        exNumericEquals(ansyuuTaisyouGkBeanLst.get(1).getJyutouKaisuuY(), 0, "充当回数（年）");
        exNumericEquals(ansyuuTaisyouGkBeanLst.get(1).getJyutouKaisuuM(), 1, "充当回数（月）");

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean)MockObjectManager.getArgument(BzDenpyouDataSksMockForKhansyuu.class, "execKh", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDensyorisyousaikbn(), C_DenSyorisyousaiKbn.CREDIT, "（ＩＢ）伝票用処理詳細区分");

        khozenCommonParam = (KhozenCommonParam)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 0);
        assertNotNull(khozenCommonParam.getAnsyuuKihon(syoNo7));
        exStringEquals((String)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 1), syoNo7, "証券番号");
        exClassificationEquals((C_TsrysyoriKbn)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 2), C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN, "手数料処理区分");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 3), BizDateYM.valueOf("201603"), "効力発生年月");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 4), 0, "入金回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 5), 1, "入金回数（月）");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 6), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 7), BizCurrency.valueOf(0), "一括払保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 8), BizDate.valueOf("20151201"), "入金日");
        assertNull(MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 9));
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_C8() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN3;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo8);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.HKNKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151201"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20151201));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 1, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo8, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201603"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201603"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.USD, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20151201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.HKNKIN, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        IT_Tokusin itTokusin = itAnsyuKihon.getTokusin();
        exStringEquals(itTokusin.getSyono(), syoNo8, "証券番号");
        exDateEquals(itTokusin.getTokusinendymd(), BizDate.valueOf("20171231"), "特伸終了日");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo8, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード ");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_C9() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo9);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo9);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KYHKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(6000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160201"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160102"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 3, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo9, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201603"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201603"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20151230"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        exStringEquals(nyknJissekiRirekiLst.get(1).getSyono(), syoNo9, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(1).getJyutoustartym(), BizDateYM.valueOf("201604"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(1).getJyutouendym(), BizDateYM.valueOf("201604"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(1).getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNykdenymd(), BizDate.valueOf("20151230"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(1).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(1).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(1).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(1).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(1).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(1).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(1).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(1).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(1).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        exStringEquals(nyknJissekiRirekiLst.get(2).getSyono(), syoNo9, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(2).getJyutoustartym(), BizDateYM.valueOf("201605"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(2).getJyutouendym(), BizDateYM.valueOf("201605"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getRsgaku(), BizCurrency.valueOf(new BigDecimal("1000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(2).getRyosyukwsratekjymd(), BizDate.valueOf("20200814"), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(2).getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNykdenymd(), BizDate.valueOf("20151230"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(2).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(2).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(2).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(2).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(2).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(2).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(2).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(2).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(2).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(2).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(itKariukekinList.get(0).getSyono(), syoNo9, "証券番号");
        exNumericEquals(itKariukekinList.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(itKariukekinList.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekinList.get(0).getKrkgk(), BizCurrency.valueOf(new BigDecimal("1000")), "仮受金額");
        exDateEquals(itKariukekinList.get(0).getHasseidenymd(), BizDate.valueOf("20151230"), "発生伝票日付");
        exDateEquals(itKariukekinList.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(itKariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(itKariukekinList.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(itKariukekinList.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekinList.get(0).getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exDateYMEquals(itKariukekinList.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itKariukekinList.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekinList.get(0).getJyutoukaisuum(), 3, "充当回数（月）");
        exDateEquals(itKariukekinList.get(0).getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exStringEquals(itKariukekinList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itKariukekinList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekinList.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo9, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201606"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo9, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

        exStringEquals((String)MockObjectManager.getArgument(SetYuuyokknmanryobiMockForKhansyuu.class, "exec", 0, 0), syoNo9, "証券番号");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(SetYuuyokknmanryobiMockForKhansyuu.class, "exec", 0, 1), BizDateYM.valueOf("201606"), "充当年月");

        khozenCommonParam = (KhozenCommonParam)MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 0);
        assertNotNull(khozenCommonParam.getAnsyuuKihon(syoNo9));
        exStringEquals((String)MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 1), syoNo9, "証券番号");
        exClassificationEquals((C_KjsymnytblhensyuusyoriKbn)MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 2), C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, "控除証明内容TBL編集処理区分");
        exDateEquals((BizDate)MockObjectManager.getArgument(EditKoujyonaiyouTblMockForKhansyuu.class, "exec", 0, 3), BizDate.valueOf("20160103"), "処理日");

        khozenCommonParam = (KhozenCommonParam)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 0);
        assertNotNull(khozenCommonParam.getAnsyuuKihon(syoNo9));
        exStringEquals((String)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 1), syoNo9, "証券番号");
        exClassificationEquals((C_TsrysyoriKbn)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 2), C_TsrysyoriKbn.SYOUMETUGOKZPNYUUKIN, "手数料処理区分");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 3), BizDateYM.valueOf("201603"), "効力発生年月");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 4), 0, "入金回数（年）");
        exNumericEquals((int)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 5), 3, "入金回数（月）");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 6), BizCurrency.valueOf(0), "未経過保険料");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 7), BizCurrency.valueOf(0), "一括払保険料");
        exDateEquals((BizDate)MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 8), BizDate.valueOf("20160201"), "入金日");
        assertNull(MockObjectManager.getArgument(EditDairitenTesuuryouTblMockForKhansyuu.class, "exec", 0, 9));

        IT_Kariukekin itKariukekin = commonNyuukin.getKariukekin();
        exNumericEquals(itKariukekin.getKrkno(), 1, "仮受番号");
        exDateEquals(itKariukekin.getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekin.getKrkgk(), BizCurrency.valueOf(1000), "仮受金額");
        exDateEquals(itKariukekin.getHasseidenymd(), BizDate.valueOf("20151230"), "発生伝票日付");
        exClassificationEquals(itKariukekin.getKrkriyuukbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(itKariukekin.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekin.getNykkeiro(), C_Nykkeiro.KYHKIN, "入金経路");
        exDateYMEquals(itKariukekin.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itKariukekin.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekin.getJyutoukaisuum(), 3, "充当回数（月）");
        exDateEquals(itKariukekin.getRyosyuymd(), BizDate.valueOf("20160201"), "領収日");
        exClassificationEquals(itKariukekin.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itKariukekin.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(itKariukekin.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ID");
        exStringEquals(itKariukekin.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekin.getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_C10() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN2;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo10);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo10);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170102"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 1, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo10, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201603"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201603"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(new BigDecimal("3000")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), BizDate.valueOf("20200814"), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("1000")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "123456789012345678", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo10, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201604"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo10, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20160201"), "伝票日付");
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
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160201"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "12340000", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        assertNull(commonNyuukin.getNyuukinKakusyouData());

    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_C11() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo11);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo11);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160231"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KYHKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201511));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170104"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160103));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");
        exBooleanEquals(commonNyuukin.getJidonhnknumu(), false, "自動返金有無");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 3, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo11, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201602"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo11, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_C12() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo12);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo12);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150630"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170104"));
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKINHITUYOU, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo12, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201511"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo12, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), syoNo12, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(1).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(1).getDenymd(), BizDate.valueOf("20151231"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(1).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
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
        exStringEquals(itKhDenpyoDataList.get(1).getSyusyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(1).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(1).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(1).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(1).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(1).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        IT_KhFBSoukinData khFBSoukinData = commonNyuukin.getKhFBSoukinData();

        exStringEquals(khFBSoukinData.getSyono(), syoNo12, "証券番号");
        exNumericEquals(khFBSoukinData.getEdano(), 0, "枝番号");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(khFBSoukinData.getSyoricd(), "RG9F", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "12340000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20150630"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20150703"), "伝票日付");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "8900", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "123456789012", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(10), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_C13() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo13);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo13);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo13);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170104"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo13, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201511"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 2, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo13, "証券番号");
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
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "001", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        exNumericEquals(itKhDenpyoDataList.get(1).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(1).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(1).getSyono(), syoNo13, "証券番号");
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

        IT_KhFBSoukinData khFBSoukinData = commonNyuukin.getKhFBSoukinData();
        exStringEquals(khFBSoukinData.getSyono(), syoNo13, "証券番号");
        exNumericEquals(khFBSoukinData.getEdano(), 10, "枝番号");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(khFBSoukinData.getSyoricd(), "RG9F", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "12340000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20150531"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20150603"), "伝票日付");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "002", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "123456789012", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "カナカナカナカナカナカナカナカナカナカナカナカナカナカナカナ", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(10), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(0), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_C14() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;


        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo14);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo14);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);
        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo14);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150630"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170104"));
        nyuukinTRParam.setCreditUriageSeikyuuKbn(C_CreditUriageSeikyuuKbn.TUUJYOU);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUTUKISOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(itKariukekinList.get(0).getSyono(), syoNo14, "証券番号");
        exNumericEquals(itKariukekinList.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(itKariukekinList.get(0).getKrkkeijyoymd(), BizDate.valueOf("20150630"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekinList.get(0).getKrkgk(), BizCurrency.valueOf(new BigDecimal("10")), "仮受金額");
        exDateEquals(itKariukekinList.get(0).getHasseidenymd(), BizDate.valueOf("20150630"), "発生伝票日付");
        exDateEquals(itKariukekinList.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(itKariukekinList.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(itKariukekinList.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.ZYUTOUTUKISOUI, "仮受理由区分");
        exClassificationEquals(itKariukekinList.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekinList.get(0).getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exDateYMEquals(itKariukekinList.get(0).getJyuutouym(), BizDateYM.valueOf("201511"), "充当年月");
        exNumericEquals(itKariukekinList.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekinList.get(0).getJyutoukaisuum(), 1, "充当回数（月）");
        exDateEquals(itKariukekinList.get(0).getRyosyuymd(), BizDate.valueOf("20150531"), "領収日");
        exStringEquals(itKariukekinList.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(itKariukekinList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekinList.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        IT_AnsyuKihon itAnsyuKihon = commonNyuukin.getAnsyuKihon();
        exStringEquals(itAnsyuKihon.getSyono(), syoNo14, "証券番号");
        exDateYMEquals(itAnsyuKihon.getJkipjytym(), BizDateYM.valueOf("201512"), "次回Ｐ充当年月");
        exClassificationEquals(itAnsyuKihon.getTkiktannaitukisuu(), C_Tkiktannaitukisuu.BLNK, "定期一括案内月数");
        exClassificationEquals(itAnsyuKihon.getKjsmhakkouzumiflg(), C_Kjsmhakkouzumiflg.BLNK, "控除証明書発行済フラグ");
        exDateEquals(itAnsyuKihon.getSyuharaimanymd(), BizDate.valueOf("20160501"), "主契約払満日");
        exStringEquals(itAnsyuKihon.getGyoumuKousinKinou(), null, "業務用更新機能ＩＤ");
        exStringEquals(itAnsyuKihon.getGyoumuKousinsyaId(), null, "業務用更新者ＩＤ");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 10, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
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
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBeanParam = (BzDenpyouDataTourokuBean) MockObjectManager.
            getArgument(BzDenpyouDataSksMockForKhansyuu.class, "execKh", 0);
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyono(), "11810111255", "（ＩＢ）証券番号");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbHuridenatesakicd(), "1234", "（ＩＢ）振替伝票宛先部課コード");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbTantocd(), C_TantouCdKbn.KAIYAKU,
            "（ＩＢ）担当コード");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbDenymd(), BizDate.valueOf("20151231"), "（ＩＢ）伝票日付");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbTuukasyu(), C_Tuukasyu.JPY, "（ＩＢ）通貨種類");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbHuridenskskbn(), C_HuridensksKbn.BLNK,
            "（ＩＢ）振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbDenhnknhoukbn(), C_DenhnknhouKbn.BLNK,
            "（ＩＢ）伝票用返金方法区分");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbDenshrhoukbn(), C_DenshrhouKbn.BLNK,
            "（ＩＢ）伝票用支払方法区分");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbSyoriymd(), BizDate.valueOf("20160105"), "（ＩＢ）処理年月日");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyoricd(), "RG9F", "（ＩＢ）処理コード");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbSyorisosikicd(), "12340000", "（ＩＢ）処理組織コード");
        exClassificationEquals(bzDenpyouDataTourokuBeanParam.getIbKyktuukasyu(), C_Tuukasyu.JPY,
            "（ＩＢ）契約通貨種類");
        exStringEquals(bzDenpyouDataTourokuBeanParam.getIbGyoumuKousinsyaId(), "JUnit", "（ＩＢ）業務用更新者ＩＤ");
        exBooleanEquals(bzDenpyouDataTourokuBeanParam.getIbKakokawaserateshiteiflg(), false,
            "（ＩＢ）過去為替レート指定フラグ");
        exDateEquals(bzDenpyouDataTourokuBeanParam.getIbKakokawaserateshiteiymd(), null,
            "（ＩＢ）過去為替レート指定年月日");
        exNumericEquals(bzDenpyouDataTourokuBeanParam.getBzSiwakeMeisaiBeanList().size(), 1, "仕訳明細リストの件数");

        IT_Kariukekin itKariukekin = commonNyuukin.getKariukekin();
        exNumericEquals(itKariukekin.getKrkno(), 1, "仮受番号");
        exDateEquals(itKariukekin.getKrkkeijyoymd(), BizDate.valueOf("20150630"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekin.getKrkgk(), BizCurrency.valueOf(10), "仮受金額");
        exDateEquals(itKariukekin.getHasseidenymd(), BizDate.valueOf("20150630"), "発生伝票日付");
        exClassificationEquals(itKariukekin.getKrkriyuukbn(), C_KrkriyuuKbn.ZYUTOUTUKISOUI, "仮受理由区分");
        exClassificationEquals(itKariukekin.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekin.getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exDateYMEquals(itKariukekin.getJyuutouym(), BizDateYM.valueOf("201511"), "充当年月");
        exNumericEquals(itKariukekin.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekin.getJyutoukaisuum(), 1, "充当回数（月）");
        exDateEquals(itKariukekin.getRyosyuymd(), BizDate.valueOf("20150531"), "領収日");
        exClassificationEquals(itKariukekin.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itKariukekin.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(itKariukekin.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ID");
        exStringEquals(itKariukekin.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekin.getCreditkessaiyouno(), "", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_C15() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo15);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo15);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo15);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(20));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170104"));

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 1, "入金実績履歴テーブルリスト件数");
        exStringEquals(nyknJissekiRirekiLst.get(0).getSyono(), syoNo15, "証券番号");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutoustartym(), BizDateYM.valueOf("201512"), "充当開始年月");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getRenno(), 1, "連番");
        exDateYMEquals(nyknJissekiRirekiLst.get(0).getJyutouendym(), BizDateYM.valueOf("201701"), "充当終了年月");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRsgaku(), BizCurrency.valueOf(new BigDecimal("123")), "領収金額");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsratekjymd(), BizDate.valueOf("20200814"), "領収為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getHrkp(), BizCurrency.valueOf(new BigDecimal("20")), "払込保険料");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyksyoriymd(), BizDate.valueOf("20150531"), "入金処理日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getRyosyuymd(), BizDate.valueOf("20150531"), "領収日");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNykdenymd(), BizDate.valueOf("20150531"), "入金伝票日付");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuuy(), 1, "充当回数（年）");
        exNumericEquals(nyknJissekiRirekiLst.get(0).getJyutoukaisuum(), 2, "充当回数（月）");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exClassificationEquals(nyknJissekiRirekiLst.get(0).getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksymd(), null, "入金取消処理日");
        exStringEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenno(), "", "入金取消伝票番号");
        exDateEquals(nyknJissekiRirekiLst.get(0).getNyktrksdenymd(), null, "入金取消伝票日付");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansannyknkingk(), BizCurrency.valueOf(0), "円換算入金額");
        exDateEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrateymd(), null, "円換算適用為替レート基準日");
        exBizCalcbleEquals(nyknJissekiRirekiLst.get(0).getYenkansantkykwsrate(), BizNumber.valueOf(0), "円換算適用為替レート");
        exStringEquals(nyknJissekiRirekiLst.get(0).getHenkousikibetukey(), "1", "変更識別キー");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(nyknJissekiRirekiLst.get(0).getCreditkessaiyouno(), "", "クレジットカード決済用番号");

        List<IT_Kariukekin> itKariukekinList = itKykKihon.getKariukekins();
        exNumericEquals(itKariukekinList.size(), 0, "仮受金テーブルリスト件数");

        assertNull(commonNyuukin.getKhFBSoukinData());

    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_C16() {
        MockObjectManager.initialize();

        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN6;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo18);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(new BigDecimal("2100000000000")));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setKzHurikaeBankCd("1001");
        nyuukinTRParam.setKzHurikaeSitenCd("101");
        nyuukinTRParam.setSuitoSoshikiCd("1012001");
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setZengetumatuDenSimeYmd(null);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setSeisonmotoDenymd(BizDate.valueOf("20170201"));
        nyuukinTRParam.setSeisantgkmkHasseidenYmd(BizDate.valueOf(20160103));
        nyuukinTRParam.setCreditkessaiyouno("12345678901234567890123456");

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "仮受金額");

        IT_KykKihon itKykKihon = commonNyuukin.getKykKihon();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = itKykKihon.getNyknJissekiRirekis();
        exNumericEquals(nyknJissekiRirekiLst.size(), 0, "入金実績履歴テーブルリスト件数");

        List<IT_Kariukekin> kariukekinLst = itKykKihon.getKariukekins();
        exNumericEquals(kariukekinLst.size(), 1, "仮受金テーブルリスト件数");
        exStringEquals(kariukekinLst.get(0).getSyono(), syoNo18, "証券番号");
        exNumericEquals(kariukekinLst.get(0).getKrkno(), 1, "仮受番号");
        exDateEquals(kariukekinLst.get(0).getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(kariukekinLst.get(0).getKrkgk(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "仮受金額");
        exDateEquals(kariukekinLst.get(0).getHasseidenymd(), BizDate.valueOf("20160103"), "発生伝票日付");
        exDateEquals(kariukekinLst.get(0).getSeisandenymd(), null, "精算伝票日付");
        exClassificationEquals(kariukekinLst.get(0).getKrkseisanzumiflg(), C_Krkseisanzumiflg.BLNK, "仮受精算済フラグ");
        exClassificationEquals(kariukekinLst.get(0).getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(kariukekinLst.get(0).getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(kariukekinLst.get(0).getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(kariukekinLst.get(0).getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(kariukekinLst.get(0).getJyutoukaisuum(), 11, "充当回数（月）");
        exDateEquals(kariukekinLst.get(0).getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ＩＤ");
        exStringEquals(kariukekinLst.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(kariukekinLst.get(0).getCreditkessaiyouno(), "12345678901234567890123456", "クレジットカード決済用番号");

        List<IT_KhDenpyoData> itKhDenpyoDataList = commonNyuukin.getKhDenpyoDatas();
        exNumericEquals(itKhDenpyoDataList.size(), 1, "契約保全伝票データテーブルリスト件数");
        exNumericEquals(itKhDenpyoDataList.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(itKhDenpyoDataList.get(0).getSyono(), syoNo18, "証券番号");
        exStringEquals(itKhDenpyoDataList.get(0).getHuridenatesakicd(), "1234", "振替伝票宛先部課コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(itKhDenpyoDataList.get(0).getDenymd(), BizDate.valueOf("20210226"), "伝票日付");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE, "勘定科目コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSuitoubumoncd(), "1234", "出納部門コード");
        exClassificationEquals(itKhDenpyoDataList.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenkawaserate(), BizNumber.valueOf(0), "伝票用為替レート");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(itKhDenpyoDataList.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(itKhDenpyoDataList.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(itKhDenpyoDataList.get(0).getSyoriYmd(), BizDate.valueOf("20160103"), "処理年月日");
        exStringEquals(itKhDenpyoDataList.get(0).getSyoricd(), "RG9F", "処理コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyorisosikicd(), "", "処理組織コード");
        exStringEquals(itKhDenpyoDataList.get(0).getSyusyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(itKhDenpyoDataList.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exBooleanEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(itKhDenpyoDataList.get(0).getKakokawaserateshiteiymd(), null, "過去為替レート指定年月日");
        exClassificationEquals(itKhDenpyoDataList.get(0).getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(itKhDenpyoDataList.get(0).getKeiyakutuukagk(), BizCurrency.valueOf(0), "契約通貨金額");
        exStringEquals(itKhDenpyoDataList.get(0).getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");

        assertNull(commonNyuukin.getKhFBSoukinData());

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syoNo18, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20160103"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 11, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20160103"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "1234", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "1001", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "101", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");

        MockObjectManager.assertNotCalled(EditDairitenTesuuryouTblMockForKhansyuu.class, "setBatchSyoriYmd");

        IT_Kariukekin itKariukekin = commonNyuukin.getKariukekin();
        exNumericEquals(itKariukekin.getKrkno(), 1, "仮受番号");
        exDateEquals(itKariukekin.getKrkkeijyoymd(), BizDate.valueOf("20160103"), "仮受計上処理日");
        exBizCalcbleEquals(itKariukekin.getKrkgk(), BizCurrency.valueOf(new BigDecimal("2100000000000")), "仮受金額");
        exDateEquals(itKariukekin.getHasseidenymd(), BizDate.valueOf("20160103"), "発生伝票日付");
        exClassificationEquals(itKariukekin.getKrkriyuukbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(itKariukekin.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(itKariukekin.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateYMEquals(itKariukekin.getJyuutouym(), BizDateYM.valueOf("201603"), "充当年月");
        exNumericEquals(itKariukekin.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itKariukekin.getJyutoukaisuum(), 11, "充当回数（月）");
        exDateEquals(itKariukekin.getRyosyuymd(), BizDate.valueOf("20160103"), "領収日");
        exClassificationEquals(itKariukekin.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itKariukekin.getTikiktbrisyuruikbn(), C_TkiktbrisyuruiKbn.NONE, "定期一括払種類区分");
        exStringEquals(itKariukekin.getGyoumuKousinKinou(), khozenCommonParam.getFunctionId(), "業務用更新機能ID");
        exStringEquals(itKariukekin.getGyoumuKousinsyaId(), khozenCommonParam.getUserID(), "業務用更新者ＩＤ");
        exStringEquals(itKariukekin.getCreditkessaiyouno(), "12345678901234567890123456", "クレジットカード決済用番号");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_C17() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000172");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000172");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000172");
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

        IT_SyuunouHenknRireki syuunouHenknRireki = commonNyuukin.getSyuunouHenknRireki();
        exStringEquals(syuunouHenknRireki.getSyono(), "17806000172", "証券番号");
        exStringEquals(syuunouHenknRireki.getDenrenno(), "100001", "伝票データ連番");
        exNumericEquals(syuunouHenknRireki.getEdano(), 10, "枝番号");
        exDateEquals(syuunouHenknRireki.getDenkihyouymd(), BizDate.valueOf("20151230"), "伝票起票日");
        exDateEquals(syuunouHenknRireki.getShrymd(), BizDate.valueOf("20151231"), "支払日");
        exClassificationEquals(syuunouHenknRireki.getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "勘定科目コード");
        exBizCalcbleEquals(syuunouHenknRireki.getHnkngk(), BizCurrency.valueOf(1000000000000L), "返金額");
        exStringEquals(syuunouHenknRireki.getCreditkessaiyouno(), "22345678901234567890123456", "クレジットカード決済用番号");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_C18() {

        changeSystemDate(BizDate.valueOf(20201205));

        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setSyoricd("RB30");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000389");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000389");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000389");
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.HKNKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
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
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf(20201205), "1");
        exDateEquals(sikinIdouRireki.getSyoriYmd(), BizDate.valueOf(20201205), "処理年月日");
        exStringEquals(sikinIdouRireki.getKeirisyorirenno(), "1", "経理用処理連番");
        exStringEquals(sikinIdouRireki.getSyono(), "17806000389", "証券番号");
        exStringEquals(sikinIdouRireki.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(sikinIdouRireki.getTargetKinouId(), "khcommon", "対象機能ＩＤ");
        exStringEquals(sikinIdouRireki.getSkno(), "", "請求番号");
        exNumericEquals(sikinIdouRireki.getSeikyuurirekino(), 0, "請求履歴番号");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(sikinIdouRireki.getNykshrkbn(), C_NykshrKbn.NYUUKIN, "入金支払区分");
        exStringEquals(sikinIdouRireki.getSyoricd(), "RB30", "処理コード");
        exClassificationEquals(sikinIdouRireki.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(sikinIdouRireki.getDenrenno(), "100001", "伝票データ連番");
        exClassificationEquals(sikinIdouRireki.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(sikinIdouRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(sikinIdouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(sikinIdouRireki.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exStringEquals(sikinIdouRireki.getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(sikinIdouRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(sikinIdouRireki.getKyksyouhnrenno(), 1, "契約商品連番");
        exClassificationEquals(sikinIdouRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exDateYMEquals(sikinIdouRireki.getPhendoukaisiym(), null, "Ｐ変動開始年月");
        exBizCalcbleEquals(sikinIdouRireki.getPhendoumaegk(), BizCurrency.valueOf(0), "Ｐ変動前金額");
        exBizCalcbleEquals(sikinIdouRireki.getPhendougogk(), BizCurrency.valueOf(0), "Ｐ変動後金額");
        exDateEquals(sikinIdouRireki.getKykymd(), BizDate.valueOf(20151122), "契約日");
        exDateEquals(sikinIdouRireki.getSeirituymd(), BizDate.valueOf(20201105), "成立日");
        exDateYMEquals(sikinIdouRireki.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exClassificationEquals(sikinIdouRireki.getShrsyorikbn(), C_ShrsyoriKbn.BLNK, "支払処理区分");
        exClassificationEquals(sikinIdouRireki.getSeikyuusyubetu(), C_SeikyuuSyubetu.BLNK, "請求種別");
        exClassificationEquals(sikinIdouRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateYMEquals(sikinIdouRireki.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exDateYMEquals(sikinIdouRireki.getJyutoustartym(), BizDateYM.valueOf(201603), "充当開始年月");
        exDateYMEquals(sikinIdouRireki.getJyutouendym(), BizDateYM.valueOf(201605), "充当終了年月");
        exClassificationEquals(sikinIdouRireki.getNykkeiro(), C_Nykkeiro.HKNKIN, "入金経路");
        exClassificationEquals(sikinIdouRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(sikinIdouRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exBizCalcbleEquals(sikinIdouRireki.getHrkp(), BizCurrency.valueOf(1000), "払込保険料");
        exBizCalcbleEquals(sikinIdouRireki.getHokenryou(), BizCurrency.valueOf(123456789), "保険料");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_C19() {

        changeSystemDate(BizDate.valueOf(20201206));

        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN3;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN6;
        CreditHnknTuutiSksMockForKhansyuu.SYORIPTN = CreditHnknTuutiSksMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setSyoricd("RB30");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);
        baseUserInfo.getUser().setUserId("JUnit");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000390");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000390");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000390");
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20160103"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.HKNKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf(201603));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
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
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        BT_SikinIdouRireki sikinIdouRireki = bizDomManager.getSikinIdouRireki(BizDate.valueOf(20201206), "1");
        exDateEquals(sikinIdouRireki.getSyoriYmd(), BizDate.valueOf(20201206), "処理年月日");
        exStringEquals(sikinIdouRireki.getKeirisyorirenno(), "1", "経理用処理連番");
        exStringEquals(sikinIdouRireki.getSyono(), "17806000390", "証券番号");
        exStringEquals(sikinIdouRireki.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exStringEquals(sikinIdouRireki.getTargetKinouId(), "khcommon", "対象機能ＩＤ");
        exStringEquals(sikinIdouRireki.getSkno(), "", "請求番号");
        exNumericEquals(sikinIdouRireki.getSeikyuurirekino(), 0, "請求履歴番号");
        exClassificationEquals(sikinIdouRireki.getSakujyoflg(), C_Delflag.BLNK, "削除フラグ");
        exClassificationEquals(sikinIdouRireki.getNykshrkbn(), C_NykshrKbn.NYUUKIN, "入金支払区分");
        exStringEquals(sikinIdouRireki.getSyoricd(), "RB30", "処理コード");
        exClassificationEquals(sikinIdouRireki.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exStringEquals(sikinIdouRireki.getDenrenno(), "100001", "伝票データ連番");
        exClassificationEquals(sikinIdouRireki.getSeg1cd(), C_Segcd.USDSISUURENDOUNENKINITIJIJYUNYUU, "セグメント１コード");
        exClassificationEquals(sikinIdouRireki.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exClassificationEquals(sikinIdouRireki.getSyutkkbn(), C_SyutkKbn.SYU, "主契約特約区分");
        exClassificationEquals(sikinIdouRireki.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exStringEquals(sikinIdouRireki.getSyouhncd(), "ﾕｹ", "商品コード");
        exNumericEquals(sikinIdouRireki.getSyouhnsdno(), 1, "商品世代番号");
        exNumericEquals(sikinIdouRireki.getKyksyouhnrenno(), 1, "契約商品連番");
        exClassificationEquals(sikinIdouRireki.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exDateYMEquals(sikinIdouRireki.getPhendoukaisiym(), null, "Ｐ変動開始年月");
        exBizCalcbleEquals(sikinIdouRireki.getPhendoumaegk(), BizCurrency.valueOf(0), "Ｐ変動前金額");
        exBizCalcbleEquals(sikinIdouRireki.getPhendougogk(), BizCurrency.valueOf(0), "Ｐ変動後金額");
        exDateEquals(sikinIdouRireki.getKykymd(), BizDate.valueOf(20151122), "契約日");
        exDateEquals(sikinIdouRireki.getSeirituymd(), BizDate.valueOf(20201105), "成立日");
        exDateYMEquals(sikinIdouRireki.getMisyuupjyuutouym(), null, "未収保険料充当年月");
        exClassificationEquals(sikinIdouRireki.getShrsyorikbn(), C_ShrsyoriKbn.BLNK, "支払処理区分");
        exClassificationEquals(sikinIdouRireki.getSeikyuusyubetu(), C_SeikyuuSyubetu.BLNK, "請求種別");
        exClassificationEquals(sikinIdouRireki.getSyoumetujiyuu(), C_Syoumetujiyuu.BLNK, "消滅事由");
        exDateYMEquals(sikinIdouRireki.getJkipjytym(), BizDateYM.valueOf(201606), "次回Ｐ充当年月");
        exDateYMEquals(sikinIdouRireki.getJyutoustartym(), BizDateYM.valueOf(201603), "充当開始年月");
        exDateYMEquals(sikinIdouRireki.getJyutouendym(), BizDateYM.valueOf(201605), "充当終了年月");
        exClassificationEquals(sikinIdouRireki.getNykkeiro(), C_Nykkeiro.HKNKIN, "入金経路");
        exClassificationEquals(sikinIdouRireki.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(sikinIdouRireki.getNyktrksflg(), C_Nyktrksflg.BLNK, "入金取消フラグ");
        exBizCalcbleEquals(sikinIdouRireki.getHrkp(), BizCurrency.valueOf(1000), "払込保険料");
        exBizCalcbleEquals(sikinIdouRireki.getHokenryou(), BizCurrency.valueOf(223456789), "保険料");
    }
}