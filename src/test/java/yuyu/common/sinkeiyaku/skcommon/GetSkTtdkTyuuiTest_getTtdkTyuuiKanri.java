package yuyu.common.sinkeiyaku.skcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.db.entity.HT_SkTtdkTyuuiKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約手続注意情報取得クラスのメソッド {@link GetSkTtdkTyuui#getTtdkTyuuiKanri(String)} テスト用クラスです<br />
 */

@RunWith(OrderedRunner.class)
public class GetSkTtdkTyuuiTest_getTtdkTyuuiKanri {

    private static String mosNo1 = "871229118";

    private static String mosNo2 = "871229126";

    private final static String fileName = "UT_SP_単体テスト仕様書_新契約手続注意情報取得";

    private final static String sheetName = "テストデータ";

    @Inject
    private GetSkTtdkTyuui getSkTtdkTyuui;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(GetSkTtdkTyuuiTest_getTtdkTyuuiKanri.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        MockObjectManager.initialize();
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testGetTtdkTyuuiKanri_A1() {

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = getSkTtdkTyuui.getTtdkTyuuiKanri(mosNo1);

        assertEquals(null, skTtdkTyuuiKanri);
    }

    @Test
    @TestOrder(20)
    public void testGetTtdkTyuuiKanri_A2() {

        HT_SkTtdkTyuuiKanri skTtdkTyuuiKanri = getSkTtdkTyuui.getTtdkTyuuiKanri(mosNo2);

        exStringEquals(skTtdkTyuuiKanri.getMosno(), mosNo2, "申込番号");
    }
}
