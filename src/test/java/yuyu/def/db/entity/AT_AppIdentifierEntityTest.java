package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

/**
 * アプリケーション識別子管理 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_AppIdentifierEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pIdentifier1 = "S01";
        String pIdentifier2 = "S02";
        String pIdentifier3 = "S03";
        String pIdentifier4 = "S04";
        String pIdentifier5 = "S05";
        String pTouchTime1 = "20150707175740500";
        String pTouchTime2 = "20150708085822900";
        String pTouchTime3 = "20150708094239900";
        String pTouchTime4 = "20150708094639300";
        String pTouchTime5 = "20150708101324500";

        AT_AppIdentifier aT_AppIdentifier1 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier1);
        if ( null == aT_AppIdentifier1 ){

            aT_AppIdentifier1 = new AT_AppIdentifier();
            aT_AppIdentifier1.setIdentifier(pIdentifier1);
            aT_AppIdentifier1.setTouchTime(pTouchTime1);

            baseDomManager.insert(aT_AppIdentifier1);
        }

        AT_AppIdentifier aT_AppIdentifier2 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier2);
        if ( null == aT_AppIdentifier2 ){

            aT_AppIdentifier2 = new AT_AppIdentifier();
            aT_AppIdentifier2.setIdentifier(pIdentifier2);
            aT_AppIdentifier2.setTouchTime(pTouchTime2);

            baseDomManager.insert(aT_AppIdentifier2);
        }

        AT_AppIdentifier aT_AppIdentifier3 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier3);
        if ( null == aT_AppIdentifier3 ){

            aT_AppIdentifier3 = new AT_AppIdentifier();
            aT_AppIdentifier3.setIdentifier(pIdentifier3);
            aT_AppIdentifier3.setTouchTime(pTouchTime3);

            baseDomManager.insert(aT_AppIdentifier3);
        }

        AT_AppIdentifier aT_AppIdentifier4 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier4);
        if ( null == aT_AppIdentifier4 ){

            aT_AppIdentifier4 = new AT_AppIdentifier();
            aT_AppIdentifier4.setIdentifier(pIdentifier4);
            aT_AppIdentifier4.setTouchTime(pTouchTime4);

            baseDomManager.insert(aT_AppIdentifier4);
        }

        AT_AppIdentifier aT_AppIdentifier5 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier5);
        if ( null == aT_AppIdentifier5 ){

            aT_AppIdentifier5 = new AT_AppIdentifier();
            aT_AppIdentifier5.setIdentifier(pIdentifier5);
            aT_AppIdentifier5.setTouchTime(pTouchTime5);

            baseDomManager.insert(aT_AppIdentifier5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pIdentifier1 = "S01";
        String pIdentifier2 = "S02";
        String pIdentifier3 = "S03";
        String pIdentifier4 = "S04";
        String pIdentifier5 = "S05";

        AT_AppIdentifier aT_AppIdentifier1 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier1);
        if ( null != aT_AppIdentifier1 ){

            baseDomManager.delete(aT_AppIdentifier1);
        }

        AT_AppIdentifier aT_AppIdentifier2 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier2);
        if ( null != aT_AppIdentifier2 ){

            baseDomManager.delete(aT_AppIdentifier2);
        }

        AT_AppIdentifier aT_AppIdentifier3 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier3);
        if ( null != aT_AppIdentifier3 ){

            baseDomManager.delete(aT_AppIdentifier3);
        }

        AT_AppIdentifier aT_AppIdentifier4 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier4);
        if ( null != aT_AppIdentifier4 ){

            baseDomManager.delete(aT_AppIdentifier4);
        }

        AT_AppIdentifier aT_AppIdentifier5 = baseDomManager.getAppIdentifierByIdentifier(pIdentifier5);
        if ( null != aT_AppIdentifier5 ){

            baseDomManager.delete(aT_AppIdentifier5);
        }
    }

    @Override
    @Test
    @Transactional
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pIdentifier = "S01";
        AT_AppIdentifier aT_AppIdentifier = baseDomManager.getAppIdentifierByIdentifier(pIdentifier);

        assertEquals(pIdentifier, aT_AppIdentifier.getIdentifier());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pIdentifier = "S99";
        AT_AppIdentifier aT_AppIdentifier = baseDomManager.getAppIdentifierByIdentifier(pIdentifier);

        assertNull(aT_AppIdentifier);

    }

    @Override
    @Test
    public void blankCondition() {
        String pIdentifier = "";
        AT_AppIdentifier aT_AppIdentifier = baseDomManager.getAppIdentifierByIdentifier(pIdentifier);

        assertNull(aT_AppIdentifier);

    }

    @Override
    @Test
    public void nullCondition() {
        String pIdentifier = null;
        try {
            baseDomManager.getAppIdentifierByIdentifier(pIdentifier);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }

    }
}
