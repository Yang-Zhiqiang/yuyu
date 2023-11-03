package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
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

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * KykNaiyouOsiraseiSksクラスのメソッド {@link KykNaiyouOsiraseiSks#exec(String,int,KhAddKoumokuSetteiBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KykNaiyouOsiraseiSksTest_setReportBean extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ご契約内容のお知らせ作成処理";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(EditKykNaiyouOsirase.class).to(EditKykNaiyouOsiraseMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit(){

        EditKykNaiyouOsiraseMockForHozen.caller = KykNaiyouOsiraseiSksTest_setReportBean.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.caller = null;
        EditKoujyoSyoumeiTblMockForHozen.SYORIPTN = null;
    }


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KykNaiyouOsiraseiSksTest_setReportBean.class,
                fileName, sheetName);
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
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSetReportBean_A1() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001010", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSetReportBean_A2() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001227", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSetReportBean_A3() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001238", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSetReportBean_A4() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN5;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001249", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSetReportBean_A5() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN6;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001250", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSetReportBean_A6() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001261", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testSetReportBean_A7() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001272", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testSetReportBean_A8() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001283", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testSetReportBean_A9() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN7;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001294", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");


    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testSetReportBean_A10() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001308", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testSetReportBean_A11() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN3;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001319", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testSetReportBean_A12() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001320", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testSetReportBean_A13() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN5;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001331", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSetReportBean_A14() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN6;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001342", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testSetReportBean_A15() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001353", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testSetReportBean_A16() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001364", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testSetReportBean_A17() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN4;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001375", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testSetReportBean_A18() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001397", 1, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        assertNotNull(kykNaiyouOsiraseiSks.getTyouhyouKey(), "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testSetReportBean_A19() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001386", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }
}
