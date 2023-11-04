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
 * 商品特条テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getSyouhnTokujousBySyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000001");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("21", "10000000001");
            Assert.assertEquals(0, kykKihon1.getSyouhnTokujousBySyutkkbn(C_SyutkKbn.SYU).size());

            IT_SyouhnTokujou SyouhnTokujou1 = kykKihon1.createSyouhnTokujou();
            SyouhnTokujou1.setSyutkkbn(C_SyutkKbn.SYU);
            SyouhnTokujou1.setSyouhncd("1001");
            SyouhnTokujou1.setSyouhnsdno(11);
            SyouhnTokujou1.setKyksyouhnrenno(31);

            IT_SyouhnTokujou SyouhnTokujou2 = kykKihon1.createSyouhnTokujou();
            SyouhnTokujou2.setSyutkkbn(C_SyutkKbn.NONE);
            SyouhnTokujou2.setSyouhncd("1001");
            SyouhnTokujou2.setSyouhnsdno(11);
            SyouhnTokujou2.setKyksyouhnrenno(31);

            hozenDomManager.insert(kykKihon1);
        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000002");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("21", "10000000002");

            IT_SyouhnTokujou SyouhnTokujou3 = kykKihon2.createSyouhnTokujou();
            SyouhnTokujou3.setSyutkkbn(C_SyutkKbn.SYU);
            SyouhnTokujou3.setSyouhncd("1001");
            SyouhnTokujou3.setSyouhnsdno(11);
            SyouhnTokujou3.setKyksyouhnrenno(31);

            hozenDomManager.insert(kykKihon2);
        }

        IT_KykKihon kykKihon3 = hozenDomManager.getKykKihon("10000000003");
        if (kykKihon3 == null) {
            kykKihon3 = new IT_KykKihon("22", "10000000003");

            IT_SyouhnTokujou SyouhnTokujou4 = kykKihon3.createSyouhnTokujou();
            SyouhnTokujou4.setSyutkkbn(C_SyutkKbn.SYU);
            SyouhnTokujou4.setSyouhncd("1002");
            SyouhnTokujou4.setSyouhnsdno(12);
            SyouhnTokujou4.setKyksyouhnrenno(32);

            IT_SyouhnTokujou SyouhnTokujou5 = kykKihon3.createSyouhnTokujou();
            SyouhnTokujou5.setSyutkkbn(C_SyutkKbn.SYU);
            SyouhnTokujou5.setSyouhncd("1003");
            SyouhnTokujou5.setSyouhnsdno(13);
            SyouhnTokujou5.setKyksyouhnrenno(33);

            IT_SyouhnTokujou SyouhnTokujou6 = kykKihon3.createSyouhnTokujou();
            SyouhnTokujou6.setSyutkkbn(C_SyutkKbn.SYU);
            SyouhnTokujou6.setSyouhncd("1004");
            SyouhnTokujou6.setSyouhnsdno(14);
            SyouhnTokujou6.setKyksyouhnrenno(34);

            hozenDomManager.insert(kykKihon3);
        }

        IT_KykKihon kykKihon4 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon4 == null) {
            kykKihon4 = new IT_KykKihon("22", "11807111130");

            IT_SyouhnTokujou SyouhnTokujou4 = kykKihon4.createSyouhnTokujou();
            SyouhnTokujou4.setSyutkkbn(C_SyutkKbn.NONE);
            SyouhnTokujou4.setSyouhncd("1005");
            SyouhnTokujou4.setSyouhnsdno(15);
            SyouhnTokujou4.setKyksyouhnrenno(35);

            IT_SyouhnTokujou SyouhnTokujou5 = kykKihon4.createSyouhnTokujou();
            SyouhnTokujou5.setSyutkkbn(C_SyutkKbn.NONE);
            SyouhnTokujou5.setSyouhncd("1006");
            SyouhnTokujou5.setSyouhnsdno(16);
            SyouhnTokujou5.setKyksyouhnrenno(36);

            IT_SyouhnTokujou SyouhnTokujou6 = kykKihon4.createSyouhnTokujou();
            SyouhnTokujou6.setSyutkkbn(C_SyutkKbn.NONE);
            SyouhnTokujou6.setSyouhncd("1007");
            SyouhnTokujou6.setSyouhnsdno(17);
            SyouhnTokujou6.setKyksyouhnrenno(37);

            hozenDomManager.insert(kykKihon4);
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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000002");
        List<IT_SyouhnTokujou> kykKihonList = kykKihon.getSyouhnTokujousBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(0, kykKihonList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        List<IT_SyouhnTokujou> kykKihonList = kykKihon.getSyouhnTokujousBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(1, kykKihonList.size());

        Assert.assertEquals("21", kykKihonList.get(0).getKbnkey());
        Assert.assertEquals("10000000001", kykKihonList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykKihonList.get(0).getSyutkkbn());
        Assert.assertEquals("1001", kykKihonList.get(0).getSyouhncd());
        Assert.assertEquals(11, kykKihonList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(31, kykKihonList.get(0).getKyksyouhnrenno().intValue());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000003");
        List<IT_SyouhnTokujou> kykKihonList = kykKihon.getSyouhnTokujousBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(3, kykKihonList.size());

        Assert.assertEquals("22", kykKihonList.get(0).getKbnkey());
        Assert.assertEquals("10000000003", kykKihonList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykKihonList.get(0).getSyutkkbn());
        Assert.assertEquals("1002", kykKihonList.get(0).getSyouhncd());
        Assert.assertEquals(12, kykKihonList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(32, kykKihonList.get(0).getKyksyouhnrenno().intValue());

        Assert.assertEquals("22", kykKihonList.get(1).getKbnkey());
        Assert.assertEquals("10000000003", kykKihonList.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykKihonList.get(1).getSyutkkbn());
        Assert.assertEquals("1003", kykKihonList.get(1).getSyouhncd());
        Assert.assertEquals(13, kykKihonList.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(33, kykKihonList.get(1).getKyksyouhnrenno().intValue());

        Assert.assertEquals("22", kykKihonList.get(2).getKbnkey());
        Assert.assertEquals("10000000003", kykKihonList.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, kykKihonList.get(2).getSyutkkbn());
        Assert.assertEquals("1004", kykKihonList.get(2).getSyouhncd());
        Assert.assertEquals(14, kykKihonList.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(34, kykKihonList.get(2).getKyksyouhnrenno().intValue());
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_SyouhnTokujou> kykKihonList = kykKihon.getSyouhnTokujousBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(3, kykKihonList.size());

        Assert.assertEquals("22", kykKihonList.get(0).getKbnkey());
        Assert.assertEquals("11807111130", kykKihonList.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykKihonList.get(0).getSyutkkbn());
        Assert.assertEquals("1005", kykKihonList.get(0).getSyouhncd());
        Assert.assertEquals(15, kykKihonList.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(35, kykKihonList.get(0).getKyksyouhnrenno().intValue());

        Assert.assertEquals("22", kykKihonList.get(1).getKbnkey());
        Assert.assertEquals("11807111130", kykKihonList.get(1).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykKihonList.get(1).getSyutkkbn());
        Assert.assertEquals("1006", kykKihonList.get(1).getSyouhncd());
        Assert.assertEquals(16, kykKihonList.get(1).getSyouhnsdno().intValue());
        Assert.assertEquals(36, kykKihonList.get(1).getKyksyouhnrenno().intValue());

        Assert.assertEquals("22", kykKihonList.get(2).getKbnkey());
        Assert.assertEquals("11807111130", kykKihonList.get(2).getSyono());
        Assert.assertEquals(C_SyutkKbn.NONE, kykKihonList.get(2).getSyutkkbn());
        Assert.assertEquals("1007", kykKihonList.get(2).getSyouhncd());
        Assert.assertEquals(17, kykKihonList.get(2).getSyouhnsdno().intValue());
        Assert.assertEquals(37, kykKihonList.get(2).getKyksyouhnrenno().intValue());
    }
}



