package yuyu.def.biz.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 住所マスタ(BM_Address) デタッチャーのテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BM_AddressDetacherTest_detachAddresstouched {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_Address address1 = new BM_Address("1234567", "1");

        bizDomManager.insert(address1);

        BM_Address address2 = new BM_Address("1234567", "2");

        bizDomManager.insert(address2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testDetach() {

        BM_Address address = bizDomManager.getAddress("1234567", "1");

        if (address != null) {
            address = BM_AddressDetacher.detachAddresstouched(address);

            ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

            boolean result = em.getEntityManager().contains(address);

            Assert.assertFalse(result);
        }
        else {
            Assert.assertTrue(false);
        }
    }
    @Test
    @TestOrder(20)
    public void testDetach2() {

        BM_Address address = bizDomManager.getAddress("1234567", "3");

        address = BM_AddressDetacher.detachAddresstouched(address);

        Assert.assertNull(address);
    }
}
