package yuyu.def.base.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * deleteAllAddresses() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_deleteAllAddresses extends AbstractTest {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        //        String pPostalCd1 = "0000001";
        //        String pPostalCd2 = "0000002";
        //        String pPostalCd3 = "0000003";
        //
        //        AM_Address aM_Address1 = baseDomManager.getAddress(pPostalCd1);
        //        if ( null == aM_Address1 ) {
        //
        //            aM_Address1 = new AM_Address();
        //            aM_Address1.setPostalCd(pPostalCd1);
        //
        //           baseDomManager.insert(aM_Address1);
        //
        //        }
        //
        //        AM_Address aM_Address2 = baseDomManager.getAddress(pPostalCd2);
        //        if ( null == aM_Address2 ) {
        //
        //            aM_Address2 = new AM_Address();
        //            aM_Address2.setPostalCd(pPostalCd2);
        //
        //          baseDomManager.insert(aM_Address2);
        //        }
        //
        //
        //        AM_Address aM_Address3 = baseDomManager.getAddress(pPostalCd3);
        //        if ( null == aM_Address3 ) {
        //
        //            aM_Address3 = new AM_Address();
        //            aM_Address3.setPostalCd(pPostalCd3);
        //
        //          baseDomManager.insert(aM_Address3);
        //        }
        //
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
    }

    @Test
    @Transactional
    public void test001(){
        //
        //        long count = baseDomManager.deleteAllAddresses();
        //
        //        assertEquals(3, count);
        //
        //        String pPostalCd = "0000001";
        //
        //        AM_Address aM_Address = baseDomManager.getAddress(pPostalCd);
        //        if ( null == aM_Address ) {
        //
        //            aM_Address = new AM_Address();
        //            aM_Address.setPostalCd(pPostalCd);
        //
        //          baseDomManager.insert(aM_Address);
        //        }
        //
    }

    @Test
    public void test002(){
        //
        //        long count = baseDomManager.deleteAllAddresses();
        //
        //        assertEquals(1, count);
    }

    @Test
    public void test003(){
        //
        //        long count = baseDomManager.deleteAllAddresses();
        //
        //        assertEquals(0, count);
    }
}
