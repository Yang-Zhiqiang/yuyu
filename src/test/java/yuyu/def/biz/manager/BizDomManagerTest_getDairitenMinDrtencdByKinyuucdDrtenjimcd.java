package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDairitenMinDrtencdByKinyuucdDrtenjimcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDairitenMinDrtencdByKinyuucdDrtenjimcd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        String drtencd = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd("1001","9001");
        Assert.assertEquals(null, drtencd);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Dairiten dairiten1 = new BM_Dairiten("M10004");
        dairiten1.setKinyuucd("1001");
        dairiten1.setDrtenjimcd("9001");

        bizDomManager.insert(dairiten1);

        BM_Dairiten dairiten2 = new BM_Dairiten("M10002");
        dairiten2.setKinyuucd("1001");
        dairiten2.setDrtenjimcd("9001");

        bizDomManager.insert(dairiten2);

        BM_Dairiten dairiten3 = new BM_Dairiten("M10003");
        dairiten3.setKinyuucd("1002");
        dairiten3.setDrtenjimcd("9001");

        bizDomManager.insert(dairiten3);

        BM_Dairiten dairiten4 = new BM_Dairiten("M10001");
        dairiten4.setKinyuucd("1003");
        dairiten4.setDrtenjimcd("9001");

        bizDomManager.insert(dairiten4);

        BM_Dairiten dairiten5 = new BM_Dairiten("M10005");
        dairiten5.setKinyuucd("1001");
        dairiten5.setDrtenjimcd("9001");

        bizDomManager.insert(dairiten5);
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        String drtencd = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd("1001","9002");
        Assert.assertEquals(null, drtencd);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        String drtencd  = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd("1001","9001");
        Assert.assertEquals("M10002", drtencd);
    }


    @Test
    @TestOrder(30)
    public void blankCondition1() {

        String drtencd  = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd("","9001");
        Assert.assertEquals(null, drtencd);

    }


    @Test
    @TestOrder(40)
    public void blankCondition2() {

        String drtencd  = bizDomManager.getDairitenMinDrtencdByKinyuucdDrtenjimcd("1001","");
        Assert.assertEquals(null, drtencd);

    }

    @Transactional
    public static void deleteTestSubData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_Dairiten> dairitenlst = bizDomManager.getAllDairiten();
        if(dairitenlst.size() > 0){
            bizDomManager.delete(dairitenlst);
        }
    }


    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }
}
