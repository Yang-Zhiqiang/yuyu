package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約手続注意テーブルエンティティリストのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getSkTtdkTyuuisBySkeittdkrenrakukbn {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCTL1.getSkTtdkTyuuisBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.BLNK).size());

            HT_SkTtdkTyuui skTtdkTyuui1 = syoriCTL1.createSkTtdkTyuui();
            skTtdkTyuui1.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);
            skTtdkTyuui1.setDatarenno(1);

            HT_SkTtdkTyuui skTtdkTyuui2 = syoriCTL1.createSkTtdkTyuui();
            skTtdkTyuui2.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.BLNK);
            skTtdkTyuui2.setDatarenno(2);

            HT_SkTtdkTyuui skTtdkTyuui3 = syoriCTL1.createSkTtdkTyuui();
            skTtdkTyuui3.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.BLNK);
            skTtdkTyuui3.setDatarenno(3);

            HT_SkTtdkTyuui skTtdkTyuui4 = syoriCTL1.createSkTtdkTyuui();
            skTtdkTyuui4.setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.BLNK);
            skTtdkTyuui4.setDatarenno(4);

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
    public void noResult1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst = syoriCTL.getSkTtdkTyuuisBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_SONOTATYUUIINFO);

        Assert.assertEquals(0, skTtdkTyuuiLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst = syoriCTL.getSkTtdkTyuuisBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO);

        Assert.assertEquals(1, skTtdkTyuuiLst.size());
        Assert.assertEquals("10000000060", skTtdkTyuuiLst.get(0).getMosno());
        Assert.assertEquals(1, skTtdkTyuuiLst.get(0).getDatarenno().intValue());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.TTDK_TRATKITYUUIINFO, skTtdkTyuuiLst.get(0).getSkeittdkrenrakukbn());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_SkTtdkTyuui> skTtdkTyuuiLst = syoriCTL.getSkTtdkTyuuisBySkeittdkrenrakukbn(C_SkeittdkrenrakuKbn.BLNK);

        Assert.assertEquals(3, skTtdkTyuuiLst.size());

        Assert.assertEquals("10000000060", skTtdkTyuuiLst.get(0).getMosno());
        Assert.assertEquals("10000000060", skTtdkTyuuiLst.get(1).getMosno());
        Assert.assertEquals("10000000060", skTtdkTyuuiLst.get(2).getMosno());

        Assert.assertEquals(2, skTtdkTyuuiLst.get(0).getDatarenno().intValue());
        Assert.assertEquals(3, skTtdkTyuuiLst.get(1).getDatarenno().intValue());
        Assert.assertEquals(4, skTtdkTyuuiLst.get(2).getDatarenno().intValue());

        Assert.assertEquals(C_SkeittdkrenrakuKbn.BLNK, skTtdkTyuuiLst.get(0).getSkeittdkrenrakukbn());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.BLNK, skTtdkTyuuiLst.get(1).getSkeittdkrenrakukbn());
        Assert.assertEquals(C_SkeittdkrenrakuKbn.BLNK, skTtdkTyuuiLst.get(2).getSkeittdkrenrakukbn());

    }
}
