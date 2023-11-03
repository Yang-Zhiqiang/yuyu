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
 * 帳票保存テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_TyouhyouHozonEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pReportKey1 = "CK00000001";
        String pReportKey2 = "CK00000002";
        String pReportKey3 = "CK00000003";
        String pReportKey4 = "CK00000004";
        String pReportKey5 = "CK00000005";

        AT_TyouhyouHozon aT_TyouhyouHozon1 = baseDomManager.getTyouhyouHozon(pReportKey1);
        if ( null == aT_TyouhyouHozon1 ){

            aT_TyouhyouHozon1 = new AT_TyouhyouHozon();
            aT_TyouhyouHozon1.setReportKey(pReportKey1);

            baseDomManager.insert(aT_TyouhyouHozon1);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon2 = baseDomManager.getTyouhyouHozon(pReportKey2);
        if ( null == aT_TyouhyouHozon2 ){

            aT_TyouhyouHozon2 = new AT_TyouhyouHozon();
            aT_TyouhyouHozon2.setReportKey(pReportKey2);

            baseDomManager.insert(aT_TyouhyouHozon2);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon3 = baseDomManager.getTyouhyouHozon(pReportKey3);
        if ( null == aT_TyouhyouHozon3 ){

            aT_TyouhyouHozon3 = new AT_TyouhyouHozon();
            aT_TyouhyouHozon3.setReportKey(pReportKey3);

            baseDomManager.insert(aT_TyouhyouHozon3);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon4 = baseDomManager.getTyouhyouHozon(pReportKey4);
        if ( null == aT_TyouhyouHozon4 ){

            aT_TyouhyouHozon4 = new AT_TyouhyouHozon();
            aT_TyouhyouHozon4.setReportKey(pReportKey4);

            baseDomManager.insert(aT_TyouhyouHozon4);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon5 = baseDomManager.getTyouhyouHozon(pReportKey5);
        if ( null == aT_TyouhyouHozon5 ){

            aT_TyouhyouHozon5 = new AT_TyouhyouHozon();
            aT_TyouhyouHozon5.setReportKey(pReportKey5);

            baseDomManager.insert(aT_TyouhyouHozon5);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pReportKey1 = "CK00000001";
        String pReportKey2 = "CK00000002";
        String pReportKey3 = "CK00000003";
        String pReportKey4 = "CK00000004";
        String pReportKey5 = "CK00000005";

        AT_TyouhyouHozon aT_TyouhyouHozon1 = baseDomManager.getTyouhyouHozon(pReportKey1);
        if ( null != aT_TyouhyouHozon1 ){

            baseDomManager.delete(aT_TyouhyouHozon1);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon2 = baseDomManager.getTyouhyouHozon(pReportKey2);
        if ( null != aT_TyouhyouHozon2 ){

            baseDomManager.delete(aT_TyouhyouHozon2);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon3 = baseDomManager.getTyouhyouHozon(pReportKey3);
        if ( null != aT_TyouhyouHozon3 ){

            baseDomManager.delete(aT_TyouhyouHozon3);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon4 = baseDomManager.getTyouhyouHozon(pReportKey4);
        if ( null != aT_TyouhyouHozon4 ){

            baseDomManager.delete(aT_TyouhyouHozon4);
        }

        AT_TyouhyouHozon aT_TyouhyouHozon5 = baseDomManager.getTyouhyouHozon(pReportKey5);
        if ( null != aT_TyouhyouHozon5 ){

            baseDomManager.delete(aT_TyouhyouHozon5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pReportKey = "CK00000001";
        AT_TyouhyouHozon aT_TyouhyouHozon = baseDomManager.getTyouhyouHozon(pReportKey);

        assertEquals(pReportKey, aT_TyouhyouHozon.getReportKey());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pReportKey = "CK00000099";
        AT_TyouhyouHozon aT_TyouhyouHozon = baseDomManager.getTyouhyouHozon(pReportKey);

        assertNull(aT_TyouhyouHozon);
    }

    @Override
    @Test
    public void blankCondition() {
        String pReportKey = "";
        AT_TyouhyouHozon aT_TyouhyouHozon = baseDomManager.getTyouhyouHozon(pReportKey);

        assertNull(aT_TyouhyouHozon);
    }

    @Override
    @Test
    public void nullCondition() {
        String pReportKey = null;
        try {
            baseDomManager.getTyouhyouHozon(pReportKey);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }

}
