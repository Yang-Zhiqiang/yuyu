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
 * 返金テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getHenkinByRenno {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 = sinkeiyakuDomManager.getSyoriCTL("791112220");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("791112220");
            HT_Henkin henkin = syoriCTL1.getHenkinByRenno(10);
            Assert.assertEquals(null, henkin);

            HT_Henkin henkin1 = syoriCTL1.createHenkin();
            henkin1.setRenno(10);

            HT_Henkin henkin2 = syoriCTL1.createHenkin();
            henkin2.setRenno(14);

            sinkeiyakuDomManager.insert(syoriCTL1);

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
    public void noResult() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        HT_Henkin hT_Henkin =hT_SyoriCTL.getHenkinByRenno(11);

        Assert.assertEquals(null, hT_Henkin);
    }

    @Test
    @TestOrder(20)
    public void normal() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");

        HT_Henkin hT_Henkin =hT_SyoriCTL.getHenkinByRenno(10);

        Assert.assertEquals("791112220", hT_Henkin.getMosno());
        Assert.assertEquals(10, hT_Henkin.getRenno().intValue());
    }
}
