package yuyu.common.biz.kaikei;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tantositucd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金データ作成クラスのメソッド {@link BzFbSoukinDataSks#execSk(BzFbSoukinDataSksBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbSoukinDataSksTest_execSk extends AbstractTest {

    @Inject
    private BzFbSoukinDataSks bzFbSoukinDataSks;

    @Test
    @TestOrder(10)
    public void testExecSk_A1() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345678901234567890");
        bzFbSoukinDataSksBean.setEdaNo(12);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RA43");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("1230000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160113"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("9900");
        bzFbSoukinDataSksBean.setSitenCd("003");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.BLNK);
        bzFbSoukinDataSksBean.setKouzaNo("123456789012");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニンメイギニンメイギニンメイギニンメイギニンメイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567890));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.BLNK);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(Long.valueOf("123455432112345")));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(123.1234));
        bzFbSoukinDataSksBean.setKinouId("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX");
        bzFbSoukinDataSksBean.setUserId("teihyoureiuser1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345678901234567890", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 12, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_SK, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RA43", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "1230000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160113"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160112"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "9900", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "008", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "123456789012", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニンメイギニンメイギニンメイギニンメイギニンメイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567890), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(Long.valueOf("123455432112345")), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(123.1234), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "teihyoureiuser1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecSk_A2() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RB10");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.TOUZA);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.USD);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RB10", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.TOUZA, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(30)
    public void testExecSk_A3() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RB31");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("5640000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.TYOTIKU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.AUD);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RB31", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "5640000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.TYOTIKU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExecSk_A4() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RC06");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("5870000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RC06", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "5870000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(50)
    public void testExecSk_A5() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RC05");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("5870000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RC05", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "5870000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    public void testExecSk_A6() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RB30");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RB30", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    public void testExecSk_A7() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RD20");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RD20", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    public void testExecSk_A8() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RD30");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_KH_SI, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RD30", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    public void testExecSk_A9() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RD20");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_NK, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RD20", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    public void testExecSk_A10() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RD30");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_NK, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RD30", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    public void testExecSk_A11() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RDB1");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_NK_JIDOU, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RDB1", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(120)
    public void testExecSk_A12() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RDA0");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNotNull(skFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(skFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(skFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(skFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(skFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_NK_JIDOU, "業務コード");
        exClassificationEquals(skFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(skFBSoukinData.getSyoricd(), "RDA0", "処理コード");
        exStringEquals(skFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(skFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(skFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(skFBSoukinData.getSyono(), "791112220", "証券番号");
        exClassificationEquals(skFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(skFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(skFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(skFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(skFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(skFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(skFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(skFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(skFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(skFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(skFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(skFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    public void testExecSk_B1() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RDA0");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.BLNK);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);
    }

    @Test
    @TestOrder(140)
    public void testExecSk_B2() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RDA0");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);
    }

    @Test
    @TestOrder(150)
    public void testExecSk_B3() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RDA0");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);
    }

    @Test
    @TestOrder(160)
    public void testExecSk_B4() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("RA43");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);
    }

    @Test
    @TestOrder(170)
    public void testExecSk_B5() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("0001");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);
    }

    @Test
    @TestOrder(180)
    public void testExecSk_B6() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("0001");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("791112220");
        bzFbSoukinDataSksBean.setShrHouSiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        bzFbSoukinDataSksBean.setBankCd("1001");
        bzFbSoukinDataSksBean.setSitenCd("001");
        bzFbSoukinDataSksBean.setYokinKbn(C_YokinKbn.HUTUU);
        bzFbSoukinDataSksBean.setKouzaNo("1234567890");
        bzFbSoukinDataSksBean.setKzMeigiNmKn("メイギニン");
        bzFbSoukinDataSksBean.setSouKingk(BizCurrency.valueOf(1234567));
        bzFbSoukinDataSksBean.setKykTuukasyu(C_Tuukasyu.JPY);
        bzFbSoukinDataSksBean.setGaikaTaikagk(BizCurrency.valueOf(4567));
        bzFbSoukinDataSksBean.setSoukinKwsRate(BizNumber.valueOf(50));
        bzFbSoukinDataSksBean.setKinouId("ABCD");
        bzFbSoukinDataSksBean.setUserId("user1");

        HT_SkFBSoukinData skFBSoukinData = bzFbSoukinDataSks.execSk(bzFbSoukinDataSksBean);

        assertNull(skFBSoukinData);

        MockObjectManager.initialize();
    }
}
