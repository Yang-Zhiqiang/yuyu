package yuyu.common.biz.bzdairiten;

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
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 募集人コード取得（行員コード指定）クラスのメソッド {@link BzGetBsKeyKouin#exec(String, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetBsKeyKouinTest_exec extends AbstractTest {

    @Inject
    private BzGetBsKeyKouin bzGetBsKeyKouin;

    private final static String fileName = "UT_SP_単体テスト仕様書_募集人コード取得（行員コード指定）";

    private final static String sheetName = "テストデータ";
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBsKeyKouinTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKouin());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String kinyuuCd = "";

        String kouinCd = "84300050102311111020";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String kinyuuCd = "1030";

        String kouinCd = "";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String kinyuuCd = "1040";

        String kouinCd = "84300050102311111040";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String kinyuuCd = "1050";

        String kouinCd = "84300050102311111050";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "100150", "募集人コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String kinyuuCd = null;

        String kouinCd = "84300050102311111020";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String kinyuuCd = "1030";

        String kouinCd = null;

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String kinyuuCd = "1030";

        String kouinCd = "1430005010231111105";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String kinyuuCd = "1080";

        String kouinCd = "00000000000000000001";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "100161", "募集人コード");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String kinyuuCd = "1090";

        String kouinCd = "00000000000000000002";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "100162", "募集人コード");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String kinyuuCd = "1100";

        String kouinCd = "00000000000000000003";

        String bosyuuCd = bzGetBsKeyKouin.exec(kinyuuCd, kouinCd);

        exStringEquals(bosyuuCd, "100165", "募集人コード");
    }
}
