package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
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
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 本社統計情報作成<br />
 * 処理コントロールテーブルエンティティリスト（大量）取得　申込月度（自）かつ申込月度（至）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdMosym {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGH0";

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_01, BizDateYM.valueOf(201605), BizDateYM.valueOf(201605))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setMosym(BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setMosym(BizDateYM.valueOf(201606));

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setMosym(BizDateYM.valueOf(201607));

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setMosym(BizDateYM.valueOf(201608));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setMosym(BizDateYM.valueOf(201609));

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setMosym(BizDateYM.valueOf(201610));

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setMosnrkumu(C_UmuKbn.ARI);

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setMosym(BizDateYM.valueOf(201611));

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setMosnrkumu(C_UmuKbn.ARI);

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("791112303");
        syoriCTL9.setMosnrkumu(C_UmuKbn.NONE);

        HT_MosKihon mosKihon8 = syoriCTL9.createMosKihon();
        mosKihon8.setMosym(BizDateYM.valueOf(201610));

        sinkeiyakuDomManager.insert(syoriCTL9);
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

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_01, BizDateYM.valueOf(201602), BizDateYM.valueOf(201602))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_01, BizDateYM.valueOf(201605), BizDateYM.valueOf(201605))) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                hT_SyoriCTL=iter.next();

                Assert.assertEquals("791112220", hT_SyoriCTL.getMosno());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112246"), "1");
        datamap.put($("791112253"), "1");
        datamap.put($("791112261"), "1");
        datamap.put($("791112279"), "1");

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_01, BizDateYM.valueOf(201607), BizDateYM.valueOf(201610))) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            int iCount = 0;
            while (iter.hasNext()) {

                iCount++;
                hT_SyoriCTL = iter.next();

                datamap.remove($(
                    hT_SyoriCTL.getMosno()));
            }

            Assert.assertEquals(4, iCount);
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

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_02, BizDateYM.valueOf(201607), BizDateYM.valueOf(201610))) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            int iCount = 0;
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
        BM_RecoveryFilter filter = new BM_RecoveryFilter("Sk001");
        filter.setRecoveryfilterkeykmid1("mosno");
        filter.setRecoveryfilternm("申込番号フィルタ");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setRecoveryfilterid("Sk001");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterkey1("791112253");
        key3.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key3);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_02, BizDateYM.valueOf(201607), BizDateYM.valueOf(201610))) {

            int iCount = 0;
            for(HT_SyoriCTL hT_SyoriCTL : exDBResults) {

                Assert.assertNotEquals(hT_SyoriCTL.getMosno(), "791112253");

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setRecoveryfilterid("Sk001");
        key1.setKakutyoujobcd("RGH0");
        key1.setRecoveryfilterkey1("791112261");
        key1.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key1);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosym(P_JOB_CD_02, BizDateYM.valueOf(201607), BizDateYM.valueOf(201610))) {

            int iCount = 0;
            for(HT_SyoriCTL hT_SyoriCTL : exDBResults) {

                Assert.assertNotEquals(hT_SyoriCTL.getMosno(), "791112253");
                Assert.assertNotEquals(hT_SyoriCTL.getMosno(), "791112261");

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
