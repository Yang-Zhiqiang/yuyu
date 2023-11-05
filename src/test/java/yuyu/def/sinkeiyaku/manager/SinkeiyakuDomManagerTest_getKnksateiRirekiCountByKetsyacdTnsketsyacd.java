package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_KnksateiRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 環境査定履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKnksateiRirekiCountByKetsyacdTnsketsyacd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000060");

        HT_KnksateiRireki knksateiRireki1 = syoriCTL1.createKnksateiRireki();
        knksateiRireki1.setRenno(1);
        knksateiRireki1.setTnsketsyacd("ASD123");
        knksateiRireki1.setKetsyacd("ASD123");

        HT_KnksateiRireki knksateiRireki2 = syoriCTL1.createKnksateiRireki();
        knksateiRireki2.setRenno(2);
        knksateiRireki2.setTnsketsyacd("ASD124");
        knksateiRireki2.setKetsyacd("ASD124");

        HT_KnksateiRireki knksateiRireki3 = syoriCTL1.createKnksateiRireki();
        knksateiRireki3.setRenno(3);
        knksateiRireki3.setTnsketsyacd("ASD125");
        knksateiRireki3.setKetsyacd("ASD126");

        HT_KnksateiRireki knksateiRireki4 = syoriCTL1.createKnksateiRireki();
        knksateiRireki4.setRenno(4);
        knksateiRireki4.setTnsketsyacd("ASD122");
        knksateiRireki4.setKetsyacd("ASD125");

        HT_KnksateiRireki knksateiRireki5 = syoriCTL1.createKnksateiRireki();
        knksateiRireki5.setRenno(5);
        knksateiRireki5.setTnsketsyacd("ASD125");
        knksateiRireki5.setKetsyacd("ASD125");

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

        Long count = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd("ASD130");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd("ASD125");
        Assert.assertEquals(new Long(3), count);

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getKnksateiRirekiCountByKetsyacdTnsketsyacd("");
        Assert.assertEquals(new Long(0), count);

    }

}
