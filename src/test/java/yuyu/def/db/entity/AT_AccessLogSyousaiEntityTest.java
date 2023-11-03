package yuyu.def.db.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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
 * アクセスログ詳細テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_AccessLogSyousaiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId = "LI00000001";
        long pTimeStamp = 0;
        C_AccessLogSyubetuKbn pLogKindCd = C_AccessLogSyubetuKbn.BLNK;
        long pSyousaiKensuu = 0;

        AT_AccessLog aT_AccessLog = baseDomManager.getAccessLog(pLogId);
        if ( null == aT_AccessLog ){

            aT_AccessLog = new AT_AccessLog();
            aT_AccessLog.setLogId(pLogId);
            aT_AccessLog.setTimeStamp(pTimeStamp);
            aT_AccessLog.setLogKindCd(pLogKindCd);
            aT_AccessLog.setSyousaiKensuu(pSyousaiKensuu);

            baseDomManager.insert(aT_AccessLog);
        }

        long pSyousaiEdaNo1 = 1;
        long pSyousaiEdaNo2 = 2;
        long pSyousaiEdaNo3 = 3;
        long pSyousaiEdaNo4 = 4;
        long pSyousaiEdaNo5 = 5;

        AT_AccessLogSyousai aT_AccessLogSyousai1 = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo1);
        if ( null == aT_AccessLogSyousai1 ){

            aT_AccessLogSyousai1 = aT_AccessLog.createAccessLogSyousai();
            aT_AccessLogSyousai1.setSyousaiEdaNo(pSyousaiEdaNo1);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai2 = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo2);
        if ( null == aT_AccessLogSyousai2 ){

            aT_AccessLogSyousai2 = aT_AccessLog.createAccessLogSyousai();
            aT_AccessLogSyousai2.setSyousaiEdaNo(pSyousaiEdaNo2);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai3 = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo3);
        if ( null == aT_AccessLogSyousai3 ){

            aT_AccessLogSyousai3 = aT_AccessLog.createAccessLogSyousai();
            aT_AccessLogSyousai3.setSyousaiEdaNo(pSyousaiEdaNo3);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai4 = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo4);
        if ( null == aT_AccessLogSyousai4 ){

            aT_AccessLogSyousai4 = aT_AccessLog.createAccessLogSyousai();
            aT_AccessLogSyousai4.setSyousaiEdaNo(pSyousaiEdaNo4);

        }

        AT_AccessLogSyousai aT_AccessLogSyousai5 = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo5);
        if ( null == aT_AccessLogSyousai5 ){

            aT_AccessLogSyousai5 = aT_AccessLog.createAccessLogSyousai();
            aT_AccessLogSyousai5.setSyousaiEdaNo(pSyousaiEdaNo5);

        }

        baseDomManager.update(aT_AccessLog);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pLogId = "LI00000001";

        AT_AccessLog aT_AccessLog = baseDomManager.getAccessLog(pLogId);
        if ( null != aT_AccessLog ){

            aT_AccessLog.getAccessLogSyousais().removeAll(aT_AccessLog.getAccessLogSyousais());

            baseDomManager.update(aT_AccessLog);
            baseDomManager.delete(aT_AccessLog);
        }
    }

    @Override
    @Test
    public void getAll() {

        String pLogId = "LI00000001";
        List<AT_AccessLogSyousai> accessLogSyousaiList = baseDomManager.getAccessLog(pLogId).getAccessLogSyousais();

        List<AT_AccessLogSyousai> resultAccessLogSyousaiList = ImmutableList.copyOf(Iterables.filter(accessLogSyousaiList, new Predicate<AT_AccessLogSyousai>() {

            @Override
            public boolean apply(AT_AccessLogSyousai pAccessLogSyousaiEntity) {

                List<Long> pSyousaiEdaNoList = new ArrayList<Long>();
                pSyousaiEdaNoList.add((long) 1);
                pSyousaiEdaNoList.add((long) 2);
                pSyousaiEdaNoList.add((long) 3);
                pSyousaiEdaNoList.add((long) 4);
                pSyousaiEdaNoList.add((long) 5);

                for (Long kinouModeId : pSyousaiEdaNoList) {
                    if (kinouModeId.equals(pAccessLogSyousaiEntity.getSyousaiEdaNo())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultAccessLogSyousaiList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pLogId = "LI00000001";
        Long pSyousaiEdaNo = (long) 1;
        AT_AccessLogSyousai aT_AccessLogSyousai = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo);

        assertEquals(pLogId, aT_AccessLogSyousai.getLogId());
        assertEquals(pSyousaiEdaNo, aT_AccessLogSyousai.getSyousaiEdaNo());

    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pLogId = "LI00000001";
        Long pSyousaiEdaNo = (long) 99;
        AT_AccessLogSyousai aT_AccessLogSyousai = baseDomManager.getAccessLog(pLogId).getAccessLogSyousai(pSyousaiEdaNo);

        assertNull(aT_AccessLogSyousai);
    }

    @Override
    @Test
    public void blankCondition() {
    }

    @Override
    @Test
    public void nullCondition() {
    }
}
