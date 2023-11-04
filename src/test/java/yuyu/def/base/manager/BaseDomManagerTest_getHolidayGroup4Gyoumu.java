package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getHolidayGroup4Gyoumu() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getHolidayGroup4Gyoumu extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000005";
        String pHolidayGroupCd2 = "HGC0000001";
        String pHolidayGroupCd3 = "HGC0000003";
        String pHolidayGroupCd4 = "HGC0000004";
        String pHolidayGroupCd5 = "HGC0000002";
        C_SysSiyouKbn pSysSiyouKbn = C_SysSiyouKbn.TUUJYOU;

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null == aT_HolidayGroup1 ) {

            aT_HolidayGroup1 = new AT_HolidayGroup();
            aT_HolidayGroup1.setHolidayGroupCd(pHolidayGroupCd1);
            aT_HolidayGroup1.setSysSiyouKbn(pSysSiyouKbn);

            baseDomManager.insert(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null == aT_HolidayGroup2 ) {

            aT_HolidayGroup2 = new AT_HolidayGroup();
            aT_HolidayGroup2.setHolidayGroupCd(pHolidayGroupCd2);
            aT_HolidayGroup2.setSysSiyouKbn(pSysSiyouKbn);

            baseDomManager.insert(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null == aT_HolidayGroup3 ) {

            aT_HolidayGroup3 = new AT_HolidayGroup();
            aT_HolidayGroup3.setHolidayGroupCd(pHolidayGroupCd3);
            aT_HolidayGroup3.setSysSiyouKbn(pSysSiyouKbn);

            baseDomManager.insert(aT_HolidayGroup3);
        }

        AT_HolidayGroup aT_HolidayGroup4 = baseDomManager.getHolidayGroup(pHolidayGroupCd4);
        if ( null == aT_HolidayGroup4 ) {

            aT_HolidayGroup4 = new AT_HolidayGroup();
            aT_HolidayGroup4.setHolidayGroupCd(pHolidayGroupCd4);
            aT_HolidayGroup4.setSysSiyouKbn(pSysSiyouKbn);

            baseDomManager.insert(aT_HolidayGroup4);
        }

        AT_HolidayGroup aT_HolidayGroup5 = baseDomManager.getHolidayGroup(pHolidayGroupCd5);
        if ( null == aT_HolidayGroup5 ) {

            aT_HolidayGroup5 = new AT_HolidayGroup();
            aT_HolidayGroup5.setHolidayGroupCd(pHolidayGroupCd5);
            aT_HolidayGroup5.setSysSiyouKbn(pSysSiyouKbn);

            baseDomManager.insert(aT_HolidayGroup5);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000005";
        String pHolidayGroupCd2 = "HGC0000001";
        String pHolidayGroupCd3 = "HGC0000003";
        String pHolidayGroupCd4 = "HGC0000004";
        String pHolidayGroupCd5 = "HGC0000002";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null != aT_HolidayGroup1 ) {

            baseDomManager.delete(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null != aT_HolidayGroup2 ) {

            baseDomManager.delete(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null != aT_HolidayGroup3 ) {

            baseDomManager.delete(aT_HolidayGroup3);
        }

        AT_HolidayGroup aT_HolidayGroup4 = baseDomManager.getHolidayGroup(pHolidayGroupCd4);
        if ( null != aT_HolidayGroup4 ) {

            baseDomManager.delete(aT_HolidayGroup4);
        }

        AT_HolidayGroup aT_HolidayGroup5 = baseDomManager.getHolidayGroup(pHolidayGroupCd5);
        if ( null != aT_HolidayGroup5 ) {

            baseDomManager.delete(aT_HolidayGroup5);
        }

    }

    @Test
    public void test001(){
        List<AT_HolidayGroup> aT_HolidayGroupList = baseDomManager.getHolidayGroup4Gyoumu();

        String pHolidayGroupCd1 = "HGC0000005";
        String pHolidayGroupCd2 = "HGC0000001";
        String pHolidayGroupCd3 = "HGC0000003";
        String pHolidayGroupCd4 = "HGC0000004";
        String pHolidayGroupCd5 = "HGC0000002";

        assertEquals(pHolidayGroupCd2, aT_HolidayGroupList.get(0).getHolidayGroupCd());
        assertEquals(pHolidayGroupCd5, aT_HolidayGroupList.get(1).getHolidayGroupCd());
        assertEquals(pHolidayGroupCd3, aT_HolidayGroupList.get(2).getHolidayGroupCd());
        assertEquals(pHolidayGroupCd4, aT_HolidayGroupList.get(3).getHolidayGroupCd());
        assertEquals(pHolidayGroupCd1, aT_HolidayGroupList.get(4).getHolidayGroupCd());

    }

}
