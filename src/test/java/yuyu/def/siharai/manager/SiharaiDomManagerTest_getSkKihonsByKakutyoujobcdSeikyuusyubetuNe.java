package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金支払調書作成<br />
 * 請求基本テーブルエンティティリスト（大量）取得　支払履歴条件かつ請求種別以外のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByKakutyoujobcdSeikyuusyubetuNe {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RCA0";
    static String P_FILTER_ID = "Si001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> jT_SkKihon =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_01, BizDate.valueOf(20160908),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.BLNK)) {

            Assert.assertFalse(jT_SkKihon.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("11111", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("1111");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160908));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("11114", "11807111118");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki3 = skKihon2.createSiRireki();
        siRireki3.setShrsikibetukey("1112");
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki3.setShrsyoriymd(BizDate.valueOf(20160909));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("11113", "11807111118");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki4 = skKihon3.createSiRireki();
        siRireki4.setShrsikibetukey("1115");
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki4.setShrsyoriymd(BizDate.valueOf(20160908));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("11112", "11807111118");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("11111", "11807111129");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("11111", "11807111130");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);

        JT_SiRireki siRireki2 = skKihon6.createSiRireki();
        siRireki2.setShrsikibetukey("1111");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf(20160908));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("11116", "11807111163");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);

        JT_SiRireki siRireki5 = skKihon7.createSiRireki();
        siRireki5.setShrsikibetukey("1116");
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki5.setShrsyoriymd(BizDate.valueOf(20160910));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("11116", "11807111141");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);

        JT_SiRireki siRireki6 = skKihon8.createSiRireki();
        siRireki6.setShrsikibetukey("1117");
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki6.setShrsyoriymd(BizDate.valueOf(20160910));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("11116", "11807111130");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);

        JT_SiRireki siRireki7 = skKihon9.createSiRireki();
        siRireki7.setShrsikibetukey("1118");
        siRireki7.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki7.setShrsyoriymd(BizDate.valueOf(20160910));

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("11115", "11807111163");
        skKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);

        JT_SiRireki siRireki8 = skKihon10.createSiRireki();
        siRireki8.setShrsikibetukey("1119");
        siRireki8.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki8.setShrsyoriymd(BizDate.valueOf(20160910));

        siharaiDomManager.insert(skKihon10);

        JT_SkKihon skKihon11 = new JT_SkKihon("11114", "11807111163");
        skKihon11.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);

        JT_SiRireki siRireki9 = skKihon11.createSiRireki();
        siRireki9.setShrsikibetukey("1120");
        siRireki9.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki9.setShrsyoriymd(BizDate.valueOf(20160910));

        siharaiDomManager.insert(skKihon11);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SkKihon> jT_SkKihon =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_01, BizDate.valueOf(20160911),
                C_ShrKekkaKbn.HSHR, C_SeikyuuSyubetu.SBKRUKTK)) {

            Assert.assertFalse(jT_SkKihon.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SkKihon> jT_SkKihon =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_01, BizDate.valueOf(20160908),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.BLNK)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihon.iterator();
            JT_SkKihon JT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                JT_SkKihon = iter.next();

                Assert.assertEquals("11111", JT_SkKihon.getSkno());
                Assert.assertEquals("11807111118", JT_SkKihon.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<JT_SkKihon> jT_SkKihon =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_01, BizDate.valueOf(20160910),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.SB)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihon.iterator();
            JT_SkKihon JT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                JT_SkKihon = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("11116", JT_SkKihon.getSkno());
                    Assert.assertEquals("11807111130", JT_SkKihon.getSyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("11116", JT_SkKihon.getSkno());
                    Assert.assertEquals("11807111141", JT_SkKihon.getSyono());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("11114", JT_SkKihon.getSkno());
                    Assert.assertEquals("11807111163", JT_SkKihon.getSyono());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("11115", JT_SkKihon.getSkno());
                    Assert.assertEquals("11807111163", JT_SkKihon.getSyono());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("11116", JT_SkKihon.getSkno());
                    Assert.assertEquals("11807111163", JT_SkKihon.getSyono());

                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_02, BizDate.valueOf(20160910),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.SB)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter(P_FILTER_ID);
        recoveryFilter1.setRecoveryfilternm("請求基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");
        recoveryFilter1.setRecoveryfilterkeykmid2("skno");

        siharaiDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        skipKey1.setTableid("JT_SkKihon");
        skipKey1.setRecoveryfilterid(P_FILTER_ID);
        skipKey1.setRecoveryfilterkey1("11807111163");
        skipKey1.setRecoveryfilterkey2("11116");

        siharaiDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_02, BizDate.valueOf(20160910),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.SB)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("11116"))
                    && (jT_SkKihon.getSyono().equals("11807111163"));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        skipKey2.setTableid("JT_SkKihon");
        skipKey2.setRecoveryfilterid(P_FILTER_ID);
        skipKey2.setRecoveryfilterkey1("11807111141");
        skipKey2.setRecoveryfilterkey2("11116");

        siharaiDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults =
            siharaiDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(P_KAKUCHOJOBCD_02, BizDate.valueOf(20160910),
                C_ShrKekkaKbn.SHR, C_SeikyuuSyubetu.SB)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("11116"))
                    && (jT_SkKihon.getSyono().equals("11807111163"));

                boolean result2 = (jT_SkKihon.getSkno().equals("11116"))
                    && (jT_SkKihon.getSyono().equals("11807111141"));

                assertFalse(result1 || result2);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

}
