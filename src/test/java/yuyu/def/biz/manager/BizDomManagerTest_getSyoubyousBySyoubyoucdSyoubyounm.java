package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_Syoubyou;
import yuyu.testinfr.TestOrder;

/**
 * 傷病マスタテーブルエンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyoubyousBySyoubyoucdSyoubyounm {
    @Inject
    private BizDomManager bizDomManager;

    private final static String syoubyoucd1 = "100111";
    private final static String syoubyoucd2 = "100333";
    private final static String syoubyoucd3 = "200111";
    private final static String syoubyoucd4 = "100222";


    private final static String syoubyounm1 = "あ東い";
    private final static String syoubyounm2 = "東い";
    private final static String syoubyounm3 = "陳奇陳";
    private final static String syoubyounm4 = "東";


    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("100","奇");

        Assert.assertEquals(0,syoubyouList.size());

        BM_Syoubyou syoubyou1 = new BM_Syoubyou(syoubyoucd1);
        syoubyou1.setSyoubyounm(syoubyounm1);

        BM_Syoubyou syoubyou2 = new BM_Syoubyou(syoubyoucd2);
        syoubyou2.setSyoubyounm(syoubyounm2);

        BM_Syoubyou syoubyou3 = new BM_Syoubyou(syoubyoucd3);
        syoubyou3.setSyoubyounm(syoubyounm3);

        BM_Syoubyou syoubyou4 = new BM_Syoubyou(syoubyoucd4);
        syoubyou4.setSyoubyounm(syoubyounm4);

        bizDomManager.insert(syoubyou1);
        bizDomManager.insert(syoubyou2);
        bizDomManager.insert(syoubyou3);
        bizDomManager.insert(syoubyou4);



    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyoubyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("300","あ");
        Assert.assertEquals(0,syoubyouList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("100","あ東");

        Assert.assertEquals(1,syoubyouList.size());

        Assert.assertEquals(syoubyoucd1,syoubyouList.get(0).getSyoubyoucd());
        Assert.assertEquals(syoubyounm1,syoubyouList.get(0).getSyoubyounm());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("100","東");

        Assert.assertEquals(3,syoubyouList.size());

        Assert.assertEquals(syoubyoucd1,syoubyouList.get(0).getSyoubyoucd());
        Assert.assertEquals(syoubyounm1,syoubyouList.get(0).getSyoubyounm());

        Assert.assertEquals(syoubyoucd4,syoubyouList.get(1).getSyoubyoucd());
        Assert.assertEquals(syoubyounm4,syoubyouList.get(1).getSyoubyounm());

        Assert.assertEquals(syoubyoucd2,syoubyouList.get(2).getSyoubyoucd());
        Assert.assertEquals(syoubyounm2,syoubyouList.get(2).getSyoubyounm());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("","東");

        Assert.assertEquals(3,syoubyouList.size());

        Assert.assertEquals(syoubyoucd1,syoubyouList.get(0).getSyoubyoucd());
        Assert.assertEquals(syoubyounm1,syoubyouList.get(0).getSyoubyounm());

        Assert.assertEquals(syoubyoucd4,syoubyouList.get(1).getSyoubyoucd());
        Assert.assertEquals(syoubyounm4,syoubyouList.get(1).getSyoubyounm());

        Assert.assertEquals(syoubyoucd2,syoubyouList.get(2).getSyoubyoucd());
        Assert.assertEquals(syoubyounm2,syoubyouList.get(2).getSyoubyounm());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("100","");

        Assert.assertEquals(3,syoubyouList.size());

        Assert.assertEquals(syoubyoucd1,syoubyouList.get(0).getSyoubyoucd());
        Assert.assertEquals(syoubyounm1,syoubyouList.get(0).getSyoubyounm());

        Assert.assertEquals(syoubyoucd4,syoubyouList.get(1).getSyoubyoucd());
        Assert.assertEquals(syoubyounm4,syoubyouList.get(1).getSyoubyounm());

        Assert.assertEquals(syoubyoucd2,syoubyouList.get(2).getSyoubyoucd());
        Assert.assertEquals(syoubyounm2,syoubyouList.get(2).getSyoubyounm());
    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {
        List<BM_Syoubyou> syoubyouList = bizDomManager.getSyoubyousBySyoubyoucdSyoubyounm("","");

        Assert.assertEquals(4,syoubyouList.size());

        Assert.assertEquals(syoubyoucd1,syoubyouList.get(0).getSyoubyoucd());
        Assert.assertEquals(syoubyounm1,syoubyouList.get(0).getSyoubyounm());

        Assert.assertEquals(syoubyoucd4,syoubyouList.get(1).getSyoubyoucd());
        Assert.assertEquals(syoubyounm4,syoubyouList.get(1).getSyoubyounm());

        Assert.assertEquals(syoubyoucd2,syoubyouList.get(2).getSyoubyoucd());
        Assert.assertEquals(syoubyounm2,syoubyouList.get(2).getSyoubyounm());

        Assert.assertEquals(syoubyoucd3,syoubyouList.get(3).getSyoubyoucd());
        Assert.assertEquals(syoubyounm3,syoubyouList.get(3).getSyoubyounm());
    }
}
