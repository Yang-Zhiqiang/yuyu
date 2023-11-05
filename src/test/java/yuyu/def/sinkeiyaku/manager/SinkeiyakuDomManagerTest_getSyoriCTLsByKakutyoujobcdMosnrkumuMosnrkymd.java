package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 支社統計情報作成<br />
 * 処理コントロールテーブルエンティティリスト(大量)取得　申込書入力日指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUCHOJOBCD_01 = "JCD01";
    static String P_KAKUCHOJOBCD_02 = "RBA0";
    static BizDate P_MOSNRKUMU_01 = BizDate.valueOf(20160321);
    static BizDate P_MOSNRKUMU_02 = BizDate.valueOf(20160421);
    static BizDate P_MOSNRKUMU_03 = BizDate.valueOf(20170421);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_01, P_MOSNRKUMU_02)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL1.setMosnrkymd(BizDate.valueOf(20160421));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL2.setMosnrkymd(BizDate.valueOf(20160321));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL3.setMosnrkymd(BizDate.valueOf(20160322));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setMosnrkumu(C_UmuKbn.ARI);
        syoriCTL4.setMosnrkymd(BizDate.valueOf(20160320));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setMosnrkumu(C_UmuKbn.NONE);
        syoriCTL5.setMosnrkymd(BizDate.valueOf(20160321));

        sinkeiyakuDomManager.insert(syoriCTL5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_01, P_MOSNRKUMU_03)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_01, P_MOSNRKUMU_02)) {

            int iCount = 0;
            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            while (iter.hasNext()) {

                hT_SyoriCTL = iter.next();
                iCount++;

                Assert.assertEquals("791112220", hT_SyoriCTL.getMosno());
                Assert.assertEquals(C_UmuKbn.ARI, hT_SyoriCTL.getMosnrkumu());
                Assert.assertEquals(BizDate.valueOf(20160421), hT_SyoriCTL.getMosnrkymd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112220",C_UmuKbn.ARI,BizDate.valueOf(20160421)), "1");
        datamap.put($("791112238",C_UmuKbn.ARI,BizDate.valueOf(20160321)), "1");
        datamap.put($("791112246",C_UmuKbn.ARI,BizDate.valueOf(20160322)), "1");

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_01, P_MOSNRKUMU_01)) {

            int iCount = 0;
            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            while (iter.hasNext()) {

                hT_SyoriCTL = iter.next();
                iCount++;

                datamap.remove($(
                    hT_SyoriCTL.getMosno(),
                    hT_SyoriCTL.getMosnrkumu(),
                    hT_SyoriCTL.getMosnrkymd()));

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
    public void testSkippedFilter40(){

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_02, P_MOSNRKUMU_01)) {

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
        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter("Sk001");
        bM_RecoveryFilter.setRecoveryfilternm("申込番号フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("mosno");
        sinkeiyakuDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey1.setTableid("HT_SyoriCTL");
        bT_SkipKey1.setRecoveryfilterid("Sk001");
        bT_SkipKey1.setRecoveryfilterkey1("791112220");
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_02, P_MOSNRKUMU_01)) {

            int iCount = 0;
            for (HT_SyoriCTL entity : exDBResults) {

                assertNotEquals("791112220", entity.getMosno());

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
        bT_SkipKey2.setKakutyoujobcd(P_KAKUCHOJOBCD_02);
        bT_SkipKey2.setTableid("HT_SyoriCTL");
        bT_SkipKey2.setRecoveryfilterid("Sk001");
        bT_SkipKey2.setRecoveryfilterkey1("791112238");
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(
            P_KAKUCHOJOBCD_02, P_MOSNRKUMU_01)) {

            int iCount = 0;
            for (HT_SyoriCTL entity : exDBResults) {

                assertNotEquals("791112220", entity.getMosno());
                assertNotEquals("791112238", entity.getMosno());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
