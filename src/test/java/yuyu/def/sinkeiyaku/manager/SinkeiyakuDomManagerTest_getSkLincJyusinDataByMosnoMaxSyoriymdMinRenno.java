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
 * getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno {

    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);


        HT_SkLincJyusinData skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000025");

        Assert.assertNull(skLincJyusinData);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno.class,
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


        HT_SkLincJyusinData skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000017");

        Assert.assertNull(skLincJyusinData);
    }

    @Test
    @TestOrder(20)
    public void normal1() {


        HT_SkLincJyusinData skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000025");

        Assert.assertEquals(BizDate.valueOf(20201223), skLincJyusinData.getSyoriYmd());
        Assert.assertEquals("0000000010", skLincJyusinData.getLinckyknaiykekdatarenno());

        skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000033");

        Assert.assertEquals(BizDate.valueOf(20201224), skLincJyusinData.getSyoriYmd());
        Assert.assertEquals("0000000012", skLincJyusinData.getLinckyknaiykekdatarenno());

        skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000041");

        Assert.assertEquals(BizDate.valueOf(20201224), skLincJyusinData.getSyoriYmd());
        Assert.assertEquals("0000000013", skLincJyusinData.getLinckyknaiykekdatarenno());

        skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("860000058");

        Assert.assertEquals(BizDate.valueOf(20201224), skLincJyusinData.getSyoriYmd());
        Assert.assertEquals("0000000014", skLincJyusinData.getLinckyknaiykekdatarenno());
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        HT_SkLincJyusinData skLincJyusinData = sinkeiyakuDomManager.getSkLincJyusinDataByMosnoMaxSyoriymdMinRenno("");

        Assert.assertNull(skLincJyusinData);

    }
}
