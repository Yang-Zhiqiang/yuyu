package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#checkTumitateDkanriTBL(String,BizDateY,BizDate,BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_checkTumitateDkanriTBL {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当整合チェック";

    private final static String sheetName = "INデータ";
    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(DBAccessDCommon.class).to(DBAccessDCommonMockForHozen.class);
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.caller = CheckDSeigouTest_checkTumitateDkanriTBL.class;
        SetHokenNndMockForHozen.caller = CheckDSeigouTest_checkTumitateDkanriTBL.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.caller = null;
        DBAccessDCommonMockForHozen.SYORIPTN = null;
        SetHokenNndMockForHozen.caller = null;
        SetHokenNndMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_checkTumitateDkanriTBL.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(230)
    public void testCheckTumitateDkanriTBL_A1() {

        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN1;

        String pSyono = null;
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180605);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180607);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBL(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd);

        exClassificationEquals(umuKbn, null, "処理結果");

    }

    @Test
    @TestOrder(240)
    public void testCheckTumitateDkanriTBL_A2() {

        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        String pSyono = "60806000011";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180605);
        BizDate pYendtHnkYmd = null;
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBL(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");

    }

    @Test
    @TestOrder(250)
    public void testCheckTumitateDkanriTBL_A3() {

        MockObjectManager.initialize();
        DBAccessDCommonMockForHozen.SYORIPTN = DBAccessDCommonMockForHozen.TESTPATTERN2;

        String pSyono = "60806000011";
        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20180605);
        BizDate pYendtHnkYmd = BizDate.valueOf(20180606);
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBL(pSyono, pKykMfHaitounendo, pKykYmd, pYendtHnkYmd);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");

    }
}
