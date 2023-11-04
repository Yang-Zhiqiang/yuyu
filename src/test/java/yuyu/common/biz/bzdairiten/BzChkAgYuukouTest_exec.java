package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BzChkAgYuukouクラスのメソッド {@link BzChkAgYuukou#exec(String,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzChkAgYuukouTest_exec extends AbstractTest {

    @Inject
    private BzChkAgYuukou bzChkAgYuukou;

    private final static String fileName = "UT-SP_単体テスト仕様書_代理店有効性チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzChkAgYuukouTest_exec.class, fileName, sheetName);

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
        bizDomManager.delete(bizDomManager.getAllDairiten());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String drtenCd = "";

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String drtenCd = null;

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String drtenCd = "1148033";

        BizDate kijyunYmd = null;

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String drtenCd = "1148034";

        BizDate kijyunYmd = BizDate.valueOf("20150801");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String drtenCd = "1148035";

        BizDate kijyunYmd = BizDate.valueOf("20150801");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String drtenCd = "1148036";

        BizDate kijyunYmd = BizDate.valueOf("99991230");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String drtenCd = "1148037";

        BizDate kijyunYmd = BizDate.valueOf("20150801");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String drtenCd = "1148038";

        BizDate kijyunYmd = BizDate.valueOf("20150802");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String drtenCd = "1148039";

        BizDate kijyunYmd = BizDate.valueOf("20150803");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String drtenCd = "1148040";

        BizDate kijyunYmd = BizDate.valueOf("20150804");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String drtenCd = "1148041";

        BizDate kijyunYmd = BizDate.valueOf("20150805");

        Boolean yuukouChkRlt = bzChkAgYuukou.exec(drtenCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }
}
