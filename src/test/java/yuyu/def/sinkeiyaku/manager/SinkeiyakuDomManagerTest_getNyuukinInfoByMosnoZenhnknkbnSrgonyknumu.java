package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean beans = sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu("791112220");

        Assert.assertEquals(beans, null);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(11);
        nyuukin1.setTyakkinymd(BizDate.valueOf(20161025));
        nyuukin1.setNyksyoriymd(BizDate.valueOf(20161020));
        nyuukin1.setRyosyuymd(BizDate.valueOf(20161024));
        nyuukin1.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin1.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(12);
        nyuukin2.setTyakkinymd(BizDate.valueOf(20161026));
        nyuukin2.setNyksyoriymd(BizDate.valueOf(20161021));
        nyuukin2.setRyosyuymd(BizDate.valueOf(20161025));
        nyuukin2.setZenhnknkbn(C_ZenhnknKbn.SUMI);
        nyuukin2.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(13);
        nyuukin3.setTyakkinymd(BizDate.valueOf(20161027));
        nyuukin3.setNyksyoriymd(BizDate.valueOf(20161022));
        nyuukin3.setRyosyuymd(BizDate.valueOf(20161026));
        nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin3.setSrgonyknumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Nyuukin nyuukin4 = syoriCTL2.createNyuukin();
        nyuukin4.setRenno(11);
        nyuukin4.setTyakkinymd(BizDate.valueOf(20161028));
        nyuukin4.setNyksyoriymd(BizDate.valueOf(20161023));
        nyuukin4.setRyosyuymd(BizDate.valueOf(20161027));
        nyuukin4.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin4.setSrgonyknumu(C_UmuKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Nyuukin nyuukin5 = syoriCTL3.createNyuukin();
        nyuukin5.setRenno(11);
        nyuukin5.setTyakkinymd(BizDate.valueOf(20161115));
        nyuukin5.setNyksyoriymd(BizDate.valueOf(20161222));
        nyuukin5.setRyosyuymd(BizDate.valueOf(20160125));
        nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin5.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin nyuukin6 = syoriCTL3.createNyuukin();
        nyuukin6.setRenno(12);
        nyuukin6.setTyakkinymd(BizDate.valueOf(20161116));
        nyuukin6.setNyksyoriymd(BizDate.valueOf(20161221));
        nyuukin6.setRyosyuymd(BizDate.valueOf(20160215));
        nyuukin6.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin6.setSrgonyknumu(C_UmuKbn.NONE);

        HT_Nyuukin nyuukin7 = syoriCTL3.createNyuukin();
        nyuukin7.setRenno(13);
        nyuukin7.setTyakkinymd(BizDate.valueOf(20161117));
        nyuukin7.setNyksyoriymd(BizDate.valueOf(20161220));
        nyuukin7.setRyosyuymd(BizDate.valueOf(20160826));
        nyuukin7.setZenhnknkbn(C_ZenhnknKbn.BLNK);
        nyuukin7.setSrgonyknumu(C_UmuKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean beans = sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu("791112253");

        Assert.assertEquals(beans, null);
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean beans = sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu("791112220");

        Assert.assertEquals(BizDate.valueOf(20161020), beans.getNyksyoriymd());
        Assert.assertEquals(BizDate.valueOf(20161024), beans.getRyosyuymdMin());
        Assert.assertEquals(BizDate.valueOf(20161024), beans.getRyosyuymdMax());
        Assert.assertEquals(BizDate.valueOf(20161025), beans.getTyakkinymdMin());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean beans = sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu("791112246");

        Assert.assertEquals(BizDate.valueOf(20161220), beans.getNyksyoriymd());
        Assert.assertEquals(BizDate.valueOf(20160125), beans.getRyosyuymdMin());
        Assert.assertEquals(BizDate.valueOf(20160826), beans.getRyosyuymdMax());
        Assert.assertEquals(BizDate.valueOf(20161115), beans.getTyakkinymdMin());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void blank1() {

        NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean beans = sinkeiyakuDomManager.getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu("");

        Assert.assertEquals(beans, null);
    }
}

