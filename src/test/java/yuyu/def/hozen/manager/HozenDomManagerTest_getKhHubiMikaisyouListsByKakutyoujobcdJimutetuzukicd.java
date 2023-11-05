package yuyu.def.hozen.manager;

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

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KhHubiMikaisyouList;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000001");

        int iCount = 0;
        for (IT_KhHubiMikaisyouList khHubiMikaisyouList : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KhHubiMikaisyouList khHubiMikaisyouList1 = new IT_KhHubiMikaisyouList("1000000001", "11807111118", C_HassinsakiKbn.BLNK);
        khHubiMikaisyouList1.setLasthubbihasinymd(BizDate.valueOf(20160215));

        hozenDomManager.insert(khHubiMikaisyouList1);

        IT_KhHubiMikaisyouList khHubiMikaisyouList2 = new IT_KhHubiMikaisyouList("1000000002", "11807111118", C_HassinsakiKbn.BLNK);
        khHubiMikaisyouList2.setLasthubbihasinymd(BizDate.valueOf(20160215));

        hozenDomManager.insert(khHubiMikaisyouList2);

        IT_KhHubiMikaisyouList khHubiMikaisyouList3 = new IT_KhHubiMikaisyouList("1000000003", "11807111141", C_HassinsakiKbn.SISYA);
        khHubiMikaisyouList3.setLasthubbihasinymd(BizDate.valueOf(20160216));

        hozenDomManager.insert(khHubiMikaisyouList3);

        IT_KhHubiMikaisyouList khHubiMikaisyouList4 = new IT_KhHubiMikaisyouList("1000000003", "11807111129", C_HassinsakiKbn.SYA);
        khHubiMikaisyouList4.setLasthubbihasinymd(BizDate.valueOf(20160218));

        hozenDomManager.insert(khHubiMikaisyouList4);

        IT_KhHubiMikaisyouList khHubiMikaisyouList5 = new IT_KhHubiMikaisyouList("1000000003", "11807111129", C_HassinsakiKbn.DRTEN);
        khHubiMikaisyouList5.setLasthubbihasinymd(BizDate.valueOf(20160217));

        hozenDomManager.insert(khHubiMikaisyouList5);

        IT_KhHubiMikaisyouList khHubiMikaisyouList6 = new IT_KhHubiMikaisyouList("1000000003", "11807111141", C_HassinsakiKbn.SYA);
        khHubiMikaisyouList6.setLasthubbihasinymd(BizDate.valueOf(20160218));

        hozenDomManager.insert(khHubiMikaisyouList6);

        IT_KhHubiMikaisyouList khHubiMikaisyouList7 = new IT_KhHubiMikaisyouList("1000000003", "11807111130", C_HassinsakiKbn.SYA);
        khHubiMikaisyouList7.setLasthubbihasinymd(BizDate.valueOf(20160218));

        hozenDomManager.insert(khHubiMikaisyouList7);

        IT_KhHubiMikaisyouList khHubiMikaisyouList8 = new IT_KhHubiMikaisyouList("1000000003", "11807111141", C_HassinsakiKbn.DRTEN);
        khHubiMikaisyouList8.setLasthubbihasinymd(BizDate.valueOf(20160218));

        hozenDomManager.insert(khHubiMikaisyouList8);

        IT_KhHubiMikaisyouList khHubiMikaisyouList9 = new IT_KhHubiMikaisyouList("1000000003", "11807111141", C_HassinsakiKbn.KOK);
        khHubiMikaisyouList9.setLasthubbihasinymd(BizDate.valueOf(20160218));

        hozenDomManager.insert(khHubiMikaisyouList9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHubiMikaisyouList());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000004");

        int iCount = 0;
        for (IT_KhHubiMikaisyouList khHubiMikaisyouList : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000001");

        int iCount = 0;
        for (IT_KhHubiMikaisyouList khHubiMikaisyouList : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("1000000001", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111118", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.BLNK, khHubiMikaisyouList.getHassinsakikbn());

            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000003");

        int iCount = 0;
        for (IT_KhHubiMikaisyouList khHubiMikaisyouList : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111141", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.SISYA, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160216), khHubiMikaisyouList.getLasthubbihasinymd());

            }

            if (2 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111129", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.DRTEN, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160217), khHubiMikaisyouList.getLasthubbihasinymd());

            }

            if (3 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111129", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.SYA, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khHubiMikaisyouList.getLasthubbihasinymd());

            }

            if (4 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111130", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.SYA, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khHubiMikaisyouList.getLasthubbihasinymd());

            }

            if (5 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111141", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.SYA, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khHubiMikaisyouList.getLasthubbihasinymd());

            }

            if (6 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111141", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.KOK, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khHubiMikaisyouList.getLasthubbihasinymd());

            }
            if (7 == iCount) {

                Assert.assertEquals("1000000003", khHubiMikaisyouList.getJimutetuzukicd());
                Assert.assertEquals("11807111141", khHubiMikaisyouList.getSyono());
                Assert.assertEquals(C_HassinsakiKbn.DRTEN, khHubiMikaisyouList.getHassinsakikbn());
                Assert.assertEquals(BizDate.valueOf(20160218), khHubiMikaisyouList.getLasthubbihasinymd());

            }
        }
        Assert.assertEquals(7, iCount);
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("JCD01", "");

        int iCount = 0;
        for (IT_KhHubiMikaisyouList khHubiMikaisyouList : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter1() {

        try(ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000003");) {

            int iCount = 0;
            Iterator<IT_KhHubiMikaisyouList> iter = beans.iterator();
            IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList = null;
            while (iter.hasNext()) {

                iT_KhHubiMikaisyouList = iter.next();
                iCount++;
            }
            Assert.assertEquals(7, iCount);
        }
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Kh002");
        recoveryFilter1.setRecoveryfilternm("保全事務手続フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("jimutetuzukicd");
        recoveryFilter1.setRecoveryfilterkeykmid2("syono");
        recoveryFilter1.setRecoveryfilterkeykmid3("hassinsakikbn");

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBH0");
        skipKey1.setTableid("IT_KhHubiMikaisyouList");
        skipKey1.setRecoveryfilterid("Kh002");
        skipKey1.setRecoveryfilterkey1("1000000003");
        skipKey1.setRecoveryfilterkey2("11807111130");
        skipKey1.setRecoveryfilterkey3(C_HassinsakiKbn.SYA.getValue());

        hozenDomManager.insert(skipKey1);
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter2(){

        try(ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000003");) {

            int iCount = 0;
            Iterator<IT_KhHubiMikaisyouList> iter = beans.iterator();
            IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList = null;
            while (iter.hasNext()) {

                iT_KhHubiMikaisyouList = iter.next();
                boolean result1 =
                        (iT_KhHubiMikaisyouList.getJimutetuzukicd().equals("1000000003")) &&
                        (iT_KhHubiMikaisyouList.getSyono().equals("11807111130")) &&
                        (iT_KhHubiMikaisyouList.getHassinsakikbn().eq(C_HassinsakiKbn.SYA));

                assertFalse(result1);
                iCount++;
            }
            Assert.assertEquals(6, iCount);
        }

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RBH0");
        skipKey1.setTableid("IT_KhHubiMikaisyouList");
        skipKey1.setRecoveryfilterid("Kh002");
        skipKey1.setRecoveryfilterkey1("1000000003");
        skipKey1.setRecoveryfilterkey2("11807111129");
        skipKey1.setRecoveryfilterkey3(C_HassinsakiKbn.SYA.getValue());

        hozenDomManager.insert(skipKey1);
    }


    @Test
    @TestOrder(70)
    public void testSkippedFilter3(){

        try(ExDBResults<IT_KhHubiMikaisyouList> beans = hozenDomManager.
                getKhHubiMikaisyouListsByKakutyoujobcdJimutetuzukicd("RBH0", "1000000003");) {

            int iCount = 0;
            Iterator<IT_KhHubiMikaisyouList> iter = beans.iterator();
            IT_KhHubiMikaisyouList iT_KhHubiMikaisyouList = null;
            while (iter.hasNext()) {

                iT_KhHubiMikaisyouList = iter.next();
                boolean result1 =
                        (iT_KhHubiMikaisyouList.getJimutetuzukicd().equals("1000000003")) &&
                        (iT_KhHubiMikaisyouList.getSyono().equals("11807111129")) &&
                        (iT_KhHubiMikaisyouList.getHassinsakikbn().eq(C_HassinsakiKbn.SYA));
                boolean result2 =
                        (iT_KhHubiMikaisyouList.getJimutetuzukicd().equals("1000000003")) &&
                        (iT_KhHubiMikaisyouList.getSyono().equals("11807111130")) &&
                        (iT_KhHubiMikaisyouList.getHassinsakikbn().eq(C_HassinsakiKbn.SYA));
                assertFalse(result1 || result2);
                iCount++;
            }
            Assert.assertEquals(5, iCount);
        }
    }
}
