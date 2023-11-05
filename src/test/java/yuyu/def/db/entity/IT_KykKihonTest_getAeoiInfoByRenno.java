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
 * ＡＥＯＩ情報テーブル、<br />
 * 連番を指定して、<br />
 * ＡＥＯＩ情報テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getAeoiInfoByRenno {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("01","11807111118");
            Assert.assertEquals(null, kykKihon.getAeoiInfoByRenno(10));

            IT_AeoiInfo aeoiInfo1 = kykKihon.createAeoiInfo();
            aeoiInfo1.setRenno(10);

            IT_AeoiInfo aeoiInfo2 = kykKihon.createAeoiInfo();
            aeoiInfo2.setRenno(11);

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_AeoiInfo aeoiInfo = kykKihon.getAeoiInfoByRenno(12);

        Assert.assertEquals(null, aeoiInfo);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_AeoiInfo aeoiInfo = kykKihon.getAeoiInfoByRenno(10);

        Assert.assertEquals("01", aeoiInfo.getKbnkey());
        Assert.assertEquals("11807111118", aeoiInfo.getSyono());
        Assert.assertEquals(10, aeoiInfo.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_AeoiInfo aeoiInfo = kykKihon.getAeoiInfoByRenno(10);

        Assert.assertEquals("01", aeoiInfo.getKbnkey());
        Assert.assertEquals("11807111118", aeoiInfo.getSyono());
        Assert.assertEquals(10, aeoiInfo.getRenno().intValue());
        Assert.assertEquals(null, aeoiInfo.getAeoisyorisosikicd());

        aeoiInfo.setAeoisyorisosikicd("100");
        hozenDomManager.update(kykKihon);
    }

    @Test
    @TestOrder(40)
    public void normal3() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_AeoiInfo aeoiInfo = kykKihon.getAeoiInfoByRenno(10);

        Assert.assertEquals("01", aeoiInfo.getKbnkey());
        Assert.assertEquals("11807111118", aeoiInfo.getSyono());
        Assert.assertEquals(10, aeoiInfo.getRenno().intValue());
        Assert.assertEquals("100", aeoiInfo.getAeoisyorisosikicd());

    }
}
