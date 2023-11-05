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

import yuyu.def.classification.C_KataKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込商品テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getMosSyouhnsByKatakbns {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL("10000000060");
        if (syoriCTL1 == null) {
            syoriCTL1 = new HT_SyoriCTL("10000000060");
            Assert.assertEquals(0, syoriCTL1.getMosSyouhnsByKatakbns(C_KataKbn.HONNIN_SAISI).size());

            HT_MosSyouhn mosSyouhn1 = syoriCTL1.createMosSyouhn();
            mosSyouhn1.setSyouhncd("M110");
            mosSyouhn1.setKatakbn(C_KataKbn.HONNIN);

            HT_MosSyouhn mosSyouhn2 = syoriCTL1.createMosSyouhn();
            mosSyouhn2.setSyouhncd("M210");
            mosSyouhn2.setKatakbn(C_KataKbn.HONIN_KO);

            HT_MosSyouhn mosSyouhn3 = syoriCTL1.createMosSyouhn();
            mosSyouhn3.setSyouhncd("M310");
            mosSyouhn3.setKatakbn(C_KataKbn.HONNIN_SAISI);

            HT_MosSyouhn mosSyouhn4 = syoriCTL1.createMosSyouhn();
            mosSyouhn4.setSyouhncd("M410");
            mosSyouhn4.setKatakbn(C_KataKbn.HONNIN_TUMA);
            sinkeiyakuDomManager.insert(syoriCTL1);
        }
        HT_SyoriCTL syoriCTL2 =  sinkeiyakuDomManager.getSyoriCTL("10000000070");
        if (syoriCTL2 == null) {
            syoriCTL2 = new HT_SyoriCTL("10000000070");

            HT_MosSyouhn mosSyouhn5 = syoriCTL2.createMosSyouhn();
            mosSyouhn5.setSyouhncd("M110");
            mosSyouhn5.setKatakbn(C_KataKbn.BLNK);
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

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsByKatakbns(C_KataKbn.BLNK);

        Assert.assertEquals(0, mosSyouhnLst.size());
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsByKatakbns(C_KataKbn.HONNIN);

        Assert.assertEquals(1, mosSyouhnLst.size());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(0).getMosno());
        Assert.assertEquals("M110", mosSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals(C_KataKbn.HONNIN, mosSyouhnLst.get(0).getKatakbn());
    }

    @Test
    @TestOrder(30)
    public void normal3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("10000000060");

        List<HT_MosSyouhn> mosSyouhnLst = syoriCTL.getMosSyouhnsByKatakbns(C_KataKbn.HONNIN_TUMA, C_KataKbn.HONIN_KO, C_KataKbn.HONNIN_SAISI);

        Assert.assertEquals(3, mosSyouhnLst.size());

        Assert.assertEquals("10000000060", mosSyouhnLst.get(0).getMosno());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(1).getMosno());
        Assert.assertEquals("10000000060", mosSyouhnLst.get(2).getMosno());

        Assert.assertEquals("M210", mosSyouhnLst.get(0).getSyouhncd());
        Assert.assertEquals("M310", mosSyouhnLst.get(1).getSyouhncd());
        Assert.assertEquals("M410", mosSyouhnLst.get(2).getSyouhncd());

        Assert.assertEquals(C_KataKbn.HONIN_KO, mosSyouhnLst.get(0).getKatakbn());
        Assert.assertEquals(C_KataKbn.HONNIN_SAISI, mosSyouhnLst.get(1).getKatakbn());
        Assert.assertEquals(C_KataKbn.HONNIN_TUMA, mosSyouhnLst.get(2).getKatakbn());

    }
}
