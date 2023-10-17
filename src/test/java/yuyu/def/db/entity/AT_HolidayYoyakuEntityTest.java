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
 * 休日予約テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_HolidayYoyakuEntityTest implements EntityTestInterface {

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

        AT_HolidayYoyaku aT_HolidayYoyaku1 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd1);
        if ( null == aT_HolidayYoyaku1 ){

            aT_HolidayYoyaku1 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku1.setHolidayCd(pHolidayCd1);
        }

        AT_HolidayYoyaku aT_HolidayYoyaku2 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd2);
        if ( null == aT_HolidayYoyaku2 ){

            aT_HolidayYoyaku2 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku2.setHolidayCd(pHolidayCd2);
        }

        AT_HolidayYoyaku aT_HolidayYoyaku3 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd3);
        if ( null == aT_HolidayYoyaku3 ){

            aT_HolidayYoyaku3 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku3.setHolidayCd(pHolidayCd3);
        }

        AT_HolidayYoyaku aT_HolidayYoyaku4 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd4);
        if ( null == aT_HolidayYoyaku4 ){

            aT_HolidayYoyaku4 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku4.setHolidayCd(pHolidayCd4);
        }

        AT_HolidayYoyaku aT_HolidayYoyaku5 = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd5);
        if ( null == aT_HolidayYoyaku5 ){

            aT_HolidayYoyaku5 = aT_HolidayGroup.createHolidayYoyaku();
            aT_HolidayYoyaku5.setHolidayCd(pHolidayCd5);
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

            aT_HolidayGroup.getHolidayYoyakus().removeAll(aT_HolidayGroup.getHolidayYoyakus());

            baseDomManager.update(aT_HolidayGroup);
            baseDomManager.delete(aT_HolidayGroup);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pHolidayGroupCd ="HGC0000001";
        List<AT_HolidayYoyaku> holidayYoyakuList = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyakus();

        List<AT_HolidayYoyaku> resultHolidayYoyakuList = ImmutableList.copyOf(Iterables.filter(holidayYoyakuList, new Predicate<AT_HolidayYoyaku>() {

            @Override
            public boolean apply(AT_HolidayYoyaku pHolidayYoyakuEntity) {

                List<String> pHolidayYoyakuCdList = new ArrayList<String>();
                pHolidayYoyakuCdList.add("HC00000001");
                pHolidayYoyakuCdList.add("HC00000002");
                pHolidayYoyakuCdList.add("HC00000003");
                pHolidayYoyakuCdList.add("HC00000004");
                pHolidayYoyakuCdList.add("HC00000005");

                for (String holidayCd : pHolidayYoyakuCdList) {
                    if (holidayCd.equals(pHolidayYoyakuEntity.getHolidayCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultHolidayYoyakuList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pHolidayGroupCd ="HGC0000001";
        String pHolidayCd = "HC00000001";
        AT_HolidayYoyaku aT_HolidayYoyaku = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd);

        assertEquals(pHolidayGroupCd, aT_HolidayYoyaku.getHolidayGroupCd());
        assertEquals(pHolidayCd, aT_HolidayYoyaku.getHolidayCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHolidayGroupCd ="HGC0000001";
        String pHolidayCd = "HC00000099";
        AT_HolidayYoyaku aT_HolidayYoyaku = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd);

        assertNull(aT_HolidayYoyaku);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHolidayGroupCd ="HGC0000001";
        String pHolidayCd = "";
        AT_HolidayYoyaku aT_HolidayYoyaku = baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd);

        assertNull(aT_HolidayYoyaku);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHolidayGroupCd = "HGC0000001";
        String pHolidayCd = null;
        try {
            baseDomManager.getHolidayGroup(pHolidayGroupCd).getHolidayYoyaku(pHolidayCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
