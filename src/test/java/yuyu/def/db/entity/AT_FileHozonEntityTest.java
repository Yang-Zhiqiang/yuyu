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
 * ファイル保存テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_FileHozonEntityTest implements EntityTestInterface {

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

        AT_FileHozon aT_FileHozon1 = baseDomManager.getFileHozon(pUniqueId1);
        if ( null == aT_FileHozon1 ) {

            aT_FileHozon1 = new AT_FileHozon();
            aT_FileHozon1.setUniqueId(pUniqueId1);

            baseDomManager.insert(aT_FileHozon1);
        }

        AT_FileHozon aT_FileHozon2 = baseDomManager.getFileHozon(pUniqueId2);
        if ( null == aT_FileHozon2 ) {

            aT_FileHozon2 = new AT_FileHozon();
            aT_FileHozon2.setUniqueId(pUniqueId2);

            baseDomManager.insert(aT_FileHozon2);
        }

        AT_FileHozon aT_FileHozon3 = baseDomManager.getFileHozon(pUniqueId3);
        if ( null == aT_FileHozon3 ) {

            aT_FileHozon3 = new AT_FileHozon();
            aT_FileHozon3.setUniqueId(pUniqueId3);

            baseDomManager.insert(aT_FileHozon3);
        }

        AT_FileHozon aT_FileHozon4 = baseDomManager.getFileHozon(pUniqueId4);
        if ( null == aT_FileHozon4 ) {

            aT_FileHozon4 = new AT_FileHozon();
            aT_FileHozon4.setUniqueId(pUniqueId4);

            baseDomManager.insert(aT_FileHozon4);
        }

        AT_FileHozon aT_FileHozon5 = baseDomManager.getFileHozon(pUniqueId5);
        if ( null == aT_FileHozon5 ) {

            aT_FileHozon5 = new AT_FileHozon();
            aT_FileHozon5.setUniqueId(pUniqueId5);

            baseDomManager.insert(aT_FileHozon5);
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

        AT_FileHozon aT_FileHozon1 = baseDomManager.getFileHozon(pUniqueId1);
        if ( null != aT_FileHozon1 ) {

            baseDomManager.delete(aT_FileHozon1);
        }

        AT_FileHozon aT_FileHozon2 = baseDomManager.getFileHozon(pUniqueId2);
        if ( null != aT_FileHozon2 ) {

            baseDomManager.delete(aT_FileHozon2);
        }

        AT_FileHozon aT_FileHozon3 = baseDomManager.getFileHozon(pUniqueId3);
        if ( null != aT_FileHozon3 ) {

            baseDomManager.delete(aT_FileHozon3);
        }

        AT_FileHozon aT_FileHozon4 = baseDomManager.getFileHozon(pUniqueId4);
        if ( null != aT_FileHozon4 ) {

            baseDomManager.delete(aT_FileHozon4);
        }

        AT_FileHozon aT_FileHozon5 = baseDomManager.getFileHozon(pUniqueId5);
        if ( null != aT_FileHozon5 ) {

            baseDomManager.delete(aT_FileHozon5);
        }

    }

    @Override
    @Test
    public void getAll() {

    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUniqueId = "UNI0000001";
        AT_FileHozon aT_FileHozon = baseDomManager.getFileHozon(pUniqueId);

        assertEquals(pUniqueId, aT_FileHozon.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        AT_FileHozon aT_FileHozon = baseDomManager.getFileHozon(pUniqueId);

        assertNull(aT_FileHozon);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        AT_FileHozon aT_FileHozon = baseDomManager.getFileHozon(pUniqueId);

        assertNull(aT_FileHozon);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        try {
            baseDomManager.getFileHozon(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }

    }
}
