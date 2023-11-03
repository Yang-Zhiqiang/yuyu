package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約確認テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKykKakByMosnoMaxRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno("10000000060");
        Assert.assertEquals(null, kykKak);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000060");

            HT_KykKak kykKak1 = syoriCtl1.createKykKak();
            kykKak1.setRenno(1);

            HT_KykKak kykKak2 = syoriCtl1.createKykKak();
            kykKak2.setRenno(2);

            HT_KykKak kykKak3 = syoriCtl1.createKykKak();
            kykKak3.setRenno(3);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000070");

            HT_KykKak kykKak4 = syoriCtl2.createKykKak();
            kykKak4.setRenno(1);

            sinkeiyakuDomManager.insert(syoriCtl2);
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

        HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno("10000000080");
        Assert.assertEquals(null, kykKak);

    }

    @Test
    @TestOrder(20)
    public void normal2() {

        HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno("10000000060");
        Assert.assertEquals("10000000060", kykKak.getMosno());
        Assert.assertEquals(3, kykKak.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_KykKak kykKak = sinkeiyakuDomManager.getKykKakByMosnoMaxRenno("");
        Assert.assertEquals(null, kykKak);

    }

}
