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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKykSyouhnsByKouryokuhasseiymdGt {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","10000000060");
            Assert.assertEquals(0, kykKihon.getKykSyouhnsByKouryokuhasseiymdGt(BizDate.valueOf(20160111)).size());
            IT_KykSyouhn kykSyouhn = kykKihon.createKykSyouhn();
            kykSyouhn.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn.setSyouhncd("A10");
            kykSyouhn.setSyouhnsdno(21);
            kykSyouhn.setKyksyouhnrenno(1);
            kykSyouhn.setKouryokuhasseiymd(BizDate.valueOf(20160111));

            IT_KykSyouhn kykSyouhn1 = kykKihon.createKykSyouhn();
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn1.setSyouhncd("A10");
            kykSyouhn1.setSyouhnsdno(22);
            kykSyouhn1.setKyksyouhnrenno(2);
            kykSyouhn1.setKouryokuhasseiymd(BizDate.valueOf(20160112));

            IT_KykSyouhn kykSyouhn2 = kykKihon.createKykSyouhn();
            kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn2.setSyouhncd("A10");
            kykSyouhn2.setSyouhnsdno(23);
            kykSyouhn2.setKyksyouhnrenno(3);
            kykSyouhn2.setKouryokuhasseiymd(BizDate.valueOf(20160113));

            IT_KykSyouhn kykSyouhn3 = kykKihon.createKykSyouhn();
            kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn3.setSyouhncd("A10");
            kykSyouhn3.setSyouhnsdno(24);
            kykSyouhn3.setKyksyouhnrenno(4);
            kykSyouhn3.setKouryokuhasseiymd(BizDate.valueOf(20160114));

            IT_KykSyouhn kykSyouhn4 = kykKihon.createKykSyouhn();
            kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn4.setSyouhncd("A10");
            kykSyouhn4.setSyouhnsdno(25);
            kykSyouhn4.setKyksyouhnrenno(5);
            kykSyouhn4.setKouryokuhasseiymd(BizDate.valueOf(20160115));

            IT_KykSyouhn kykSyouhn5 = kykKihon.createKykSyouhn();
            kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn5.setSyouhncd("A10");
            kykSyouhn5.setSyouhnsdno(26);
            kykSyouhn5.setKyksyouhnrenno(6);
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
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsByKouryokuhasseiymdGt(BizDate.valueOf(20160116));
        Assert.assertEquals(0, kykSyouhnList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsByKouryokuhasseiymdGt(BizDate.valueOf(20160114));
        Assert.assertEquals(1, kykSyouhnList.size());

        Assert.assertEquals("10", kykSyouhnList.get(0).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(0).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(0).getSyouhncd());
        Assert.assertEquals(25, kykSyouhnList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(5, kykSyouhnList.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160115), kykSyouhnList.get(0).getKouryokuhasseiymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsByKouryokuhasseiymdGt(BizDate.valueOf(20160112));
        Assert.assertEquals(3, kykSyouhnList.size());

        Assert.assertEquals("10", kykSyouhnList.get(0).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(0).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(0).getSyouhncd());
        Assert.assertEquals(23, kykSyouhnList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(3, kykSyouhnList.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160113), kykSyouhnList.get(0).getKouryokuhasseiymd());

        Assert.assertEquals("10", kykSyouhnList.get(1).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(1).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(1).getSyouhncd());
        Assert.assertEquals(24, kykSyouhnList.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(4, kykSyouhnList.get(1).getKyksyouhnrenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160114), kykSyouhnList.get(1).getKouryokuhasseiymd());

        Assert.assertEquals("10", kykSyouhnList.get(2).getKbnkey());
        Assert.assertEquals("10000000060", kykSyouhnList.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykSyouhnList.get(2).getSyutkkbn());
        Assert.assertEquals("A10", kykSyouhnList.get(2).getSyouhncd());
        Assert.assertEquals(25, kykSyouhnList.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(5, kykSyouhnList.get(2).getKyksyouhnrenno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160115), kykSyouhnList.get(2).getKouryokuhasseiymd());
    }
}
