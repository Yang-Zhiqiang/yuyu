package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 排他制御テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_HaitaSeigyoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHaitaSyuruiCd = "HSC0000001";

        AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
        if ( null == aM_HaitaSyurui ) {

            aM_HaitaSyurui = new AM_HaitaSyurui();
            aM_HaitaSyurui.setHaitaSyuruiCd(pHaitaSyuruiCd);

            baseDomManager.insert(aM_HaitaSyurui);
        }

        String pHaitaKey1 = "HK00000001";
        String pHaitaKey2 = "HK00000002";
        String pHaitaKey3 = "HK00000003";
        String pHaitaKey4 = "HK00000004";
        String pHaitaKey5 = "HK00000005";
        String pHaitamotoKinouId1 = "HKI0000001";
        String pHaitamotoKinouId2 = "HKI0000002";
        String pHaitamotoKinouId3 = "HKI0000003";
        String pHaitamotoKinouId4 = "HKI0000004";
        String pHaitamotoKinouId5 = "HKI0000005";
        String pHaitaUserId1 = "HUI0000001";
        String pHaitaUserId2 = "HUI0000002";
        String pHaitaUserId3 = "HUI0000003";
        String pHaitaUserId4 = "HUI0000004";
        String pHaitaUserId5 = "HUI0000005";
        String pHaitaKaisiTime1 = "20130613000000001";
        String pHaitaKaisiTime2 = "20130613000000001";
        String pHaitaKaisiTime3 = "20130613000000001";
        String pHaitaKaisiTime4 = "20130613000000001";
        String pHaitaKaisiTime5 = "20130613000000001";
        String pHaitaUniqueKey1 = "HUK0000001";
        String pHaitaUniqueKey2 = "HUK0000002";
        String pHaitaUniqueKey3 = "HUK0000003";
        String pHaitaUniqueKey4 = "HUK0000004";
        String pHaitaUniqueKey5 = "HUK0000005";

        AT_HaitaSeigyo aT_HaitaSeigyo1 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey1);
        if ( null == aT_HaitaSeigyo1 ){

            aT_HaitaSeigyo1 = new AT_HaitaSeigyo();
            aT_HaitaSeigyo1.setHaitaSyuruiCd(pHaitaSyuruiCd);
            aT_HaitaSeigyo1.setHaitaKey(pHaitaKey1);
            aT_HaitaSeigyo1.setHaitamotoKinouId(pHaitamotoKinouId1);
            aT_HaitaSeigyo1.setHaitaUserId(pHaitaUserId1);
            aT_HaitaSeigyo1.setHaitaKaisiTime(pHaitaKaisiTime1);
            aT_HaitaSeigyo1.setHaitaUniqueKey(pHaitaUniqueKey1);

            baseDomManager.insert(aT_HaitaSeigyo1);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo2 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey2);
        if ( null == aT_HaitaSeigyo2 ){

            aT_HaitaSeigyo2 = new AT_HaitaSeigyo();
            aT_HaitaSeigyo2.setHaitaSyuruiCd(pHaitaSyuruiCd);
            aT_HaitaSeigyo2.setHaitaKey(pHaitaKey2);
            aT_HaitaSeigyo2.setHaitamotoKinouId(pHaitamotoKinouId2);
            aT_HaitaSeigyo2.setHaitaUserId(pHaitaUserId2);
            aT_HaitaSeigyo2.setHaitaKaisiTime(pHaitaKaisiTime2);
            aT_HaitaSeigyo2.setHaitaUniqueKey(pHaitaUniqueKey2);

            baseDomManager.insert(aT_HaitaSeigyo2);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo3 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey3);
        if ( null == aT_HaitaSeigyo3 ){

            aT_HaitaSeigyo3 = new AT_HaitaSeigyo();
            aT_HaitaSeigyo3.setHaitaSyuruiCd(pHaitaSyuruiCd);
            aT_HaitaSeigyo3.setHaitaKey(pHaitaKey3);
            aT_HaitaSeigyo3.setHaitamotoKinouId(pHaitamotoKinouId3);
            aT_HaitaSeigyo3.setHaitaUserId(pHaitaUserId3);
            aT_HaitaSeigyo3.setHaitaKaisiTime(pHaitaKaisiTime3);
            aT_HaitaSeigyo3.setHaitaUniqueKey(pHaitaUniqueKey3);

            baseDomManager.insert(aT_HaitaSeigyo3);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo4 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey4);
        if ( null == aT_HaitaSeigyo4 ){

            aT_HaitaSeigyo4 = new AT_HaitaSeigyo();
            aT_HaitaSeigyo4.setHaitaSyuruiCd(pHaitaSyuruiCd);
            aT_HaitaSeigyo4.setHaitaKey(pHaitaKey4);
            aT_HaitaSeigyo4.setHaitamotoKinouId(pHaitamotoKinouId4);
            aT_HaitaSeigyo4.setHaitaUserId(pHaitaUserId4);
            aT_HaitaSeigyo4.setHaitaKaisiTime(pHaitaKaisiTime4);
            aT_HaitaSeigyo4.setHaitaUniqueKey(pHaitaUniqueKey4);

            baseDomManager.insert(aT_HaitaSeigyo4);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo5 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey5);
        if ( null == aT_HaitaSeigyo5 ){

            aT_HaitaSeigyo5 = new AT_HaitaSeigyo();
            aT_HaitaSeigyo5.setHaitaSyuruiCd(pHaitaSyuruiCd);
            aT_HaitaSeigyo5.setHaitaKey(pHaitaKey5);
            aT_HaitaSeigyo5.setHaitamotoKinouId(pHaitamotoKinouId5);
            aT_HaitaSeigyo5.setHaitaUserId(pHaitaUserId5);
            aT_HaitaSeigyo5.setHaitaKaisiTime(pHaitaKaisiTime5);
            aT_HaitaSeigyo5.setHaitaUniqueKey(pHaitaUniqueKey5);

            baseDomManager.insert(aT_HaitaSeigyo5);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHaitaSyuruiCd = "HSC0000001";
        String pHaitaKey1 = "HK00000001";
        String pHaitaKey2 = "HK00000002";
        String pHaitaKey3 = "HK00000003";
        String pHaitaKey4 = "HK00000004";
        String pHaitaKey5 = "HK00000005";

        AT_HaitaSeigyo aT_HaitaSeigyo1 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey1);
        if ( null != aT_HaitaSeigyo1 ) {

            baseDomManager.delete(aT_HaitaSeigyo1);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo2 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey2);
        if ( null != aT_HaitaSeigyo2 ) {

            baseDomManager.delete(aT_HaitaSeigyo2);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo3 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey3);
        if ( null != aT_HaitaSeigyo3 ) {

            baseDomManager.delete(aT_HaitaSeigyo3);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo4 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey4);
        if ( null != aT_HaitaSeigyo4 ) {

            baseDomManager.delete(aT_HaitaSeigyo4);
        }

        AT_HaitaSeigyo aT_HaitaSeigyo5 = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey5);
        if ( null != aT_HaitaSeigyo5 ) {

            baseDomManager.delete(aT_HaitaSeigyo5);
        }

        AM_HaitaSyurui aM_HaitaSyurui = baseDomManager.getHaitaSyuruiByHaitaSyuruiCd(pHaitaSyuruiCd);
        if ( null != aM_HaitaSyurui ) {

            baseDomManager.delete(aM_HaitaSyurui);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_HaitaSeigyo> haitaSeigyoList = baseDomManager.getAllHaitaSeigyos();

        List<AT_HaitaSeigyo> resultHaitaSeigyoList = ImmutableList.copyOf(Iterables.filter(haitaSeigyoList, new Predicate<AT_HaitaSeigyo>() {

            @Override
            public boolean apply(AT_HaitaSeigyo pHaitaSeigyoEntity) {

                List<String> pHaitaKeyList = new ArrayList<String>();
                String pHaitaSyuruiCd = "HSC0000001";
                pHaitaKeyList.add("HK00000001");
                pHaitaKeyList.add("HK00000002");
                pHaitaKeyList.add("HK00000003");
                pHaitaKeyList.add("HK00000004");
                pHaitaKeyList.add("HK00000005");

                for (String haitaKey : pHaitaKeyList) {
                    if (haitaKey.equals(pHaitaSeigyoEntity.getHaitaKey()) && pHaitaSyuruiCd.equals(pHaitaSeigyoEntity.getHaitaSyuruiCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultHaitaSeigyoList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pHaitaSyuruiCd = "HSC0000001";
        String pHaitaKey = "HK00000001";
        AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

        assertEquals(pHaitaSyuruiCd, aT_HaitaSeigyo.getHaitaSyuruiCd());
        assertEquals(pHaitaKey, aT_HaitaSeigyo.getHaitaKey());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHaitaSyuruiCd = "HSC0000001";
        String pHaitaKey = "HK00000099";
        AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

        assertNull(aT_HaitaSeigyo);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHaitaSyuruiCd = "HSC0000001";
        String pHaitaKey = "";
        AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);

        assertNull(aT_HaitaSeigyo);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHaitaSyuruiCd = "HSC0000001";
        String pHaitaKey = null;
        try {
            AT_HaitaSeigyo aT_HaitaSeigyo = baseDomManager.getHaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
