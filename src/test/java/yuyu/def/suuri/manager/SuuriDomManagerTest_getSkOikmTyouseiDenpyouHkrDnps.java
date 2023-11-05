package yuyu.def.suuri.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkOikmTyouseiDenpyouHkrDnps() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkOikmTyouseiDenpyouHkrDnps {

    @Inject
    SuuriDomManager suuriDomManager;
    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouHkrDnps();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouHkrDnpsBean STDbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou1 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A110", 10);
        skOikmSyukeiPDenpyou1.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU);
        skOikmSyukeiPDenpyou1.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou1.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou1.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou1.setHuridenatesakicd("115");
        skOikmSyukeiPDenpyou1.setTekiyoucd("1000");
        skOikmSyukeiPDenpyou1.setTantocd(C_TantouCdKbn.KETTEI);
        skOikmSyukeiPDenpyou1.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou1);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU);
        kanjyouKamoku1.setKanjyoukmknm("勘定科目名");
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku1);

        BM_Segment segment1 = new BM_Segment(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        segment1.setSegnm("セグメント名");

        bizDomManager.insert(segment1);

    }

    @Test
    @TestOrder(20)
    public void normal10(){

        ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouHkrDnps();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouHkrDnpsBean STDbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("115", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KETTEI, STDbean.getTantocd());
                Assert.assertEquals("1000", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名", STDbean.getSegnm());

            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11(){

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        suuriDomManager.delete(suuriDomManager.getAllSkOikmSyukeiPDenpyou());
        bizDomManager.delete(bizDomManager.getAllKanjyouKamoku());
        bizDomManager.delete(bizDomManager.getAllSegment());

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou1 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.valueOf("10"), "A110", 10);
        skOikmSyukeiPDenpyou1.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        skOikmSyukeiPDenpyou1.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou1.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou1.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou1.setHuridenatesakicd("115");
        skOikmSyukeiPDenpyou1.setTantocd(C_TantouCdKbn.KEIYAKUSYOUGAI);
        skOikmSyukeiPDenpyou1.setTekiyoucd("1000");
        skOikmSyukeiPDenpyou1.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou1);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou2 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A111", 10);
        skOikmSyukeiPDenpyou2.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmSyukeiPDenpyou2.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmSyukeiPDenpyou2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou2.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou2.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou2.setHuridenatesakicd("114");
        skOikmSyukeiPDenpyou2.setTantocd(C_TantouCdKbn.WARIATENASI);
        skOikmSyukeiPDenpyou2.setTekiyoucd("1001");
        skOikmSyukeiPDenpyou2.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou2);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou3 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A112", 10);
        skOikmSyukeiPDenpyou3.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        skOikmSyukeiPDenpyou3.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmSyukeiPDenpyou3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou3.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou3.setSeg1cd(C_Segcd.BLNK);
        skOikmSyukeiPDenpyou3.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou3.setTantocd(C_TantouCdKbn.KETTEI);
        skOikmSyukeiPDenpyou3.setTekiyoucd("1002");
        skOikmSyukeiPDenpyou3.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou3);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou4 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A113", 10);
        skOikmSyukeiPDenpyou4.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        skOikmSyukeiPDenpyou4.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmSyukeiPDenpyou4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou4.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou4.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou4.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou4.setTantocd(C_TantouCdKbn.SENTAKUINFO);
        skOikmSyukeiPDenpyou4.setTekiyoucd("1003");
        skOikmSyukeiPDenpyou4.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou4);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou5 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A114", 10);
        skOikmSyukeiPDenpyou5.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY);
        skOikmSyukeiPDenpyou5.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou5.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou5.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou5.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou5.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou5.setTekiyoucd("1004");
        skOikmSyukeiPDenpyou5.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou5);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou6 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A115", 10);
        skOikmSyukeiPDenpyou6.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD);
        skOikmSyukeiPDenpyou6.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmSyukeiPDenpyou6.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou6.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou6.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou6.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou6.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou6.setTekiyoucd("1005");
        skOikmSyukeiPDenpyou6.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou6);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou7 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A116", 10);
        skOikmSyukeiPDenpyou7.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        skOikmSyukeiPDenpyou7.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmSyukeiPDenpyou7.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou7.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou7.setSeg1cd(C_Segcd.BLNK);
        skOikmSyukeiPDenpyou7.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou7.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou7.setTekiyoucd("1006");
        skOikmSyukeiPDenpyou7.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou7);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou8 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A117", 10);
        skOikmSyukeiPDenpyou8.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        skOikmSyukeiPDenpyou8.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmSyukeiPDenpyou8.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou8.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou8.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou8.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou8.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou8.setTekiyoucd("1007");
        skOikmSyukeiPDenpyou8.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou8);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou9 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A118", 10);
        skOikmSyukeiPDenpyou9.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        skOikmSyukeiPDenpyou9.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou9.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou9.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou9.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou9.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou9.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou9.setTekiyoucd("1008");
        skOikmSyukeiPDenpyou9.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou9);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou10 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A119", 10);
        skOikmSyukeiPDenpyou10.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        skOikmSyukeiPDenpyou10.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou10.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou10.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou10.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmSyukeiPDenpyou10.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou10.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou10.setTekiyoucd("1009");
        skOikmSyukeiPDenpyou10.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou10);

        ST_SkOikmSyukeiPDenpyou skOikmSyukeiPDenpyou11 = new ST_SkOikmSyukeiPDenpyou(C_DensysKbn.SKEI, "A120", 10);
        skOikmSyukeiPDenpyou11.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        skOikmSyukeiPDenpyou11.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmSyukeiPDenpyou11.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmSyukeiPDenpyou11.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmSyukeiPDenpyou11.setSeg1cd(C_Segcd.BLNK);
        skOikmSyukeiPDenpyou11.setHuridenatesakicd("113");
        skOikmSyukeiPDenpyou11.setTantocd(C_TantouCdKbn.SOUKATU1);
        skOikmSyukeiPDenpyou11.setTekiyoucd("1010");
        skOikmSyukeiPDenpyou11.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));

        suuriDomManager.insert(skOikmSyukeiPDenpyou11);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku1.setKanjyoukmknm("勘定科目名");
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        kanjyouKamoku2.setKanjyoukmknm("勘定科目名1");
        kanjyouKamoku2.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY);
        kanjyouKamoku3.setKanjyoukmknm("勘定科目名2");
        kanjyouKamoku3.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku3);

        BM_KanjyouKamoku kanjyouKamoku4 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD);
        kanjyouKamoku4.setKanjyoukmknm("勘定科目名3");
        kanjyouKamoku4.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku4);

        BM_KanjyouKamoku kanjyouKamoku5 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY);
        kanjyouKamoku5.setKanjyoukmknm("勘定科目名4");
        kanjyouKamoku5.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku5);

        BM_Segment segment1 = new BM_Segment(C_Segcd.BLNK);
        segment1.setSegnm("セグメント名");

        bizDomManager.insert(segment1);

        BM_Segment segment2 = new BM_Segment(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        segment2.setSegnm("セグメント名1");

        bizDomManager.insert(segment2);

    }
    @Test
    @TestOrder(30)
    public void normal20(){

        ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouHkrDnps();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouHkrDnpsBean STDbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1010", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名3", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名", STDbean.getSegnm());
            }

            if (2 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1009", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名3", STDbean.getKanjyoukmknm());
                Assert.assertEquals(null, STDbean.getSegnm());
            }

            if (3 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1008", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名3", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名1", STDbean.getSegnm());
            }

            if (4 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1007", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名3", STDbean.getKanjyoukmknm());
                Assert.assertEquals(null, STDbean.getSegnm());
            }

            if (5 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1006", STDbean.getTekiyoucd());
                Assert.assertEquals("勘定科目名3", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名", STDbean.getSegnm());

            }

            if (6 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1004", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名4", STDbean.getKanjyoukmknm());
                Assert.assertEquals(null, STDbean.getSegnm());
            }

            if (7 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SOUKATU1, STDbean.getTantocd());
                Assert.assertEquals("1005", STDbean.getTekiyoucd());
                Assert.assertEquals(null, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals(null, STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名1", STDbean.getSegnm());
            }

            if (8 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_PKAKIN_GAIHO_JPY, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, STDbean.getTantocd());
                Assert.assertEquals("1003", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名2", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名1", STDbean.getSegnm());
            }

            if (9 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("113", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KETTEI, STDbean.getTantocd());
                Assert.assertEquals("1002", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名1", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名", STDbean.getSegnm());
            }

            if (10 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("114", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.WARIATENASI, STDbean.getTantocd());
                Assert.assertEquals("1001", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名1", STDbean.getSegnm());
            }

            if (11 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), STDbean.getDenyenkagk());
                Assert.assertEquals("115", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KEIYAKUSYOUGAI, STDbean.getTantocd());
                Assert.assertEquals("1000", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名1", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名1", STDbean.getSegnm());
            }

        }
        Assert.assertEquals(11, iCount);
    }


    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkOikmSyukeiPDenpyou> skOikmSyukeiPDenpyouList = suuriDomManager.getAllSkOikmSyukeiPDenpyou();
        if(skOikmSyukeiPDenpyouList.size() > 0){
            suuriDomManager.delete(skOikmSyukeiPDenpyouList);
        }

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_KanjyouKamoku> kanjyouKamokuList = bizDomManager.getAllKanjyouKamoku();
        if(kanjyouKamokuList.size() > 0){
            bizDomManager.delete(kanjyouKamokuList);
        }
        List<BM_Segment> segmentList = bizDomManager.getAllSegment();
        if(segmentList.size() > 0){
            bizDomManager.delete(segmentList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}

