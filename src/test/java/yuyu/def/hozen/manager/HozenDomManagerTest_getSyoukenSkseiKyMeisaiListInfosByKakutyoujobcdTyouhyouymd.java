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

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.hozen.result.bean.SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";

    @SuppressWarnings({ "resource", "unused" })
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("11807111118");

        if( null == kykKihon1 ) {

            kykKihon1 = new IT_KykKihon("01","11807111118");

            IT_HokenSyouken hokenSyouken1 = kykKihon1.createHokenSyouken();
            hokenSyouken1.setTyouhyouymd(BizDate.valueOf(20160215));

            IT_HokenSyouken hokenSyouken2 = kykKihon1.createHokenSyouken();
            hokenSyouken2.setTyouhyouymd(BizDate.valueOf(20160214));

            IT_KykSya kykSya1 = kykKihon1.createKykSya();

            IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

            hozenDomManager.insert(kykKihon1);

        }

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_HokenSyouken hokenSyouken3 = kykKihon3.createHokenSyouken();
        hokenSyouken3.setTyouhyouymd(BizDate.valueOf(20160215));

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_HokenSyouken hokenSyouken4 = kykKihon4.createHokenSyouken();
        hokenSyouken4.setTyouhyouymd(BizDate.valueOf(20160215));

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_HokenSyouken hokenSyouken5 = kykKihon5.createHokenSyouken();
        hokenSyouken5.setTyouhyouymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_HhknSya hhknSya4 = kykKihon5.createHhknSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_HokenSyouken hokenSyouken6 = kykKihon6.createHokenSyouken();
        hokenSyouken6.setTyouhyouymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_HhknSya hhknSya5 = kykKihon6.createHhknSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_HokenSyouken hokenSyouken7 = kykKihon7.createHokenSyouken();
        hokenSyouken7.setTyouhyouymd(BizDate.valueOf(20160220));

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_HhknSya hhknSya6 = kykKihon7.createHhknSya();

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

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160228));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160215));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", fKSKbean.getIT_HokenSyouken().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_HokenSyouken().getSyono());
                Assert.assertEquals(BizDate.valueOf(20160215), fKSKbean.getIT_HokenSyouken().getTyouhyouymd());

                Assert.assertEquals("01", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSya().getSyono());

                Assert.assertEquals("01", fKSKbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_HhknSya().getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("05", fKSKbean.getIT_HokenSyouken().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_HokenSyouken().getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getIT_HokenSyouken().getTyouhyouymd());

                Assert.assertEquals("05", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("05", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_KykSya().getSyono());

                Assert.assertEquals("05", fKSKbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111152", fKSKbean.getIT_HhknSya().getSyono());
            }

            if (2 == iCount) {
                Assert.assertEquals("06", fKSKbean.getIT_HokenSyouken().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_HokenSyouken().getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getIT_HokenSyouken().getTyouhyouymd());

                Assert.assertEquals("06", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("06", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_KykSya().getSyono());

                Assert.assertEquals("06", fKSKbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111163", fKSKbean.getIT_HhknSya().getSyono());
            }

            if (3 == iCount) {
                Assert.assertEquals("07", fKSKbean.getIT_HokenSyouken().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_HokenSyouken().getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), fKSKbean.getIT_HokenSyouken().getTyouhyouymd());

                Assert.assertEquals("07", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("07", fKSKbean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_KykSya().getSyono());

                Assert.assertEquals("07", fKSKbean.getIT_HhknSya().getKbnkey());
                Assert.assertEquals("11807111174", fKSKbean.getIT_HhknSya().getSyono());
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

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(3, iCount);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RBC1");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("05");
        skipKey1.setRecoveryfilterkey2("11807111152");

        hozenDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;
            assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), "11807111152");
            assertNotEquals(fKSKbean.getIT_KykKihon().getKbnkey(), "05");

        }
        Assert.assertEquals(2, iCount);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {

        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RBC1");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("06");
        skipKey2.setRecoveryfilterkey2("11807111163");

        hozenDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        ExDBResults<SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean> beans = hozenDomManager.
            getSyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymd("RBC1", BizDate.valueOf(20160220));

        int iCount = 0;
        for (SyoukenSkseiKyMeisaiListInfosByKakutyoujobcdTyouhyouymdBean fKSKbean : beans) {
            iCount++;
            assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), "11807111152");
            assertNotEquals(fKSKbean.getIT_KykKihon().getSyono(), "11807111163");
            assertNotEquals(fKSKbean.getIT_KykKihon().getKbnkey(), "05");
            assertNotEquals(fKSKbean.getIT_KykKihon().getKbnkey(), "06");

        }
        Assert.assertEquals(1, iCount);
    }
}
