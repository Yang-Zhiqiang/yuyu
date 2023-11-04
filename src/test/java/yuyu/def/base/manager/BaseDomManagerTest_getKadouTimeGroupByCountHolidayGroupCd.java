package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getKadouTimeGroupByCountHolidayGroupCd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getKadouTimeGroupByCountHolidayGroupCd extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null == aT_HolidayGroup1 ) {

            aT_HolidayGroup1 = new AT_HolidayGroup();
            aT_HolidayGroup1.setHolidayGroupCd(pHolidayGroupCd1);

            baseDomManager.insert(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null == aT_HolidayGroup2 ) {

            aT_HolidayGroup2 = new AT_HolidayGroup();
            aT_HolidayGroup2.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_HolidayGroup2);
        }

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";
        String pKadouTimeGroupCd3 = "KGC0000003";
        String pKadouTimeGroupCd4 = "KGC0000004";
        String pKadouTimeGroupCd5 = "KGC0000005";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null == aT_KadouTimeGroup1 ) {

            aT_KadouTimeGroup1 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup1.setKadouTimeGroupCd(pKadouTimeGroupCd1);

            baseDomManager.insert(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null == aT_KadouTimeGroup2 ) {

            aT_KadouTimeGroup2 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup2.setKadouTimeGroupCd(pKadouTimeGroupCd2);
            aT_KadouTimeGroup2.setHolidayGroupCd(pHolidayGroupCd1);

            baseDomManager.insert(aT_KadouTimeGroup2);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd3);
        if ( null == aT_KadouTimeGroup3 ) {

            aT_KadouTimeGroup3 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup3.setKadouTimeGroupCd(pKadouTimeGroupCd3);
            aT_KadouTimeGroup3.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_KadouTimeGroup3);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd4);
        if ( null == aT_KadouTimeGroup4 ) {

            aT_KadouTimeGroup4 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup4.setKadouTimeGroupCd(pKadouTimeGroupCd4);
            aT_KadouTimeGroup4.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_KadouTimeGroup4);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd5);
        if ( null == aT_KadouTimeGroup5 ) {

            aT_KadouTimeGroup5 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup5.setKadouTimeGroupCd(pKadouTimeGroupCd5);
            aT_KadouTimeGroup5.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_KadouTimeGroup5);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null != aT_HolidayGroup1 ) {

            aT_HolidayGroup1.getHolidayYoyakus().removeAll(aT_HolidayGroup1.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup1);
            baseDomManager.delete(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null != aT_HolidayGroup2 ) {

            aT_HolidayGroup2.getHolidayYoyakus().removeAll(aT_HolidayGroup2.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup2);
            baseDomManager.delete(aT_HolidayGroup2);
        }

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";
        String pKadouTimeGroupCd3 = "KGC0000003";
        String pKadouTimeGroupCd4 = "KGC0000004";
        String pKadouTimeGroupCd5 = "KGC0000005";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null != aT_KadouTimeGroup1 ) {

            baseDomManager.delete(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null != aT_KadouTimeGroup2 ) {

            baseDomManager.delete(aT_KadouTimeGroup2);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd3);
        if ( null != aT_KadouTimeGroup3 ) {

            baseDomManager.delete(aT_KadouTimeGroup3);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd4);
        if ( null != aT_KadouTimeGroup4 ) {

            baseDomManager.delete(aT_KadouTimeGroup4);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd5);
        if ( null != aT_KadouTimeGroup5 ) {

            baseDomManager.delete(aT_KadouTimeGroup5);
        }

    }

    @Test
    public void test001(){
        String pHolidayGroupCd = "HGC0000099";
        long count = baseDomManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pHolidayGroupCd = "HGC0000001";
        long count = baseDomManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);

        assertEquals(1, count);

    }

    @Test
    public void test003(){
        String pHolidayGroupCd = "HGC0000002";
        long count = baseDomManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        String pHolidayGroupCd = "";
        long count = baseDomManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);

        assertEquals(0, count);

    }

    @Test
    public void test005(){
        String pHolidayGroupCd = null;
        long count = baseDomManager.getKadouTimeGroupByCountHolidayGroupCd(pHolidayGroupCd);

        assertEquals(0, count);

    }

}
