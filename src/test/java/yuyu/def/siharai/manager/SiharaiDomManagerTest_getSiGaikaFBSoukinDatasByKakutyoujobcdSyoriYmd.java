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

import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 支払外貨ＦＢ送金データ取込<br />
 * 支払外貨ＦＢ送金データテーブルエンティティリスト（大量）取得（拡張ジョブコード、処理年月日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("JCD01", BizDate.valueOf(20140808))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData1 = new JT_SiGaikaFBSoukinData("100120023003");
        siGaikaFBSoukinData1.setSyoriYmd(BizDate.valueOf(20140808));

        siharaiDomManager.insert(siGaikaFBSoukinData1);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData2 = new JT_SiGaikaFBSoukinData("201111111111");
        siGaikaFBSoukinData2.setSyoriYmd(BizDate.valueOf(20140804));

        siharaiDomManager.insert(siGaikaFBSoukinData2);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData3 = new JT_SiGaikaFBSoukinData("300340046006");
        siGaikaFBSoukinData3.setSyoriYmd(BizDate.valueOf(20160201));

        siharaiDomManager.insert(siGaikaFBSoukinData3);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData4 = new JT_SiGaikaFBSoukinData("200110022003");
        siGaikaFBSoukinData4.setSyoriYmd(BizDate.valueOf(20160201));

        siharaiDomManager.insert(siGaikaFBSoukinData4);

        JT_SiGaikaFBSoukinData siGaikaFBSoukinData5 = new JT_SiGaikaFBSoukinData("400110022003");
        siGaikaFBSoukinData5.setSyoriYmd(BizDate.valueOf(20160201));

        siharaiDomManager.insert(siGaikaFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiGaikaFBSoukinData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("JCD01", BizDate.valueOf(20140404))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("JCD01", BizDate.valueOf(20140808))) {

            int iCount = 0;
            Iterator<JT_SiGaikaFBSoukinData> iter = beans.iterator();
            JT_SiGaikaFBSoukinData siGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                siGaikaFBSoukinData = iter.next();
                iCount++;

                Assert.assertEquals("100120023003", siGaikaFBSoukinData.getFbsoukindatasikibetukey());
                Assert.assertEquals(BizDate.valueOf(20140808), siGaikaFBSoukinData.getSyoriYmd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("300340046006",BizDate.valueOf(20160201)), "1");
        datamap.put($("200110022003",BizDate.valueOf(20160201)), "1");
        datamap.put($("400110022003",BizDate.valueOf(20160201)), "1");

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("JCD01", BizDate.valueOf(20160201))) {

            Iterator<JT_SiGaikaFBSoukinData> iter = beans.iterator();
            JT_SiGaikaFBSoukinData siGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                siGaikaFBSoukinData = iter.next();

                datamap.remove($(
                    siGaikaFBSoukinData.getFbsoukindatasikibetukey(),
                    siGaikaFBSoukinData.getSyoriYmd()));
            }
            Assert.assertTrue(datamap.isEmpty());
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

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("RGEC", BizDate.valueOf(20160201)))  {

            int iCount = 0;
            Iterator<JT_SiGaikaFBSoukinData> iter = beans.iterator();
            JT_SiGaikaFBSoukinData jT_SiGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                jT_SiGaikaFBSoukinData = iter.next();
                iCount++;
            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz107");
        recoveryFilter1.setRecoveryfilternm("ＦＢ送金データフィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("fbsoukindatasikibetukey");

        siharaiDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RGEC");
        skipKey1.setTableid("JT_SiGaikaFBSoukinData");
        skipKey1.setRecoveryfilterid("Bz107");
        skipKey1.setRecoveryfilterkey1("300340046006");

        siharaiDomManager.insert(skipKey1);
    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("RGEC", BizDate.valueOf(20160201)))  {

            int iCount = 0;
            Iterator<JT_SiGaikaFBSoukinData> iter = beans.iterator();
            JT_SiGaikaFBSoukinData jT_SiGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                jT_SiGaikaFBSoukinData = iter.next();
                assertNotEquals(jT_SiGaikaFBSoukinData.getFbsoukindatasikibetukey(), "300340046006");
                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A02");
        skipKey2.setKakutyoujobcd("RGEC");
        skipKey2.setTableid("JT_SiGaikaFBSoukinData");
        skipKey2.setRecoveryfilterid("Bz107");
        skipKey2.setRecoveryfilterkey1("200110022003");

        siharaiDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try (ExDBResults<JT_SiGaikaFBSoukinData> beans =
            siharaiDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd("RGEC", BizDate.valueOf(20160201)))  {

            int iCount = 0;
            Iterator<JT_SiGaikaFBSoukinData> iter = beans.iterator();
            JT_SiGaikaFBSoukinData jT_SiGaikaFBSoukinData = null;
            while (iter.hasNext()) {

                jT_SiGaikaFBSoukinData = iter.next();
                assertNotEquals(jT_SiGaikaFBSoukinData.getFbsoukindatasikibetukey(), "300340046006");
                assertNotEquals(jT_SiGaikaFBSoukinData.getFbsoukindatasikibetukey(), "200110022003");
                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }
}
