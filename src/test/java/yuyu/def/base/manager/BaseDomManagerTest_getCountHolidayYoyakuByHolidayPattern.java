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

import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getCountHolidayYoyakuByHolidayPattern() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getCountHolidayYoyakuByHolidayPattern extends AbstractTest {

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

        AT_HolidayYoyaku aT_HolidayYoyaku1 = aT_HolidayGroup.getHolidayYoyaku(pHolidayCd1);
        if ( null == aT_HolidayYoyaku1 ) {

            aT_HolidayYoyaku1 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku1.setHolidayCd(pHolidayCd1);
            aT_HolidayYoyaku1.setHolidayPatternParam(pHolidayPatternParam1);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku2 = aT_HolidayGroup.getHolidayYoyaku(pHolidayCd2);
        if ( null == aT_HolidayYoyaku2 ) {

            aT_HolidayYoyaku2 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku2.setHolidayCd(pHolidayCd2);
            aT_HolidayYoyaku2.setHolidayPatternParam(pHolidayPatternParam2);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku3 = aT_HolidayGroup.getHolidayYoyaku(pHolidayCd3);
        if ( null == aT_HolidayYoyaku3 ) {

            aT_HolidayYoyaku3 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku3.setHolidayCd(pHolidayCd3);
            aT_HolidayYoyaku3.setHolidayPatternParam(pHolidayPatternParam3);

        }

        AT_HolidayYoyaku aT_HolidayYoyaku4 = aT_HolidayGroup.getHolidayYoyaku(pHolidayCd4);
        if ( null == aT_HolidayYoyaku4 ) {

            aT_HolidayYoyaku4 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku4.setHolidayCd(pHolidayCd4);
            aT_HolidayYoyaku4.setHolidayPatternParam(pHolidayPatternParam4);

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

            aT_HolidayGroup.getHolidayYoyakus().removeAll(aT_HolidayGroup.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup);
            baseDomManager.delete(aT_HolidayGroup);
        }
    }

    @Test
    public void test001(){
        String pHolidayPatternParam = "HPP0000099";
        long count = baseDomManager.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pHolidayPatternParam = "HPP0000002";
        long count = baseDomManager.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);

        assertEquals(1, count);

    }

    @Test
    public void test003(){
        String pHolidayPatternParam = "HPP0000001";
        long count = baseDomManager.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        String pHolidayPatternParam = "";
        long count = baseDomManager.getCountHolidayYoyakuByHolidayPattern(pHolidayPatternParam);

        assertEquals(0, count);

    }

}