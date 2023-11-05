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
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#checkKykMfHaitounendo(BizDateY,BizDate,BizDate,BizDate)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_checkKykMfHaitounendo {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当整合チェック";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(SetHokenNnd.class).to(SetHokenNndMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        MockObjectManager.initialize();
        SetHokenNndMockForHozen.caller = CheckDSeigouTest_checkKykMfHaitounendo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.caller = null;
        SetHokenNndMockForHozen.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_checkKykMfHaitounendo.class,
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
    @TestOrder(140)
    public void testCheckKykMfHaitounendo_A1() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        BizDateY pKykMfHaitounendo = null;
        BizDate pKykYmd = BizDate.valueOf("20180606");
        BizDate pYendtHnkYmd = null;
        BizDate pSyoriYmd = BizDate.valueOf("20180609");
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkKykMfHaitounendo(pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(umuKbn, null, "処理結果");
    }

    @Test
    @TestOrder(150)
    public void testCheckKykMfHaitounendo_A2() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2019);
        BizDate pKykYmd = BizDate.valueOf("20180605");
        BizDate pYendtHnkYmd = BizDate.valueOf("20180606");
        BizDate pSyoriYmd = BizDate.valueOf("20180507");
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkKykMfHaitounendo(pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");
    }

    @Test
    @TestOrder(160)
    public void testCheckKykMfHaitounendo_A3() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf("20180608");
        BizDate pYendtHnkYmd = BizDate.valueOf("20180609");
        BizDate pSyoriYmd = BizDate.valueOf("20180507");
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkKykMfHaitounendo(pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");
    }

    @Test
    @TestOrder(170)
    public void testCheckKykMfHaitounendo_A4() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2017);
        BizDate pKykYmd = BizDate.valueOf("20180608");
        BizDate pYendtHnkYmd = BizDate.valueOf("20180609");
        BizDate pSyoriYmd = BizDate.valueOf("20180507");
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkKykMfHaitounendo(pKykMfHaitounendo, pKykYmd, pYendtHnkYmd, pSyoriYmd);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");

    }
}
