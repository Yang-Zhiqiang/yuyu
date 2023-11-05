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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykSyouhnsBySyutkkbn {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","10000000060");
            Assert.assertEquals(0, kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).size());
            IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("A10");
            kykSyouhn.setSyouhnsdno(21);
            kykSyouhn.setKyksyouhnrenno(1);

            IT_KykSyouhn kykSyouhn1 = kykKihon.createKykSyouhn();
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn1.setSyouhncd("A10");
            kykSyouhn1.setSyouhnsdno(22);
            kykSyouhn1.setKyksyouhnrenno(2);

            IT_KykSyouhn kykSyouhn2 = kykKihon.createKykSyouhn();
            kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn2.setSyouhncd("A10");
            kykSyouhn2.setSyouhnsdno(23);
            kykSyouhn2.setKyksyouhnrenno(3);

            IT_KykSyouhn kykSyouhn3 = kykKihon.createKykSyouhn();
            kykSyouhn3.setSyutkkbn(C_SyutkKbn.TK);
            kykSyouhn3.setSyouhncd("A10");
            kykSyouhn3.setSyouhnsdno(24);
            kykSyouhn3.setKyksyouhnrenno(4);

            hozenDomManager.insert(kykKihon);
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.NONE);
        Assert.assertEquals(0, kykSyouhnList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        Assert.assertEquals(1, kykSyouhnList.size());

        Assert.assertEquals("10", kykSyouhnList.get(0).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.TK, kykSyouhnList.get(0).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(0).getSyouhncd());
        Assert.assertEquals(24, kykSyouhnList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(4, kykSyouhnList.get(0).getKyksyouhnrenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        Assert.assertEquals(3, kykSyouhnList.size());

        Assert.assertEquals("10", kykSyouhnList.get(0).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(0).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(0).getSyouhncd());
        Assert.assertEquals(21, kykSyouhnList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, kykSyouhnList.get(0).getKyksyouhnrenno().intValue());

        Assert.assertEquals("10", kykSyouhnList.get(1).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(1).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(1).getSyouhncd());
        Assert.assertEquals(22, kykSyouhnList.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(2, kykSyouhnList.get(1).getKyksyouhnrenno().intValue());

        Assert.assertEquals("10", kykSyouhnList.get(2).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(2).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(2).getSyouhncd());
        Assert.assertEquals(23, kykSyouhnList.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(3, kykSyouhnList.get(2).getKyksyouhnrenno().intValue());
    }
}
