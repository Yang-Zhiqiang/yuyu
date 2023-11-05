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
 * ユーザー変更履歴 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_UserHenkouRirekiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";

        AT_UserHenkouRireki aT_UserHenkouRireki1 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId1);
        if ( null == aT_UserHenkouRireki1 ) {

            aT_UserHenkouRireki1 = new AT_UserHenkouRireki();
            aT_UserHenkouRireki1.setUniqueId(pUniqueId1);

            baseDomManager.insert(aT_UserHenkouRireki1);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki2 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId2);
        if ( null == aT_UserHenkouRireki2 ) {

            aT_UserHenkouRireki2 = new AT_UserHenkouRireki();
            aT_UserHenkouRireki2.setUniqueId(pUniqueId2);

            baseDomManager.insert(aT_UserHenkouRireki2);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki3 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId3);
        if ( null == aT_UserHenkouRireki3 ) {

            aT_UserHenkouRireki3 = new AT_UserHenkouRireki();
            aT_UserHenkouRireki3.setUniqueId(pUniqueId3);

            baseDomManager.insert(aT_UserHenkouRireki3);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki4 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId4);
        if ( null == aT_UserHenkouRireki4 ) {

            aT_UserHenkouRireki4 = new AT_UserHenkouRireki();
            aT_UserHenkouRireki4.setUniqueId(pUniqueId4);

            baseDomManager.insert(aT_UserHenkouRireki4);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki5 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId5);
        if ( null == aT_UserHenkouRireki5 ) {

            aT_UserHenkouRireki5 = new AT_UserHenkouRireki();
            aT_UserHenkouRireki5.setUniqueId(pUniqueId5);

            baseDomManager.insert(aT_UserHenkouRireki5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";

        AT_UserHenkouRireki aT_UserHenkouRireki1 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId1);
        if ( null != aT_UserHenkouRireki1 ) {

            baseDomManager.delete(aT_UserHenkouRireki1);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki2 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId2);
        if ( null != aT_UserHenkouRireki2 ) {

            baseDomManager.delete(aT_UserHenkouRireki2);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki3 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId3);
        if ( null != aT_UserHenkouRireki3 ) {

            baseDomManager.delete(aT_UserHenkouRireki3);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki4 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId4);
        if ( null != aT_UserHenkouRireki4 ) {

            baseDomManager.delete(aT_UserHenkouRireki4);
        }

        AT_UserHenkouRireki aT_UserHenkouRireki5 = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId5);
        if ( null != aT_UserHenkouRireki5 ) {

            baseDomManager.delete(aT_UserHenkouRireki5);
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
        String pUniqueId = "UNI0000001";
        AT_UserHenkouRireki aT_UserHenkouRireki = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId);

        assertEquals(pUniqueId, aT_UserHenkouRireki.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        AT_UserHenkouRireki aT_UserHenkouRireki = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId);

        assertNull(aT_UserHenkouRireki);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        AT_UserHenkouRireki aT_UserHenkouRireki = baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId);

        assertNull(aT_UserHenkouRireki);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        try {
            baseDomManager.getUserHenkouRirekiByUniqueId(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }

    }
}
