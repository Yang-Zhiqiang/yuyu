package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate.valueOf(20160420),
                BizDate.valueOf(20160120), BizDate.valueOf(20150320))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 1);
        denpyoData1.setKeirisyono("11807111118");
        denpyoData1.setDenymd(BizDate.valueOf(20160420));
        denpyoData1.setSyoriYmd(BizDate.valueOf(20160119));
        denpyoData1.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData1.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData1.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 2);
        denpyoData2.setKeirisyono("11807111118");
        denpyoData2.setDenymd(BizDate.valueOf(20160420));
        denpyoData2.setSyoriYmd(BizDate.valueOf(20160119));
        denpyoData2.setKessantyouseikbn(C_KessantyouseiKbn.BLNK);
        denpyoData2.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData2.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.HOZEN, "1", 3);
        denpyoData3.setKeirisyono("11807111118");
        denpyoData3.setDenymd(BizDate.valueOf(20160420));
        denpyoData3.setSyoriYmd(BizDate.valueOf(20160119));
        denpyoData3.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData3.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData3.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 4);
        denpyoData4.setKeirisyono("11807111118");
        denpyoData4.setDenymd(BizDate.valueOf(20160420));
        denpyoData4.setSyoriYmd(BizDate.valueOf(20160119));
        denpyoData4.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData4.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);
        denpyoData4.setFstpryosyuymd(BizDate.valueOf(20150321));

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 5);
        denpyoData5.setKeirisyono("11807111152");
        denpyoData5.setDenymd(BizDate.valueOf(20160421));
        denpyoData5.setSyoriYmd(BizDate.valueOf(20160119));
        denpyoData5.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData5.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData5.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 6);
        denpyoData6.setKeirisyono("11807111152");
        denpyoData6.setDenymd(BizDate.valueOf(20160419));
        denpyoData6.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData6.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData6.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData6.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 7);
        denpyoData7.setKeirisyono("11807111163");
        denpyoData7.setDenymd(BizDate.valueOf(20160420));
        denpyoData7.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData7.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData7.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData7.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 8);
        denpyoData8.setKeirisyono("11807111163");
        denpyoData8.setDenymd(BizDate.valueOf(20160420));
        denpyoData8.setSyoriYmd(BizDate.valueOf(20160121));
        denpyoData8.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData8.setDensyorikbn(C_DensyoriKbn.SEIRITU);
        denpyoData8.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData8);

        BT_DenpyoData denpyoData9 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 9);
        denpyoData9.setKeirisyono("11807111163");
        denpyoData9.setDenymd(BizDate.valueOf(20160420));
        denpyoData9.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData9.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData9.setDensyorikbn(C_DensyoriKbn.FP_ONLINENYKN);
        denpyoData9.setFstpryosyuymd(BizDate.valueOf(20150321));

        bizDomManager.insert(denpyoData9);

        BT_DenpyoData denpyoData10 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 10);
        denpyoData10.setKeirisyono("11807111163");
        denpyoData10.setDenymd(BizDate.valueOf(20160420));
        denpyoData10.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData10.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData10.setDensyorikbn(C_DensyoriKbn.FP_ONLINENYKN);
        denpyoData10.setFstpryosyuymd(BizDate.valueOf(20150320));

        bizDomManager.insert(denpyoData10);

        BT_DenpyoData denpyoData11 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 11);
        denpyoData11.setKeirisyono("11807111163");
        denpyoData11.setDenymd(BizDate.valueOf(20160420));
        denpyoData11.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData11.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData11.setDensyorikbn(C_DensyoriKbn.FP_ONLINENYKN);
        denpyoData11.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData11);

        BT_DenpyoData denpyoData12 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 12);
        denpyoData12.setKeirisyono("11807111118");
        denpyoData12.setDenymd(BizDate.valueOf(20160420));
        denpyoData12.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData12.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData12.setDensyorikbn(C_DensyoriKbn.FP_CREDITNYKN);
        denpyoData12.setFstpryosyuymd(BizDate.valueOf(20150321));

        bizDomManager.insert(denpyoData12);

        BT_DenpyoData denpyoData13 = new BT_DenpyoData(C_DensysKbn.SKEI, "1", 13);
        denpyoData13.setKeirisyono("11807111163");
        denpyoData13.setDenymd(BizDate.valueOf(20160420));
        denpyoData13.setSyoriYmd(BizDate.valueOf(20160120));
        denpyoData13.setKessantyouseikbn(C_KessantyouseiKbn.OIKOMITAISYOU);
        denpyoData13.setDensyorikbn(C_DensyoriKbn.FP_CREDITNYKN);
        denpyoData13.setFstpryosyuymd(BizDate.valueOf(20150319));

        bizDomManager.insert(denpyoData13);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate.valueOf(20160520),
                BizDate.valueOf(20160120), BizDate.valueOf(20150320))) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate.valueOf(20160421),
                BizDate.valueOf(20160119), BizDate.valueOf(20150319))) {

            int iCount = 0;
            for (BT_DenpyoData denpyoData : beans) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                    Assert.assertEquals("1", denpyoData.getDenrenno());
                    Assert.assertEquals(5, denpyoData.getEdano().intValue());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate.valueOf(20160420),
                BizDate.valueOf(20160120), BizDate.valueOf(20150320))) {

            Map<String,String> map = new HashMap<String,String>();
            map.put($(C_DensysKbn.SKEI, "1", 1),"1");
            map.put($(C_DensysKbn.SKEI, "1", 2),"1");
            map.put($(C_DensysKbn.HOZEN, "1", 3),"1");
            map.put($(C_DensysKbn.SKEI, "1", 5),"1");
            map.put($(C_DensysKbn.SKEI, "1", 7),"1");
            map.put($(C_DensysKbn.SKEI, "1", 10),"1");
            map.put($(C_DensysKbn.SKEI, "1", 11),"1");
            map.put($(C_DensysKbn.SKEI, "1", 13),"1");

            int iCount = 0;
            for (BT_DenpyoData denpyoData : beans) {
                iCount++;

                map.remove($(denpyoData.getDensyskbn(), denpyoData.getDenrenno(), denpyoData.getEdano().intValue()));
            }

            Assert.assertEquals(8, iCount);
            assertTrue(map.isEmpty());
        }
    }
}
