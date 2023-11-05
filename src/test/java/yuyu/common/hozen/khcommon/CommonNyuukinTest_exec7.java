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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.GetasPRsTuukaMockForKhansyuu;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuMockForKhansyuu;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.ascommon.SetMinusUriagebiMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 入金共通処理クラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec7 {

    private final static String syoNo1 = "11807111118";

    private final static String syoNo2 = "11807111129";

    private final static String syoNo3 = "11807111130";

    private final static String syoNo4 = "11807111141";

    private final static String syoNo5 = "11807111152";

    private final static String syoNo6 = "11807111163";

    private final static String syoNo7 = "11807111174";

    private final static String syoNo8 = "11807111185";

    private final static String syoNo9 = "11807111196";

    private final static String syoNo10 = "11807111200";

    private final static String syoNo11 = "11807111211";

    private final static String syoNo12 = "11807111222";

    @Inject
    private CommonNyuukin commonNyuukin;

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
                bind(GetasPRsTuuka.class).to(GetasPRsTuukaMockForKhansyuu.class);
                bind(KeisanRsgaku.class).to(KeisanRsgakuMockForKhansyuu.class);
                bind(SetMinusUriagebi.class).to(SetMinusUriagebiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        EditKoujyonaiyouTblMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        EditDairitenTesuuryouTblMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        GetasPRsTuukaMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        KeisanRsgakuMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
        SetMinusUriagebiMockForKhansyuu.caller = CommonNyuukinTest_exec7.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec7.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
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
        GetasPRsTuukaMockForKhansyuu.caller = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = null;
        KeisanRsgakuMockForKhansyuu.caller = null;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = null;
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
    }

    @Test
    @TestOrder(1)
    @Transactional
    public void testExec_G1() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo1);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151119"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(2)
    @Transactional
    public void testExec_G2() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo2);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo2);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo2);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.PMENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151119"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(3)
    @Transactional
    public void testExec_G3() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo3);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo3);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151019"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(4)
    @Transactional
    public void testExec_G4() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo4);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo4);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151019"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKINHITUYOU, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(5)
    @Transactional
    public void testExec_G5() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;

        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo5);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo5);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo5);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(6)
    @Transactional
    public void testExec_G6() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo6);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo6);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo6);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1010));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(990), "仮受金額");
    }

    @Test
    @TestOrder(7)
    @Transactional
    public void testExec_G7() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo7);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo7);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo7);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(8)
    @Transactional
    public void testExec_G8() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo8);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo8);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo8);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(9)
    @Transactional
    public void testExec_G9() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo9);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo9);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo9);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_G10() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo10);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo10);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo10);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void testExec_G11() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo11);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo11);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(12)
    @Transactional
    public void testExec_G12() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo12);
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(syoNo12);
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syoNo12);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.OTHER);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn( C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_G13() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000138");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000138");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000138");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1010));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setCreditkessaiyouno("");

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "000000000000000021", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(990), "仮受金額");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_G14() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000149");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000149");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1010));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setCreditkessaiyouno(null);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.ARI, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "000000000000000022", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(990), "仮受金額");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_G15() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        EditKoujyonaiyouTblMockForKhansyuu.SYORIPTN = EditKoujyonaiyouTblMockForKhansyuu.TESTPATTERN1;
        EditDairitenTesuuryouTblMockForKhansyuu.SYORIPTN = EditDairitenTesuuryouTblMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;
        asKinou.setKinouId("khcommon");
        asKinou.setKinouKbn(C_KinouKbn.BATCH);
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000150");
        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon("17806000150");
        khozenCommonParam.setBatchKeiyakuKihon(kykKihon);
        khozenCommonParam.setBatchAnsyuKihon(ansyuKihon);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000150");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1010));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.YOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        nyuukinTRParam.setCreditkessaiyouno("001");

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.YOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(990), "仮受金額");
    }
}