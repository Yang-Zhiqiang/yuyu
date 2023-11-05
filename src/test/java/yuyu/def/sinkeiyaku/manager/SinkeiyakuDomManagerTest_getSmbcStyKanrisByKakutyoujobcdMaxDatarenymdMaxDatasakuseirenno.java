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
 * getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SmbcStyKanri> beans =
            sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20161111), BizNumber.valueOf(4444444));
        smbcStyKanri1.setSyono("11807111118");
        smbcStyKanri1.setRendouflg(C_Rendouflg.RENDOUZUMI);
        smbcStyKanri1.setSmbcuktkkanriid("9999999");

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
            sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20171001), BizNumber.valueOf(91));
        smbcStyKanri1.setSyono("11807111129");
        smbcStyKanri1.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri1.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(11));
        smbcStyKanri2.setSyono("11807111129");
        smbcStyKanri2.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri2.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(12));
        smbcStyKanri3.setSyono("11807111129");
        smbcStyKanri3.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri3.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(13));
        smbcStyKanri4.setSyono("11807111129");
        smbcStyKanri4.setRendouflg(C_Rendouflg.RENDOUZUMI);
        smbcStyKanri4.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")){

            int iCount = 0;
            for (HT_SmbcStyKanri SmbcStyKanri : beans) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20171002), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(12), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111129", SmbcStyKanri.getSyono());
                    Assert.assertEquals("6666666", SmbcStyKanri.getSmbcuktkkanriid());
                }

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());

        HT_SmbcStyKanri smbcStyKanri1 = new HT_SmbcStyKanri(BizDate.valueOf(20161110), BizNumber.valueOf(6666666));
        smbcStyKanri1.setSyono("11807111163");
        smbcStyKanri1.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri1.setSmbcuktkkanriid("9999999");

        sinkeiyakuDomManager.insert(smbcStyKanri1);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri(BizDate.valueOf(20161110), BizNumber.valueOf(5555555));
        smbcStyKanri2.setSyono("11807111163");
        smbcStyKanri2.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri2.setSmbcuktkkanriid("9999999");

        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri3 = new HT_SmbcStyKanri(BizDate.valueOf(20161109), BizNumber.valueOf(7777777));
        smbcStyKanri3.setSyono("11807111163");
        smbcStyKanri3.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri3.setSmbcuktkkanriid("9999999");

        sinkeiyakuDomManager.insert(smbcStyKanri3);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri(BizDate.valueOf(20151110), BizNumber.valueOf(6666666));
        smbcStyKanri4.setSyono("11807111174");
        smbcStyKanri4.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri4.setSmbcuktkkanriid("8888888");

        sinkeiyakuDomManager.insert(smbcStyKanri4);

        HT_SmbcStyKanri smbcStyKanri5 = new HT_SmbcStyKanri(BizDate.valueOf(20151110), BizNumber.valueOf(5555555));
        smbcStyKanri5.setSyono("11807111174");
        smbcStyKanri5.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri5.setSmbcuktkkanriid("8888888");

        sinkeiyakuDomManager.insert(smbcStyKanri5);

        HT_SmbcStyKanri smbcStyKanri6 = new HT_SmbcStyKanri(BizDate.valueOf(20151109), BizNumber.valueOf(7777777));
        smbcStyKanri6.setSyono("11807111174");
        smbcStyKanri6.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri6.setSmbcuktkkanriid("8888888");

        sinkeiyakuDomManager.insert(smbcStyKanri6);

        HT_SmbcStyKanri smbcStyKanri7 = new HT_SmbcStyKanri(BizDate.valueOf(20141110), BizNumber.valueOf(6666666));
        smbcStyKanri7.setSyono("11807111200");
        smbcStyKanri7.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri7.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri7);

        HT_SmbcStyKanri smbcStyKanri8 = new HT_SmbcStyKanri(BizDate.valueOf(20141110), BizNumber.valueOf(5555555));
        smbcStyKanri8.setSyono("11807111200");
        smbcStyKanri8.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri8.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri8);

        HT_SmbcStyKanri smbcStyKanri9 = new HT_SmbcStyKanri(BizDate.valueOf(20141109), BizNumber.valueOf(7777777));
        smbcStyKanri9.setSyono("11807111200");
        smbcStyKanri9.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri9.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri9);

        HT_SmbcStyKanri smbcStyKanri10 = new HT_SmbcStyKanri(BizDate.valueOf(20131110), BizNumber.valueOf(6666666));
        smbcStyKanri10.setSyono("11807111196");
        smbcStyKanri10.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri10.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri10);

        HT_SmbcStyKanri smbcStyKanri11 = new HT_SmbcStyKanri(BizDate.valueOf(20131110), BizNumber.valueOf(5555555));
        smbcStyKanri11.setSyono("11807111196");
        smbcStyKanri11.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri11.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri11);

        HT_SmbcStyKanri smbcStyKanri12 = new HT_SmbcStyKanri(BizDate.valueOf(20131109), BizNumber.valueOf(7777777));
        smbcStyKanri12.setSyono("11807111196");
        smbcStyKanri12.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri12.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri12);

        HT_SmbcStyKanri smbcStyKanri13 = new HT_SmbcStyKanri(BizDate.valueOf(20121110), BizNumber.valueOf(6666666));
        smbcStyKanri13.setSyono("11807111185");
        smbcStyKanri13.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri13.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri13);

        HT_SmbcStyKanri smbcStyKanri14 = new HT_SmbcStyKanri(BizDate.valueOf(20121110), BizNumber.valueOf(5555555));
        smbcStyKanri14.setSyono("11807111185");
        smbcStyKanri14.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri14.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri14);

        HT_SmbcStyKanri smbcStyKanri15 = new HT_SmbcStyKanri(BizDate.valueOf(20121109), BizNumber.valueOf(7777777));
        smbcStyKanri15.setSyono("11807111185");
        smbcStyKanri15.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri15.setSmbcuktkkanriid("7777777");

        sinkeiyakuDomManager.insert(smbcStyKanri15);

        HT_SmbcStyKanri smbcStyKanri16 = new HT_SmbcStyKanri(BizDate.valueOf(20171001), BizNumber.valueOf(90));
        smbcStyKanri16.setSyono("11807111118");
        smbcStyKanri16.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri16.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri16);

        HT_SmbcStyKanri smbcStyKanri17 = new HT_SmbcStyKanri(BizDate.valueOf(20171001), BizNumber.valueOf(91));
        smbcStyKanri17.setSyono("11807111129");
        smbcStyKanri17.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri17.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri17);

        HT_SmbcStyKanri smbcStyKanri18 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(11));
        smbcStyKanri18.setSyono("11807111129");
        smbcStyKanri18.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri18.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri18);

        HT_SmbcStyKanri smbcStyKanri19 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(12));
        smbcStyKanri19.setSyono("11807111129");
        smbcStyKanri19.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri19.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri19);

        HT_SmbcStyKanri smbcStyKanri20 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(13));
        smbcStyKanri20.setSyono("11807111129");
        smbcStyKanri20.setRendouflg(C_Rendouflg.RENDOUZUMI);
        smbcStyKanri20.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri20);

        HT_SmbcStyKanri smbcStyKanri21 = new HT_SmbcStyKanri(BizDate.valueOf(20171002), BizNumber.valueOf(14));
        smbcStyKanri21.setSyono("11807111130");
        smbcStyKanri21.setRendouflg(C_Rendouflg.MIRENDOU);
        smbcStyKanri21.setSmbcuktkkanriid("6666666");

        sinkeiyakuDomManager.insert(smbcStyKanri21);

    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        try (ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")){

            int iCount = 0;
            for (HT_SmbcStyKanri SmbcStyKanri : beans) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20171001), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(90), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111118", SmbcStyKanri.getSyono());
                    Assert.assertEquals("6666666", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (2 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20171002), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(12), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111129", SmbcStyKanri.getSyono());
                    Assert.assertEquals("6666666", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (3 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20171002), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(14), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111130", SmbcStyKanri.getSyono());
                    Assert.assertEquals("6666666", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (4 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20121110), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(6666666), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111185", SmbcStyKanri.getSyono());
                    Assert.assertEquals("7777777", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (5 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20131110), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(6666666), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111196", SmbcStyKanri.getSyono());
                    Assert.assertEquals("7777777", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (6 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20141110), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(6666666), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111200", SmbcStyKanri.getSyono());
                    Assert.assertEquals("7777777", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (7 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20151110), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(6666666), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111174", SmbcStyKanri.getSyono());
                    Assert.assertEquals("8888888", SmbcStyKanri.getSmbcuktkkanriid());
                }

                if (8 == iCount) {
                    Assert.assertEquals(BizDate.valueOf(20161110), SmbcStyKanri.getDatarenymd());
                    Assert.assertEquals(BizNumber.valueOf(6666666), SmbcStyKanri.getDatasakuseirenno());
                    Assert.assertEquals("11807111163", SmbcStyKanri.getSyono());
                    Assert.assertEquals("9999999", SmbcStyKanri.getSmbcuktkkanriid());
                }
            }
            Assert.assertEquals(8, iCount);
        }
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
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")){
            for (HT_SmbcStyKanri SmbcStyKanri : beans) {
                iCount++;
            }

            Assert.assertEquals(8, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBCA");
        skipKey1.setTableid("HT_SmbcStyKanri");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111163");

        sinkeiyakuDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz001");
        recoveryFilter1.setRecoveryfilternm("証券番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");

        sinkeiyakuDomManager.insert(recoveryFilter1);

    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")){
            for(HT_SmbcStyKanri SmbcStyKanri : beans){
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "11807111163");

                iCount++;
            }
            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A01");
        skipKey2.setKakutyoujobcd("RBCA");
        skipKey2.setTableid("HT_SmbcStyKanri");
        skipKey2.setRecoveryfilterid("Bz001");
        skipKey2.setRecoveryfilterkey1("11807111174");

        sinkeiyakuDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<HT_SmbcStyKanri> beans = sinkeiyakuDomManager.getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno("RBCA")){
            for(HT_SmbcStyKanri SmbcStyKanri : beans){
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "11807111163");
                assertNotEquals(SmbcStyKanri.getSmbcuktkkanriid(), "11807111174");

                iCount++;
            }
            assertEquals(6, iCount);
        }
    }
}



