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
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 稼働時間テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_KadouTimeEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd = "KGC0000001";

        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        if ( null == aT_KadouTimeGroup ){

            aT_KadouTimeGroup = new AT_KadouTimeGroup();
            aT_KadouTimeGroup.setKadouTimeGroupCd(pKadouTimeGroupCd);

            baseDomManager.insert(aT_KadouTimeGroup);
        }

        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn1 = C_KadouTimeYoubiKbn.NITIYOU;
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn2 = C_KadouTimeYoubiKbn.GETUYOU;
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn3 = C_KadouTimeYoubiKbn.KAYOU;
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn4 = C_KadouTimeYoubiKbn.SUIYOU;
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn5 = C_KadouTimeYoubiKbn.MOKUYOU;
        C_EigyoubiKbn pEigyoubiKbn1 = C_EigyoubiKbn.EIGYOUBI;
        C_EigyoubiKbn pEigyoubiKbn2 = C_EigyoubiKbn.EIGYOUBI;
        C_EigyoubiKbn pEigyoubiKbn3 = C_EigyoubiKbn.HIEIGYOUBI;
        C_EigyoubiKbn pEigyoubiKbn4 = C_EigyoubiKbn.EIGYOUBI;
        C_EigyoubiKbn pEigyoubiKbn5 = C_EigyoubiKbn.HIEIGYOUBI;

        AT_KadouTime aT_KadouTime1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn1, pEigyoubiKbn1);
        if ( null == aT_KadouTime1 ){

            aT_KadouTime1 = aT_KadouTimeGroup.createKadouTime();
            aT_KadouTime1.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn1);
            aT_KadouTime1.setEigyoubiKbn(pEigyoubiKbn1);
        }

        AT_KadouTime aT_KadouTime2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn2, pEigyoubiKbn2);
        if ( null == aT_KadouTime2 ){

            aT_KadouTime2 = aT_KadouTimeGroup.createKadouTime();
            aT_KadouTime2.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn2);
            aT_KadouTime2.setEigyoubiKbn(pEigyoubiKbn2);
        }

        AT_KadouTime aT_KadouTime3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn3, pEigyoubiKbn3);
        if ( null == aT_KadouTime3 ){

            aT_KadouTime3 = aT_KadouTimeGroup.createKadouTime();
            aT_KadouTime3.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn3);
            aT_KadouTime3.setEigyoubiKbn(pEigyoubiKbn3);
        }

        AT_KadouTime aT_KadouTime4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn4, pEigyoubiKbn4);
        if ( null == aT_KadouTime4 ){

            aT_KadouTime4 = aT_KadouTimeGroup.createKadouTime();
            aT_KadouTime4.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn4);
            aT_KadouTime4.setEigyoubiKbn(pEigyoubiKbn4);
        }

        AT_KadouTime aT_KadouTime5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn5, pEigyoubiKbn5);
        if ( null == aT_KadouTime5 ){

            aT_KadouTime5 = aT_KadouTimeGroup.createKadouTime();
            aT_KadouTime5.setKadouTimeYoubiKbn(pKadouTimeYoubiKbn5);
            aT_KadouTime5.setEigyoubiKbn(pEigyoubiKbn5);
        }

        baseDomManager.update(aT_KadouTimeGroup);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd = "KGC0000001";

        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        if ( null != aT_KadouTimeGroup ){

            aT_KadouTimeGroup.getKadouTimes().removeAll(aT_KadouTimeGroup.getKadouTimes());

            baseDomManager.update(aT_KadouTimeGroup);
            baseDomManager.delete(aT_KadouTimeGroup);

        }
    }

    @Override
    @Test
    public void getAll() {

        String pKadouTimeGroupCd = "KGC0000001";
        List<AT_KadouTime> kadouTimeList = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTimes();

        List<AT_KadouTime> resultKadouTimeList = ImmutableList.copyOf(Iterables.filter(kadouTimeList, new Predicate<AT_KadouTime>() {

            @Override
            public boolean apply(AT_KadouTime pKadouTimeEntity) {

                List<C_KadouTimeYoubiKbn> pKadouTimeYoubiKbnList = new ArrayList<C_KadouTimeYoubiKbn>();
                pKadouTimeYoubiKbnList.add(C_KadouTimeYoubiKbn.NITIYOU);
                pKadouTimeYoubiKbnList.add(C_KadouTimeYoubiKbn.GETUYOU);
                pKadouTimeYoubiKbnList.add(C_KadouTimeYoubiKbn.KAYOU);
                pKadouTimeYoubiKbnList.add(C_KadouTimeYoubiKbn.SUIYOU);
                pKadouTimeYoubiKbnList.add(C_KadouTimeYoubiKbn.MOKUYOU);

                List<C_EigyoubiKbn> pEigyoubiKbnList = new ArrayList<C_EigyoubiKbn>();
                pEigyoubiKbnList.add(C_EigyoubiKbn.EIGYOUBI);
                pEigyoubiKbnList.add(C_EigyoubiKbn.EIGYOUBI);
                pEigyoubiKbnList.add(C_EigyoubiKbn.HIEIGYOUBI);
                pEigyoubiKbnList.add(C_EigyoubiKbn.EIGYOUBI);
                pEigyoubiKbnList.add(C_EigyoubiKbn.HIEIGYOUBI);

                for ( int idx = 0; idx < pKadouTimeYoubiKbnList.size(); idx++ ){
                    if ( pKadouTimeYoubiKbnList.get(idx).eq(pKadouTimeEntity.getKadouTimeYoubiKbn())
                        && pEigyoubiKbnList.get(idx).eq(pKadouTimeEntity.getEigyoubiKbn())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultKadouTimeList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000001";
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn = C_KadouTimeYoubiKbn.NITIYOU;
        C_EigyoubiKbn pEigyoubiKbn = C_EigyoubiKbn.EIGYOUBI;
        AT_KadouTime aT_KadouTime = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn, pEigyoubiKbn);

        assertEquals(pKadouTimeGroupCd, aT_KadouTime.getKadouTimeGroupCd());
        assertEquals(pKadouTimeYoubiKbn, aT_KadouTime.getKadouTimeYoubiKbn());
        assertEquals(pEigyoubiKbn, aT_KadouTime.getEigyoubiKbn());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000001";
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn = C_KadouTimeYoubiKbn.DOYOU;
        C_EigyoubiKbn pEigyoubiKbn = C_EigyoubiKbn.HIEIGYOUBI;
        AT_KadouTime aT_KadouTime = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(pKadouTimeYoubiKbn, pEigyoubiKbn);

        assertNull(aT_KadouTime);
    }

    @Override
    @Test
    public void blankCondition() {
    }

    @Override
    @Test
    public void nullCondition() {
        String pKadouTimeGroupCd = "KGC0000001";
        try {
            baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getKadouTime(null, null);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
