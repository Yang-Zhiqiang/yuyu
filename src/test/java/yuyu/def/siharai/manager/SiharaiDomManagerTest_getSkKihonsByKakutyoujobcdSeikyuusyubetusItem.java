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

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金情報抽出<br />
 * 請求基本テーブルエンティティリスト（大量）取得　請求種別複数かつ死亡仮受付登録日のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByKakutyoujobcdSeikyuusyubetusItem {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RCF0";
    static String P_SKNO_001 = "SK000000001";
    static String P_SKNO_002 = "SK000000002";
    static String P_SKNO_003 = "SK000000003";
    static String P_SKNO_004 = "SK000000004";
    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";
    static String P_SYONO_003 = "11807111130";
    static String P_SYONO_004 = "11807111141";
    static BizDate P_SIBOUKARITRKYMD_01 = BizDate.valueOf(20160413);
    static BizDate P_SIBOUKARITRKYMD_02 = BizDate.valueOf(20160414);
    static BizDate P_SIBOUKARITRKYMD_03 = BizDate.valueOf(20160415);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_01, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_01)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_001);
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon1.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_002, P_SYONO_001);
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.SB);
        skKihon2.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_001, P_SYONO_002);
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon3.setSiboukaritrkymd(P_SIBOUKARITRKYMD_01);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon(P_SKNO_002, P_SYONO_002);
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon4.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon(P_SKNO_003, P_SYONO_002);
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KOUSG);
        skKihon5.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon(P_SKNO_004, P_SYONO_002);
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon6.setSiboukaritrkymd(P_SIBOUKARITRKYMD_03);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon(P_SKNO_003, P_SYONO_003);
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon7.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon(P_SKNO_004, P_SYONO_004);
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon8.setSiboukaritrkymd(P_SIBOUKARITRKYMD_02);

        siharaiDomManager.insert(skKihon8);
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

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_01, C_SeikyuuSyubetu.BLNK, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_02)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_01, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_01)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                Assert.assertEquals(P_SKNO_001, jT_SkKihon.getSkno());
                Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());
                Assert.assertEquals(P_SIBOUKARITRKYMD_01, jT_SkKihon.getSiboukaritrkymd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SKNO_001,P_SYONO_002,C_SeikyuuSyubetu.KYH,P_SIBOUKARITRKYMD_01), "1");
        datamap.put($(P_SKNO_002,P_SYONO_002,C_SeikyuuSyubetu.KYH,P_SIBOUKARITRKYMD_02), "1");
        datamap.put($(P_SKNO_003,P_SYONO_003,C_SeikyuuSyubetu.KYH,P_SIBOUKARITRKYMD_02), "1");
        datamap.put($(P_SKNO_004,P_SYONO_004,C_SeikyuuSyubetu.KYH,P_SIBOUKARITRKYMD_02), "1");

        try(ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_01, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_02)) {

            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                datamap.remove($(
                    jT_SkKihon.getSkno(),
                    jT_SkKihon.getSyono(),
                    jT_SkKihon.getSeikyuusyubetu(),
                    jT_SkKihon.getSiboukaritrkymd()));

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
    public void testSkippedFilter40(){

        try(ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_02, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_02)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();
                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter("Si001");
        bM_RecoveryFilter.setRecoveryfilternm("請求基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("syono");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("skno");

        siharaiDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("JT_SkKihon");
        bT_SkipKey1.setRecoveryfilterid("Si001");
        bT_SkipKey1.setRecoveryfilterkey1(P_SYONO_003);
        bT_SkipKey1.setRecoveryfilterkey2(P_SKNO_003);

        siharaiDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_02, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_02)) {

            int iCount = 0;
            for (JT_SkKihon entity : exDBResults) {

                boolean result1 =
                    (!entity.getSyono().equals(P_SYONO_003)) &&
                    (!entity.getSkno().equals(P_SKNO_003));

                assertTrue(result1);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("JT_SkKihon");
        bT_SkipKey2.setRecoveryfilterid("Si001");
        bT_SkipKey2.setRecoveryfilterkey1(P_SYONO_004);
        bT_SkipKey2.setRecoveryfilterkey2(P_SKNO_004);

        siharaiDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(P_KAKUTYOUJOBCD_02, C_SeikyuuSyubetu.KYH, C_SeikyuuSyubetu.SB, P_SIBOUKARITRKYMD_02)) {

            int iCount = 0;
            for (JT_SkKihon entity : exDBResults) {

                boolean result1 =
                    (!entity.getSyono().equals(P_SYONO_003)) &&
                    (!entity.getSkno().equals(P_SKNO_003));

                boolean result2 =
                    (!entity.getSyono().equals(P_SYONO_004)) &&
                    (!entity.getSkno().equals(P_SKNO_004));

                assertTrue(result1 && result2);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
