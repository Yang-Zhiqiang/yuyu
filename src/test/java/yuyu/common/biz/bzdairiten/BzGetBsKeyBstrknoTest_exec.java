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
 * 募集人コード取得（募集人登録番号指定）クラスのメソッド {@link BzGetBsKeyBstrkno#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetBsKeyBstrknoTest_exec extends AbstractTest {

    @Inject
    private BzGetBsKeyBstrkno bzGetBsKeyBstrkno;

    private final static String fileName = "UT_SP_単体テスト仕様書_募集人コード取得（募集人登録番号指定）";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBsKeyBstrknoTest_exec.class, fileName, sheetName);
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
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String bosyuuTrkNo = "";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String bosyuuTrkNo = null;

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String bosyuuTrkNo = "9876543210123";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String bosyuuTrkNo = "1234567890123";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "123456", "募集人コード");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String bosyuuTrkNo = "1234567890130";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "123460", "募集人コード");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String bosyuuTrkNo = "1234567890131";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "123471", "募集人コード");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String bosyuuTrkNo = "1234567890132";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "", "募集人コード");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String bosyuuTrkNo = "1234567890133";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "123490", "募集人コード");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String bosyuuTrkNo = "1234567890134";

        String bosyuuCd = bzGetBsKeyBstrkno.exec(bosyuuTrkNo);

        exStringEquals(bosyuuCd, "123502", "募集人コード");
    }
}
