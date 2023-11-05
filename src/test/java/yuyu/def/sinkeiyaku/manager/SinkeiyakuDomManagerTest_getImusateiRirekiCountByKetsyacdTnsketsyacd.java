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
 * 医務査定履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getImusateiRirekiCountByKetsyacdTnsketsyacd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000060");

        HT_ImusateiRireki imusateiRireki1 = syoriCTL1.createImusateiRireki();
        imusateiRireki1.setRenno(1);
        imusateiRireki1.setTnsketsyacd("ASD123");
        imusateiRireki1.setKetsyacd("ASD123");

        HT_ImusateiRireki imusateiRireki2 = syoriCTL1.createImusateiRireki();
        imusateiRireki2.setRenno(2);
        imusateiRireki2.setTnsketsyacd("ASD124");
        imusateiRireki2.setKetsyacd("ASD124");

        HT_ImusateiRireki imusateiRireki3 = syoriCTL1.createImusateiRireki();
        imusateiRireki3.setRenno(3);
        imusateiRireki3.setTnsketsyacd("ASD125");
        imusateiRireki3.setKetsyacd("ASD126");

        HT_ImusateiRireki imusateiRireki4 = syoriCTL1.createImusateiRireki();
        imusateiRireki4.setRenno(4);
        imusateiRireki4.setTnsketsyacd("ASD122");
        imusateiRireki4.setKetsyacd("ASD125");

        HT_ImusateiRireki imusateiRireki5 = syoriCTL1.createImusateiRireki();
        imusateiRireki5.setRenno(5);
        imusateiRireki5.setTnsketsyacd("ASD125");
        imusateiRireki5.setKetsyacd("ASD125");

        sinkeiyakuDomManager.insert(syoriCTL1);
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

        Long count = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd("ASD130");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd("ASD125");
        Assert.assertEquals(new Long(3), count);

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getImusateiRirekiCountByKetsyacdTnsketsyacd("");
        Assert.assertEquals(new Long(0), count);

    }

}
