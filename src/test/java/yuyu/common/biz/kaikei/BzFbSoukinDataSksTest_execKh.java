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
import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＦＢ送金データ作成クラスのメソッド {@link BzFbSoukinDataSks#execKh(BzFbSoukinDataSksBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzFbSoukinDataSksTest_execKh extends AbstractTest {

    @Inject
    private BzFbSoukinDataSks bzFbSoukinDataSks;

    @Test
    @TestOrder(10)
    public void testExecKh_A1() {

        changeSystemDate(BizDate.valueOf("20160311"));

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.HOZEN);
        bzFbSoukinDataSksBean.setSyoriCd("RA43");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("11807111118");
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

        IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

        assertNotNull(khFBSoukinData.getFbsoukindatasikibetukey());
        exStringEquals(khFBSoukinData.getDenrenno(), "12345", "伝票データ連番");
        exNumericEquals(khFBSoukinData.getEdano(), 1, "枝番号");
        exClassificationEquals(khFBSoukinData.getDensyskbn(), C_DensysKbn.HOZEN, "伝票用システム区分");
        exClassificationEquals(khFBSoukinData.getGyoumucd(), C_Gyoumucd.GK_YENSOUKIN_SK, "業務コード");
        exClassificationEquals(khFBSoukinData.getTantositucd(), C_Tantositucd.BLNK0, "担当室コード");
        exStringEquals(khFBSoukinData.getSyoricd(), "RA43", "処理コード");
        exStringEquals(khFBSoukinData.getSyorisosikicd(), "0000", "処理組織コード");
        exDateEquals(khFBSoukinData.getSyoriYmd(), BizDate.valueOf("20160112"), "処理年月日");
        exDateEquals(khFBSoukinData.getDenymd(), BizDate.valueOf("20160111"), "伝票日付");
        exStringEquals(khFBSoukinData.getSyono(), "11807111118", "証券番号");
        exClassificationEquals(khFBSoukinData.getShrhousiteikbn(), C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exStringEquals(khFBSoukinData.getBankcd(), "1001", "銀行コード");
        exStringEquals(khFBSoukinData.getSitencd(), "001", "支店コード");
        exClassificationEquals(khFBSoukinData.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(khFBSoukinData.getKouzano(), "1234567890", "口座番号");
        exStringEquals(khFBSoukinData.getKzmeiginmkn(), "メイギニン", "口座名義人氏名（カナ）");
        exBizCalcbleEquals(khFBSoukinData.getSoukingk(), BizCurrency.valueOf(1234567), "送金金額");
        exClassificationEquals(khFBSoukinData.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(khFBSoukinData.getGaikataikagk(), BizCurrency.valueOf(4567), "外貨対価額");
        exBizCalcbleEquals(khFBSoukinData.getSoukinkwsrate(), BizNumber.valueOf(50), "送金用為替レート");
        exStringEquals(khFBSoukinData.getGyoumuKousinKinou(), "ABCD", "業務用更新機能ＩＤ");
        exStringEquals(khFBSoukinData.getGyoumuKousinsyaId(), "user1", "業務用更新者ＩＤ");
        exStringEquals(khFBSoukinData.getGyoumuKousinTime().toString().substring(0, 8), BizDate.valueOf("20160311").toString(), "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExecKh_B1() {

        BzFbSoukinDataSksBean bzFbSoukinDataSksBean = SWAKInjector.getInstance(BzFbSoukinDataSksBean.class);
        bzFbSoukinDataSksBean.setDenbyouyouDataRenbon("12345");
        bzFbSoukinDataSksBean.setEdaNo(1);
        bzFbSoukinDataSksBean.setDenSysKbn(C_DensysKbn.SKEI);
        bzFbSoukinDataSksBean.setSyoriCd("0001");
        bzFbSoukinDataSksBean.setSyoriSosikiCd("0000");
        bzFbSoukinDataSksBean.setSyoriYmd(BizDate.valueOf("20160112"));
        bzFbSoukinDataSksBean.setDenYmd(BizDate.valueOf("20160111"));
        bzFbSoukinDataSksBean.setSyoNo("11807111118");
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

        IT_KhFBSoukinData khFBSoukinData = bzFbSoukinDataSks.execKh(bzFbSoukinDataSksBean);

        assertNull(khFBSoukinData);

        MockObjectManager.initialize();
    }
}
