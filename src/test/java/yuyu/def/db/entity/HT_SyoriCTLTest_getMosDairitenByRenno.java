package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込代理店テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosDairitenByRenno {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;
    private final static String mosno1 = "10000000060";
    private final static String mosno2 = "10000000070";

    private final static Integer renno1 = 1;
    private final static Integer renno3 = 3;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL(mosno1);
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL(mosno1);
            HT_MosDairiten mosDairiten = syoriCTL1.getMosDairitenByRenno(renno1);
            Assert.assertEquals(null, mosDairiten );

            HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
            mosDairiten1.setRenno(1);

            HT_MosDairiten mosDairiten2 = syoriCTL1.createMosDairiten();
            mosDairiten2.setRenno(2);
            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(mosno2);

        HT_MosDairiten mosDairiten3 = syoriCTL2.createMosDairiten();
        mosDairiten3.setRenno(2);

        sinkeiyakuDomManager.insert(syoriCTL2);
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

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);

        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(renno3);

        Assert.assertEquals(null, mosDairiten);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);

        HT_MosDairiten mosDairiten = syoriCTL.getMosDairitenByRenno(renno1);

        Assert.assertEquals(mosno1, mosDairiten.getMosno());
        Assert.assertEquals(renno1, mosDairiten.getRenno());
    }

}
