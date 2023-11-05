package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getAccessLogCount() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getAccessLogCount extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId1 = "LI00000001";
        String pLogId2 = "LI00000002";
        String pLogId3 = "LI00000003";
        String pLogId4 = "LI00000004";
        String pLogId5 = "LI00000005";
        String pLogId6 = "LI00000006";
        String pLogId7 = "LI00000007";
        String pLogId8 = "LI00000008";
        String pLogId9 = "LI00000009";
        String pLogId10 = "LI00000010";
        String pLogId11 = "LI00000011";
        String pSyoriUserId = "SUI0000001";
        String pIpAddress = "IA00000001";
        String pSessionId = "SEI0000001";
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        String pSubSystemId = "SSI0000001";
        String pCategoryId = "CI00000001";
        String pKinouId = "KI00000001";
        long pSyousaiKensuu = 0;
        long pTimeStamp1 = setSyoriTime(BizDate.valueOf("20150103"));
        long pTimeStamp2 = setSyoriTime(BizDate.valueOf("20150104"));
        long pTimeStamp3 = setSyoriTime(BizDate.valueOf("20150105"));
        long pTimeStamp4 = setSyoriTime(BizDate.valueOf("20150106"));
        long pTimeStamp5 = setSyoriTime(BizDate.valueOf("20150206"));
        long pTimeStamp6 = setSyoriTime(BizDate.valueOf("20150306"));
        long pTimeStamp7 = setSyoriTime(BizDate.valueOf("20150406"));
        long pTimeStamp8 = setSyoriTime(BizDate.valueOf("20150506"));
        long pTimeStamp9 = setSyoriTime(BizDate.valueOf("20150606"));
        long pTimeStamp10 = setSyoriTime(BizDate.valueOf("20150706"));
        long pTimeStamp11 = setSyoriTime(BizDate.valueOf("20150806"));

        C_KinouKbn pKinouKbn1 = C_KinouKbn.ONLINE;

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou1 ) {

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId);
            aS_Kinou1.setKinouKbn(pKinouKbn1);

            baseDomManager.insert(aS_Kinou1);
        }

        AT_AccessLog aT_AccessLog1 = baseDomManager.getAccessLog(pLogId1);
        if ( null == aT_AccessLog1 ) {

            aT_AccessLog1 = new AT_AccessLog();
            aT_AccessLog1.setLogId(pLogId1);
            aT_AccessLog1.setTimeStamp(pTimeStamp1);
            aT_AccessLog1.setSyoriUserId(pSyoriUserId);
            aT_AccessLog1.setIpAddress(pIpAddress);
            aT_AccessLog1.setSessionId(pSessionId);
            aT_AccessLog1.setLogKindCd(pLogKindCd);
            aT_AccessLog1.setSubSystemId(pSubSystemId);
            aT_AccessLog1.setCategoryId(pCategoryId);
            aT_AccessLog1.setKinouId(pKinouId);
            aT_AccessLog1.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog1);
        }

        AT_AccessLog aT_AccessLog2 = baseDomManager.getAccessLog(pLogId2);
        if ( null == aT_AccessLog2 ) {

            aT_AccessLog2 = new AT_AccessLog();
            aT_AccessLog2.setLogId(pLogId2);
            aT_AccessLog2.setTimeStamp(pTimeStamp2);
            aT_AccessLog2.setSyoriUserId(pSyoriUserId);
            aT_AccessLog2.setIpAddress(pIpAddress);
            aT_AccessLog2.setSessionId(pSessionId);
            aT_AccessLog2.setLogKindCd(pLogKindCd);
            aT_AccessLog2.setSubSystemId(pSubSystemId);
            aT_AccessLog2.setCategoryId(pCategoryId);
            aT_AccessLog2.setKinouId(pKinouId);
            aT_AccessLog2.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog2);
        }

        AT_AccessLog aT_AccessLog3 = baseDomManager.getAccessLog(pLogId3);
        if ( null == aT_AccessLog3 ) {

            aT_AccessLog3 = new AT_AccessLog();
            aT_AccessLog3.setLogId(pLogId3);
            aT_AccessLog3.setTimeStamp(pTimeStamp3);
            aT_AccessLog3.setSyoriUserId(pSyoriUserId);
            aT_AccessLog3.setIpAddress(pIpAddress);
            aT_AccessLog3.setSessionId(pSessionId);
            aT_AccessLog3.setLogKindCd(pLogKindCd);
            aT_AccessLog3.setSubSystemId(pSubSystemId);
            aT_AccessLog3.setCategoryId(pCategoryId);
            aT_AccessLog3.setKinouId(pKinouId);
            aT_AccessLog3.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog3);
        }

        AT_AccessLog aT_AccessLog4 = baseDomManager.getAccessLog(pLogId4);
        if ( null == aT_AccessLog4 ) {

            aT_AccessLog4 = new AT_AccessLog();
            aT_AccessLog4.setLogId(pLogId4);
            aT_AccessLog4.setTimeStamp(pTimeStamp4);
            aT_AccessLog4.setSyoriUserId(pSyoriUserId);
            aT_AccessLog4.setIpAddress(pIpAddress);
            aT_AccessLog4.setSessionId(pSessionId);
            aT_AccessLog4.setLogKindCd(pLogKindCd);
            aT_AccessLog4.setSubSystemId(pSubSystemId);
            aT_AccessLog4.setCategoryId(pCategoryId);
            aT_AccessLog4.setKinouId(pKinouId);
            aT_AccessLog4.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog4);
        }

        AT_AccessLog aT_AccessLog5 = baseDomManager.getAccessLog(pLogId5);
        if ( null == aT_AccessLog5 ) {

            aT_AccessLog5 = new AT_AccessLog();
            aT_AccessLog5.setLogId(pLogId5);
            aT_AccessLog5.setTimeStamp(pTimeStamp5);
            aT_AccessLog5.setSyoriUserId(pSyoriUserId);
            aT_AccessLog5.setIpAddress(pIpAddress);
            aT_AccessLog5.setSessionId(pSessionId);
            aT_AccessLog5.setLogKindCd(pLogKindCd);
            aT_AccessLog5.setSubSystemId(pSubSystemId);
            aT_AccessLog5.setCategoryId(pCategoryId);
            aT_AccessLog5.setKinouId(pKinouId);
            aT_AccessLog5.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog5);
        }

        AT_AccessLog aT_AccessLog6 = baseDomManager.getAccessLog(pLogId6);
        if ( null == aT_AccessLog6 ) {

            aT_AccessLog6 = new AT_AccessLog();
            aT_AccessLog6.setLogId(pLogId6);
            aT_AccessLog6.setTimeStamp(pTimeStamp6);
            aT_AccessLog6.setSyoriUserId(pSyoriUserId);
            aT_AccessLog6.setIpAddress(pIpAddress);
            aT_AccessLog6.setSessionId(pSessionId);
            aT_AccessLog6.setLogKindCd(pLogKindCd);
            aT_AccessLog6.setSubSystemId(pSubSystemId);
            aT_AccessLog6.setCategoryId(pCategoryId);
            aT_AccessLog6.setKinouId(pKinouId);
            aT_AccessLog6.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog6);
        }

        AT_AccessLog aT_AccessLog7 = baseDomManager.getAccessLog(pLogId7);
        if ( null == aT_AccessLog7 ) {

            aT_AccessLog7 = new AT_AccessLog();
            aT_AccessLog7.setLogId(pLogId7);
            aT_AccessLog7.setTimeStamp(pTimeStamp7);
            aT_AccessLog7.setSyoriUserId(pSyoriUserId);
            aT_AccessLog7.setIpAddress(pIpAddress);
            aT_AccessLog7.setSessionId(pSessionId);
            aT_AccessLog7.setLogKindCd(pLogKindCd);
            aT_AccessLog7.setSubSystemId(pSubSystemId);
            aT_AccessLog7.setCategoryId(pCategoryId);
            aT_AccessLog7.setKinouId(pKinouId);
            aT_AccessLog7.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog7);
        }

        AT_AccessLog aT_AccessLog8 = baseDomManager.getAccessLog(pLogId8);
        if ( null == aT_AccessLog8 ) {

            aT_AccessLog8 = new AT_AccessLog();
            aT_AccessLog8.setLogId(pLogId8);
            aT_AccessLog8.setTimeStamp(pTimeStamp8);
            aT_AccessLog8.setSyoriUserId(pSyoriUserId);
            aT_AccessLog8.setIpAddress(pIpAddress);
            aT_AccessLog8.setSessionId(pSessionId);
            aT_AccessLog8.setLogKindCd(pLogKindCd);
            aT_AccessLog8.setSubSystemId(pSubSystemId);
            aT_AccessLog8.setCategoryId(pCategoryId);
            aT_AccessLog8.setKinouId(pKinouId);
            aT_AccessLog8.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog8);
        }

        AT_AccessLog aT_AccessLog9 = baseDomManager.getAccessLog(pLogId9);
        if ( null == aT_AccessLog9 ) {

            aT_AccessLog9 = new AT_AccessLog();
            aT_AccessLog9.setLogId(pLogId9);
            aT_AccessLog9.setTimeStamp(pTimeStamp9);
            aT_AccessLog9.setSyoriUserId(pSyoriUserId);
            aT_AccessLog9.setIpAddress(pIpAddress);
            aT_AccessLog9.setSessionId(pSessionId);
            aT_AccessLog9.setLogKindCd(pLogKindCd);
            aT_AccessLog9.setSubSystemId(pSubSystemId);
            aT_AccessLog9.setCategoryId(pCategoryId);
            aT_AccessLog9.setKinouId(pKinouId);
            aT_AccessLog9.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog9);
        }

        AT_AccessLog aT_AccessLog10 = baseDomManager.getAccessLog(pLogId10);
        if ( null == aT_AccessLog10 ) {

            aT_AccessLog10 = new AT_AccessLog();
            aT_AccessLog10.setLogId(pLogId10);
            aT_AccessLog10.setTimeStamp(pTimeStamp10);
            aT_AccessLog10.setSyoriUserId(pSyoriUserId);
            aT_AccessLog10.setIpAddress(pIpAddress);
            aT_AccessLog10.setSessionId(pSessionId);
            aT_AccessLog10.setLogKindCd(pLogKindCd);
            aT_AccessLog10.setSubSystemId(pSubSystemId);
            aT_AccessLog10.setCategoryId(pCategoryId);
            aT_AccessLog10.setKinouId(pKinouId);
            aT_AccessLog10.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog10);
        }

        AT_AccessLog aT_AccessLog11 = baseDomManager.getAccessLog(pLogId11);
        if ( null == aT_AccessLog11 ) {

            aT_AccessLog11 = new AT_AccessLog();
            aT_AccessLog11.setLogId(pLogId11);
            aT_AccessLog11.setTimeStamp(pTimeStamp11);
            aT_AccessLog11.setSyoriUserId(pSyoriUserId);
            aT_AccessLog11.setIpAddress(pIpAddress);
            aT_AccessLog11.setSessionId(pSessionId);
            aT_AccessLog11.setLogKindCd(pLogKindCd);
            aT_AccessLog11.setSubSystemId(pSubSystemId);
            aT_AccessLog11.setCategoryId(pCategoryId);
            aT_AccessLog11.setKinouId(pKinouId);
            aT_AccessLog11.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog11);
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
        String pLogId6 = "LI00000006";
        String pLogId7 = "LI00000007";
        String pLogId8 = "LI00000008";
        String pLogId9 = "LI00000009";
        String pLogId10 = "LI00000010";
        String pLogId11 = "LI00000011";

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

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

        AT_AccessLog aT_AccessLog6 = baseDomManager.getAccessLog(pLogId6);
        if (null != aT_AccessLog6) {

            baseDomManager.delete(aT_AccessLog6);
        }

        AT_AccessLog aT_AccessLog7 = baseDomManager.getAccessLog(pLogId7);
        if (null != aT_AccessLog7) {

            baseDomManager.delete(aT_AccessLog7);
        }

        AT_AccessLog aT_AccessLog8 = baseDomManager.getAccessLog(pLogId8);
        if (null != aT_AccessLog8) {

            baseDomManager.delete(aT_AccessLog8);
        }

        AT_AccessLog aT_AccessLog9 = baseDomManager.getAccessLog(pLogId9);
        if (null != aT_AccessLog9) {

            baseDomManager.delete(aT_AccessLog9);
        }

        AT_AccessLog aT_AccessLog10 = baseDomManager.getAccessLog(pLogId10);
        if (null != aT_AccessLog10) {

            baseDomManager.delete(aT_AccessLog10);
        }

        AT_AccessLog aT_AccessLog11 = baseDomManager.getAccessLog(pLogId11);
        if (null != aT_AccessLog11) {

            baseDomManager.delete(aT_AccessLog11);
        }
    }

    @Test
    public void Test001() {
        String pSubSystemId = "SSI0000001";
        String pCategoryId = "CI00000001";
        String pKinouId = "KI00000001";
        C_KinouKbn pKinouKbn = C_KinouKbn.ONLINE;
        BizDate pSyoriYmdFrom = BizDate.valueOf("20150101");
        String pSyoriTimeFrom = "0000";
        BizDate pSyoriYmdTo = BizDate.valueOf("20150102");
        String pSyoriTimeTo = "2359";
        String pUserId = "SUI0000001";
        String pIpAddress = "IA00000001";
        String pSessionId = "SEI0000001";
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        long count = baseDomManager.getAccessLogCount(pSubSystemId, pCategoryId, pKinouId, pKinouKbn, pSyoriYmdFrom,
            pSyoriTimeFrom, pSyoriYmdTo, pSyoriTimeTo, pUserId, pIpAddress, pSessionId, pLogKindCd);

        assertEquals(0,  count);
    }

    @Test
    public void Test002() {
        String pSubSystemId = "SSI0000001";
        String pCategoryId = "CI00000001";
        String pKinouId = "KI00000001";
        C_KinouKbn pKinouKbn = C_KinouKbn.ONLINE;
        BizDate pSyoriYmdFrom = BizDate.valueOf("20150101");
        String pSyoriTimeFrom = "0000";
        BizDate pSyoriYmdTo = BizDate.valueOf("20150103");
        String pSyoriTimeTo = "2359";
        String pUserId = "SUI0000001";
        String pIpAddress = "IA00000001";
        String pSessionId = "SEI0000001";
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        long count = baseDomManager.getAccessLogCount(pSubSystemId, pCategoryId, pKinouId, pKinouKbn, pSyoriYmdFrom,
            pSyoriTimeFrom, pSyoriYmdTo, pSyoriTimeTo, pUserId, pIpAddress, pSessionId, pLogKindCd);

        assertEquals(1,  count);
    }

    @Test
    public void Test003() {
        String pSubSystemId = "SSI0000001";
        String pCategoryId = "CI00000001";
        String pKinouId = "KI00000001";
        C_KinouKbn pKinouKbn = C_KinouKbn.ONLINE;
        BizDate pSyoriYmdFrom = BizDate.valueOf("20150104");
        String pSyoriTimeFrom = "0000";
        BizDate pSyoriYmdTo = BizDate.valueOf("20150106");
        String pSyoriTimeTo = "2359";
        String pUserId = "SUI0000001";
        String pIpAddress = "IA00000001";
        String pSessionId = "SEI0000001";
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        long count = baseDomManager.getAccessLogCount(pSubSystemId, pCategoryId, pKinouId, pKinouKbn, pSyoriYmdFrom,
            pSyoriTimeFrom, pSyoriYmdTo, pSyoriTimeTo, pUserId, pIpAddress, pSessionId, pLogKindCd);

        assertEquals(3,  count);
    }

    @Test
    public void Test004() {
        //        String pSubSystemId = null;
        //        String pCategoryId = null;
        //        String pKinouId = null;
        //        C_KinouKbn pKinouKbn = null;
        //        BizDate pSyoriYmdFrom = null;
        //        String pSyoriTimeFrom = null;
        //        BizDate pSyoriYmdTo = null;
        //        String pSyoriTimeTo = null;
        //        String pUserId = null;
        //        String pIpAddress = null;
        //        String pSessionId = null;
        //        C_AccessLogSyubetuKbn pLogKindCd = null;
        //        long count = baseDomManager.getAccessLogCount(pSubSystemId, pCategoryId, pKinouId, pKinouKbn, pSyoriYmdFrom,
        //            pSyoriTimeFrom, pSyoriYmdTo, pSyoriTimeTo, pUserId, pIpAddress, pSessionId, pLogKindCd);
        //
        //        assertEquals(11,  count);
    }

    @Test
    public void Test005() {
        String pSubSystemId = "SSI0000001";
        String pCategoryId = "CI00000001";
        String pKinouId = "KI00000001";
        C_KinouKbn pKinouKbn = C_KinouKbn.ONLINE;
        BizDate pSyoriYmdFrom = BizDate.valueOf("20150306");
        String pSyoriTimeFrom = "0000";
        BizDate pSyoriYmdTo = BizDate.valueOf("20150706");
        String pSyoriTimeTo = "2359";
        String pUserId = "SUI0000001";
        String pIpAddress = "IA00000001";
        String pSessionId = "SEI0000001";
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        long count = baseDomManager.getAccessLogCount(pSubSystemId, pCategoryId, pKinouId, pKinouKbn, pSyoriYmdFrom,
            pSyoriTimeFrom, pSyoriYmdTo, pSyoriTimeTo, pUserId, pIpAddress, pSessionId, pLogKindCd);

        assertEquals(5,  count);
    }

    private static long setSyoriTime(BizDate pSyoriYmd){

        Date syoriTime = pSyoriYmd.toDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(syoriTime);

        return Long.valueOf(calendar.getTimeInMillis());
    }

}

