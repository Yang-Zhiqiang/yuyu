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
 * パスワード履歴 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_PasswordRirekiEntityTest implements EntityTestInterface {

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

        AT_PasswordRireki aT_PasswordRireki1 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId1);
        if ( null == aT_PasswordRireki1 ) {

            aT_PasswordRireki1 = new AT_PasswordRireki();
            aT_PasswordRireki1.setUniqueId(pUniqueId1);

            baseDomManager.insert(aT_PasswordRireki1);
        }

        AT_PasswordRireki aT_PasswordRireki2 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId2);
        if ( null == aT_PasswordRireki2 ) {

            aT_PasswordRireki2 = new AT_PasswordRireki();
            aT_PasswordRireki2.setUniqueId(pUniqueId2);

            baseDomManager.insert(aT_PasswordRireki2);
        }

        AT_PasswordRireki aT_PasswordRireki3 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId3);
        if ( null == aT_PasswordRireki3 ) {

            aT_PasswordRireki3 = new AT_PasswordRireki();
            aT_PasswordRireki3.setUniqueId(pUniqueId3);

            baseDomManager.insert(aT_PasswordRireki3);
        }

        AT_PasswordRireki aT_PasswordRireki4 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId4);
        if ( null == aT_PasswordRireki4 ) {

            aT_PasswordRireki4 = new AT_PasswordRireki();
            aT_PasswordRireki4.setUniqueId(pUniqueId4);

            baseDomManager.insert(aT_PasswordRireki4);
        }

        AT_PasswordRireki aT_PasswordRireki5 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId5);
        if ( null == aT_PasswordRireki5 ) {

            aT_PasswordRireki5 = new AT_PasswordRireki();
            aT_PasswordRireki5.setUniqueId(pUniqueId5);

            baseDomManager.insert(aT_PasswordRireki5);
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

        AT_PasswordRireki aT_PasswordRireki1 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId1);
        if ( null != aT_PasswordRireki1 ) {

            baseDomManager.delete(aT_PasswordRireki1);
        }

        AT_PasswordRireki aT_PasswordRireki2 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId2);
        if ( null != aT_PasswordRireki2 ) {

            baseDomManager.delete(aT_PasswordRireki2);
        }

        AT_PasswordRireki aT_PasswordRireki3 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId3);
        if ( null != aT_PasswordRireki3 ) {

            baseDomManager.delete(aT_PasswordRireki3);
        }

        AT_PasswordRireki aT_PasswordRireki4 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId4);
        if ( null != aT_PasswordRireki4 ) {

            baseDomManager.delete(aT_PasswordRireki4);
        }

        AT_PasswordRireki aT_PasswordRireki5 = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId5);
        if ( null != aT_PasswordRireki5 ) {

            baseDomManager.delete(aT_PasswordRireki5);
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
        AT_PasswordRireki aT_PasswordRireki = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId);

        assertEquals(pUniqueId, aT_PasswordRireki.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        AT_PasswordRireki aT_PasswordRireki = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId);

        assertNull(aT_PasswordRireki);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        AT_PasswordRireki aT_PasswordRireki = baseDomManager.getPasswordRirekiByUniqueId(pUniqueId);

        assertNull(aT_PasswordRireki);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        try {
            baseDomManager.getPasswordRirekiByUniqueId(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
