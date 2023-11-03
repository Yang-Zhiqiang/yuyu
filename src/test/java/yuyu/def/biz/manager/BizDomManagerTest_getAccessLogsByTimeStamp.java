package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * アクセスログ作成（月次）<br />
 * アクセスログテーブルエンティティリスト取得　処理年月日<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAccessLogsByTimeStamp {

    @Inject
    BizDomManager bizDomManager;
    BaseDomManager baseDomManager;


    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsByTimeStamp(20160731000000000L,20160801000000000L)){

            Assert.assertFalse(exDBResults.iterator().hasNext());

        }
        AT_AccessLog accessLog1 = new AT_AccessLog("1");
        accessLog1.setTimeStamp(20160801000000000L);
        accessLog1.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog1.setSyousaiKensuu(1L);

        baseDomManager.insert(accessLog1);

        AT_AccessLog accessLog2 = new AT_AccessLog("2");
        accessLog2.setTimeStamp(20160801000000001L);
        accessLog2.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog2.setSyousaiKensuu(2L);

        baseDomManager.insert(accessLog2);

        AT_AccessLog accessLog3 = new AT_AccessLog("3");
        accessLog3.setTimeStamp(20160730235959999L);
        accessLog3.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog3.setSyousaiKensuu(3L);

        baseDomManager.insert(accessLog3);

        AT_AccessLog accessLog4 = new AT_AccessLog("4");
        accessLog4.setTimeStamp(20160801000000013L);
        accessLog4.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog4.setSyousaiKensuu(4L);

        baseDomManager.insert(accessLog4);

        AT_AccessLog accessLog5 = new AT_AccessLog("5");
        accessLog5.setTimeStamp(20160801000000012L);
        accessLog5.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog5.setSyousaiKensuu(5L);

        baseDomManager.insert(accessLog5);

        AT_AccessLog accessLog6 = new AT_AccessLog("6");
        accessLog6.setTimeStamp(20160801000000011L);
        accessLog6.setLogKindCd(C_AccessLogSyubetuKbn.valueOf("ActionBegin"));
        accessLog6.setSyousaiKensuu(6L);

        baseDomManager.insert(accessLog6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllAccessLogs());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsByTimeStamp(20160801000000023L,20160801000000024L)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsByTimeStamp(20160731000000000L,20160801000000000L)){
            int iCount = 0;
            for (AT_AccessLog entity : exDBResults) {

                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("1", entity.getLogId());
                    Assert.assertEquals(new Long(20160801000000000L), entity.getTimeStamp());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsByTimeStamp(20160801000000011L,20160801000000013L)){
            int iCount = 0;
            for (AT_AccessLog entity : exDBResults) {

                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("6", entity.getLogId());
                    Assert.assertEquals(new Long(20160801000000011L), entity.getTimeStamp());
                }
                if (2 == iCount) {
                    Assert.assertEquals("5", entity.getLogId());
                    Assert.assertEquals(new Long(20160801000000012L), entity.getTimeStamp());
                }
                if (3 == iCount) {
                    Assert.assertEquals("4", entity.getLogId());
                    Assert.assertEquals(new Long(20160801000000013L), entity.getTimeStamp());
                }

            }
            Assert.assertEquals(3, iCount);
        }

    }
}
