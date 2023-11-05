package yuyu.common.biz.bzdairiten;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 代理店法人商号取得クラスのメソッド {@link BzGetAgHoujinsyougou#exec(String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzGetAgHoujinsyougouTest_exec extends AbstractTest {

    @Inject
    private BzGetAgHoujinsyougou bzGetAgHoujinsyougou;

    private final static String fileName = "UT_SP_単体テスト仕様書_代理店法人商号取得";

    private final static String sheetName = "テストデータ";


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetAgHoujinsyougouTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairitenSyougou());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        String dairitenCd = "";

        String kanjiHoujinSyougou = bzGetAgHoujinsyougou.exec(dairitenCd);

        exStringEquals(kanjiHoujinSyougou, "", "漢字法人商号");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String dairitenCd = "9011020";

        String kanjiHoujinSyougou = bzGetAgHoujinsyougou.exec(dairitenCd);

        exStringEquals(kanjiHoujinSyougou, "", "漢字法人商号");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String dairitenCd = "9011030";

        String kanjiHoujinSyougou = bzGetAgHoujinsyougou.exec(dairitenCd);

        exStringEquals(kanjiHoujinSyougou, "漢字法人商号三", "漢字法人商号");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String dairitenCd = null;

        String kanjiHoujinSyougou = bzGetAgHoujinsyougou.exec(dairitenCd);

        exStringEquals(kanjiHoujinSyougou, "", "漢字法人商号");
    }
}
