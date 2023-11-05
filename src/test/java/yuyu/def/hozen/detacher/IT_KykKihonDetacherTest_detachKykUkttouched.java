package yuyu.def.hozen.detacher;

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

import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykUkttouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykUkt kykUkt1 = kykKihon1.createKykUkt();
        kykUkt1.setUktsyukbn(C_UktsyuKbn.SBUKT);
        kykUkt1.setUktsyurenno(11);

        IT_KykUkt kykUkt2 = kykKihon1.createKykUkt();
        kykUkt2.setUktsyukbn(C_UktsyuKbn.STDRSK);
        kykUkt2.setUktsyurenno(12);

        IT_KykUkt kykUkt3 = kykKihon1.createKykUkt();
        kykUkt3.setUktsyukbn(C_UktsyuKbn.NKUKT);
        kykUkt3.setUktsyurenno(13);

        hozenDomManager.insert(kykKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon("11807111118");

        IT_KykKihon entity = IT_KykKihonDetacher.detachKykUkttouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_KykUkt> kykUkts = entity.getKykUkts();

        Assert.assertEquals(3, kykUkts.size());

        IT_KykUkt kykUkt1 = kykUkts.get(0);
        Assert.assertEquals("01", kykUkt1.getKbnkey());
        Assert.assertEquals("11807111118", kykUkt1.getSyono());
        Assert.assertEquals(C_UktsyuKbn.SBUKT, kykUkt1.getUktsyukbn());
        Assert.assertEquals(11, kykUkt1.getUktsyurenno().intValue());

        IT_KykUkt kykUkt2 = kykUkts.get(1);
        Assert.assertEquals("01", kykUkt2.getKbnkey());
        Assert.assertEquals("11807111118", kykUkt2.getSyono());
        Assert.assertEquals(C_UktsyuKbn.STDRSK, kykUkt2.getUktsyukbn());
        Assert.assertEquals(12, kykUkt2.getUktsyurenno().intValue());

        IT_KykUkt kykUkt3 = kykUkts.get(2);
        Assert.assertEquals("01", kykUkt3.getKbnkey());
        Assert.assertEquals("11807111118", kykUkt3.getSyono());
        Assert.assertEquals(C_UktsyuKbn.NKUKT, kykUkt3.getUktsyukbn());
        Assert.assertEquals(13, kykUkt3.getUktsyurenno().intValue());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKykUkttouched(iT_KykKihon));
    }
}
