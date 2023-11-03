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
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 選択情報チェッククラスのメソッド {@link CheckSentakujyouhou#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */

@RunWith(OrderedRunner.class)
public class CheckSentakujyouhouTest_exec {

    private final static String mosNo1 = "791112220";

    private final static String mosNo2 = "791112238";

    private final static String fileName = "UT_SP_単体テスト仕様書_選択情報チェック";

    private final static String sheetName = "テストデータ";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckSentakujyouhouTest_exec.class, fileName, sheetName);
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

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckMRKanren.class).to(CheckMRKanrenMockForSinkeiyaku.class);
            }
        });
    }

    @AfterClass
    public static void clearMockClass() {

        CheckMRKanrenMockForSinkeiyaku.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        CheckMRKanrenMockForSinkeiyaku.caller = CheckSentakujyouhouTest_exec.class;
        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo1);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.YOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000003");
        CheckSentakujyouhou checkSentakujyouhou = SWAKInjector.getInstance(CheckSentakujyouhou.class);
        checkSentakujyouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 1, "不備メッセージ件数");
        exStringEquals(hubiMsg.get(0).getMessageId(), "WHC1004", "不備メッセージID");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者に医的選択情報があります。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112220", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.WARNING, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000003", "業務用更新時間");

        MockObjectManager.assertCalled(CheckMRKanrenMockForSinkeiyaku.class, "exec");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo2);
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKosTime("20150604162000003");
        CheckSentakujyouhou checkSentakujyouhou = SWAKInjector.getInstance(CheckSentakujyouhou.class);
        checkSentakujyouhou.exec(mosnaiCheckParam);

        List<HT_HubiMsg> hubiMsg = mosnaiCheckParam.getListHubiMsg();

        exNumericEquals(hubiMsg.size(), 0, "不備メッセージ件数");

        MockObjectManager.assertNotCalled(CheckMRKanren.class, "exec");

    }

}
