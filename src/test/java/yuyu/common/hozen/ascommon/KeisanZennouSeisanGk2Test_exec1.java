package yuyu.common.hozen.ascommon;

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
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 前納精算額計算２クラスのメソッド {@link KeisanZennouSeisanGk2#exec(BizDate, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGk2Test_exec1 {

    @Inject
    private KeisanZennouSeisanGk2 keisanZennouSeisanGk2;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算２";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGk2Test_exec1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "11806001018";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001010";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001021";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001032";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001043";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001054";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20200701);
        String syono = "99806001065";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20170424);
        String syono = "99806001076";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20100424);
        String syono = "99806001087";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20100424);
        String syono = "99806001098";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20100424);
        String syono = "99806001102";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20090501);
        String syono = "99806001113";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020101);
        String syono = "99806001124";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate zennouseisankijyunymd = BizDate.valueOf(20020701);
        String syono = "99806001135";

        C_ErrorKbn errorKbn = keisanZennouSeisanGk2.exec(zennouseisankijyunymd, syono);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
    }
}
