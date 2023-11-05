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
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BM_Segment;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkOikmTyouseiDenpyouInfos() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkOikmTyouseiDenpyouInfos {

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

        ExDBResults<SkOikmTyouseiDenpyouInfosBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouInfos();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouInfosBean STDbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou1 = new ST_SkOikmTyouseiDenpyou("791112220", C_Kanjyoukmkcd.BLNK, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skOikmTyouseiDenpyou1.setHuridenatesakicd("H03");
        skOikmTyouseiDenpyou1.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou1.setTekiyoucd("T01");
        skOikmTyouseiDenpyou1.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou1);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.BLNK);
        kanjyouKamoku1.setKanjyoukmknm("勘定科目名");
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        suuriDomManager.insert(kanjyouKamoku1);

        BM_Segment segment1 = new BM_Segment(C_Segcd.BLNK);
        segment1.setSegnm("セグメント名");

        suuriDomManager.insert(segment1);

        BM_TantouCd tantouCd1 = new BM_TantouCd(C_TantouCdKbn.BLNK0);
        tantouCd1.setBusitunm("B01");

        suuriDomManager.insert(tantouCd1);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal10(){

        ExDBResults<SkOikmTyouseiDenpyouInfosBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouInfos();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouInfosBean STDbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.BLNK, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H03", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
        }
        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11(){

        suuriDomManager.delete(suuriDomManager.getAllSkOikmTyouseiDenpyou());
        bizDomManager.delete(bizDomManager.getAllKanjyouKamoku());
        bizDomManager.delete(bizDomManager.getAllSegment());
        bizDomManager.delete(bizDomManager.getAllTantouCd());

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou1 = new ST_SkOikmTyouseiDenpyou("791112220", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou1.setHuridenatesakicd("H03");
        skOikmTyouseiDenpyou1.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skOikmTyouseiDenpyou1.setTekiyoucd("T01");
        skOikmTyouseiDenpyou1.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou1);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou2 = new ST_SkOikmTyouseiDenpyou("791112238", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou2.setHuridenatesakicd("H02");
        skOikmTyouseiDenpyou2.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skOikmTyouseiDenpyou2.setTekiyoucd("T01");
        skOikmTyouseiDenpyou2.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou2);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou3 = new ST_SkOikmTyouseiDenpyou("791112246", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou3.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou3.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skOikmTyouseiDenpyou3.setTekiyoucd("T01");
        skOikmTyouseiDenpyou3.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou3);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou4 = new ST_SkOikmTyouseiDenpyou("791112253", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou4.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou4.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmTyouseiDenpyou4.setTekiyoucd("T01");
        skOikmTyouseiDenpyou4.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou4);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou5 = new ST_SkOikmTyouseiDenpyou("791112261", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou5.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou5.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou5.setTekiyoucd("T01");
        skOikmTyouseiDenpyou5.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou5);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou6 = new ST_SkOikmTyouseiDenpyou("791112287", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou6.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou6.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou6.setTekiyoucd("T01");
        skOikmTyouseiDenpyou6.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou6);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou7 = new ST_SkOikmTyouseiDenpyou("791112295", C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou7.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou7.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou7.setTekiyoucd("T01");
        skOikmTyouseiDenpyou7.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou7);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou8 = new ST_SkOikmTyouseiDenpyou("791112311", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou8.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou8.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou8.setTekiyoucd("T01");
        skOikmTyouseiDenpyou8.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou8);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou9 = new ST_SkOikmTyouseiDenpyou("791112378", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.valueOf("1"), C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou9.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou9.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou9.setTekiyoucd("T01");
        skOikmTyouseiDenpyou9.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou9);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou10 = new ST_SkOikmTyouseiDenpyou("791112386", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.valueOf("0"), C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou10.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou10.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou10.setTekiyoucd("T01");
        skOikmTyouseiDenpyou10.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou10);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou11 = new ST_SkOikmTyouseiDenpyou("791112394", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.valueOf("0"), C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmTyouseiDenpyou11.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou11.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou11.setTekiyoucd("T01");
        skOikmTyouseiDenpyou11.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou11);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou12 = new ST_SkOikmTyouseiDenpyou("791112394", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.valueOf("0"), C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skOikmTyouseiDenpyou12.setHuridenatesakicd("H01");
        skOikmTyouseiDenpyou12.setTantocd(C_TantouCdKbn.BLNK0);
        skOikmTyouseiDenpyou12.setTekiyoucd("T01");
        skOikmTyouseiDenpyou12.setDenyenkagk(BizCurrency.valueOf(10));

        suuriDomManager.insert(skOikmTyouseiDenpyou12);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.BLNK);
        kanjyouKamoku1.setKanjyoukmknm("勘定科目名１");
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        suuriDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        kanjyouKamoku2.setKanjyoukmknm("勘定科目名２");
        kanjyouKamoku2.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        suuriDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        kanjyouKamoku3.setKanjyoukmknm("勘定科目名３");
        kanjyouKamoku3.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        suuriDomManager.insert(kanjyouKamoku3);

        BM_KanjyouKamoku kanjyouKamoku4 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku4.setKanjyoukmknm("勘定科目名４");
        kanjyouKamoku4.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        suuriDomManager.insert(kanjyouKamoku4);

        BM_Segment segment1 = new BM_Segment(C_Segcd.BLNK);
        segment1.setSegnm("セグメント名１");

        suuriDomManager.insert(segment1);

        BM_Segment segment2 = new BM_Segment(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        segment2.setSegnm("セグメント名２");

        suuriDomManager.insert(segment2);

        BM_TantouCd tantouCd1 = new BM_TantouCd(C_TantouCdKbn.BLNK0);
        tantouCd1.setBusitunm("B01");

        suuriDomManager.insert(tantouCd1);

        BM_TantouCd tantouCd2 = new BM_TantouCd(C_TantouCdKbn.KIKAKUIMU);
        tantouCd2.setBusitunm("B02");

        suuriDomManager.insert(tantouCd2);

    }

    @Test
    @TestOrder(30)
    public void normal20(){

        ExDBResults<SkOikmTyouseiDenpyouInfosBean> beans = suuriDomManager.getSkOikmTyouseiDenpyouInfos();

        int iCount = 0;
        for (SkOikmTyouseiDenpyouInfosBean STDbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名４", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名１", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
            if (2 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名４", STDbean.getKanjyoukmknm());
                Assert.assertEquals(null, STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
            if (3 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名４", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
            if (4 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名４", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());
            }
            if (5 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名４", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
            if (6 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名３", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }
            if (7 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名２", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());
            }

            if (8 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.BLNK0, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(null, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals(null, STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B01", STDbean.getBusitunm());

            }

            if (9 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名２", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals(null, STDbean.getBusitunm());
            }
            if (10 == iCount) {

                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H01", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名２", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B02", STDbean.getBusitunm());

            }
            if (11 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H02", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名２", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B02", STDbean.getBusitunm());

            }
            if (12 == iCount) {
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, STDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, STDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, STDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, STDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, STDbean.getSeg1cd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN),STDbean.getDenyenkagk());
                Assert.assertEquals("H03", STDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, STDbean.getTantocd());
                Assert.assertEquals("T01", STDbean.getTekiyoucd());
                Assert.assertEquals(C_KanjyoukmkgroupKbn.BLNK, STDbean.getKanjyoukmkgroupkbn());
                Assert.assertEquals("勘定科目名２", STDbean.getKanjyoukmknm());
                Assert.assertEquals("セグメント名２", STDbean.getSegnm());
                Assert.assertEquals("B02", STDbean.getBusitunm());

            }
        }
        Assert.assertEquals(12, iCount);
    }



    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouList = suuriDomManager.getAllSkOikmTyouseiDenpyou();
        if(skOikmTyouseiDenpyouList.size() > 0){
            suuriDomManager.delete(skOikmTyouseiDenpyouList);
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
        List<BM_TantouCd> tantouCdList = bizDomManager.getAllTantouCd();
        if(tantouCdList.size() > 0){
            bizDomManager.delete(tantouCdList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}