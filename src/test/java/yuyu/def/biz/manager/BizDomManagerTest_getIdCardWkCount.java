package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BW_IdCardWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getIdCardWks() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getIdCardWkCount {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        Long count = bizDomManager.getIdCardWkCount();
        Assert.assertEquals(0, count.longValue());


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllIdCardWk());
    }

    @Test
    @TestOrder(10)
    public void normal00() {
        Long count = bizDomManager.getIdCardWkCount();
        Assert.assertEquals(0, count.longValue());

    }


    @Test
    @TestOrder(20)
    @Transactional
    public void normal10() {

        BW_IdCardWk idCardWk1 = new BW_IdCardWk("11", "100001");
        bizDomManager.insert(idCardWk1);
    }

    @Test
    @TestOrder(30)
    public void normal11() {
        Long count = bizDomManager.getIdCardWkCount();
        Assert.assertEquals(1, count.longValue());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal20() {
        BW_IdCardWk idCardWk2 = new BW_IdCardWk("22", "100002");
        bizDomManager.insert(idCardWk2);

        BW_IdCardWk idCardWk3 = new BW_IdCardWk("33", "100003");
        bizDomManager.insert(idCardWk3);

    }

    @Test
    @TestOrder(40)
    public void normal21() {
        Long count = bizDomManager.getIdCardWkCount();
        Assert.assertEquals(3, count.longValue());

    }


}

