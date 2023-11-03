package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;

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
import yuyu.def.hozen.result.bean.FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";

    private static String P_JOB_CD_02 = "RBI5";

    private final static C_FatcakekKbn[] dSyukouteikanriid1 = {C_FatcakekKbn.BLNK, C_FatcakekKbn.TAISYOUGAIHUYOU};
    private final static C_FatcakekKbn[] dSyukouteikanriid2 = {C_FatcakekKbn.KAKUNINTYUU, C_FatcakekKbn.TOKUTEIAMERICAN, C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215), C_SyutkKbn.SYU, dSyukouteikanriid1);

        int iCount = 0;
        for (FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if( null == kykKihon1 ) {

            kykKihon1 = new IT_KykKihon("11","11807111118");

            IT_FatcaInfo fatcaInfo1 = kykKihon1.createFatcaInfo();
            fatcaInfo1.setRenno(21);
            fatcaInfo1.setFatcakekkbn(C_FatcakekKbn.BLNK);
            fatcaInfo1.setKouryokuendymd(BizDate.valueOf(20160227));

            IT_FatcaInfo fatcaInfo2 = kykKihon1.createFatcaInfo();
            fatcaInfo2.setRenno(22);
            fatcaInfo2.setFatcakekkbn(C_FatcakekKbn.BLNK);
            fatcaInfo2.setKouryokuendymd(BizDate.valueOf(20160215));

            IT_FatcaInfo fatcaInfo3 = kykKihon1.createFatcaInfo();
            fatcaInfo3.setRenno(23);
            fatcaInfo3.setFatcakekkbn(C_FatcakekKbn.BLNK);
            fatcaInfo3.setKouryokuendymd(BizDate.valueOf(20160214));

            IT_FatcaInfo fatcaInfo4 = kykKihon1.createFatcaInfo();
            fatcaInfo4.setRenno(24);
            fatcaInfo4.setFatcakekkbn(C_FatcakekKbn.TAISYOUGAIYOU);
            fatcaInfo4.setKouryokuendymd(BizDate.valueOf(20160227));

            IT_KykSya kykSya1 = kykKihon1.createKykSya();

            IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
            kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
            kykSyouhn1.setSyouhncd("1001");
            kykSyouhn1.setSyouhnsdno(31);
            kykSyouhn1.setKyksyouhnrenno(41);

            IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
            kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
            kykSyouhn3.setSyouhncd("1001");
            kykSyouhn3.setSyouhnsdno(31);
            kykSyouhn3.setKyksyouhnrenno(41);

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(31);
        kykSyouhn2.setKyksyouhnrenno(41);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("11", "11807111185");

        IT_FatcaInfo fatcaInfo5 = kykKihon3.createFatcaInfo();
        fatcaInfo5.setRenno(30);
        fatcaInfo5.setFatcakekkbn(C_FatcakekKbn.BLNK);
        fatcaInfo5.setKouryokuendymd(BizDate.valueOf(20160227));

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("11", "11807111196");

        IT_FatcaInfo fatcaInfo6 = kykKihon4.createFatcaInfo();
        fatcaInfo6.setRenno(31);
        fatcaInfo6.setFatcakekkbn(C_FatcakekKbn.BLNK);
        fatcaInfo6.setKouryokuendymd(BizDate.valueOf(20160227));

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("1001");
        kykSyouhn4.setSyouhnsdno(31);
        kykSyouhn4.setKyksyouhnrenno(41);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("12", "11807111130");

        IT_FatcaInfo fatcaInfo7 = kykKihon5.createFatcaInfo();
        fatcaInfo7.setRenno(25);
        fatcaInfo7.setFatcakekkbn(C_FatcakekKbn.KAKUNINTYUU);
        fatcaInfo7.setKouryokuendymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn5.setSyouhncd("1002");
        kykSyouhn5.setSyouhnsdno(32);
        kykSyouhn5.setKyksyouhnrenno(42);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("12", "11807111141");

        IT_FatcaInfo fatcaInfo8 = kykKihon6.createFatcaInfo();
        fatcaInfo8.setRenno(26);
        fatcaInfo8.setFatcakekkbn(C_FatcakekKbn.KAKUNINTYUU);
        fatcaInfo8.setKouryokuendymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn6.setSyouhncd("1002");
        kykSyouhn6.setSyouhnsdno(32);
        kykSyouhn6.setKyksyouhnrenno(42);

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("12", "11807111152");

        IT_FatcaInfo fatcaInfo9 = kykKihon7.createFatcaInfo();
        fatcaInfo9.setRenno(27);
        fatcaInfo9.setFatcakekkbn(C_FatcakekKbn.TOKUTEIAMERICAN);
        fatcaInfo9.setKouryokuendymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn7.setSyouhncd("1002");
        kykSyouhn7.setSyouhnsdno(32);
        kykSyouhn7.setKyksyouhnrenno(42);

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("12", "11807111163");

        IT_FatcaInfo fatcaInfo10 = kykKihon8.createFatcaInfo();
        fatcaInfo10.setRenno(28);
        fatcaInfo10.setFatcakekkbn(C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU);
        fatcaInfo10.setKouryokuendymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya7 = kykKihon8.createKykSya();

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn8.setSyouhncd("1002");
        kykSyouhn8.setSyouhnsdno(32);
        kykSyouhn8.setKyksyouhnrenno(42);

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("12", "11807111174");

        IT_FatcaInfo fatcaInfo11 = kykKihon9.createFatcaInfo();
        fatcaInfo11.setRenno(29);
        fatcaInfo11.setFatcakekkbn(C_FatcakekKbn.HIKYOURYOKUTEKIKOKYAKU);
        fatcaInfo11.setKouryokuendymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya8 = kykKihon9.createKykSya();

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn9.setSyouhncd("1002");
        kykSyouhn9.setSyouhnsdno(32);
        kykSyouhn9.setKyksyouhnrenno(42);

        hozenDomManager.insert(kykKihon9);

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

        ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160228), C_SyutkKbn.NONE, dSyukouteikanriid1);

        int iCount = 0;
        for (FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215), C_SyutkKbn.SYU, dSyukouteikanriid1);

        int iCount = 0;
        for (FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("11", fKSKbean.getIT_FatcaInfo().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_FatcaInfo().getSyono());
                Assert.assertEquals(Integer.valueOf(21), fKSKbean.getIT_FatcaInfo().getRenno());

                Assert.assertEquals("11", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSya().getSyono());

                Assert.assertEquals("11", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("1001", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(Integer.valueOf(31), fKSKbean.getIT_KykSyouhn().getSyouhnsdno());
                Assert.assertEquals(Integer.valueOf(41), fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno());

            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("12","11807111130","12","11807111130","25","12","11807111130","12","11807111130","2","1002","32","42"), "1");
        datamap.put($("12","11807111141","12","11807111141","26","12","11807111141","12","11807111141","2","1002","32","42"), "2");
        datamap.put($("12","11807111152","12","11807111152","27","12","11807111152","12","11807111152","2","1002","32","42"), "3");
        datamap.put($("12","11807111163","12","11807111163","28","12","11807111163","12","11807111163","2","1002","32","42"), "4");
        datamap.put($("12","11807111174","12","11807111174","29","12","11807111174","12","11807111174","2","1002","32","42"), "5");


        ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215), C_SyutkKbn.TK, dSyukouteikanriid2);

        for (FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean fKSKbean : beans) {
            datamap.remove($(fKSKbean.getIT_KykKihon().getKbnkey(),fKSKbean.getIT_KykKihon().getSyono(),
                fKSKbean.getIT_FatcaInfo().getKbnkey(),fKSKbean.getIT_FatcaInfo().getSyono(),fKSKbean.getIT_FatcaInfo().getRenno(),fKSKbean.getIT_KykSya().getKbnkey(),
                fKSKbean.getIT_KykSya().getSyono(),fKSKbean.getIT_KykSyouhn().getKbnkey(),fKSKbean.getIT_KykSyouhn().getSyono(),fKSKbean.getIT_KykSyouhn().getSyutkkbn(),
                fKSKbean.getIT_KykSyouhn().getSyouhncd(),fKSKbean.getIT_KykSyouhn().getSyouhnsdno(),fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno()));
        }
        Assert.assertTrue(datamap.isEmpty());
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
        try( ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_JOB_CD_02, BizDate.valueOf(20160215), C_SyutkKbn.TK, dSyukouteikanriid2);){
            for(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean bean : beans){

                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Kh001");
        filter.setRecoveryfilternm("契約基本フィルタ");
        filter.setRecoveryfilterkeykmid1("kbnkey");
        filter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("900001");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setTableid("IT_KykKihon");
        key3.setRecoveryfilterid("Kh001");
        key3.setRecoveryfilterkey1("12");
        key3.setRecoveryfilterkey2("11807111130");

        hozenDomManager.insert(key3);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try( ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_JOB_CD_02, BizDate.valueOf(20160215), C_SyutkKbn.TK, dSyukouteikanriid2);){
            for(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean bean : beans){

                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111130");
                iCount++;
            }
            Assert.assertEquals(4, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("900002");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setTableid("IT_KykKihon");
        key1.setRecoveryfilterid("Kh001");
        key1.setRecoveryfilterkey1("12");
        key1.setRecoveryfilterkey2("11807111141");

        hozenDomManager.insert(key1);

    }


    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try( ExDBResults<FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean> beans = hozenDomManager.
            getFatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbn(P_JOB_CD_02, BizDate.valueOf(20160215), C_SyutkKbn.TK, dSyukouteikanriid2);){
            for(FatcaRekinennReportInfosByKakutyoujobcdKouryokuendymdSyutkkbnFatcakekkbnBean bean : beans){
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111130");
                assertNotEquals(bean.getIT_KykKihon().getSyono(), "11807111141");

                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }
}

