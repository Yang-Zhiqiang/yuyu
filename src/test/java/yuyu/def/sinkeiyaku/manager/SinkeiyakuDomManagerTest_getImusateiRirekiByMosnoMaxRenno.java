package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_ImusateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医務査定履歴テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getImusateiRirekiByMosnoMaxRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno("10000000060");
        Assert.assertEquals(null, imusateiRireki);

        HT_SyoriCTL syoriCtl1 = sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCtl1 == null) {
            syoriCtl1 = new HT_SyoriCTL("10000000060");

            HT_ImusateiRireki imusateiRireki1 = syoriCtl1.createImusateiRireki();
            imusateiRireki1.setRenno(1);

            HT_ImusateiRireki imusateiRireki2 = syoriCtl1.createImusateiRireki();
            imusateiRireki2.setRenno(2);

            HT_ImusateiRireki imusateiRireki3 = syoriCtl1.createImusateiRireki();
            imusateiRireki3.setRenno(3);

            sinkeiyakuDomManager.insert(syoriCtl1);
        }

        HT_SyoriCTL syoriCtl2 = sinkeiyakuDomManager.getSyoriCTL("10000000070");
        if (syoriCtl2 == null) {
            syoriCtl2 = new HT_SyoriCTL("10000000070");

            HT_ImusateiRireki imusateiRireki4 = syoriCtl2.createImusateiRireki();
            imusateiRireki4.setRenno(4);

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

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno("10000000080");
        Assert.assertEquals(null, imusateiRireki);

    }

    @Test
    @TestOrder(20)
    public void normal2() {

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno("10000000060");
        Assert.assertEquals("10000000060", imusateiRireki.getMosno());
        Assert.assertEquals(3, imusateiRireki.getRenno().intValue());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        HT_ImusateiRireki imusateiRireki = sinkeiyakuDomManager.getImusateiRirekiByMosnoMaxRenno("");
        Assert.assertEquals(null, imusateiRireki);

    }

}
