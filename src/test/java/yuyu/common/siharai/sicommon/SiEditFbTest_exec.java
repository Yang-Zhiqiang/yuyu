package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.siharai.edittbl.SiEditFb;
import yuyu.common.siharai.edittbl.SiEditFbInBean;
import yuyu.common.siharai.edittbl.SiEditFbOutBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金ＦＢ送金データTBL編集のメソッド{@link SiEditFb#exec(SiEditFbInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiEditFbTest_exec extends AbstractTest {
    @Inject
    private SiEditFb siEditFb;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金給付金ＦＢ送金データTBL編集";

    private final static String sheetName = "INデータ";

    @Inject
    private BaseUserInfo baseUserInfo;
    @Inject
    private AS_Kinou kinou;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SiEditFbTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllGinkou());
        bizDomManager.delete(bizDomManager.getAllKinyuuKikanHuhoyofuriInfo());
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='shrhouSiteiKbn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='bankCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='sitenCd'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(40)
    public void testExec_A4() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='yokinKbn'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(50)
    public void testExec_A5() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='kouzaNo'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(60)
    public void testExec_A6() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("123");
        siEditFbInBean.setKykTuukasyu(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='kykTuukasyu'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(70)
    public void testExec_A7() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("123");
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setSoukinKwsRate(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='soukinKwsRate'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(80)
    public void testExec_A8() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("123");
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='fbSokinEdaBangou'", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("123");
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(123);
        siEditFbInBean.setSiDenpyoDataLst(null);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "パラメータエラー　param='siDenpyoDataLst'", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(100)
    public void testExec_B1() {
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("bankCd");
        siEditFbInBean.setSitenCd("sitenCd");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("123");
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(123);
        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        assertNull(siEditFbOutBean.getSiFBSoukinDataLst());
        assertNull(siEditFbOutBean.getSiGaikaFBSoukinDataLst());
    }

    @Test
    @TestOrder(110)
    public void testExec_B2() {
        baseUserInfo.getUser().setUserId("JUnit1234567890");
        kinou.setKinouId("sicommon");

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);

        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("QQ101");
        siEditFbInBean.setSitenCd("QR101");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmKn("加奈欄");
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(10);

        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
        siDenpyoData.setDenrenno("QR0001");
        siDenpyoData.setEdano(10);
        siDenpyoData.setDensyskbn(C_DensysKbn.HKSIHARAI);
        siDenpyoData.setSyono("11807111118");
        siDenpyoData.setDenymd(BizDate.valueOf("20160222"));
        siDenpyoData.setSyoriYmd(BizDate.valueOf("20160218"));
        siDenpyoData.setSyoricd("0001");
        siDenpyoData.setSyorisosikicd("0002");
        siDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
        siDenpyoData.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoData);
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        JT_SiFBSoukinData siFBSoukinData = siEditFbOutBean.getSiFBSoukinDataLst().get(0);
        exStringEquals(siFBSoukinData.getDenrenno(), "QR0001", "伝票データ連番");
        exNumericEquals(siFBSoukinData.getEdano(), 10, "枝番号");
        exClassificationEquals(siFBSoukinData.getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exClassificationEquals(siFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(siFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(siFBSoukinData.getSyoricd(), "0001", "処理コード");
        exStringEquals(siFBSoukinData.getSyorisosikicd(), "0002", "処理組織コード");
        exDateEquals(siFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160218"), "処理年月日");
        exDateEquals(siFBSoukinData.getDenymd(), BizDate.valueOf("20160222"), "伝票日付");
        exStringEquals(siFBSoukinData.getSyono(), "11807111118", "証券番号");
        exClassificationEquals(siFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(siFBSoukinData.getBankcd(), "QQ101", "銀行コード");
        exStringEquals(siFBSoukinData.getSitencd(), "QR101", "支店コード");
        exClassificationEquals(siFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(siFBSoukinData.getKouzano(), "SDR101", "口座番号");
        exStringEquals(siFBSoukinData.getKzmeiginmkn(), "加奈欄", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(siFBSoukinData.getSoukingk(), BizCurrency.valueOf(10000), "送金金額");
        exClassificationEquals(siFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(siFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(20000), "外貨対価額");
        exBizCalcbleEquals(siFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(9), "送金用為替レート");
        exStringEquals(siFBSoukinData.getGyoumuKousinKinou(), "sicommon", "業務用更新機能ＩＤ");
        exStringEquals(siFBSoukinData.getGyoumuKousinsyaId(), "JUnit1234567890", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(120)
    public void testExec_B3() {

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);

        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("QQ101");
        siEditFbInBean.setSitenCd("QR101");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmKn("加奈欄");
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.USD);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(12);

        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData siDenpyoDataFirst = new JT_SiDenpyoData();
        siDenpyoDataFirst.setDenrenno("QR0001");
        siDenpyoDataFirst.setEdano(10);
        siDenpyoDataFirst.setDensyskbn(C_DensysKbn.HKSIHARAI);
        siDenpyoDataFirst.setSyono("11807111118");
        siDenpyoDataFirst.setDenymd(BizDate.valueOf("20160222"));
        siDenpyoDataFirst.setSyoriYmd(BizDate.valueOf("20160218"));
        siDenpyoDataFirst.setSyoricd("0001");
        siDenpyoDataFirst.setSyorisosikicd("0002");
        siDenpyoDataFirst.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataFirst.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataFirst);
        JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
        siDenpyoDataSecond.setDenrenno("QR0002");
        siDenpyoDataSecond.setEdano(11);
        siDenpyoDataSecond.setDensyskbn(C_DensysKbn.SKEI);
        siDenpyoDataSecond.setSyono("11807111129");
        siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160222"));
        siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160218"));
        siDenpyoDataSecond.setSyoricd("0001");
        siDenpyoDataSecond.setSyorisosikicd("0003");
        siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataSecond.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataSecond);
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        List<JT_SiFBSoukinData> siFBSoukinDataLst = siEditFbOutBean.getSiFBSoukinDataLst();
        assertNull(siFBSoukinDataLst);
        List<JT_SiGaikaFBSoukinData> siGaikaFBSoukinDataLst = siEditFbOutBean.getSiGaikaFBSoukinDataLst();
        assertNull(siGaikaFBSoukinDataLst);
    }

    @Test(expected = BizAppException.class)
    @TestOrder(130)
    public void testExec_B4() {
        changeSystemDate(BizDate.valueOf("20150310"));
        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("9999");
        siEditFbInBean.setSitenCd("888");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmKn("加奈欄");
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.USD);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(12);

        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
        siDenpyoData.setDenrenno("QR0001");
        siDenpyoData.setEdano(10);
        siDenpyoData.setDensyskbn(C_DensysKbn.HKSIHARAI);
        siDenpyoData.setSyono("11807111118");
        siDenpyoData.setDenymd(BizDate.valueOf("20160222"));
        siDenpyoData.setSyoriYmd(BizDate.valueOf("20160218"));
        siDenpyoData.setSyoricd("0001");
        siDenpyoData.setSyorisosikicd("0002");
        siDenpyoData.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoData.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoData);
        JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
        siDenpyoDataSecond.setDenrenno("QR0002");
        siDenpyoDataSecond.setEdano(11);
        siDenpyoDataSecond.setDensyskbn(C_DensysKbn.SKEI);
        siDenpyoDataSecond.setSyono("11807111129");
        siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160502"));
        siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160219"));
        siDenpyoDataSecond.setSyoricd("0001");
        siDenpyoDataSecond.setSyorisosikicd("0003");
        siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataSecond.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataSecond);
        JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
        siDenpyoDataThird.setDenrenno("QR0003");
        siDenpyoDataThird.setEdano(12);
        siDenpyoDataThird.setDensyskbn(C_DensysKbn.HOZEN);
        siDenpyoDataThird.setSyono("11807111130");
        siDenpyoDataThird.setDenymd(BizDate.valueOf("20160503"));
        siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160225"));
        siDenpyoDataThird.setSyoricd("0001");
        siDenpyoDataThird.setSyorisosikicd("0004");
        siDenpyoDataThird.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataThird.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataThird);
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        try {
            siEditFb.exec(siEditFbInBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　BM_Ginkou　key:bankcd=9999,sitencd=888", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_B5() {
        baseUserInfo.getUser().setUserId("JUnit1234567890");
        kinou.setKinouId("sicommon");

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);

        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("0170");
        siEditFbInBean.setSitenCd("181");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmei("toms");
        siEditFbInBean.setShrTuukaSyu(C_Tuukasyu.JPY);
        siEditFbInBean.setGaikaShrgk(BizCurrency.valueOf(10001));
        siEditFbInBean.setCrossRateShrgk(BizCurrency.valueOf(10002));
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.USD);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(12);

        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData siDenpyoData = new JT_SiDenpyoData();
        siDenpyoData.setDenrenno("QR0001");
        siDenpyoData.setEdano(10);
        siDenpyoData.setDensyskbn(C_DensysKbn.HKSIHARAI);
        siDenpyoData.setSyono("11807111118");
        siDenpyoData.setDenymd(BizDate.valueOf("20160222"));
        siDenpyoData.setSyoriYmd(BizDate.valueOf("20160218"));
        siDenpyoData.setSyoricd("0001");
        siDenpyoData.setSyorisosikicd("0002");
        siDenpyoData.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoData.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoData);
        JT_SiDenpyoData siDenpyoDataSecond = new JT_SiDenpyoData();
        siDenpyoDataSecond.setDenrenno("QR0002");
        siDenpyoDataSecond.setEdano(11);
        siDenpyoDataSecond.setDensyskbn(C_DensysKbn.SKEI);
        siDenpyoDataSecond.setSyono("11807111129");
        siDenpyoDataSecond.setDenymd(BizDate.valueOf("20160502"));
        siDenpyoDataSecond.setSyoriYmd(BizDate.valueOf("20160219"));
        siDenpyoDataSecond.setSyoricd("0001");
        siDenpyoDataSecond.setSyorisosikicd("0003");
        siDenpyoDataSecond.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataSecond.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataSecond);
        JT_SiDenpyoData siDenpyoDataThird = new JT_SiDenpyoData();
        siDenpyoDataThird.setDenrenno("QR0003");
        siDenpyoDataThird.setEdano(12);
        siDenpyoDataThird.setDensyskbn(C_DensysKbn.HOZEN);
        siDenpyoDataThird.setSyono("11807111130");
        siDenpyoDataThird.setDenymd(BizDate.valueOf("20160503"));
        siDenpyoDataThird.setSyoriYmd(BizDate.valueOf("20160225"));
        siDenpyoDataThird.setSyoricd("0001");
        siDenpyoDataThird.setSyorisosikicd("0004");
        siDenpyoDataThird.setTuukasyu(C_Tuukasyu.USD);
        siDenpyoDataThird.setDengyoumucd("9943");
        siDenpyoDataLst.add(siDenpyoDataThird);
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        assertNull(siEditFbOutBean.getSiFBSoukinDataLst());
        JT_SiGaikaFBSoukinData siGaikaFBSoukinData = siEditFbOutBean.getSiGaikaFBSoukinDataLst().get(0);

        exStringEquals(siGaikaFBSoukinData.getDenrenno(), "QR0003", "伝票データ連番");
        exNumericEquals(siGaikaFBSoukinData.getEdano(), 12, "枝番号");
        exClassificationEquals(siGaikaFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exClassificationEquals(siGaikaFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.SETTEI_HUKA, "外貨業務コー");
        exClassificationEquals(siGaikaFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(siGaikaFBSoukinData.getSyoricd(), "0001", "処理コード");
        exStringEquals(siGaikaFBSoukinData.getSyorisosikicd(), "0004", "処理組織コード");
        exDateEquals(siGaikaFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160225"), "処理年月日");
        exDateEquals(siGaikaFBSoukinData.getDenymd(), BizDate.valueOf("20160503"), "伝票日付");
        exStringEquals(siGaikaFBSoukinData.getSyono(), "11807111130", "証券番号");
        exClassificationEquals(siGaikaFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(siGaikaFBSoukinData.getBankcd(), "0170", "銀行コード");
        exStringEquals(siGaikaFBSoukinData.getBanknmej(), "THE YAMAGUCHI BANK, LTD.", "銀行名（英字）");
        exStringEquals(siGaikaFBSoukinData.getSitencd(), "181", "支店コード");
        exStringEquals(siGaikaFBSoukinData.getSitennmej(), "OBAYAMA", "支店名（英字）");
        exStringEquals(siGaikaFBSoukinData.getKouzano(), "SDR101", "口座番号");
        exStringEquals(siGaikaFBSoukinData.getKzmeiginmei(), "toms", "口座名義人名（英字）");
        exClassificationEquals(siGaikaFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siGaikaFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(10001), "外貨支払額");
        exClassificationEquals(siGaikaFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(siGaikaFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(10002), "クロスレート支払額");
        exBizCalcbleEquals(siGaikaFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(9), "送金用為替レート");
        exStringEquals(siGaikaFBSoukinData.getGyoumuKousinKinou(), "sicommon", "業務用更新機能ＩＤ");
        exStringEquals(siGaikaFBSoukinData.getGyoumuKousinsyaId(), "JUnit1234567890", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(150)
    public void testExec_B6() {

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("9900");
        siEditFbInBean.setSitenCd("097");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmKn("加奈欄");
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(10);
        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData JT_SiDenpyoData = new JT_SiDenpyoData();
        JT_SiDenpyoData.setDenrenno("QR0001");
        JT_SiDenpyoData.setEdano(20);
        JT_SiDenpyoData.setDensyskbn(C_DensysKbn.HKSIHARAI);
        JT_SiDenpyoData.setSyono("11807111118");
        JT_SiDenpyoData.setDenymd(BizDate.valueOf("20160222"));
        JT_SiDenpyoData.setSyoriYmd(BizDate.valueOf("20160218"));
        JT_SiDenpyoData.setSyoricd("0001");
        JT_SiDenpyoData.setSyorisosikicd("0002");
        JT_SiDenpyoData.setTuukasyu(C_Tuukasyu.USD);
        JT_SiDenpyoData.setDengyoumucd("9943");
        siDenpyoDataLst.add(JT_SiDenpyoData);
        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        assertNull(siEditFbOutBean.getSiFBSoukinDataLst());
        assertNull(siEditFbOutBean.getSiGaikaFBSoukinDataLst());
    }

    @Test
    @TestOrder(160)
    public void testExec_B7() {

        SiEditFbInBean siEditFbInBean = SWAKInjector.getInstance(SiEditFbInBean.class);
        siEditFbInBean.setShrhouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        siEditFbInBean.setBankCd("QQ101");
        siEditFbInBean.setSitenCd("QR101");
        siEditFbInBean.setYokinKbn(C_YokinKbn.HUTUU);
        siEditFbInBean.setKouzaNo("SDR101");
        siEditFbInBean.setKzMeiginmKn("加奈欄");
        siEditFbInBean.setSoukinGk(BizCurrency.valueOf(10000));
        siEditFbInBean.setKykTuukasyu(C_Tuukasyu.JPY);
        siEditFbInBean.setGaikaTaikaGk(BizCurrency.valueOf(20000));
        siEditFbInBean.setSoukinKwsRate(BizNumber.valueOf(9));
        siEditFbInBean.setFbSokinEdaBangou(10);
        List<JT_SiDenpyoData> siDenpyoDataLst = new ArrayList<>();
        JT_SiDenpyoData JT_SiDenpyoData = new JT_SiDenpyoData();
        JT_SiDenpyoData.setDenrenno("QR0001");
        JT_SiDenpyoData.setEdano(20);
        JT_SiDenpyoData.setDensyskbn(C_DensysKbn.HKSIHARAI);
        JT_SiDenpyoData.setSyono("11807111118");
        JT_SiDenpyoData.setDenymd(BizDate.valueOf("20160222"));
        JT_SiDenpyoData.setSyoriYmd(BizDate.valueOf("20160218"));
        JT_SiDenpyoData.setSyoricd("0001");
        JT_SiDenpyoData.setSyorisosikicd("0002");
        JT_SiDenpyoData.setTuukasyu(C_Tuukasyu.JPY);
        JT_SiDenpyoData.setDengyoumucd("9943");
        siDenpyoDataLst.add(JT_SiDenpyoData);

        siEditFbInBean.setSiDenpyoDataLst(siDenpyoDataLst);
        SiEditFbOutBean siEditFbOutBean = siEditFb.exec(siEditFbInBean);
        assertNull(siEditFbOutBean.getSiFBSoukinDataLst());
        assertNull(siEditFbOutBean.getSiGaikaFBSoukinDataLst());
    }
}
