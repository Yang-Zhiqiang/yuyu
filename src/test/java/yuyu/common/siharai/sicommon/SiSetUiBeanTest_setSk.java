package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataMock;
import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiInfoSateiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSiharaiInfoSkukeUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSindansyoryouShrUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSkjyouhouSindansyoUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSouhusakiSindansyoUiBeanParamImpl;
import yuyu.common.siharai.siview.ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParamImpl;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParamImpl;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SinsaGendoKknKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSk(CommonViewUiBeanParam, JT_Sk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSk {

    @Inject
    private SiSetUiBean siSetUiBean;

    @BeforeClass
    public static void testInit() {

        BzGetBankDataMock.caller = SiSetUiBeanTest_setSk.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetBankDataMock.caller = null;
        BzGetBankDataMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testSetSk_A1() {

        JT_Sk skKihon = new JT_Sk();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        siSetUiBean.setSk(commonViewUiBeanParam, skKihon);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSk_A2() {

        ViewSiharaiInfoSkukeUiBeanParamImpl viewSiharaiInfoSkukeUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSkukeUiBeanParamImpl.class);
        viewSiharaiInfoSkukeUiBeanParamImpl.setSyoruiukeymd(BizDate.valueOf(20160311));

        siSetUiBean.setSk(viewSiharaiInfoSkukeUiBeanParamImpl, null);

        exDateEquals(viewSiharaiInfoSkukeUiBeanParamImpl.getSyoruiukeymd(), BizDate.valueOf(20160311), "書類受付日");

    }

    @Test
    @TestOrder(30)
    public void testSetSk_A3() {

        ViewSiharaiInfoSkukeUiBeanParamImpl viewSiharaiInfoSkukeUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSkukeUiBeanParamImpl.class);
        viewSiharaiInfoSkukeUiBeanParamImpl.setSyoruiukeymd(BizDate.valueOf(20160311));

        JT_Sk sk = new JT_Sk();
        sk.setSyoruiukeymd(BizDate.valueOf(20160411));

        siSetUiBean.setSk(viewSiharaiInfoSkukeUiBeanParamImpl, sk);

        exDateEquals(viewSiharaiInfoSkukeUiBeanParamImpl.getSyoruiukeymd(), BizDate.valueOf(20160411), "書類受付日");

    }

    @Test
    @TestOrder(40)
    public void testSetSk_A4() {

        ViewSiharaiInfoSateiUiBeanParamImpl viewSiharaiInfoSateiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoSateiUiBeanParamImpl.class);
        viewSiharaiInfoSateiUiBeanParamImpl.setSyoruiukeymd(BizDate.valueOf(20160311));
        viewSiharaiInfoSateiUiBeanParamImpl.setHubikanryouymd(BizDate.valueOf(20160312));

        JT_Sk sk = new JT_Sk();
        sk.setSyoruiukeymd(BizDate.valueOf(20160411));
        sk.setHubikanryouymd(BizDate.valueOf(20160412));

        siSetUiBean.setSk(viewSiharaiInfoSateiUiBeanParamImpl, sk);

        exDateEquals(viewSiharaiInfoSateiUiBeanParamImpl.getSyoruiukeymd(), BizDate.valueOf(20160411), "書類受付日");
        exDateEquals(viewSiharaiInfoSateiUiBeanParamImpl.getHubikanryouymd(), BizDate.valueOf(20160412), "不備完了日");

    }

    @Test
    @TestOrder(50)
    public void testSetSk_A5() {

        ViewSkjyouhouUiBeanParamImpl viewSkjyouhouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouUiBeanParamImpl.class);

        viewSkjyouhouUiBeanParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.BLNK);
        viewSkjyouhouUiBeanParamImpl.setSihonninkakninkbn(C_SiHonninKakninKekkaKbn.KOUZA);
        viewSkjyouhouUiBeanParamImpl.setSeikyuusyaseiymd(BizDate.valueOf(20160311));
        viewSkjyouhouUiBeanParamImpl.setSeikyuusyasei(C_Seibetu.BLNK);
        viewSkjyouhouUiBeanParamImpl.setSeikyuusyanmkn("AAA");
        viewSkjyouhouUiBeanParamImpl.setSeikyuusyanmkj("BBB");

        JT_Sk sk = new JT_Sk();
        sk.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        sk.setSihonninkakninkbn(C_SiHonninKakninKekkaKbn.INKAN);
        sk.setSeikyuusyaseiymd(BizDate.valueOf(20160411));
        sk.setSeikyuusyasei(C_Seibetu.MALE);
        sk.setSeikyuusyanmkn("CCC");
        sk.setSeikyuusyanmkj("DDD");

        siSetUiBean.setSk(viewSkjyouhouUiBeanParamImpl, sk);

        exClassificationEquals(viewSkjyouhouUiBeanParamImpl.getSeikyuusyakbn(), C_SeikyuusyaKbn.UKTHONNIN, "請求者区分");
        exClassificationEquals(viewSkjyouhouUiBeanParamImpl.getSihonninkakninkbn(), C_SiHonninKakninKekkaKbn.INKAN,
            "保険金本人確認結果区分");
        exDateEquals(viewSkjyouhouUiBeanParamImpl.getSeikyuusyaseiymd(), BizDate.valueOf(20160411), "請求者生年月日");
        exClassificationEquals(viewSkjyouhouUiBeanParamImpl.getSeikyuusyasei(), C_Seibetu.MALE, "請求者性別");
        exStringEquals(viewSkjyouhouUiBeanParamImpl.getSeikyuusyanmkn(), "CCC", "請求者（カナ）");
        exStringEquals(viewSkjyouhouUiBeanParamImpl.getSeikyuusyanmkj(), "DDD", "請求者（漢字）");

    }

    @Test
    @TestOrder(60)
    public void testSetSk_A6() {

        ViewSkjyouhouSindansyoUiBeanParamImpl viewSkjyouhouSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouSindansyoUiBeanParamImpl.class);

        viewSkjyouhouSindansyoUiBeanParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.BLNK);
        viewSkjyouhouSindansyoUiBeanParamImpl.setSeikyuusyanmkn("AAA");
        viewSkjyouhouSindansyoUiBeanParamImpl.setSeikyuusyanmkj("BBB");

        JT_Sk sk = new JT_Sk();
        sk.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        sk.setSeikyuusyanmkn("CCC");
        sk.setSeikyuusyanmkj("DDD");

        siSetUiBean.setSk(viewSkjyouhouSindansyoUiBeanParamImpl, sk);

        exClassificationEquals(viewSkjyouhouSindansyoUiBeanParamImpl.getSeikyuusyakbn(), C_SeikyuusyaKbn.UKTHONNIN,
            "請求者区分");
        exStringEquals(viewSkjyouhouSindansyoUiBeanParamImpl.getSeikyuusyanmkn(), "CCC", "請求者（カナ）");
        exStringEquals(viewSkjyouhouSindansyoUiBeanParamImpl.getSeikyuusyanmkj(), "DDD", "請求者（漢字）");

    }

    @Test
    @TestOrder(70)
    public void testSetSk_A7() {

        ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.class);

        viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.setSeikyuusyakbn(C_SeikyuusyaKbn.BLNK);
        viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.setSeikyuusyanmkn("AAA");
        viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.setSeikyuusyanmkj("BBB");

        JT_Sk sk = new JT_Sk();
        sk.setSeikyuusyakbn(C_SeikyuusyaKbn.UKTHONNIN);
        sk.setSeikyuusyanmkn("CCC");
        sk.setSeikyuusyanmkj("DDD");

        siSetUiBean.setSk(viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl, sk);

        exClassificationEquals(viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.getSeikyuusyakbn(),
            C_SeikyuusyaKbn.UKTHONNIN, "請求者区分");
        exStringEquals(viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.getSeikyuusyanmkn(), "CCC", "請求者（カナ）");
        exStringEquals(viewSkjyouhouSateiSougouSyoukaiUiBeanParamImpl.getSeikyuusyanmkj(), "DDD", "請求者（漢字）");

    }

    @Test
    @TestOrder(80)
    public void testSetSk_A8() {

        ViewSoukinsakiUiBeanParamImpl viewSoukinsakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiUiBeanParamImpl.class);

        viewSoukinsakiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiUiBeanParamImpl.setBanknmkj("AAA");
        viewSoukinsakiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiUiBeanParamImpl.setSitennmkj("BBB");
        viewSoukinsakiUiBeanParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiUiBeanParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKzmeiginmkn("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd(null);
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.HUTUU);
        sk.setKouzano("2003");
        sk.setKzdoukbn(C_Kzdou.DOUITU);
        sk.setKzmeiginmkn("DDD");


        siSetUiBean.setSk(viewSoukinsakiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBankcd(), null, "銀行コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getKzdoukbn(), C_Kzdou.DOUITU, "口座名義人同一区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");


    }

    @Test
    @TestOrder(90)
    public void testSetSk_A9() {

        ViewSoukinsakiUiBeanParamImpl viewSoukinsakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiUiBeanParamImpl.class);

        viewSoukinsakiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiUiBeanParamImpl.setBanknmkj("AAA");
        viewSoukinsakiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiUiBeanParamImpl.setSitennmkj("BBB");
        viewSoukinsakiUiBeanParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiUiBeanParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKzmeiginmkn("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd(null);
        sk.setYokinkbn(C_YokinKbn.HUTUU);
        sk.setKouzano("2003");
        sk.setKzdoukbn(C_Kzdou.SITEI);
        sk.setKzmeiginmkn("DDD");

        siSetUiBean.setSk(viewSoukinsakiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitencd(), null, "支店コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKzmeiginmkn(), "DDD", "口座名義人氏名（カナ）");

    }

    @Test
    @TestOrder(100)
    public void testSetSk_A10() {

        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = "1";

        ViewSoukinsakiUiBeanParamImpl viewSoukinsakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiUiBeanParamImpl.class);

        viewSoukinsakiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiUiBeanParamImpl.setBanknmkj("AAA");
        viewSoukinsakiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiUiBeanParamImpl.setSitennmkj("BBB");
        viewSoukinsakiUiBeanParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiUiBeanParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKzmeiginmkn("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.HUTUU);
        sk.setKouzano("2003");
        sk.setKzdoukbn(C_Kzdou.SITEI);
        sk.setKzmeiginmkn("DDD");

        siSetUiBean.setSk(viewSoukinsakiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBanknmkj(), "EEE", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitennmkj(), "FFF", "支店名（漢字）");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKzmeiginmkn(), "DDD", "口座名義人氏名（カナ）");

        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 0, "2001");
        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 1, "2002");
        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 2, null);

    }

    @Test
    @TestOrder(110)
    public void testSetSk_A11() {

        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = "2";

        ViewSoukinsakiUiBeanParamImpl viewSoukinsakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiUiBeanParamImpl.class);

        viewSoukinsakiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiUiBeanParamImpl.setBanknmkj("AAA");
        viewSoukinsakiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiUiBeanParamImpl.setSitennmkj("BBB");
        viewSoukinsakiUiBeanParamImpl.setYokinkbn(C_YokinKbn.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiUiBeanParamImpl.setKzdoukbn(C_Kzdou.BLNK);
        viewSoukinsakiUiBeanParamImpl.setKzmeiginmkn("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.HUTUU);
        sk.setKouzano("2003");
        sk.setKzdoukbn(C_Kzdou.SITEI);
        sk.setKzmeiginmkn("DDD");

        siSetUiBean.setSk(viewSoukinsakiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getInputshrhousiteikbn(), C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exClassificationEquals(viewSoukinsakiUiBeanParamImpl.getKzdoukbn(), C_Kzdou.SITEI, "口座名義人同一区分");
        exStringEquals(viewSoukinsakiUiBeanParamImpl.getKzmeiginmkn(), "DDD", "口座名義人氏名（カナ）");

    }

    @Test
    @TestOrder(120)
    public void testSetSk_A12() {

        ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.class);

        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setYokinkbn(C_YokinKbn.HUTUU);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKzmeiginmkn("AAA");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBanknmkj("CCC");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitennmkj("DDD");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd(null);
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.TOUZA);
        sk.setKouzano("2003");
        sk.setKzmeiginmkn("BBB");

        siSetUiBean.setSk(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getInputshrhousiteikbn(),
            C_InputShrhousiteiKbn.FBSOUKIN,
            "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBankcd(), null, "銀行コード");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.TOUZA,
            "預金種目区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKzmeiginmkn(), "BBB", "口座名義人氏名（カナ）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");

    }

    @Test
    @TestOrder(130)
    public void testSetSk_A13() {

        ViewSindansyoryouShrUiBeanParamImpl viewSindansyoryouShrUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSindansyoryouShrUiBeanParamImpl.class);
        viewSindansyoryouShrUiBeanParamImpl.setSindansyomaisuu(10);

        JT_Sk sk = new JT_Sk();
        sk.setSindansyomaisuu(11);

        siSetUiBean.setSk(viewSindansyoryouShrUiBeanParamImpl, sk);

        exNumericEquals(viewSindansyoryouShrUiBeanParamImpl.getSindansyomaisuu(), 11, "診断書枚数");

    }

    @Test
    @TestOrder(140)
    public void testSetSk_A14() {

        ViewShrdtlSakuseiKbnUiBeanParamImpl viewShrdtlSakuseiKbnUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrdtlSakuseiKbnUiBeanParamImpl.class);
        viewShrdtlSakuseiKbnUiBeanParamImpl.setShrdtlsyooutkbn(C_KanryotuutioutKbn.BLNK);
        viewShrdtlSakuseiKbnUiBeanParamImpl.setHassoukbn(C_HassouKbn.BLNK);

        JT_Sk sk = new JT_Sk();
        sk.setShrdtlsyooutkbn(C_KanryotuutioutKbn.PDF);
        sk.setHassoukbn(C_HassouKbn.HONSYAKAISOU);

        siSetUiBean.setSk(viewShrdtlSakuseiKbnUiBeanParamImpl, sk);

        exClassificationEquals(viewShrdtlSakuseiKbnUiBeanParamImpl.getShrdtlsyooutkbn(), C_KanryotuutioutKbn.PDF,
            "支払明細書出力区分");
        exClassificationEquals(viewShrdtlSakuseiKbnUiBeanParamImpl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");

    }

    @Test
    @TestOrder(150)
    public void testSetSk_A15() {

        ViewSouhusakiUiBeanParamImpl viewSouhusakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiUiBeanParamImpl.class);
        viewSouhusakiUiBeanParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        viewSouhusakiUiBeanParamImpl.setTsinyno("1001");
        viewSouhusakiUiBeanParamImpl.setTsinadr1kj("AAA");
        viewSouhusakiUiBeanParamImpl.setTsinadr2kj("BBB");
        viewSouhusakiUiBeanParamImpl.setTsinadr3kj("CCC");
        viewSouhusakiUiBeanParamImpl.setTsintelno("1002");

        JT_Sk sk = new JT_Sk();
        sk.setSouhusakikbn(C_SouhusakiKbn.TDADDIGAI);
        sk.setTsinyno("2001");
        sk.setTsinadr1kj("DDD");
        sk.setTsinadr2kj("EEE");
        sk.setTsinadr3kj("FFF");
        sk.setTsintelno("2002");

        siSetUiBean.setSk(viewSouhusakiUiBeanParamImpl, sk);

        exClassificationEquals(viewSouhusakiUiBeanParamImpl.getSouhusakikbn(), C_SouhusakiKbn.TDADDIGAI, "送付先区分");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinyno(), "2001", "通信先郵便番号");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr1kj(), "DDD", "通信先住所１（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr2kj(), "EEE", "通信先住所２（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr3kj(), "FFF", "通信先住所３（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsintelno(), "2002", "通信先電話番号");

    }

    @Test
    @TestOrder(160)
    public void testSetSk_A16() {

        ViewSouhusakiSindansyoUiBeanParamImpl viewSouhusakiSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSindansyoUiBeanParamImpl.class);
        viewSouhusakiSindansyoUiBeanParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinyno("1001");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr1kj("AAA");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr2kj("BBB");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr3kj("CCC");

        JT_Sk sk = new JT_Sk();
        sk.setSouhusakikbn(C_SouhusakiKbn.TDADDIGAI);
        sk.setTsinyno("2001");
        sk.setTsinadr1kj("DDD");
        sk.setTsinadr2kj("EEE");
        sk.setTsinadr3kj("FFF");

        siSetUiBean.setSk(viewSouhusakiSindansyoUiBeanParamImpl, sk);

        exClassificationEquals(viewSouhusakiSindansyoUiBeanParamImpl.getSouhusakikbn(), C_SouhusakiKbn.TDADDIGAI,
            "送付先区分");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinyno(), "2001", "通信先郵便番号");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr1kj(), "DDD", "通信先住所１（漢字）");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr2kj(), "EEE", "通信先住所２（漢字）");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr3kj(), "FFF", "通信先住所３（漢字）");

    }

    @Test
    @TestOrder(170)
    public void testSetSk_A17() {

        ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.class);
        viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.setTsinyno("1001");
        viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.setTsinadr1kj("AAA");
        viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.setTsinadr2kj("BBB");
        viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.setTsinadr3kj("CCC");
        viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.setTsintelno("1002");

        JT_Sk sk = new JT_Sk();
        sk.setTsinyno("2001");
        sk.setTsinadr1kj("DDD");
        sk.setTsinadr2kj("EEE");
        sk.setTsinadr3kj("FFF");
        sk.setTsintelno("2002");

        siSetUiBean.setSk(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl, sk);

        exStringEquals(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.getTsinyno(), "2001", "通信先郵便番号");
        exStringEquals(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.getTsinadr1kj(), "DDD", "通信先住所１（漢字）");
        exStringEquals(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.getTsinadr2kj(), "EEE", "通信先住所２（漢字）");
        exStringEquals(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.getTsinadr3kj(), "FFF", "通信先住所３（漢字）");
        exStringEquals(viewSouhusakiSateiSougouSyoukaiUiBeanParamImpl.getTsintelno(), "2002", "通信先電話番号");

    }

    @Test
    @TestOrder(180)
    public void testSetSk_A18() {

        ViewSinkensyaUiBeanParamImpl viewSinkensyaUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSinkensyaUiBeanParamImpl.class);
        viewSinkensyaUiBeanParamImpl.setSkskknnmkn("AAA");
        viewSinkensyaUiBeanParamImpl.setSkskknnmkj("BBB");
        viewSinkensyaUiBeanParamImpl.setSkskknsyubetu(C_SkskknsyubetuKbn.BLNK);

        JT_Sk sk = new JT_Sk();
        sk.setSkskknnmkn("CCC");
        sk.setSkskknnmkj("DDD");
        sk.setSkskknsyubetu(C_SkskknsyubetuKbn.SINKENSYA);

        siSetUiBean.setSk(viewSinkensyaUiBeanParamImpl, sk);

        exStringEquals(viewSinkensyaUiBeanParamImpl.getSkskknnmkn(), "CCC", "親権者後見人名（カナ）");
        exStringEquals(viewSinkensyaUiBeanParamImpl.getSkskknnmkj(), "DDD", "親権者後見人名（漢字）");
        exClassificationEquals(viewSinkensyaUiBeanParamImpl.getSkskknsyubetu(), C_SkskknsyubetuKbn.SINKENSYA,
            "親権者後見人種別");

    }

    @Test
    @TestOrder(190)
    public void testSetSk_A19() {

        ViewSateikaisouyouhiSibouUiBeanParamImpl viewSateikaisouyouhiSibouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSateikaisouyouhiSibouUiBeanParamImpl.class);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakmeigihnk(false);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakmeigihnkkbn(C_YouhiKbn.HUYOU);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakkaigaisb(false);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakkaigaisbkbn(C_UmuKbn.NONE);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakhusyousi(false);
        viewSateikaisouyouhiSibouUiBeanParamImpl.setSateikakhusyousikbn(C_UmuKbn.NONE);

        JT_Sk sk = new JT_Sk();
        sk.setSateikakmeigihnkkbn(C_YouhiKbn.YOU);
        sk.setSateikakkaigaisbkbn(C_UmuKbn.ARI);
        sk.setSateikakhusyousikbn(C_UmuKbn.ARI);

        siSetUiBean.setSk(viewSateikaisouyouhiSibouUiBeanParamImpl, sk);

        exClassificationEquals(viewSateikaisouyouhiSibouUiBeanParamImpl.getSateikakmeigihnkkbn(), C_YouhiKbn.YOU,
            "査定回送要否確認（名義変更査定）区分");
        exClassificationEquals(viewSateikaisouyouhiSibouUiBeanParamImpl.getSateikakkaigaisbkbn(), C_UmuKbn.ARI,
            "査定回送要否確認（海外死亡）区分");
        exClassificationEquals(viewSateikaisouyouhiSibouUiBeanParamImpl.getSateikakhusyousikbn(), C_UmuKbn.ARI,
            "査定回送要否確認（不詳の死）区分");

    }

    @Test
    @TestOrder(200)
    public void testSetSk_A20() {

        ViewSiharaiInfoUiBeanParamImpl viewSiharaiInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiharaiInfoUiBeanParamImpl.class);

        viewSiharaiInfoUiBeanParamImpl.setShrtuukasyu(C_Tuukasyu.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setShrkwsratekjnymd(BizDate.valueOf(20160314));
        viewSiharaiInfoUiBeanParamImpl.setShrkwsrate(BizNumber.valueOf(10));
        viewSiharaiInfoUiBeanParamImpl.setDispsyoruiukeymd(BizDate.valueOf(20160315));
        viewSiharaiInfoUiBeanParamImpl.setDisphubikanryouymd(BizDate.valueOf(20160316));
        viewSiharaiInfoUiBeanParamImpl.setShrymd(BizDate.valueOf(20160317));
        viewSiharaiInfoUiBeanParamImpl.setDispsinsagendokknkbn(C_SinsaGendoKknKbn.BLNK);
        viewSiharaiInfoUiBeanParamImpl.setDisprkktydnnissuu(11);

        JT_Sk sk = new JT_Sk();
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setShrkwsratekjnymd(BizDate.valueOf(20150314));
        sk.setShrkwsrate(BizNumber.valueOf(12));
        sk.setSyoruiukeymd(BizDate.valueOf(20150315));
        sk.setHubikanryouymd(BizDate.valueOf(20150316));
        sk.setSinsagendokknkbn(C_SinsaGendoKknKbn.BD5);
        sk.setRikoukityuutuudannissuu(13);

        siSetUiBean.setSk(viewSiharaiInfoUiBeanParamImpl, sk);

        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getShrtuukasyu(), C_Tuukasyu.JPY, "支払通貨種類");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsratekjnymd(), BizDate.valueOf(20150314), "支払時為替レート基準日");
        exBizCalcbleEquals(viewSiharaiInfoUiBeanParamImpl.getShrkwsrate(), BizNumber.valueOf(12), "支払時為替レート");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDispsyoruiukeymd(), BizDate.valueOf(20150315), "（表示用）書類受付日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getDisphubikanryouymd(), BizDate.valueOf(20150316), "（表示用）不備完了日");
        exDateEquals(viewSiharaiInfoUiBeanParamImpl.getShrymd(), null, "支払日");
        exClassificationEquals(viewSiharaiInfoUiBeanParamImpl.getDispsinsagendokknkbn(), C_SinsaGendoKknKbn.BD5,
            "（表示用）審査限度期間区分");
        exNumericEquals(viewSiharaiInfoUiBeanParamImpl.getDisprkktydnnissuu(), 13, "（表示用）履行期中断日数");

    }

    @Test
    @TestOrder(210)
    public void testSetSk_A21() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(21));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(23));

        JT_Sk sk = new JT_Sk();
        sk.setShrgk(BizCurrency.valueOf(200));
        sk.setHokenkngkgoukei(BizCurrency.valueOf(55));
        sk.setTienrisokukisanymd(BizDate.valueOf(20150301));
        sk.setTienrsknissuu(66);
        sk.setShrtienrsk(BizCurrency.valueOf(77));
        sk.setYenshrgk(BizCurrency.valueOf(201));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(99));
        sk.setYenshrtienrsk(BizCurrency.valueOf(100));

        siSetUiBean.setSk(viewShrGoukeiUiBeanParamImpl, sk);

        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrgk(),  BizCurrency.valueOf(200), "支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getHokenkngkgoukei(), BizCurrency.valueOf(55), "保険金額合計");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd(), BizDate.valueOf(20150301), "保険金額合計");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getTienrsknissuu(), 66, "保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(77), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrgk(),  BizCurrency.valueOf(201), "円換算支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenhkgkgoukei(), BizCurrency.valueOf(99), "円換算保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(100), "円換算支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());

    }

    @Test
    @TestOrder(220)
    public void testSetSk_A22() {

        ViewSknaiyouUiBeanParamImpl viewSknaiyouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSknaiyouUiBeanParamImpl.class);

        viewSknaiyouUiBeanParamImpl.setSuketorihouhoukbn(C_SUketoriHouhouKbn.BLNK);

        JT_Sk sk = new JT_Sk();
        sk.setSuketorihouhoukbn(C_SUketoriHouhouKbn.ITIBU_NENKIN);

        siSetUiBean.setSk(viewSknaiyouUiBeanParamImpl, sk);

        exClassificationEquals(viewSknaiyouUiBeanParamImpl.getSuketorihouhoukbn(), C_SUketoriHouhouKbn.ITIBU_NENKIN,
            "保険金受取方法区分");

    }

    @Test
    @TestOrder(230)
    public void testSetSk_A23() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);

        viewSkKihonUiBeanParamImpl.setSyono("1001");

        JT_Sk sk = new JT_Sk();
        sk.setSyono("1002");

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1001", "証券番号");

    }

    @Test
    @TestOrder(240)
    public void testSetSk_A24() {

        ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.class);

        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setYokinkbn(C_YokinKbn.HUTUU);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKzmeiginmkn("AAA");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBanknmkj("CCC");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitennmkj("DDD");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd(null);
        sk.setYokinkbn(C_YokinKbn.TOUZA);
        sk.setKouzano("2003");
        sk.setKzmeiginmkn("BBB");

        siSetUiBean.setSk(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getInputshrhousiteikbn(),
            C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitencd(), null, "支店コード");
        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.TOUZA,
            "預金種目区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKzmeiginmkn(), "BBB", "口座名義人氏名（カナ）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");

    }

    @Test
    @TestOrder(250)
    public void testSetSk_A25() {

        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = "1";

        ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.class);

        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setYokinkbn(C_YokinKbn.HUTUU);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKzmeiginmkn("AAA");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBanknmkj("CCC");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitennmkj("DDD");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.TOUZA);
        sk.setKouzano("2003");
        sk.setKzmeiginmkn("BBB");

        siSetUiBean.setSk(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getInputshrhousiteikbn(),
            C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.TOUZA,
            "預金種目区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKzmeiginmkn(), "BBB", "口座名義人氏名（カナ）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBanknmkj(), "EEE", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitennmkj(), "FFF", "支店名（漢字）");

        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 0, "2001");
        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 1, "2002");
        MockObjectManager.assertArgumentPassed(BzGetBankData.class, "exec", 2, null);

    }

    @Test
    @TestOrder(260)
    public void testSetSk_A26() {

        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = "2";

        ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.class);

        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setInputshrhousiteikbn(C_InputShrhousiteiKbn.BLNK);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBankcd("1001");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitencd("1002");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setYokinkbn(C_YokinKbn.HUTUU);
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKouzano("1003");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setKzmeiginmkn("AAA");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setBanknmkj("CCC");
        viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.setSitennmkj("DDD");

        JT_Sk sk = new JT_Sk();
        sk.setInputshrhousiteikbn(C_InputShrhousiteiKbn.FBSOUKIN);
        sk.setBankcd("2001");
        sk.setSitencd("2002");
        sk.setYokinkbn(C_YokinKbn.TOUZA);
        sk.setKouzano("2003");
        sk.setKzmeiginmkn("BBB");

        siSetUiBean.setSk(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl, sk);

        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getInputshrhousiteikbn(),
            C_InputShrhousiteiKbn.FBSOUKIN, "入力用支払方法指定区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBankcd(), "2001", "銀行コード");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitencd(), "2002", "支店コード");
        exClassificationEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getYokinkbn(), C_YokinKbn.TOUZA,
            "預金種目区分");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKouzano(), "2003", "口座番号");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getKzmeiginmkn(), "BBB", "口座名義人氏名（カナ）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getBanknmkj(), "", "銀行名（漢字）");
        exStringEquals(viewSoukinsakiSateiSougouSyoukaiUiBeanParamImpl.getSitennmkj(), "", "支店名（漢字）");

    }

    @Test
    @TestOrder(270)
    public void testSetSk_A27() {

        ViewSiinInfoUiBeanParamImpl viewSiinInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSiinInfoUiBeanParamImpl.class);

        viewSiinInfoUiBeanParamImpl.setSiinkbn(C_SiinKbn.SP);

        JT_Sk sk = new JT_Sk();
        sk.setSiinkbn(C_SiinKbn.SG);

        siSetUiBean.setSk(viewSiinInfoUiBeanParamImpl, sk);

        exClassificationEquals(viewSiinInfoUiBeanParamImpl.getSiinkbn(), C_SiinKbn.SG, "死因区分");

    }

    @Test
    @TestOrder(280)
    public void testSetSk_A28() {

        ViewSaikenInfoUiBeanParamImpl viewSaikenInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSaikenInfoUiBeanParamImpl.class);

        viewSaikenInfoUiBeanParamImpl.setSaikennmkj("吉田");
        viewSaikenInfoUiBeanParamImpl.setSaikennyno("3810085");
        viewSaikenInfoUiBeanParamImpl.setSaikennmkj("東京都");
        viewSaikenInfoUiBeanParamImpl.setSaikennmkj("銀座");
        viewSaikenInfoUiBeanParamImpl.setSaikennmkj("町1-5-6");

        JT_Sk sk = new JT_Sk();
        sk.setSaikennmkj("西嶋");
        sk.setSaikennyno("0850211");
        sk.setSaikenadr1kj("大阪");
        sk.setSaikenadr2kj("関内");
        sk.setSaikenadr3kj("麻布3-4-33");

        siSetUiBean.setSk(viewSaikenInfoUiBeanParamImpl, sk);

        exStringEquals(viewSaikenInfoUiBeanParamImpl.getSaikennmkj(), "西嶋", "債権者氏名（漢字）");
        exStringEquals(viewSaikenInfoUiBeanParamImpl.getSaikennyno(), "0850211", "債権者郵便番号");
        exStringEquals(viewSaikenInfoUiBeanParamImpl.getSaikenadr1kj(), "大阪", "債権者住所１（漢字）");
        exStringEquals(viewSaikenInfoUiBeanParamImpl.getSaikenadr2kj(), "関内", "債権者住所２（漢字）");
        exStringEquals(viewSaikenInfoUiBeanParamImpl.getSaikenadr3kj(), "麻布3-4-33", "債権者住所３（漢字）");

    }

    @Test
    @TestOrder(290)
    public void testSetSk_A29() {

        ViewMnMeigiBangouUiBeanParamImpl viewMnMeigiBangouUiBeanParamImpl = SWAKInjector
            .getInstance(ViewMnMeigiBangouUiBeanParamImpl.class);

        viewMnMeigiBangouUiBeanParamImpl.setUktmnmeigibangou("123");
        viewMnMeigiBangouUiBeanParamImpl.setKykmnmeigibangou("321");

        JT_Sk sk = new JT_Sk();
        sk.setUktmnmeigibangou("456");
        sk.setKykmnmeigibangou("654");

        siSetUiBean.setSk(viewMnMeigiBangouUiBeanParamImpl, sk);

        exStringEquals(viewMnMeigiBangouUiBeanParamImpl.getUktmnmeigibangou(), "456", "受取人ＭＮ名義番号");
        exStringEquals(viewMnMeigiBangouUiBeanParamImpl.getKykmnmeigibangou(), "654", "契約者ＭＮ名義番号");

    }

    @Test
    @TestOrder(300)
    public void testSetSk_A30() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(21));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(23));

        JT_Sk sk = new JT_Sk();
        sk.setShrgk(BizCurrency.valueOf(200));
        sk.setHokenkngkgoukei(BizCurrency.valueOf(55));
        sk.setTienrisokukisanymd(BizDate.valueOf(20150301));
        sk.setTienrsknissuu(66);
        sk.setShrtienrsk(BizCurrency.valueOf(0));
        sk.setYenshrgk(BizCurrency.valueOf(201));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(99));
        sk.setYenshrtienrsk(BizCurrency.valueOf(0));

        siSetUiBean.setSk(viewShrGoukeiUiBeanParamImpl, sk);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(0), "円換算支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());

    }

    @Test
    @TestOrder(310)
    public void testSetSk_A31() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(21));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(23));

        JT_Sk sk = new JT_Sk();
        sk.setShrgk(BizCurrency.valueOf(200));
        sk.setHokenkngkgoukei(BizCurrency.valueOf(55));
        sk.setTienrisokukisanymd(BizDate.valueOf(20150301));
        sk.setTienrsknissuu(66);
        sk.setShrtienrsk(BizCurrency.valueOf(0));
        sk.setYenshrgk(BizCurrency.valueOf(201));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(99));
        sk.setYenshrtienrsk(BizCurrency.valueOf(100));
        sk.setShrtuukasyu(C_Tuukasyu.JPY);

        siSetUiBean.setSk(viewShrGoukeiUiBeanParamImpl, sk);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(0), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(100), "円換算支払遅延利息");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd(), BizDate.valueOf(20150301), "円支払遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu(), 66, "円支払遅延利息日数");

    }

    @Test
    @TestOrder(320)
    public void testSetSk_A32() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(21));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(23));

        JT_Sk sk = new JT_Sk();
        sk.setShrgk(BizCurrency.valueOf(200));
        sk.setHokenkngkgoukei(BizCurrency.valueOf(55));
        sk.setTienrisokukisanymd(BizDate.valueOf(20150301));
        sk.setTienrsknissuu(66);
        sk.setShrtienrsk(BizCurrency.valueOf(1000));
        sk.setYenshrgk(BizCurrency.valueOf(201));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(99));
        sk.setYenshrtienrsk(BizCurrency.valueOf(0));
        sk.setShrtuukasyu(C_Tuukasyu.JPY);

        siSetUiBean.setSk(viewShrGoukeiUiBeanParamImpl, sk);

        assertNull("遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd());
        assertNull("遅延利息日数", viewShrGoukeiUiBeanParamImpl.getTienrsknissuu());
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(1000), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(0), "円換算支払遅延利息");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd(), BizDate.valueOf(20150301), "円支払遅延利息起算日");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu(), 66, "円支払遅延利息日数");

    }

    @Test
    @TestOrder(330)
    public void testSetSk_A33() {

        ViewShrGoukeiUiBeanParamImpl viewShrGoukeiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewShrGoukeiUiBeanParamImpl.class);

        viewShrGoukeiUiBeanParamImpl.setShrgk(BizCurrency.valueOf(11));
        viewShrGoukeiUiBeanParamImpl.setHokenkngkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setTienrisokukisanymd(BizDate.valueOf(20160301));
        viewShrGoukeiUiBeanParamImpl.setTienrsknissuu(33);
        viewShrGoukeiUiBeanParamImpl.setShrtienrsk(BizCurrency.valueOf(44));
        viewShrGoukeiUiBeanParamImpl.setYenshrgk(BizCurrency.valueOf(21));
        viewShrGoukeiUiBeanParamImpl.setYenhkgkgoukei(BizCurrency.valueOf(22));
        viewShrGoukeiUiBeanParamImpl.setYenshrtienrsk(BizCurrency.valueOf(23));

        JT_Sk sk = new JT_Sk();
        sk.setShrgk(BizCurrency.valueOf(200));
        sk.setHokenkngkgoukei(BizCurrency.valueOf(55));
        sk.setTienrisokukisanymd(BizDate.valueOf(20150301));
        sk.setTienrsknissuu(66);
        sk.setShrtienrsk(BizCurrency.valueOf(77));
        sk.setYenshrgk(BizCurrency.valueOf(201));
        sk.setYenhkgkgoukei(BizCurrency.valueOf(99));
        sk.setYenshrtienrsk(BizCurrency.valueOf(100));
        sk.setShrtuukasyu(C_Tuukasyu.JPY);
        sk.setKyktuukasyu(C_Tuukasyu.JPY);

        siSetUiBean.setSk(viewShrGoukeiUiBeanParamImpl, sk);

        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrgk(),  BizCurrency.valueOf(200), "支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getHokenkngkgoukei(), BizCurrency.valueOf(55), "保険金額合計");
        exDateEquals(viewShrGoukeiUiBeanParamImpl.getTienrisokukisanymd(), BizDate.valueOf(20150301), "保険金額合計");
        exNumericEquals(viewShrGoukeiUiBeanParamImpl.getTienrsknissuu(), 66, "保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getShrtienrsk(), BizCurrency.valueOf(77), "支払遅延利息");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrgk(),  BizCurrency.valueOf(201), "円換算支払金額");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenhkgkgoukei(), BizCurrency.valueOf(99), "円換算保険金額合計");
        exBizCalcbleEquals(viewShrGoukeiUiBeanParamImpl.getYenshrtienrsk(), BizCurrency.valueOf(100), "円換算支払遅延利息");
        assertNull("円支払遅延利息起算日", viewShrGoukeiUiBeanParamImpl.getYentienrisokukisanymd());
        assertNull("円支払遅延利息日数", viewShrGoukeiUiBeanParamImpl.getYentienrsknissuu());

    }

}
