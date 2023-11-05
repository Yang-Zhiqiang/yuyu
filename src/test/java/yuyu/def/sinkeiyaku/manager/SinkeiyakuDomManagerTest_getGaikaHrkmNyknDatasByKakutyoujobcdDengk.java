package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_GaikaHrkmNyknData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getGaikaHrkmNyknDatasByKakutyoujobcdDengk() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getGaikaHrkmNyknDatasByKakutyoujobcdDengk {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.BLNK, BizDate.valueOf(20160606), "0001");
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1(){

        try (ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20(){
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0001");
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.HOZEN, BizDate.valueOf(20160606), "0002");
        gaikaHrkmNyknData2.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0003");
        gaikaHrkmNyknData3.setDengk(BizCurrency.valueOf(111,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData4 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0004");
        gaikaHrkmNyknData4.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData4.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData4);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21(){

        try(ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")){

            int iCount = 0;
            for (HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData : beans) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(C_DensysKbn.SKEI, hT_GaikaHrkmNyknData.getDensyskbn());
                    Assert.assertEquals(BizDate.valueOf("20160606"), hT_GaikaHrkmNyknData.getSyoriYmd());
                    Assert.assertEquals("0001", hT_GaikaHrkmNyknData.getItirenno());
                }
            }
            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30(){
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllGaikaHrkmNyknData());

        HT_GaikaHrkmNyknData gaikaHrkmNyknData1 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0001");
        gaikaHrkmNyknData1.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.YEN));
        gaikaHrkmNyknData1.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData1);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData2 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0002");
        gaikaHrkmNyknData2.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR));
        gaikaHrkmNyknData2.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData2);

        HT_GaikaHrkmNyknData gaikaHrkmNyknData3 = new HT_GaikaHrkmNyknData(C_DensysKbn.SKEI, BizDate.valueOf(20160606), "0003");
        gaikaHrkmNyknData3.setDengk(BizCurrency.valueOf(0,BizCurrencyTypes.EURO));
        gaikaHrkmNyknData3.setSyorizumiflg(C_Syorizumiflg.MISYORI);

        sinkeiyakuDomManager.insert(gaikaHrkmNyknData3);

    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_DensysKbn.SKEI,BizDate.valueOf("20160606"),"0001"), "1");
        datamap.put($(C_DensysKbn.SKEI,BizDate.valueOf("20160606"),"0002"), "1");
        datamap.put($(C_DensysKbn.SKEI,BizDate.valueOf("20160606"),"0003"), "1");

        try(ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")){

            for (HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData : beans) {
                datamap.remove($(
                    hT_GaikaHrkmNyknData.getDensyskbn(),
                    hT_GaikaHrkmNyknData.getSyoriYmd(),
                    hT_GaikaHrkmNyknData.getItirenno()));
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

        try(ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")) {

            int iCount = 0;

            Iterator<HT_GaikaHrkmNyknData> iter = beans.iterator();

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
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Sk002");
        recoveryFilter1.setRecoveryfilternm("振込入金フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("densyskbn");
        recoveryFilter1.setRecoveryfilterkeykmid2("syoriYmd");
        recoveryFilter1.setRecoveryfilterkeykmid3("itirenno");

        sinkeiyakuDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("000001");
        skipKey1.setKakutyoujobcd("RBB1");
        skipKey1.setTableid("HT_GaikaHrkmNyknData");
        skipKey1.setRecoveryfilterid("Sk002");
        skipKey1.setRecoveryfilterkey1("10");
        skipKey1.setRecoveryfilterkey2("20160606");
        skipKey1.setRecoveryfilterkey3("0001");

        sinkeiyakuDomManager.insert(skipKey1);

    }
    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")) {
            int iCount = 0;

            Iterator<HT_GaikaHrkmNyknData> iter = beans.iterator();

            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {
                hT_GaikaHrkmNyknData = iter.next();
                boolean result1 =
                    (hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI)) &&
                    (hT_GaikaHrkmNyknData.getSyoriYmd().equals(BizDate.valueOf("20160606"))) &&
                    (hT_GaikaHrkmNyknData.getItirenno().equals("0001"));

                assertFalse(result1);
                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("000002");
        skipKey2.setKakutyoujobcd("RBB1");
        skipKey2.setTableid("HT_GaikaHrkmNyknData");
        skipKey2.setRecoveryfilterid("Sk002");
        skipKey2.setRecoveryfilterkey1("10");
        skipKey2.setRecoveryfilterkey2("20160606");
        skipKey2.setRecoveryfilterkey3("0002");

        sinkeiyakuDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    @Transactional
    public void testSkippedFilter61(){

        try(ExDBUpdatableResults<HT_GaikaHrkmNyknData> beans = sinkeiyakuDomManager.getGaikaHrkmNyknDatasByKakutyoujobcdDengk("RBB1")) {
            int iCount = 0;

            Iterator<HT_GaikaHrkmNyknData> iter = beans.iterator();

            HT_GaikaHrkmNyknData hT_GaikaHrkmNyknData = null;

            while (iter.hasNext()) {
                hT_GaikaHrkmNyknData = iter.next();
                boolean result1 =
                    (hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI)) &&
                    (hT_GaikaHrkmNyknData.getSyoriYmd().equals(BizDate.valueOf("20160606"))) &&
                    (hT_GaikaHrkmNyknData.getItirenno().equals("0001"));

                boolean result2 =
                    (hT_GaikaHrkmNyknData.getDensyskbn().equals(C_DensysKbn.SKEI)) &&
                    (hT_GaikaHrkmNyknData.getSyoriYmd().equals(BizDate.valueOf("20160606"))) &&
                    (hT_GaikaHrkmNyknData.getItirenno().equals("0002"));
                assertFalse(result1);
                assertFalse(result2);
                iCount++;
            }
            Assert.assertEquals(1, iCount);
        }
    }

}

