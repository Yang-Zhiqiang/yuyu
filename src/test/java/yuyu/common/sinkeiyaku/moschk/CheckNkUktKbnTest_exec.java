package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Uketorinin;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金受取人区分入力チェックのメソッド {@link CheckNkUktKbn#exec(MosnaiCheckParam,List<HT_Uketorinin>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckNkUktKbnTest_exec {

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000025";

    private final static String mosNo3 = "860000033";

    private final static String mosNo4 = "860000041";

    private final static String mosNo5 = "981112220";

    private final static String mosNo6 = "981112238";

    private final static String mosNo7 = "981112246";

    private final static String mosNo8 = "981112253";

    private final static String mosNo9 = "981112261";

    private final static String mosNo10 = "981112279";

    private final static String mosNo11 = "981112287";

    private final static String mosNo12 = "981112295";

    private final static String mosNo13 = "981112303";

    private final static String mosNo14 = "981112329";

    private final static String mosNo15 = "980000012";

    private final static String mosNo16 = "980000020";

    private final static String mosNo17 = "980000038";

    private final static String syouhnCd_M110 = "M110";

    private final static int syouhnsdNo_M110 = 1;

    private final static String syouhnCd_M120 = "M120";

    private final static int syouhnsdNo_M120 = 1;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_年金受取人区分入力チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private CheckNkUktKbn checkNkUktKbn;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckNkUktKbnTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        checkNkUktKbn.exec(mosnaiCheckParam, null);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        List<HT_Uketorinin> uketorininLst = new ArrayList<>();

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20180222134500000");
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();

        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo4, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHA1071", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契被同一の場合、年金受取人区分に「被保険者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20180222134500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        checkNkUktKbn.exec(mosnaiCheckParam, null);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = new ArrayList<>();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181019134500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo7, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHA1071", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契被同一の場合、年金受取人区分に「被保険者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181019134500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181016134500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo8, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1020", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人に被保険者を指定する場合、被保険者が契約者の配偶者で、かつ税制適格特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181016134500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181019154500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo10, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHA1071", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "契被同一の場合、年金受取人区分に「被保険者と同じ」は指定できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181019154500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181017154500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo11, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1020", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人に被保険者を指定する場合、被保険者が契約者の配偶者で、かつ税制適格特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181017154500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181017154500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo12, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1020", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人に被保険者を指定する場合、被保険者が契約者の配偶者で、かつ税制適格特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181017154500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo13);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M120, syouhnsdNo_M120);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = new ArrayList<>();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo14);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181018154500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo14, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1020", "メッセージＩＤ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "年金受取人に被保険者を指定する場合、被保険者が契約者の配偶者で、かつ税制適格特約の付加が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20181018154500000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo15);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo16);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181016134500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo17);
        BM_SyouhnZokusei syuSyouhnZokusei = bizDomManager.getSyouhnZokusei(syouhnCd_M110, syouhnsdNo_M110);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20181017154500000");

        List<HT_Uketorinin> uketorininLst = syoriCTL.getUketorinins();
        checkNkUktKbn.exec(mosnaiCheckParam, uketorininLst);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
    }
}
