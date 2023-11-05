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
import yuyu.def.db.entity.HT_SkLincJyusinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        List<HT_SkLincJyusinData> skLincJyusinDataLst = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate.valueOf(20201222), "0000000020");

        Assert.assertEquals(0, skLincJyusinDataLst.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkLincJyusinData());

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {


        List<HT_SkLincJyusinData> skLincJyusinDataLst = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate.valueOf(20201221), "0000000010");

        Assert.assertEquals(0, skLincJyusinDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        List<HT_SkLincJyusinData> skLincJyusinDataLst = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate.valueOf(20201222), "0000000020");

        Assert.assertEquals(1, skLincJyusinDataLst.size());

        Assert.assertEquals(BizDate.valueOf(20201222), skLincJyusinDataLst.get(0).getSyoriYmd());
        Assert.assertEquals("1000000001", skLincJyusinDataLst.get(0).getLinckyknaiykekdatarenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {


        List<HT_SkLincJyusinData> skLincJyusinDataLst = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate.valueOf(20201223), "0000000030");

        Assert.assertEquals(5, skLincJyusinDataLst.size());

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinDataLst.get(0).getSyoriYmd());
        Assert.assertEquals("1000000001", skLincJyusinDataLst.get(0).getLinckyknaiykekdatarenno());

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinDataLst.get(1).getSyoriYmd());
        Assert.assertEquals("1000000002", skLincJyusinDataLst.get(1).getLinckyknaiykekdatarenno());

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinDataLst.get(2).getSyoriYmd());
        Assert.assertEquals("1000000003", skLincJyusinDataLst.get(2).getLinckyknaiykekdatarenno());

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinDataLst.get(3).getSyoriYmd());
        Assert.assertEquals("1000000004", skLincJyusinDataLst.get(3).getLinckyknaiykekdatarenno());

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinDataLst.get(4).getSyoriYmd());
        Assert.assertEquals("1000000005", skLincJyusinDataLst.get(4).getLinckyknaiykekdatarenno());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkLincJyusinData> skLincJyusinDataLst = sinkeiyakuDomManager.getSkLincJyusinDatasBySyoriymdLinckyknaiykekdatarennooya(BizDate.valueOf(20201223), "");

        Assert.assertEquals(0, skLincJyusinDataLst.size());

    }
}
