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
import org.slf4j.Logger;

import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getCountHolidayByHolidayPattern() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getCountHolidayByHolidayPattern extends AbstractTest {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd = "HGC0000001";

        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);
        if ( null == aT_HolidayGroup ) {

            aT_HolidayGroup = new AT_HolidayGroup();
            aT_HolidayGroup.setHolidayGroupCd(pHolidayGroupCd);

            baseDomManager.insert(aT_HolidayGroup);
        }

        String pHolidayCd1 = "HC00000001";
        String pHolidayCd2 = "HC00000002";
        String pHolidayCd3 = "HC00000003";
        String pHolidayCd4 = "HC00000004";
        String pHolidayPatternParam1 = "HPP0000001";
        String pHolidayPatternParam2 = "HPP0000002";
        String pHolidayPatternParam3 = "HPP0000001";
        String pHolidayPatternParam4 = "HPP0000001";

        AT_Holiday aT_Holiday1 = aT_HolidayGroup.getHoliday(pHolidayCd1);
        if ( null == aT_Holiday1 ) {

            aT_Holiday1 = aT_HolidayGroup.createHoliday();
            aT_Holiday1.setHolidayCd(pHolidayCd1);
            aT_Holiday1.setHolidayPatternParam(pHolidayPatternParam1);

        }

        AT_Holiday aT_Holiday2 = aT_HolidayGroup.getHoliday(pHolidayCd2);
        if ( null == aT_Holiday2 ) {

            aT_Holiday2 = aT_HolidayGroup.createHoliday();
            aT_Holiday2.setHolidayCd(pHolidayCd2);
            aT_Holiday2.setHolidayPatternParam(pHolidayPatternParam2);

        }

        AT_Holiday aT_Holiday3 = aT_HolidayGroup.getHoliday(pHolidayCd3);
        if ( null == aT_Holiday3 ) {

            aT_Holiday3 = aT_HolidayGroup.createHoliday();
            aT_Holiday3.setHolidayCd(pHolidayCd3);
            aT_Holiday3.setHolidayPatternParam(pHolidayPatternParam3);

        }

        AT_Holiday aT_Holiday4 = aT_HolidayGroup.getHoliday(pHolidayCd4);
        if ( null == aT_Holiday4 ) {

            aT_Holiday4 = aT_HolidayGroup.createHoliday();
            aT_Holiday4.setHolidayCd(pHolidayCd4);
            aT_Holiday4.setHolidayPatternParam(pHolidayPatternParam4);

        }

        baseDomManager.update(aT_HolidayGroup);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd = "HGC0000001";

        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);
        if ( null != aT_HolidayGroup ) {

            aT_HolidayGroup.getHolidays().removeAll(aT_HolidayGroup.getHolidays());

            baseDomManager.update(aT_HolidayGroup);
            baseDomManager.delete(aT_HolidayGroup);
        }
    }

    @Test
    public void test001(){
        String pHolidayPatternParam = "HPP0000099";
        long count = baseDomManager.getCountHolidayByHolidayPattern(pHolidayPatternParam);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pHolidayPatternParam = "HPP0000002";
        long count = baseDomManager.getCountHolidayByHolidayPattern(pHolidayPatternParam);

        assertEquals(1, count);

    }

    @Test
    public void test003(){
        String pHolidayPatternParam = "HPP0000001";
        long count = baseDomManager.getCountHolidayByHolidayPattern(pHolidayPatternParam);

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        String pHolidayPatternParam = "";
        long count = baseDomManager.getCountHolidayByHolidayPattern(pHolidayPatternParam);

        assertEquals(0, count);

    }
}