package yuyu.common.sinkeiyaku.skcommon;

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
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 差異データ取得クラスのメソッド {@link SaiDataSyutoku#findSaiData(String, String)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SaiDataSyutokuTest_findSaiData {

    private final static String mosNo1 = "885012112";

    private final static String mosNo2 = "885012120";

    private final static String mosNo3 = "885012138";

    private final static String fileName = "UT_SP_単体テスト仕様書_差異データ取得";

    private final static String sheetName = "テストデータ";

    @Inject
    private SaiDataSyutoku saiDataSyutoku;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SaiDataSyutokuTest_findSaiData.class, fileName, sheetName);
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
    public void testFindSaiData_A1() {

        int syutokuData = saiDataSyutoku.findSaiData(mosNo1, "SaiDataSyutoku");

        exNumericEquals(syutokuData, -1, "取得データ有無");

        exNumericEquals(saiDataSyutoku.getNrksouikmList().size(), 0, "入力相違項目リストの件数");
        exNumericEquals(saiDataSyutoku.getItijinrkList().size(), 0, "１次入力リストの件数");
        exNumericEquals(saiDataSyutoku.getNijinrkList().size(), 0, "２次入力リストの件数");
    }

    @Test
    @TestOrder(20)
    public void testFindSaiData_A2() {

        int syutokuData = saiDataSyutoku.findSaiData(mosNo2, "SaiDataSyutoku");

        exNumericEquals(syutokuData, 0, "取得データ有無");

        exStringEquals(saiDataSyutoku.getNrksouikmList().get(0), "入力相違項目", "入力相違項目リスト[0]");
        exStringEquals(saiDataSyutoku.getItijinrkList().get(0), "１次入力", "１次入力リスト[0]");
        exStringEquals(saiDataSyutoku.getNijinrkList().get(0), "２次入力", "２次入力リスト[0]");

        exNumericEquals(saiDataSyutoku.getNrksouikmList().size(), 1, "入力相違項目リストの件数");
        exNumericEquals(saiDataSyutoku.getItijinrkList().size(), 1, "１次入力リストの件数");
        exNumericEquals(saiDataSyutoku.getNijinrkList().size(), 1, "２次入力リストの件数");
    }

    @Test
    @TestOrder(30)
    public void testFindSaiData_A3() {

        int syutokuData = saiDataSyutoku.findSaiData(mosNo3, "SaiDataSyutoku");

        exNumericEquals(syutokuData, 0, "取得データ有無");

        exStringEquals(saiDataSyutoku.getNrksouikmList().get(0), "入力相違項目1", "入力相違項目リスト[0]");
        exStringEquals(saiDataSyutoku.getItijinrkList().get(0), "１次入力1", "１次入力リスト[0]");
        exStringEquals(saiDataSyutoku.getNijinrkList().get(0), "２次入力1", "２次入力リスト[0]");

        exStringEquals(saiDataSyutoku.getNrksouikmList().get(1), null, "入力相違項目リスト[1]");
        exStringEquals(saiDataSyutoku.getItijinrkList().get(1), null, "１次入力リスト[1]");
        exStringEquals(saiDataSyutoku.getNijinrkList().get(1), null, "２次入力リスト[1]");

        exStringEquals(saiDataSyutoku.getNrksouikmList().get(2), "入力相違項目3", "入力相違項目リスト[2]");
        exStringEquals(saiDataSyutoku.getItijinrkList().get(2), "１次入力3", "１次入力リスト[2]");
        exStringEquals(saiDataSyutoku.getNijinrkList().get(2), "２次入力3", "２次入力リスト[2]");

        exNumericEquals(saiDataSyutoku.getNrksouikmList().size(), 3, "入力相違項目リストの件数");
        exNumericEquals(saiDataSyutoku.getItijinrkList().size(), 3, "１次入力リストの件数");
        exNumericEquals(saiDataSyutoku.getNijinrkList().size(), 3, "２次入力リストの件数");
    }
}
