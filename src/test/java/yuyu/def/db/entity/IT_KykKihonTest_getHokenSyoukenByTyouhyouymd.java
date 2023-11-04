package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険証券テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getHokenSyoukenByTyouhyouymd {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "11807111130");

            IT_HokenSyouken hokenSyouken = kykKihon1.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20160220"));
            Assert.assertEquals(null, hokenSyouken);

            IT_HokenSyouken hokenSyouken1 = kykKihon1.createHokenSyouken();
            hokenSyouken1.setTyouhyouymd(BizDate.valueOf("20160220"));

            IT_HokenSyouken hokenSyouken2 = kykKihon1.createHokenSyouken();
            hokenSyouken2.setTyouhyouymd(BizDate.valueOf("20160221"));

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10", "11807111118");

            IT_HokenSyouken hokenSyouken3 = kykKihon2.createHokenSyouken();
            hokenSyouken3.setTyouhyouymd(BizDate.valueOf("20160220"));

            hozenDomManager.insert(kykKihon2);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20160224"));
        Assert.assertEquals(null, hokenSyouken);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20160220"));

        Assert.assertEquals("10", hokenSyouken.getKbnkey());
        Assert.assertEquals("11807111130", hokenSyouken.getSyono());
        Assert.assertEquals(BizDate.valueOf("20160220"), hokenSyouken.getTyouhyouymd());

        List<IT_HokenSyouken> iT_HokenSyouken = kykKihon.getHokenSyoukens();
        iT_HokenSyouken.remove(hokenSyouken);
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf("20160220"));

        Assert.assertEquals(null, hokenSyouken);

    }

}
