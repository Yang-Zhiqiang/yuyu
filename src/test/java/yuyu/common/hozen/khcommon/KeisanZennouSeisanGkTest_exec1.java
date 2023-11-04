package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 前納精算額計算クラスのメソッド {@link KeisanZennouSeisanGk#exec(BizDate, String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanZennouSeisanGkTest_exec1 {

    @Inject
    private KeisanZennouSeisanGk keisanZennouSeisanGk;
    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_前納精算額計算";
    private final static String sheetName = "INデータ_20170609";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetZennouKikanRiritu.class).to(GetZennouKikanRirituMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        GetZennouKikanRirituMockForKhansyuu.caller = KeisanZennouSeisanGkTest_exec1.class;
    }

    @AfterClass
    public static void testClear() {

        GetZennouKikanRirituMockForKhansyuu.caller = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanZennouSeisanGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
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
    public void testExec_C1() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000010";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(20)
    public void testExec_C2() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000011";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(30)
    public void testExec_C3() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000022";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(40)
    public void testExec_C4() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000033";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(50)
    public void testExec_C5() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000044";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(60)
    public void testExec_C6() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000055";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_C7() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000066";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(80)
    public void testExec_C8() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000077";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(90)
    public void testExec_C9() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60806000088";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(100)
    public void testExec_C10() {

        BizDate calckijyunymd = BizDate.valueOf("20221102");
        String syono = "60806000099";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(110)
    public void testExec_C11() {

        BizDate calckijyunymd = BizDate.valueOf("20221101");
        String syono = "60806000103";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(120)
    public void testExec_C12() {

        GetZennouKikanRirituMockForKhansyuu.SYORIPTN = GetZennouKikanRirituMockForKhansyuu.TESTPATTERN1;
        BizDate calckijyunymd = BizDate.valueOf("20221031");
        String syono = "60806000114";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

    @Test
    @TestOrder(130)
    public void testExec_C13() {

        BizDate calckijyunymd = BizDate.valueOf("20181106");
        String syono = "60809526796";
        C_ErrorKbn errorKbn = keisanZennouSeisanGk.exec(calckijyunymd, syono);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");

    }

}
