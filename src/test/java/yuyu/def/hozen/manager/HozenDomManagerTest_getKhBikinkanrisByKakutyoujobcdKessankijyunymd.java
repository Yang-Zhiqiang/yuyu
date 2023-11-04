package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

import java.util.Iterator;

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

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhBikinkanrisByKakutyoujobcdKessankijyunymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisByKakutyoujobcdKessankijyunymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd("JCD01", BizDate.valueOf(20160215));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111370", BizDate.valueOf(20160215), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160215), 1);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri1.setCalckijyunymd(BizDate.valueOf(20160213));
        khBikinkanri1.setKbnkeirisegcd(C_Segcd.valueOf("0000"));

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111370", BizDate.valueOf(20160214), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160215), 1);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri2.setCalckijyunymd(BizDate.valueOf(20160213));
        khBikinkanri2.setKbnkeirisegcd(C_Segcd.valueOf("0000"));

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111370", BizDate.valueOf(20160215), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160215), 2);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.valueOf("2"));
        khBikinkanri3.setCalckijyunymd(BizDate.valueOf(20160213));
        khBikinkanri3.setKbnkeirisegcd(C_Segcd.valueOf("0000"));

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111370", BizDate.valueOf(20160215), C_BkncdKbn.valueOf("0"), BizDate.valueOf(20160215), 1);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri4.setCalckijyunymd(BizDate.valueOf(20160213));
        khBikinkanri4.setKbnkeirisegcd(C_Segcd.valueOf("0000"));

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111152", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 3);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri5.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri5.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri5);

        IT_KhBikinkanri khBikinkanri6 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 4);
        khBikinkanri6.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri6.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri6.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri6);

        IT_KhBikinkanri khBikinkanri7 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 5);
        khBikinkanri7.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri7.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri7.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri7);

        IT_KhBikinkanri khBikinkanri8 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 6);
        khBikinkanri8.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri8.setCalckijyunymd(BizDate.valueOf(20160215));
        khBikinkanri8.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri8);

        IT_KhBikinkanri khBikinkanri9 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 7);
        khBikinkanri9.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri9.setCalckijyunymd(BizDate.valueOf(20160216));
        khBikinkanri9.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri9);

        IT_KhBikinkanri khBikinkanri10 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160217), 8);
        khBikinkanri10.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri10.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri10.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri10);

        IT_KhBikinkanri khBikinkanri11 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160216), 9);
        khBikinkanri11.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri11.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri11.setKbnkeirisegcd(C_Segcd.valueOf("2801"));

        hozenDomManager.insert(khBikinkanri11);

        IT_KhBikinkanri khBikinkanri12 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160216), C_BkncdKbn.valueOf("PC12"), BizDate.valueOf(20160218), 10);
        khBikinkanri12.setBknrigikbn(C_BknrigiKbn.valueOf("0"));
        khBikinkanri12.setCalckijyunymd(BizDate.valueOf(20160214));
        khBikinkanri12.setKbnkeirisegcd(C_Segcd.valueOf("2901"));

        hozenDomManager.insert(khBikinkanri12);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd("JCD01", BizDate.valueOf(20160210));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd("JCD01", BizDate.valueOf(20160215));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("11807111370", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160215), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160215), khBikinkanri.getBknkktymd());
                Assert.assertEquals(1, khBikinkanri.getRenno().intValue());

            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymd("JCD01", BizDate.valueOf(20160216));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : beans) {
            iCount++;


            if (1 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getBknkktymd());
                Assert.assertEquals(9, khBikinkanri.getRenno().intValue());

            }

            if (2 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160217), khBikinkanri.getBknkktymd());
                Assert.assertEquals(8, khBikinkanri.getRenno().intValue());

            }

            if (3 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(7, khBikinkanri.getRenno().intValue());

            }

            if (4 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(6, khBikinkanri.getRenno().intValue());

            }

            if (5 == iCount) {

                Assert.assertEquals("11807111130", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(5, khBikinkanri.getRenno().intValue());

            }

            if (6 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(4, khBikinkanri.getRenno().intValue());

            }

            if (7 == iCount) {

                Assert.assertEquals("11807111152", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(3, khBikinkanri.getRenno().intValue());

            }

            if (8 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160216), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.KAIYAKU, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khBikinkanri.getBknkktymd());
                Assert.assertEquals(10, khBikinkanri.getRenno().intValue());

            }




        }
        Assert.assertEquals(8, iCount);
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

        try(ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.getKhBikinkanrisByKakutyoujobcdKessankijyunymd("RBG5", BizDate.valueOf(20160216));){

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = beans.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                iCount++;
            }
            Assert.assertEquals(8, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RBG5");
        skipKey1.setTableid("IT_KhBikinkanri");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111130");

        hozenDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz001");
        recoveryFilter1.setRecoveryfilternm("証券番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");

        hozenDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.getKhBikinkanrisByKakutyoujobcdKessankijyunymd("RBG5", BizDate.valueOf(20160216));){

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = beans.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111130");
                iCount++;
            }
            Assert.assertEquals(7, iCount);
        }
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey skipKey2 = new BT_SkipKey("A03");
        skipKey2.setKakutyoujobcd("RBG5");
        skipKey2.setTableid("IT_KhBikinkanri");
        skipKey2.setRecoveryfilterid("Bz001");
        skipKey2.setRecoveryfilterkey1("11807111152");

        hozenDomManager.insert(skipKey2);
    }


    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<IT_KhBikinkanri> beans = hozenDomManager.getKhBikinkanrisByKakutyoujobcdKessankijyunymd("RBG5", BizDate.valueOf(20160216));){

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = beans.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111130");
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111152");
                iCount++;
            }
            Assert.assertEquals(6, iCount);
        }
    }
}
