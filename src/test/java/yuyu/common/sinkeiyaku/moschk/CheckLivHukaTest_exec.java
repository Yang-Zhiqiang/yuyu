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
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * リビングニーズ付加有無チェッククラスのメソッド {@link CheckLivHuka#exec(MosnaiCheckParam, BM_SyouhnZokusei)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckLivHukaTest_exec {

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "861110039";

    private final static String mosNo5 = "861110047";

    private final static String mosNo6 = "861110054";

    private final static String mosNo7 = "861110062";

    private final static String fileName = "UT_SP_単体テスト仕様書_リビングニーズ付加有無チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private CheckLivHuka checkLivHuka;

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BM_SyouhnZokusei syouhnZokusei;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckLivHukaTest_exec.class, fileName, sheetName);
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.ARI);

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo1, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EBC0045", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "リビングニーズ特約有無の入力が必要です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user002");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.NONE);

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user003");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.ARI);

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo3, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0016", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "法人契約はリビングニーズ特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user003", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user004");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.ARI);

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo4, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0017", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "質権設定契約はリビングニーズ特約付加できません。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user004", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user005");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.NONE);
        syouhnZokusei.setSyouhnnm("手術特約");

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo5, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0016", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "手術特約はリビングニーズ特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user005", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user006");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.NONE);
        syouhnZokusei.setSyouhnnm("手術特約");

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo6, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0016", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "手術特約はリビングニーズ特約付加対象外です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user006", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150529111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setKosID("user007");
        mosnaiCheckParam.setKosTime("20150529111400000");
        syouhnZokusei.setLivtkumu(C_UmuKbn.ARI);

        checkLivHuka.exec(mosnaiCheckParam, syouhnZokusei);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }
}