package yuyu.def.suuri.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkKessanSyukeisByDenymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkKessanSyukeisByDenymd {

    @Inject
    private SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisByDenymd(BizDate.valueOf(20161120));

        Assert.assertEquals(0, skKessanSyukeiLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ST_SkKessanSyukei skKessanSyukei1 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20161116), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei1.setHuridenatesakicd("103");
        skKessanSyukei1.setDenkanjokamokucd("10003");
        skKessanSyukei1.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei1);

        ST_SkKessanSyukei skKessanSyukei2 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20161120), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei2.setHuridenatesakicd("103");
        skKessanSyukei2.setDenkanjokamokucd("10003");
        skKessanSyukei2.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei2);

        ST_SkKessanSyukei skKessanSyukei3 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(20161119), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei3.setHuridenatesakicd("103");
        skKessanSyukei3.setDenkanjokamokucd("10003");
        skKessanSyukei3.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei3);

        ST_SkKessanSyukei skKessanSyukei4 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(20161118), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei4.setHuridenatesakicd("103");
        skKessanSyukei4.setDenkanjokamokucd("10003");
        skKessanSyukei4.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei4);

        ST_SkKessanSyukei skKessanSyukei5 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei5.setHuridenatesakicd("103");
        skKessanSyukei5.setDenkanjokamokucd("10003");
        skKessanSyukei5.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei5);

        ST_SkKessanSyukei skKessanSyukei6 = new ST_SkKessanSyukei("791112246", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei6.setHuridenatesakicd("103");
        skKessanSyukei6.setDenkanjokamokucd("10003");
        skKessanSyukei6.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei6);

        ST_SkKessanSyukei skKessanSyukei7 = new ST_SkKessanSyukei("791112253", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei7.setHuridenatesakicd("102");
        skKessanSyukei7.setDenkanjokamokucd("10003");
        skKessanSyukei7.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei7);

        ST_SkKessanSyukei skKessanSyukei8 = new ST_SkKessanSyukei("791112261", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei8.setHuridenatesakicd("101");
        skKessanSyukei8.setDenkanjokamokucd("10003");
        skKessanSyukei8.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei8);

        ST_SkKessanSyukei skKessanSyukei9 = new ST_SkKessanSyukei("791112279", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei9.setHuridenatesakicd("101");
        skKessanSyukei9.setDenkanjokamokucd("10002");
        skKessanSyukei9.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei9);

        ST_SkKessanSyukei skKessanSyukei10 = new ST_SkKessanSyukei("791112287", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei10.setHuridenatesakicd("101");
        skKessanSyukei10.setDenkanjokamokucd("10001");
        skKessanSyukei10.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei10);

        ST_SkKessanSyukei skKessanSyukei11 = new ST_SkKessanSyukei("791112295", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei11.setHuridenatesakicd("101");
        skKessanSyukei11.setDenkanjokamokucd("10001");
        skKessanSyukei11.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei11);

        ST_SkKessanSyukei skKessanSyukei12 = new ST_SkKessanSyukei("791112303", BizDate.valueOf(20161117), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei12.setHuridenatesakicd("101");
        skKessanSyukei12.setDenkanjokamokucd("10001");
        skKessanSyukei12.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei12);

    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisByDenymd(BizDate.valueOf(20161121));

        Assert.assertEquals(0, skKessanSyukeiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisByDenymd(BizDate.valueOf(20161120));

        Assert.assertEquals(1, skKessanSyukeiLst.size());

        Assert.assertEquals("791112220", skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161120), skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(0).getSeg1cd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisByDenymd(BizDate.valueOf(20161117));

        Assert.assertEquals(11, skKessanSyukeiLst.size());

        Assert.assertEquals("791112303", skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(0).getSeg1cd());
        Assert.assertEquals("101", skKessanSyukeiLst.get(0).getHuridenatesakicd());
        Assert.assertEquals("10001", skKessanSyukeiLst.get(0).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(0).getHuridenpagekbn());


        Assert.assertEquals("791112295", skKessanSyukeiLst.get(1).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(1).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(1).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA, skKessanSyukeiLst.get(1).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(1).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(1).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(1).getSeg1cd());
        Assert.assertEquals("101", skKessanSyukeiLst.get(1).getHuridenatesakicd());
        Assert.assertEquals("10001", skKessanSyukeiLst.get(1).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(1).getHuridenpagekbn());

        Assert.assertEquals("791112287", skKessanSyukeiLst.get(2).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(2).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(2).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(2).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(2).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(2).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(2).getSeg1cd());
        Assert.assertEquals("101", skKessanSyukeiLst.get(2).getHuridenatesakicd());
        Assert.assertEquals("10001", skKessanSyukeiLst.get(2).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(2).getHuridenpagekbn());

        Assert.assertEquals("791112279", skKessanSyukeiLst.get(3).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(3).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(3).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(3).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(3).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(3).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(3).getSeg1cd());
        Assert.assertEquals("101", skKessanSyukeiLst.get(3).getHuridenatesakicd());
        Assert.assertEquals("10002", skKessanSyukeiLst.get(3).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(3).getHuridenpagekbn());

        Assert.assertEquals("791112261", skKessanSyukeiLst.get(4).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(4).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(4).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(4).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(4).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(4).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(4).getSeg1cd());
        Assert.assertEquals("101", skKessanSyukeiLst.get(4).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(4).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(4).getHuridenpagekbn());

        Assert.assertEquals("791112253", skKessanSyukeiLst.get(5).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(5).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(5).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(5).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(5).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(5).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(5).getSeg1cd());
        Assert.assertEquals("102", skKessanSyukeiLst.get(5).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(5).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(5).getHuridenpagekbn());

        Assert.assertEquals("791112246", skKessanSyukeiLst.get(6).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(6).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(6).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(6).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(6).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(6).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(6).getSeg1cd());
        Assert.assertEquals("103", skKessanSyukeiLst.get(6).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(6).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(6).getHuridenpagekbn());

        Assert.assertEquals("791112238", skKessanSyukeiLst.get(7).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161117), skKessanSyukeiLst.get(7).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(7).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(7).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(7).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(7).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(7).getSeg1cd());
        Assert.assertEquals("103", skKessanSyukeiLst.get(7).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(7).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(7).getHuridenpagekbn());

        Assert.assertEquals("791112238", skKessanSyukeiLst.get(8).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161118), skKessanSyukeiLst.get(8).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(8).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(8).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(8).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(8).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(8).getSeg1cd());
        Assert.assertEquals("103", skKessanSyukeiLst.get(8).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(8).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(8).getHuridenpagekbn());

        Assert.assertEquals("791112238", skKessanSyukeiLst.get(9).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161119), skKessanSyukeiLst.get(9).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(9).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(9).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(9).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(9).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(9).getSeg1cd());
        Assert.assertEquals("103", skKessanSyukeiLst.get(9).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(9).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(9).getHuridenpagekbn());

        Assert.assertEquals("791112220", skKessanSyukeiLst.get(10).getMosno());
        Assert.assertEquals(BizDate.valueOf(20161120), skKessanSyukeiLst.get(10).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(10).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(10).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(10).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(10).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, skKessanSyukeiLst.get(10).getSeg1cd());
        Assert.assertEquals("103", skKessanSyukeiLst.get(10).getHuridenatesakicd());
        Assert.assertEquals("10003", skKessanSyukeiLst.get(10).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(10).getHuridenpagekbn());

    }


    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkKessanSyukei> skKessanSyukeiList = suuriDomManager.getAllSkKessanSyukei();
        if(skKessanSyukeiList.size() > 0){
            suuriDomManager.delete(skKessanSyukeiList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}