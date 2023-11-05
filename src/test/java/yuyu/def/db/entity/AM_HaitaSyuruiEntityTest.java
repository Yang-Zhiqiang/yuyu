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
 * 排他種類マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AM_HaitaSyuruiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHaitaSyuruiCd1 = "HSC0000001";
        String pHaitaSyuruiCd2 = "HSC0000002";
        String pHaitaSyuruiCd3 = "HSC0000003";
        String pHaitaSyuruiCd4 = "HSC0000004";
        String pHaitaSyuruiCd5 = "HSC0000005";

        AM_HaitaSyurui aM_HaitaSyurui1 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd1);
        if ( null == aM_HaitaSyurui1 ){

            aM_HaitaSyurui1 = new AM_HaitaSyurui();
            aM_HaitaSyurui1.setHaitaSyuruiCd(pHaitaSyuruiCd1);

            baseDomManager.insert(aM_HaitaSyurui1);
        }

        AM_HaitaSyurui aM_HaitaSyurui2 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd2);
        if ( null == aM_HaitaSyurui2 ){

            aM_HaitaSyurui2 = new AM_HaitaSyurui();
            aM_HaitaSyurui2.setHaitaSyuruiCd(pHaitaSyuruiCd2);

            baseDomManager.insert(aM_HaitaSyurui2);
        }

        AM_HaitaSyurui aM_HaitaSyurui3 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd3);
        if ( null == aM_HaitaSyurui3 ){

            aM_HaitaSyurui3 = new AM_HaitaSyurui();
            aM_HaitaSyurui3.setHaitaSyuruiCd(pHaitaSyuruiCd3);

            baseDomManager.insert(aM_HaitaSyurui3);
        }

        AM_HaitaSyurui aM_HaitaSyurui4 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd4);
        if ( null == aM_HaitaSyurui4 ){

            aM_HaitaSyurui4 = new AM_HaitaSyurui();
            aM_HaitaSyurui4.setHaitaSyuruiCd(pHaitaSyuruiCd4);

            baseDomManager.insert(aM_HaitaSyurui4);
        }

        AM_HaitaSyurui aM_HaitaSyurui5 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd5);
        if ( null == aM_HaitaSyurui5 ){

            aM_HaitaSyurui5 = new AM_HaitaSyurui();
            aM_HaitaSyurui5.setHaitaSyuruiCd(pHaitaSyuruiCd5);

            baseDomManager.insert(aM_HaitaSyurui5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHaitaSyuruiCd1 = "HSC0000001";
        String pHaitaSyuruiCd2 = "HSC0000002";
        String pHaitaSyuruiCd3 = "HSC0000003";
        String pHaitaSyuruiCd4 = "HSC0000004";
        String pHaitaSyuruiCd5 = "HSC0000005";

        AM_HaitaSyurui aM_HaitaSyurui1 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd1);
        if ( null != aM_HaitaSyurui1 ){

            baseDomManager.delete(aM_HaitaSyurui1);
        }

        AM_HaitaSyurui aM_HaitaSyurui2 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd2);
        if ( null != aM_HaitaSyurui2 ){

            baseDomManager.delete(aM_HaitaSyurui2);
        }

        AM_HaitaSyurui aM_HaitaSyurui3 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd3);
        if ( null != aM_HaitaSyurui3 ){

            baseDomManager.delete(aM_HaitaSyurui3);
        }

        AM_HaitaSyurui aM_HaitaSyurui4 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd4);
        if ( null != aM_HaitaSyurui4 ){

            baseDomManager.delete(aM_HaitaSyurui4);
        }

        AM_HaitaSyurui aM_HaitaSyurui5 = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd5);
        if ( null != aM_HaitaSyurui5 ){

            baseDomManager.delete(aM_HaitaSyurui5);
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
        String pHaitaSyuruiCd = "HSC0000001";
        AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);

        assertEquals(pHaitaSyuruiCd, aM_HaitaSyurui.getHaitaSyuruiCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHaitaSyuruiCd = "HSC0000099";
        AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);

        assertNull(aM_HaitaSyurui);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHaitaSyuruiCd = "";
        AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);

        assertNull(aM_HaitaSyurui);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHaitaSyuruiCd = null;
        try {
            baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
