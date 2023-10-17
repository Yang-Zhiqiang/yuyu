package yuyu.def.sinkeiyaku.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSmbcStyKanrisByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisByKakutyoujobcd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SmbcStyKanri> beans =
            sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd("RGBQ")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(0));
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setRendouflg(C_Rendouflg.valueOf("1"));
        smbcStyKanri1.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

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

        try (ExDBResults<HT_SmbcStyKanri> beans =
            sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd("RGBQ")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(0));
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri1.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(1));
        smbcStyKanri2.setSyono("11807111118");
        smbcStyKanri2.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri2.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(10));
        smbcStyKanri3.setSyono("11807111118");
        smbcStyKanri3.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri3.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20160216), BizNumber.valueOf(10));
        smbcStyKanri4.setSyono("11807111118");
        smbcStyKanri4.setRendouflg(C_Rendouflg.valueOf("1"));
        smbcStyKanri4.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri4);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {


        ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd("RGBQ");

        int iCount = 0;
        for (HT_SmbcStyKanri SmbcStyKanri : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160215), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(0));
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri1.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(1));
        smbcStyKanri2.setSyono("11807111118");
        smbcStyKanri2.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri2.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20160215), BizNumber.valueOf(10));
        smbcStyKanri3.setSyono("11807111118");
        smbcStyKanri3.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri3.setSmbcuktkkanriid("100001");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20160216), BizNumber.valueOf(10));
        smbcStyKanri4.setSyono("11807111118");
        smbcStyKanri4.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri4.setSmbcuktkkanriid("100003");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri(BizDate.valueOf(20160217), BizNumber.valueOf(10));
        smbcStyKanri5.setSyono("11807111118");
        smbcStyKanri5.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri5.setSmbcuktkkanriid("100002");

        sinkeiyakuDomManager.insert(smbcStyKanri5);

        HT_SmbcStyKanri smbcStyKanri6 = new HT_SmbcStyKanri(BizDate.valueOf(20160218), BizNumber.valueOf(10));
        smbcStyKanri6.setSyono("11807111130");
        smbcStyKanri6.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri6.setSmbcuktkkanriid("100003");

        sinkeiyakuDomManager.insert(smbcStyKanri6);

        HT_SmbcStyKanri smbcStyKanri7 = new HT_SmbcStyKanri(BizDate.valueOf(20160219), BizNumber.valueOf(10));
        smbcStyKanri7.setSyono("11807111129");
        smbcStyKanri7.setRendouflg(C_Rendouflg.valueOf("0"));
        smbcStyKanri7.setSmbcuktkkanriid("100003");

        sinkeiyakuDomManager.insert(smbcStyKanri7);
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd("RGBQ");

        int iCount = 0;
        for (HT_SmbcStyKanri SmbcStyKanri : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160215), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
                Assert.assertEquals("100001", SmbcStyKanri.getSmbcuktkkanriid());
                Assert.assertEquals("11807111118", SmbcStyKanri.getSyono());
            }

            if (2 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160217), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
                Assert.assertEquals("100002", SmbcStyKanri.getSmbcuktkkanriid());
                Assert.assertEquals("11807111118", SmbcStyKanri.getSyono());
            }

            if (3 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160216), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
                Assert.assertEquals("100003", SmbcStyKanri.getSmbcuktkkanriid());
                Assert.assertEquals("11807111118", SmbcStyKanri.getSyono());
            }

            if (4 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160219), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
                Assert.assertEquals("100003", SmbcStyKanri.getSmbcuktkkanriid());
                Assert.assertEquals("11807111129", SmbcStyKanri.getSyono());
            }

            if (5 == iCount) {
                Assert.assertEquals(BizDate.valueOf(20160218), SmbcStyKanri.getDatarenymd());
                Assert.assertEquals(BizNumber.valueOf(10), SmbcStyKanri.getDatasakuseirenno());
                Assert.assertEquals("100003", SmbcStyKanri.getSmbcuktkkanriid());
                Assert.assertEquals("11807111130", SmbcStyKanri.getSyono());
            }
        }
        Assert.assertEquals(5, iCount);
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
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd(
            "RGBQ");){
            for (HT_SmbcStyKanri SmbcStyKanri : beans) {
                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk007");
        filter.setRecoveryfilterkeykmid1("smbcuktkkanriid");
        filter.setRecoveryfilternm("ＳＭＢＣ＿受付管理ＩＤフィルタ");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid("Sk007");
        key3.setKakutyoujobcd("RGBQ");
        key3.setRecoveryfilterkey1("100001");
        key3.setTableid("HT_SmbcStyKanri");
        sinkeiyakuDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd(
            "RGBQ");){
            for(HT_SmbcStyKanri SmbcStyKanri : beans){
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "100001");

                iCount++;
            }
            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid("Sk007");
        key1.setKakutyoujobcd("RGBQ");
        key1.setRecoveryfilterkey1("100002");
        key1.setTableid("HT_SmbcStyKanri");
        sinkeiyakuDomManager.insert(key1);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcd(
            "RGBQ");){
            for(HT_SmbcStyKanri SmbcStyKanri : beans){
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "100001");
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "100002");

                iCount++;
            }
            assertEquals(3, iCount);
        }
    }
}


