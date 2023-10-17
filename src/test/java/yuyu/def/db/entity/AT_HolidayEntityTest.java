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
 * 休日テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_HolidayEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd = "HGC0000001";

        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);
        if ( null == aT_HolidayGroup ){

            aT_HolidayGroup = new AT_HolidayGroup();
            aT_HolidayGroup.setHolidayGroupCd(pHolidayGroupCd);

            baseDomManager.insert(aT_HolidayGroup);
        }

        String pHolidayCd1 = "HC00000001";
        String pHolidayCd2 = "HC00000002";
        String pHolidayCd3 = "HC00000003";
        String pHolidayCd4 = "HC00000004";
        String pHolidayCd5 = "HC00000005";

        AT_Holiday aT_Holiday1 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd1);
        if ( null == aT_Holiday1 ){

            aT_Holiday1 = aT_HolidayGroup.createHoliday();
            aT_Holiday1.setHolidayCd(pHolidayCd1);
        }

        AT_Holiday aT_Holiday2 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd2);
        if ( null == aT_Holiday2 ){

            aT_Holiday2 = aT_HolidayGroup.createHoliday();
            aT_Holiday2.setHolidayCd(pHolidayCd2);
        }

        AT_Holiday aT_Holiday3 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd3);
        if ( null == aT_Holiday3 ){

            aT_Holiday3 = aT_HolidayGroup.createHoliday();
            aT_Holiday3.setHolidayCd(pHolidayCd3);
        }

        AT_Holiday aT_Holiday4 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd4);
        if ( null == aT_Holiday4 ){

            aT_Holiday4 = aT_HolidayGroup.createHoliday();
            aT_Holiday4.setHolidayCd(pHolidayCd4);
        }

        AT_Holiday aT_Holiday5 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd5);
        if ( null == aT_Holiday5 ){

            aT_Holiday5 = aT_HolidayGroup.createHoliday();
            aT_Holiday5.setHolidayCd(pHolidayCd5);
        }

        baseDomManager.update(aT_HolidayGroup);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd = "HGC0000001";

        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);
        if ( null != aT_HolidayGroup ){

            aT_HolidayGroup.getHolidays().removeAll(aT_HolidayGroup.getHolidays());

            baseDomManager.update(aT_HolidayGroup);
            baseDomManager.delete(aT_HolidayGroup);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pHolidayGroupCd ="HGC0000001";
        List<AT_Holiday> holidayList = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidays();

        List<AT_Holiday> resultHolidayList = ImmutableList.copyOf(Iterables.filter(holidayList, new Predicate<AT_Holiday>() {

            @Override
            public boolean apply(AT_Holiday pHolidayEntity) {

                List<String> pHolidayCdList = new ArrayList<String>();
                pHolidayCdList.add("HC00000001");
                pHolidayCdList.add("HC00000002");
                pHolidayCdList.add("HC00000003");
                pHolidayCdList.add("HC00000004");
                pHolidayCdList.add("HC00000005");

                for (String holidayCd : pHolidayCdList) {
                    if (holidayCd.equals(pHolidayEntity.getHolidayCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultHolidayList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pHolidayGroupCd = "HGC0000001";
        String pHolidayCd = "HC00000001";
        AT_Holiday aT_Holiday = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd);

        assertEquals(pHolidayGroupCd, aT_Holiday.getHolidayGroupCd());
        assertEquals(pHolidayCd, aT_Holiday.getHolidayCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHolidayGroupCd = "HGC0000001";
        String pHolidayCd = "HC00000099";
        AT_Holiday aT_Holiday = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd);

        assertNull(aT_Holiday);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHolidayGroupCd = "HGC0000001";
        String pHolidayCd = "";
        AT_Holiday aT_Holiday = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd);

        assertNull(aT_Holiday);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHolidayGroupCd = "HGC0000001";
        String pHolidayCd = null;
        try {
            baseDomManager.getHolidayGroup(pHolidayGroupCd).getHoliday(pHolidayCd);
        } catch (Exception e) {
            assertThat(e,  instanceOf(NonUniqueResultException.class));
        }
    }
}
