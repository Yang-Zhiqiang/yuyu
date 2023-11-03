package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

/**
 * 契約確認テーブルのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class HT_SyoriCTLTest_getKykKakByRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000001");
            Assert.assertEquals(null, syoriCtl1.getKykKakByRenno(1));

            HT_KykKak kykKak1 = syoriCtl1.createKykKak();
            kykKak1.setRenno(1);
            kykKak1.setKykkaktantcd("kk00");

            HT_KykKak kykKak2 = syoriCtl1.createKykKak();
            kykKak2.setRenno(2);
            kykKak2.setKykkaktantcd("kk01");


            sinkeiyakuDomManager.insert(syoriCtl1);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        HT_KykKak kykKak = syoriCtl.getKykKakByRenno(3);

        Assert.assertEquals(null, kykKak);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        HT_KykKak kykKak = syoriCtl.getKykKakByRenno(1);

        Assert.assertEquals("10000000001", kykKak.getMosno());
        Assert.assertEquals(1, kykKak.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        HT_KykKak kykKak = syoriCtl.getKykKakByRenno(2);

        Assert.assertEquals("10000000001", kykKak.getMosno());
        Assert.assertEquals(2, kykKak.getRenno().intValue());
        Assert.assertEquals("kk01", kykKak.getKykkaktantcd());

        kykKak.setKykkaktantcd("kk02");
        sinkeiyakuDomManager.update(syoriCtl);
    }

    @Test
    @TestOrder(40)
    public void normal4() {
        HT_SyoriCTL syoriCtl = sinkeiyakuDomManager.getSyoriCTL("10000000001");
        HT_KykKak kykKak = syoriCtl.getKykKakByRenno(2);

        Assert.assertEquals("10000000001", kykKak.getMosno());
        Assert.assertEquals(2, kykKak.getRenno().intValue());
        Assert.assertEquals("kk02", kykKak.getKykkaktantcd());

    }
}
