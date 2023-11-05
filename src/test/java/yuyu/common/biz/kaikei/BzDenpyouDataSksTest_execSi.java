package yuyu.common.biz.kaikei;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 伝票データ作成クラスのメソッド {@link BzDenpyouDataSks#execSi(BzDenpyouDataTourokuBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzDenpyouDataSksTest_execSi extends AbstractTest {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_伝票データ作成";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BzDenpyouDataSksTest_execSi.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager3 = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager3.delete(bizDomManager3.getAllKanjyouKamoku());
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    public void testExecSi_A1() {
        try {
            changeSystemDate(BizDate.valueOf("20160308"));
            BzDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111370");
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSi(bean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111370", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testExecSi_B1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111200");
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(skDenpyoDatas.size(), 0, "件数");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(30)
    public void testExecSi_B2() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111381");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);
        bean.setIbDensyorisyousaikbn(C_DenSyorisyousaiKbn.KZHURIKAE_SIS);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111381", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(40)
    public void testExecSi_B3() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111392");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("RA43");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0002");
        bean.setIbSyouhnsdno(1);
        bean.setIbDensyorisyousaikbn(C_DenSyorisyousaiKbn.KZHURIKAE_SIS);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2001));
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        BzSiwakeMeisaiBean siwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        siwakeMeisaiBean3.setIbSuitoubumoncd("1");
        siwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean3.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(2002));
        siwakeMeisaiBeans.add(siwakeMeisaiBean3);

        BzSiwakeMeisaiBean siwakeMeisaiBean4 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean4.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean4.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN);
        siwakeMeisaiBean4.setIbSuitoubumoncd("1");
        siwakeMeisaiBean4.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean4.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean4.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean4.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean4.setIbKeiyakutuukagk(BizCurrency.valueOf(2003));
        siwakeMeisaiBeans.add(siwakeMeisaiBean4);

        BzSiwakeMeisaiBean siwakeMeisaiBean5 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean5.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean5.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        siwakeMeisaiBean5.setIbSuitoubumoncd("1");
        siwakeMeisaiBean5.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean5.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean5.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean5.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean5.setIbKeiyakutuukagk(BizCurrency.valueOf(2004));
        siwakeMeisaiBeans.add(siwakeMeisaiBean5);

        BzSiwakeMeisaiBean siwakeMeisaiBean6 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean6.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean6.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean6.setIbSuitoubumoncd("1");
        siwakeMeisaiBean6.setIbDengaikagk(BizCurrency.valueOf(30000));
        siwakeMeisaiBean6.setIbDenyenkagk(BizCurrency.valueOf(20000));
        siwakeMeisaiBean6.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean6.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean6.setIbKeiyakutuukagk(BizCurrency.valueOf(2005));
        siwakeMeisaiBeans.add(siwakeMeisaiBean6);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(skDenpyoDatas.size(), 6, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(skDenpyoDatas.get(1).getEdano(), 2, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(1).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(1).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(1).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(1).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(1).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(1).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(1).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(1).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(1).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(1).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(1).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(1).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(1).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(1).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(1).getKeiyakutuukagk().toString(), "2001", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(1).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(1).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(1).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(1).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(1).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(skDenpyoDatas.get(2).getEdano(), 3, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(2).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(2).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(2).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(2).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(2).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(2).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(2).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(2).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(2).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(2).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(2).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(2).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(1).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(1).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(2).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(2).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(2).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(2).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(2).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(2).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(2).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(2).getKeiyakutuukagk().toString(), "2002", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(2).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(2).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(2).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(2).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(2).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(2).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(skDenpyoDatas.get(3).getEdano(), 4, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(3).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(3).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(3).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(3).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(3).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(3).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(3).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(3).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(3).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(3).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(3).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(3).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(3).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(3).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(3).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(3).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(3).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(3).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(3).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(3).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(3).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(3).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(3).getKeiyakutuukagk().toString(), "2003", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(3).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(3).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(3).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(3).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(3).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(3).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(skDenpyoDatas.get(4).getEdano(), 5, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(4).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(4).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(4).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(4).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(4).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(4).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(4).getKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(4).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(4).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(4).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(4).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(4).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(4).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(4).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(4).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(4).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(4).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(4).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(4).getSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(4).getSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(4).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(4).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(4).getKeiyakutuukagk().toString(), "2004", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(4).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(4).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(4).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(4).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(4).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(4).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(skDenpyoDatas.get(5).getEdano(), 6, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(5).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(5).getSyono(), "11807111392", "証券番号");
        exStringEquals(skDenpyoDatas.get(5).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(5).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(5).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(5).getTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(5).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(5).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(5).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(5).getDengaikagk().toString(), "30000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(5).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(5).getDenyenkagk().toString(), "20000", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(5).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(5).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(5).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(5).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(5).getSyoricd(), "RA43", "処理コード");
        exStringEquals(skDenpyoDatas.get(5).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(5).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(5).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(5).getKakokawaserateshiteiflg(), false, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(5).getKakokawaserateshiteiymd(), BizDate.valueOf("19850102"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(5).getKeiyakutuukagk().toString(), "2005", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(5).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(5).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(5).getDengyoumucd(), "5650", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(5).getSyusyouhncd(), "0002", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(5).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(5).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 4, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(50)
    public void testExecSi_C1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111381");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(true);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("20161009"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);
        bean.setIbDensyorisyousaikbn(C_DenSyorisyousaiKbn.KZHURIKAE_SIS);
        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(skDenpyoDatas.size(), 1, "件数");

        exNumericEquals(skDenpyoDatas.get(0).getEdano(), 1, "枝番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyskbn(), C_DensysKbn.HKSIHARAI, "伝票用システム区分");
        exStringEquals(skDenpyoDatas.get(0).getSyono(), "11807111381", "証券番号");
        exStringEquals(skDenpyoDatas.get(0).getHuridenatesakicd(), "001", "振替伝票宛先部課コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTantocd(), C_TantouCdKbn.IMUSATEI, "担当コード");
        exDateEquals(skDenpyoDatas.get(0).getDenymd(), BizDate.valueOf("20160101"), "伝票日付");
        exClassificationEquals(skDenpyoDatas.get(0).getTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(skDenpyoDatas.get(0).getKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, "勘定科目コード");
        exStringEquals(skDenpyoDatas.get(0).getSuitoubumoncd(), "1", "出納部門コード");
        exClassificationEquals(skDenpyoDatas.get(0).getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getDengaikagk().toString(), "1000", "伝票金額（外貨）");
        exStringEquals(skDenpyoDatas.get(0).getDenkawaserate().toString(), "0", "伝票用為替レート");
        exStringEquals(skDenpyoDatas.get(0).getDenyenkagk().toString(), "0", "伝票金額（円）");
        exClassificationEquals(skDenpyoDatas.get(0).getHuridenskskbn(), C_HuridensksKbn.BLNK, "振替伝票作成区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(skDenpyoDatas.get(0).getDenshrhoukbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");
        exDateEquals(skDenpyoDatas.get(0).getSyoriYmd(), BizDate.valueOf("20160119"), "処理年月日");
        exStringEquals(skDenpyoDatas.get(0).getSyoricd(), "0001", "処理コード");
        exStringEquals(skDenpyoDatas.get(0).getSyorisosikicd(), "0000001", "処理組織コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg1cd(), C_Segcd.BLNK, "セグメント１コード");
        exClassificationEquals(skDenpyoDatas.get(0).getSeg2cd(), C_Segcd.BLNK, "セグメント２コード");
        exBooleanEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(skDenpyoDatas.get(0).getKakokawaserateshiteiymd(), BizDate.valueOf("20161011"), "過去為替レート指定年月日");
        exClassificationEquals(skDenpyoDatas.get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exStringEquals(skDenpyoDatas.get(0).getKeiyakutuukagk().toString(), "2000", "契約通貨金額");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinsyaId(), "test01", "業務用更新者ＩＤ");
        exStringEquals(skDenpyoDatas.get(0).getGyoumuKousinTime().substring(0, 8), "20160308", "業務用更新時間");
        exStringEquals(skDenpyoDatas.get(0).getDengyoumucd(), "", "伝票用業務コード ");
        exStringEquals(skDenpyoDatas.get(0).getSyusyouhncd(), "0001", "主契約商品コード ");
        exNumericEquals(skDenpyoDatas.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(skDenpyoDatas.get(0).getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");

        exNumericEquals(bzDenpyouDataSks.getEdano(), 0, "メンバ変数．枝番号");
    }

    @Test
    @TestOrder(60)
    public void testExecSi_D1() {
        changeSystemDate(BizDate.valueOf("20160308"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20160101"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        BzSiwakeMeisaiBean siwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean3.setIbSuitoubumoncd("1");
        siwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean3.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTS);
        siwakeMeisaiBeans.add(siwakeMeisaiBean3);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exClassificationEquals(skDenpyoDatas.get(0).getKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");
        exClassificationEquals(skDenpyoDatas.get(1).getKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exClassificationEquals(skDenpyoDatas.get(2).getKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "為替適用区分");
        exClassificationEquals(skDenpyoDatas.get(3).getKawasetekiyokbn(), C_KawasetekiyoKbn.TTS, "為替適用区分");
    }

    @Test
    @TestOrder(70)
    public void testExecSi_E1() {
        changeSystemDate(BizDate.valueOf("20190325"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111211");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20190325"));
        bean.setIbTuukasyu(C_Tuukasyu.JPY);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
        siwakeMeisaiBean0.setIbDenkarikanjyono("12345");
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean2.setIbDenkarikanjyono(null);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exStringEquals(skDenpyoDatas.get(0).getDenkarikanjyono(), "12345", "伝票用仮勘定番号");
        exStringEquals(skDenpyoDatas.get(1).getDenkarikanjyono(), "", "伝票用仮勘定番号");
        exStringEquals(skDenpyoDatas.get(2).getDenkarikanjyono(), "", "伝票用仮勘定番号");
    }

    @Test
    @TestOrder(80)
    public void testExecSi_F1() {
        try {
            changeSystemDate(BizDate.valueOf("20190325"));
            BzDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111211");
            bean.setIbHuridenatesakicd("001");
            bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
            bean.setIbDenymd(BizDate.valueOf("20190325"));
            bean.setIbTuukasyu(C_Tuukasyu.JPY);
            bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
            bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
            bean.setIbSyoriymd(BizDate.valueOf("20160119"));
            bean.setIbSyoricd("0001");
            bean.setIbSyorisosikicd("0000001");
            bean.setIbGyoumuKousinsyaId("test01");
            bean.setIbKakokawaserateshiteiflg(false);
            bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
            bean.setIbKyktuukasyu(C_Tuukasyu.JPY);
            bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bean.setIbSyouhncd("0001");
            bean.setIbSyouhnsdno(1);

            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean0.setIbSuitoubumoncd("1");
            siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(5000,BizCurrencyTypes.YEN));
            siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(5100));
            siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
            siwakeMeisaiBean0.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean0);

            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(2000,BizCurrencyTypes.YEN));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
            siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
            siwakeMeisaiBean1.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(3100,BizCurrencyTypes.YEN));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
            siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
            siwakeMeisaiBean2.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSi(bean);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111211", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(90)
    public void testExecSi_F2() {
        try {
            changeSystemDate(BizDate.valueOf("20190325"));
            BzDenpyouDataTourokuBean bean = SWAKInjector
                .getInstance(BzDenpyouDataTourokuBean.class);
            bean.setIbSyono("11807111212");
            bean.setIbHuridenatesakicd("001");
            bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
            bean.setIbDenymd(BizDate.valueOf("20190325"));
            bean.setIbTuukasyu(C_Tuukasyu.USD);
            bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
            bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
            bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
            bean.setIbSyoriymd(BizDate.valueOf("20160119"));
            bean.setIbSyoricd("0001");
            bean.setIbSyorisosikicd("0000001");
            bean.setIbGyoumuKousinsyaId("test01");
            bean.setIbKakokawaserateshiteiflg(false);
            bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
            bean.setIbKyktuukasyu(C_Tuukasyu.USD);
            bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
            bean.setIbSyouhncd("0001");
            bean.setIbSyouhnsdno(1);

            List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
            BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
            siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean0.setIbSuitoubumoncd("1");
            siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(5000,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(5100));
            siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean0.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean0);

            BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean1.setIbSuitoubumoncd("1");
            siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
            siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean1.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean1);

            BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
            siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
            siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
            siwakeMeisaiBean2.setIbSuitoubumoncd("1");
            siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(3100,BizCurrencyTypes.DOLLAR));
            siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
            siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
            siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
            siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
            siwakeMeisaiBean2.setIbDenkarikanjyono("");
            siwakeMeisaiBeans.add(siwakeMeisaiBean2);

            bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

            BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
            bzDenpyouDataSks.execSi(bean);

        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "貸借合計金額が不一致です。証券番号=11807111212", "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(100)
    public void testExecSi_F3() {
        changeSystemDate(BizDate.valueOf("20190325"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20190325"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20160119"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(5000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(5100));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(2000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(2000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(3100,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean2.setIbDenkarikanjyono("");
        siwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exBooleanEquals(skDenpyoDatas.get(0).getTaisyakutyouseiflg(), true, "貸借調整フラグ");
        exBooleanEquals(skDenpyoDatas.get(1).getTaisyakutyouseiflg(), false, "貸借調整フラグ");
        exBooleanEquals(skDenpyoDatas.get(2).getTaisyakutyouseiflg(), true, "貸借調整フラグ");
    }

    @Test
    @TestOrder(110)
    public void testExecSi_G1() {
        changeSystemDate(BizDate.valueOf("20210323"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20210323"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20210323"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(bzDenpyouDataSks.getCreditHnknEdano(), 0, "メンバ変数．クレカ返金枝番号");
    }

    @Test
    @TestOrder(110)
    public void testExecSi_G2() {
        changeSystemDate(BizDate.valueOf("20210323"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20210323"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20210323"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(bzDenpyouDataSks.getCreditHnknEdano(), 2, "メンバ変数．クレカ返金枝番号");
    }

    @Test
    @TestOrder(130)
    public void testExecSi_G3() {
        changeSystemDate(BizDate.valueOf("20210323"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20210323"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20210323"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(30000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean2.setIbDenkarikanjyono("");
        siwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
    	
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(bzDenpyouDataSks.getCreditHnknEdano(), 3, "メンバ変数．クレカ返金枝番号");
    }

    @Test
    @TestOrder(140)
    public void testExecSi_G4() {
        changeSystemDate(BizDate.valueOf("20210323"));
        BzDenpyouDataTourokuBean bean = SWAKInjector
            .getInstance(BzDenpyouDataTourokuBean.class);
        bean.setIbSyono("11807111213");
        bean.setIbHuridenatesakicd("001");
        bean.setIbTantocd(C_TantouCdKbn.IMUSATEI);
        bean.setIbDenymd(BizDate.valueOf("20210323"));
        bean.setIbTuukasyu(C_Tuukasyu.USD);
        bean.setIbHuridenskskbn(C_HuridensksKbn.BLNK);
        bean.setIbDenhnknhoukbn(C_DenhnknhouKbn.BLNK);
        bean.setIbDenshrhoukbn(C_DenshrhouKbn.BLNK);
        bean.setIbSyoriymd(BizDate.valueOf("20210323"));
        bean.setIbSyoricd("0001");
        bean.setIbSyorisosikicd("0000001");
        bean.setIbGyoumuKousinsyaId("test01");
        bean.setIbKakokawaserateshiteiflg(false);
        bean.setIbKakokawaserateshiteiymd(BizDate.valueOf("19850102"));
        bean.setIbKyktuukasyu(C_Tuukasyu.USD);
        bean.setIbShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        bean.setIbSyouhncd("0001");
        bean.setIbSyouhnsdno(1);

        List<BzSiwakeMeisaiBean> siwakeMeisaiBeans = new ArrayList<>();
        BzSiwakeMeisaiBean siwakeMeisaiBean0 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean0.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean0.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE);
        siwakeMeisaiBean0.setIbSuitoubumoncd("1");
        siwakeMeisaiBean0.setIbDengaikagk(BizCurrency.valueOf(10000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean0.setIbDenyenkagk(BizCurrency.valueOf(10000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean0.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean0.setIbKeiyakutuukagk(BizCurrency.valueOf(1000));
        siwakeMeisaiBean0.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean0.setIbDenkarikanjyono("");
        siwakeMeisaiBean0.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean0);

        BzSiwakeMeisaiBean siwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        siwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN);
        siwakeMeisaiBean1.setIbSuitoubumoncd("1");
        siwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(20000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        siwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(2000));
        siwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean1.setIbDenkarikanjyono("");
        siwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean1);

        BzSiwakeMeisaiBean siwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        siwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        siwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI);
        siwakeMeisaiBean2.setIbSuitoubumoncd("1");
        siwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000,BizCurrencyTypes.DOLLAR));
        siwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(30000,BizCurrencyTypes.YEN));
        siwakeMeisaiBean2.setIbSeg1cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbSeg2cd(C_Segcd.BLNK);
        siwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(3000));
        siwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        siwakeMeisaiBean2.setIbDenkarikanjyono("");
        siwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);
        siwakeMeisaiBeans.add(siwakeMeisaiBean2);
    	
        bean.setBzSiwakeMeisaiBeanList(siwakeMeisaiBeans);

        List<JT_SiDenpyoData> skDenpyoDatas = new ArrayList<>();
        BzDenpyouDataSks bzDenpyouDataSks = SWAKInjector.getInstance(BzDenpyouDataSks.class);
        skDenpyoDatas = bzDenpyouDataSks.execSi(bean);

        exNumericEquals(bzDenpyouDataSks.getCreditHnknEdano(), 1, "メンバ変数．クレカ返金枝番号");
    }
}
