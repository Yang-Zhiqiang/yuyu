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
import yuyu.def.classification.C_AccessLogSyubetuKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * アクセスログテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_AccessLogEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId1 = "LI00000001";
        String pLogId2 = "LI00000002";
        String pLogId3 = "LI00000003";
        String pLogId4 = "LI00000004";
        String pLogId5 = "LI00000005";
        long pTimeStamp1 = 0;
        long pTimeStamp2 = 0;
        long pTimeStamp3 = 0;
        long pTimeStamp4 = 0;
        long pTimeStamp5 = 0;
        C_AccessLogSyubetuKbn pLogKindCd1 = C_AccessLogSyubetuKbn.BLNK;
        C_AccessLogSyubetuKbn pLogKindCd2 = C_AccessLogSyubetuKbn.BLNK;
        C_AccessLogSyubetuKbn pLogKindCd3 = C_AccessLogSyubetuKbn.BLNK;
        C_AccessLogSyubetuKbn pLogKindCd4 = C_AccessLogSyubetuKbn.BLNK;
        C_AccessLogSyubetuKbn pLogKindCd5 = C_AccessLogSyubetuKbn.BLNK;
        long pSyousaiKensuu1 = 0;
        long pSyousaiKensuu2 = 1;
        long pSyousaiKensuu3 = 2;
        long pSyousaiKensuu4 = 3;
        long pSyousaiKensuu5 = 4;

        AT_AccessLog aT_AccessLog1 = baseDomManager.getAccessLog(pLogId1);
        if ( null == aT_AccessLog1 ){

            aT_AccessLog1 = new AT_AccessLog();
            aT_AccessLog1.setLogId(pLogId1);
            aT_AccessLog1.setTimeStamp(pTimeStamp1);
            aT_AccessLog1.setLogKindCd(pLogKindCd1);
            aT_AccessLog1.setSyousaiKensuu(pSyousaiKensuu1);

            baseDomManager.insert(aT_AccessLog1);
        }

        AT_AccessLog aT_AccessLog2 = baseDomManager.getAccessLog(pLogId2);
        if ( null == aT_AccessLog2 ){

            aT_AccessLog2 = new AT_AccessLog();
            aT_AccessLog2.setLogId(pLogId2);
            aT_AccessLog2.setTimeStamp(pTimeStamp2);
            aT_AccessLog2.setLogKindCd(pLogKindCd2);
            aT_AccessLog2.setSyousaiKensuu(pSyousaiKensuu2);

            baseDomManager.insert(aT_AccessLog2);
        }

        AT_AccessLog aT_AccessLog3 = baseDomManager.getAccessLog(pLogId3);
        if ( null == aT_AccessLog3 ){

            aT_AccessLog3 = new AT_AccessLog();
            aT_AccessLog3.setLogId(pLogId3);
            aT_AccessLog3.setTimeStamp(pTimeStamp3);
            aT_AccessLog3.setLogKindCd(pLogKindCd3);
            aT_AccessLog3.setSyousaiKensuu(pSyousaiKensuu3);

            baseDomManager.insert(aT_AccessLog3);
        }

        AT_AccessLog aT_AccessLog4 = baseDomManager.getAccessLog(pLogId4);
        if ( null == aT_AccessLog4 ){

            aT_AccessLog4 = new AT_AccessLog();
            aT_AccessLog4.setLogId(pLogId4);
            aT_AccessLog4.setTimeStamp(pTimeStamp4);
            aT_AccessLog4.setLogKindCd(pLogKindCd4);
            aT_AccessLog4.setSyousaiKensuu(pSyousaiKensuu4);

            baseDomManager.insert(aT_AccessLog4);
        }

        AT_AccessLog aT_AccessLog5 = baseDomManager.getAccessLog(pLogId5);
        if ( null == aT_AccessLog5 ){

            aT_AccessLog5 = new AT_AccessLog();
            aT_AccessLog5.setLogId(pLogId5);
            aT_AccessLog5.setTimeStamp(pTimeStamp5);
            aT_AccessLog5.setLogKindCd(pLogKindCd5);
            aT_AccessLog5.setSyousaiKensuu(pSyousaiKensuu5);

            baseDomManager.insert(aT_AccessLog5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId1 = "LI00000001";
        String pLogId2 = "LI00000002";
        String pLogId3 = "LI00000003";
        String pLogId4 = "LI00000004";
        String pLogId5 = "LI00000005";

        AT_AccessLog aT_AccessLog1 = baseDomManager.getAccessLog(pLogId1);
        if (null != aT_AccessLog1) {

            baseDomManager.delete(aT_AccessLog1);
        }

        AT_AccessLog aT_AccessLog2 = baseDomManager.getAccessLog(pLogId2);
        if (null != aT_AccessLog2) {

            baseDomManager.delete(aT_AccessLog2);
        }

        AT_AccessLog aT_AccessLog3 = baseDomManager.getAccessLog(pLogId3);
        if (null != aT_AccessLog3) {

            baseDomManager.delete(aT_AccessLog3);
        }

        AT_AccessLog aT_AccessLog4 = baseDomManager.getAccessLog(pLogId4);
        if (null != aT_AccessLog4) {

            baseDomManager.delete(aT_AccessLog4);
        }

        AT_AccessLog aT_AccessLog5 = baseDomManager.getAccessLog(pLogId5);
        if (null != aT_AccessLog5) {

            baseDomManager.delete(aT_AccessLog5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();

        List<AT_AccessLog> resultAccessLogList = ImmutableList.copyOf(Iterables.filter(accessLogList, new Predicate<AT_AccessLog>() {

            @Override
            public boolean apply(AT_AccessLog pAccessLogEntity) {

                List<String> subAccessLogIdList = new ArrayList<String>();
                subAccessLogIdList.add("LI00000001");
                subAccessLogIdList.add("LI00000002");
                subAccessLogIdList.add("LI00000003");
                subAccessLogIdList.add("LI00000004");
                subAccessLogIdList.add("LI00000005");

                for (String accessLogId : subAccessLogIdList) {
                    if (accessLogId.equals(pAccessLogEntity.getLogId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultAccessLogList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pLogId = "LI00000001";
        AT_AccessLog aT_AccessLog = baseDomManager.getAccessLog(pLogId);

        assertEquals(pLogId, aT_AccessLog.getLogId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pLogId = "LI00000099";
        AT_AccessLog aT_AccessLog = baseDomManager.getAccessLog(pLogId);

        assertNull(aT_AccessLog);
    }

    @Override
    @Test
    public void blankCondition() {
        String pLogId = "";
        AT_AccessLog aT_AccessLog = baseDomManager.getAccessLog(pLogId);

        assertNull(aT_AccessLog);
    }

    @Override
    @Test
    public void nullCondition() {
        String pLogId = null;
        try {
            baseDomManager.getAccessLog(pLogId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
