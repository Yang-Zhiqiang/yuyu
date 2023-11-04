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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 医務査定商品別特条条件付テーブルエンティティリストのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getImusateiSyouhnTokujyousByRenno {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCTL1.getImusateiSyouhnTokujyousByRenno(1).size());

            HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou1 = syoriCTL1.createImusateiSyouhnTokujyou();
            hT_ImusateiSyouhnTokujyou1.setMosno("10000000060");
            hT_ImusateiSyouhnTokujyou1.setRenno(1);
            hT_ImusateiSyouhnTokujyou1.setSyouhncd("M110");

            HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou2 = syoriCTL1.createImusateiSyouhnTokujyou();
            hT_ImusateiSyouhnTokujyou2.setMosno("10000000060");
            hT_ImusateiSyouhnTokujyou2.setRenno(2);
            hT_ImusateiSyouhnTokujyou2.setSyouhncd("M210");

            HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou3 = syoriCTL1.createImusateiSyouhnTokujyou();
            hT_ImusateiSyouhnTokujyou3.setMosno("10000000060");
            hT_ImusateiSyouhnTokujyou3.setRenno(2);
            hT_ImusateiSyouhnTokujyou3.setSyouhncd("M310");

            HT_ImusateiSyouhnTokujyou hT_ImusateiSyouhnTokujyou4 = syoriCTL1.createImusateiSyouhnTokujyou();
            hT_ImusateiSyouhnTokujyou4.setMosno("10000000060");
            hT_ImusateiSyouhnTokujyou4.setRenno(2);
            hT_ImusateiSyouhnTokujyou4.setSyouhncd("M410");

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

        List<HT_ImusateiSyouhnTokujyou> imusateiSyouhnTokujyouLst = syoriCTL.getImusateiSyouhnTokujyousByRenno(3);

        Assert.assertEquals(0, imusateiSyouhnTokujyouLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_ImusateiSyouhnTokujyou> imusateiSyouhnTokujyouLst = syoriCTL.getImusateiSyouhnTokujyousByRenno(1);

        Assert.assertEquals(1, imusateiSyouhnTokujyouLst.size());
        Assert.assertEquals("10000000060", imusateiSyouhnTokujyouLst.get(0).getMosno());
        Assert.assertEquals(Integer.valueOf(1), imusateiSyouhnTokujyouLst.get(0).getRenno());
        Assert.assertEquals("M110", imusateiSyouhnTokujyouLst.get(0).getSyouhncd());

    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_ImusateiSyouhnTokujyou> imusateiSyouhnTokujyouLst = syoriCTL.getImusateiSyouhnTokujyousByRenno(2);

        Assert.assertEquals(3, imusateiSyouhnTokujyouLst.size());

        Assert.assertEquals("10000000060", imusateiSyouhnTokujyouLst.get(0).getMosno());
        Assert.assertEquals("10000000060", imusateiSyouhnTokujyouLst.get(1).getMosno());
        Assert.assertEquals("10000000060", imusateiSyouhnTokujyouLst.get(2).getMosno());

        Assert.assertEquals(Integer.valueOf(2), imusateiSyouhnTokujyouLst.get(0).getRenno());
        Assert.assertEquals(Integer.valueOf(2), imusateiSyouhnTokujyouLst.get(1).getRenno());
        Assert.assertEquals(Integer.valueOf(2), imusateiSyouhnTokujyouLst.get(2).getRenno());

        Assert.assertEquals("M210", imusateiSyouhnTokujyouLst.get(0).getSyouhncd());
        Assert.assertEquals("M310", imusateiSyouhnTokujyouLst.get(1).getSyouhncd());
        Assert.assertEquals("M410", imusateiSyouhnTokujyouLst.get(2).getSyouhncd());


    }
}
