package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金選択情報登録テーブルのテストクラス
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg {

    @Inject
    SiharaiDomManager siharaiDomManager;
    static String P_KAKUCHOJOBCD_01 = "RG9J";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        JT_SiSentakuInfoTouroku siSentakuInfoTouroku1 = new JT_SiSentakuInfoTouroku("11807111118", 1);
        siSentakuInfoTouroku1.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        siharaiDomManager.insert(siSentakuInfoTouroku1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiSentakuInfoTouroku());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1(){


        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        siharaiDomManager.delete(siharaiDomManager.getAllSiSentakuInfoTouroku());

        JT_SiSentakuInfoTouroku siSentakuInfoTouroku1 = new JT_SiSentakuInfoTouroku("11807111118", 1);
        siSentakuInfoTouroku1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        siharaiDomManager.insert(siSentakuInfoTouroku1);

        JT_SiSentakuInfoTouroku siSentakuInfoTouroku2 = new JT_SiSentakuInfoTouroku("11807111129", 2);
        siSentakuInfoTouroku2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        siharaiDomManager.insert(siSentakuInfoTouroku2);

        JT_SiSentakuInfoTouroku siSentakuInfoTouroku3 = new JT_SiSentakuInfoTouroku("11807111130", 3);
        siSentakuInfoTouroku3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        siharaiDomManager.insert(siSentakuInfoTouroku3);

        JT_SiSentakuInfoTouroku siSentakuInfoTouroku4 = new JT_SiSentakuInfoTouroku("11807111118", 2);
        siSentakuInfoTouroku4.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        siharaiDomManager.insert(siSentakuInfoTouroku4);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1(){


        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.SYORIZUMI)) {

            int iCount = 0;
            Iterator<JT_SiSentakuInfoTouroku> iter = beans.iterator();
            JT_SiSentakuInfoTouroku jT_SiSentakuInfoTouroku = null;
            while (iter.hasNext()) {

                jT_SiSentakuInfoTouroku = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", jT_SiSentakuInfoTouroku.getSyono());
                    Assert.assertEquals(2, jT_SiSentakuInfoTouroku.getRenno().intValue());
                    Assert.assertEquals(C_Syorizumiflg.SYORIZUMI, jT_SiSentakuInfoTouroku.getSyorizumiflg());

                    continue;
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111118",1,C_Syorizumiflg.MISYORI), "1");
        datamap.put($("11807111129",2,C_Syorizumiflg.MISYORI), "2");
        datamap.put($("11807111130",3,C_Syorizumiflg.MISYORI), "2");


        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            Iterator<JT_SiSentakuInfoTouroku> iter = beans.iterator();
            JT_SiSentakuInfoTouroku jT_SiSentakuInfoTouroku = null;
            while (iter.hasNext()) {

                jT_SiSentakuInfoTouroku = iter.next();
                datamap.remove($(
                    jT_SiSentakuInfoTouroku.getSyono(),
                    jT_SiSentakuInfoTouroku.getRenno().intValue(),
                    jT_SiSentakuInfoTouroku.getSyorizumiflg()));

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
        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {
            int iCount = 0;
            Iterator<JT_SiSentakuInfoTouroku> iter = beans.iterator();
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
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz002");
        recoveryFilter1.setRecoveryfilternm("証券番号連番フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");
        recoveryFilter1.setRecoveryfilterkeykmid2("renno");

        siharaiDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd(P_KAKUCHOJOBCD_01);
        skipKey1.setTableid("JT_SiSentakuInfoTouroku");
        skipKey1.setRecoveryfilterid("Bz002");
        skipKey1.setRecoveryfilterkey1("11807111130");
        skipKey1.setRecoveryfilterkey2("3");

        siharaiDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (JT_SiSentakuInfoTouroku entity : beans) {

                Assert.assertNotEquals("11807111130", entity.getSyono());
                Assert.assertNotEquals(3, entity.getRenno().intValue());

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
        skipKey2.setKakutyoujobcd(P_KAKUCHOJOBCD_01);
        skipKey2.setTableid("JT_SiSentakuInfoTouroku");
        skipKey2.setRecoveryfilterid("Bz002");
        skipKey2.setRecoveryfilterkey1("11807111129");
        skipKey2.setRecoveryfilterkey2("2");

        siharaiDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        try(ExDBUpdatableResults<JT_SiSentakuInfoTouroku> beans = siharaiDomManager
            .getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(P_KAKUCHOJOBCD_01, C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (JT_SiSentakuInfoTouroku entity : beans) {

                Assert.assertNotEquals("11807111129", entity.getSyono());
                Assert.assertNotEquals(2, entity.getRenno().intValue());
                Assert.assertNotEquals("11807111130", entity.getSyono());
                Assert.assertNotEquals(3, entity.getRenno().intValue());

                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }
}
