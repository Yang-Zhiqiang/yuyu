package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RBI8";
    private static String P_FILTER_ID = "Kh001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160311));

        int iCount = 0;
        for (KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean KFMKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_FatcaInfo fatcaInfo1 = kykKihon1.createFatcaInfo();
        fatcaInfo1.setRenno(1);
        fatcaInfo1.setSyoriYmd(BizDate.valueOf(20160310));
        fatcaInfo1.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_FatcaInfo fatcaInfo4 = kykKihon1.createFatcaInfo();
        fatcaInfo4.setRenno(2);
        fatcaInfo4.setSyoriYmd(BizDate.valueOf(20160310));
        fatcaInfo4.setFatcakekkbn(C_FatcakekKbn.valueOf("2"));

        IT_FatcaInfo fatcaInfo5 = kykKihon1.createFatcaInfo();
        fatcaInfo5.setRenno(3);
        fatcaInfo5.setSyoriYmd(BizDate.valueOf(20160311));
        fatcaInfo5.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_FatcaInfo fatcaInfo6 = kykKihon1.createFatcaInfo();
        fatcaInfo6.setRenno(4);
        fatcaInfo6.setSyoriYmd(BizDate.valueOf(20160312));
        fatcaInfo6.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn4.setSyouhncd("A100");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_FatcaInfo fatcaInfo2 = kykKihon2.createFatcaInfo();
        fatcaInfo2.setRenno(1);
        fatcaInfo2.setSyoriYmd(BizDate.valueOf(20160310));
        fatcaInfo2.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_FatcaInfo fatcaInfo3 = kykKihon3.createFatcaInfo();
        fatcaInfo3.setRenno(1);
        fatcaInfo3.setSyoriYmd(BizDate.valueOf(20160310));
        fatcaInfo3.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_KykSyouhn kykSyouhn2 = kykKihon3.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_KykSyouhn kykSyouhn3 = kykKihon4.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("06", "11807111163");

        IT_FatcaInfo fatcaInfo7 = kykKihon5.createFatcaInfo();
        fatcaInfo7.setRenno(1);
        fatcaInfo7.setSyoriYmd(BizDate.valueOf(20160311));
        fatcaInfo7.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("05", "11807111152");

        IT_FatcaInfo fatcaInfo8 = kykKihon6.createFatcaInfo();
        fatcaInfo8.setRenno(1);
        fatcaInfo8.setSyoriYmd(BizDate.valueOf(20160311));
        fatcaInfo8.setFatcakekkbn(C_FatcakekKbn.valueOf("1"));

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon6);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20150310));

        int iCount = 0;
        for (KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean KFMKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160311));

        int iCount = 0;
        for (KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean KFMKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", KFMKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111118", KFMKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(1, KFMKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("01", KFMKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", KFMKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", KFMKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", KFMKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, KFMKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", KFMKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(10, KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("01", KFMKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", KFMKbean.getIT_KykSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> mIT_FatcaInfo = new HashMap<String,String>();

        mIT_FatcaInfo.put($("01", "11807111118", 1),"1");
        mIT_FatcaInfo.put($("01", "11807111118", 3),"1");

        Map<String,String> mIT_KykKihon = new HashMap<String,String>();

        mIT_KykKihon.put($("01", "11807111118"),"1");

        Map<String,String> mIT_KykSyouhn = new HashMap<String,String>();

        mIT_KykSyouhn.put($("01", "11807111118", C_SyutkKbn.SYU, "A100", 10, 1),"1");

        Map<String,String> mIT_KykSya = new HashMap<String,String>();

        mIT_KykSya.put($("01", "11807111118"),"1");

        ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160312));

        int iCount = 0;
        for (KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean KFMKbean : beans) {
            iCount++;

            if (1 == iCount) {
                assertTrue(mIT_FatcaInfo.containsKey($(KFMKbean.getIT_FatcaInfo().getKbnkey(), KFMKbean.getIT_FatcaInfo().getSyono(), KFMKbean.getIT_FatcaInfo().getRenno().intValue())));
                assertTrue(mIT_KykKihon.containsKey($(KFMKbean.getIT_KykKihon().getKbnkey(),KFMKbean.getIT_KykKihon().getSyono())));
                assertTrue(mIT_KykSyouhn.containsKey($(KFMKbean.getIT_KykSyouhn().getKbnkey(), KFMKbean.getIT_KykSyouhn().getSyono(), KFMKbean.getIT_KykSyouhn().getSyutkkbn(), KFMKbean.getIT_KykSyouhn().getSyouhncd(), KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue(), KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue())));
                assertTrue(mIT_KykSya.containsKey($(KFMKbean.getIT_KykSya().getKbnkey(), KFMKbean.getIT_KykSya().getSyono())));

                mIT_FatcaInfo.remove($(KFMKbean.getIT_FatcaInfo().getKbnkey(), KFMKbean.getIT_FatcaInfo().getSyono(), KFMKbean.getIT_FatcaInfo().getRenno().intValue()));

            }

            if (2 == iCount) {
                assertTrue(mIT_FatcaInfo.containsKey($(KFMKbean.getIT_FatcaInfo().getKbnkey(), KFMKbean.getIT_FatcaInfo().getSyono(), KFMKbean.getIT_FatcaInfo().getRenno().intValue())));
                assertTrue(mIT_KykKihon.containsKey($(KFMKbean.getIT_KykKihon().getKbnkey(),KFMKbean.getIT_KykKihon().getSyono())));
                assertTrue(mIT_KykSyouhn.containsKey($(KFMKbean.getIT_KykSyouhn().getKbnkey(), KFMKbean.getIT_KykSyouhn().getSyono(), KFMKbean.getIT_KykSyouhn().getSyutkkbn(), KFMKbean.getIT_KykSyouhn().getSyouhncd(), KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue(), KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue())));
                assertTrue(mIT_KykSya.containsKey($(KFMKbean.getIT_KykSya().getKbnkey(), KFMKbean.getIT_KykSya().getSyono())));

                mIT_FatcaInfo.remove($(KFMKbean.getIT_FatcaInfo().getKbnkey(), KFMKbean.getIT_FatcaInfo().getSyono(), KFMKbean.getIT_FatcaInfo().getRenno().intValue()));
                mIT_KykKihon.remove($(KFMKbean.getIT_KykKihon().getKbnkey(),KFMKbean.getIT_KykKihon().getSyono()));
                mIT_KykSyouhn.remove($(KFMKbean.getIT_KykSyouhn().getKbnkey(), KFMKbean.getIT_KykSyouhn().getSyono(), KFMKbean.getIT_KykSyouhn().getSyutkkbn(), KFMKbean.getIT_KykSyouhn().getSyouhncd(), KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue(), KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue()));
                mIT_KykSya.remove($(KFMKbean.getIT_KykSya().getKbnkey(), KFMKbean.getIT_KykSya().getSyono()));
            }

            if (3 == iCount) {
                Assert.assertEquals("05", KFMKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111152", KFMKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(1, KFMKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("05", KFMKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111152", KFMKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("05", KFMKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111152", KFMKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, KFMKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", KFMKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(10, KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("05", KFMKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111152", KFMKbean.getIT_KykSya().getSyono());
            }

            if (4 == iCount) {
                Assert.assertEquals("06", KFMKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111163", KFMKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(1, KFMKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("06", KFMKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111163", KFMKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("06", KFMKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111163", KFMKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, KFMKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", KFMKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(10, KFMKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, KFMKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("06", KFMKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111163", KFMKbean.getIT_KykSya().getSyono());
            }
        }
        assertTrue(mIT_FatcaInfo.isEmpty());
        assertTrue(mIT_KykKihon.isEmpty());
        assertTrue(mIT_KykSyouhn.isEmpty());
        assertTrue(mIT_KykSya.isEmpty());

        Assert.assertEquals(4, iCount);
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        int iCount = 0;
        try(ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans =
            hozenDomManager.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160312));){
            for(KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean bean : beans){

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("kbnkey");
        filter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(filter);

        BT_SkipKey key4 = new BT_SkipKey("A04");
        key4.setRecoveryfilterid(P_FILTER_ID);
        key4.setKakutyoujobcd(P_JOB_CD_02);
        key4.setRecoveryfilterkey1("06");
        key4.setRecoveryfilterkey2("11807111163");
        key4.setTableid("IT_KykKihon");
        hozenDomManager.insert(key4);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> beans =
            hozenDomManager.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160312));){
            for(KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean bean : beans){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111163");

                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey2("11807111152");
        key3.setRecoveryfilterkey1("05");
        key3.setTableid("IT_KykKihon");
        hozenDomManager.insert(key3);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean> rs =
            hozenDomManager.getKhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160312));){
            for(KhFatcaMonitoringKakninInfosByKakutyoujobcdFatcakekkbnSyoriYmdSyutkkbnBean bean : rs){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111163");
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111152");

                iCount++;
            }
            assertEquals(2, iCount);
        }
    }
}


