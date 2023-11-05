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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 入力差異テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getNrkDifsByVrfkinouid {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000002");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000002");
            Assert.assertEquals(0, syoriCtl1.getNrkDifsByVrfkinouid("10003").size());

            HT_NrkDif nrkDif1 = syoriCtl1.createNrkDif();
            nrkDif1.setVrfkinouid("10003");
            nrkDif1.setRenno3keta(102);

            HT_NrkDif nrkDif2 = syoriCtl1.createNrkDif();
            nrkDif2.setVrfkinouid("10003");
            nrkDif2.setRenno3keta(103);

            HT_NrkDif henkin3 = syoriCtl1.createNrkDif();
            henkin3.setVrfkinouid("10003");
            henkin3.setRenno3keta(104);

            HT_NrkDif henkin4 = syoriCtl1.createNrkDif();
            henkin4.setVrfkinouid("10002");
            henkin4.setRenno3keta(101);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000001");

            HT_NrkDif henkin5 = syoriCtl2.createNrkDif();
            henkin5.setVrfkinouid("10001");
            henkin5.setRenno3keta(101);

            sinkeiyakuDomManager.insert(syoriCtl2);
        }
        HT_SyoriCTL syoriCtl3 = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        if (syoriCtl3 == null) {
            syoriCtl3 = new HT_SyoriCTL("10000000003");

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
        List<HT_NrkDif> nrkDifList = syoriCtl.getNrkDifsByVrfkinouid("10005");

        Assert.assertEquals(0, nrkDifList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        List<HT_NrkDif> nrkDifList = syoriCtl.getNrkDifsByVrfkinouid("10001");

        Assert.assertEquals(1, nrkDifList.size());

        Assert.assertEquals("10000000001", nrkDifList.get(0).getMosno());
        Assert.assertEquals(101, nrkDifList.get(0).getRenno3keta().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000002");

        List<HT_NrkDif> nrkDifList = syoriCtl.getNrkDifsByVrfkinouid("10003");

        Assert.assertEquals(3, nrkDifList.size());

        Assert.assertEquals("10000000002", nrkDifList.get(0).getMosno());
        Assert.assertEquals(102, nrkDifList.get(0).getRenno3keta().intValue());

        Assert.assertEquals("10000000002", nrkDifList.get(1).getMosno());
        Assert.assertEquals(103, nrkDifList.get(1).getRenno3keta().intValue());

        Assert.assertEquals("10000000002", nrkDifList.get(2).getMosno());
        Assert.assertEquals(104, nrkDifList.get(2).getRenno3keta().intValue());

    }
    @Test
    @TestOrder(20)
    public void blankCondition() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000003");
        List<HT_NrkDif> nrkDifList = syoriCtl.getNrkDifsByVrfkinouid("");

        Assert.assertEquals(0, nrkDifList.size());
    }
}
