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
 * getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Integer MaxSyouhnsdno = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd("A100",BizDate.valueOf(20160304));
        Assert.assertEquals(null, MaxSyouhnsdno);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("A100", 10);
        syouhnZokusei1.setKykfromymd(BizDate.valueOf(20160303));
        syouhnZokusei1.setKyktoymd(BizDate.valueOf(20160305));

        bizDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("A200", 20);
        syouhnZokusei2.setKykfromymd(BizDate.valueOf(20160303));
        syouhnZokusei2.setKyktoymd(BizDate.valueOf(20160305));

        bizDomManager.insert(syouhnZokusei2);

        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei("A100", 30);
        syouhnZokusei3.setKykfromymd(BizDate.valueOf(20160301));
        syouhnZokusei3.setKyktoymd(BizDate.valueOf(20160303));

        bizDomManager.insert(syouhnZokusei3);

        BM_SyouhnZokusei syouhnZokusei4 = new BM_SyouhnZokusei("A100", 40);
        syouhnZokusei4.setKykfromymd(BizDate.valueOf(20160305));
        syouhnZokusei4.setKyktoymd(BizDate.valueOf(20160307));

        bizDomManager.insert(syouhnZokusei4);

        BM_SyouhnZokusei syouhnZokusei5 = new BM_SyouhnZokusei("A100", 25);
        syouhnZokusei5.setKykfromymd(BizDate.valueOf(20160304));
        syouhnZokusei5.setKyktoymd(BizDate.valueOf(20160304));

        bizDomManager.insert(syouhnZokusei5);

        BM_SyouhnZokusei syouhnZokusei6 = new BM_SyouhnZokusei("A100", 15);
        syouhnZokusei6.setKykfromymd(BizDate.valueOf(20160303));
        syouhnZokusei6.setKyktoymd(BizDate.valueOf(20160305));

        bizDomManager.insert(syouhnZokusei6);

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

        Integer MaxSyouhnsdno = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd("A500",BizDate.valueOf(20160304));
        Assert.assertEquals(null, MaxSyouhnsdno);
    }

    @Test
    @TestOrder(20)
    public void blank() {

        Integer MaxSyouhnsdno = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd("",BizDate.valueOf(20160304));
        Assert.assertEquals(null, MaxSyouhnsdno);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Integer MaxSyouhnsdno = bizDomManager.getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd("A100",BizDate.valueOf(20160304));
        Assert.assertEquals(25, MaxSyouhnsdno.intValue());

    }
}