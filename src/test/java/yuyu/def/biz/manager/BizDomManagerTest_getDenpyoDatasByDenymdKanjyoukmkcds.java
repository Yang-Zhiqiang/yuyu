package yuyu.def.biz.manager;

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

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDenpyoDatasByDenymdKanjyoukmkcds() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDenpyoDatasByDenymdKanjyoukmkcds {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getDenpyoDatasByDenymdKanjyoukmkcds";

    private final static String sheetName = "INデータ";

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestSubData();



        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_DenpyoData> denpyoDataLst = bizDomManager.
            getDenpyoDatasByDenymdKanjyoukmkcds(BizDate.valueOf(20160215), BizDate.valueOf(20160216));
        Assert.assertEquals(0, denpyoDataLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(BizDomManagerTest_getDenpyoDatasByDenymdKanjyoukmkcds.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDenpyoData());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_DenpyoData>  denpyoDataLst = bizDomManager.
            getDenpyoDatasByDenymdKanjyoukmkcds(BizDate.valueOf(20160201), BizDate.valueOf(20160213));
        Assert.assertEquals(0, denpyoDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_DenpyoData>  denpyoDataLst = bizDomManager.
            getDenpyoDatasByDenymdKanjyoukmkcds(BizDate.valueOf(20160215), BizDate.valueOf(20160216));
        Assert.assertEquals(1, denpyoDataLst.size());

        Assert.assertEquals(C_DensysKbn.SKEI, denpyoDataLst.get(0).getDensyskbn());
        Assert.assertEquals("1000000001", denpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals(1, denpyoDataLst.get(0).getEdano().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_DenpyoData>  denpyoDataLst = bizDomManager.
            getDenpyoDatasByDenymdKanjyoukmkcds(BizDate.valueOf(20160315), BizDate.valueOf(20160319));
        Assert.assertEquals(6, denpyoDataLst.size());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(0).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals(7, denpyoDataLst.get(0).getEdano().intValue());
        Assert.assertEquals("1001", denpyoDataLst.get(0).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoDataLst.get(0).getTaisyakukbn());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(1).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(1).getDenrenno());
        Assert.assertEquals(10, denpyoDataLst.get(1).getEdano().intValue());
        Assert.assertEquals("1002", denpyoDataLst.get(1).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoDataLst.get(1).getTaisyakukbn());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(2).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(2).getDenrenno());
        Assert.assertEquals(8, denpyoDataLst.get(2).getEdano().intValue());
        Assert.assertEquals("1002", denpyoDataLst.get(2).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA, denpyoDataLst.get(2).getTaisyakukbn());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(3).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(3).getDenrenno());
        Assert.assertEquals(9, denpyoDataLst.get(3).getEdano().intValue());
        Assert.assertEquals("1002", denpyoDataLst.get(3).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.KASIKATA, denpyoDataLst.get(3).getTaisyakukbn());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(4).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(4).getDenrenno());
        Assert.assertEquals(6, denpyoDataLst.get(4).getEdano().intValue());
        Assert.assertEquals("1003", denpyoDataLst.get(4).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.BLNK, denpyoDataLst.get(4).getTaisyakukbn());

        Assert.assertEquals(C_DensysKbn.HOZEN, denpyoDataLst.get(5).getDensyskbn());
        Assert.assertEquals("1000000002", denpyoDataLst.get(5).getDenrenno());
        Assert.assertEquals(12, denpyoDataLst.get(5).getEdano().intValue());
        Assert.assertEquals("1003", denpyoDataLst.get(5).getSyoricd());
        Assert.assertEquals(C_TaisyakuKbn.KARIKATA, denpyoDataLst.get(5).getTaisyakukbn());

    }
}