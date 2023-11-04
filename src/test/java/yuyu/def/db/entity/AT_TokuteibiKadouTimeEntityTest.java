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
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 特定日稼働時間テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_TokuteibiKadouTimeEntityTest implements EntityTestInterface {

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

        BizDate pKadouTimeSiteiYmd1 = BizDate.valueOf("20150309");
        BizDate pKadouTimeSiteiYmd2 = BizDate.valueOf("20150409");
        BizDate pKadouTimeSiteiYmd3 = BizDate.valueOf("20150509");
        BizDate pKadouTimeSiteiYmd4 = BizDate.valueOf("20150609");
        BizDate pKadouTimeSiteiYmd5 = BizDate.valueOf("20150709");

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd1);
        if ( null == aT_TokuteibiKadouTime1 ){

            aT_TokuteibiKadouTime1 = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime1.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd1);

        }

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd2);
        if ( null == aT_TokuteibiKadouTime2 ){

            aT_TokuteibiKadouTime2 = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime2.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd2);

        }

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd3);
        if ( null == aT_TokuteibiKadouTime3 ){

            aT_TokuteibiKadouTime3 = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime3.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd3);

        }

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd4);
        if ( null == aT_TokuteibiKadouTime4 ){

            aT_TokuteibiKadouTime4 = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime4.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd4);

        }

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd5);
        if ( null == aT_TokuteibiKadouTime5 ){

            aT_TokuteibiKadouTime5 = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime5.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd5);

        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd = "KGC0000001";

        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        if ( null != aT_KadouTimeGroup ){

            aT_KadouTimeGroup.getTokuteibiKadouTimes().removeAll(aT_KadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(aT_KadouTimeGroup);
            baseDomManager.delete(aT_KadouTimeGroup);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pKadouTimeGroupCd = "KGC0000001";
        List<AT_TokuteibiKadouTime> tokuteibiKadouTimeList = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTimes();

        List<AT_TokuteibiKadouTime> resultTokuteibiKadouTimeList = ImmutableList.copyOf(Iterables.filter(tokuteibiKadouTimeList, new Predicate<AT_TokuteibiKadouTime>() {

            @Override
            public boolean apply(AT_TokuteibiKadouTime pTokuteibiKadouTimeEntity) {

                List<BizDate> pKadouTimeSiteiYmdList = new ArrayList<BizDate>();
                pKadouTimeSiteiYmdList.add(BizDate.valueOf("20150309"));
                pKadouTimeSiteiYmdList.add(BizDate.valueOf("20150409"));
                pKadouTimeSiteiYmdList.add(BizDate.valueOf("20150509"));
                pKadouTimeSiteiYmdList.add(BizDate.valueOf("20150609"));
                pKadouTimeSiteiYmdList.add(BizDate.valueOf("20150709"));

                for ( BizDate kadouTimeSiteiYmd : pKadouTimeSiteiYmdList ){
                    if ( kadouTimeSiteiYmd.equals(pTokuteibiKadouTimeEntity.getKadouTimeSiteiYmd())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultTokuteibiKadouTimeList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000001";
        BizDate pKadouTimeSiteiYmd = BizDate.valueOf("20150309");
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd);

        assertEquals(pKadouTimeGroupCd, aT_TokuteibiKadouTime.getKadouTimeGroupCd());
        assertEquals(pKadouTimeSiteiYmd, aT_TokuteibiKadouTime.getKadouTimeSiteiYmd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000001";
        BizDate pKadouTimeSiteiYmd = BizDate.valueOf("20991231");
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(pKadouTimeSiteiYmd);

        assertNull(aT_TokuteibiKadouTime);
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
            baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd).getTokuteibiKadouTime(null);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
