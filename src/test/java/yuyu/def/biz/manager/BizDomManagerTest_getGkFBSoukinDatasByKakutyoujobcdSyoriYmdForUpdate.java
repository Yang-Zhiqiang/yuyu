package yuyu.def.biz.manager;

import static org.junit.Assert.*;import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 外貨ＦＢ送金データ取込<br />
 * 外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate {

    @Inject
    BizDomManager bizDomManager;

    private static String P_JOB_CD_02 = "RGEJ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate("JCD01", BizDate.valueOf(20140808))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_GkFBSoukinData gkFBSoukinData1 = new BT_GkFBSoukinData("100120023003");
        gkFBSoukinData1.setSyoriYmd(BizDate.valueOf(20140808));

        bizDomManager.insert(gkFBSoukinData1);

        BT_GkFBSoukinData gkFBSoukinData2 = new BT_GkFBSoukinData("201111111111");
        gkFBSoukinData2.setSyoriYmd(BizDate.valueOf(20140804));

        bizDomManager.insert(gkFBSoukinData2);

        BT_GkFBSoukinData gkFBSoukinData3 = new BT_GkFBSoukinData("300340046006");
        gkFBSoukinData3.setSyoriYmd(BizDate.valueOf(20160201));

        bizDomManager.insert(gkFBSoukinData3);

        BT_GkFBSoukinData gkFBSoukinData4 = new BT_GkFBSoukinData("200110022003");
        gkFBSoukinData4.setSyoriYmd(BizDate.valueOf(20160201));

        bizDomManager.insert(gkFBSoukinData4);

        BT_GkFBSoukinData gkFBSoukinData5 = new BT_GkFBSoukinData("400110022003");
        gkFBSoukinData5.setSyoriYmd(BizDate.valueOf(20160201));

        bizDomManager.insert(gkFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGkFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1(){

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate("JCD01", BizDate.valueOf(20140404))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate("JCD01", BizDate.valueOf(20140808))) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                iCount++;

                Assert.assertEquals("100120023003", bT_GkFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(BizDate.valueOf(20140808), bT_GkFBSoukinData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate("JCD01", BizDate.valueOf(20160201))) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;

            Map<String,String> map = new HashMap<String,String>();
            map.put($("300340046006",BizDate.valueOf(20160201)), "1");
            map.put($("200110022003",BizDate.valueOf(20160201)), "1");
            map.put($("400110022003",BizDate.valueOf(20160201)), "1");

            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                iCount++;

                if (1 == iCount) {

                    assertTrue(map.containsKey($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd())));
                    map.remove($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd()));
                    continue;
                }

                if (2 == iCount) {

                    assertTrue(map.containsKey($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd())));
                    map.remove($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd()));
                    continue;
                }

                if (3 == iCount) {

                    assertTrue(map.containsKey($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd())));
                    map.remove($(bT_GkFBSoukinData.getFbsoukindatasikibetukey(),bT_GkFBSoukinData.getSyoriYmd()));
                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(41)
    @Transactional
    public void testSkippedFilter11() {

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(P_JOB_CD_02, BizDate.valueOf(20160201))) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {

                bT_GkFBSoukinData = iter.next();
                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter filter = new BM_RecoveryFilter("Bz107");
        filter.setRecoveryfilternm("ＦＢ送金データフィルタ");
        filter.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");
        bizDomManager.insert(filter);

        BT_SkipKey key3 = new BT_SkipKey("A03");
        key3.setKakutyoujobcd(P_JOB_CD_02);
        key3.setRecoveryfilterid("Bz107");
        key3.setRecoveryfilterkey1("300340046006");
        key3.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key3);
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter20(){

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(P_JOB_CD_02, BizDate.valueOf(20160201))) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {
                bT_GkFBSoukinData = iter.next();
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "300340046006");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey key1 = new BT_SkipKey("A01");
        key1.setKakutyoujobcd(P_JOB_CD_02);
        key1.setRecoveryfilterid("Bz107");
        key1.setRecoveryfilterkey1("200110022003");
        key1.setTableid("BT_GkFBSoukinData");
        bizDomManager.insert(key1);

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3(){

        try (ExDBUpdatableResults<BT_GkFBSoukinData> beans =
            bizDomManager.getGkFBSoukinDatasByKakutyoujobcdSyoriYmdForUpdate(P_JOB_CD_02, BizDate.valueOf(20160201))) {

            int iCount = 0;
            Iterator<BT_GkFBSoukinData> iter = beans.iterator();
            BT_GkFBSoukinData bT_GkFBSoukinData = null;
            while (iter.hasNext()) {
                bT_GkFBSoukinData = iter.next();
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "300340046006");
                assertNotEquals(bT_GkFBSoukinData.getFbsoukindatasikibetukey(), "200110022003");
                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}
