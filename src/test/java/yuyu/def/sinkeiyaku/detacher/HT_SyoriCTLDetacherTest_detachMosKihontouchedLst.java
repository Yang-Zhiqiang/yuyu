package yuyu.def.sinkeiyaku.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HT_SyoriCTLDetacherクラスの、<br />
 * detachMosKihontouched() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachMosKihontouchedLst {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        syoriCTL1.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        syoriCTL2.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        syoriCTL3.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager .class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<HT_SyoriCTL> syoriCTLList = sinkeiyakuDomManager.getAllSyoriCTL();

        List<HT_SyoriCTL> entityList = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCTLList);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for (HT_SyoriCTL entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        Assert.assertEquals(3, syoriCTLList.size());

        Assert.assertEquals("791112220", syoriCTLList.get(0).getMosKihon().getMosno());
        Assert.assertEquals("791112238", syoriCTLList.get(1).getMosKihon().getMosno());
        Assert.assertEquals("791112246", syoriCTLList.get(2).getMosKihon().getMosno());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<HT_SyoriCTL> syoriCTLList = new ArrayList<>();
        syoriCTLList.add(null);
        syoriCTLList.add(null);

        List<HT_SyoriCTL> entityList = HT_SyoriCTLDetacher.detachMosKihontouched(syoriCTLList);

        for (HT_SyoriCTL entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
