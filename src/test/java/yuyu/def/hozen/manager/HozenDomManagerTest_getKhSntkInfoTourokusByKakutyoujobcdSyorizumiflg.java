package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTouroku = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.MISYORI)) {

            Assert.assertFalse(khSntkInfoTouroku.iterator().hasNext());
        }

        IT_KhSntkInfoTouroku khSntkInfoTouroku1 = new IT_KhSntkInfoTouroku("11807111129", 2);
        khSntkInfoTouroku1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        hozenDomManager.insert(khSntkInfoTouroku1);

        IT_KhSntkInfoTouroku khSntkInfoTouroku2 = new IT_KhSntkInfoTouroku("11807111130", 3);
        khSntkInfoTouroku2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        hozenDomManager.insert(khSntkInfoTouroku2);

        IT_KhSntkInfoTouroku khSntkInfoTouroku3 = new IT_KhSntkInfoTouroku("11807111141", 4);
        khSntkInfoTouroku3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        hozenDomManager.insert(khSntkInfoTouroku3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhSntkInfoTouroku());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult10(){

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.SYORIZUMI)) {

            Assert.assertFalse(khSntkInfoTourokus.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void noResult20(){
        IT_KhSntkInfoTouroku khSntkInfoTouroku1 = new IT_KhSntkInfoTouroku("11807111118", 1);
        khSntkInfoTouroku1.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        hozenDomManager.insert(khSntkInfoTouroku1);
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {


        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.SYORIZUMI)) {

            int iCount = 0;
            Iterator<IT_KhSntkInfoTouroku> iter = khSntkInfoTourokus.iterator();
            IT_KhSntkInfoTouroku khSntkInfoTouroku = null;
            while (iter.hasNext()) {

                khSntkInfoTouroku = iter.next();
                iCount++;

                Assert.assertEquals("11807111118", khSntkInfoTouroku.getSyono());
                Assert.assertEquals(1, khSntkInfoTouroku.getRenno().intValue());
            }

            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111129","2"), "1");
        datamap.put($("11807111130","3"), "2");
        datamap.put($("11807111141","4"), "3");


        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.MISYORI)) {

            Iterator<IT_KhSntkInfoTouroku> iter = khSntkInfoTourokus.iterator();
            IT_KhSntkInfoTouroku khSntkInfoTouroku = null;
            while (iter.hasNext()) {

                khSntkInfoTouroku = iter.next();

                datamap.remove($(khSntkInfoTouroku.getSyono(),khSntkInfoTouroku.getRenno().intValue()));

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
    public void testSkippedFilter40() {

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            Iterator<IT_KhSntkInfoTouroku> iter = khSntkInfoTourokus.iterator();
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

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RG9I");
        skipKey1.setTableid("IT_KhSntkInfoTouroku");
        skipKey1.setRecoveryfilterid("Bz002");
        skipKey1.setRecoveryfilterkey1("11807111129");
        skipKey1.setRecoveryfilterkey2("2");

        hozenDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51() {

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (IT_KhSntkInfoTouroku khSntkInfoTouroku : khSntkInfoTourokus) {

                Assert.assertNotEquals("11807111129", khSntkInfoTouroku.getSyono());
                Assert.assertNotEquals(2, khSntkInfoTouroku.getRenno().intValue());

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
        skipKey2.setKakutyoujobcd("RG9I");
        skipKey2.setTableid("IT_KhSntkInfoTouroku");
        skipKey2.setRecoveryfilterid("Bz002");
        skipKey2.setRecoveryfilterkey1("11807111130");
        skipKey2.setRecoveryfilterkey2("3");

        hozenDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61() {

        try (ExDBUpdatableResults<IT_KhSntkInfoTouroku> khSntkInfoTourokus = hozenDomManager
            .getKhSntkInfoTourokusByKakutyoujobcdSyorizumiflg("RG9I", C_Syorizumiflg.MISYORI)) {

            int iCount = 0;
            for (IT_KhSntkInfoTouroku khSntkInfoTouroku : khSntkInfoTourokus) {

                Assert.assertNotEquals("11807111129", khSntkInfoTouroku.getSyono());
                Assert.assertNotEquals("11807111130", khSntkInfoTouroku.getSyono());
                Assert.assertNotEquals(2, khSntkInfoTouroku.getRenno().intValue());
                Assert.assertNotEquals(3, khSntkInfoTouroku.getRenno().intValue());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
