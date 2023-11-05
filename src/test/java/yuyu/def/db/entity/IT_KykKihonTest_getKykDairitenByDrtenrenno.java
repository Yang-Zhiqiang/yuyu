package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約代理店テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykDairitenByDrtenrenno {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("11", "11807111118");
            Assert.assertEquals(null, kykKihon1.getKykDairitenByDrtenrenno(1));

            IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
            kykDairiten1.setDrtenrenno(1);

            IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
            kykDairiten2.setDrtenrenno(2);

            hozenDomManager.insert(kykKihon1);

        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(3);

        Assert.assertEquals(null, kykDairiten);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_KykDairiten kykDairiten = kykKihon.getKykDairitenByDrtenrenno(1);

        Assert.assertEquals("11807111118", kykDairiten.getSyono());
        Assert.assertEquals(1, kykDairiten.getDrtenrenno().intValue());
        Assert.assertEquals("11", kykDairiten.getKbnkey());
    }

}
