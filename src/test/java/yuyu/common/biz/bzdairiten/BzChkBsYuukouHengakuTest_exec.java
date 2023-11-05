package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

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
 * BzChkBsYuukouHengakuクラスのメソッド {@link BzChkBsYuukouHengaku#exec(String,BizDate)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzChkBsYuukouHengakuTest_exec extends AbstractTest {

    @Inject
    private BzChkBsYuukouHengaku bzChkBsYuukouHengaku;

    private final static String fileName = "UT-SP_単体テスト仕様書_募集人変額保険資格有効性チェック";

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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBosyuunin());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String bosyuuCd = "";

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String bosyuuCd = null;

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String bosyuuCd = "125533";

        BizDate kijyunYmd = null;

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String bosyuuCd = "125534";

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String bosyuuCd = "125535";

        BizDate kijyunYmd = BizDate.valueOf("20150101");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String bosyuuCd = "125536";

        BizDate kijyunYmd = BizDate.valueOf("20150901");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        String bosyuuCd = "125537";

        BizDate kijyunYmd = BizDate.valueOf("99991230");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        String bosyuuCd = "125538";

        BizDate kijyunYmd = BizDate.valueOf("20150801");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        String bosyuuCd = "125539";

        BizDate kijyunYmd = BizDate.valueOf("20150802");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        String bosyuuCd = "125540";

        BizDate kijyunYmd = BizDate.valueOf("20150803");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, true, "有効性判定結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        String bosyuuCd = "125541";

        BizDate kijyunYmd = BizDate.valueOf("20150804");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        String bosyuuCd = "125542";

        BizDate kijyunYmd = BizDate.valueOf("20150805");

        Boolean yuukouChkRlt = bzChkBsYuukouHengaku.exec(bosyuuCd, kijyunYmd);

        exBooleanEquals(yuukouChkRlt, false, "有効性判定結果");
    }
}
