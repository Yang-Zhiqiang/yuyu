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

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getNyuukinByMosnoRyosyuymdZenhnknkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinByMosnoRyosyuymdZenhnknkbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn("791112220", BizDate.valueOf(20161128));
        Assert.assertEquals(null, nyuukin);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setRenno(1);
        nyuukin1.setRyosyuymd(BizDate.valueOf(20161128));
        nyuukin1.setZenhnknkbn(C_ZenhnknKbn.SUMI);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin2.setRenno(0);
        nyuukin2.setRyosyuymd(BizDate.valueOf(20161127));
        nyuukin2.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin3.setRenno(2);
        nyuukin3.setRyosyuymd(BizDate.valueOf(20161128));
        nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
        nyuukin4.setRenno(3);
        nyuukin4.setRyosyuymd(BizDate.valueOf(20161128));
        nyuukin4.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        HT_Nyuukin nyuukin5 = syoriCTL1.createNyuukin();
        nyuukin5.setRenno(4);
        nyuukin5.setRyosyuymd(BizDate.valueOf(20161128));
        nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112360");

        HT_Nyuukin nyuukin6 = syoriCTL2.createNyuukin();
        nyuukin6.setRenno(1);
        nyuukin6.setRyosyuymd(BizDate.valueOf(20161128));
        nyuukin6.setZenhnknkbn(C_ZenhnknKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn("791112501", BizDate.valueOf(20161128));
        Assert.assertEquals(null, nyuukin);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn("791112220", BizDate.valueOf(20161128));
        Assert.assertEquals("791112220", nyuukin.getMosno());
        Assert.assertEquals(2, nyuukin.getRenno().intValue());
        Assert.assertEquals(C_ZenhnknKbn.BLNK, nyuukin.getZenhnknkbn());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoRyosyuymdZenhnknkbn("", BizDate.valueOf(20161128));
        Assert.assertEquals(null, nyuukin);

    }

}

