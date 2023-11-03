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
 * getSkKessanSyukeisBySeg1cdDenymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkKessanSyukeisBySeg1cdDenymd {

    @Inject
    SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisBySeg1cdDenymd(BizDate.valueOf(20160301));
        Assert.assertEquals(0,skKessanSyukeiLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        ST_SkKessanSyukei skKessanSyukei1 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20170301), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei1.setHuridenatesakicd("112");
        skKessanSyukei1.setDenkanjokamokucd("A110");
        skKessanSyukei1.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei1);

        ST_SkKessanSyukei skKessanSyukei2 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20170301), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei2.setHuridenatesakicd("112");
        skKessanSyukei2.setDenkanjokamokucd("A110");
        skKessanSyukei2.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei2);

        ST_SkKessanSyukei skKessanSyukei3 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20170228), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei3.setHuridenatesakicd("112");
        skKessanSyukei3.setDenkanjokamokucd("A110");
        skKessanSyukei3.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei3);

        ST_SkKessanSyukei skKessanSyukei4 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(20160304), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei4.setHuridenatesakicd("112");
        skKessanSyukei4.setDenkanjokamokucd("A110");
        skKessanSyukei4.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei4);

        ST_SkKessanSyukei skKessanSyukei5 = new ST_SkKessanSyukei("791112246", BizDate.valueOf(20160303), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei5.setHuridenatesakicd("112");
        skKessanSyukei5.setDenkanjokamokucd("A110");
        skKessanSyukei5.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei5);

        ST_SkKessanSyukei skKessanSyukei6 = new ST_SkKessanSyukei("791112253", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei6.setHuridenatesakicd("112");
        skKessanSyukei6.setDenkanjokamokucd("A110");
        skKessanSyukei6.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei6);

        ST_SkKessanSyukei skKessanSyukei7 = new ST_SkKessanSyukei("791112261", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei7.setHuridenatesakicd("114");
        skKessanSyukei7.setDenkanjokamokucd("A110");
        skKessanSyukei7.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei7);

        ST_SkKessanSyukei skKessanSyukei8 = new ST_SkKessanSyukei("791112279", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei8.setHuridenatesakicd("113");
        skKessanSyukei8.setDenkanjokamokucd("A110");
        skKessanSyukei8.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei8);

        ST_SkKessanSyukei skKessanSyukei9 = new ST_SkKessanSyukei("791112287", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei9.setHuridenatesakicd("112");
        skKessanSyukei9.setDenkanjokamokucd("A130");
        skKessanSyukei9.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei9);

        ST_SkKessanSyukei skKessanSyukei10 = new ST_SkKessanSyukei("791112295", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei10.setHuridenatesakicd("112");
        skKessanSyukei10.setDenkanjokamokucd("A120");
        skKessanSyukei10.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei10);

        ST_SkKessanSyukei skKessanSyukei11 = new ST_SkKessanSyukei("791112303", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei11.setHuridenatesakicd("112");
        skKessanSyukei11.setDenkanjokamokucd("A110");
        skKessanSyukei11.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei11);

        ST_SkKessanSyukei skKessanSyukei12 = new ST_SkKessanSyukei("791112311", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei12.setHuridenatesakicd("112");
        skKessanSyukei12.setDenkanjokamokucd("A110");
        skKessanSyukei12.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei12);

        ST_SkKessanSyukei skKessanSyukei13 = new ST_SkKessanSyukei("791112329", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei13.setHuridenatesakicd("112");
        skKessanSyukei13.setDenkanjokamokucd("A110");
        skKessanSyukei13.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei13);

        ST_SkKessanSyukei skKessanSyukei14 = new ST_SkKessanSyukei("791112337", BizDate.valueOf(20160302), C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skKessanSyukei14.setHuridenatesakicd("112");
        skKessanSyukei14.setDenkanjokamokucd("A110");
        skKessanSyukei14.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei14);

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisBySeg1cdDenymd(BizDate.valueOf(20180301));
        Assert.assertEquals(0,skKessanSyukeiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisBySeg1cdDenymd(BizDate.valueOf(20170301));
        Assert.assertEquals(1,skKessanSyukeiLst.size());

        Assert.assertEquals("791112220",skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20170301),skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(0).getSeg1cd());

    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<ST_SkKessanSyukei> skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisBySeg1cdDenymd(BizDate.valueOf(20160301));
        Assert.assertEquals(13,skKessanSyukeiLst.size());

        Assert.assertEquals("791112337",skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK,skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(0).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(0).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(0).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(0).getHuridenpagekbn());

        Assert.assertEquals("791112329",skKessanSyukeiLst.get(1).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(1).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(1).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK,skKessanSyukeiLst.get(1).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(1).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(1).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(1).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(1).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(1).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(1).getHuridenpagekbn());

        Assert.assertEquals("791112311",skKessanSyukeiLst.get(2).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(2).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(2).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(2).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(2).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(2).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(2).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(2).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(2).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(2).getHuridenpagekbn());

        Assert.assertEquals("791112303",skKessanSyukeiLst.get(3).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(3).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(3).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA,skKessanSyukeiLst.get(3).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(3).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(3).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(3).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(3).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(3).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(3).getHuridenpagekbn());

        Assert.assertEquals("791112295",skKessanSyukeiLst.get(4).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(4).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(4).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(4).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(4).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(4).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(4).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(4).getHuridenatesakicd());
        Assert.assertEquals("A120",skKessanSyukeiLst.get(4).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(4).getHuridenpagekbn());

        Assert.assertEquals("791112287",skKessanSyukeiLst.get(5).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(5).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(5).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(5).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(5).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(5).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(5).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(5).getHuridenatesakicd());
        Assert.assertEquals("A130",skKessanSyukeiLst.get(5).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(5).getHuridenpagekbn());

        Assert.assertEquals("791112279",skKessanSyukeiLst.get(6).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(6).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(6).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(6).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(6).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(6).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(6).getSeg1cd());
        Assert.assertEquals("113",skKessanSyukeiLst.get(6).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(6).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(6).getHuridenpagekbn());

        Assert.assertEquals("791112261",skKessanSyukeiLst.get(7).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(7).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(7).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(7).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(7).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(7).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(7).getSeg1cd());
        Assert.assertEquals("114",skKessanSyukeiLst.get(7).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(7).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(7).getHuridenpagekbn());

        Assert.assertEquals("791112253",skKessanSyukeiLst.get(8).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160302),skKessanSyukeiLst.get(8).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(8).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(8).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(8).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(8).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(8).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(8).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(8).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI,skKessanSyukeiLst.get(8).getHuridenpagekbn());

        Assert.assertEquals("791112246",skKessanSyukeiLst.get(9).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160303),skKessanSyukeiLst.get(9).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(9).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(9).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(9).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(9).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(9).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(9).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(9).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(9).getHuridenpagekbn());

        Assert.assertEquals("791112238",skKessanSyukeiLst.get(10).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160304),skKessanSyukeiLst.get(10).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(10).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(10).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(10).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(10).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(10).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(10).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(10).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(10).getHuridenpagekbn());

        Assert.assertEquals("791112220",skKessanSyukeiLst.get(11).getMosno());
        Assert.assertEquals(BizDate.valueOf(20170228),skKessanSyukeiLst.get(11).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(11).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(11).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(11).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(11).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(11).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(11).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(11).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(11).getHuridenpagekbn());

        Assert.assertEquals("791112220",skKessanSyukeiLst.get(12).getMosno());
        Assert.assertEquals(BizDate.valueOf(20170301),skKessanSyukeiLst.get(12).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKUZATUSYUUNYUU,skKessanSyukeiLst.get(12).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA,skKessanSyukeiLst.get(12).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK,skKessanSyukeiLst.get(12).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK,skKessanSyukeiLst.get(12).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,skKessanSyukeiLst.get(12).getSeg1cd());
        Assert.assertEquals("112",skKessanSyukeiLst.get(12).getHuridenatesakicd());
        Assert.assertEquals("A110",skKessanSyukeiLst.get(12).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK,skKessanSyukeiLst.get(12).getHuridenpagekbn());

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