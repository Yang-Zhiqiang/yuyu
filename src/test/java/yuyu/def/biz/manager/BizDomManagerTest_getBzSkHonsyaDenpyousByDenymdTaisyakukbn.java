package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.result.bean.BzSkHonsyaDenpyousByDenymdTaisyakukbnBean;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 業務共通<br />
 * 新契約本社用伝票リスト作成<br />
 * 新契約本社用伝票データ集計Beanリスト取得　伝票用システム区分が新契約のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getBzSkHonsyaDenpyousByDenymdTaisyakukbn {

    @Inject
    BizDomManager bizDomManager;

    static BizDate P_DENYMDFROM_01 = BizDate.valueOf("20160401");
    static BizDate P_DENYMDTO_01 = BizDate.valueOf("20160410");
    static BizDate P_DENYMD_01 = BizDate.valueOf("20160331");
    static BizDate P_DENYMD_02 = BizDate.valueOf("20160401");
    static BizDate P_DENYMD_03 = BizDate.valueOf("20160402");
    static BizDate P_DENYMD_04 = BizDate.valueOf("20160405");
    static BizDate P_DENYMD_05 = BizDate.valueOf("20160409");
    static BizDate P_DENYMD_06 = BizDate.valueOf("20160410");
    static BizDate P_DENYMD_07 = BizDate.valueOf("20160411");
    static BizCurrency P_DENYENKAGK__2000_JPY = BizCurrency.valueOf(2000, BizCurrencyTypes.YEN);
    static BizCurrency P_DENYENKAGK__1000_JPY = BizCurrency.valueOf(1000, BizCurrencyTypes.YEN);
    static BizCurrency P_DENYENKAGK_DOLLAR = BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(P_DENYMDFROM_01, P_DENYMDTO_01,
                C_TaisyakuKbn.KARIKATA);

        Assert.assertEquals(0, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.size());

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.HOZEN, "10", 10);
        denpyoData1.setDenymd(P_DENYMD_04);
        denpyoData1.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData1.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData1.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData1.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.SKEI, "11", 10);
        denpyoData2.setDenymd(P_DENYMD_01);
        denpyoData2.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData2.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData2.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData2.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.SKEI, "12", 10);
        denpyoData3.setDenymd(P_DENYMD_02);
        denpyoData3.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        denpyoData3.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        denpyoData3.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData3.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.SKEI, "13", 10);
        denpyoData4.setDenymd(P_DENYMD_03);
        denpyoData4.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData4.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU);
        denpyoData4.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData4.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.SKEI, "14", 10);
        denpyoData5.setDenymd(P_DENYMD_04);
        denpyoData5.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData5.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        denpyoData5.setDenyenkagk(P_DENYENKAGK_DOLLAR);
        denpyoData5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData5.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.SKEI, "15", 10);
        denpyoData6.setDenymd(P_DENYMD_04);
        denpyoData6.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData6.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        denpyoData6.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData6.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData6.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.SKEI, "16", 10);
        denpyoData7.setDenymd(P_DENYMD_05);
        denpyoData7.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData7.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData7.setDenyenkagk(P_DENYENKAGK__1000_JPY);
        denpyoData7.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData7.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.SKEI, "17", 10);
        denpyoData8.setDenymd(P_DENYMD_06);
        denpyoData8.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData8.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData8.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData8.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData8.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData8);

        BT_DenpyoData denpyoData9 = new BT_DenpyoData(C_DensysKbn.SKEI, "18", 10);
        denpyoData9.setDenymd(P_DENYMD_07);
        denpyoData9.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData9.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        denpyoData9.setDenyenkagk(P_DENYENKAGK__2000_JPY);
        denpyoData9.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData9.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData9);

        BT_DenpyoData denpyoData10 = new BT_DenpyoData(C_DensysKbn.SKEI, "19", 10);
        denpyoData10.setDenymd(P_DENYMD_06);
        denpyoData10.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        denpyoData10.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        denpyoData10.setDenyenkagk(null);
        denpyoData10.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        denpyoData10.setTekiyoukbn(C_TekiyouKbn.BLNK);

        bizDomManager.insert(denpyoData10);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU);
        kanjyouKamoku1.setKanjyoukmknm("KM10");
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        kanjyouKamoku2.setKanjyoukmknm("KM10");
        kanjyouKamoku2.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        kanjyouKamoku3.setKanjyoukmknm("KM10");
        kanjyouKamoku3.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku3);

        BM_KanjyouKamoku kanjyouKamoku4 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        kanjyouKamoku4.setKanjyoukmknm("KM10");
        kanjyouKamoku4.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku4);

        BM_KanjyouKamoku kanjyouKamoku5 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        kanjyouKamoku5.setKanjyoukmknm("KM10");
        kanjyouKamoku5.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku5);

        BM_KanjyouKamoku kanjyouKamoku6 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        kanjyouKamoku6.setKanjyoukmknm("KM10");
        kanjyouKamoku6.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku6);

        BM_KanjyouKamoku kanjyouKamoku7 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku7.setKanjyoukmknm("KM10");
        kanjyouKamoku7.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllDenpyoData());
        bizDomManager.delete(bizDomManager.getAllKanjyouKamoku());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(P_DENYMDFROM_01, P_DENYMDTO_01,
                C_TaisyakuKbn.BLNK);

        Assert.assertEquals(0, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(P_DENYMDFROM_01, P_DENYMDTO_01,
                C_TaisyakuKbn.KARIKATA);

        Assert.assertEquals(1, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.size());

        Assert.assertEquals("KM10", bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmknm());
        Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmkgroupkbn());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getTekiyoukbn());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getTaisyakukbn());
        Assert.assertEquals(1, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getDenyenkagkCount().intValue());
        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getDenyenkagkSum());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList =
            bizDomManager.getBzSkHonsyaDenpyousByDenymdTaisyakukbn(P_DENYMDFROM_01, P_DENYMDTO_01,
                C_TaisyakuKbn.KASIKATA);

        Assert.assertEquals(3, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.size());

        Assert.assertEquals("KM10", bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmknm());
        Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmkgroupkbn());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getTekiyoukbn());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getTaisyakukbn());
        Assert.assertEquals(2, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getDenyenkagkCount().intValue());
        Assert.assertEquals(BizCurrency.valueOf(3000, BizCurrencyTypes.YEN), bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(0).getDenyenkagkSum());

        Assert.assertEquals("KM10", bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getKanjyoukmknm());
        Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getKanjyoukmkgroupkbn());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getKanjyoukmkcd());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getTekiyoukbn());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getTaisyakukbn());
        Assert.assertEquals(1, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getDenyenkagkCount().intValue());
        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(1).getDenyenkagkSum());

        Assert.assertEquals("KM10", bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getKanjyoukmknm());
        Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getKanjyoukmkgroupkbn());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getKanjyoukmkcd());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getTekiyoukbn());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getTaisyakukbn());
        Assert.assertEquals(1, bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getDenyenkagkCount().intValue());
        Assert.assertEquals(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN), bzSkHonsyaDenpyousByKakutyoujobcdItemsBeanList.get(2).getDenyenkagkSum());
    }
}