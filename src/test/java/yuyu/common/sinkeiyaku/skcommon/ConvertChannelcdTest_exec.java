package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * チャネルコード変換クラスのメソッド {@link ConvertChannelcd#exec(C_Channelcd)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ConvertChannelcdTest_exec {

    @Inject
    private ConvertChannelcd convertChannelcd;

    private final static String fileName = "UT_SP_単体テスト仕様書_チャネルコード変換";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkPreSyoruiTorikomiTest_sinkykSyoruiTorikomi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkChannel());
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllTyouhyourenrakusaki());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_Channelcd henkougoChannelcd = convertChannelcd.exec(null, null);
        exClassificationEquals(henkougoChannelcd, C_Channelcd.TIGIN, "規定チェック用チャネルコード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_Channelcd henkougoChannelcd = convertChannelcd.exec(C_Channelcd.BLNK, "");
        exClassificationEquals(henkougoChannelcd, C_Channelcd.TIGIN, "規定チェック用チャネルコード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_Channelcd henkougoChannelcd = convertChannelcd.exec(null, "5100001");
        exClassificationEquals(henkougoChannelcd, C_Channelcd.SMBC, "規定チェック用チャネルコード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_Channelcd henkougoChannelcd = convertChannelcd.exec(C_Channelcd.MIZUHO, null);
        exClassificationEquals(henkougoChannelcd, C_Channelcd.TIGIN, "規定チェック用チャネルコード");
    }

}