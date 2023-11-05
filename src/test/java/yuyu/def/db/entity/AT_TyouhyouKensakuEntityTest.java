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
 * 帳票検索テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_TyouhyouKensakuEntityTest implements EntityTestInterface {

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

        AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
        if ( null == aT_TyouhyouKensaku1 ){

            aT_TyouhyouKensaku1 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku1.setUniqueId(pUniqueId1);

            baseDomManager.insert(aT_TyouhyouKensaku1);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
        if ( null == aT_TyouhyouKensaku2 ){

            aT_TyouhyouKensaku2 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku2.setUniqueId(pUniqueId2);

            baseDomManager.insert(aT_TyouhyouKensaku2);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
        if ( null == aT_TyouhyouKensaku3 ){

            aT_TyouhyouKensaku3 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku3.setUniqueId(pUniqueId3);

            baseDomManager.insert(aT_TyouhyouKensaku3);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
        if ( null == aT_TyouhyouKensaku4 ){

            aT_TyouhyouKensaku4 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku4.setUniqueId(pUniqueId4);

            baseDomManager.insert(aT_TyouhyouKensaku4);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
        if ( null == aT_TyouhyouKensaku5 ){

            aT_TyouhyouKensaku5 = new AT_TyouhyouKensaku();
            aT_TyouhyouKensaku5.setUniqueId(pUniqueId5);

            baseDomManager.insert(aT_TyouhyouKensaku5);
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

        AT_TyouhyouKensaku aT_TyouhyouKensaku1 = baseDomManager.getTyouhyouKensaku(pUniqueId1);
        if ( null != aT_TyouhyouKensaku1 ){

            baseDomManager.delete(aT_TyouhyouKensaku1);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku2 = baseDomManager.getTyouhyouKensaku(pUniqueId2);
        if ( null != aT_TyouhyouKensaku2 ){

            baseDomManager.delete(aT_TyouhyouKensaku2);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku3 = baseDomManager.getTyouhyouKensaku(pUniqueId3);
        if ( null != aT_TyouhyouKensaku3 ){

            baseDomManager.delete(aT_TyouhyouKensaku3);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku4 = baseDomManager.getTyouhyouKensaku(pUniqueId4);
        if ( null != aT_TyouhyouKensaku4 ){

            baseDomManager.delete(aT_TyouhyouKensaku4);
        }

        AT_TyouhyouKensaku aT_TyouhyouKensaku5 = baseDomManager.getTyouhyouKensaku(pUniqueId5);
        if ( null != aT_TyouhyouKensaku5 ){

            baseDomManager.delete(aT_TyouhyouKensaku5);
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
        AT_TyouhyouKensaku aT_TyouhyouKensaku = baseDomManager.getTyouhyouKensaku(pUniqueId);

        assertEquals(pUniqueId, aT_TyouhyouKensaku.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        AT_TyouhyouKensaku aT_TyouhyouKensaku = baseDomManager.getTyouhyouKensaku(pUniqueId);

        assertNull(aT_TyouhyouKensaku);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        AT_TyouhyouKensaku aT_TyouhyouKensaku = baseDomManager.getTyouhyouKensaku(pUniqueId);

        assertNull(aT_TyouhyouKensaku);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        try {
            baseDomManager.getTyouhyouKensaku(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
