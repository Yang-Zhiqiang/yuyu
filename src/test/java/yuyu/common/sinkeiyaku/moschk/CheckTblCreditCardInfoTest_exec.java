package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * クレジットカード情報TBLチェッククラスのメソッド {@link CheckTblCreditCardInfo#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTblCreditCardInfoTest_exec {

    private final static String mosNo1 = "860000017";

    private final static String mosNo2 = "860000033";

    private final static String mosNo3 = "860000041";

    private final static String mosNo4 = "860000058";

    private final static String mosNo5 = "860000074";

    private final static String mosNo6 = "860000082";

    private final static String mosNo7 = "860000090";

    private final static String mosNo8 = "860000116";

    private final static String mosNo9 = "860000124";

    private final static String mosNo10 = "860000132";

    private final static String mosNo11 = "860000157";

    private final static String mosNo12 = "860000165";

    private final static String HUBIMSG_CREDITCARDJYOUHOU = "クレジットカード情報";

    private final static String fileName = "UT_SP_単体テスト仕様書_クレジットカード情報TBLチェック";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckTblCreditCardInfoTest_exec.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

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

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000017", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBA0024), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBA0024, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo3);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo4);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo5);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000074", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBC0007), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBC0007, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo6);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000082", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBC0007), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBC0007, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo7);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000090", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBA0024), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBA0024, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo8);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo9);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000124", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            MessageUtil.getMessage(MessageId.EHC1128), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EHC1128, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo10);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージテーブルエンティティリスト件数");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo11);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000157", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBC0007), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBC0007, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        CheckTblCreditCardInfo checkTblCreditCardInfo = SWAKInjector.getInstance(CheckTblCreditCardInfo.class);
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        MosnaiCheckParam mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL(mosNo12);
        List <HT_HubiMsg> hubiMsg = syoriCtl.getHubiMsgs();
        mosnaiCheckParam.setDataSyoriControl(syoriCtl);
        mosnaiCheckParam.setListHubiMsg(hubiMsg);
        checkTblCreditCardInfo.exec(mosnaiCheckParam);

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージテーブルエンティティリスト件数");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000165", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(),
            HUBIMSG_CREDITCARDJYOUHOU + MessageUtil.getMessage(MessageId.EBC0007), "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), MessageId.EBC0007, "メッセージID");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(),
            C_HubisyubetuKbn.valueOf(C_KetsrhkosKbn.SRHORYU_HUBI.getValue()), "不備種別区分");
    }
}