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
public class KykNaiyouOsiraseiSksTest_exec extends AbstractTest {

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

        EditKykNaiyouOsiraseMockForHozen.caller = KykNaiyouOsiraseiSksTest_exec.class;
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
            testDataAndTblMap = testDataMaker.getInData(KykNaiyouOsiraseiSksTest_exec.class,
                fileName, sheetName);
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
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("17806000013", 1, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "対象契約が存在しません。 " , "エラーメッセージ内容");
        }
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("17806000024", 1, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "消滅契約のため処理できません。 " , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001032", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001043", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "払込猶予期間外のため処理できません。" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR , "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("99806001054", 0, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "払込猶予期間外のため処理できません。 " , "エラーメッセージ内容");
        }
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {

        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("99806001065", 1, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "処理日が契約日前のため処理できません。 " , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201110));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001076", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK , "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001087", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001098", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001102", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001113", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001124", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001135", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "契約対象外商品のため処理できません。" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("99806001146", 0, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "契約対象外商品のため処理できません。" , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001157", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "", "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN1;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001168", 0, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "", "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("99806001179", 0, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "笑顔の約束のため処理できません。２０２１年６月頃対応予定です。" , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001180", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "笑顔の約束のため処理できません。２０２１年６月頃対応予定です。" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001191", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "契約対象外商品のため処理できません。" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "", "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("99806001205", 0, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "契約対象外商品のため処理できません。" , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        MockObjectManager.initialize();
        EditKykNaiyouOsiraseMockForHozen.SYORIPTN = EditKykNaiyouOsiraseMockForHozen.TESTPATTERN2;
        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("99806001216", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "配当金が未反映のため、処理できません。配当金反映後に処理可能となります。" , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 1, "為替レートみなし区分");
    }

    @Test(expected = Exception.class)
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        try {

            kykNaiyouOsiraseiSks.exec("21806000010", 1, khAddKoumokuSetteiBean);

        } catch (AssertionError e) {

            exStringEquals(e.getMessage(), "プラスつみたて終身保険（円建）のため処理できません。２０２１年６月頃対応予定です。" , "エラーメッセージ内容");
        }
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        changeSystemDate(BizDate.valueOf(20201107));
        KykNaiyouOsiraseiSks kykNaiyouOsiraseiSks = SWAKInjector.getInstance(KykNaiyouOsiraseiSks.class);
        KhAddKoumokuSetteiBean khAddKoumokuSetteiBean = SWAKInjector.getInstance(KhAddKoumokuSetteiBean.class);
        khAddKoumokuSetteiBean.setSakuseiSyozoku("代理店事務サ−ビス室");
        khAddKoumokuSetteiBean.setSakuseisya("５９０保総合業務０１");

        C_ErrorKbn errorKbn = kykNaiyouOsiraseiSks.exec("21806000010", 2, khAddKoumokuSetteiBean);

        exStringEquals(kykNaiyouOsiraseiSks.getErrorMsg(), "プラスつみたて終身保険（円建）のため処理できません。２０２１年６月頃対応予定です。   " , "エラーメッセージ");
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(kykNaiyouOsiraseiSks.getTyouhyouKey(), "" , "帳票キー");
        exNumericEquals(kykNaiyouOsiraseiSks.getKawaserateMinasiKbn(), 0, "為替レートみなし区分");
    }
}
