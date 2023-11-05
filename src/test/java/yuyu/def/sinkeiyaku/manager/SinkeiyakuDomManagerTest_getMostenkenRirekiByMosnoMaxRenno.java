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
public class SinkeiyakuDomManagerTest_getMostenkenRirekiByMosnoMaxRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno("1000000001");
        Assert.assertEquals(null, mostenkenRireki);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("1000000001");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("1000000001");

            HT_MostenkenRireki mostenkenRireki1 = syoriCTL1.createMostenkenRireki();
            mostenkenRireki1.setRenno(Integer.valueOf(2));

            HT_MostenkenRireki mostenkenRireki2 = syoriCTL1.createMostenkenRireki();
            mostenkenRireki2.setRenno(Integer.valueOf(3));

            HT_MostenkenRireki mostenkenRireki3 = syoriCTL1.createMostenkenRireki();
            mostenkenRireki3.setRenno(Integer.valueOf(4));

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = sinkeiyakuDomManager.getSyoriCTL("1000000003");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("1000000003");

            HT_MostenkenRireki mostenkenRireki4 = syoriCTL2.createMostenkenRireki();
            mostenkenRireki4.setRenno(Integer.valueOf(5));

            sinkeiyakuDomManager.insert(syoriCTL2);
        }

        HT_SyoriCTL syoriCTL3 = sinkeiyakuDomManager.getSyoriCTL("1000000002");
        if (syoriCTL3 == null) {
            syoriCTL3 = new HT_SyoriCTL("1000000002");

            sinkeiyakuDomManager.insert(syoriCTL3);
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
    @Transactional
    public void noResult1() {
        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno("1000000002");
        Assert.assertEquals(null, mostenkenRireki);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {
        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno("1000000001");
        Assert.assertEquals("1000000001", mostenkenRireki.getMosno());
        Assert.assertEquals(Integer.valueOf(4), mostenkenRireki.getRenno());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void blank1() {
        HT_MostenkenRireki mostenkenRireki = sinkeiyakuDomManager.getMostenkenRirekiByMosnoMaxRenno("");
        Assert.assertEquals(null, mostenkenRireki);
    }

}
