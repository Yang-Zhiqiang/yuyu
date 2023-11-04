package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import yuyu.def.db.entity.BV_SiharaiTyousyo;
import yuyu.def.db.entity.IT_KhTyousyo;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSiharaiTyousyosByKakutyoujobcdSyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSiharaiTyousyosByKakutyoujobcdSyoriYmd {

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBResults<BV_SiharaiTyousyo> bV_SiharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1",BizDate.valueOf(20161024))) {

            Assert.assertFalse(bV_SiharaiTyousyoExDBResults.iterator().hasNext());
        }

        IT_KhTyousyo khTyousyo1 = new IT_KhTyousyo("11807111118", BizDate.valueOf(20161024), (long) 11111);

        hozenDomManager.insert(khTyousyo1);

        IT_KhTyousyo khTyousyo2 = new IT_KhTyousyo("11807111129", BizDate.valueOf(20161023), (long) 22222);

        hozenDomManager.insert(khTyousyo2);

    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhTyousyo());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BV_SiharaiTyousyo> siharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20171024))) {

            Assert.assertFalse(siharaiTyousyoExDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        try (ExDBResults<BV_SiharaiTyousyo> siharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20161024))) {

            int iCount = 0;
            Iterator<BV_SiharaiTyousyo> iter = siharaiTyousyoExDBResults.iterator();
            BV_SiharaiTyousyo bV_SiharaiTyousyo = null;
            while (iter.hasNext()) {

                bV_SiharaiTyousyo = iter.next();
                iCount++;

                Assert.assertEquals("11807111118", bV_SiharaiTyousyo.getSyono());
                Assert.assertEquals(BizDate.valueOf(20161024), bV_SiharaiTyousyo.getTyouhyouymd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        hozenDomManager.delete(hozenDomManager.getAllKhTyousyo());

        IT_KhTyousyo khTyousyo1 = new IT_KhTyousyo("11807111118", BizDate.valueOf(20161024), (long) 11111);

        hozenDomManager.insert(khTyousyo1);

        IT_KhTyousyo khTyousyo2 = new IT_KhTyousyo("11807111129", BizDate.valueOf(20161024), (long) 33333);

        hozenDomManager.insert(khTyousyo2);

        IT_KhTyousyo khTyousyo3 = new IT_KhTyousyo("11807111130", BizDate.valueOf(20161024), (long) 44444);

        hozenDomManager.insert(khTyousyo3);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BV_SiharaiTyousyo> siharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20161024))) {
            Map<String,String> map = new HashMap<String,String>();
            map.put($("11807111118",BizDate.valueOf(20161024)), "1");
            map.put($("11807111129",BizDate.valueOf(20161024)), "1");
            map.put($("11807111130",BizDate.valueOf(20161024)), "1");


            int iCount = 0;
            Iterator<BV_SiharaiTyousyo> iter = siharaiTyousyoExDBResults.iterator();
            BV_SiharaiTyousyo bV_SiharaiTyousyo = null;
            while (iter.hasNext()) {

                bV_SiharaiTyousyo = iter.next();
                iCount++;

                if (1 == iCount) {
                    assertTrue(map.containsKey($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd())));
                    map.remove($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd()));

                    continue;
                }

                if (2 == iCount) {
                    assertTrue(map.containsKey($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd())));
                    map.remove($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd()));

                    continue;
                }

                if (3 == iCount) {
                    assertTrue(map.containsKey($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd())));
                    map.remove($(bV_SiharaiTyousyo.getSyono(),bV_SiharaiTyousyo.getTyouhyouymd()));

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

        try (ExDBResults<BV_SiharaiTyousyo> bV_SiharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20161024))) {

            int iCount = 0;
            Iterator<BV_SiharaiTyousyo> iter = bV_SiharaiTyousyoExDBResults.iterator();
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(42)
    @Transactional
    public void testSkippedFilter12() {

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz001");
        recoveryFilter1.setRecoveryfilternm("証券番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A0001");
        skipKey1.setKakutyoujobcd("RBG1");
        skipKey1.setTableid("BV_SiharaiTyousyo");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111118");

        hozenDomManager.insert(skipKey1);

    }

    @Test
    @TestOrder(50)
    public void testSkippedFilter20() {

        try (ExDBResults<BV_SiharaiTyousyo> bV_SiharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20161024))) {

            int iCount = 0;
            Iterator<BV_SiharaiTyousyo> iter = bV_SiharaiTyousyoExDBResults.iterator();
            BV_SiharaiTyousyo bV_SiharaiTyousyo = null;
            while (iter.hasNext()) {

                bV_SiharaiTyousyo = iter.next();

                boolean result1 = (bV_SiharaiTyousyo.getSyono().equals("11807111118"));

                assertFalse(result1);

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter21() {

        BT_SkipKey skipKey2 = new BT_SkipKey("A0002");
        skipKey2.setKakutyoujobcd("RBG1");
        skipKey2.setTableid("BV_SiharaiTyousyo");
        skipKey2.setRecoveryfilterid("Bz001");
        skipKey2.setRecoveryfilterkey1("11807111129");

        hozenDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter3() {

        try (ExDBResults<BV_SiharaiTyousyo> bV_SiharaiTyousyoExDBResults =
            bizDomManager.getSiharaiTyousyosByKakutyoujobcdSyoriYmd("RBG1", BizDate.valueOf(20161024))) {

            int iCount = 0;
            Iterator<BV_SiharaiTyousyo> iter = bV_SiharaiTyousyoExDBResults.iterator();
            BV_SiharaiTyousyo bV_SiharaiTyousyo = null;
            while (iter.hasNext()) {

                bV_SiharaiTyousyo = iter.next();

                boolean result1 = (bV_SiharaiTyousyo.getSyono().equals("11807111118"));

                boolean result2 = (bV_SiharaiTyousyo.getSyono().equals("11807111129"));

                assertFalse(result1);

                assertFalse(result2);

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}



