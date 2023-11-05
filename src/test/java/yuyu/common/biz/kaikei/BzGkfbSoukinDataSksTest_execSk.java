package yuyu.common.biz.kaikei;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ送金データ作成クラスのメソッド {@link BzGkfbSoukinDataSks#execSk(BzGkfbSoukinDataSksBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkfbSoukinDataSksTest_execSk extends AbstractTest {

    @Inject
    private BzGkfbSoukinDataSks bzGkfbSoukinDataSks;

    @Test
    @TestOrder(10)
    public void testExecSk_A1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345678901234567890");
        bean.setEdaNo(99);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RA43");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160120"));
        bean.setDenYmd(BizDate.valueOf("20160121"));
        bean.setSyono("11807111129");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("2876");
        bean.setBankNmEj("YokohamaBankYokohamaBankYokohamaBankYokohamaBankYokohamaBank");
        bean.setSitenCd("003");
        bean.setSitenNmEj("tokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyo");
        bean.setKouzaNo("121234567890");
        bean.setKzMeigiNmEi("meigininmeigininmeigininkarika");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(151234567890123L));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(151234567890124L));
        bean.setSoukinKwsRate(BizNumber.valueOf(190.1234));
        bean.setKinouId("kinouIDABCDtestkinouIDABCDtestkinouIDABCDtestfull1");
        bean.setUserId("user100fullfull");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345678901234567890", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 99, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_SK, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RA43", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160120"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160121"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111129", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "2876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "YokohamaBankYokohamaBankYokohamaBankYokohamaBankYokohamaBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "003", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "tokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyo",
            "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "121234567890", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meigininmeigininmeigininkarika", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(151234567890123L), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(),
            BizCurrency.valueOf(151234567890124L), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(190.1234), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "kinouIDABCDtestkinouIDABCDtestkinouIDABCDtestfull1", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user100fullfull", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecSk_B1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RB30");
        bean.setSyoriSosikiCd("0010");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.EUR);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.AUD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RB30", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0010", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.EUR, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    public void testExecSk_B2() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RB10");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.AUD);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.EUR);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RB10", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.AUD, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.EUR, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExecSk_B3() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RB31");
        bean.setSyoriSosikiCd("5640000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RB31", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "5640000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(50)
    public void testExecSk_B4() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RC06");
        bean.setSyoriSosikiCd("5870000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RC06", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "5870000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    public void testExecSk_B5() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RC05");
        bean.setSyoriSosikiCd("5870000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RC05", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "5870000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    public void testExecSk_B6() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RD20");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RD20", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    public void testExecSk_B7() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RD30");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RD30", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    public void testExecSk_B8() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RDB1");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_2EIGO, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RDB1", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    public void testExecSk_B9() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RDB1");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_3EIGO, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RDB1", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    public void testExecSk_B10() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RDA0");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNotNull(skGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skGkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_3EIGO, "外貨業務コード");
        exClassificationEquals(skGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skGkFBSoukinData.getSyoricd(), "RDA0", "処理コード");
        exStringEquals(skGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(skGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(skGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(skGkFBSoukinData.getBanknmej(), "TokyoBank",
            "銀行名（英字）");
        exStringEquals(skGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(skGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(skGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(skGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(skGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(skGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(skGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(120)
    public void testExecSk_C1() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RA43");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);

    }

    @Test
    @TestOrder(130)
    public void testExecSk_C2() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RDA0");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);
    }

    @Test
    @TestOrder(140)
    public void testExecSk_C3() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RA43");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);
    }

    @Test
    @TestOrder(150)
    public void testExecSk_C4() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("RA43");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.BLNK);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);
    }

    @Test
    @TestOrder(160)
    public void testExecSk_C5() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("0001");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);
    }

    @Test
    @TestOrder(170)
    public void testExecSk_C6() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.SKEI);
        bean.setSyoriCd("0001");
        bean.setSyoriSosikiCd("0000");
        bean.setSyoriYmd(BizDate.valueOf("20160112"));
        bean.setDenYmd(BizDate.valueOf("20160111"));
        bean.setSyono("11807111211");
        bean.setShrHouSiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        bean.setBankCd("9876");
        bean.setBankNmEj("TokyoBank");
        bean.setSitenCd("002");
        bean.setSitenNmEj("yokohama");
        bean.setKouzaNo("1234567");
        bean.setKzMeigiNmEi("meiginin");
        bean.setShrTuukaSyu(C_Tuukasyu.JPY);
        bean.setGaikaShrgk(BizCurrency.valueOf(4567));
        bean.setKykTuukaSyu(C_Tuukasyu.USD);
        bean.setCrossRateShrgk(BizCurrency.valueOf(4568));
        bean.setSoukinKwsRate(BizNumber.valueOf(50));
        bean.setKinouId("ABCD");
        bean.setUserId("user1");

        HT_SkGaikaFBSoukinData skGkFBSoukinData = bzGkfbSoukinDataSks.execSk(bean);

        assertNull(skGkFBSoukinData);
    }
}
