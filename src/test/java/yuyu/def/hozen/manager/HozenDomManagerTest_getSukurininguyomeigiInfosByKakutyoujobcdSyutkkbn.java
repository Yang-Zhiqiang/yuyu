package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * HozenDomManagerクラスの、<br />
 * getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;
    BizDomManager bizDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    private static String P_JOB_CD_02 = "RBM1";
    private static String P_FILTER_ID = "Kh001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_KAKUTYOUJOBCD_01, C_SyutkKbn.SYU);

        int iCount = 0;
        for (SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean SIbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("A100");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(1);

        IT_HhknSya hhknSya2 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon4.createHhknSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn5.setSyouhncd("A100");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(1);

        IT_KykSya kykSya5 = kykKihon5.createKykSya();

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn6.setSyouhncd("A100");
        kykSyouhn6.setSyouhnsdno(10);
        kykSyouhn6.setKyksyouhnrenno(1);

        IT_KykSya kykSya6 = kykKihon6.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon6.createHhknSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn7.setSyouhncd("A100");
        kykSyouhn7.setSyouhnsdno(10);
        kykSyouhn7.setKyksyouhnrenno(1);

        IT_KykSya kykSya7 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya7 = kykKihon7.createHhknSya();

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

        ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_KAKUTYOUJOBCD_01, C_SyutkKbn.NONE);

        int iCount = 0;
        for (SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean SIbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_KAKUTYOUJOBCD_01, C_SyutkKbn.SYU);

        int iCount = 0;
        for (SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean SIbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", SIbean.getKykKihon().getKbnkey());
                Assert.assertEquals("11807111118", SIbean.getKykKihon().getSyono());

                Assert.assertEquals("01", SIbean.getKykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", SIbean.getKykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, SIbean.getKykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", SIbean.getKykSyouhn().getSyouhncd());
                Assert.assertEquals(Integer.valueOf(10), SIbean.getKykSyouhn().getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(1), SIbean.getKykSyouhn().getKyksyouhnrenno());

                Assert.assertEquals("01", SIbean.getKykSya().getKbnkey());
                Assert.assertEquals("11807111118", SIbean.getKykSya().getSyono());

                Assert.assertEquals("01", SIbean.getKhknSya().getKbnkey());
                Assert.assertEquals("11807111118", SIbean.getKhknSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_KAKUTYOUJOBCD_01, C_SyutkKbn.TK);

        int iCount = 0;
        for (SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean SIbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("05", SIbean.getKykKihon().getKbnkey());
                Assert.assertEquals("11807111152", SIbean.getKykKihon().getSyono());

                Assert.assertEquals("05", SIbean.getKykSyouhn().getKbnkey());
                Assert.assertEquals("11807111152", SIbean.getKykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.TK, SIbean.getKykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", SIbean.getKykSyouhn().getSyouhncd());
                Assert.assertEquals(Integer.valueOf(10), SIbean.getKykSyouhn().getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(1), SIbean.getKykSyouhn().getKyksyouhnrenno());

                Assert.assertEquals("05", SIbean.getKykSya().getKbnkey());
                Assert.assertEquals("11807111152", SIbean.getKykSya().getSyono());

                Assert.assertEquals("05", SIbean.getKhknSya().getKbnkey());
                Assert.assertEquals("11807111152", SIbean.getKhknSya().getSyono());
            }

            if (2 == iCount) {
                Assert.assertEquals("06", SIbean.getKykKihon().getKbnkey());
                Assert.assertEquals("11807111163", SIbean.getKykKihon().getSyono());

                Assert.assertEquals("06", SIbean.getKykSyouhn().getKbnkey());
                Assert.assertEquals("11807111163", SIbean.getKykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.TK, SIbean.getKykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", SIbean.getKykSyouhn().getSyouhncd());
                Assert.assertEquals(Integer.valueOf(10), SIbean.getKykSyouhn().getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(1), SIbean.getKykSyouhn().getKyksyouhnrenno());

                Assert.assertEquals("06", SIbean.getKykSya().getKbnkey());
                Assert.assertEquals("11807111163", SIbean.getKykSya().getSyono());

                Assert.assertEquals("06", SIbean.getKhknSya().getKbnkey());
                Assert.assertEquals("11807111163", SIbean.getKhknSya().getSyono());
            }

            if (3 == iCount) {
                Assert.assertEquals("07", SIbean.getKykKihon().getKbnkey());
                Assert.assertEquals("11807111174", SIbean.getKykKihon().getSyono());

                Assert.assertEquals("07", SIbean.getKykSyouhn().getKbnkey());
                Assert.assertEquals("11807111174", SIbean.getKykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.TK, SIbean.getKykSyouhn().getSyutkkbn());
                Assert.assertEquals("A100", SIbean.getKykSyouhn().getSyouhncd());
                Assert.assertEquals(Integer.valueOf(10), SIbean.getKykSyouhn().getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(1), SIbean.getKykSyouhn().getKyksyouhnrenno());

                Assert.assertEquals("07", SIbean.getKykSya().getKbnkey());
                Assert.assertEquals("11807111174", SIbean.getKykSya().getSyono());

                Assert.assertEquals("07", SIbean.getKhknSya().getKbnkey());
                Assert.assertEquals("11807111174", SIbean.getKhknSya().getSyono());
            }
        }
        Assert.assertEquals(3, iCount);
    }
    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
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
        try(ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_JOB_CD_02, C_SyutkKbn.TK);){
            for(SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean bean : beans){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        IT_KykKihon kykKihon1 = new IT_KykKihon("08", "11807111185");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn1.setSyouhncd("A100");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(4);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("09", "11807111196");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("2"));
        kykSyouhn2.setSyouhncd("A100");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(4);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        BM_RecoveryFilter filter = new BM_RecoveryFilter(P_FILTER_ID);
        filter.setRecoveryfilterkeykmid1("kbnkey");
        filter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid(P_FILTER_ID);
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("05");
        key3.setRecoveryfilterkey2("11807111152");
        key3.setTableid("IT_KykKihon");
        hozenDomManager.insert(key3);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_JOB_CD_02, C_SyutkKbn.TK);){
            for(SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean bean : beans){
                assertNotEquals(bean.getKykKihon().getSyono(), "11807111152");

                iCount++;
            }
            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid(P_FILTER_ID);
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterkey2("11807111185");
        key1.setRecoveryfilterkey1("08");
        key1.setTableid("IT_KykKihon");
        hozenDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean> beans = hozenDomManager.
            getSukurininguyomeigiInfosByKakutyoujobcdSyutkkbn(P_JOB_CD_02, C_SyutkKbn.TK);){
            for(SukurininguyomeigiInfosByKakutyoujobcdSyutkkbnBean bean : beans){
                assertNotEquals(bean.getKykKihon().getSyono(), "11807111152");
                assertNotEquals(bean.getKykKihon().getSyono(), "11807111185");

                iCount++;
            }
            assertEquals(3, iCount);
        }
    }
}


