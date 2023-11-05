package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不備メッセージ設定クラスのメソッド {@link SetHubiMsg#editHubiMsgKingakuPKans(BizCurrency, BizCurrency, C_Tuukasyu,
        boolean, MosnaiCheckParam,HT_MosKihon, BM_SyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHubiMsgTest_editHubiMsgKingakuPKans {

    @Inject
    private SetHubiMsg setHubiMsg;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_不備メッセージ設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetHubiMsgTest_exec_1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("テストデータ6", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(10)
    public void testEditHubiMsgKingakuPKans_A1() {

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(100,BizCurrencyTypes.DOLLAR),
            BizCurrency.valueOf(1,BizCurrencyTypes.DOLLAR), C_Tuukasyu.USD, true, null, null, null);

        exStringEquals(hubiMsg, "100米ドル", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(20)
    public void testEditHubiMsgKingakuPKans_A2() {

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.NONE);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, null, null);

        exStringEquals(hubiMsg, "9,000円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(30)
    public void testEditHubiMsgKingakuPKans_A3() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000280");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｱ", 3);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(hubiMsg, "35,967円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(40)
    public void testEditHubiMsgKingakuPKans_A4() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000298");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｳ", 3);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(hubiMsg, "0円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(50)
    public void testEditHubiMsgKingakuPKans_A5() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000306");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｵ", 3);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(hubiMsg, "9,000円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(60)
    public void testEditHubiMsgKingakuPKans_A6() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000314");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｷ", 3);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(hubiMsg, "0円", "不備メッセージ（通貨）");
    }

    @Test
    @TestOrder(70)
    public void testEditHubiMsgKingakuPKans_A7() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        MosnaiCheckParam mosnaiCheckParam = new MosnaiCheckParam();
        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL("860000322");
        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei("ﾕｸ", 3);

        String hubiMsg = setHubiMsg.editHubiMsgKingakuPKans(BizCurrency.valueOf(9000),
            BizCurrency.valueOf(9999), C_Tuukasyu.JPY, true, mosnaiCheckParam, mosKihon, syouhnZokusei);

        exStringEquals(hubiMsg, "0万円", "不備メッセージ（通貨）");
    }

}
