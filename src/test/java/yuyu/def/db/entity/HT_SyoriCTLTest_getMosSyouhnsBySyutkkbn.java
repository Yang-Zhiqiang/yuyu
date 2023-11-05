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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込商品テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosSyouhnsBySyutkkbn {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCTL1.getMosSyouhnsBySyutkkbn(C_SyutkKbn.NONE).size());

            HT_MosSyouhn mosSyouhn1 = syoriCTL1.createMosSyouhn();
            mosSyouhn1.setMosno("10000000060");
            mosSyouhn1.setSyouhncd("M110");
            mosSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);

            HT_MosSyouhn mosSyouhn2 = syoriCTL1.createMosSyouhn();
            mosSyouhn2.setMosno("10000000060");
            mosSyouhn2.setSyouhncd("M210");
            mosSyouhn2.setSyutkkbn(C_SyutkKbn.TK);

            HT_MosSyouhn mosSyouhn3 = syoriCTL1.createMosSyouhn();
            mosSyouhn3.setMosno("10000000060");
            mosSyouhn3.setSyouhncd("M310");
            mosSyouhn3.setSyutkkbn(C_SyutkKbn.TK);

            HT_MosSyouhn mosSyouhn4 = syoriCTL1.createMosSyouhn();
            mosSyouhn4.setMosno("10000000060");
            mosSyouhn4.setSyouhncd("M410");
            mosSyouhn4.setSyutkkbn(C_SyutkKbn.TK);
            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("10000000070");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("10000000070");

            HT_MosSyouhn mosSyouhn5 = syoriCTL1.createMosSyouhn();
            mosSyouhn5.setMosno("10000000070");
            mosSyouhn5.setSyouhncd("M110");
            mosSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
            sinkeiyakuDomManager.insert(syoriCTL2);
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

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.NONE);

        Assert.assertEquals(0, mosSyouhnLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        Assert.assertEquals(1, mosSyouhnLst.size());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(0).getMosno());
        Assert.assertEquals("M110", mosSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(C_SyutkKbn.SYU, mosSyouhnLst.get(0).getSyutkkbn());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        Assert.assertEquals(3, mosSyouhnLst.size());

        Assert.assertEquals("10000000060", mosSyouhnLst.get(0).getMosno());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(1).getMosno());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(2).getMosno());

        Assert.assertEquals("M210", mosSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals("M310", mosSyouhnLst.get(1).getSyouhncd());
        Assert.assertEquals("M410", mosSyouhnLst.get(2).getSyouhncd());

        Assert.assertEquals(C_SyutkKbn.TK, mosSyouhnLst.get(0).getSyutkkbn());
        Assert.assertEquals(C_SyutkKbn.TK, mosSyouhnLst.get(1).getSyutkkbn());
        Assert.assertEquals(C_SyutkKbn.TK, mosSyouhnLst.get(2).getSyutkkbn());

    }
}
