package yuyu.def.sinkeiyaku.manager;

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
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHokenSyuruiNosByHyoujitoymdGt() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHyoujitoymdGt {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkHokenSyuruiNosByHyoujitoymdGt";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;


    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(BizDate.valueOf(20160125));

        Assert.assertEquals(0, skHokenSyuruiNoLst.size());

        insertTestData();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkHokenSyuruiNosByHyoujitoymdGt.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public static void deleteTestSubData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(BizDate
            .valueOf(20160229));

        Assert.assertEquals(0, skHokenSyuruiNoLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(BizDate
            .valueOf(20160226));
        Assert.assertEquals(1, skHokenSyuruiNoLst.size());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        Assert.assertEquals(BizDate.valueOf(20160227), skHokenSyuruiNoLst.get(0).getHyoujitoymd());
        Assert.assertEquals(1, skHokenSyuruiNoLst.get(0).getHknsyuruinosd().intValue());

    }

    @Test
    @TestOrder(40)
    public void normal2() {

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(BizDate
            .valueOf(20160220));

        Assert.assertEquals(3, skHokenSyuruiNoLst.size());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRIHENGAKUNK_BLEND, skHokenSyuruiNoLst.get(0).getHknsyuruino());
        Assert.assertEquals(BizDate.valueOf(20160224), skHokenSyuruiNoLst.get(0).getHyoujitoymd());
        Assert.assertEquals(6, skHokenSyuruiNoLst.get(0).getHknsyuruinosd().intValue());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, skHokenSyuruiNoLst.get(1).getHknsyuruino());
        Assert.assertEquals(BizDate.valueOf(20160225), skHokenSyuruiNoLst.get(1).getHyoujitoymd());
        Assert.assertEquals(4, skHokenSyuruiNoLst.get(1).getHknsyuruinosd().intValue());

        Assert.assertEquals(C_HknsyuruiNo.GAIKAITIJIBRISYUUSIN_MAITOSIUKT, skHokenSyuruiNoLst.get(2).getHknsyuruino());
        Assert.assertEquals(BizDate.valueOf(20160223), skHokenSyuruiNoLst.get(2).getHyoujitoymd());
        Assert.assertEquals(5, skHokenSyuruiNoLst.get(2).getHknsyuruinosd().intValue());


    }
}
