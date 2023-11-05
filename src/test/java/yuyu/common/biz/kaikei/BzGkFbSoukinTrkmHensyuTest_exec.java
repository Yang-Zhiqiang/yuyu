package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Gkgyoumucd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ送金データ取込編集クラスのメソッド {@link BzGkFbSoukinTrkmHensyu#exec(GkFBSoukinDataParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkFbSoukinTrkmHensyuTest_exec {

    @Inject
    private BzGkFbSoukinTrkmHensyu bzGkFbSoukinTrkmHensyu;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        GkFBSoukinDataParam gkFBSoukinDataParam = new GkFBSoukinDataParamImpl();
        gkFBSoukinDataParam.setFbsoukindatasikibetukey("fb345678901234567890");
        gkFBSoukinDataParam.setDenrenno("12345678901234567890");
        gkFBSoukinDataParam.setEdano(99);
        gkFBSoukinDataParam.setDensyskbn(C_DensysKbn.SKEI);
        gkFBSoukinDataParam.setGkgyoumucd(C_Gkgyoumucd.SKFUSEIRITUPHENKIN);
        gkFBSoukinDataParam.setSyoricd("0001");
        gkFBSoukinDataParam.setSyorisosikicd("0000");
        gkFBSoukinDataParam.setSyoriYmd(BizDate.valueOf("20160120"));
        gkFBSoukinDataParam.setDenymd(BizDate.valueOf("20160121"));
        gkFBSoukinDataParam.setSyono("11807111129");
        gkFBSoukinDataParam.setShrhousiteikbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        gkFBSoukinDataParam.setBankcd("2876");
        gkFBSoukinDataParam.setBanknmej("YokohamaBankYokohamaBankYokohamaBankYokohamaBankYokohamaBank");
        gkFBSoukinDataParam.setSitencd("003");
        gkFBSoukinDataParam.setSitennmej("tokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyo");
        gkFBSoukinDataParam.setKouzano("121234567890");
        gkFBSoukinDataParam.setKzmeiginmei("kz34567890123456789012345678901234567890123456"
            + "789012345678901234567890123456789012345678901234567890123456789012345678"
            + "9012345678901234567890");
        gkFBSoukinDataParam.setShrtuukasyu(C_Tuukasyu.JPY);
        gkFBSoukinDataParam.setGaikashrgk(BizCurrency.valueOf(151234567890123L));
        gkFBSoukinDataParam.setKyktuukasyu(C_Tuukasyu.USD);
        gkFBSoukinDataParam.setCrossrateshrgk(BizCurrency.valueOf(151234567890124L));
        gkFBSoukinDataParam.setSoukinkwsrate(BizNumber.valueOf(190.1234));
        gkFBSoukinDataParam.setIrninnmei("ir345678901234567890123456789012345678901"
            + "234567890123456789012345678901234567890123456789012345678901234567890123"
            + "456789012345678901234567890");

        BT_GkFBSoukinData gkFBSoukinData = bzGkFbSoukinTrkmHensyu.exec(gkFBSoukinDataParam);

        exStringEquals(gkFBSoukinData.getFbsoukindatasikibetukey(), "fb345678901234567890", "ＦＢ送金データ識別キー");
        exStringEquals(gkFBSoukinData.getDenrenno(), "12345678901234567890", "伝票データ連番");
        exNumericEquals(gkFBSoukinData.getEdano(), 99, "枝番号");
        exClassificationEquals(gkFBSoukinData.getDensyskbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exClassificationEquals(gkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.SKFUSEIRITUPHENKIN, "外貨業務コード");
        exStringEquals(gkFBSoukinData.getSyoricd(), "0001", "処理コード");
        exStringEquals(gkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(gkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160120"), "処理年月日");
        exDateEquals(gkFBSoukinData.getDenymd(), BizDate.valueOf("20160121"), "伝票日付");
        exStringEquals(gkFBSoukinData.getKeirisyono(), "11807111129", "証券番号");
        exClassificationEquals(gkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(gkFBSoukinData.getBankcd(), "2876", "銀行コード");
        exStringEquals(gkFBSoukinData.getBanknmej(),
            "YokohamaBankYokohamaBankYokohamaBankYokohamaBankYokohamaBank", "銀行名（英字）");
        exStringEquals(gkFBSoukinData.getSitencd(), "003", "支店コード");
        exStringEquals(gkFBSoukinData.getSitennmej(),
            "tokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyotokyo", "支店名（英字）");
        exStringEquals(gkFBSoukinData.getKouzano(), "121234567890", "口座番号");
        exStringEquals(gkFBSoukinData.getKzmeiginmei(), "kz34567890123456789012345678901234567890123456789012"
            + "34567890123456789012345678901234567890123456789012345678901234567890123456"
            + "78901234567890", "口座名義人名（英字）");
        exClassificationEquals(gkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(gkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(151234567890123L), "外貨支払額");
        exClassificationEquals(gkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(gkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(151234567890124L), "クロスレート支払額");
        exBizCalcbleEquals(gkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(190.1234), "送金用為替レート");
        exStringEquals(gkFBSoukinData.getIrninnmei(), "ir3456789012345678901234567890123456789012"
            + "34567890123456789012345678901234567890123456789012345678901234567890123456"
            + "789012345678901234567890", "依頼人名（英字）");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        GkFBSoukinDataParam gkFBSoukinDataParam = new GkFBSoukinDataParamImpl();

        BT_GkFBSoukinData gkFBSoukinData = bzGkFbSoukinTrkmHensyu.exec(gkFBSoukinDataParam);

        exStringEquals(gkFBSoukinData.getFbsoukindatasikibetukey(), null, "ＦＢ送金データ識別キー");
        exStringEquals(gkFBSoukinData.getDenrenno(), "", "伝票データ連番");
        exNumericEquals(gkFBSoukinData.getEdano(), 0, "枝番号");
        exClassificationEquals(gkFBSoukinData.getDensyskbn(), C_DensysKbn.BLNK, "伝票用システム区分");
        exClassificationEquals(gkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.BLNK, "外貨業務コード");
        exStringEquals(gkFBSoukinData.getSyoricd(), "", "処理コード");
        exStringEquals(gkFBSoukinData.getSyorisosikicd(), "", "処理組織コード");
        exDateEquals(gkFBSoukinData.getSyoriYmd(), null, "処理年月日");
        exDateEquals(gkFBSoukinData.getDenymd(), null, "伝票日付");
        exStringEquals(gkFBSoukinData.getKeirisyono(), "", "証券番号");
        exClassificationEquals(gkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.BLNK, "支払方法指定区分");
        exStringEquals(gkFBSoukinData.getBankcd(), "", "銀行コード");
        exStringEquals(gkFBSoukinData.getBanknmej(), "", "銀行名（英字）");
        exStringEquals(gkFBSoukinData.getSitencd(), "", "支店コード");
        exStringEquals(gkFBSoukinData.getSitennmej(), "", "支店名（英字）");
        exStringEquals(gkFBSoukinData.getKouzano(), "", "口座番号");
        exStringEquals(gkFBSoukinData.getKzmeiginmei(), "", "口座名義人名（英字）");
        exClassificationEquals(gkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.BLNK, "支払通貨種類");
        exBizCalcbleEquals(gkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(0), "外貨支払額");
        exClassificationEquals(gkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(gkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(0), "クロスレート支払額");
        exBizCalcbleEquals(gkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(0), "送金用為替レート");
        exStringEquals(gkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
    }
}
