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
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.SyainMeiboInfosByKakutyoujobcdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSyainMeiboInfosByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getSyainMeiboInfosByKakutyoujobcd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.getSyainMeiboInfosByKakutyoujobcd("RBL1")) {

            int iCount = 0;
            for (SyainMeiboInfosByKakutyoujobcdBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn5 = kykKihon1.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("0003");
        kykSyouhn5.setSyouhnsdno(10);
        kykSyouhn5.setKyksyouhnrenno(01);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn1 = kykKihon2.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("0001");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(01);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KykSyouhn kykSyouhn2 = kykKihon3.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("0001");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(01);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn3 = kykKihon4.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("0001");
        kykSyouhn3.setSyouhnsdno(20);
        kykSyouhn3.setKyksyouhnrenno(01);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya4 = kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("0002");
        kykSyouhn4.setSyouhnsdno(10);
        kykSyouhn4.setKyksyouhnrenno(01);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSya kykSya5 = kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        BM_SyouhnZokusei syouhnZokusei1 = new BM_SyouhnZokusei("0001", 10);
        syouhnZokusei1.setHaitoukbn(C_HaitouKbn.RISAHAI);

        hozenDomManager.insert(syouhnZokusei1);

        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei("0003", 10);
        syouhnZokusei2.setHaitoukbn(C_HaitouKbn.NONE);

        hozenDomManager.insert(syouhnZokusei2);


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
        ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.
            getSyainMeiboInfosByKakutyoujobcd("RBB5");

        int iCount = 0;
        for (SyainMeiboInfosByKakutyoujobcdBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        IT_KykSyouhn kykSyouhn1 = new IT_KykSyouhn("01", "11807111118", C_SyutkKbn.SYU, "0001", 10, 01);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        hozenDomManager.insert(kykSyouhn1);


    }
    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {
        ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.
            getSyainMeiboInfosByKakutyoujobcd("RBL1");

        int iCount = 0;
        for (SyainMeiboInfosByKakutyoujobcdBean bean : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("01", bean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", bean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykSya().getSyono());

                Assert.assertEquals("01", bean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykSyouhn().getSyono());

                Assert.assertEquals("0001", bean.getBM_SyouhnZokusei().getSyouhncd());
                Assert.assertEquals(10, bean.getBM_SyouhnZokusei().getSyouhnsdno().intValue());

            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("00", "11807111200");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("0001");
        kykSyouhn1.setSyouhnsdno(10);
        kykSyouhn1.setKyksyouhnrenno(01);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "11807111211");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("0001");
        kykSyouhn2.setSyouhnsdno(10);
        kykSyouhn2.setKyksyouhnrenno(01);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("02", "11807111222");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("0001");
        kykSyouhn3.setSyouhnsdno(10);
        kykSyouhn3.setKyksyouhnrenno(01);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

    }

    @Test
    @TestOrder(31)
    public void normal31() {
        ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.
            getSyainMeiboInfosByKakutyoujobcd("RBL1");

        HashMap<String,String> datamap1 = new HashMap<String,String>();
        datamap1.put($("00","11807111200","00","11807111200","00","11807111200","0001",10), "1");
        datamap1.put($("01","11807111211","01","11807111211","01","11807111211","0001",10), "2");
        datamap1.put($("02","11807111222","02","11807111222","02","11807111222","0001",10), "3");

        int iCount = 0;
        for (SyainMeiboInfosByKakutyoujobcdBean bean : beans) {
            datamap1.remove($(
                bean.getIT_KykKihon().getKbnkey(),
                bean.getIT_KykKihon().getSyono(),
                bean.getIT_KykSya().getKbnkey(),
                bean.getIT_KykSya().getSyono(),
                bean.getIT_KykSyouhn().getKbnkey(),
                bean.getIT_KykSyouhn().getSyono(),
                bean.getBM_SyouhnZokusei().getSyouhncd(),
                bean.getBM_SyouhnZokusei().getSyouhnsdno().intValue()));
        }
        Assert.assertTrue(datamap1.isEmpty());

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

        try(ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.getSyainMeiboInfosByKakutyoujobcd("RBL1")){

            int iCount = 0;

            Iterator<SyainMeiboInfosByKakutyoujobcdBean> iter = beans.iterator();

            SyainMeiboInfosByKakutyoujobcdBean SyainMeiboInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SyainMeiboInfosByKakutyoujobcdBean = iter.next();
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
        skipKey1.setKakutyoujobcd("RBL1");
        skipKey1.setTableid("IT_KykKihon");
        skipKey1.setRecoveryfilterid("Kh001");
        skipKey1.setRecoveryfilterkey1("00");
        skipKey1.setRecoveryfilterkey2("11807111200");

        hozenDomManager.insert(skipKey1);

    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.getSyainMeiboInfosByKakutyoujobcd("RBL1")){
            int iCount = 0;

            Iterator<SyainMeiboInfosByKakutyoujobcdBean> iter = beans.iterator();

            SyainMeiboInfosByKakutyoujobcdBean SyainMeiboInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SyainMeiboInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("00")) &&
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111200"));


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
        skipKey2.setKakutyoujobcd("RBL1");
        skipKey2.setTableid("IT_KykKihon");
        skipKey2.setRecoveryfilterid("Kh001");
        skipKey2.setRecoveryfilterkey1("01");
        skipKey2.setRecoveryfilterkey2("11807111211");

        hozenDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<SyainMeiboInfosByKakutyoujobcdBean> beans = hozenDomManager.getSyainMeiboInfosByKakutyoujobcd("RBL1")){

            int iCount = 0;

            Iterator<SyainMeiboInfosByKakutyoujobcdBean> iter = beans.iterator();

            SyainMeiboInfosByKakutyoujobcdBean SyainMeiboInfosByKakutyoujobcdBean = null;

            while (iter.hasNext()) {
                SyainMeiboInfosByKakutyoujobcdBean = iter.next();
                boolean result1 =
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("00")) &&
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111200"));
                boolean result2 =
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getKbnkey().equals("01")) &&
                    (SyainMeiboInfosByKakutyoujobcdBean.getIT_KykKihon().getSyono().equals("11807111211"));
                assertFalse(result1);
                assertFalse(result2);
                iCount++;
            }

            Assert.assertEquals(1, iCount);

        }
    }
}

