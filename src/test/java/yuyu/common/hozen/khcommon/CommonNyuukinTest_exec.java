package yuyu.common.hozen.khcommon;

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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataSksMockForKhansyuu;
import yuyu.common.hozen.ascommon.AnsyuuBatSyoriHunoKykMisslistSks;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.ascommon.GetasPRsTuukaMockForKhansyuu;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.ascommon.KeisanRsgakuMockForKhansyuu;
import yuyu.common.hozen.ascommon.SetMinusUriagebi;
import yuyu.common.hozen.ascommon.SetMinusUriagebiMockForKhansyuu;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_CommonNyuukinErrorRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KrkPayEasyHrkmyousiNkKbn;
import yuyu.def.classification.C_KrkriyuuKbn;
import yuyu.def.classification.C_NykhouhouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * CommonNyuukinクラスのメソッド {@link CommonNyuukin#exec(KhozenCommonParam,NyuukinTRParam,C_YouhiKbn,C_YouhiKbn,AnsyuuBatSyoriHunoKykMisslistSks)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonNyuukinTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_入金共通処理_入金チェック処理";

    private final static String sheetName = "テストデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    private final static String syono1 = "11807111118";

    private final static String syono2 = "11807111129";

    private final static String syono3 = "11807111130";

    private final static String syono4 = "11807111141";

    private final static String syono9 = "11807111196";

    private final static String syono10 = "11807111200";

    private final static String syono11 = "11807111211";

    private final static String syono12 = "11807111222";

    private final static String syono13 = "11807111233";

    private final static String syono14 = "11807111244";

    private final static String syono15 = "11807111255";

    private final static String syono16 = "11807111266";

    private final static String syono17 = "11807111277";

    private final static String syono18 = "11807111288";

    private final static String syono19 = "11807111299";

    private final static String syono20 = "11807111303";

    private final static String syono21 = "11807111314";

    private final static String syono23 = "11807111336";

    private final static String syono24 = "11807111347";

    private final static String syono25 = "11807111358";

    private final static String syono26 = "11807111369";

    private final static String syono27 = "11807111370";

    private final static String syono30 = "11807111406";

    private final static String syono31 = "11808111111";

    private final static String syono32 = "11808111122";

    private final static String syono33 = "11808111133";

    private final static String syono34 = "11808111144";

    private final static String syono35 = "11808111155";

    private final static String syono36 = "11808111166";

    private final static String syono54 = "11808111340";

    private final static String syono55 = "11808111351";

    private final static String syono56 = "11808111362";

    private final static String syono57 = "11808111373";

    private final static String syono59 = "11808111395";

    private final static String syono60 = "11808111409";

    private final static String syono61 = "11809111114";

    private final static String syono62 = "11809111125";

    private final static String syono63 = "11809111136";

    private final static String syono64 = "11809111147";

    private final static String syono65 = "11809111158";

    private final static String syono66 = "11809111169";

    private final static String syono67 = "11809111170";

    private final static String syono69 = "11809111192";

    private final static String syono70 = "11809111206";

    private final static String syono71 = "11809111217";

    private final static String syono72 = "11809111228";

    private final static String syono73 = "11809111239";

    private final static String syono74 = "11809111240";

    private final static String syono75 = "11809111251";

    private final static String syono77 = "11809111273";

    private final static String syono78 = "11809111284";

    private final static String syono79 = "11809111295";

    private final static String syono80 = "11809111309";

    private final static String syono81 = "11809111310";

    private final static String syono82 = "11809111321";

    private final static String syono83 = "11809111332";

    private final static String syono84 = "11809111343";

    private final static String syono85 = "11809111354";

    private final static String syono86 = "11809111365";

    private final static String syono87 = "11809111376";

    private final static String syono88 = "11809111387";

    private final static String syono89 = "11809111398";

    private final static String syono90 = "11809111402";

    private final static String syono92 = "11809111424";

    private final static String syono93 = "11809111435";

    private final static String syono94 = "11809111446";

    private final static String syono95 = "11809111457";

    private final static String syono96 = "11809111468";

    private final static String syono103 = "11810111118";

    private final static String syono105 = "11810111130";

    private final static String syono107 = "11810111152";

    private final static String syono108 = "11810111163";

    private final static String syono109 = "11810111174";

    private final static String syono110 = "11810111185";

    private final static String syono111 = "11810111196";

    private final static String syono112 = "11810111200";

    private final static String syono113 = "11810111211";

    private final static String syono114 = "11810111222";

    private final static String syono115 = "11810111233";

    private final static String syono116 = "11810111244";

    private final static String syono117 = "11810111255";

    private final static String syono118 = "11810111266";

    private final static String syono119 = "11810111277";

    private final static String syono120 = "11810111288";

    private final static String syono121 = "11810111299";

    private final static String syono125 = "11810111336";

    private final static String syono126 = "11810111347";

    private final static String syono127 = "11810111358";

    private final static String syono129 = "11810111370";

    private final static String syono130 = "11810111381";

    private final static String syono131 = "17806000264";

    private final static String syono132 = "17806000275";

    private final static String syono133 = "17806000286";

    private final static String syono134 = "17806000297";

    private final static String syono135 = "17806000301";

    @Inject
    private CommonNyuukin commonNyuukin;

    @Inject
    private KhozenCommonParam khozenCommonParam;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou asKinou;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetYuuyokknmanryobi.class).to(SetYuuyokknmanryobiMockForKhansyuu.class);
                bind(HanteiTetuduki.class).to(HanteiTetudukiMockForKhansyuu.class);
                bind(AnsyuuCommonSiwake.class).to(AnsyuuCommonSiwakeMockForKhansyuu.class);
                bind(BzDenpyouDataSks.class).to(BzDenpyouDataSksMockForKhansyuu.class);
                bind(KeisanIkkatuWaribikiKikan.class).to(KeisanIkkatuWaribikiKikanMockForKhansyuu.class);
                bind(GetasPRsTuuka.class).to(GetasPRsTuukaMockForKhansyuu.class);
                bind(KeisanRsgaku.class).to(KeisanRsgakuMockForKhansyuu.class);
                bind(SetMinusUriagebi.class).to(SetMinusUriagebiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(CommonNyuukinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @BeforeClass
    public static void testInit(){
        SetYuuyokknmanryobiMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        HanteiTetudukiMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        AnsyuuCommonSiwakeMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        BzDenpyouDataSksMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        GetasPRsTuukaMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        KeisanRsgakuMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
        SetMinusUriagebiMockForKhansyuu.caller = CommonNyuukinTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        HanteiTetudukiMockForKhansyuu.caller = null;
        HanteiTetudukiMockForKhansyuu.SYORIPTN =null;
        AnsyuuCommonSiwakeMockForKhansyuu.caller = null;
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = null;
        BzDenpyouDataSksMockForKhansyuu.caller = null;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;
        GetasPRsTuukaMockForKhansyuu.caller = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = null;
        KeisanRsgakuMockForKhansyuu.caller = null;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = null;
        SetMinusUriagebiMockForKhansyuu.caller = null;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(1)
    public void testExec_B1() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        SetMinusUriagebiMockForKhansyuu.SYORIPTN = SetMinusUriagebiMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono1);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151119"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKEKEIJYOU);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(2)
    public void testExec_B2() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono2);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HONSYASYOUKAIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

        khozenCommonParam = (KhozenCommonParam) MockObjectManager.getArgument(HanteiTetudukiMockForKhansyuu.class, "exec", 0, 0);
        String syoNo = (String) MockObjectManager.getArgument(HanteiTetudukiMockForKhansyuu.class, "exec", 0, 1);
        exStringEquals(khozenCommonParam.getFunctionId(), "kinouId", "機能ID");
        exStringEquals(syoNo, "11807111129", "証券番号");
    }

    @Test
    @TestOrder(3)
    public void testExec_B3() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono3);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.HARAIHENYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRHN_SYORIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(4)
    public void testExec_B4() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(5)
    public void testExec_B5() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono9);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(null);
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.RYSYBIMISS, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(6)
    public void testExec_B6() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono10);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151119"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.RYSYBIMISS, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(7)
    public void testExec_B7() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono11);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150630"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150227"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.RYSYBIMISS, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(8)
    public void testExec_B8() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono13);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150731"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201702"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(1000000001200L));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150331"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1000000001200L), "仮受金額");

    }

    @Test
    @TestOrder(9)
    public void testExec_B9() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono14);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150731"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150401"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(10)
    public void testExec_B10() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono15);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150227"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.RYSYBIMISS, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(11)
    public void testExec_B11() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono12);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150228"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @TestOrder(12)
    public void testExec_B12() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono16);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201703"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150228"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(13)
    public void testExec_B13() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono17);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201702"));
        nyuukinTRParam.setJyutouKaisuuY("3");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150301"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");


    }

    @Test
    @TestOrder(14)
    public void testExec_B14() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono18);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(15)
    public void testExec_B15() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono19);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(16)
    public void testExec_B16() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono20);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(17)
    public void testExec_B17() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono21);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(18)
    public void testExec_B18() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono20);
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

    }

    @Test
    @TestOrder(19)
    public void testExec_B19() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono21);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(20)
    public void testExec_B20() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono16);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.SKEI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201703"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(0));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150228"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(21)
    public void testExec_B21() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono23);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(22)
    public void testExec_B22() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono24);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(23)
    public void testExec_B23() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono25);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(24)
    public void testExec_B24() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono26);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(25)
    public void testExec_B25() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono27);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(28)
    public void testExec_B28() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono30);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(29)
    public void testExec_B29() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono31);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
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
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(30)
    public void testExec_B30() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono32);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(31)
    public void testExec_B31() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono33);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(32)
    public void testExec_B32() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono54);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(33)
    public void testExec_B33() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono55);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(34)
    public void testExec_B34() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono56);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(35)
    public void testExec_B35() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono57);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(36)
    public void testExec_B36() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono59);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(37)
    public void testExec_B37() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono60);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(38)
    public void testExec_B38() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono61);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(39)
    public void testExec_B39() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono62);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("13");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HONSYASYOUKAIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(40)
    public void testExec_B40() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono63);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("14");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HONSYASYOUKAIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");



    }

    @Test
    @TestOrder(41)
    public void testExec_B41() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono129);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("13");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(42)
    public void testExec_B42() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono64);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(4999));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(4999), "仮受金額");
    }

    @Test
    @TestOrder(43)
    public void testExec_B43() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono65);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("4");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(44)
    public void testExec_B44() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono66);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(45)
    public void testExec_B45() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono67);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(46)
    public void testExec_B46() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono69);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(47)
    public void testExec_B47() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono70);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(48)
    public void testExec_B48() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono71);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }
    @Test
    @TestOrder(49)
    public void testExec_B49() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono72);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("13");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HONSYASYOUKAIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(50)
    public void testExec_B50() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono73);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("14");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HONSYASYOUKAIHTY, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(51)
    public void testExec_B51() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono130);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("13");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(52)
    public void testExec_B52() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono74);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(53)
    public void testExec_B53() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono75);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(54)
    public void testExec_B54() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono77);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(55)
    public void testExec_B55() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono78);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(56)
    public void testExec_B56() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono79);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("5");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(57)
    public void testExec_B57() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono80);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(58)
    public void testExec_B58() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono81);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("2");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(59)
    public void testExec_B59() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono82);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(60)
    public void testExec_B60() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono83);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(61)
    public void testExec_B61() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono84);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(62)
    public void testExec_B62() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono85);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(63)
    public void testExec_B63() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono86);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.OTHER);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(64)
    public void testExec_B64() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono87);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRKHOUHOUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(65)
    public void testExec_B65() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono88);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(66)
    public void testExec_B66() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono89);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("11");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.SYOUMETUGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(67)
    public void testExec_B67() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono90);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKINHITUYOU, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(68)
    public void testExec_B68() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono92);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(69)
    public void testExec_B69() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono93);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(70)
    public void testExec_B70() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono94);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(71)
    public void testExec_B71() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono95);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("13");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(72)
    public void testExec_B72() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono103);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(73)
    public void testExec_B73() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono107);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKINHITUYOU, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(74)
    public void testExec_B74() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono108);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(75)
    public void testExec_B75() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono109);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(76)
    public void testExec_B76() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono110);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(77)
    public void testExec_B77() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono111);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(78)
    public void testExec_B78() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono112);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CONVENI);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        try {
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。入金経路に誤りがあります。証券番号＝11810111200　入金経路＝コンビニ", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_B80() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono113);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(81)
    public void testExec_B81() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono114);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRKHOUHOUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }
    @Test
    @TestOrder(82)
    public void testExec_B82() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono115);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(83)
    public void testExec_B83() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono96);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(5000));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KYUUSOKUTYUUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(5000), "仮受金額");

    }

    @Test
    @TestOrder(84)
    public void testExec_B84() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono116);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRKKAISUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(85)
    public void testExec_B85() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono105);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRKKAISUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(86)
    public void testExec_B86() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono117);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUTUKISOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(87)
    public void testExec_B87() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono118);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20180101"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201510"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20180101"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.YUYOKKNGONYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(88)
    public void testExec_B88() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono119);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20171231"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201510"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20171231"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(89)
    public void testExec_B89() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono120);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20171230"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201510"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20171230"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(90)
    public void testExec_B90() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono121);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20171230"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201510"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(21));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20171230"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(1), "仮受金額");

    }

    @Test
    @TestOrder(91)
    public void testExec_B91() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN4;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono34);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KYHKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KAZYOUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(9), "仮受金額");

    }

    @Test
    @TestOrder(92)
    public void testExec_B92() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN3;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono35);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.HKNKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(93)
    public void testExec_B93() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN5;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono36);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(20));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(94)
    public void testExec_B94() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono125);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KYHKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(null);
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        try {
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約情報が取得できません。証券番号＝11810111336　入金経路＝給付金", "エラーメッセージ");
            throw e;
        }

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(95)
    public void testExec_B95() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono126);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.HKNKIN);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        try {
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約情報が取得できません。証券番号＝11810111347　入金経路＝保険金", "エラーメッセージ");
            throw e;
        }

    }

    @Test
    @TestOrder(96)
    public void testExec_B96() {
        MockObjectManager.initialize();
        AnsyuuCommonSiwakeMockForKhansyuu.SYORIPTN = AnsyuuCommonSiwakeMockForKhansyuu.TESTPATTERN1;
        BzDenpyouDataSksMockForKhansyuu.SYORIPTN = BzDenpyouDataSksMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono127);
        nyuukinTRParam.setSyuudaikocd(C_Syuudaikocd.SIS);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.SYOKAIP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNyuukinKakusyounrkYmd(BizDate.valueOf("20160104"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.YOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.KYKHUZAIERROR, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        IT_NyuukinKakusyouData itNyuukinKakusyouData = commonNyuukin.getNyuukinKakusyouData();
        exStringEquals(itNyuukinKakusyouData.getSyono(), syono127, "証券番号");
        exDateEquals(itNyuukinKakusyouData.getNyksyoriymd(), BizDate.valueOf("20150531"), "入金処理日");
        exDateEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkymd(), BizDate.valueOf("20160104"), "入金確証入力年月日");
        exClassificationEquals(itNyuukinKakusyouData.getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exClassificationEquals(itNyuukinKakusyouData.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払込回数");
        exClassificationEquals(itNyuukinKakusyouData.getNyknaiyoukbn(), C_NyknaiyouKbn.SYOKAIP, "入金内容区分");
        exClassificationEquals(itNyuukinKakusyouData.getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exDateYMEquals(itNyuukinKakusyouData.getJyuutouym(), BizDateYM.valueOf("201511"), "充当年月");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuuy(), 0, "充当回数（年）");
        exNumericEquals(itNyuukinKakusyouData.getJyutoukaisuum(), 0, "充当回数（月）");
        exBizCalcbleEquals(itNyuukinKakusyouData.getRsgaku(), BizCurrency.valueOf(new BigDecimal("10")), "領収金額");
        exDateEquals(itNyuukinKakusyouData.getRyosyuymd(), BizDate.valueOf("20150531"), "領収日");
        exDateEquals(itNyuukinKakusyouData.getNykdenymd(), BizDate.valueOf("20150531"), "入金伝票日付");
        exStringEquals(itNyuukinKakusyouData.getSuitoubumoncd(), "001", "出納部門コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaebankcd(), "", "口座振替銀行コード");
        exStringEquals(itNyuukinKakusyouData.getKzhurikaesitencd(), "", "口座振替支店コード");
        exStringEquals(itNyuukinKakusyouData.getNyuukinkakusyounrkno(), "", "入金確証入力番号");
        exClassificationEquals(itNyuukinKakusyouData.getHrkmyousinkkbn(), C_KrkPayEasyHrkmyousiNkKbn.TAISYOUGAI, "振込用紙入金区分");
        exStringEquals(itNyuukinKakusyouData.getSuitososhikicd(), "", "出納組織コード");

        AnsyuuCommonSiwakeInBean ansyuuCommonSiwakeInBean = (AnsyuuCommonSiwakeInBean)MockObjectManager.getArgument(AnsyuuCommonSiwakeMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(ansyuuCommonSiwakeInBean.getSyuudaikoCd(), C_Syuudaikocd.SIS, "収納代行社コード");

    }

    @Test
    @TestOrder(97)
    public void testExec_B97() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono131);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(98)
    public void testExec_B98() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono132);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(99)
    public void testExec_B99() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono133);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("3");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.OTHERKR_ARI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

        BizDate ryosyuYmd = (BizDate) MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class, "exec", 0, 0);
        BizDateYM jyuutouYm = (BizDateYM) MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class, "exec", 0, 1);
        Integer jyuutouTukisuu = (Integer) MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class, "exec", 0, 2);
        exDateEquals(ryosyuYmd, nyuukinTRParam.getRyosyuYmd(), "領収日");
        exDateYMEquals(jyuutouYm, nyuukinTRParam.getJyutouYm(), "充当年月");
        exNumericEquals(jyuutouTukisuu, 3, "充当月数");

    }

    @Test
    @TestOrder(100)
    public void testExec_B100() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono134);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(101)
    public void testExec_B101() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono135);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(102)
    public void testExec_B102() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono107);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
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
        CommonNyuukin  commonNyuukin2 = SWAKInjector.getInstance(CommonNyuukin.class);
        commonNyuukin2.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin2.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin2.getKrkRiyuuKbn(), C_KrkriyuuKbn.HRKHOUHOUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin2.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin2.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin2.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(103)
    public void testExec_B103() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono103);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("2");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(104)
    public void testExec_B104() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono103);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.CREDIT);
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
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(105)
    public void testExec_B105() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN3;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001054");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(4999));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(4999), "仮受金額");

    }

    @Test
    @TestOrder(106)
    public void testExec_B106() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001065");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201505"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(107)
    public void testExec_B107() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001076");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201504"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("12");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(108)
    public void testExec_B108() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001087");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(109)
    public void testExec_B109() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001098");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(110)
    public void testExec_B110() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001102");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(111)
    public void testExec_B111() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001113");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151130"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

    }

    @Test
    @TestOrder(112)
    public void testExec_B112() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001124");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(113)
    public void testExec_B113() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001135");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(114)
    public void testExec_B114() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001146");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(115)
    public void testExec_B115() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001157");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");

    }

    @Test
    @TestOrder(116)
    public void testExec_B116() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN2;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001168");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.SYORIHUNOERROR, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.ZYUTOUSUUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");

        exStringEquals((String) MockObjectManager.getArgument(GetasPRsTuukaMockForKhansyuu.class, "exec", 0, 0), "99806001168", "証券番号");

    }

    @Test
    @TestOrder(117)
    public void testExec_B117() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001179");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(20));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.SYORIHUNOERROR, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.BLNK, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(0), "仮受金額");
        IT_KykKihon kykKihon =  (IT_KykKihon) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(kykKihon.getSyono(), "99806001179", "証券番号");
        exClassificationEquals((C_Nykkeiro) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 1), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals((C_NyknaiyouKbn) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 2), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 3), BizDate.valueOf(20150531), "領収年月日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 4), BizDateYM.valueOf(201511), "充当開始年月");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 5), 0, "充当年数");
        exNumericEquals((int) MockObjectManager.getArgument(KeisanRsgakuMockForKhansyuu.class, "exec", 0, 6), 1, "充当月数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(118)
    public void testExec_B118() {
        MockObjectManager.initialize();
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN2;

        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = null;
        nyuukinTRParam.setSyoNo("99806001180");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(20));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);

        try {
            commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);
        } catch (Exception e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。領収金額計算エラー。エラー理由＝保険料領収通貨取得エラー　証券番号＝99806001180", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(119)
    public void testExec_B119() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.OTHER);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.NYKNNAIYOUSOUI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(120)
    public void testExec_B120() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo(syono4);
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.BANK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.HOZENHENKOUYOUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.ARI);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201511"));
        nyuukinTRParam.setJyutouKaisuuY(null);
        nyuukinTRParam.setJyutouKaisuuM("1");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(10));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20151118"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.KARIUKE);
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);

        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HENKOUMATI, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(10), "仮受金額");
    }

    @Test
    @TestOrder(121)
    public void testExec_B121() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000415");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201506"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(11));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KIGETUMAENYN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(11), "仮受金額");

    }

    @Test
    @TestOrder(122)
    public void testExec_B122() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("99806001065");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150430"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201505"));
        nyuukinTRParam.setJyutouKaisuuY("0");
        nyuukinTRParam.setJyutouKaisuuM("6");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(11));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150430"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.KIGETUMAENYN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(11), "仮受金額");

    }

    @Test
    @TestOrder(123)
    public void testExec_B123() {
        MockObjectManager.initialize();
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        HanteiTetudukiMockForKhansyuu.SYORIPTN = HanteiTetudukiMockForKhansyuu.TESTPATTERN2;
        GetasPRsTuukaMockForKhansyuu.SYORIPTN = GetasPRsTuukaMockForKhansyuu.TESTPATTERN1;
        KeisanRsgakuMockForKhansyuu.SYORIPTN = KeisanRsgakuMockForKhansyuu.TESTPATTERN1;
        khozenCommonParam.setFunctionId("kinouId");
        asKinou.setKinouKbn(C_KinouKbn.ONLINE);

        NyuukinTRParam  nyuukinTRParam = SWAKInjector.getInstance(NyuukinTRParam.class);
        AnsyuuBatSyoriHunoKykMisslistSks ansyuuBatSyoriHunoKykMisslistSks = SWAKInjector.getInstance(AnsyuuBatSyoriHunoKykMisslistSks.class);
        nyuukinTRParam.setSyoNo("17806000415");
        nyuukinTRParam.setSyoriYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setNykKeiro(C_Nykkeiro.KZHRK);
        nyuukinTRParam.setHrkkaisuu(C_Hrkkaisuu.NEN);
        nyuukinTRParam.setNykNaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        nyuukinTRParam.setIktnyuukinnumu(C_UmuKbn.NONE);
        nyuukinTRParam.setJyutouYm(BizDateYM.valueOf("201506"));
        nyuukinTRParam.setJyutouKaisuuY("1");
        nyuukinTRParam.setJyutouKaisuuM("0");
        nyuukinTRParam.setRyosyuGk(BizCurrency.valueOf(8));
        nyuukinTRParam.setRyosyuYmd(BizDate.valueOf("20150531"));
        nyuukinTRParam.setZengetumatuDenSimeYmd(BizDate.valueOf("20151120"));
        nyuukinTRParam.setPdfOutYouhi(C_YouhiKbn.HUYOU);
        nyuukinTRParam.setNykhouhouKbn(C_NykhouhouKbn.HURIKAE);
        nyuukinTRParam.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        commonNyuukin.exec(khozenCommonParam, nyuukinTRParam, C_YouhiKbn.HUYOU, C_YouhiKbn.HUYOU, ansyuuBatSyoriHunoKykMisslistSks);

        exClassificationEquals(commonNyuukin.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(commonNyuukin.getCommonNyuukinErrorRiyuuKbn(), C_CommonNyuukinErrorRiyuuKbn.BLNK, "エラー理由");
        exClassificationEquals(commonNyuukin.getKrkRiyuuKbn(), C_KrkriyuuKbn.HUSOKUNYKN, "仮受理由区分");
        exClassificationEquals(commonNyuukin.getPdfOutUmuKbn(), C_UmuKbn.NONE, "PDF出力有無区分");
        exStringEquals(commonNyuukin.getTyohyoKey(), "", "帳票キー");
        exBizCalcbleEquals(commonNyuukin.getBdKrkGK(), BizCurrency.valueOf(8), "仮受金額");

    }
}