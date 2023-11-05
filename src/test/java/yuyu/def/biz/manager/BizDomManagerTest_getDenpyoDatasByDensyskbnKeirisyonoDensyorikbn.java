package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "1", C_DensyoriKbn.BLNK, BizDate.valueOf(20161125));

        Assert.assertEquals(0, denpyoDataLst.size());

        BT_DenpyoData denpyoData1 = new BT_DenpyoData(C_DensysKbn.BLNK, "10", 01);
        denpyoData1.setKeirisyono("1");
        denpyoData1.setDenymd(BizDate.valueOf(20161125));
        denpyoData1.setDensyorikbn(C_DensyoriKbn.BLNK);

        bizDomManager.insert(denpyoData1);

        BT_DenpyoData denpyoData2 = new BT_DenpyoData(C_DensysKbn.HOZEN, "10", 01);
        denpyoData2.setKeirisyono("1");
        denpyoData2.setDenymd(BizDate.valueOf(20161125));
        denpyoData2.setDensyorikbn(C_DensyoriKbn.BLNK);

        bizDomManager.insert(denpyoData2);

        BT_DenpyoData denpyoData3 = new BT_DenpyoData(C_DensysKbn.BLNK, "14", 01);
        denpyoData3.setKeirisyono("2");
        denpyoData3.setDenymd(BizDate.valueOf(20161125));
        denpyoData3.setDensyorikbn(C_DensyoriKbn.BLNK);

        bizDomManager.insert(denpyoData3);

        BT_DenpyoData denpyoData4 = new BT_DenpyoData(C_DensysKbn.BLNK, "15", 01);
        denpyoData4.setKeirisyono("1");
        denpyoData4.setDenymd(BizDate.valueOf(20161125));
        denpyoData4.setDensyorikbn(C_DensyoriKbn.FP_CREDITNYKN);

        bizDomManager.insert(denpyoData4);

        BT_DenpyoData denpyoData5 = new BT_DenpyoData(C_DensysKbn.BLNK, "16", 01);
        denpyoData5.setKeirisyono("1");
        denpyoData5.setDenymd(BizDate.valueOf(20161124));
        denpyoData5.setDensyorikbn(C_DensyoriKbn.BLNK);

        bizDomManager.insert(denpyoData5);

        BT_DenpyoData denpyoData6 = new BT_DenpyoData(C_DensysKbn.SKEI, "11", 01);
        denpyoData6.setKeirisyono("3");
        denpyoData6.setDenymd(BizDate.valueOf(20161111));
        denpyoData6.setDensyorikbn(C_DensyoriKbn.FP_KZHKSR);

        bizDomManager.insert(denpyoData6);

        BT_DenpyoData denpyoData7 = new BT_DenpyoData(C_DensysKbn.SKEI, "12", 01);
        denpyoData7.setKeirisyono("3");
        denpyoData7.setDenymd(BizDate.valueOf(20161112));
        denpyoData7.setDensyorikbn(C_DensyoriKbn.FP_KZHKSR);

        bizDomManager.insert(denpyoData7);

        BT_DenpyoData denpyoData8 = new BT_DenpyoData(C_DensysKbn.SKEI, "13", 01);
        denpyoData8.setKeirisyono("3");
        denpyoData8.setDenymd(BizDate.valueOf(20161113));
        denpyoData8.setDensyorikbn(C_DensyoriKbn.FP_KZHKSR);

        bizDomManager.insert(denpyoData8);

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

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "1", C_DensyoriKbn.BLNK, BizDate.valueOf(20161126));

        Assert.assertEquals(0, denpyoDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "1", C_DensyoriKbn.BLNK, BizDate.valueOf(20161125));

        Assert.assertEquals(1, denpyoDataLst.size());

        Assert.assertEquals(C_DensysKbn.BLNK, denpyoDataLst.get(0).getDensyskbn());
        Assert.assertEquals( "10", denpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals(01, denpyoDataLst.get(0).getEdano().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> SkKihonMap = new HashMap<String,String>();
        SkKihonMap.put($(C_DensysKbn.SKEI, "11", 01),"1");
        SkKihonMap.put($(C_DensysKbn.SKEI, "12", 01),"1");
        SkKihonMap.put($(C_DensysKbn.SKEI, "13", 01),"1");

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.SKEI, "3", C_DensyoriKbn.FP_KZHKSR, BizDate.valueOf(20161111));

        Assert.assertEquals(3, denpyoDataLst.size());

        SkKihonMap.remove($(denpyoDataLst.get(0).getDensyskbn(), denpyoDataLst.get(0).getDenrenno(), denpyoDataLst.get(0).getEdano()));
        SkKihonMap.remove($(denpyoDataLst.get(1).getDensyskbn(), denpyoDataLst.get(1).getDenrenno(), denpyoDataLst.get(1).getEdano()));
        SkKihonMap.remove($(denpyoDataLst.get(2).getDensyskbn(), denpyoDataLst.get(2).getDenrenno(), denpyoDataLst.get(2).getEdano()));

        assertTrue(SkKihonMap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_DenpyoData> denpyoData = bizDomManager.getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(
            C_DensysKbn.BLNK, "", C_DensyoriKbn.BLNK, BizDate.valueOf(20161125));

        Assert.assertEquals(0, denpyoData.size());

    }

}
