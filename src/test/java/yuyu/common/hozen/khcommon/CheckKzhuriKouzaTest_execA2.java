package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.CheckKouzaNo;
import yuyu.common.biz.bzcommon.CheckKouzaNoMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * CheckKzhuriKouzaクラスのメソッド {@link CheckKzhuriKouza#exec(CheckKzhuriKouzaExecUiBeanParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKzhuriKouzaTest_execA2 extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_口座振替口座入力チェック";

    private final static String sheetName = "INデータ";

    @Inject
    private CheckKzhuriKouza checkKzhuriKouza;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckKouzaNo.class).to(CheckKouzaNoMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckKouzaNoMockForKhansyuu.caller = CheckKzhuriKouzaTest_execA2.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        CheckKouzaNoMockForKhansyuu.caller = null;
        CheckKouzaNoMockForKhansyuu.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CheckKzhuriKouzaTest_execA2.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
        bizDomManager.delete(bizDomManager.getAllKinyuuKikanHuhoyofuriInfo());

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testExec_B1() {
        try {
            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("");
            pUiBean.setSitencd("123");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setKouzano("321");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "銀行コードが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_B2() {
        try {
            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "支店コードが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void testExec_B3() {
        try {

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("123");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "入力された銀行または支店コードが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_B4() {
        try {

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("104");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "入力された銀行または支店コードが有効ではありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void testExec_B5() {
        try {

            changeSystemDate(BizDate.valueOf("19800601"));
            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("4321");
            pUiBean.setSitencd("105");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "入力された金融機関は預振協定外です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(60)
    public void testExec_B6() {
        try {

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("106");
            pUiBean.setYokinkbn(C_YokinKbn.BLNK);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "預金種目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(70)
    public void testExec_B7() {
        try {
            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("9900");
            pUiBean.setSitencd("123");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "ゆうちょ銀行の場合、預金種目に当座は指定できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testExec_B8() {
        try {

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("108");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座番号が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(90)
    public void testExec_B9() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN1;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("109");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isCheckOK", 0, "0000321");
            MockObjectManager.assertArgumentPassed(CheckKouzaNoMockForKhansyuu.class, "isCheckOK", 1, C_Tuukasyu.JPY);

            exStringEquals(e.getMessage(), "口座番号が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(100)
    public void testExec_B10() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN2;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("110");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座番号の入力桁数が超過しています。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(110)
    public void testExec_B11() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("111");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.BLNK);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座名義契約者同一人区分が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(120)
    public void testExec_B12() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("112");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setKzmeiginmkn("");
            pUiBean.setKouzano("321");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座名義人の入力が必要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(130)
    public void testExec_B13() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("113");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
            pUiBean.setKzmeiginmkn("テスト");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座名義人が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(140)
    public void testExec_B14() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("114");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.DOUITU);
            pUiBean.setKzmeiginmkn("");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座名義人が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(150)
    public void testExec_B15() {
        try {

            MockObjectManager.initialize();

            CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

            CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
                .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

            pUiBean.setBankcd("1234");
            pUiBean.setSitencd("115");
            pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            pUiBean.setKouzano("321");
            pUiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
            pUiBean.setKzmeiginmkn("1234567891011121314151617181920");
            pUiBean.setVkykskyknmkn("test");
            pUiBean.setBanknmkj("大阪銀行");
            pUiBean.setSitennmkj("大阪支店");

            checkKzhuriKouza.exec(pUiBean);
        } catch (Exception e) {

            exStringEquals(e.getMessage(), "口座名義人の入力桁数が超過しています。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(160)
    public void testExec_B16() {

        MockObjectManager.initialize();

        CheckKouzaNoMockForKhansyuu.SYORIPTN = CheckKouzaNoMockForKhansyuu.TESTPATTERN3;

        CheckKzhuriKouzaExecUiBeanParamImpl pUiBean = SWAKInjector
            .getInstance(CheckKzhuriKouzaExecUiBeanParamImpl.class);

        pUiBean.setBankcd("0001");
        pUiBean.setSitencd("116");
        pUiBean.setYokinkbn(C_YokinKbn.TOUZA);
        pUiBean.setKouzano("321");
        pUiBean.setKzkykdoukbn(C_KzkykdouKbn.SITEI);
        pUiBean.setKzmeiginmkn("123");
        pUiBean.setVkykskyknmkn("test");
        pUiBean.setBanknmkj("大阪銀行");
        pUiBean.setSitennmkj("大阪支店");

        boolean result = checkKzhuriKouza.exec(pUiBean);
        exBooleanEquals(result, true, "処理結果");
        exStringEquals(pUiBean.getBanknmkj(), "みずほ銀行", "銀行名");
        exStringEquals(pUiBean.getSitennmkj(), "歌島橋支店", "支店名");
        exStringEquals(pUiBean.getKouzano(), "0000321", "口座番号");
        exStringEquals(pUiBean.getKzmeiginmkn(), "123", "口座名義人氏名（カナ）");
    }

}
