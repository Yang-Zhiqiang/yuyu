package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

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
import yuyu.def.hozen.result.bean.KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_JOB_CD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RBI7";
    private static String P_FILTER_ID = "Kh001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(P_JOB_CD_01, BizDate.valueOf(20160215), BizDate.valueOf(20160215));

        int iCount = 0;
        for (KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if( null == kykKihon1 ) {

            kykKihon1 = new IT_KykKihon("01","11807111118");

            IT_FatcaInfo fatcaInfo1 = kykKihon1.createFatcaInfo();
            fatcaInfo1.setRenno(21);
            fatcaInfo1.setSyoriYmd(BizDate.valueOf(20160215));
            fatcaInfo1.setFatcakekkbn(C_FatcakekKbn.BLNK);

            IT_FatcaInfo fatcaInfo4 = kykKihon1.createFatcaInfo();
            fatcaInfo4.setRenno(22);
            fatcaInfo4.setSyoriYmd(BizDate.valueOf(20160215));
            fatcaInfo4.setFatcakekkbn(C_FatcakekKbn.KAKUNINTYUU);

            IT_FatcaInfo fatcaInfo5 = kykKihon1.createFatcaInfo();
            fatcaInfo5.setRenno(23);
            fatcaInfo5.setSyoriYmd(BizDate.valueOf(20160201));
            fatcaInfo5.setFatcakekkbn(C_FatcakekKbn.BLNK);

            IT_FatcaInfo fatcaInfo6 = kykKihon1.createFatcaInfo();
            fatcaInfo6.setRenno(24);
            fatcaInfo6.setSyoriYmd(BizDate.valueOf(20160228));
            fatcaInfo6.setFatcakekkbn(C_FatcakekKbn.BLNK);

            IT_KykSya kykSya1 = kykKihon1.createKykSya();

            IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn1.setSyouhncd("1001");
            kykSyouhn1.setSyouhnsdno(11);
            kykSyouhn1.setKyksyouhnrenno(31);

            IT_KykSyouhn kykSyouhn4 = kykKihon1.createKykSyouhn();
            kykSyouhn4.setSyutkkbn(C_SyutkKbn.NONE);
            kykSyouhn4.setSyouhncd("1001");
            kykSyouhn4.setSyouhnsdno(11);
            kykSyouhn4.setKyksyouhnrenno(31);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(31);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_FatcaInfo fatcaInfo2 = kykKihon3.createFatcaInfo();
        fatcaInfo2.setRenno(21);
        fatcaInfo2.setSyoriYmd(BizDate.valueOf(20160215));
        fatcaInfo2.setFatcakekkbn(C_FatcakekKbn.BLNK);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_FatcaInfo fatcaInfo3 = kykKihon4.createFatcaInfo();
        fatcaInfo3.setRenno(21);
        fatcaInfo3.setSyoriYmd(BizDate.valueOf(20160215));
        fatcaInfo3.setFatcakekkbn(C_FatcakekKbn.BLNK);

        IT_KykSyouhn kykSyouhn3 = kykKihon4.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1001");
        kykSyouhn3.setSyouhnsdno(11);
        kykSyouhn3.setKyksyouhnrenno(31);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_FatcaInfo fatcaInfo7 = kykKihon5.createFatcaInfo();
        fatcaInfo7.setRenno(25);
        fatcaInfo7.setSyoriYmd(BizDate.valueOf(20160220));
        fatcaInfo7.setFatcakekkbn(C_FatcakekKbn.TOKUTEIAMERICAN);

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("1002");
        kykSyouhn5.setSyouhnsdno(12);
        kykSyouhn5.setKyksyouhnrenno(32);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_FatcaInfo fatcaInfo8 = kykKihon6.createFatcaInfo();
        fatcaInfo8.setRenno(25);
        fatcaInfo8.setSyoriYmd(BizDate.valueOf(20160225));
        fatcaInfo8.setFatcakekkbn(C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU);

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("1002");
        kykSyouhn6.setSyouhnsdno(12);
        kykSyouhn6.setKyksyouhnrenno(32);

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_FatcaInfo fatcaInfo9 = kykKihon7.createFatcaInfo();
        fatcaInfo9.setRenno(25);
        fatcaInfo9.setSyoriYmd(BizDate.valueOf(20160223));
        fatcaInfo9.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("1002");
        kykSyouhn7.setSyouhnsdno(12);
        kykSyouhn7.setKyksyouhnrenno(32);

        hozenDomManager.insert(kykKihon7);

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

        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(P_JOB_CD_01, BizDate.valueOf(20160202), BizDate.valueOf(20160214));

        int iCount = 0;
        for (KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(P_JOB_CD_01, BizDate.valueOf(20160215), BizDate.valueOf(20160215));

        int iCount = 0;
        for (KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", fKSKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(21, fKSKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("01", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1001", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(11, fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(31, fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("01", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> beans = hozenDomManager.
            getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(P_JOB_CD_01, BizDate.valueOf(20160220), BizDate.valueOf(20160225));

        int iCount = 0;
        for (KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("05", fKSKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(25, fKSKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("05", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("05", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1002", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(12, fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(32, fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("05", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_KykSya().getSyono());
            }

            if (2 == iCount) {
                Assert.assertEquals("06", fKSKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(25, fKSKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("06", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("06", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1002", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(12, fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(32, fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("06", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_KykSya().getSyono());
            }

            if (3 == iCount) {
                Assert.assertEquals("07", fKSKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(25, fKSKbean.getIT_FatcaInfo().getRenno().intValue());

                Assert.assertEquals("07", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("07", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1002", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(12, fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(32, fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("07", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_KykSya().getSyono());
            }
        }
        Assert.assertEquals(3, iCount);
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
        try(ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> fKSKbean =
            hozenDomManager.getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160220), BizDate.valueOf(20160225));){
            for(KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean bean : fKSKbean){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
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

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("07");
        key3.setRecoveryfilterkey2("11807111174");
        key3.setTableid("IT_KykKihon");
        hozenDomManager.insert(key3);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> fKSKbean =
            hozenDomManager.getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160220), BizDate.valueOf(20160225));){
            for(KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean bean : fKSKbean){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111174");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey2("11807111152");
        key1.setRecoveryfilterkey1("05");
        key1.setTableid("IT_KykKihon");
        hozenDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean> rs =
            hozenDomManager.getKhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbn(
                P_JOB_CD_02, BizDate.valueOf(20160220), BizDate.valueOf(20160225));){
            for(KhFatcaMonitoringknkykInfosByKakutyoujobcdFatcakekkbnNeSyoriYmdSyutkkbnBean bean : rs){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111174");
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111152");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}


