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
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 指定契約日チェッククラスのメソッド {@link CheckShiteiKeiyakubi#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckShiteiKeiyakubiTest_exec {

    @Inject
    private CheckShiteiKeiyakubi checkShiteiKeiyakubi;

    private final static String mosNo1 = "861110005";

    private final static String mosNo2 = "861110013";

    private final static String mosNo3 = "861110021";

    private final static String mosNo4 = "861110039";

    private final static String mosNo5 = "861110047";

    private final static String mosNo6 = "861110054";

    private final static String mosNo7 = "861110062";

    private final static String mosNo8 = "861110070";

    private final static String mosNo9 = "861110088";

    private final static String mosNo10 = "861110096";

    private final static String fileName = "UT_SP_単体テスト仕様書_指定契約日チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckShiteiKeiyakubiTest_exec.class, fileName, sheetName);
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
    @TestOrder(10)
    public void testExec_A1() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(),C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分 ");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "入力された内容では契約日の特例を適用できません。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20151221111400000");

        checkShiteiKeiyakubi.exec(pMP);
        List<HT_HubiMsg> hubiMsg = pMP.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo7, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0108", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "指定契約日は不可です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20151221111400000", "業務用更新時間");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exClassificationEquals(pMP.getSekmossakuseiErroutKbn(),C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分 ");
        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "入力された内容では契約日の特例を適用できません。", "結果画面ＭＳＧ");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.SKEI);
        pMP.setKosID("user001");
        pMP.setKosTime("20151221111400000");

        checkShiteiKeiyakubi.exec(pMP);

        List<HT_HubiMsg> hubiMsg = pMP.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリストの件数");
        exStringEquals(hubiMsg.get(0).getMosno(), mosNo9, "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0108", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "指定契約日は不可です。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20151221111400000", "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        MosnaiCheckParam pMP =  new MosnaiCheckParam();
        pMP.setDataSyoriControl(syoriCTL1);
        pMP.setSysKbn(C_SysKbn.ESHIEN);

        checkShiteiKeiyakubi.exec(pMP);

        exStringEquals(pMP.getSekmossakuseiErrmsg2(), "", "結果画面ＭＳＧ");
    }
}
