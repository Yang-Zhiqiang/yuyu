package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 受取人TBLチェッククラスのメソッド {@link CheckTblUketorinin#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckTblUketorininTest_exec {

    private final static String mosNo1 = "981112220";

    private final static String mosNo2 = "981112238";

    private final static String mosNo3 = "981112246";

    private final static String mosNo4 = "981112253";

    private final static String mosNo5 = "981112261";

    private final static String mosNo6 = "981112279";

    private final static String mosNo7 = "981112287";

    private final static String mosNo8 = "981112295";

    private final static String mosNo9 = "981112303";

    private final static String mosNo10 = "981112311";

    private final static String mosNo11 = "981112329";

    private final static String mosNo12 = "981112337";

    private final static String mosNo13 = "981112345";

    private final static String mosNo14 = "981112352";

    private final static String mosNo15 = "981112360";

    private final static String mosNo16 = "981112378";

    private final static String mosNo17 = "981112386";

    private final static String mosNo18 = "981112394";

    private final static String mosNo21 = "860000017";

    private final static String mosNo22 = "860000025";

    private final static String mosNo23 = "860000033";

    private final static String mosNo24 = "860000041";

    private final static String mosNo25 = "860000504";

    private final static String mosNo26 = "860001007";

    private final static String mosNo27 = "981112402";

    private final static String mosNo28 = "981112410";

    private final static String mosNo29 = "980111249";

    private final static String mosNo30 = "980111256";

    private final static String mosNo31 = "980111264";

    private final static String mosNo32 = "980111272";

    private final static String mosNo33 = "980111280";

    private final static String mosNo34 = "980111298";

    private final static String mosNo35 = "980111306";

    private final static String mosNo36 = "980111314";

    private final static String mosNo37 = "980111322";

    private final static String mosNo38 = "980111330";

    private final static String mosNo39 = "980111348";

    private final static String mosNo40 = "980111355";

    private final static String mosNo41 = "980111363";

    private final static String mosNo42 = "980111371";

    private final static String mosNo43 = "980111389";

    private final static String mosNo44 = "980111397";

    private final static String mosNo45 = "980111405";

    private final static String mosNo46 = "791112238";

    private final static String mosNo47 = "791112246";

    private final static String mosNo48 = "791112253";

    private final static String mosNo49 = "791112261";

    private final static String mosNo50 = "791112279";

    private final static String mosNo51 = "791112287";

    private final static String mosNo52 = "791112295";

    private final static String mosNo53 = "791112311";

    private final static String mosNo54 = "791112329";

    private final static String mosNo55 = "791112337";

    private final static String mosNo56 = "791112410";

    private final static String mosNo57 = "791112428";

    private final static String mosNo58 = "791112436";

    private final static String mosNo59 = "791112444";

    private final static String mosNo60 = "791112451";

    private final static String mosNo61 = "791112469";

    private final static String mosNo62 = "791112477";

    private final static String mosNo63 = "791112485";

    private final static String mosNo64 = "791112493";

    private final static String mosNo65 = "791112501";

    private final static String mosNo66 = "791112519";

    private final static String mosNo67 = "791112527";

    private final static String mosNo68 = "791112535";

    private final static String mosNo69 = "791112543";

    private final static String mosNo70 = "791112550";

    private final static String mosNo71 = "791112576";

    private final static String mosNo72 = "791112220";

    private final static String mosNo73 = "861110013";

    private final static String mosNo74 = "861110021";

    private final static String mosNo75 = "861110054";

    private final static String mosNo76 = "861110062";

    private final static String mosNo77 = "861110112";

    private final static String mosNo78 = "861110120";

    private final static String mosNo79 = "861110138";

    private final static String mosNo80 = "861110146";

    private final static String mosNo81 = "861110153";

    private final static String mosNo82 = "861110161";

    private final static String mosNo83 = "861110179";

    private final static String mosNo84 = "861110187";

    private final static String mosNo85 = "861110195";

    private final static String mosNo86 = "861110203";

    private final static String mosNo87 = "861110211";

    private final static String mosNo88 = "861110229";

    private final static String mosNo89 = "861110237";

    private final static String mosNo90 = "861110039";

    private final static String mosNo91 = "861110047";

    private final static String mosNo92 = "861110245";

    private final static String mosNo93 = "860000306";

    private final static String mosNo94 = "861110096";

    private final static String mosNo95 = "861110104";

    private final static String mosNo96 = "861110278";

    private final static String mosNo97 = "861110286";

    private final static String mosNo98 = "861110484";

    private final static String mosNo99 = "861110294";

    private final static String mosNo100 = "861110302";

    private final static String mosNo101 = "861110310";

    private final static String mosNo102 = "861110005";

    private final static String mosNo103 = "860000538";

    private final static String mosNo104 = "860000520";

    private final static String mosNo105 = "860000512";

    private final static String mosNo106 = "861110450";

    private final static String mosNo107 = "971112222";

    private final static String mosNo108 = "971112230";

    private final static String mosNo109 = "971112248";

    private final static String mosNo110 = "971112255";

    private final static String mosNo111 = "971112263";

    private final static String mosNo112 = "971112271";

    private final static String mosNo113 = "971112289";

    private final static String mosNo114 = "971112297";

    private final static String mosNo115 = "971112313";

    private final static String mosNo116 = "971112511";

    private final static String mosNo117 = "971112321";

    private final static String mosNo118 = "860083658";

    private final static String mosNo119 = "861110260";

    private final static String mosNo120 = "861110252";

    private final static String mosNo121 = "860000058";

    private final static String mosNo122 = "860000066";

    private final static String mosNo123 = "860000074";

    private final static String mosNo124 = "860000082";

    private final static String mosNo125 = "860000090";

    private final static String mosNo126 = "860000108";

    private final static String mosNo127 = "860000116";

    private final static String mosNo128 = "860000124";

    private final static String mosNo129 = "860000132";

    private final static String mosNo130 = "860000140";

    private final static String mosNo131 = "860000157";

    private final static String mosNo132 = "860000165";

    private final static String mosNo133 = "860000173";

    private final static String mosNo134 = "860000181";

    private final static String mosNo135 = "860000199";

    private final static String mosNo136 = "860000207";

    private final static String mosNo137 = "860000215";

    private final static String mosNo138 = "860000223";

    private final static String mosNo139 = "860000231";

    private final static String mosNo140 = "860000249";

    private final static String syouhnCd = "M110";

    private final static int syouhnsdNo = 1;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_受取人TBLチェック";

    private final static String sheetName = "テストデータ_20160905";

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {

                bind(GetUktYouFlg.class).to(GetUktYouFlgMockForSinkeiyaku.class);
                bind(CheckSbUktHhkn.class).to(CheckSbUktHhknMockForSinkeiyaku.class);
                bind(CheckNkUktKbn.class).to(CheckNkUktKbnMockForSinkeiyaku.class);
                bind(CheckUktBnWari.class).to(CheckUktBnWariMockForSinkeiyaku.class);
                bind(CheckSeiYmd.class).to(CheckSeiYmdMockForSinkeiyaku.class);

            }
        });
    }

    @BeforeClass
    public static void testInit(){
        GetUktYouFlgMockForSinkeiyaku.caller = CheckTblUketorininTest_exec.class;
        CheckSbUktHhknMockForSinkeiyaku.caller = CheckTblUketorininTest_exec.class;
        CheckNkUktKbnMockForSinkeiyaku.caller = CheckTblUketorininTest_exec.class;
        CheckUktBnWariMockForSinkeiyaku.caller = CheckTblUketorininTest_exec.class;
        CheckSeiYmdMockForSinkeiyaku.caller = CheckTblUketorininTest_exec.class;

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetUktYouFlgMockForSinkeiyaku.caller = null;
        CheckSbUktHhknMockForSinkeiyaku.caller = null;
        CheckNkUktKbnMockForSinkeiyaku.caller = null;
        CheckUktBnWariMockForSinkeiyaku.caller = null;
        CheckSeiYmdMockForSinkeiyaku.caller = null;

        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = null;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckTblUketorininTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);

        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 5, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112220", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112220", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112220", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "981112220", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(4).getMosno(), "981112220", "申込番号");
        exStringEquals(hubiMsg.get(4).getHubimsg(), "被保険者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112238", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMosno(), "981112238", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getMosno(), "981112238", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(3).getMosno(), "981112238", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN1;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN2;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 6, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人区分に「契約者」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "死亡受取人の分割割合が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "死亡受取人生年月日が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(4).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(4).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(5).getMosno(), "981112246", "申込番号");
        exStringEquals(hubiMsg.get(5).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(5).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(GetUktYouFlgMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), mosNo3, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exDateEquals(mosnaiCheckParamtemp1.getSysDate(), BizDate.valueOf("20160303"), "システム処理日");

        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(CheckSbUktHhknMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), mosNo3, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exDateEquals(mosnaiCheckParamtemp2.getSysDate(), BizDate.valueOf("20160303"), "システム処理日");
        List<HT_Uketorinin> sbUketorinInLst =  (List<HT_Uketorinin>) MockObjectManager.getArgument(CheckSbUktHhknMockForSinkeiyaku.class, "exec", 0, 1);

        exNumericEquals(sbUketorinInLst.size(), 4, "受取人テーブルエンティティリスト");

        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(CheckUktBnWariMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), mosNo3, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp3.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exDateEquals(mosnaiCheckParamtemp3.getSysDate(), BizDate.valueOf("20160303"), "システム処理日");
        List<HT_Uketorinin> sbUketorinInLst2 =  (List<HT_Uketorinin>) MockObjectManager.getArgument(CheckUktBnWariMockForSinkeiyaku.class, "exec", 0, 1);

        exNumericEquals(sbUketorinInLst2.size(), 4, "受取人テーブルエンティティリスト");

        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(CheckSeiYmdMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), mosNo3, "申込番号");
        exClassificationEquals( mosnaiCheckParamtemp4.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exDateEquals(mosnaiCheckParamtemp4.getSysDate(), BizDate.valueOf("20160303"), "システム処理日");
        MockObjectManager.assertArgumentPassed(CheckSeiYmdMockForSinkeiyaku.class, "exec", 1,BizDate.valueOf("20160301"));
        MockObjectManager.assertArgumentPassed(CheckSeiYmdMockForSinkeiyaku.class, "exec", 2, "死亡受取人生年月日");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112253", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112253", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112253", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112261", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112261", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112261", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "981112261", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "981112279", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112279", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112279", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "981112287", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112287", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112287", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "981112295", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112295", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "981112303", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112303", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112303", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112311", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112311", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112311", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "981112329", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112329", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112329", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112337", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112337", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112337", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112345", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112345", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112345", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112352", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112352", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112352", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");


    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112360", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112360", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112360", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112378", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112378", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112378", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112386", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112386", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112386", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo18);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112394", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112394", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112394", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "",
            "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo21);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");

    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo22);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860000025", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000025", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000025", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "【特認可能】被保険者代理人の続柄"
            + "として「その他」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo23);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000033", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000033", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000033", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "860000033", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "（特認済）被保険者代理人の続柄として「その他」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo24);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");

    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo25);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20160303"));
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000504", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000504", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000504", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "死亡受取人人数が５人以上の場合、"
            + "被保険者代理人区分に「死亡受取人と同じ」を指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo26);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860001007", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860001007", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860001007", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }


    @Test
    @TestOrder(270)
    public void testExec_A27() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo27);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112402", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112402", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112402", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo28);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "981112410", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "981112410", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "981112410", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN5;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo29);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111249", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111249", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111249", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN5;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo30);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111256", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111256", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN6;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo31);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111264", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111264", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111264", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN6;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo32);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111272", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111272", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = null;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo33);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN7;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo34);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111298", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111298", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111298", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者と年金受取人が別人のため、"
            + "被保険者代理特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN7;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo35);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111306", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111306", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111306", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者と年金受取人が別人のため、"
            + "被保険者代理特約は付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN5;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo36);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111314", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo37);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111322", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo38);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111330", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo39);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111348", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo40);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111355", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo41);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111363", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo42);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exStringEquals(hubiMsg.get(0).getMosno(), "980111371", "申込番号");
        if (hubiMsg.size() > 0) {
            for ( HT_HubiMsg hubiMsgData : hubiMsg) {
                assertNotEquals(hubiMsgData.getHubimsg(), "被保険者と年金受取人が別人のため、指定代理請求特約は付加できません。", "不備メッセージ");
            }
        } else {
            exStringEquals(hubiMsg.get(0).getHubimsg(), "", "不備メッセージ");
        }
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo43);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnsdNo);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE,
            "設計書申込書作成エラー出力区分");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo44);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111397", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111397", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111397", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "【特認可能】死亡受取人が配偶者の場合は、"
            + "被保険者代理人の続柄として「配偶者」は指定できません。"
            + "被保険者代理人区分に「死亡受取人と同じ」を指定してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo45);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "980111405", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "980111405", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "980111405", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "【特認可能】死亡受取人が配偶者の場合は、"
            + "被保険者代理人の続柄として「配偶者」は指定できません。"
            + "被保険者代理人区分に「死亡受取人と同じ」を指定してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo46);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112238", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo47);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112246", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112246", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo48);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112253", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112253", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo49);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112261", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112261", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo50);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112279", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo51);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112287", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo52);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112295", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo53);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112311", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo54);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112329", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo55);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112337", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo56);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112410", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo57);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112428", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo58);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112436", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo59);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112444", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo60);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112451", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo61);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112469", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo62);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112477", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo63);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112485", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo64);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112493", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo65);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112501", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo66);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112519", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo67);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112527", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo68);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112535", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo69);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112543", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo70);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112550", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112550", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo71);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112576", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112576", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo72);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112220", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo73);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110013", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族２人目住所情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110013", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo74);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110021", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110021", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110021", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo75);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110054", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110054", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110054", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo76);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110062", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110062", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = CheckNkUktKbnMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo77);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110112", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110112", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo81);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110153", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者代理人区分に"
            + "「登録家族１人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110153", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "被保険者代理特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo82);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110161", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契約者代理人区分に"
            + "「登録家族２人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN7;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo83);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110179", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110179", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "年金受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110179", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110179", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo84);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110187", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110187", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110187", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110187", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が死亡受取人の場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo85);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110195", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110195", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110195", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110195", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が死亡受取人の場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo86);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110203", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110203", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110203", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110203", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が死亡受取人の場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo87);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110211", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110211", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110211", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110211", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が死亡受取人の場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo88);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110229", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110229", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110229", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110229", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(890)
    public void testExec_A89() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo89);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110237", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110237", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110237", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110237", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(900)
    public void testExec_A90() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo90);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110039", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110039", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110039", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(910)
    public void testExec_A91() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo91);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110047", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110047", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110047", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110047", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が特定名義の場合、"
            + "被保険者代理人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo92);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110245", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110245", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110245", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110245", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が登録家族１人目と同じの場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo93);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000306", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000306", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000306", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "860000306", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が登録家族２人目と同じの場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo94);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110096", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110096", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110096", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110096", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が契約者と同じの場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo95);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110104", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110104", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110104", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110104", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が契約者と同じの場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo96);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110278", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110278", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110278", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110278", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分が契約者と同じの場合、"
            + "被保険者代理人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(970)
    public void testExec_A97() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo97);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110286", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の分割割合が正しくありません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110286", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110286", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110286", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "死亡受取人と契約者が同一のため、"
            + "被保険者代理人区分に「契約者と同じ」を指定してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo98);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110484", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110484", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110484", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "契約者区分が「契被同一」の場合、"
            + "被保険者代理人区分に「契約者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(990)
    public void testExec_A99() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo99);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110294", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110294", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110294", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(),
            "【特認可能】被保険者代理人の続柄として「その他」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1000)
    public void testExec_A100() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo100);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110302", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110302", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110302", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(),
            "【特認可能】被保険者代理人の続柄として「その他」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1010)
    public void testExec_A101() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo101);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110310", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110310", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "被保険者代理人区分に"
            + "「登録家族１人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1020)
    public void testExec_A102() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo102);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110005", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110005", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110005", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者代理人区分に"
            + "「登録家族２人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1030)
    public void testExec_A103() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo103);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000538", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000538", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000538", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "860000538", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人情報に"
            + "「生年月日」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1040)
    public void testExec_A104() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo104);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000520", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000520", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000520", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "860000520", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分に"
            + "「登録家族１人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1050)
    public void testExec_A105() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo105);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000512", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000512", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "860000512", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "860000512", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分に"
            + "「登録家族２人目と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1060)
    public void testExec_A106() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo106);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110450", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110450", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "861110450", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "861110450", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "被保険者代理人区分に"
            + "「契約者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1070)
    public void testExec_A107() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo107);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112222", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112222", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1080)
    public void testExec_A108() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo108);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112230", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112230", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が特定名義の場合、"
            + "定期支払金受取人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1090)
    public void testExec_A109() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo109);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112248", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112248", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が特定名義の場合、"
            + "定期支払金受取人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1100)
    public void testExec_A110() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo110);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112255", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112255", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が特定名義の場合、"
            + "定期支払金受取人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1110)
    public void testExec_A111() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo111);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112263", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112263", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が特定名義の場合、"
            + "定期支払金受取人情報をすべて入力してください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1120)
    public void testExec_A112() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo112);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112271", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112271", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が契約者と同じの場合、"
            + "定期支払金受取人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1130)
    public void testExec_A113() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo113);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112289", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112289", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が契約者と同じの場合、"
            + "定期支払金受取人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1140)
    public void testExec_A114() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo114);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112297", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112297", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が契約者と同じの場合、"
            + "定期支払金受取人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1150)
    public void testExec_A115() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo115);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112313", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112313", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が契約者と同じの場合、"
            + "定期支払金受取人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1160)
    public void testExec_A116() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo116);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112511", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112511", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人区分が契約者と同じの場合、"
            + "定期支払金受取人情報の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1170)
    public void testExec_A117() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo117);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "971112321", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "971112321", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "定期支払金受取人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1180)
    public void testExec_A118() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo118);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "860083658", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1190)
    public void testExec_A119() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo119);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110260", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1200)
    public void testExec_A120() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo120);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110252", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1210)
    public void testExec_A121() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo121);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000058", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1220)
    public void testExec_A122() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo122);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1230)
    public void testExec_A123() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo123);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1240)
    public void testExec_A124() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo124);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1250)
    public void testExec_A125() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo125);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1260)
    public void testExec_A126() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo126);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1270)
    public void testExec_A127() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo127);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1280)
    public void testExec_A128() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo128);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルの件数");
    }

    @Test
    @TestOrder(1290)
    public void testExec_A129() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo129);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000132", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1300)
    public void testExec_A130() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo130);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000140", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1310)
    public void testExec_A131() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo131);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000157", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000157", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "登録家族２人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1320)
    public void testExec_A132() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo132);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000165", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1330)
    public void testExec_A133() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo133);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000173", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1340)
    public void testExec_A134() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo134);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000181", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1350)
    public void testExec_A135() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo135);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000199", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1260)
    public void testExec_A136() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo136);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000207", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1370)
    public void testExec_A137() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo137);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000215", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1380)
    public void testExec_A138() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo138);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000223", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1390)
    public void testExec_A139() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo139);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000231", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000231", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "登録家族２人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1400)
    public void testExec_A140() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN8;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo140);
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000249", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "860000249", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "登録家族２人目が契約者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1410)
    public void testExec_A141() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000101");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000101", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000101", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000101", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "（特認済）被保険者代理人が被保険者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1420)
    public void testExec_A142() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000119");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000119", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000119", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000119", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "990000119", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1430)
    public void testExec_A143() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN4;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000127");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000127", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000127", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000127", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "【特認可能】被保険者代理人が被保険者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1440)
    public void testExec_A144() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000135");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000135", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000135", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000135", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "990000135", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1450)
    public void testExec_A145() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000143");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000143", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000143", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000143", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1460)
    public void testExec_A146() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000150");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000150", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000150", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1470)
    public void testExec_A147() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000168");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000168", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000168", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1480)
    public void testExec_A148() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN3;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000176");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000176", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000176", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000176", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "定期支払金受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1490)
    public void testExec_A149() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000184");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 2, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000184", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000184", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }

    @Test
    @TestOrder(1500)
    public void testExec_A150() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000192");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000192", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000192", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000192", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1510)
    public void testExec_A151() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN1;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000200");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 5, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000200", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡返還金受取人区分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000200", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000200", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "登録家族１人目の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "990000200", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "契約者代理人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(4).getMosno(), "990000200", "申込番号");
        exStringEquals(hubiMsg.get(4).getHubimsg(), "被保険者代理人の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(4).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1520)
    public void testExec_A152() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000218");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000218", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000218", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000218", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1530)
    public void testExec_A153() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000226");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000226", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000226", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000226", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1540)
    public void testExec_A154() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000234");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000234", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000234", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000234", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1550)
    public void testExec_A155() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = null;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000242");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000242", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "死亡受取人の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000242", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000242", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "990000242", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "【特認可能】被保険者代理人が被保険者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1560)
    public void testExec_A156() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000259");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 3, "不備メッセージテーブルの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "990000259", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000259", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000259", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "【特認可能】被保険者代理人が被保険者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
    }

    @Test
    @TestOrder(1570)
    public void testExec_A157() {
        GetUktYouFlgMockForSinkeiyaku.SYORIPTN = GetUktYouFlgMockForSinkeiyaku.TESTPATTERN2;
        CheckSbUktHhknMockForSinkeiyaku.SYORIPTN = CheckSbUktHhknMockForSinkeiyaku.TESTPATTERN2;
        CheckUktBnWariMockForSinkeiyaku.SYORIPTN = CheckUktBnWariMockForSinkeiyaku.TESTPATTERN2;
        CheckSeiYmdMockForSinkeiyaku.SYORIPTN = CheckSeiYmdMockForSinkeiyaku.TESTPATTERN1;
        CheckNkUktKbnMockForSinkeiyaku.SYORIPTN = null;
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("990000267");
        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        CheckTblUketorinin checkTblUketorinin = SWAKInjector.getInstance(CheckTblUketorinin.class);
        checkTblUketorinin.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 4, "不備メッセージテーブルの件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "990000267", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "受取人人数分の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(1).getMosno(), "990000267", "申込番号");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "ご家族登録サービスの入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(2).getMosno(), "990000267", "申込番号");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "保険契約者代理特約の入力は不要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

        exStringEquals(hubiMsg.get(3).getMosno(), "990000267", "申込番号");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "【特認可能】被保険者代理人が被保険者と同一の可能性があります。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");

    }
}
