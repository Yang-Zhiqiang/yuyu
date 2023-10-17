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
 * 推移表テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getSuiihyousByTyouhyouymd {
    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111130");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10","11807111130");
            List<IT_Suiihyou> suiihyouLst = kykKihon1.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160223"));
            Assert.assertEquals(0, suiihyouLst.size());

            IT_Suiihyou suiihyou1 = kykKihon1.createSuiihyou();
            suiihyou1.setTyouhyouymd(BizDate.valueOf("20160223"));
            suiihyou1.setKeikanensuu(1);

            IT_Suiihyou suiihyou2 = kykKihon1.createSuiihyou();
            suiihyou2.setTyouhyouymd(BizDate.valueOf("20160222"));
            suiihyou2.setKeikanensuu(1);

            IT_Suiihyou suiihyou3 = kykKihon1.createSuiihyou();
            suiihyou3.setTyouhyouymd(BizDate.valueOf("20160222"));
            suiihyou3.setKeikanensuu(2);

            IT_Suiihyou suiihyou4 = kykKihon1.createSuiihyou();
            suiihyou4.setTyouhyouymd(BizDate.valueOf("20160222"));
            suiihyou4.setKeikanensuu(3);

            IT_Suiihyou suiihyou5 = kykKihon1.createSuiihyou();
            suiihyou5.setTyouhyouymd(BizDate.valueOf("20160224"));
            suiihyou5.setKeikanensuu(1);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("10","11807111118");
            List<IT_Suiihyou> suiihyouLst = kykKihon2.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160222"));
            Assert.assertEquals(0, suiihyouLst.size());

            IT_Suiihyou suiihyou6 = kykKihon2.createSuiihyou();
            suiihyou6.setTyouhyouymd(BizDate.valueOf("20160222"));
            suiihyou6.setKeikanensuu(1);

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
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160220"));
        Assert.assertEquals(0, suiihyouLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160223"));
        Assert.assertEquals(1, suiihyouLst.size());

        Assert.assertEquals("10", suiihyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", suiihyouLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(1), suiihyouLst.get(0).getKeikanensuu());
        Assert.assertEquals(BizDate.valueOf("20160223"), suiihyouLst.get(0).getTyouhyouymd());

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");
        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160222"));
        Assert.assertEquals(3, suiihyouLst.size());

        Assert.assertEquals("10", suiihyouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111130", suiihyouLst.get(0).getSyono());
        Assert.assertEquals(Integer.valueOf(1), suiihyouLst.get(0).getKeikanensuu());
        Assert.assertEquals(BizDate.valueOf("20160222"), suiihyouLst.get(0).getTyouhyouymd());

        Assert.assertEquals("10", suiihyouLst.get(1).getKbnkey());
        Assert.assertEquals("11807111130", suiihyouLst.get(1).getSyono());
        Assert.assertEquals(Integer.valueOf(2), suiihyouLst.get(1).getKeikanensuu());
        Assert.assertEquals(BizDate.valueOf("20160222"), suiihyouLst.get(1).getTyouhyouymd());

        Assert.assertEquals("10", suiihyouLst.get(2).getKbnkey());
        Assert.assertEquals("11807111130", suiihyouLst.get(2).getSyono());
        Assert.assertEquals(Integer.valueOf(3), suiihyouLst.get(2).getKeikanensuu());
        Assert.assertEquals(BizDate.valueOf("20160222"), suiihyouLst.get(2).getTyouhyouymd());

        List<IT_Suiihyou> iT_Suiihyou = kykKihon.getSuiihyous();
        iT_Suiihyou.removeAll(suiihyouLst);
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111130");

        List<IT_Suiihyou> suiihyouLst = kykKihon.getSuiihyousByTyouhyouymd(BizDate.valueOf("20160222"));

        Assert.assertEquals(0, suiihyouLst.size());

    }

}
