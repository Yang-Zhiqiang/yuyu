package yuyu.common.hozen.ascommon;

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
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納計算通貨チェッククラスのメソッド {@link ChkZennouKeisanTuuka#exec(String pSyono, String pZnngaikakbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class ChkZennouKeisanTuukaTest_exec {

    private static final String SYONO1 = "17806000013";
    private static final String SYONO2 = "17806000024";
    private static final String SYONO3 = "17806000035";
    private static final String SYONO4 = "17806000046";

    @Inject
    ChkZennouKeisanTuuka chkZennouKeisanTuuka;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納計算通貨チェック";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(ChkZennouKeisanTuukaTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon(SYONO1));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SYONO2));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SYONO3));
        hozenDomManager.delete(hozenDomManager.getKykKihon(SYONO4));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        C_ErrorKbn kekkaKbn =  chkZennouKeisanTuuka.exec(SYONO1, "0");

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        C_ErrorKbn kekkaKbn =  chkZennouKeisanTuuka.exec(SYONO2, "1");

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        C_ErrorKbn kekkaKbn =  chkZennouKeisanTuuka.exec(SYONO3, "1");

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        C_ErrorKbn kekkaKbn =  chkZennouKeisanTuuka.exec(SYONO4, "1");

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");
    }
}
