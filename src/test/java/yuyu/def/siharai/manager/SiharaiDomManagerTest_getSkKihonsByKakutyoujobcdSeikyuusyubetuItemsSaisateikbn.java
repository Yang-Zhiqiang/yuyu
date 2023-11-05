package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_SaisateiKbn;
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
 * 保険金給付金備金情報抽出<br />
 * 請求基本テーブルエンティティリスト（大量）取得　請求種別かつ決算基準日複数かつ再査定区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RCA0";
    static String P_FILTER_ID = "Si001";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> iT_KhDenpyoDatas = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_01, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160911), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            Assert.assertFalse(iT_KhDenpyoDatas.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("SKNO01", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon1.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon1.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey("SHR01");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160916));
        siRireki1.setTyakkinymd(BizDate.valueOf(20160913));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("SKNO01", "11807111129");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon2.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon2.setSiboukaritrkymd(BizDate.valueOf(20160914));

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey("SHR01");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf(20160915));
        siRireki2.setTyakkinymd(BizDate.valueOf(20160914));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("SKNO01", "11807111130");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon3.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon3.setSiboukaritrkymd(BizDate.valueOf(20160911));

        JT_SiRireki siRireki3 = skKihon3.createSiRireki();
        siRireki3.setShrsikibetukey("SHR01");
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki3.setShrsyoriymd(BizDate.valueOf(20160914));
        siRireki3.setTyakkinymd(BizDate.valueOf(20160915));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("SKNO01", "11807111141");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon4.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon4.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki4 = skKihon4.createSiRireki();
        siRireki4.setShrsikibetukey("SHR01");
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki4.setShrsyoriymd(BizDate.valueOf(20160913));
        siRireki4.setTyakkinymd(BizDate.valueOf(20160916));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("SKNO02", "11807111118");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon5.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon5.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki5 = skKihon5.createSiRireki();
        siRireki5.setShrsikibetukey("SHR01");
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki5.setShrsyoriymd(BizDate.valueOf(20160913));
        siRireki5.setTyakkinymd(BizDate.valueOf(20160916));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("SKNO02", "11807111129");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon6.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon6.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki6 = skKihon6.createSiRireki();
        siRireki6.setShrsikibetukey("SHR01");
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki6.setShrsyoriymd(BizDate.valueOf(20160914));
        siRireki6.setTyakkinymd(BizDate.valueOf(20160915));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("SKNO02", "11807111130");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon7.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon7.setSiboukaritrkymd(BizDate.valueOf(20160914));

        JT_SiRireki siRireki7 = skKihon7.createSiRireki();
        siRireki7.setShrsikibetukey("SHR01");
        siRireki7.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki7.setShrsyoriymd(BizDate.valueOf(20160915));
        siRireki7.setTyakkinymd(BizDate.valueOf(20160914));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("SKNO02", "11807111141");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon8.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon8.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki8 = skKihon8.createSiRireki();
        siRireki8.setShrsikibetukey("SHR01");
        siRireki8.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki8.setShrsyoriymd(BizDate.valueOf(20160916));
        siRireki8.setTyakkinymd(BizDate.valueOf(20160913));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("SKNO02", "11807111152");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon9.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon9.setSiboukaritrkymd(BizDate.valueOf(20160915));

        JT_SiRireki siRireki9 = skKihon9.createSiRireki();
        siRireki9.setShrsikibetukey("SHR01");
        siRireki9.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki9.setShrsyoriymd(BizDate.valueOf(20160915));
        siRireki9.setTyakkinymd(BizDate.valueOf(20160914));

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("SKNO02", "11807111163");
        skKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon10.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon10.setSiboukaritrkymd(BizDate.valueOf(20160916));

        JT_SiRireki siRireki10 = skKihon10.createSiRireki();
        siRireki10.setShrsikibetukey("SHR01");
        siRireki10.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki10.setShrsyoriymd(BizDate.valueOf(20160916));
        siRireki10.setTyakkinymd(BizDate.valueOf(20160913));

        siharaiDomManager.insert(skKihon10);

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

        try (ExDBResults<JT_SkKihon> iT_KhDenpyoDatas = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_01, C_SeikyuuSyubetu.KOUSG,
                BizDate.valueOf(20160911), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            Assert.assertFalse(iT_KhDenpyoDatas.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_01, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160911), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                Assert.assertEquals("SKNO01", jT_SkKihon.getSkno());
                Assert.assertEquals("11807111130", jT_SkKihon.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("SKNO01","11807111130"), "1");
        datamap.put($("SKNO01","11807111141"), "2");
        datamap.put($("SKNO02","11807111130"), "2");

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_01, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160915), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                datamap.remove($(
                    jT_SkKihon.getSkno(),
                    jT_SkKihon.getSyono()));

            }
            Assert.assertTrue(datamap.isEmpty());
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

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_02, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160915), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
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
        skipKey1.setRecoveryfilterkey1("11807111130");
        skipKey1.setRecoveryfilterkey2("SKNO01");

        siharaiDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_02, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160915), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("SKNO01"))
                    && (jT_SkKihon.getSyono().equals("11807111130"));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
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
        skipKey2.setRecoveryfilterkey2("SKNO01");

        siharaiDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBResults<JT_SkKihon> jT_SkKihonResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(P_KAKUCHOJOBCD_02, C_SeikyuuSyubetu.SB,
                BizDate.valueOf(20160915), C_SaisateiKbn.BLNK, BizDate.valueOf(20160914), BizDate.valueOf(20160914));) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = jT_SkKihonResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("SKNO01"))
                    && (jT_SkKihon.getSyono().equals("11807111130"));

                boolean result2 = (jT_SkKihon.getSkno().equals("SKNO01"))
                    && (jT_SkKihon.getSyono().equals("11807111141"));

                assertFalse(result1 || result2);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
