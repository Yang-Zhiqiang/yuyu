package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * SMBC進捗管理データ作成<br />
 * SMBC新規進捗管理対象データテーブルエンティティリスト(大量)取得のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcSnkSntKnrTsDatasByKakutyoujobcd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBA0";
    static String P_FILTER_ID = "Sk001";
    static Integer P_RENNO_01 = new Integer(1);
    static Integer P_RENNO_02 = new Integer(2);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_01)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111118");
        syoriCTL2.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL2.setMosnrkumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111118");
        syoriCTL3.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL3.setMosnrkumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSyono("11807111118");
        syoriCTL4.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL4.setMosnrkumu(C_UmuKbn.NONE);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSyono("11807111118");
        syoriCTL5.setSkeijimukbn(C_SkeijimuKbn.TIGINSINKIN);
        syoriCTL5.setMosnrkumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSyono("11807111129");
        syoriCTL6.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL6.setMosnrkumu(C_UmuKbn.ARI);

        syoriCTL1.createMosKihon();
        syoriCTL3.createMosKihon();
        syoriCTL4.createMosKihon();
        syoriCTL5.createMosKihon();
        syoriCTL6.createMosKihon();

        HT_MosDairiten hT_MosDairiten1 = syoriCTL2.createMosDairiten();
        hT_MosDairiten1.setRenno(P_RENNO_01);

        HT_MosDairiten hT_MosDairiten2 = syoriCTL3.createMosDairiten();
        hT_MosDairiten2.setRenno(P_RENNO_02);

        HT_MosDairiten hT_MosDairiten3 = syoriCTL4.createMosDairiten();
        hT_MosDairiten3.setRenno(P_RENNO_01);

        HT_MosDairiten hT_MosDairiten4 = syoriCTL5.createMosDairiten();
        hT_MosDairiten4.setRenno(P_RENNO_01);

        HT_MosDairiten hT_MosDairiten5 = syoriCTL6.createMosDairiten();
        hT_MosDairiten5.setRenno(P_RENNO_01);

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki = new HT_SmbcStyKanriSsRireki();
        hT_SmbcStyKanriSsRireki.setSyono("11807111129");

        sinkeiyakuDomManager.insert(syoriCTL1);
        sinkeiyakuDomManager.insert(syoriCTL2);
        sinkeiyakuDomManager.insert(syoriCTL3);
        sinkeiyakuDomManager.insert(syoriCTL4);
        sinkeiyakuDomManager.insert(syoriCTL5);
        sinkeiyakuDomManager.insert(syoriCTL6);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanriSsRireki);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_01)){
            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSyono("11807111118");
        syoriCTL7.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL7.setMosnrkumu(C_UmuKbn.ARI);

        syoriCTL7.createMosKihon();

        HT_MosDairiten hT_MosDairiten6 = syoriCTL7.createMosDairiten();
        hT_MosDairiten6.setRenno(P_RENNO_01);

        sinkeiyakuDomManager.insert(syoriCTL7);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_01)){

            int iCount = 0;
            for (HT_SyoriCTL syoriCTL : exDBResults) {

                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("791112287", syoriCTL.getMosno());
                    Assert.assertEquals("11807111118", syoriCTL.getSyono());
                    Assert.assertEquals(C_SkeijimuKbn.SMBC, syoriCTL.getSkeijimukbn());
                    Assert.assertEquals(C_UmuKbn.ARI, syoriCTL.getMosnrkumu());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setSyono("11807111118");
        syoriCTL8.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL8.setMosnrkumu(C_UmuKbn.ARI);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("791112303");
        syoriCTL9.setSyono("11807111118");
        syoriCTL9.setSkeijimukbn(C_SkeijimuKbn.SMBC);
        syoriCTL9.setMosnrkumu(C_UmuKbn.ARI);

        syoriCTL8.createMosKihon();
        syoriCTL9.createMosKihon();

        HT_MosDairiten hT_MosDairiten7 = syoriCTL8.createMosDairiten();
        hT_MosDairiten7.setRenno(P_RENNO_01);

        HT_MosDairiten hT_MosDairiten8 = syoriCTL9.createMosDairiten();
        hT_MosDairiten8.setRenno(P_RENNO_01);

        sinkeiyakuDomManager.insert(syoriCTL8);
        sinkeiyakuDomManager.insert(syoriCTL9);
    }

    @Test
    @TestOrder(31)
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112287","11807111118",C_SkeijimuKbn.SMBC,C_UmuKbn.ARI), "1");
        datamap.put($("791112295","11807111118",C_SkeijimuKbn.SMBC,C_UmuKbn.ARI), "1");
        datamap.put($("791112303","11807111118",C_SkeijimuKbn.SMBC,C_UmuKbn.ARI), "1");

        try(ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_01)) {

            int iCount = 0;

            for (HT_SyoriCTL syoriCTL : exDBResults) {

                datamap.remove($(
                    syoriCTL.getMosno(),
                    syoriCTL.getSyono(),
                    syoriCTL.getSkeijimukbn(),
                    syoriCTL.getMosnrkumu()));

                iCount++;
            }
            Assert.assertEquals(3, iCount);
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

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_02)) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            int iCount = 0;
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
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("申込番号フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("mosno");
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("HT_SyoriCTL");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1("791112287");
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_02)) {

            int iCount = 0;
            for (HT_SyoriCTL hT_SyoriCTL : exDBResults) {

                assertNotEquals("791112287", hT_SyoriCTL.getMosno());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("HT_SyoriCTL");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1("791112295");
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcSnkSntKnrTsDatasByKakutyoujobcd(P_JOB_CD_02)) {

            int iCount = 0;
            for (HT_SyoriCTL hT_SyoriCTL : exDBResults) {

                assertNotEquals("791112287", hT_SyoriCTL.getMosno());
                assertNotEquals("791112295", hT_SyoriCTL.getMosno());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
