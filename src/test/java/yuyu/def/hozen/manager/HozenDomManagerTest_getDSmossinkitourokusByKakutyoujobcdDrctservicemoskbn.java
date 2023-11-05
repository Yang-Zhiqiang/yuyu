package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.result.bean.DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn {

    @Inject
    HozenDomManager hozenDomManager;

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA")) {

            int iCount = 0;
            for (DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
        kykKihon1.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");

        hozenDomManager.insert(dsKokyakuKanri1);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA")) {

            int iCount = 0;
            for (DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean bean : beans) {
                iCount++;
            }
            Assert.assertEquals(0, iCount);
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
        kykKihon1.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("03", "11807111130");
        kykKihon2.setDrctservicemoskbn(C_DirectServiceMosKbn.NOENTRY);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("02", "11807111129");
        kykKihon3.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");
        kykKihon4.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        hozenDomManager.insert(kykKihon4);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111129");

        hozenDomManager.insert(dsKokyakuKanri1);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans = hozenDomManager.
            getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA");

        int iCount = 0;
        for (DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean bean : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("01", bean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", bean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykSya().getSyono());

            }
        }
        Assert.assertEquals(1, iCount);

    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");
        kykKihon1.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");
        kykKihon2.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");
        kykKihon3.setDrctservicemoskbn(C_DirectServiceMosKbn.ENTRY);

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111141");

        hozenDomManager.insert(dsKokyakuKanri1);

    }

    @Test
    @TestOrder(31)
    public void normal31() {

        ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans = hozenDomManager.
            getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA");

        int iCount = 0;
        for (DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean bean : beans) {
            iCount++;
            if (1 == iCount) {
                Assert.assertEquals("01", bean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", bean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111118", bean.getIT_KykSya().getSyono());

            }

            if (2 == iCount) {
                Assert.assertEquals("02", bean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111129", bean.getIT_KykKihon().getSyono());

                Assert.assertEquals("02", bean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111129", bean.getIT_KykSya().getSyono());

            }

            if (3 == iCount) {
                Assert.assertEquals("03", bean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111130", bean.getIT_KykKihon().getSyono());

                Assert.assertEquals("03", bean.getIT_KykSya().getKbnkey());
                Assert.assertEquals("11807111130", bean.getIT_KykSya().getSyono());

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

        try(ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA")){

            int iCount = 0;

            Iterator<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> iter = beans.iterator();

            DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = null;

            while (iter.hasNext()) {
                dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = iter.next();
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

        BT_SkipKey skipKey1 = new BT_SkipKey("00001");
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

        try(ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA")){
            int iCount = 0;

            Iterator<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> iter = beans.iterator();

            DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = null;

            while (iter.hasNext()) {
                dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = iter.next();
                boolean result1 =
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getKbnkey().equals("01")) &&
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getSyono().equals("11807111118"));


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

        BT_SkipKey skipKey2 = new BT_SkipKey("00002");
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

        try(ExDBResults<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> beans =
            hozenDomManager.getDSmossinkitourokusByKakutyoujobcdDrctservicemoskbn("RBCA")){

            int iCount = 0;

            Iterator<DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean> iter = beans.iterator();

            DSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = null;

            while (iter.hasNext()) {
                dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean = iter.next();
                boolean result1 =
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getKbnkey().equals("01")) &&
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getSyono().equals("11807111118"));
                boolean result2 =
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getKbnkey().equals("02")) &&
                    (dSmossinkitourokusByKakutyoujobcdDrctservicemoskbnBean.getIT_KykKihon().getSyono().equals("11807111129"));
                assertFalse(result1);
                assertFalse(result2);
                iCount++;
            }

            Assert.assertEquals(1, iCount);

        }
    }
}




