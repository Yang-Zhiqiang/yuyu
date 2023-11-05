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

import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入金テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNyuukinsByNyknsyubetu {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCTL1.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.BLNK).size());

            HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
            nyuukin1.setRenno(1);
            nyuukin1.setNyknsyubetu(C_NyknsyubetuKbn.BLNK);

            HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
            nyuukin2.setRenno(2);
            nyuukin2.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);

            HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
            nyuukin3.setRenno(3);
            nyuukin3.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);

            HT_Nyuukin nyuukin4 = syoriCTL1.createNyuukin();
            nyuukin4.setRenno(4);
            nyuukin4.setNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);

            sinkeiyakuDomManager.insert(syoriCTL1);
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.CONVENIENCE);

        Assert.assertEquals(0, nyuukinLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.BLNK);

        Assert.assertEquals(1, nyuukinLst.size());
        Assert.assertEquals("10000000060", nyuukinLst.get(0).getMosno());
        Assert.assertEquals(1, nyuukinLst.get(0).getRenno().intValue());
        Assert.assertEquals(C_NyknsyubetuKbn.BLNK, nyuukinLst.get(0).getNyknsyubetu());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);

        Assert.assertEquals(3, nyuukinLst.size());

        Assert.assertEquals("10000000060", nyuukinLst.get(0).getMosno());
        Assert.assertEquals("10000000060", nyuukinLst.get(1).getMosno());
        Assert.assertEquals("10000000060", nyuukinLst.get(2).getMosno());

        Assert.assertEquals(2, nyuukinLst.get(0).getRenno().intValue());
        Assert.assertEquals(3, nyuukinLst.get(1).getRenno().intValue());
        Assert.assertEquals(4, nyuukinLst.get(2).getRenno().intValue());

        Assert.assertEquals(C_NyknsyubetuKbn.HURIKOMI, nyuukinLst.get(0).getNyknsyubetu());
        Assert.assertEquals(C_NyknsyubetuKbn.HURIKOMI, nyuukinLst.get(1).getNyknsyubetu());
        Assert.assertEquals(C_NyknsyubetuKbn.HURIKOMI, nyuukinLst.get(2).getNyknsyubetu());

        List<HT_Nyuukin> hT_Nyuukins = syoriCTL.getNyuukins();
        hT_Nyuukins.removeAll(nyuukinLst);
        sinkeiyakuDomManager.update(syoriCTL);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_Nyuukin> nyuukinLst = syoriCTL.getNyuukinsByNyknsyubetu(C_NyknsyubetuKbn.HURIKOMI);

        Assert.assertEquals(0, nyuukinLst.size());

    }
}
