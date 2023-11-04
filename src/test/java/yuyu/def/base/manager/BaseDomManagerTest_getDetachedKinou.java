package yuyu.def.base.manager;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getDetachedKinou() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getDetachedKinou extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private static Logger logger;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ) {

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ) {

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);

            baseDomManager.insert(aS_Kinou2);
        }


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.delete(aS_Kinou2);
        }
    }

    @Test
    public void test001(){
        String pKinouId = "KI00000099";
        AS_Kinou aS_Kinou = baseDomManager.getDetachedKinou(pKinouId);

        assertNull(aS_Kinou);
    }

    @Test
    public void test002(){
        String pKinouId = "KI00000001";
        AS_Kinou aS_Kinou = baseDomManager.getDetachedKinou(pKinouId);

        assertEquals(pKinouId, aS_Kinou.getKinouId());
    }

    @Test
    public void test003(){
        String pKinouId = "";
        AS_Kinou aS_Kinou = baseDomManager.getDetachedKinou(pKinouId);

        assertNull(aS_Kinou);
    }

    @Test
    public void test004(){
        String pKinouId = null;
        try {
            baseDomManager.getDetachedKinou(pKinouId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }

    @Test
    public void test005() {
        String kinouId = "roletouroku";
        AS_Kinou kinou1 = baseDomManager.getKinou(kinouId);
        AS_Kinou kinou2 = baseDomManager.getDetachedKinou(kinouId);
        assertTrue(baseDomManager.isManaged(kinou1));
        assertFalse(baseDomManager.isManaged(kinou2));
        assertTrue(kinou1.equals(kinou2));
    }

    @Test
    public void test006() {
        AS_Kinou kinou = baseDomManager.getDetachedKinou("roletouroku");
        assertFalse(baseDomManager.isManaged(kinou));
    }

    @Transactional
    @Test
    public void test007() {
        String kinouId = "roletouroku";
        AS_Kinou kinou1 = baseDomManager.getKinou(kinouId);
        AS_Kinou kinou2 = baseDomManager.getDetachedKinou(kinouId);
        assertTrue(baseDomManager.isManaged(kinou1));
        assertFalse(baseDomManager.isManaged(kinou2));
        assertTrue(kinou1.equals(kinou2));
        kinou2.setKinouNm("test");
        logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行されない ↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @Test
    public void test008() {
        String kinouId = "roletouroku";
        AS_Kinou kinou1 = baseDomManager.getKinou(kinouId);
        AS_Kinou kinou2 = baseDomManager.getDetachedKinou(kinouId);
        logger.debug("====================================================== >> マネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes1 = kinou1.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes1) {
            logger.debug(kinouMode.toString());
        }
        logger.debug("====================================================== マネージドの機能モード取得 << ======================================================");
        logger.debug("====================================================== >> アンマネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes2 = kinou2.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes2) {
            logger.debug(kinouMode.toString());
        }
        logger.debug("====================================================== アンマネージドの機能モード取得 << ======================================================");
    }

    @Test
    public void test009() {
        String kinouId = "roletouroku";
        AS_Kinou kinou1 = baseDomManager.getKinou(kinouId);
        kinou1.detach();
        AS_Kinou kinou2 = baseDomManager.getDetachedKinou(kinouId);
        logger.debug("====================================================== >> マネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes1 = kinou1.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes1) {
            logger.debug(kinouMode.toString());
        }
        logger.debug("====================================================== マネージドの機能モード取得 << ======================================================");
        logger.debug("====================================================== >> アンマネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes2 = kinou2.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes2) {
            logger.debug(kinouMode.toString());
        }
        logger.debug("====================================================== アンマネージドの機能モード取得 << ======================================================");
    }

    @Transactional
    @Test
    public void test010() {
        String kinouId = "roletouroku";
        AS_Kinou kinou1 = baseDomManager.getKinou(kinouId);
        AS_Kinou kinou2 = baseDomManager.getDetachedKinou(kinouId);
        logger.debug("====================================================== >> マネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes1 = kinou1.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes1) {
            logger.debug(kinouMode.toString());
        }
        logger.debug("====================================================== マネージドの機能モード取得 << ======================================================");
        logger.debug("====================================================== >> アンマネージドの機能モード取得 ======================================================");
        Set<AS_KinouMode> kinouModes2 = kinou2.getKinouModes();
        for (AS_KinouMode kinouMode : kinouModes2) {
            logger.debug(kinouMode.toString());
            kinouMode.setKousinKinou("junit");
        }
        logger.debug("====================================================== アンマネージドの機能モード取得 << ======================================================");
        logger.debug("↓↓↓↓↓↓↓↓↓↓↓↓ Update文が発行されない ↓↓↓↓↓↓↓↓↓↓↓↓");
    }
}
