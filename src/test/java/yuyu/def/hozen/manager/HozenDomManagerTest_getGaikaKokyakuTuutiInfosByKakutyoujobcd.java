package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

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
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.GaikaKokyakuTuutiInfosByKakutyoujobcdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getGaikaKokyakuTuutiInfosByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getGaikaKokyakuTuutiInfosByKakutyoujobcd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA")) {

            int iCount = 0;
            for (GaikaKokyakuTuutiInfosByKakutyoujobcdBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "11807111141");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("01");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("01", "11807111152");

        IT_KykSya kykSya2 = kykKihon3.createKykSya();

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("01");
        kykSyouhn3.setSyouhnsdno(11);
        kykSyouhn3.setKyksyouhnrenno(11);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("01", "11807111163");

        IT_KykSya kykSya3 = kykKihon4.createKykSya();

        IT_HhknSya hhknSya3 = kykKihon4.createHhknSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("01", "11807111174");

        IT_KykSya kykSya4 = kykKihon5.createKykSya();

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn4.setSyouhncd("01");
        kykSyouhn4.setSyouhnsdno(11);
        kykSyouhn4.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya4 = kykKihon5.createHhknSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("01", "11807111185");

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        IT_KykSyouhn kykSyouhn5 = kykKihon6.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("11");
        kykSyouhn5.setSyouhnsdno(11);
        kykSyouhn5.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya5 = kykKihon6.createHhknSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("01", "11807111196");

        IT_KykSya kykSya6 = kykKihon7.createKykSya();

        IT_KykSyouhn kykSyouhn6 = kykKihon7.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn6.setSyouhncd("01");
        kykSyouhn6.setSyouhnsdno(99);
        kykSyouhn6.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya6 = kykKihon7.createHhknSya();

        hozenDomManager.insert(kykKihon7);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("01", 11);

        hozenDomManager.insert(syouhnZokusei1);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal10() {
        ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.
            getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA");

        int iCount = 0;
        for (GaikaKokyakuTuutiInfosByKakutyoujobcdBean bean : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("01", bean.getKykKihon().getKbnkey());
                Assert.assertEquals("11807111118", bean.getKykKihon().getSyono());

                Assert.assertEquals("01", bean.getKykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", bean.getKykSyouhn().getSyono());

            }
        }
        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("01");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("01");
        kykSyouhn3.setSyouhnsdno(11);
        kykSyouhn3.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        hozenDomManager.insert(kykKihon3);

    }

    @Test
    @TestOrder(31)
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("01","11807111118","01","11807111118","01","11807111118","01","11807111118","01","11"), "1");
        datamap.put($("02","11807111129","02","11807111129","02","11807111129","02","11807111129","01","11"), "2");
        datamap.put($("03","11807111130","03","11807111130","03","11807111130","03","11807111130","01","11"), "3");

        ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.
            getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA");

        for (GaikaKokyakuTuutiInfosByKakutyoujobcdBean bean : beans) {

            datamap.remove($(bean.getKykKihon().getKbnkey(),
                bean.getKykKihon().getSyono(),
                bean.getKykSyouhn().getKbnkey(),
                bean.getKykSyouhn().getSyono()));
        }
        Assert.assertTrue(datamap.isEmpty());

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

        try(ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA")){

            int iCount = 0;

            Iterator<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> iter = beans.iterator();

            GaikaKokyakuTuutiInfosByKakutyoujobcdBean GaikaKokyakuTuutiInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                GaikaKokyakuTuutiInfosByKakutyoujobcdBean = iter.next();
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh001");
        recoveryFilter1.setRecoveryfilternm("契約基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("kbnkey");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBCA");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("01");
        skipKey1.setRecoveryfilterkey2("11807111118");

        hozenDomManager.insert(skipKey1);

    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA")){
            int iCount = 0;

            Iterator<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> iter = beans.iterator();

            GaikaKokyakuTuutiInfosByKakutyoujobcdBean GaikaKokyakuTuutiInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                GaikaKokyakuTuutiInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getKbnkey().equals("01")) &&
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getSyono().equals("11807111118"));


                assertFalse(result1);
                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {

        BT_SkipKey skipKey2 = new BT_SkipKey("A04");
        skipKey2.setKakutyoujobcd("RBCA");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("02");
        skipKey2.setRecoveryfilterkey2("11807111129");

        hozenDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> beans = hozenDomManager.getGaikaKokyakuTuutiInfosByKakutyoujobcd("RBCA")){

            int iCount = 0;

            Iterator<GaikaKokyakuTuutiInfosByKakutyoujobcdBean> iter = beans.iterator();

            GaikaKokyakuTuutiInfosByKakutyoujobcdBean GaikaKokyakuTuutiInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                GaikaKokyakuTuutiInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getKbnkey().equals("01")) &&
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getSyono().equals("11807111118"));
                boolean result2 =
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getKbnkey().equals("02")) &&
                    (GaikaKokyakuTuutiInfosByKakutyoujobcdBean.getKykKihon().getSyono().equals("11807111129"));
                assertFalse(result1);
                assertFalse(result2);
                iCount++;
            }

            Assert.assertEquals(1, iCount);

        }
    }
}

