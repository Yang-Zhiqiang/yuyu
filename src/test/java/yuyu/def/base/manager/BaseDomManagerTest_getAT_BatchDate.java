package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_BatchDate;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getAT_BatchDate() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getAT_BatchDate extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        BizDate pBatchExecDate = BizDate.valueOf("20150806");

        AT_BatchDate aT_BatchDate = baseDomManager.getAT_BatchDate();
        if ( null == aT_BatchDate ) {

            aT_BatchDate = new AT_BatchDate();
            aT_BatchDate.setBatchExecDate(pBatchExecDate);

            baseDomManager.insert(aT_BatchDate);

        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AT_BatchDate aT_BatchDate = baseDomManager.getAT_BatchDate();
        if ( null != aT_BatchDate ) {

            baseDomManager.delete(aT_BatchDate);
        }


    }

    @Test
    public void test001(){
        AT_BatchDate aT_BatchDate = baseDomManager.getAT_BatchDate();

        assertNotNull(null, aT_BatchDate);
    }
}
