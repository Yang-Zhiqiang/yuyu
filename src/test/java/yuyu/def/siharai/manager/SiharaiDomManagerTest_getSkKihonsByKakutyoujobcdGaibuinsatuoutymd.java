package yuyu.def.siharai.manager;

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
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金DNP連動TBL作成<br />
 * 請求基本テーブルエンティティリスト(大量)取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsByKakutyoujobcdGaibuinsatuoutymd {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160811))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("10001", "11807111118");
        skKihon1.setGaibuinsatuoutymd(BizDate.valueOf(20160811));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("10002", "11807111118");
        skKihon2.setGaibuinsatuoutymd(BizDate.valueOf(20160812));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("10003", "11807111130");
        skKihon3.setGaibuinsatuoutymd(BizDate.valueOf(20160813));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("10004", "11807111129");
        skKihon4.setGaibuinsatuoutymd(BizDate.valueOf(20160813));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("10005", "11807111118");
        skKihon5.setGaibuinsatuoutymd(BizDate.valueOf(20160813));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("10004", "11807111118");
        skKihon6.setGaibuinsatuoutymd(BizDate.valueOf(20160813));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("10003", "11807111118");
        skKihon7.setGaibuinsatuoutymd(BizDate.valueOf(20160813));

        siharaiDomManager.insert(skKihon7);
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
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20150811))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160811))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;

                Assert.assertEquals("10001", jT_SkKihon.getSkno());
                Assert.assertEquals("11807111118", jT_SkKihon.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160813))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();
                iCount++;
                if (1 == iCount) {

                    Assert.assertEquals("10003", jT_SkKihon.getSkno());
                    Assert.assertEquals("11807111118", jT_SkKihon.getSyono());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("10004", jT_SkKihon.getSkno());
                    Assert.assertEquals("11807111118", jT_SkKihon.getSyono());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("10005", jT_SkKihon.getSkno());
                    Assert.assertEquals("11807111118", jT_SkKihon.getSyono());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("10004", jT_SkKihon.getSkno());
                    Assert.assertEquals("11807111129", jT_SkKihon.getSyono());

                    continue;
                }

                if (5 == iCount) {

                    Assert.assertEquals("10003", jT_SkKihon.getSkno());
                    Assert.assertEquals("11807111130", jT_SkKihon.getSyono());

                    continue;
                }
            }

            Assert.assertEquals(5, iCount);
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

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160813))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(5, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Si001");
        recoveryFilter1.setRecoveryfilternm("請求基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");
        recoveryFilter1.setRecoveryfilterkeykmid2("skno");

        siharaiDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RCA0");
        skipKey1.setTableid("JT_SkKihon");
        skipKey1.setRecoveryfilterid("Si001");
        skipKey1.setRecoveryfilterkey1("11807111130");
        skipKey1.setRecoveryfilterkey2("10003");

        siharaiDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160813))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("10003"))
                    && (jT_SkKihon.getSyono().equals("11807111130"));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A02");
        skipKey2.setKakutyoujobcd("RCA0");
        skipKey2.setTableid("JT_SkKihon");
        skipKey2.setRecoveryfilterid("Si001");
        skipKey2.setRecoveryfilterkey1("11807111129");
        skipKey2.setRecoveryfilterkey2("10004");

        siharaiDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBResults<JT_SkKihon> exDBResults = siharaiDomManager
            .getSkKihonsByKakutyoujobcdGaibuinsatuoutymd("RCA0", BizDate.valueOf(20160813))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDBResults.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                jT_SkKihon = iter.next();

                boolean result1 = (jT_SkKihon.getSkno().equals("10003"))
                    && (jT_SkKihon.getSyono().equals("11807111130"));

                boolean result2 = (jT_SkKihon.getSkno().equals("10004"))
                    && (jT_SkKihon.getSyono().equals("11807111129"));

                assertFalse(result1 || result2);

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
