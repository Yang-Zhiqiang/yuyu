package yuyu.batch.biz.bzmaster.bzaddresstorikomi;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.batch.biz.bzmaster.bzaddresstorikomi.BzAddressTorikomiDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_Address;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * マスタ取込（住所マスタ）<br />
 * deleteAddress() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class BzAddressTorikomiDaoTest_deleteAddress {

    @Inject
    private BzAddressTorikomiDao bzAddressTorikomiDao;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_Address address1 = new BM_Address("3530005", "1");
        bizDomManager.insert(address1);

        BM_Address address2 = new BM_Address("3530006", "2");
        bizDomManager.insert(address2);

        BM_Address address3 = new BM_Address("3530007", "3");
        bizDomManager.insert(address3);

        BM_Address address4 = new BM_Address("3530008", "4");
        bizDomManager.insert(address4);
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1() {

        bzAddressTorikomiDao.deleteAddress();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal2() {

        assertEquals(0, bizDomManager.getAllAddress().size());
    }
}
