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

import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasBySyoriYmdDensyskbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasBySyoriYmdDensyskbn {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasBySyoriYmdDensyskbn(BizDate.valueOf(20160823), BizDate.valueOf(20160825), C_DensysKbn.SKEI)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "10001", 1);
        denpyoData1.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData1.setSyoriYmd(BizDate.valueOf(20160824));

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "10001", 2);
        denpyoData2.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData2.setSyoriYmd(BizDate.valueOf(20160823));

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "10001", 3);
        denpyoData3.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData3.setSyoriYmd(BizDate.valueOf(20160822));

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "10001", 4);
        denpyoData4.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData4.setSyoriYmd(BizDate.valueOf(20160826));

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.valueOf("0"), "10001", 1);
        denpyoData5.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData5.setSyoriYmd(BizDate.valueOf(20160824));

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.valueOf("10"), "10001", 5);
        denpyoData6.setKanjyoukmkcd(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY);
        denpyoData6.setSyoriYmd(BizDate.valueOf(20160824));

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "10002", 1);
        denpyoData7.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD);
        denpyoData7.setSyoriYmd(BizDate.valueOf(20160924));

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "10002", 2);
        denpyoData8.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY);
        denpyoData8.setSyoriYmd(BizDate.valueOf(20160925));

        bizDomManager.insert(denpyoData8);

        BT_DenpyoData denpyoData9 = new BT_DenpyoData(C_DensysKbn.valueOf("20"), "10002", 3);
        denpyoData9.setKanjyoukmkcd(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD);
        denpyoData9.setSyoriYmd(BizDate.valueOf(20160926));

        bizDomManager.insert(denpyoData9);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<BT_DenpyoData> beans =
            bizDomManager.getDenpyoDatasBySyoriYmdDensyskbn(BizDate.valueOf(20160823), BizDate.valueOf(20160825), C_DensysKbn.HOZEN)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdDensyskbn(BizDate.valueOf(20160823),
            BizDate.valueOf(20160825), C_DensysKbn.SKEI);

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_DensysKbn.SKEI, denpyoData.getDensyskbn());
                Assert.assertEquals("10001", denpyoData.getDenrenno());
                Assert.assertEquals(1, denpyoData.getEdano().intValue());
            }
        }

        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<BT_DenpyoData> beans = bizDomManager.getDenpyoDatasBySyoriYmdDensyskbn(BizDate.valueOf(20160923),
            BizDate.valueOf(20160926), C_DensysKbn.HOZEN);

        Map<String,String> map = new HashMap<String,String>();
        map.put($(C_DensysKbn.HOZEN,"10002",1), "1");
        map.put($(C_DensysKbn.HOZEN,"10002",2), "1");
        map.put($(C_DensysKbn.HOZEN,"10002",3), "1");

        int iCount = 0;
        for (BT_DenpyoData denpyoData : beans) {
            iCount++;

            map.remove($(denpyoData.getDensyskbn(),denpyoData.getDenrenno(),denpyoData.getEdano().intValue()));
        }
        Assert.assertEquals(3, iCount);
        assertTrue(map.isEmpty());
    }
}

