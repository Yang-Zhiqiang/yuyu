package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getAccessLogSyousaisByLogIdEdaNoOrder() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getAccessLogSyousaisByLogIdEdaNoOrder extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId1 = "LI00000001";
        String pLogId2 = "LI00000002";
        long pTimeStamp1 = 0;
        long pTimeStamp2 = 1;
        C_AccessLogSyubetuKbn pLogKindCd1 = C_AccessLogSyubetuKbn.BLNK;
        C_AccessLogSyubetuKbn pLogKindCd2 = C_AccessLogSyubetuKbn.ACTION_END;
        long pSyousaiKensuu1 = 0;
        long pSyousaiKensuu2 = 1;

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

        long pSyousaiEdaNo1 = 1;
        long pSyousaiEdaNo2 = 3;
        long pSyousaiEdaNo3 = 2;
        long pSyousaiEdaNo4 = 4;

        AT_AccessLogSyousai aT_AccessLogSyousai1 = baseDomManager.getAccessLog(pLogId1).getAccessLogSyousai(pSyousaiEdaNo1);
        if ( null == aT_AccessLogSyousai1 ){

            aT_AccessLogSyousai1 = aT_AccessLog1.createAccessLogSyousai();
            aT_AccessLogSyousai1.setSyousaiEdaNo(pSyousaiEdaNo1);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai2 = baseDomManager.getAccessLog(pLogId1).getAccessLogSyousai(pSyousaiEdaNo2);
        if ( null == aT_AccessLogSyousai2 ){

            aT_AccessLogSyousai2 = aT_AccessLog1.createAccessLogSyousai();
            aT_AccessLogSyousai2.setSyousaiEdaNo(pSyousaiEdaNo2);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai3 = baseDomManager.getAccessLog(pLogId1).getAccessLogSyousai(pSyousaiEdaNo3);
        if ( null == aT_AccessLogSyousai3 ){

            aT_AccessLogSyousai3 = aT_AccessLog1.createAccessLogSyousai();
            aT_AccessLogSyousai3.setSyousaiEdaNo(pSyousaiEdaNo3);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai4 = baseDomManager.getAccessLog(pLogId2).getAccessLogSyousai(pSyousaiEdaNo4);
        if ( null == aT_AccessLogSyousai4 ){

            aT_AccessLogSyousai4 = aT_AccessLog2.createAccessLogSyousai();
            aT_AccessLogSyousai4.setSyousaiEdaNo(pSyousaiEdaNo4);

        }

        baseDomManager.update(aT_AccessLog1);
        baseDomManager.update(aT_AccessLog2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId1 = "LI00000001";
        String pLogId2 = "LI00000002";

        AT_AccessLog aT_AccessLog1 = baseDomManager.getAccessLog(pLogId1);
        if ( null != aT_AccessLog1 ){

            aT_AccessLog1.getAccessLogSyousais().removeAll(aT_AccessLog1.getAccessLogSyousais());

            baseDomManager.update(aT_AccessLog1);
            baseDomManager.delete(aT_AccessLog1);
        }

        AT_AccessLog aT_AccessLog2 = baseDomManager.getAccessLog(pLogId2);
        if ( null != aT_AccessLog2 ){

            aT_AccessLog2.getAccessLogSyousais().removeAll(aT_AccessLog2.getAccessLogSyousais());

            baseDomManager.update(aT_AccessLog2);
            baseDomManager.delete(aT_AccessLog2);
        }
    }

    @Test
    public void test001(){
        String pLogId = "LI00000099";
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(0, aT_AccessLogSyousaiList.size());
    }

    @Test
    public void test002(){
        String pLogId = "LI00000002";
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(1, aT_AccessLogSyousaiList.size());
    }

    @Test
    public void test003(){
        String pLogId = "LI00000001";
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(3, aT_AccessLogSyousaiList.size());
    }

    @Test
    public void test004(){
        String pLogId = "";
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(0, aT_AccessLogSyousaiList.size());
    }

    @Test
    public void test005(){
        String pLogId = null;
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(0, aT_AccessLogSyousaiList.size());
    }

    @Test
    public void test006(){
        String pLogId = "LI00000001";
        Long pSyousaiEdaNo1 = (long) 1;
        Long pSyousaiEdaNo2 = (long) 3;
        Long pSyousaiEdaNo3 = (long) 2;
        List<AT_AccessLogSyousai> aT_AccessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(pLogId);

        assertEquals(pSyousaiEdaNo1, aT_AccessLogSyousaiList.get(0).getSyousaiEdaNo());
        assertEquals(pSyousaiEdaNo3, aT_AccessLogSyousaiList.get(1).getSyousaiEdaNo());
        assertEquals(pSyousaiEdaNo2, aT_AccessLogSyousaiList.get(2).getSyousaiEdaNo());
    }
}
