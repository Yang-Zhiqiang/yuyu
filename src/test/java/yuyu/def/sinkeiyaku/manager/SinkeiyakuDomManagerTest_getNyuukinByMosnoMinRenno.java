package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

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
 * 入金テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getNyuukinByMosnoMinRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMinRenno("791112220");
        Assert.assertEquals(null, nyuukin);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("791112220");

            HT_Nyuukin nyuukin1 = syoriCtl1.createNyuukin();
            nyuukin1.setRenno(2);
            nyuukin1.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin2 = syoriCtl1.createNyuukin();
            nyuukin2.setRenno(3);
            nyuukin2.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin3 = syoriCtl1.createNyuukin();
            nyuukin3.setRenno(4);
            nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin4 = syoriCtl1.createNyuukin();
            nyuukin4.setRenno(1);
            nyuukin4.setZenhnknkbn(C_ZenhnknKbn.SUMI);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("791112360");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("791112360");

            HT_Nyuukin nyuukin5 = syoriCtl2.createNyuukin();
            nyuukin5.setRenno(1);
            nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }
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

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMinRenno("791112501");
        Assert.assertEquals(null, nyuukin);

    }

    @Test
    @TestOrder(20)
    public void normal2() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMinRenno("791112220");
        Assert.assertEquals("791112220", nyuukin.getMosno());
        Assert.assertEquals(2, nyuukin.getRenno().intValue());
        Assert.assertEquals(C_ZenhnknKbn.BLNK, nyuukin.getZenhnknkbn());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_Nyuukin nyuukin = sinkeiyakuDomManager.getNyuukinByMosnoMinRenno("");
        Assert.assertEquals(null, nyuukin);

    }

}
