package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 医査統計作成<br />
 * 処理コントロールテーブルエンティティリスト（大量）取得　決定結果コード複数のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByKakutyoujobcdMosymKetkekkacds {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RBA0";
    static BizDateYM P_MOSYM_01 = BizDateYM.valueOf("201601");
    static BizDateYM P_MOSYM_02 = BizDateYM.valueOf("201603");
    static BizDateYM P_MOSYM_03 = BizDateYM.valueOf("201604");

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_01, P_MOSYM_02)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112261");

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setMosym(P_MOSYM_02);

        HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei1.setDakuhiktrenno(61);
        dakuhiKettei1.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        HT_DakuhiKettei dakuhiKettei2 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei2.setDakuhiktrenno(60);
        dakuhiKettei2.setKetkekkacd(C_Ketkekkacd.GENKAITAI_SYOUDAKU);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112253");

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setMosym(P_MOSYM_03);

        HT_DakuhiKettei dakuhiKettei3 = syoriCTL2.createDakuhiKettei();
        dakuhiKettei3.setDakuhiktrenno(61);
        dakuhiKettei3.setKetkekkacd(C_Ketkekkacd.GENKAITAI_SYOUDAKU);

        HT_DakuhiKettei dakuhiKettei4 = syoriCTL2.createDakuhiKettei();
        dakuhiKettei4.setDakuhiktrenno(32);
        dakuhiKettei4.setKetkekkacd(C_Ketkekkacd.GENKAITAI_SYOUDAKU);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setMosym(P_MOSYM_03);

        HT_DakuhiKettei dakuhiKettei5 = syoriCTL3.createDakuhiKettei();
        dakuhiKettei5.setDakuhiktrenno(62);
        dakuhiKettei5.setKetkekkacd(C_Ketkekkacd.MIAWASE);

        HT_DakuhiKettei dakuhiKettei6 = syoriCTL3.createDakuhiKettei();
        dakuhiKettei6.setDakuhiktrenno(61);
        dakuhiKettei6.setKetkekkacd(C_Ketkekkacd.MIAWASE);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112238");

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setMosym(P_MOSYM_03);

        HT_DakuhiKettei dakuhiKettei7 = syoriCTL4.createDakuhiKettei();
        dakuhiKettei7.setDakuhiktrenno(63);
        dakuhiKettei7.setKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);

        HT_DakuhiKettei dakuhiKettei8 = syoriCTL4.createDakuhiKettei();
        dakuhiKettei8.setDakuhiktrenno(59);
        dakuhiKettei8.setKetkekkacd(C_Ketkekkacd.ENKI_SIJINASI);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112220");

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setMosym(P_MOSYM_03);

        HT_DakuhiKettei dakuhiKettei9 = syoriCTL5.createDakuhiKettei();
        dakuhiKettei9.setDakuhiktrenno(61);
        dakuhiKettei9.setKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        HT_DakuhiKettei dakuhiKettei10 = syoriCTL5.createDakuhiKettei();
        dakuhiKettei10.setDakuhiktrenno(10);
        dakuhiKettei10.setKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();
        mosKihon6.setMosym(BizDateYM.valueOf("201602"));

        HT_DakuhiKettei dakuhiKettei11 = syoriCTL6.createDakuhiKettei();
        dakuhiKettei11.setDakuhiktrenno(61);
        dakuhiKettei11.setKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");

        HT_MosKihon mosKihon7 = syoriCTL7.createMosKihon();
        mosKihon7.setMosym(P_MOSYM_03);

        HT_DakuhiKettei dakuhiKettei12 = syoriCTL7.createDakuhiKettei();
        dakuhiKettei12.setDakuhiktrenno(61);
        dakuhiKettei12.setKetkekkacd(C_Ketkekkacd.HUBI_MATI);

        HT_DakuhiKettei dakuhiKettei13 = syoriCTL7.createDakuhiKettei();
        dakuhiKettei13.setDakuhiktrenno(60);
        dakuhiKettei13.setKetkekkacd(C_Ketkekkacd.ENKI_SUUNENGOSAISIN);

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");

        sinkeiyakuDomManager.insert(syoriCTL8);
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
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_01, P_MOSYM_01)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_01, P_MOSYM_02)) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                hT_SyoriCTL=iter.next();

                Assert.assertEquals("791112261", hT_SyoriCTL.getMosno());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_01, P_MOSYM_03)) {

            Iterator<HT_SyoriCTL> iter = exDBResults.iterator();
            HT_SyoriCTL hT_SyoriCTL = null;
            int iCount = 0;
            while (iter.hasNext()) {

                iCount++;
                hT_SyoriCTL = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("791112220", hT_SyoriCTL.getMosno());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("791112238", hT_SyoriCTL.getMosno());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("791112246", hT_SyoriCTL.getMosno());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("791112253", hT_SyoriCTL.getMosno());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
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
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_02, P_MOSYM_03)) {

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
        filter.setRecoveryfilternm("申込番号フィルタ");
        filter.setRecoveryfilterkeykmid1("mosno");
        sinkeiyakuDomManager.insert(filter);

        BT_SkipKey key1 = new BT_SkipKey("900001");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Sk001");
        key1.setRecoveryfilterkey1("791112253");
        key1.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_02, P_MOSYM_03)) {

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
        BT_SkipKey key1 = new BT_SkipKey("900002");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Sk001");
        key1.setRecoveryfilterkey1("791112246");
        key1.setTableid("HT_SyoriCTL");
        sinkeiyakuDomManager.insert(key1);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61() {

        try (ExDBResults<HT_SyoriCTL> exDBResults =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(P_JOB_CD_02, P_MOSYM_03)) {

            int iCount = 0;
            for(HT_SyoriCTL hT_SyoriCTL : exDBResults) {

                Assert.assertNotEquals(hT_SyoriCTL.getMosno(), "791112253");
                Assert.assertNotEquals(hT_SyoriCTL.getMosno(), "791112246");

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }
}
