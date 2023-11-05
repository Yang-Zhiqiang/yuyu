package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinsByZenhnknkbnBlank {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("791112220");
            List<HT_Nyuukin> nyuukinList = syoriCtl1.getNyuukinsByZenhnknkbnBlank();
            Assert.assertEquals(0, nyuukinList.size());

            HT_Nyuukin nyuukin1 = syoriCtl1.createNyuukin();
            nyuukin1.setRenno(11);
            nyuukin1.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin2 = syoriCtl1.createNyuukin();
            nyuukin2.setRenno(12);
            nyuukin2.setZenhnknkbn(C_ZenhnknKbn.SUMI);

            sinkeiyakuDomManager.insert(syoriCtl1);

            HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

            sinkeiyakuDomManager.insert(syoriCTL2);

            HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

            HT_Nyuukin nyuukin3 = syoriCTL3.createNyuukin();
            nyuukin3.setRenno(13);
            nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin4 = syoriCTL3.createNyuukin();
            nyuukin4.setRenno(14);
            nyuukin4.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin nyuukin5 = syoriCTL3.createNyuukin();
            nyuukin5.setRenno(15);
            nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            sinkeiyakuDomManager.insert(syoriCTL3);
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
    @Transactional
    public void noResult1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112238");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnBlank();

        Assert.assertEquals(0, nyuukinList.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112220");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnBlank();

        Assert.assertEquals(1, nyuukinList.size());

        Assert.assertEquals("791112220", nyuukinList.get(0).getMosno());
        Assert.assertEquals(11, nyuukinList.get(0).getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("791112246");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnBlank();

        Assert.assertEquals(3, nyuukinList.size());

        Assert.assertEquals("791112246", nyuukinList.get(0).getMosno());
        Assert.assertEquals(13, nyuukinList.get(0).getRenno().intValue());

        Assert.assertEquals("791112246", nyuukinList.get(1).getMosno());
        Assert.assertEquals(14, nyuukinList.get(1).getRenno().intValue());

        Assert.assertEquals("791112246", nyuukinList.get(2).getMosno());
        Assert.assertEquals(15, nyuukinList.get(2).getRenno().intValue());
    }
}
