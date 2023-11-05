package yuyu.def.db.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getTrkKzkByTrkKzkKbn {

    private final static String fileName = "UT-SP_単体テスト仕様書（Entity）_getTrkKzkByTrkKzkKbn";

    private final static String sheetName = "INデータ";

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");

        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("11807111118");
            IT_TrkKzk trkKzk = kykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);

            Assert.assertNull(trkKzk);

            insertTestData();
        }
    }

    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(IT_KykKihonTest_getTrkKzkByTrkKzkKbn.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_TrkKzk trkKzk = kykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.BLNK);

        Assert.assertNull(trkKzk);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        IT_TrkKzk trkKzk = kykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);

        Assert.assertEquals("01", trkKzk.getKbnkey());
        Assert.assertEquals("11807111118", trkKzk.getSyono());
        Assert.assertEquals(C_TrkKzkKbn.TRKKZK1, trkKzk.getTrkkzkkbn());
    }
}
