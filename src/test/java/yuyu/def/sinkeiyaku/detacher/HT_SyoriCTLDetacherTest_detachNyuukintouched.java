package yuyu.def.sinkeiyaku.detacher;

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

import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HT_SyoriCTLDetacherクラスの、<br />
 * detachNyuukintouched() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLDetacherTest_detachNyuukintouched {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager .class);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Nyuukin nyuukin1 = syoriCTL1.createNyuukin();
        nyuukin1.setMosno("791112220");
        nyuukin1.setRenno(01);

        HT_Nyuukin nyuukin2 = syoriCTL1.createNyuukin();
        nyuukin1.setMosno("791112220");
        nyuukin2.setRenno(02);

        HT_Nyuukin nyuukin3 = syoriCTL1.createNyuukin();
        nyuukin1.setMosno("791112220");
        nyuukin3.setRenno(03);

        sinkeiyakuDomManager.insert(syoriCTL1);

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

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        HT_SyoriCTL entity = HT_SyoriCTLDetacher.detachNyuukintouched(hT_SyoriCTL);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<HT_Nyuukin> NyuukinLst = entity.getNyuukins();

        Assert.assertEquals(3, NyuukinLst.size());

        HT_Nyuukin ht_Nyuukin1 = NyuukinLst.get(0);
        Assert.assertEquals("791112220", ht_Nyuukin1.getMosno());
        Assert.assertEquals(01, ht_Nyuukin1.getRenno().intValue());

        HT_Nyuukin ht_Nyuukin2 = NyuukinLst.get(1);
        Assert.assertEquals("791112220", ht_Nyuukin2.getMosno());
        Assert.assertEquals(02, ht_Nyuukin2.getRenno().intValue());

        HT_Nyuukin ht_Nyuukin3 = NyuukinLst.get(2);
        Assert.assertEquals("791112220", ht_Nyuukin3.getMosno());
        Assert.assertEquals(03, ht_Nyuukin3.getRenno().intValue());

    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        HT_SyoriCTL hT_SyoriCTL = null;

        Assert.assertNull(HT_SyoriCTLDetacher.detachNyuukintouched(hT_SyoriCTL));
    }
}
