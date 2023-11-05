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
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ送金データ作成クラスのメソッド {@link BzGkfbSoukinDataSks#execSi(BzGkfbSoukinDataSksBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkfbSoukinDataSksTest_execSi extends AbstractTest {

    @Inject
    private BzGkfbSoukinDataSks bzGkfbSoukinDataSks;

    @Test
    @TestOrder(10)
    public void testExecSi_A1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.HKSIHARAI);
        bean.setSyoriCd("RB30");
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

        JT_SiGaikaFBSoukinData siGkFBSoukinData = bzGkfbSoukinDataSks.execSi(bean);

        assertNotNull(siGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(siGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(siGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(siGkFBSoukinData.getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exClassificationEquals(siGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKSOUKIN_KH_SI, "外貨業務コード");
        exClassificationEquals(siGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(siGkFBSoukinData.getSyoricd(), "RB30", "処理コード");
        exStringEquals(siGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(siGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(siGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(siGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(siGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_2EIGYOUBI, "支払方法指定区分");
        exStringEquals(siGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(siGkFBSoukinData.getBanknmej(), "TokyoBank", "銀行名（英字）");
        exStringEquals(siGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(siGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(siGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(siGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(siGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(siGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(siGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(siGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(siGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(siGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(siGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(siGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(siGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecSi_B1() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.HKSIHARAI);
        bean.setSyoriCd("0001");
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

        JT_SiGaikaFBSoukinData siGkFBSoukinData = bzGkfbSoukinDataSks.execSi(bean);

        assertNull(siGkFBSoukinData);
    }
}