package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込点検履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getMostenkenRirekiCountByKetsyacdTnsketsyacd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Long count = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(0), count);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000060");

        HT_MostenkenRireki mostenkenRireki1 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki1.setRenno(1);
        mostenkenRireki1.setTnsketsyacd("ASD123");
        mostenkenRireki1.setKetsyacd("ASD123");

        HT_MostenkenRireki mostenkenRireki2 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki2.setRenno(2);
        mostenkenRireki2.setTnsketsyacd("ASD124");
        mostenkenRireki2.setKetsyacd("ASD124");

        HT_MostenkenRireki mostenkenRireki3 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki3.setRenno(3);
        mostenkenRireki3.setTnsketsyacd("ASD125");
        mostenkenRireki3.setKetsyacd("ASD126");

        HT_MostenkenRireki mostenkenRireki4 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki4.setRenno(4);
        mostenkenRireki4.setTnsketsyacd("ASD122");
        mostenkenRireki4.setKetsyacd("ASD125");

        HT_MostenkenRireki mostenkenRireki5 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki5.setRenno(5);
        mostenkenRireki5.setTnsketsyacd("ASD125");
        mostenkenRireki5.setKetsyacd("ASD125");

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

        Long count = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd("ASD130");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd("ASD123");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd("ASD125");
        Assert.assertEquals(new Long(3), count);

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Long count = sinkeiyakuDomManager.getMostenkenRirekiCountByKetsyacdTnsketsyacd("");
        Assert.assertEquals(new Long(0), count);

    }

}
