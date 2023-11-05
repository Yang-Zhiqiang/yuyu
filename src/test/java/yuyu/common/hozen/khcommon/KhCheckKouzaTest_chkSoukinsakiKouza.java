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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.hozen.khozen.khseinengappiseiteisei.KhSeinengappiSeiTeiseiUiBean;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SoukinsakiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * KhCheckKouzaクラスのメソッド {@link KhCheckKouza#chkSoukinsakiKouza(CheckKouzaChkSoukinsakiKouzaUiBeanParam,KhozenCommonParam)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KhCheckKouzaTest_chkSoukinsakiKouza {

    @Inject
    private KhCheckKouza KhCheckKouza;

    private final static String fileName = "UT-SP_単体テスト仕様書_口座情報入力チェック";

    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KhCheckKouzaTest_chkSoukinsakiKouza.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KhCheckBankMaster.class).to(KhCheckBankMasterMockForHozen.class);

            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KhCheckBankMasterMockForHozen.caller = KhCheckKouzaTest_chkSoukinsakiKouza.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KhCheckBankMasterMockForHozen.caller = null;
        KhCheckBankMasterMockForHozen.SYORIPTN = null;
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testChkSoukinsakiKouza_A1() {

        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "銀行コードが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testChkSoukinsakiKouza_A2() {

        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "支店コードが未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(30)
    public void testChkSoukinsakiKouza_B1() {
        MockObjectManager.initialize();

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN1;

        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("9900");
            khSeinengappiSeiTeiseiUiBean.setSitencd("101");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 0, C_Tuukasyu.JPY);
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 1, "9900");
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 2, "101");
            exStringEquals(e.getMessage(), "入力された銀行または支店コードが存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testChkSoukinsakiKouza_B2() {
        MockObjectManager.initialize();

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN2;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("9900");
            khSeinengappiSeiTeiseiUiBean.setSitencd("153");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 0, C_Tuukasyu.JPY);
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 1, "9900");
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 2, "153");
            exStringEquals(e.getMessage(), "入力された銀行または支店コードが有効ではありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void testChkSoukinsakiKouza_B3() {
        MockObjectManager.initialize();

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN3;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("9900");
            khSeinengappiSeiTeiseiUiBean.setSitencd("133");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 0, C_Tuukasyu.JPY);
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 1, "9900");
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 2, "133");
            exStringEquals(e.getMessage(), "送金の取扱いがない支店です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(60)
    public void testChkSoukinsakiKouza_B4() {
        MockObjectManager.initialize();

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN4;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.EUR);
            khSeinengappiSeiTeiseiUiBean.setBankcd("9900");
            khSeinengappiSeiTeiseiUiBean.setSitencd("143");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 0, C_Tuukasyu.EUR);
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 1, "9900");
            MockObjectManager.assertArgumentPassed(KhCheckBankMasterMockForHozen.class, "checkBankMaster", 2, "143");
            exStringEquals(e.getMessage(), "外貨送金の取扱いがない銀行または支店です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(70)
    public void testChkSoukinsakiKouza_C1() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "預金種目が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testChkSoukinsakiKouza_C2() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.EUR);
            khSeinengappiSeiTeiseiUiBean.setBankcd("9900");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.TOUZA);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("120753918246");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "ゆうちょ銀行の場合、預金種目に当座は指定できません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(90)
    public void testChkSoukinsakiKouza_D1() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座番号が未入力です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(100)
    public void testChkSoukinsakiKouza_D2() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("123");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("123456");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        exBooleanEquals(result, true, "チェック結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getKouzano(), "0123456", "口座番号");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(110)
    public void testChkSoukinsakiKouza_D3() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("123456A/");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座番号が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(120)
    public void testChkSoukinsakiKouza_D4() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("12012345678901");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座番号の入力桁数が超過しています。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(130)
    public void testChkSoukinsakiKouza_D5() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.EUR);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("123");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("99999999");
        khSeinengappiSeiTeiseiUiBean.setKouzano("120123");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        exBooleanEquals(result, true, "チェック結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getKouzano(), "120123", "口座番号");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(140)
    public void testChkSoukinsakiKouza_E1() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座名義人の入力が必要です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(150)
    public void testChkSoukinsakiKouza_E2() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.DOUITU);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座名義人が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(160)
    public void testChkSoukinsakiKouza_E3() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.DOUITU);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶｱｲｳｴｵｶ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座名義人の入力桁数が超過しています。", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(170)
    public void testChkSoukinsakiKouza_E4() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;
        try {
            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("123");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.DOUITU);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座名義人が正しくありません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(180)
    public void testChkSoukinsakiKouza_E5() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("17806000013");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("123");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.DOUITU);
        khSeinengappiSeiTeiseiUiBean.setKyknmkn("");
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        exBooleanEquals(result, true, "チェック結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getKzmeiginmkn(), "アイウエオ", "口座名義人氏名（カナ）");
    }

    @Test
    @TestOrder(190)
    public void testChkSoukinsakiKouza_E6() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("17806000024");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("123");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.DOUITU);
        khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｱｲｳｴｵ");
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        exBooleanEquals(result, true, "チェック結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getKzmeiginmkn(), "ｱｲｳｴｵ", "口座名義人氏名（カナ）");
    }

    @Test
    @TestOrder(200)
    public void testChkSoukinsakiKouza_F1() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("567");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("ｺｳｻﾞﾒｲｷﾞﾆﾝｼﾒｲ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.BLNK);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        exBooleanEquals(result, true, "チェック結果");
        exStringEquals(KhCheckKouza.getGinkouName(), "銀行名テスト", "メンバ変数．銀行名");
        exStringEquals(KhCheckKouza.getShitenName(), "支店名テスト", "メンバ変数．支店名");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(210)
    public void testChkSoukinsakiKouza_G1() {

        try {
            KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("17806000057");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("567");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZ);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座情報が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(220)
    public void testChkSoukinsakiKouza_G2() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("567");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZ);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getBankcd(),"5674","銀行コード");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getSitencd(),"123","支店コード");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getYokinkbn(),C_YokinKbn.TOUZA,"預金種目区分");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getKzdoukbn(),C_Kzdou.DOUITU,"口座名義人同一区分");
    }

    @Test
    @TestOrder(230)
    public void testChkSoukinsakiKouza_G3() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("17806000013");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("567");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZ);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getBankcd(),"7456","銀行コード");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getSitencd(),"222","支店コード");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getYokinkbn(),C_YokinKbn.HUTUU,"預金種目区分");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getKzdoukbn(),C_Kzdou.BLNK,"口座名義人同一区分");
    }

    @Test
    @TestOrder(240)
    public void testChkSoukinsakiKouza_G4() {

        KhCheckBankMasterMockForHozen.SYORIPTN = KhCheckBankMasterMockForHozen.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("17806000013");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("567");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.PHURIKZIGAI);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getBankcd(),"1234","銀行コード");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getSitencd(),"567","支店コード");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getYokinkbn(),C_YokinKbn.HUTUU,"預金種目区分");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getKzdoukbn(),C_Kzdou.BLNK,"口座名義人同一区分");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(250)
    public void testChkSoukinsakiKouza_G5() {

        try {
            KhCheckBankMasterMock.SYORIPTN = KhCheckBankMasterMock.TESTPATTERN5;

            KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
            KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
            khSeinengappiSeiTeiseiUiBean.setSyono("17806000057");
            khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
            khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
            khSeinengappiSeiTeiseiUiBean.setSitencd("567");
            khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
            khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
            khSeinengappiSeiTeiseiUiBean.setKyknmkn("ｹｲﾔｸｼｬﾒｲ");
            khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
            khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
            khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.TKSHKSHRKZ);
            kcParm.setSikibetuKey("12");
            kcParm.setFunctionId("KhozenCommonParam");

            KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);
        } catch(BizLogicException e){
            exStringEquals(e.getMessage(), "口座情報が存在しません。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(260)
    public void testChkSoukinsakiKouza_G6() {

        KhCheckBankMasterMock.SYORIPTN = KhCheckBankMasterMock.TESTPATTERN5;

        KhSeinengappiSeiTeiseiUiBean khSeinengappiSeiTeiseiUiBean = SWAKInjector.getInstance(KhSeinengappiSeiTeiseiUiBean.class);
        KhozenCommonParam kcParm = SWAKInjector.getInstance(KhozenCommonParam.class);
        khSeinengappiSeiTeiseiUiBean.setSyono("12806345672");
        khSeinengappiSeiTeiseiUiBean.setShrtuukasyu(C_Tuukasyu.JPY);
        khSeinengappiSeiTeiseiUiBean.setBankcd("1234");
        khSeinengappiSeiTeiseiUiBean.setSitencd("567");
        khSeinengappiSeiTeiseiUiBean.setYokinkbn(C_YokinKbn.HUTUU);
        khSeinengappiSeiTeiseiUiBean.setKzdoukbn(C_Kzdou.BLNK);
        khSeinengappiSeiTeiseiUiBean.setKzmeiginmkn("コウザメイギニンシメイ");
        khSeinengappiSeiTeiseiUiBean.setKouzano("1207539");
        khSeinengappiSeiTeiseiUiBean.setSoukinsakikbn(C_SoukinsakiKbn.TKSHKSHRKZ);
        kcParm.setSikibetuKey("12");
        kcParm.setFunctionId("KhozenCommonParam");

        boolean result = KhCheckKouza.chkSoukinsakiKouza(khSeinengappiSeiTeiseiUiBean, kcParm);

        exBooleanEquals(result, true, "処理結果");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getBankcd(),"9900","銀行コード");
        exStringEquals(khSeinengappiSeiTeiseiUiBean.getSitencd(),"208","支店コード");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getYokinkbn(),C_YokinKbn.HUTUU,"預金種目区分");
        exClassificationEquals(khSeinengappiSeiTeiseiUiBean.getKzdoukbn(),C_Kzdou.DOUITU,"口座名義人同一区分");
    }
}
