package yuyu.def.sinkeiyaku.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkHubiDetailsByMosnoSyoruicd メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class   SinkeiyakuDomManagerTest_getMostenkenRirekiByMosnoKanryouMaxRenno {
    private final static String fileName = "UT-SP_単体テスト仕様書（DomManager）_getMostenkenRirekiByMosnoKanryouMaxRenno";

    private final static String sheetName = "INデータ";

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_MostenkenRireki mostenkenRireki =
            sinkeiyakuDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno("860000010");

        Assert.assertEquals(null, mostenkenRireki);

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SinkeiyakuDomManagerTest_getMostenkenRirekiByMosnoKanryouMaxRenno.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_MostenkenRireki mostenkenRireki =
            sinkeiyakuDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno("860000016");

        Assert.assertEquals(null, mostenkenRireki);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_MostenkenRireki mostenkenRireki =
            sinkeiyakuDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno("860000017");

        Assert.assertEquals("860000017", mostenkenRireki.getMosno());
        Assert.assertEquals(3, mostenkenRireki.getRenno().intValue());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        HT_MostenkenRireki mostenkenRireki =
            sinkeiyakuDomManager.getMostenkenRirekiByMosnoKanryouMaxRenno("");

        Assert.assertEquals(null, mostenkenRireki);
    }

}
