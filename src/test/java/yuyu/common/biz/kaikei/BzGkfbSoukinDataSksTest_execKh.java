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
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 外貨ＦＢ送金データ作成クラスのメソッド {@link BzGkfbSoukinDataSks#execKh(BzGkfbSoukinDataSksBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzGkfbSoukinDataSksTest_execKh extends AbstractTest {

    @Inject
    private BzGkfbSoukinDataSks bzGkfbSoukinDataSks;

    @Test
    @TestOrder(10)
    public void testExecKh_A1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.HOZEN);
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

        IT_KhGaikaFBSoukinData khGkFBSoukinData = bzGkfbSoukinDataSks.execKh(bean);

        assertNotNull(khGkFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(khGkFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(khGkFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(khGkFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exClassificationEquals(khGkFBSoukinData.getGkgyoumucd(), C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_3EIGO, "外貨業務コード");
        exClassificationEquals(khGkFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(khGkFBSoukinData.getSyoricd(), "RDA0", "処理コード");
        exStringEquals(khGkFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(khGkFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(khGkFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(khGkFBSoukinData.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(khGkFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_3EIGYOUBI, "支払方法指定区分");
        exStringEquals(khGkFBSoukinData.getBankcd(), "9876", "銀行コード");
        exStringEquals(khGkFBSoukinData.getBanknmej(), "TokyoBank", "銀行名（英字）");
        exStringEquals(khGkFBSoukinData.getSitencd(), "002", "支店コード");
        exStringEquals(khGkFBSoukinData.getSitennmej(), "yokohama", "支店名（英字）");
        exStringEquals(khGkFBSoukinData.getKouzano(), "1234567", "口座番号");
        exStringEquals(khGkFBSoukinData.getKzmeiginmei(), "meiginin", "口座名義人名（英字）");
        exClassificationEquals(khGkFBSoukinData.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exBizCalcbleEquals(khGkFBSoukinData.getGaikashrgk(), BizCurrency.valueOf(4567), "外貨支払額");
        exClassificationEquals(khGkFBSoukinData.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(khGkFBSoukinData.getCrossrateshrgk(), BizCurrency.valueOf(4568), "クロスレート支払額");
        exBizCalcbleEquals(khGkFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(khGkFBSoukinData.getIrninnmei(), "", "依頼人名（英字）");
        exStringEquals(khGkFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(khGkFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(khGkFBSoukinData.getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecKh_B1() {
        BzGkfbSoukinDataSksBean bean = SWAKInjector
            .getInstance(BzGkfbSoukinDataSksBean.class);
        bean.setDenRenno("12345");
        bean.setEdaNo(1);
        bean.setDenSysKbn(C_DensysKbn.HOZEN);
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

        IT_KhGaikaFBSoukinData khGkFBSoukinData = bzGkfbSoukinDataSks.execKh(bean);

        assertNull(khGkFBSoukinData);
    }
}