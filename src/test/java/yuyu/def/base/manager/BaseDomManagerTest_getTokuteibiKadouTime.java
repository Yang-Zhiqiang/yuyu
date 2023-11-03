package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getTokuteibiKadouTime() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getTokuteibiKadouTime extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd = "KGC0000001";

        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        if ( null == aT_KadouTimeGroup ) {

            aT_KadouTimeGroup = new AT_KadouTimeGroup();
            aT_KadouTimeGroup.setKadouTimeGroupCd(pKadouTimeGroupCd);

            baseDomManager.insert(aT_KadouTimeGroup);

        }

        BizDate pKadouTimeSiteiYmd = BizDate.valueOf("20150806");

        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = aT_KadouTimeGroup.getTokuteibiKadouTime(pKadouTimeSiteiYmd);
        if ( null == aT_TokuteibiKadouTime ) {

            aT_TokuteibiKadouTime = aT_KadouTimeGroup.createTokuteibiKadouTime();
            aT_TokuteibiKadouTime.setKadouTimeSiteiYmd(pKadouTimeSiteiYmd);

        }

        baseDomManager.update(aT_KadouTimeGroup);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd = "KGC0000001";

        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        if ( null != aT_KadouTimeGroup ) {

            aT_KadouTimeGroup.getTokuteibiKadouTimes().removeAll(aT_KadouTimeGroup.getTokuteibiKadouTimes());

            baseDomManager.update(aT_KadouTimeGroup);
            baseDomManager.delete(aT_KadouTimeGroup);
        }

    }

    @Test
    public void test001(){
        String pKadouTimeGroupCd = "KGC0000099";
        BizDate pKadouTimeSiteiYmd = BizDate.valueOf("20151231");
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = baseDomManager.getTokuteibiKadouTime(pKadouTimeGroupCd, pKadouTimeSiteiYmd);

        assertNull(aT_TokuteibiKadouTime);

    }

    @Test
    public void test002(){
        String pKadouTimeGroupCd = "KGC0000001";
        BizDate pKadouTimeSiteiYmd = BizDate.valueOf("20150806");
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = baseDomManager.getTokuteibiKadouTime(pKadouTimeGroupCd, pKadouTimeSiteiYmd);

        assertNotNull(null, aT_TokuteibiKadouTime);
    }

    @Test
    public void test003(){
        String pKadouTimeGroupCd = null;
        BizDate pKadouTimeSiteiYmd = null;
        AT_TokuteibiKadouTime aT_TokuteibiKadouTime = baseDomManager.getTokuteibiKadouTime(pKadouTimeGroupCd, pKadouTimeSiteiYmd);

        assertNotNull(aT_TokuteibiKadouTime);
    }
}
