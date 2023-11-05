package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyouhnZokuseiBySyouhncdHyoujiymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseiBySyouhncdHyoujiymd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_SyouhnZokusei  syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd("A110",BizDate.valueOf(20160224));
        Assert.assertEquals(null, syouhnZokusei);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("A110", 2);
        syouhnZokusei1.setHyoujifromymd(BizDate.valueOf(20160223));
        syouhnZokusei1.setHyoujitoymd(BizDate.valueOf(20160225));

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("A110", 3);
        syouhnZokusei6.setHyoujifromymd(BizDate.valueOf(20160224));
        syouhnZokusei6.setHyoujitoymd(BizDate.valueOf(20160224));

        bizDomManager.insert(syouhnZokusei6);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("A110", 5);
        syouhnZokusei2.setHyoujifromymd(BizDate.valueOf(20160224));
        syouhnZokusei2.setHyoujitoymd(BizDate.valueOf(20160224));

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("A110", 8);
        syouhnZokusei3.setHyoujifromymd(BizDate.valueOf(20160226));
        syouhnZokusei3.setHyoujitoymd(BizDate.valueOf(20160227));

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("A110", 9);
        syouhnZokusei4.setHyoujifromymd(BizDate.valueOf(20160220));
        syouhnZokusei4.setHyoujitoymd(BizDate.valueOf(20160221));

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("A120", 5);
        syouhnZokusei5.setHyoujifromymd(BizDate.valueOf(20160224));
        syouhnZokusei5.setHyoujitoymd(BizDate.valueOf(20160224));

        bizDomManager.insert(syouhnZokusei5);




    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        BM_SyouhnZokusei  syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd("A130",BizDate.valueOf(20160224));
        Assert.assertEquals(null, syouhnZokusei);
    }

    @Test
    @TestOrder(20)
    public void blank() {

        BM_SyouhnZokusei  syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd("",BizDate.valueOf(20160224));
        Assert.assertEquals(null, syouhnZokusei);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        BM_SyouhnZokusei  syouhnZokusei = bizDomManager.getSyouhnZokuseiBySyouhncdHyoujiymd("A110",BizDate.valueOf(20160224));

        Assert.assertEquals("A110", syouhnZokusei.getSyouhncd());
        Assert.assertEquals(5, syouhnZokusei.getSyouhnsdno().intValue());
        Assert.assertEquals(BizDate.valueOf(20160224), syouhnZokusei.getHyoujifromymd());
        Assert.assertEquals(BizDate.valueOf(20160224), syouhnZokusei.getHyoujitoymd());

    }
}