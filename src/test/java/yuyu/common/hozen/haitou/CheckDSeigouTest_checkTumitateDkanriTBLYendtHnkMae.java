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
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 配当整合チェッククラスのメソッド {@link CheckDSeigou#checkTumitateDkanriTBLYendtHnkMae(BizDateY,BizDate,IT_KhTumitateDKanri)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkMae {

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
        SetHokenNndMockForHozen.caller = CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkMae.class;
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
            testDataAndTblMap = testDataMaker.getInData(CheckDSeigouTest_checkTumitateDkanriTBLYendtHnkMae.class,
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
    @TestOrder(260)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A1() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN1;

        BizDateY pKykMfHaitounendo = null;
        BizDate pKykYmd = null;
        IT_KhTumitateDKanri pKhTumitateDKanri = null;
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, pKhTumitateDKanri);

        exClassificationEquals(umuKbn, null, "処理結果");
    }

    @Test
    @TestOrder(270)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A2() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN2;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20120606);
        IT_KhTumitateDKanri pKhTumitateDKanri = null;
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, pKhTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");
    }

    @Test
    @TestOrder(280)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A3() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN3;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20130606);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        khTumitateDKanri.setKbnkey("02");
        khTumitateDKanri.setSyono("60806000022");
        khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20140609));
        khTumitateDKanri.setRenno(1);

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");
    }

    @Test
    @TestOrder(290)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A4() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20140606);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        khTumitateDKanri.setKbnkey("02");
        khTumitateDKanri.setSyono("60806000022");
        khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180609));
        khTumitateDKanri.setRenno(1);

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");
    }

    @Test
    @TestOrder(300)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A5() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;

        BizDateY pKykMfHaitounendo = BizDateY.valueOf(2018);
        BizDate pKykYmd = BizDate.valueOf(20140606);
        IT_KhTumitateDKanri khTumitateDKanri = null;
        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");

    }

    @Test
    @TestOrder(300)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A6() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;

        BizDateY pKykMfHaitounendo = null;
        BizDate pKykYmd = BizDate.valueOf(20140606);

        IT_KhTumitateDKanri khTumitateDKanri = new IT_KhTumitateDKanri();
        khTumitateDKanri.setKbnkey("02");
        khTumitateDKanri.setSyono("60806000022");
        khTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20140609));
        khTumitateDKanri.setRenno(1);

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "処理結果");

    }

    @Test
    @TestOrder(300)
    public void testCheckTumitateDkanriTBLYendtHnkMae_A7() {

        MockObjectManager.initialize();
        SetHokenNndMockForHozen.SYORIPTN = SetHokenNndMockForHozen.TESTPATTERN4;

        BizDateY pKykMfHaitounendo = null;
        BizDate pKykYmd = BizDate.valueOf(20140606);

        IT_KhTumitateDKanri khTumitateDKanri = null;

        CheckDSeigou checkDSeigou = SWAKInjector.getInstance(CheckDSeigou.class);
        C_UmuKbn umuKbn = checkDSeigou.checkTumitateDkanriTBLYendtHnkMae(pKykMfHaitounendo, pKykYmd, khTumitateDKanri);

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "処理結果");

    }
}
