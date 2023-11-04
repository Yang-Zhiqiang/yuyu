package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約ガイダンス取得のメソッド {@link GetSinkeiyakuGuidance#exec(GetSinkeiyakuGuidanceOutBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class GetSinkeiyakuGuidanceTest_exec {

    @Inject
    private GetSinkeiyakuGuidance getSinkeiyakuGuidance;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約ガイダンス取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(GetSinkeiyakuGuidanceTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000017"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(0), "1000", "ガイダンスメッセージリスト[0]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(1), "2000", "ガイダンスメッセージリスト[1]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2030", "ガイダンスメッセージリスト[2]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3000", "ガイダンスメッセージリスト[3]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(4), "3010", "ガイダンスメッセージリスト[4]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(5), "3030", "ガイダンスメッセージリスト[5]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(6), "5000", "ガイダンスメッセージリスト[6]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(7), "6000", "ガイダンスメッセージリスト[7]");

    }

    @Test
    @TestOrder(11)
    public void testExec_A1_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000017"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(0), "1000", "ガイダンスメッセージリスト[0]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(1), "2000", "ガイダンスメッセージリスト[1]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2030", "ガイダンスメッセージリスト[2]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3000", "ガイダンスメッセージリスト[3]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(4), "3010", "ガイダンスメッセージリスト[4]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(5), "3030", "ガイダンスメッセージリスト[5]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(6), "5000", "ガイダンスメッセージリスト[6]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(7), "6000", "ガイダンスメッセージリスト[7]");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000025"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }

    @Test
    @TestOrder(21)
    public void testExec_A2_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000025"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000033"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }

    @Test
    @TestOrder(31)
    public void testExec_A3_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000033"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000041"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }

    @Test
    @TestOrder(41)
    public void testExec_A4_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000041"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2030"), false, "ＭＳＧコードが'2030'に存在しない");
        }
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000058"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2040", "ガイダンスメッセージリスト[2]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(4), "3030", "ガイダンスメッセージリスト[4]");
    }

    @Test
    @TestOrder(51)
    public void testExec_A5_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000058"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2040", "ガイダンスメッセージリスト[2]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(4), "3030", "ガイダンスメッセージリスト[4]");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000066"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
            exBooleanEquals(data.contains("3030"), false, "ＭＳＧコードが'3030'に存在しない");
        }
    }

    @Test
    @TestOrder(61)
    public void testExec_A6_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000066"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
            exBooleanEquals(data.contains("3030"), false, "ＭＳＧコードが'3030'に存在しない");
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000074"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
            exBooleanEquals(data.contains("3030"), false, "ＭＳＧコードが'3030'に存在しない");
        }
    }

    @Test
    @TestOrder(71)
    public void testExec_A7_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000074"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
            exBooleanEquals(data.contains("3030"), false, "ＭＳＧコードが'3030'に存在しない");
        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000082"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(81)
    public void testExec_A8_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000082"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000090"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(91)
    public void testExec_A9_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000090"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000108"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(101)
    public void testExec_A10_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000108"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000116"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(111)
    public void testExec_A11_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000116"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコードが'2040'に存在しない");
        }
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000124"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(121)
    public void testExec_A12_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000124"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000132"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(131)
    public void testExec_A13_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000132"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000140"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(141)
    public void testExec_A14_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000140"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000157"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(151)
    public void testExec_A15_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000157"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3010", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000165"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3010"), false, "ＭＳＧコードが'3010'に存在しない");
        }
    }

    @Test
    @TestOrder(161)
    public void testExec_A16_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000165"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3010"), false, "ＭＳＧコードが'3010'に存在しない");
        }
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000173"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(171)
    public void testExec_A17_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000173"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000181"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(181)
    public void testExec_A18_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000181"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000199"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(191)
    public void testExec_A19_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000199"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000207"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(201)
    public void testExec_A20_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000207"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(3), "3020", "ガイダンスメッセージリスト[3]");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000215"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(211)
    public void testExec_A21_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000215"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000223"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(221)
    public void testExec_A22_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000223"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000231"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(231)
    public void testExec_A23_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000231"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("3020"), false, "ＭＳＧコードが'3020'に存在しない");
        }
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO);

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(0), "1000", "ガイダンスメッセージリスト[0]");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(1), "3000", "ガイダンスメッセージリスト[1]");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SISAN);

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exNumericEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().size(), 0, "ガイダンスメッセージリストのサイズ");
    }

    @Test
    @TestOrder(280)
    public void testExec_A26() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000223"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2710"), false, "ＭＳＧコードが'2710'に存在しない");
        }
    }

    @Test
    @TestOrder(281)
    public void testExec_A26_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000223"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {
            exBooleanEquals(data.contains("2710"), false, "ＭＳＧコードが'2710'に存在しない");
        }
    }

    @Test
    @TestOrder(290)
    public void testExec_A27() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000249"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2710", "ガイダンスメッセージリスト[2]");
    }

    @Test
    @TestOrder(291)
    public void testExec_A27_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000249"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getGuidansuMessageList().get(2), "2710", "ガイダンスメッセージリスト[2]");
    }

    @Test
    @TestOrder(300)
    public void testExec_A28() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000256"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), true, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(301)
    public void testExec_A28_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000256"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), true, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(310)
    public void testExec_A29() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000264"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), true, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");

    }

    @Test
    @TestOrder(311)
    public void testExec_A29_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000264"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), true, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");

    }

    @Test
    @TestOrder(320)
    public void testExec_A30() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000272"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), true, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(321)
    public void testExec_A30_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000272"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), true, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(330)
    public void testExec_A31() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000280"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(331)
    public void testExec_A31_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000280"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(340)
    public void testExec_A32() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000298"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(341)
    public void testExec_A32_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000298"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(350)
    public void testExec_A33() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000306"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(351)
    public void testExec_A33_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000306"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(360)
    public void testExec_A34() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000314"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(361)
    public void testExec_A34_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000314"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(370)
    public void testExec_A35() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000322"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(371)
    public void testExec_A35_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000322"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(380)
    public void testExec_A36() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000330"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(381)
    public void testExec_A36_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000330"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(390)
    public void testExec_A37() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000348"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(391)
    public void testExec_A37_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000348"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(400)
    public void testExec_A38() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000355"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(401)
    public void testExec_A38_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000355"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(410)
    public void testExec_A39() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000363"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(411)
    public void testExec_A39_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000363"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(420)
    public void testExec_A40() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000371"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(421)
    public void testExec_A40_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000371"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(430)
    public void testExec_A41() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000389"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(431)
    public void testExec_A41_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000389"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(440)
    public void testExec_A42() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000397"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(441)
    public void testExec_A42_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000397"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(450)
    public void testExec_A43() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000405"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(451)
    public void testExec_A43_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000405"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(450)
    public void testExec_A44() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000413"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(451)
    public void testExec_A44_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000413"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(470)
    public void testExec_A45() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000421"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(471)
    public void testExec_A45_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000421"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(480)
    public void testExec_A46() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000439"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(481)
    public void testExec_A46_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000439"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        List<String> guidansuMessageList = getSinkeiyakuGuidanceOutBean.getGuidansuMessageList();

        exBooleanEquals(guidansuMessageList.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
        exBooleanEquals(guidansuMessageList.contains("2050"), true, "ＭＳＧコード'2050'の設定確認");
    }

    @Test
    @TestOrder(490)
    public void testExec_A47() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000447"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(491)
    public void testExec_A47_2() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        MosnaiCheckParam mPM = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mPM.setSekmossakuseiKbn(C_SekmossakuseiKbn.SEKKEISYO_MOUSIKOMISYO);

        mPM.setDataSyoriControl(sinkeiyakuDomManager.getSyoriCTL("860000447"));

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = getSinkeiyakuGuidance.exec(mPM);

        for (String data : getSinkeiyakuGuidanceOutBean.getGuidansuMessageList()) {

            exBooleanEquals(data.contains("2040"), false, "ＭＳＧコード'2040'の設定確認");
            exBooleanEquals(data.contains("2045"), false, "ＭＳＧコード'2045'の設定確認");
            exBooleanEquals(data.contains("2050"), false, "ＭＳＧコード'2050'の設定確認");
        }
    }

    @Test
    @TestOrder(260)
    public void testProperties_A1() {

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = SWAKInjector
            .getInstance(GetSinkeiyakuGuidanceOutBean.class);

        getSinkeiyakuGuidanceOutBean.setKnsnkanouhyj("1");

        getSinkeiyakuGuidanceOutBean.setNngndkkkanouhyj("2");

        getSinkeiyakuGuidanceOutBean.setMnstskanouhyj("3");

        getSinkeiyakuGuidanceOutBean.setSyktkikanouhyj("4");

        getSinkeiyakuGuidanceOutBean.setSyaikanouhyj("5");

        getSinkeiyakuGuidanceOutBean.setSndnzknsyouhyj("6");

        getSinkeiyakuGuidanceOutBean.setKtekknsyouhyj("7");

        getSinkeiyakuGuidanceOutBean.setKnsnsysndnzyou("8");

        getSinkeiyakuGuidanceOutBean.setKnsnktekknsyou("9");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnkanouhyj(), "1", "健診書可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getNngndkkkanouhyj(), "2", "人間ドック可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getMnstskanouhyj(), "3", "面接士可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSyktkikanouhyj(), "4", "嘱託医可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSyaikanouhyj(), "5", "社医可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSndnzknsyouhyj(), "6", "心電図検査要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKtekknsyouhyj(), "7", "血液検査要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnsysndnzyou(), "8", "健診書用心電図要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnktekknsyou(), "9", "健診書用血液検査項目要表示");
    }

    @Test
    @TestOrder(270)
    public void testProperties_A2() {

        GetSinkeiyakuGuidanceOutBean getSinkeiyakuGuidanceOutBean = SWAKInjector
            .getInstance(GetSinkeiyakuGuidanceOutBean.class);

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnkanouhyj(), "0", "健診書可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getNngndkkkanouhyj(), "0", "人間ドック可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getMnstskanouhyj(), "0", "面接士可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSyktkikanouhyj(), "0", "嘱託医可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSyaikanouhyj(), "0", "社医可能表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getSndnzknsyouhyj(), "0", "心電図検査要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKtekknsyouhyj(), "0", "血液検査要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnsysndnzyou(), "0", "健診書用心電図要表示");

        exStringEquals(getSinkeiyakuGuidanceOutBean.getKnsnktekknsyou(), "0", "健診書用血液検査項目要表示");
    }
}
