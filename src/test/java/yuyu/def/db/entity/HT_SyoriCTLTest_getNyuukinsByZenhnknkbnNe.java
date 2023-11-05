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
public class HT_SyoriCTLTest_getNyuukinsByZenhnknkbnNe {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000001");
            List<HT_Nyuukin> nyuukinList = syoriCtl1.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);
            Assert.assertEquals(0, nyuukinList.size());

            HT_Nyuukin Nyuukin1 = syoriCtl1.createNyuukin();
            Nyuukin1.setRenno(11);
            Nyuukin1.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin Nyuukin2 = syoriCtl1.createNyuukin();
            Nyuukin2.setRenno(12);
            Nyuukin2.setZenhnknkbn(C_ZenhnknKbn.SUMI);

            HT_Nyuukin Nyuukin7 = syoriCtl1.createNyuukin();
            Nyuukin7.setRenno(13);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000002");

            HT_Nyuukin Nyuukin3 = syoriCtl2.createNyuukin();
            Nyuukin3.setRenno(11);
            Nyuukin3.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }

        HT_SyoriCTL syoriCtl3 = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        if (syoriCtl3 == null) {
            syoriCtl3 = new HT_SyoriCTL("10000000003");

            HT_Nyuukin Nyuukin4 = syoriCtl3.createNyuukin();
            Nyuukin4.setRenno(13);
            Nyuukin4.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin Nyuukin5 = syoriCtl3.createNyuukin();
            Nyuukin5.setRenno(14);
            Nyuukin5.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            HT_Nyuukin Nyuukin6 = syoriCtl3.createNyuukin();
            Nyuukin6.setRenno(15);
            Nyuukin6.setZenhnknkbn(C_ZenhnknKbn.BLNK);

            sinkeiyakuDomManager.insert(syoriCtl3);
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
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.BLNK);

        Assert.assertEquals(0, nyuukinList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

        Assert.assertEquals(1, nyuukinList.size());

        Assert.assertEquals("10000000001", nyuukinList.get(0).getMosno());
        Assert.assertEquals(11, nyuukinList.get(0).getRenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        List<HT_Nyuukin> nyuukinList = syoriCtl.getNyuukinsByZenhnknkbnNe(C_ZenhnknKbn.SUMI);

        Assert.assertEquals(3, nyuukinList.size());

        Assert.assertEquals("10000000003", nyuukinList.get(0).getMosno());
        Assert.assertEquals(13, nyuukinList.get(0).getRenno().intValue());

        Assert.assertEquals("10000000003", nyuukinList.get(1).getMosno());
        Assert.assertEquals(14, nyuukinList.get(1).getRenno().intValue());

        Assert.assertEquals("10000000003", nyuukinList.get(2).getMosno());
        Assert.assertEquals(15, nyuukinList.get(2).getRenno().intValue());
    }
}



