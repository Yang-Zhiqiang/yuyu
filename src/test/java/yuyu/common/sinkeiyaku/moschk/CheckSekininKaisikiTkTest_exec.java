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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 責任開始期特約付加チェッククラスのメソッド {@link CheckSekininKaisikiTk#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckSekininKaisikiTkTest_exec {

    private final static String syoNo1 = "791112220";

    private final static String syoNo2 = "791112238";

    private final static String syoNo3 = "791112246";

    private final static String syoNo4 = "791112253";

    private final static String syoNo5 = "791112261";

    private final static String syoNo6 = "791112279";

    private final static String syoNo7 = "791112287";

    private final static String syoNo8 = "791112295";

    private final static String fileName = "UT_SP_単体テスト仕様書_責任開始期特約付加チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private CheckSekininKaisikiTk checkSekininKaisikiTk;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSekininKaisikiTkTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ｵ1", 1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("ｵ2", 1));

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0220", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "責任開始期に関する特約は付加必須です。", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112238", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150603111400000", "業務用更新時間");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC0220", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "責任開始期に関する特約は付加必須です。", "不備メッセージ");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo3);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo4);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo5);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo6);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.NONE, "フリーインシュアランス該当有無");

    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo7);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150603111400000");
        checkSekininKaisikiTk.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();
        exNumericEquals(hubiMsg.size(), 0, "件数");
        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.ARI, "フリーインシュアランス該当有無");

    }

    @Test(expected = CommonBizAppException.class)
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        try{
            HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(syoNo8);
            mosnaiCheckParam.setDataSyoriControl(syoriCTL);
            mosnaiCheckParam.setKosID("user001");
            mosnaiCheckParam.setKosTime("20150603111400000");
            checkSekininKaisikiTk.exec(mosnaiCheckParam);
        }
        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。主契約申込商品件数異常 申込番号：791112295", "エラーメッセージ");
            throw e;
        }
    }
}
