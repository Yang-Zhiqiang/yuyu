package yuyu.def.zdb.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.ZT_IjiToukeiIdouInfoTr;
import yuyu.def.db.meta.QZT_IjiToukeiIdouInfoTr;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 死亡統計異動情報取込<br />
 * 医事統計異動情報テーブル（取）エンティティリスト（大量）取得　拡張ジョブコードのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class ZdbDomManagerTest_getIjiToukeiIdouInfoTrsByKakutyoujobcd {

    @Inject
    ZdbDomManager zdbDomManager;
    @Inject
    BizDomManager bizDomManager;

    static String P_JOB_CD_01 = "JCD01";
    static String P_JOB_CD_02 = "RGAX";
    static String P_FILTER_ID = "Bz004";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        ZdbDomManager zdbDomManager = SWAKInjector.getInstance(ZdbDomManager.class);

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_01)){

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }

        ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr1 = new ZT_IjiToukeiIdouInfoTr("11807111118", new Integer(13));

        zdbDomManager.insert(zT_IjiToukeiIdouInfoTr1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        QZT_IjiToukeiIdouInfoTr qZT_IjiToukeiIdouInfoTr = new QZT_IjiToukeiIdouInfoTr("qZT_IjiToukeiIdouInfoTr");
        String jpql1 = $DELETE_FROM(qZT_IjiToukeiIdouInfoTr) ;
        em.createJPQL(jpql1).bind(qZT_IjiToukeiIdouInfoTr).executeUpdate();

        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void normal10() {

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_01)){

            Iterator<ZT_IjiToukeiIdouInfoTr> iter = exDBResEntity.iterator();
            ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr = null;
            int iCount = 0;
            while (iter.hasNext()) {

                zT_IjiToukeiIdouInfoTr = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("11807111118", zT_IjiToukeiIdouInfoTr.getZtrsyono());
                    Assert.assertEquals(new Integer(13), zT_IjiToukeiIdouInfoTr.getZtrkykmfksnctr());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }


    @Test
    @TestOrder(11)
    @Transactional
    public void normal11() {


        ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr2 = new ZT_IjiToukeiIdouInfoTr("11807111129", new Integer(13));

        zdbDomManager.insert(zT_IjiToukeiIdouInfoTr2);

        ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr3 = new ZT_IjiToukeiIdouInfoTr("11807111130", new Integer(13));

        zdbDomManager.insert(zT_IjiToukeiIdouInfoTr3);
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_01)){

            Iterator<ZT_IjiToukeiIdouInfoTr> iter = exDBResEntity.iterator();
            ZT_IjiToukeiIdouInfoTr zT_IjiToukeiIdouInfoTr = null;
            int iCount = 0;
            Map<String,String> map = new HashMap<String,String>();
            map.put($("11807111118",new Integer(13)), "1");
            map.put($("11807111129",new Integer(13)), "1");
            map.put($("11807111130",new Integer(13)), "1");
            while (iter.hasNext()) {

                zT_IjiToukeiIdouInfoTr = iter.next();
                iCount++;
                if (1 == iCount) {

                    map.remove($(zT_IjiToukeiIdouInfoTr.getZtrsyono(),zT_IjiToukeiIdouInfoTr.getZtrkykmfksnctr()));
                    continue;
                }

                if (2 == iCount) {

                    map.remove($(zT_IjiToukeiIdouInfoTr.getZtrsyono(),zT_IjiToukeiIdouInfoTr.getZtrkykmfksnctr()));
                    continue;
                }

                if (3 == iCount) {

                    map.remove($(zT_IjiToukeiIdouInfoTr.getZtrsyono(),zT_IjiToukeiIdouInfoTr.getZtrkykmfksnctr()));
                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testSkippedFilter10() {

        bizDomManager.delete(bizDomManager.getAllRecoveryFilter());
        bizDomManager.delete(bizDomManager.getAllSkipKey());
    }

    @Test
    @TestOrder(31)
    public void testSkippedFilter11(){

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_02)){

            Iterator<ZT_IjiToukeiIdouInfoTr> iter = exDBResEntity.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;

            }
            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(32)
    @Transactional
    public void testSkippedFilter12(){

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter(P_FILTER_ID);
        bM_RecoveryFilter.setRecoveryfilternm("証券番号フィルタ（取）");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("ztrsyono");
        zdbDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey1.setTableid("ZT_IjiToukeiIdouInfoTr");
        bT_SkipKey1.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey1.setRecoveryfilterkey1("11807111118");
        zdbDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(40)
    public void testSkippedFilter20(){

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_02)){

            int iCount = 0;
            for (ZT_IjiToukeiIdouInfoTr entity : exDBResEntity) {

                Assert.assertNotEquals("11807111118", entity.getZtrsyono());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(41)
    @Transactional
    public void testSkippedFilter21(){

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd(P_JOB_CD_02);
        bT_SkipKey2.setTableid("ZT_IjiToukeiIdouInfoTr");
        bT_SkipKey2.setRecoveryfilterid(P_FILTER_ID);
        bT_SkipKey2.setRecoveryfilterkey1("11807111129");
        zdbDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter3(){

        try(ExDBResults<ZT_IjiToukeiIdouInfoTr> exDBResEntity = zdbDomManager.getIjiToukeiIdouInfoTrsByKakutyoujobcd(P_JOB_CD_02)){

            int iCount = 0;
            for (ZT_IjiToukeiIdouInfoTr entity : exDBResEntity) {

                Assert.assertNotEquals("11807111118", entity.getZtrsyono());
                Assert.assertNotEquals("11807111129", entity.getZtrsyono());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
