package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 振込入金処理<br />
 * 振込入金対象ワークテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_KAKUTYOUJOBCD_01 = "JCD01";
    static String P_KAKUTYOUJOBCD_02 = "RBB0";
    static String P_FILTER_ID = "Sk001";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWk =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160411))) {

            Assert.assertFalse(hrkmNyknTaisyouWk.iterator().hasNext());
        }

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk1 = new HW_HrkmNyknTaisyouWk(BizDate.valueOf(20160411), "791112220", 1);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk1);

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk2 = new HW_HrkmNyknTaisyouWk(BizDate.valueOf(20160410), "791112220", 1);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk2);

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk3 = new HW_HrkmNyknTaisyouWk(BizDate.valueOf(20160409), "791112253", 1);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk3);

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk4 = new HW_HrkmNyknTaisyouWk(BizDate.valueOf(20160409), "791112246", 1);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk4);

        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk5 = new HW_HrkmNyknTaisyouWk(BizDate.valueOf(20160409), "791112238", 1);
        sinkeiyakuDomManager.insert(hW_HrkmNyknTaisyouWk5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllHrkmNyknTaisyouWk());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWk =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160311))) {

            Assert.assertFalse(hrkmNyknTaisyouWk.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWk =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160411))) {

            int iCount = 0;
            Iterator<HW_HrkmNyknTaisyouWk> iter = hrkmNyknTaisyouWk.iterator();
            HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk = null;
            while (iter.hasNext()) {

                hW_HrkmNyknTaisyouWk = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf(20160411), hW_HrkmNyknTaisyouWk.getSyoriYmd());
                Assert.assertEquals("791112220", hW_HrkmNyknTaisyouWk.getMosno());
                Assert.assertEquals(1, hW_HrkmNyknTaisyouWk.getRenno().intValue());

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<HW_HrkmNyknTaisyouWk> hrkmNyknTaisyouWk =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_01, BizDate.valueOf(20160409))){

            int iCount = 0;
            Iterator<HW_HrkmNyknTaisyouWk> iter = hrkmNyknTaisyouWk.iterator();
            HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk = null;
            while (iter.hasNext()) {

                hW_HrkmNyknTaisyouWk = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160409), hW_HrkmNyknTaisyouWk.getSyoriYmd());
                    Assert.assertEquals("791112238", hW_HrkmNyknTaisyouWk.getMosno());
                    Assert.assertEquals(1, hW_HrkmNyknTaisyouWk.getRenno().intValue());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160409), hW_HrkmNyknTaisyouWk.getSyoriYmd());
                    Assert.assertEquals("791112246", hW_HrkmNyknTaisyouWk.getMosno());
                    Assert.assertEquals(1, hW_HrkmNyknTaisyouWk.getRenno().intValue());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(BizDate.valueOf(20160409), hW_HrkmNyknTaisyouWk.getSyoriYmd());
                    Assert.assertEquals("791112253", hW_HrkmNyknTaisyouWk.getMosno());
                    Assert.assertEquals(1, hW_HrkmNyknTaisyouWk.getRenno().intValue());

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
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

        try(ExDBResults<HW_HrkmNyknTaisyouWk> exDBResBean =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160409))) {

            Iterator<HW_HrkmNyknTaisyouWk> iter = exDBResBean.iterator();
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
        bT_SkipKey1.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey1.setTableid("HW_HrkmNyknTaisyouWk");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1("791112253");
        sinkeiyakuDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<HW_HrkmNyknTaisyouWk> exDBResBean =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160409))) {

            int iCount = 0;
            for (HW_HrkmNyknTaisyouWk entity : exDBResBean) {

                assertNotEquals(entity.getMosno(), "791112253");

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
        bT_SkipKey2.setKakutyoujobcd(P_KAKUTYOUJOBCD_02);
        bT_SkipKey2.setTableid("HW_HrkmNyknTaisyouWk");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1("791112246");
        sinkeiyakuDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<HW_HrkmNyknTaisyouWk> exDBResBean =
            sinkeiyakuDomManager.getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(P_KAKUTYOUJOBCD_02, BizDate.valueOf(20160409))) {

            int iCount = 0;
            for (HW_HrkmNyknTaisyouWk entity : exDBResBean) {

                assertNotEquals(entity.getMosno(), "791112253");
                assertNotEquals(entity.getMosno(), "791112246");

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
