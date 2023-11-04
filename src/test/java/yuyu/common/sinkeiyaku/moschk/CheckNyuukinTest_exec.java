package yuyu.common.sinkeiyaku.moschk;

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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubi;
import yuyu.common.hozen.khcommon.SetCreditUriageSeikyuubiMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.SetHurikaebi;
import yuyu.common.hozen.khcommon.SetHurikaebiMockForSinkeiyaku;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 入金チェッククラスのメソッド {@link CheckNyuukin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckNyuukinTest_exec {

    private final static String mosNo1 = "971112222";

    private final static String mosNo2 = "971112248";

    private final static String mosNo3 = "971112271";

    private final static String mosNo4 = "971112297";

    private final static String mosNo5 = "971112230";

    private final static String mosNo6 = "971112255";

    private final static String mosNo7 = "971112263";

    private final static String mosNo8 = "971112289";

    private final static String mosNo9 = "971112511";

    private final static String mosNo10 = "971112313";

    private final static String mosNo11 = "971112321";

    private final static String mosNo12 = "860000017";

    private final static String mosNo13 = "860000025";

    private final static String mosNo14 = "860000033";

    private final static String mosNo15 = "860000041";

    private final static String mosNo16 = "860000058";

    private final static String mosNo17 = "860000066";

    private final static String mosNo18 = "860000074";

    private final static String mosNo19 = "860000082";

    private final static String mosNo20 = "860000090";

    private final static String mosNo21 = "860000108";

    private final static String mosNo22 = "860000116";

    private final static String mosNo23 = "860000124";

    private final static String mosNo24 = "860000132";

    private final static String mosNo25 = "860000140";

    private final static String mosNo26 = "860000157";

    private final static String mosNo27 = "860000165";

    private final static String mosNo28 = "860000173";

    private final static String mosNo29 = "860000181";

    private final static String mosNo30 = "860000199";

    private final static String mosNo31 = "860000207";

    private final static String mosNo32 = "860000215";

    private final static String mosNo33 = "860000223";

    private final static String mosNo34 = "860000231";

    private final static String mosNo35 = "970111407";

    private final static String mosNo36 = "970111415";

    private final static String mosNo37 = "791112220";

    private final static String mosNo38 = "791112238";

    private final static String mosNo39 = "791112246";

    private final static String mosNo40 = "791112253";

    private final static String mosNo41 = "791112261";

    private final static String mosNo42 = "791112279";

    private final static String mosNo43 = "791112287";

    private final static String mosNo44 = "860000249";

    private final static String fileName = "UT_SP_単体テスト仕様書_入金チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckNyuukin checkNyuukin;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHurikaebi.class).to(SetHurikaebiMockForSinkeiyaku.class);
                bind(SetCreditUriageSeikyuubi.class).to(SetCreditUriageSeikyuubiMockForSinkeiyaku.class);
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class);
            }
        });
    }
    @BeforeClass
    public static void testInit() {

        SetHurikaebiMockForSinkeiyaku.caller = CheckNyuukinTest_exec.class;

        SetCreditUriageSeikyuubiMockForSinkeiyaku.caller = CheckNyuukinTest_exec.class;

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = CheckNyuukinTest_exec.class;

    }

    @AfterClass
    public static void testClear() {

        SetHurikaebiMockForSinkeiyaku.caller = null;
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = null;

        SetCreditUriageSeikyuubiMockForSinkeiyaku.caller = null;
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = null;

        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = null;

    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckNyuukinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("共通データ", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }}

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SEIRITUHORYUU_HUSOKUKIN, "入金状態区分");


        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo5, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0098", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不足入金エラー　不足金額　１０円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo1, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1007", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "通貨相違　払込通貨　米ドル　領収通貨　円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo6, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0080", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料払込経路が口振の契約に口振以外の入金があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo7, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0101", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "初回保険料払込経路がクレジットカード扱契約に入金があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo8, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC0099", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "過剰入金エラー　過剰金額　７０円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo4, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0058", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "過剰入金エラー　過剰金額　１００円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo10, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0079", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "入金領収日相違　領収日　２０１５．　６．１９　領収予定日　２０１５．　６．２０", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

        exClassificationEquals(syoriCTL.getTokunin().getIkkatuyouptknkbn(), C_IkkatuyouptknKbn.NONE, "一括要Ｐ特認区分");

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");

        exNumericEquals(syoriCTL.getMosKihon().getSkjpjyuutoukaisuu(), 1, "新契約時保険料充当回数");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();

        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181010));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();

        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181121));

        checkNyuukin.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo18, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1019", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の案内日は２０１８年１１月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo19);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181021));

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo20);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(11);

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.MARUSIIKKATUYOU, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo21, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1019", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の案内日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo22);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);

        checkNyuukin.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo22, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1019", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の案内日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN3;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo23);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        checkNyuukin.exec(mosnaiCheckParam);


        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo23, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1019", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の案内日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo24);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.SEIRITUHORYUU_KAKIN, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo24, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1021", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の売上請求抽出日は２０１９年１１月１２日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {
        MockObjectManager.initialize();

        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo25);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo25, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1021", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の売上請求抽出日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo26);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(6));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo26, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1019", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の案内日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {
        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo27);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo27, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1021", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の売上請求抽出日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");
        exNumericEquals(syoriCTL.getMosKihon().getSkjpjyuutoukaisuu(), 2, "新契約時保険料充当回数");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {
        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo28);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo28, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1021", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "２回目保険料の売上請求抽出日は２０１８年１０月２１日です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {
        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN1;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo29);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20190521));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {
        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN3;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo30);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20190421));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo30, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "THC1082", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】契約年月日　２０１９年０５月１０日による一括要Ｐあり（２０１９年０４月２１日時点）／一括要Ｐ省略または併徴の要否を確認してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo31);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo31, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0057", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不足入金エラー　不足金額　３００円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo32);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo32, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0057", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不足入金エラー　不足金額　２００円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo33);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.NONE);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");


        exClassificationEquals(syoriCTL.getNyuukinjoutaikbn(), C_NyuukinjyoutaiKbn.RYOUSYUUGAKUSEITOU, "入金状態区分");
        exNumericEquals(syoriCTL.getMosKihon().getSkjpjyuutoukaisuu(), 1, "新契約時保険料充当回数");
    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo34);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.NONE);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo34, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0057", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "不足入金エラー　不足金額　２００円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user002", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181121111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo35);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo35, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1007", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "通貨相違　払込通貨　米ドル　領収通貨　円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo36);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150619111400000");

        checkNyuukin.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo36, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1007", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "通貨相違　払込通貨　米ドル　領収通貨　円", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150619111400000", "業務用更新時間");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {
        MockObjectManager.initialize();

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo37);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20191121));

        try{

            checkNyuukin.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112220",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo38);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(500), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(1500), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(1000), "一括要Ｐ必要額（継続Ｐ）");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), BizDate.valueOf(20201217), "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(12.22), "継続Ｐ適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 9, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20181122), "領収年月日");

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnCd(), "ﾕﾍ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getYoteiRiritu(), BizNumber.valueOf(0.024), "予定利率");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(500), "保険料");
    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {
        MockObjectManager.initialize();
        SetCreditUriageSeikyuubiMockForSinkeiyaku.SYORIPTN = SetCreditUriageSeikyuubiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo39);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(17);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(300), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(3000), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(1000), "一括要Ｐ必要額（継続Ｐ）");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), BizDate.valueOf(20201217), "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(12.22), "継続Ｐ適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 16, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.CREDIT, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20181122), "領収年月日");

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnCd(), "ﾕﾍ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getYoteiRiritu(), BizNumber.valueOf(0.024), "予定利率");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(300), "保険料");
    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo40);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(0), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(3000), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(0), "一括要Ｐ必要額（継続Ｐ）");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), null, "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(0), "継続Ｐ適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.AUD, "領収通貨種類");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 10, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.SYOKAIP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20201208), "領収年月日");

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnCd(), "ﾕﾍ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getYoteiRiritu(), BizNumber.valueOf(0.024), "予定利率");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo41);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(0), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(3000), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(0), "一括要Ｐ必要額（継続Ｐ）");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), null, "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(0), "継続Ｐ適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 10, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.SYOKAIP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20201208), "領収年月日");

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnCd(), "ﾕﾍ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getYoteiRiritu(), BizNumber.valueOf(0.024), "予定利率");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo42);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exBizCalcbleEquals(mosKihon.getHrktuukaheijyunp(), BizCurrency.valueOf(0), "払込通貨平準払Ｐ");
        exBizCalcbleEquals(mosKihon.getHrktuukafstphrkgk(), BizCurrency.valueOf(3000), "払込通貨初回Ｐ払込必要額");
        exBizCalcbleEquals(mosKihon.getIkkatuyoupgkkeizokup(), BizCurrency.valueOf(0), "一括要Ｐ必要額（継続Ｐ）");
        exDateEquals(mosKihon.getKeizokuptkykwsratekjymd(), null, "継続Ｐ適用為替レート基準日");
        exBizCalcbleEquals(mosKihon.getKeizokuptkykwsrate(), BizNumber.valueOf(0), "継続Ｐ適用為替レート");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.BLNK, "定期一括払種類区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 10, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.SYOKAIP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.SKEI, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20201208), "領収年月日");

        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanLst = keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnCd(), "ﾕﾎ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getRyouritusdNo(), "L", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getYoteiRiritu(), BizNumber.valueOf(0.024), "予定利率");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {
        MockObjectManager.initialize();
        SetHurikaebiMockForSinkeiyaku.SYORIPTN = SetHurikaebiMockForSinkeiyaku.TESTPATTERN2;
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo43);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20181122));
        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(10);
        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.HEITYOU);

        try{

            checkNyuukin.exec(mosnaiCheckParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "月払一括入金額計算異常 申込番号：791112287", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {
        KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo44);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20181121111400000");

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        checkNyuukin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }
}
