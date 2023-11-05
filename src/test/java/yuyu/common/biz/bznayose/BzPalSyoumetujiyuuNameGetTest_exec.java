package yuyu.common.biz.bznayose;

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
import yuyu.def.classification.C_BetukutiKeiyakuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ消滅事由名称取得のメソッド {@link BzPalSyoumetujiyuuNameGet#exec(String,C_BetukutiKeiyakuKbn )} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzPalSyoumetujiyuuNameGetTest_exec {
    @Inject
    private BzPalSyoumetujiyuuNameGet bzPalSyoumetujiyuuNameGet;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ消滅事由名称取得";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzPalSyoumetujiyuuNameGetTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getPalSyoumetujiyuu("0999",C_BetukutiKeiyakuKbn.KEIYAKU));
        bizDomManager.delete(bizDomManager.getPalSyoumetujiyuu("8888",C_BetukutiKeiyakuKbn.NENKIN));
    }
    @Test
    @TestOrder(10)
    public void testExec_A1() {
        String result = bzPalSyoumetujiyuuNameGet.exec("999", C_BetukutiKeiyakuKbn.KEIYAKU) ;
        exStringEquals(result, "契約取消", "消滅事由名称");
    }
    @Test
    @TestOrder(20)
    public void testExec_A2() {
        String result = bzPalSyoumetujiyuuNameGet.exec("9999", C_BetukutiKeiyakuKbn.NENKIN) ;
        exStringEquals(result, "その他", "消滅事由名称");
    }
}
