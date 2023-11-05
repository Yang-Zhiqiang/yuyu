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
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 代理店コード取得（親代理店、事務所指定）クラスのメソッド {@link BzGetAgKeyJimusyo#exec(String,String)}テスト用クラスです<br />
 */
@RunWith(SWAKTestRunner.class)
public class BzGetAgKeyJimusyoTest_exec extends AbstractTest {

    @Inject
    private BzGetAgKeyJimusyo bzGetAgKeyJimusyo;

    private final static String fileName = "UT-SP_単体テスト仕様書_代理店コード取得（親代理店、事務所指定）";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetAgKeyJimusyoTest_exec.class, fileName, sheetName);
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

        String oyadrtenCd = "";

        String drtenjimCd = "2010";

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "", "代理店コード");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        String oyadrtenCd = "1030010";

        String drtenjimCd = "";

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "", "代理店コード");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        String oyadrtenCd = "1040010";

        String drtenjimCd = "4010";

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "", "代理店コード");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        String oyadrtenCd = "1050010";

        String drtenjimCd = "5110";

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "1055150", "代理店コード");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        String oyadrtenCd = null;

        String drtenjimCd = "2010";

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "", "代理店コード");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        String oyadrtenCd = "1030010";

        String drtenjimCd = null;

        String drtenCd = bzGetAgKeyJimusyo.exec(oyadrtenCd, drtenjimCd);

        exStringEquals(drtenCd, "", "代理店コード");
    }
}
