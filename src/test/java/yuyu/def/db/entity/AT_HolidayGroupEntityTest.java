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
 * 休日グループテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_HolidayGroupEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";
        String pHolidayGroupCd3 = "HGC0000003";
        String pHolidayGroupCd4 = "HGC0000004";
        String pHolidayGroupCd5 = "HGC0000005";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null == aT_HolidayGroup1 ){

            aT_HolidayGroup1 = new AT_HolidayGroup();
            aT_HolidayGroup1.setHolidayGroupCd(pHolidayGroupCd1);

            baseDomManager.insert(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null == aT_HolidayGroup2 ){

            aT_HolidayGroup2 = new AT_HolidayGroup();
            aT_HolidayGroup2.setHolidayGroupCd(pHolidayGroupCd2);

            baseDomManager.insert(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null == aT_HolidayGroup3 ){

            aT_HolidayGroup3 = new AT_HolidayGroup();
            aT_HolidayGroup3.setHolidayGroupCd(pHolidayGroupCd3);

            baseDomManager.insert(aT_HolidayGroup3);
        }

        AT_HolidayGroup aT_HolidayGroup4 = baseDomManager.getHolidayGroup(pHolidayGroupCd4);
        if ( null == aT_HolidayGroup4 ){

            aT_HolidayGroup4 = new AT_HolidayGroup();
            aT_HolidayGroup4.setHolidayGroupCd(pHolidayGroupCd4);

            baseDomManager.insert(aT_HolidayGroup4);
        }

        AT_HolidayGroup aT_HolidayGroup5 = baseDomManager.getHolidayGroup(pHolidayGroupCd5);
        if ( null == aT_HolidayGroup5 ){

            aT_HolidayGroup5 = new AT_HolidayGroup();
            aT_HolidayGroup5.setHolidayGroupCd(pHolidayGroupCd5);

            baseDomManager.insert(aT_HolidayGroup5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHolidayGroupCd1 = "HGC0000001";
        String pHolidayGroupCd2 = "HGC0000002";
        String pHolidayGroupCd3 = "HGC0000003";
        String pHolidayGroupCd4 = "HGC0000004";
        String pHolidayGroupCd5 = "HGC0000005";

        AT_HolidayGroup aT_HolidayGroup1 = baseDomManager.getHolidayGroup(pHolidayGroupCd1);
        if ( null != aT_HolidayGroup1 ){

            baseDomManager.delete(aT_HolidayGroup1);
        }

        AT_HolidayGroup aT_HolidayGroup2 = baseDomManager.getHolidayGroup(pHolidayGroupCd2);
        if ( null != aT_HolidayGroup2 ){

            baseDomManager.delete(aT_HolidayGroup2);
        }

        AT_HolidayGroup aT_HolidayGroup3 = baseDomManager.getHolidayGroup(pHolidayGroupCd3);
        if ( null != aT_HolidayGroup3 ){

            baseDomManager.delete(aT_HolidayGroup3);
        }

        AT_HolidayGroup aT_HolidayGroup4 = baseDomManager.getHolidayGroup(pHolidayGroupCd4);
        if ( null != aT_HolidayGroup4 ){

            baseDomManager.delete(aT_HolidayGroup4);
        }

        AT_HolidayGroup aT_HolidayGroup5 = baseDomManager.getHolidayGroup(pHolidayGroupCd5);
        if ( null != aT_HolidayGroup5 ){

            baseDomManager.delete(aT_HolidayGroup5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_HolidayGroup> holidayGroupList = baseDomManager.getAllHolidayGroups();

        List<AT_HolidayGroup> resultHolidayGroupList = ImmutableList.copyOf(Iterables.filter(holidayGroupList, new Predicate<AT_HolidayGroup>() {

            @Override
            public boolean apply(AT_HolidayGroup pHolidayGroupEntity) {

                List<String> pHolidayGroupCdList = new ArrayList<String>();
                pHolidayGroupCdList.add("HGC0000001");
                pHolidayGroupCdList.add("HGC0000002");
                pHolidayGroupCdList.add("HGC0000003");
                pHolidayGroupCdList.add("HGC0000004");
                pHolidayGroupCdList.add("HGC0000005");

                for (String holidayGroupCd : pHolidayGroupCdList) {
                    if (holidayGroupCd.equals(pHolidayGroupEntity.getHolidayGroupCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultHolidayGroupList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pHolidayGroupCd = "HGC0000001";
        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);

        assertEquals(pHolidayGroupCd, aT_HolidayGroup.getHolidayGroupCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHolidayGroupCd = "HGC0000099";
        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);

        assertNull(aT_HolidayGroup);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHolidayGroupCd = "";
        AT_HolidayGroup aT_HolidayGroup = baseDomManager.getHolidayGroup(pHolidayGroupCd);

        assertNull(aT_HolidayGroup);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHolidayGroupCd = null;
        try {
            baseDomManager.getHolidayGroup(pHolidayGroupCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
