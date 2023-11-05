package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 猶予期間外チェッククラスのメソッド {@link String pSyono, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckYuuyokkngaiTest_exec {

    private final static String syoNo1 = "17806015033";

    private final static String syoNo2 = "17806015022";

    private final static String syoNo3 = "17806015044";

    private final static String syoNo4 = "17806015055";

    private final static String syoNo5 = "17806000105";

    private final static String syoNo6 = "17806000138";

    private final static String fileName = "UT_SP_単体テスト仕様書_猶予期間外チェック";

    private final static String sheetName = "テストデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetYuuyokknmanryobi.class).to(SetYuuyokknmanryobiMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){
        SetYuuyokknmanryobiMockForKhansyuu.caller = CheckYuuyokkngaiTest_exec.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckYuuyokkngaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
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

    @AfterClass
    public static void testClear() {
        SetYuuyokknmanryobiMockForKhansyuu.caller = null;
        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = null;
        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        BizDate pDate = BizDate.valueOf(20150101);

        Boolean check =  checkYuuyokkngai.exec(syoNo1, pDate);

        exBooleanEquals(check, true, "実行結果");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        MockObjectManager.initialize();

        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;

        BizDate pDate = BizDate.valueOf(20171010);

        Boolean check =  checkYuuyokkngai.exec(syoNo2, pDate);

        exBooleanEquals(check, false, "実行結果");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        MockObjectManager.initialize();

        SetYuuyokknmanryobiMockForKhansyuu.SYORIPTN = SetYuuyokknmanryobiMockForKhansyuu.TESTPATTERN1;
        BizDate pDate = BizDate.valueOf(20131010);

        Boolean check =  checkYuuyokkngai.exec(syoNo3, pDate);

        exBooleanEquals(check, true, "実行結果");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        MockObjectManager.initialize();

        BizDate pDate = BizDate.valueOf(20161010);

        Boolean check =  checkYuuyokkngai.exec(syoNo4, pDate);

        exBooleanEquals(check, true, "実行結果");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        BizDate pDate = BizDate.valueOf(20170101);

        Boolean check =  checkYuuyokkngai.exec(syoNo5, pDate);

        exBooleanEquals(check, true, "実行結果");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        BizDate pDate = BizDate.valueOf(20170101);

        Boolean check =  checkYuuyokkngai.exec(syoNo6, pDate);

        exBooleanEquals(check, true, "実行結果");
    }

}
