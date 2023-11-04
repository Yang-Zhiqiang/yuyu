package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

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
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険料免除特約関連チェッククラスのメソッド {@link CheckPmentkKanren#exec(MosnaiCheckParam ,BM_SyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckPmentkKanrenTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "861110039";

    private final static String mosNo5 = "861110047";

    private final static String mosNo6 = "861110054";

    private final static String mosNo7 = "861110062";

    private final static String mosNo8 = "861110070";

    private final static String fileName = "UT_SP_単体テスト仕様書_保険料免除特約関連チェック";

    private final static String sheetName = "テストデータ";


    @Inject
    private CheckPmentkKanren checkPmentkKanren;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData(){

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckPmentkKanrenTest_exec.class, fileName, sheetName);
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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllChkTkykSyuNenreiHani());
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("M110",1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("M310",1));

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsg.get(0).getMosno(), "861110005", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "保険料免除特約の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);
        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), "861110039", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0014", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "なしは付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_B1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ件数");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_B2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), "861110054", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "THC0028", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】３大疾病保険料払込免除特約の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_B3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        BM_SyouhnZokusei syouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,syouhinZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_B4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        BM_SyouhnZokusei pSyouhinZokusei = syoriCTL.getMosSyouhns().get(0).getSyouhnZokusei();
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.WARNING);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150624162000000");
        checkPmentkKanren.exec(mosnaiCheckParam ,pSyouhinZokusei);


        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exStringEquals(hubiMsg.get(0).getMosno(), "861110070", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "THC0028", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "【特認可能】３大疾病保険料払込免除特約の契約可能期間・年齢範囲外です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150624162000000", "業務用更新時間");
    }
}
