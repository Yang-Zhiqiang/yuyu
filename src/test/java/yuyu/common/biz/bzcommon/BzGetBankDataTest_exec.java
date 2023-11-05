package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BankYuuksHantKbn;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_EnkashrKahiKbn;
import yuyu.def.classification.C_GaikashrKahiKbn;
import yuyu.def.classification.C_HrkmKanouihyj;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kokunaikwskameihyj;
import yuyu.def.classification.C_KyouteiSyouinKbn;
import yuyu.def.classification.C_TapekoukanKbn;
import yuyu.def.classification.C_TrhkginkousitenKbn;
import yuyu.def.classification.C_TsrkeisanhouKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 銀行情報取得クラスのメソッド {@link BzGetBankData#exec(String, String, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetBankDataTest_exec {

    @Inject
    private BzGetBankData bzGetBankData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_銀行情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzGetBankDataTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGinkou());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        String bankcd = "";
        String sitencd = "450";
        BizDate kijyunYmd = BizDate.valueOf("20160113");

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.NONE, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), null, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), null, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), null, "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), null, "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), null, "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), null, "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), null, "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), null, "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), null, "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), null, "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), null, "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), null, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), null, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), null, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), null, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), null, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), null, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), null, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        String bankcd = "9900";
        String sitencd = "";
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.NONE, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), null, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), null, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), null, "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), null, "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), null, "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), null, "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), null, "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), null, "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), null, "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), null, "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), null, "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), null, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), null, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), null, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), null, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), null, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), null, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), null, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        String bankcd = null;
        String sitencd = "450";
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.NONE, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), null, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), null, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), null, "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), null, "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), null, "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), null, "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), null, "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), null, "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), null, "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), null, "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), null, "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), null, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), null, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), null, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), null, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), null, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), null, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), null, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        String bankcd = "9900";
        String sitencd = null;
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.NONE, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), null, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), null, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), null, "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), null, "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), null, "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), null, "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), null, "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), null, "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), null, "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), null, "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), null, "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), null, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), null, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), null, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), null, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), null, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), null, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), null, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        String bankcd = "9900";
        String sitencd = "450";
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exStringEquals(bzGetBankDataBean.getBankCd(), "9900", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "458", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20160114), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "ユウチギンコウ", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "シテンメイイチ", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "ゆうちょ銀行", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "１４５００", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "YUUTYOGINKOU", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "SITEN1", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        String bankcd = "1500";
        String sitencd = "101";
        BizDate kijyunYmd = BizDate.valueOf(20170111);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exStringEquals(bzGetBankDataBean.getBankCd(), "1500", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "101", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "ギンコウメイサン", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "シテンメイサン", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名３", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名３", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennm3", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20160105), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20160106), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        String bankcd = "1500";
        String sitencd = "100";
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.NONE, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), null, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), null, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), null, "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), null, "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), null, "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), null, "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), null, "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), null, "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), null, "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), null, "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), null, "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        String bankcd = "1500";
        String sitencd = "101";
        BizDate kijyunYmd = null;

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.HANTEIHUKA, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        String bankcd = "9900";
        String sitencd = "100";
        BizDate kijyunYmd = BizDate.valueOf(20160113);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        String bankcd = "9900";
        String sitencd = "100";
        BizDate kijyunYmd = BizDate.valueOf(20160114);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.OK, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        String bankcd = "9900";
        String sitencd = "100";
        BizDate kijyunYmd = BizDate.valueOf(20160115);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.OK, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20161231);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.OK, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20161230);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.OK, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20161229);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20170102);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {

        String bankcd = "9900";
        String sitencd = "132";
        BizDate kijyunYmd = BizDate.valueOf(20150201);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "通帳記号　１１３２０", "帳票用支店名");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20161230);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.HUKA, "円貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "通帳記号　１１１１０", "帳票用支店名");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {

        String bankcd = "1500";
        String sitencd = "101";
        BizDate kijyunYmd = BizDate.valueOf(20170111);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "支店名３", "帳票用支店名");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {

        String bankcd = "9900";
        String sitencd = "100";
        BizDate kijyunYmd = BizDate.valueOf(20160114);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.KA, "外貨支払可否区分");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {

        String bankcd = "1500";
        String sitencd = "101";
        BizDate kijyunYmd = BizDate.valueOf(20170111);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.HUKA, "外貨支払可否区分");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {

        String bankcd = "9900";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20161230);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.HUKA, "外貨支払可否区分");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {

        String bankcd = "1500";
        String sitencd = "101";

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd);

        exStringEquals(bzGetBankDataBean.getBankCd(), "1500", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "101", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "ギンコウメイサン", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "シテンメイサン", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名３", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名３", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennm3", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20160105), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20160106), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {

        String bankcd = "1111";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20170231);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.OK, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.KA, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "支店名８", "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), "1111", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "111", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(00000000), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(00000000), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(99999999), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名８", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名８", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名８", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名８", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "ｷﾞﾝｺｳﾒｲ8", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "ｼﾃﾝﾒｲ8", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(99999999), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(99999999), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.MIKAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {

        String bankcd = "9999";
        String sitencd = "001";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.KA, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "ＸＸＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9999", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "001", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20150131), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20160131), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "ＸＸＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＥ", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "ＸＸＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸ２ＸＸＸＸＥ", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "ＸＸＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "ＸＸＸＸＸＸＸＸＸ１ＸＸＸＸＸＸＸＸＸＥ", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "xxxxxxxxx1xxxxxxxxx2xxxxxxxxx3xxxxxxxxx4xxxxxxxxx5xxxxxxxxxE", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "xxxxxxxxx1xxxxxxxxx2xxxxxxxxx3xxxxxxxxx4xxxxxxxxx5xxxxxxxxxE", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20160105), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20160106), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {

        String bankcd = "9998";
        String sitencd = "002";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.HUKA, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "", "帳票用支店名");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9998", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "002", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), null, "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), null, "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), null, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), null, "振込可能支店表示");
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {

        String bankcd = "9700";
        String sitencd = "113";
        BizDate kijyunYmd = BizDate.valueOf(20161231);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exClassificationEquals(bzGetBankDataBean.getBankYuuksHantKbn(), C_BankYuuksHantKbn.NG, "銀行有効性判定区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9700", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "113", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exClassificationEquals(bzGetBankDataBean.getEnkashrKahiKbn(), C_EnkashrKahiKbn.KA, "円貨支払可否区分");
        exClassificationEquals(bzGetBankDataBean.getGaikashrKahiKbn(), C_GaikashrKahiKbn.HUKA, "外貨支払可否区分");
        exStringEquals(bzGetBankDataBean.getReportSitenNm(), "支店名（漢字）", "帳票用支店名");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), null, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), null, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), null, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), null, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), null, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), null, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), null, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), null, "委託者支店コード");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), null, "委託者金融機関コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), null, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), null, "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), null, "手数料計算方法区分");
        exBooleanEquals(bzGetBankDataBean.getKinyuutesuuryou() == null,true,"金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), null, "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), null, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), null, "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), null, "普保預振情報更新年月日");
    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_A28() {

        String bankcd = "9600";
        String sitencd = "114";
        BizDate kijyunYmd = BizDate.valueOf(20161231);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9600", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "114", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), null, "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), null, "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20181010), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), null, "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), null, "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), null, "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), null, "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.GINKOU, "取引銀行支店区分");
    }

    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_A29() {

        String bankcd = "9900";
        String sitencd = "112";
        BizDate kijyunYmd = BizDate.valueOf(19891004);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), BizDate.valueOf(19891004), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "ＣＳＳ協定消因区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "全税共協定消因区分");
    }

    @Test
    @TestOrder(300)
    @Transactional
    public void testExec_A30() {

        String bankcd = "9900";
        String sitencd = "112";
        BizDate kijyunYmd = BizDate.valueOf(19891005);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), BizDate.valueOf(19891004), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "ＣＳＳ協定消因区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "全税共協定消因区分");
    }

    @Test
    @TestOrder(310)
    @Transactional
    public void testExec_A31() {

        String bankcd = "9900";
        String sitencd = "112";
        BizDate kijyunYmd = BizDate.valueOf(19891003);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(), BizDate.valueOf(19891004), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "ＣＳＳ協定消因区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.MIKYOUTEI, "全税共協定消因区分");
    }

    @Test
    @TestOrder(320)
    @Transactional
    public void testExec_A32() {

        String bankcd = "9500";
        String sitencd = "102";
        BizDate kijyunYmd = BizDate.valueOf(20161229);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9500", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "102", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20161231), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20161231), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20161231), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20161231), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20161231), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20161231), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20161231), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20161231), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.KA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20161231), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.KA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(330)
    @Transactional
    public void testExec_A33() {

        String bankcd = "9400";
        String sitencd = "103";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9400", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "103", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170101), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20170101), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170101), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20170101), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170101), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(340)
    @Transactional
    public void testExec_A34() {

        String bankcd = "9300";
        String sitencd = "104";
        BizDate kijyunYmd = BizDate.valueOf(20170102);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9300", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "104", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170102), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20170102), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170102), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20170102), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170101), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(350)
    @Transactional
    public void testExec_A35() {

        String bankcd = "9200";
        String sitencd = "105";
        BizDate kijyunYmd = BizDate.valueOf(20180911);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9200", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "105", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20161231), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20161231), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20180910), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20161231), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20170101), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20180910), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(360)
    @Transactional
    public void testExec_A36() {

        String bankcd = "9100";
        String sitencd = "106";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9100", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "106", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170101), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20180910), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170101), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20170101), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20180910), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(370)
    @Transactional
    public void testExec_A37() {

        String bankcd = "9000";
        String sitencd = "107";
        BizDate kijyunYmd = BizDate.valueOf(20170102);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "9000", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "107", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170102), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), BizDate.valueOf(20180910), "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170102), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), BizDate.valueOf(20170101), "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20180910), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20161230), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(380)
    @Transactional
    public void testExec_A38() {

        String bankcd = "8900";
        String sitencd = "108";
        BizDate kijyunYmd = BizDate.valueOf(20180911);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "8900", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "108", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20161231), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20161231), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20161231), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170101), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(390)
    @Transactional
    public void testExec_A39() {

        String bankcd = "8800";
        String sitencd = "109";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "8800", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "109", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170101), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170101), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170101), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testExec_A40() {

        String bankcd = "8700";
        String sitencd = "110";
        BizDate kijyunYmd = BizDate.valueOf(20170102);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "8700", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "110", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), BizDate.valueOf(20170101), "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170102), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170102), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170101), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KAIJYO, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170101), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(410)
    @Transactional
    public void testExec_A41() {

        String bankcd = "8600";
        String sitencd = "111";
        BizDate kijyunYmd = BizDate.valueOf(20170101);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "8600", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "111", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170102), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170102), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170102), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.HUKA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.HUKA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170102), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.HUKA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }

    @Test
    @TestOrder(420)
    @Transactional
    public void testExec_A42() {

        String bankcd = "8500";
        String sitencd = "112";
        BizDate kijyunYmd = BizDate.valueOf(20170103);

        BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(bankcd, sitencd, kijyunYmd);

        exClassificationEquals(bzGetBankDataBean.getBankmasterUmuKbn(), C_BankmasterUmuKbn.ARI, "銀行マスタ有無区分");
        exStringEquals(bzGetBankDataBean.getBankCd(), "8500", "銀行コード");
        exStringEquals(bzGetBankDataBean.getSitenCd(), "112", "支店コード");
        exDateEquals(bzGetBankDataBean.getKousinYmd(), BizDate.valueOf(20160102), "更新年月日");
        exDateEquals(bzGetBankDataBean.getSinsetuYmd(), BizDate.valueOf(20170101), "新設年月日");
        exDateEquals(bzGetBankDataBean.getHaisiYmd(), null, "廃止年月日");
        exStringEquals(bzGetBankDataBean.getBankNmKn(), "銀行名（カナ）", "銀行名（カナ）");
        exStringEquals(bzGetBankDataBean.getSitenNmKn(), "支店名（カナ）", "支店名（カナ）");
        exStringEquals(bzGetBankDataBean.getBankNmKj(), "銀行名（漢字）", "銀行名（漢字）");
        exStringEquals(bzGetBankDataBean.getSitenNmKj(), "支店名（漢字）", "支店名（漢字）");
        exStringEquals(bzGetBankDataBean.getBankNmEj(), "", "銀行名（英字）");
        exStringEquals(bzGetBankDataBean.getSitenNmEj(), "sitennmej", "支店名（英字）");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaisiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定開始年月日");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKaijyoYmd(), null, "ＣＳＳ協定解除年月日");
        exClassificationEquals(bzGetBankDataBean.getKokunaikwskameihyj(), C_Kokunaikwskameihyj.KAMEI, "内国為替制度加盟表示");
        exClassificationEquals(bzGetBankDataBean.getHrkmKanouihyj(), C_HrkmKanouihyj.KA, "振込可能支店表示");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaisiYmd(), BizDate.valueOf(20170102), "預振協定開始年月日");
        exDateEquals(bzGetBankDataBean.getYofurikyouteikaijyoYmd(), null, "預振協定解除年月日");
        exStringEquals(bzGetBankDataBean.getItakusyakinyuuCd(), "0001", "委託者金融機関コード");
        exStringEquals(bzGetBankDataBean.getItakusyasitenCd(), "001", "委託者支店コード");
        exClassificationEquals(bzGetBankDataBean.getItakusyayokinKbn(), C_YokinKbn.HUTUU, "委託者預金種目区分");
        exStringEquals(bzGetBankDataBean.getItakusyakouzano(), "0000001", "委託者口座番号");
        exClassificationEquals(bzGetBankDataBean.getTsrkeisanhouKbn(), C_TsrkeisanhouKbn.SEIKYUBASE, "手数料計算方法区分");
        exNumericEquals(bzGetBankDataBean.getKinyuutesuuryou(), 12, "金融機関手数料");
        exStringEquals(bzGetBankDataBean.getItakusyacd(), "11111", "委託者コード");
        exClassificationEquals(bzGetBankDataBean.getTapekoukanKbn1(), C_TapekoukanKbn.KOUKAN_1, "テープ交換区分１");
        exStringEquals(bzGetBankDataBean.getMdsisyaCd(), "123", "窓口支社コード");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaisiYmd(), BizDate.valueOf(20170102), "全税共協定開始年月日");
        exDateEquals(bzGetBankDataBean.getZzkkyouteikaijyoYmd(), null, "全税共協定解除年月日");
        exDateEquals(bzGetBankDataBean.getHuhoyofuriinfokousinYmd(), BizDate.valueOf(20181010), "普保預振情報更新年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "預振協定消因区分");
        exDateEquals(bzGetBankDataBean.getYohuriKyouteiKouryokuhasseiYmd(),  BizDate.valueOf(20170102), "預振協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getYohuriKahiKbn(), C_KahiKbn.KA, "預振可否区分");
        exClassificationEquals(bzGetBankDataBean.getCssKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "ＣＳＳ協定消因区分");
        exDateEquals(bzGetBankDataBean.getCssKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170102), "ＣＳＳ協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getCssKahiKbn(), C_KahiKbn.KA, "ＣＳＳ可否区分");
        exClassificationEquals(bzGetBankDataBean.getZzkKyouteiSyouinKbn(), C_KyouteiSyouinKbn.KYOUTEI, "全税共協定消因区分");
        exDateEquals(bzGetBankDataBean.getZzkKyouteiKouryokuhasseiYmd(), BizDate.valueOf(20170102), "全税共協定効力発生年月日");
        exClassificationEquals(bzGetBankDataBean.getZzkKahiKbn(), C_KahiKbn.KA, "全税共可否区分");
        exClassificationEquals(bzGetBankDataBean.getTrhkGinkousitenKbn(), C_TrhkginkousitenKbn.SITEN, "取引銀行支店区分");
    }
}