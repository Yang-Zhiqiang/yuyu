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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HuridenpageKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.BM_TantouCd;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd {

    @Inject
    private SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();
        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate.valueOf(20160219));

        Assert.assertEquals(0, skKessanSyukeiLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ST_SkKessanSyukei skKessanSyukei1 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20160220), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei1.setHuridenatesakicd("114");
        skKessanSyukei1.setTantocd(C_TantouCdKbn.SENTAKUINFO);
        skKessanSyukei1.setDenkanjokamokucd("11114");
        skKessanSyukei1.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei1);

        ST_SkKessanSyukei skKessanSyukei2 = new ST_SkKessanSyukei("791112220", BizDate.valueOf(20160218), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei2.setHuridenatesakicd("114");
        skKessanSyukei2.setTantocd(C_TantouCdKbn.SENTAKUINFO);
        skKessanSyukei2.setDenkanjokamokucd("11114");
        skKessanSyukei2.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei2);

        ST_SkKessanSyukei skKessanSyukei3 = new ST_SkKessanSyukei("791112238", BizDate.valueOf(20160217), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei3.setHuridenatesakicd("112");
        skKessanSyukei3.setTantocd(C_TantouCdKbn.SOUKATU1);
        skKessanSyukei3.setDenkanjokamokucd("11112");
        skKessanSyukei3.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei3);

        ST_SkKessanSyukei skKessanSyukei4 = new ST_SkKessanSyukei("791112246", BizDate.valueOf(20160216), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei4.setHuridenatesakicd("114");
        skKessanSyukei4.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei4.setDenkanjokamokucd("11112");
        skKessanSyukei4.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei4);

        ST_SkKessanSyukei skKessanSyukei5 = new ST_SkKessanSyukei("791112253", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei5.setHuridenatesakicd("113");
        skKessanSyukei5.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei5.setDenkanjokamokucd("11112");
        skKessanSyukei5.setHuridenpagekbn(C_HuridenpageKbn.OIKOMITYOUSEI);

        suuriDomManager.insert(skKessanSyukei5);

        ST_SkKessanSyukei skKessanSyukei6 = new ST_SkKessanSyukei("791112261", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei6.setHuridenatesakicd("114");
        skKessanSyukei6.setTantocd(C_TantouCdKbn.SOUKATU1);
        skKessanSyukei6.setDenkanjokamokucd("11112");
        skKessanSyukei6.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei6);

        ST_SkKessanSyukei skKessanSyukei7 = new ST_SkKessanSyukei("791112279", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei7.setHuridenatesakicd("113");
        skKessanSyukei7.setTantocd(C_TantouCdKbn.IMUIMU);
        skKessanSyukei7.setDenkanjokamokucd("11112");
        skKessanSyukei7.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei7);

        ST_SkKessanSyukei skKessanSyukei8 = new ST_SkKessanSyukei("791112287", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei8.setHuridenatesakicd("112");
        skKessanSyukei8.setTantocd(C_TantouCdKbn.SOUKATU1);
        skKessanSyukei8.setDenkanjokamokucd("11114");
        skKessanSyukei8.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei8);

        ST_SkKessanSyukei skKessanSyukei9 = new ST_SkKessanSyukei("791112295", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei9.setHuridenatesakicd("112");
        skKessanSyukei9.setTantocd(C_TantouCdKbn.IMUIMU);
        skKessanSyukei9.setDenkanjokamokucd("11112");
        skKessanSyukei9.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei9);

        ST_SkKessanSyukei skKessanSyukei10 = new ST_SkKessanSyukei("791112303", BizDate.valueOf(20160215), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei10.setHuridenatesakicd("112");
        skKessanSyukei10.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei10.setDenkanjokamokucd("11114");
        skKessanSyukei10.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei10);

        ST_SkKessanSyukei skKessanSyukei11 = new ST_SkKessanSyukei("791112311", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei11.setHuridenatesakicd("112");
        skKessanSyukei11.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei11.setDenkanjokamokucd("11114");
        skKessanSyukei11.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei11);

        ST_SkKessanSyukei skKessanSyukei12 = new ST_SkKessanSyukei("791112329", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei12.setHuridenatesakicd("112");
        skKessanSyukei12.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei12.setDenkanjokamokucd("11113");
        skKessanSyukei12.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei12);

        ST_SkKessanSyukei skKessanSyukei13 = new ST_SkKessanSyukei("791112337", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei13.setHuridenatesakicd("112");
        skKessanSyukei13.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei13.setDenkanjokamokucd("11112");
        skKessanSyukei13.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei13);

        ST_SkKessanSyukei skKessanSyukei14 = new ST_SkKessanSyukei("791112345", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei14.setHuridenatesakicd("112");
        skKessanSyukei14.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei14.setDenkanjokamokucd("11112");
        skKessanSyukei14.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei14);

        ST_SkKessanSyukei skKessanSyukei15 = new ST_SkKessanSyukei("791112352", BizDate.valueOf(20160215), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);
        skKessanSyukei15.setHuridenatesakicd("112");
        skKessanSyukei15.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skKessanSyukei15.setDenkanjokamokucd("11112");
        skKessanSyukei15.setHuridenpagekbn(C_HuridenpageKbn.BLNK);

        suuriDomManager.insert(skKessanSyukei15);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku1.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        kanjyouKamoku2.setKanjyoukmkgroupkbn(C_KanjyoukmkgroupKbn.BLNK);

        bizDomManager.insert(kanjyouKamoku2);

        BM_TantouCd tantouCd1 = new BM_TantouCd(C_TantouCdKbn.IMUSATEI);

        bizDomManager.insert(tantouCd1);

        BM_TantouCd tantouCd2 = new BM_TantouCd(C_TantouCdKbn.KIKAKUIMU);

        bizDomManager.insert(tantouCd2);

        BM_TantouCd tantouCd3 = new BM_TantouCd(C_TantouCdKbn.IMUIMU);

        bizDomManager.insert(tantouCd3);

        BM_TantouCd tantouCd4 = new BM_TantouCd(C_TantouCdKbn.SOUKATU1);

        bizDomManager.insert(tantouCd4);
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate.valueOf(20160221));

        Assert.assertEquals(0, skKessanSyukeiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate.valueOf(20160219));

        Assert.assertEquals(1, skKessanSyukeiLst.size());

        Assert.assertEquals("791112220", skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160220), skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(0).getSeg1cd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<ST_SkKessanSyukei>  skKessanSyukeiLst = suuriDomManager.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate.valueOf(20160215));

        Assert.assertEquals(15, skKessanSyukeiLst.size());

        Assert.assertEquals("791112352", skKessanSyukeiLst.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(0).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(0).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(0).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(0).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(0).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(0).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(0).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(0).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(0).getHuridenpagekbn());

        Assert.assertEquals("791112345", skKessanSyukeiLst.get(1).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(1).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(1).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA, skKessanSyukeiLst.get(1).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(1).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(1).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(1).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(1).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(1).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(1).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(1).getHuridenpagekbn());

        Assert.assertEquals("791112337", skKessanSyukeiLst.get(2).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(2).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(2).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(2).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(2).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(2).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(2).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(2).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(2).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(2).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(2).getHuridenpagekbn());

        Assert.assertEquals("791112329", skKessanSyukeiLst.get(3).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(3).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(3).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(3).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(3).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(3).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(3).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(3).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(3).getTantocd());
        Assert.assertEquals("11113", skKessanSyukeiLst.get(3).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(3).getHuridenpagekbn());

        Assert.assertEquals("791112311", skKessanSyukeiLst.get(4).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(4).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(4).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(4).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(4).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(4).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(4).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(4).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(4).getTantocd());
        Assert.assertEquals("11114", skKessanSyukeiLst.get(4).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(4).getHuridenpagekbn());

        Assert.assertEquals("791112303", skKessanSyukeiLst.get(5).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(5).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, skKessanSyukeiLst.get(5).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(5).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(5).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(5).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(5).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(5).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(5).getTantocd());
        Assert.assertEquals("11114", skKessanSyukeiLst.get(5).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(5).getHuridenpagekbn());

        Assert.assertEquals("791112295", skKessanSyukeiLst.get(6).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(6).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(6).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(6).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(6).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(6).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(6).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(6).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.IMUIMU, skKessanSyukeiLst.get(6).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(6).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(6).getHuridenpagekbn());

        Assert.assertEquals("791112287", skKessanSyukeiLst.get(7).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(7).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(7).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(7).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(7).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(7).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(7).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(7).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.SOUKATU1, skKessanSyukeiLst.get(7).getTantocd());
        Assert.assertEquals("11114", skKessanSyukeiLst.get(7).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(7).getHuridenpagekbn());

        Assert.assertEquals("791112279", skKessanSyukeiLst.get(8).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(8).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(8).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(8).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(8).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(8).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(8).getSeg1cd());
        Assert.assertEquals("113", skKessanSyukeiLst.get(8).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.IMUIMU, skKessanSyukeiLst.get(8).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(8).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(8).getHuridenpagekbn());

        Assert.assertEquals("791112261", skKessanSyukeiLst.get(9).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(9).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(9).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(9).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(9).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(9).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(9).getSeg1cd());
        Assert.assertEquals("114", skKessanSyukeiLst.get(9).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.SOUKATU1, skKessanSyukeiLst.get(9).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(9).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(9).getHuridenpagekbn());

        Assert.assertEquals("791112253", skKessanSyukeiLst.get(10).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160215), skKessanSyukeiLst.get(10).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(10).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(10).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(10).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(10).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(10).getSeg1cd());
        Assert.assertEquals("113", skKessanSyukeiLst.get(10).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(10).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(10).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(10).getHuridenpagekbn());

        Assert.assertEquals("791112246", skKessanSyukeiLst.get(11).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160216), skKessanSyukeiLst.get(11).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(11).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(11).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(11).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(11).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(11).getSeg1cd());
        Assert.assertEquals("114", skKessanSyukeiLst.get(11).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, skKessanSyukeiLst.get(11).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(11).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(11).getHuridenpagekbn());

        Assert.assertEquals("791112238", skKessanSyukeiLst.get(12).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160217), skKessanSyukeiLst.get(12).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(12).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, skKessanSyukeiLst.get(12).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(12).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(12).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(12).getSeg1cd());
        Assert.assertEquals("112", skKessanSyukeiLst.get(12).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.SOUKATU1, skKessanSyukeiLst.get(12).getTantocd());
        Assert.assertEquals("11112", skKessanSyukeiLst.get(12).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(12).getHuridenpagekbn());

        Assert.assertEquals("791112220", skKessanSyukeiLst.get(13).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160218), skKessanSyukeiLst.get(13).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(13).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(13).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(13).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(13).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(13).getSeg1cd());
        Assert.assertEquals("114", skKessanSyukeiLst.get(13).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, skKessanSyukeiLst.get(13).getTantocd());
        Assert.assertEquals("11114", skKessanSyukeiLst.get(13).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.BLNK, skKessanSyukeiLst.get(13).getHuridenpagekbn());

        Assert.assertEquals("791112220", skKessanSyukeiLst.get(14).getMosno());
        Assert.assertEquals(BizDate.valueOf(20160220), skKessanSyukeiLst.get(14).getDenymd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, skKessanSyukeiLst.get(14).getKanjyoukmkcd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, skKessanSyukeiLst.get(14).getTaisyakukbn());
        Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, skKessanSyukeiLst.get(14).getNaibukeiyakukbn());
        Assert.assertEquals(C_TekiyouKbn.BLNK, skKessanSyukeiLst.get(14).getTekiyoukbn());
        Assert.assertEquals(C_Segcd.BLNK, skKessanSyukeiLst.get(14).getSeg1cd());
        Assert.assertEquals("114", skKessanSyukeiLst.get(14).getHuridenatesakicd());
        Assert.assertEquals(C_TantouCdKbn.SENTAKUINFO, skKessanSyukeiLst.get(14).getTantocd());
        Assert.assertEquals("11114", skKessanSyukeiLst.get(14).getDenkanjokamokucd());
        Assert.assertEquals(C_HuridenpageKbn.OIKOMITYOUSEI, skKessanSyukeiLst.get(14).getHuridenpagekbn());
    }

    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkKessanSyukei> skKessanSyukeiList = suuriDomManager.getAllSkKessanSyukei();
        if(skKessanSyukeiList.size() > 0){
            suuriDomManager.delete(skKessanSyukeiList);
        }
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_TantouCd> tantouCdList = bizDomManager.getAllTantouCd();
        if(tantouCdList.size() > 0){
            bizDomManager.delete(tantouCdList);
        }
        List<BM_KanjyouKamoku> kanjyouKamokuList = bizDomManager.getAllKanjyouKamoku();
        if(kanjyouKamokuList.size() > 0){
            bizDomManager.delete(kanjyouKamokuList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}