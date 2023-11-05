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
 * 医務査定特条テーブルエンティティのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getImusateiTokujyouByRenno {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String mosno1 = "10000000060";
    private final static String mosno2 = "10000000070";

    private final static Integer renno2 = 2;
    private final static Integer renno3 = 3;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL syoriCTL1 =  sinkeiyakuDomManager.getSyoriCTL(mosno1);

        if (syoriCTL1 == null) {

            syoriCTL1 = new HT_SyoriCTL(mosno1);
            HT_ImusateiTokujyou imusateiTokujyou = syoriCTL1.getImusateiTokujyouByRenno(renno2);
            Assert.assertEquals(null, imusateiTokujyou);

            HT_ImusateiTokujyou imusateiTokujyou1 = syoriCTL1.createImusateiTokujyou();
            imusateiTokujyou1.setRenno(1);

            HT_ImusateiTokujyou imusateiTokujyou2 = syoriCTL1.createImusateiTokujyou();
            imusateiTokujyou2.setRenno(2);

            sinkeiyakuDomManager.insert(syoriCTL1);
        }

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(mosno2);

        HT_ImusateiTokujyou imusateiTokujyou3 = syoriCTL2.createImusateiTokujyou();
        imusateiTokujyou3.setRenno(2);

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

        HT_ImusateiTokujyou imusateiTokujyou = syoriCTL.getImusateiTokujyouByRenno(renno3);

        Assert.assertEquals(null, imusateiTokujyou);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosno1);
        HT_ImusateiTokujyou imusateiTokujyou = syoriCTL.getImusateiTokujyouByRenno(renno2);

        Assert.assertEquals(mosno1, imusateiTokujyou.getMosno());
        Assert.assertEquals(renno2, imusateiTokujyou.getRenno());
    }

}
