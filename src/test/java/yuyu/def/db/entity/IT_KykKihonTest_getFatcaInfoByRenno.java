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
 * ＦＡＴＣＡ情報テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getFatcaInfoByRenno {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","10000000060");
            Assert.assertEquals(null, kykKihon.getFatcaInfoByRenno(10));

            IT_FatcaInfo fatcaInfo = kykKihon.createFatcaInfo();
            fatcaInfo.setRenno(10);

            IT_FatcaInfo fatcaInfo1 = kykKihon.createFatcaInfo();
            fatcaInfo1.setRenno(11);

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
        IT_FatcaInfo fatcaInfo = kykKihon.getFatcaInfoByRenno(12);

        Assert.assertEquals(null, fatcaInfo);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_FatcaInfo fatcaInfo = kykKihon.getFatcaInfoByRenno(10);

        Assert.assertEquals("10", fatcaInfo.getKbnkey());
        Assert.assertEquals("10000000060", fatcaInfo.getSyono());
        Assert.assertEquals(10, fatcaInfo.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_FatcaInfo fatcaInfo = kykKihon.getFatcaInfoByRenno(10);

        Assert.assertEquals("10", fatcaInfo.getKbnkey());
        Assert.assertEquals("10000000060", fatcaInfo.getSyono());
        Assert.assertEquals(10, fatcaInfo.getRenno().intValue());
        Assert.assertEquals(null, fatcaInfo.getSyorisosikicd());

        fatcaInfo.setSyorisosikicd("100");
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000060");
        IT_FatcaInfo fatcaInfo = kykKihon.getFatcaInfoByRenno(10);

        Assert.assertEquals("10", fatcaInfo.getKbnkey());
        Assert.assertEquals("10000000060", fatcaInfo.getSyono());
        Assert.assertEquals(10, fatcaInfo.getRenno().intValue());
        Assert.assertEquals("100", fatcaInfo.getSyorisosikicd());

    }
}
