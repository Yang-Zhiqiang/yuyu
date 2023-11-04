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

import yuyu.def.db.entity.BM_Syokugyou;
import yuyu.testinfr.TestOrder;

/**
 * 職業マスタテーブルエンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyokugyousBySyokugyoucdSyokugyounm {
    @Inject
    private BizDomManager bizDomManager;

    private final static String syokugyoucd1 = "133";
    private final static String syokugyoucd2 = "111";
    private final static String syokugyoucd3 = "211";
    private final static String syokugyoucd4 = "122";


    private final static String syokugyounm1 = "東い";
    private final static String syokugyounm2 = "あ東い";
    private final static String syokugyounm3 = "陳奇陳";
    private final static String syokugyounm4 = "東";


    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm(syokugyoucd1,syokugyounm1);

        Assert.assertEquals(0,syokugyouList.size());

        BM_Syokugyou syokugyou1 = new BM_Syokugyou(syokugyoucd1);
        syokugyou1.setSyokugyounm(syokugyounm1);

        BM_Syokugyou syokugyou2 = new BM_Syokugyou(syokugyoucd2);
        syokugyou2.setSyokugyounm(syokugyounm2);

        BM_Syokugyou syokugyou3 = new BM_Syokugyou(syokugyoucd3);
        syokugyou3.setSyokugyounm(syokugyounm3);

        BM_Syokugyou syokugyou4 = new BM_Syokugyou(syokugyoucd4);
        syokugyou4.setSyokugyounm(syokugyounm4);

        bizDomManager.insert(syokugyou1);
        bizDomManager.insert(syokugyou2);
        bizDomManager.insert(syokugyou3);
        bizDomManager.insert(syokugyou4);



    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyokugyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("3","あ");
        Assert.assertEquals(0,syokugyouList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("1","あ東");

        Assert.assertEquals(1,syokugyouList.size());

        Assert.assertEquals(syokugyoucd2,syokugyouList.get(0).getSyokugyoucd());
        Assert.assertEquals(syokugyounm2,syokugyouList.get(0).getSyokugyounm());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("1","東");

        Assert.assertEquals(3,syokugyouList.size());

        Assert.assertEquals(syokugyoucd2,syokugyouList.get(0).getSyokugyoucd());
        Assert.assertEquals(syokugyounm2,syokugyouList.get(0).getSyokugyounm());

        Assert.assertEquals(syokugyoucd4,syokugyouList.get(1).getSyokugyoucd());
        Assert.assertEquals(syokugyounm4,syokugyouList.get(1).getSyokugyounm());

        Assert.assertEquals(syokugyoucd1,syokugyouList.get(2).getSyokugyoucd());
        Assert.assertEquals(syokugyounm1,syokugyouList.get(2).getSyokugyounm());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("","東");

        Assert.assertEquals(3,syokugyouList.size());

        Assert.assertEquals(syokugyoucd2,syokugyouList.get(0).getSyokugyoucd());
        Assert.assertEquals(syokugyounm2,syokugyouList.get(0).getSyokugyounm());

        Assert.assertEquals(syokugyoucd4,syokugyouList.get(1).getSyokugyoucd());
        Assert.assertEquals(syokugyounm4,syokugyouList.get(1).getSyokugyounm());

        Assert.assertEquals(syokugyoucd1,syokugyouList.get(2).getSyokugyoucd());
        Assert.assertEquals(syokugyounm1,syokugyouList.get(2).getSyokugyounm());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("1","");

        Assert.assertEquals(3,syokugyouList.size());

        Assert.assertEquals(syokugyoucd2,syokugyouList.get(0).getSyokugyoucd());
        Assert.assertEquals(syokugyounm2,syokugyouList.get(0).getSyokugyounm());

        Assert.assertEquals(syokugyoucd4,syokugyouList.get(1).getSyokugyoucd());
        Assert.assertEquals(syokugyounm4,syokugyouList.get(1).getSyokugyounm());

        Assert.assertEquals(syokugyoucd1,syokugyouList.get(2).getSyokugyoucd());
        Assert.assertEquals(syokugyounm1,syokugyouList.get(2).getSyokugyounm());
    }

    @Test
    @TestOrder(60)
    public void blankCondition3() {
        List<BM_Syokugyou> syokugyouList = bizDomManager.getSyokugyousBySyokugyoucdSyokugyounm("","");

        Assert.assertEquals(4, syokugyouList.size());

        Assert.assertEquals(syokugyoucd2,syokugyouList.get(0).getSyokugyoucd());
        Assert.assertEquals(syokugyounm2,syokugyouList.get(0).getSyokugyounm());

        Assert.assertEquals(syokugyoucd4,syokugyouList.get(1).getSyokugyoucd());
        Assert.assertEquals(syokugyounm4,syokugyouList.get(1).getSyokugyounm());

        Assert.assertEquals(syokugyoucd1,syokugyouList.get(2).getSyokugyoucd());
        Assert.assertEquals(syokugyounm1,syokugyouList.get(2).getSyokugyounm());

        Assert.assertEquals(syokugyoucd3,syokugyouList.get(3).getSyokugyoucd());
        Assert.assertEquals(syokugyounm3,syokugyouList.get(3).getSyokugyounm());
    }
}
