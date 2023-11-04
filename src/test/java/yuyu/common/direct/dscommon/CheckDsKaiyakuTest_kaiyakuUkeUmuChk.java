package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ解約受付有無チェックのメソッド{@link CheckDsKaiyaku#kaiyakuUkeUmuChk(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsKaiyakuTest_kaiyakuUkeUmuChk {

    @Inject
    private CheckDsKaiyaku checkDsKaiyaku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ解約共通チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDsKaiyakuTest_kaiyakuUkeUmuChk.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHenkouUktk());
    }

    @Test
    @TestOrder(10)
    public void testExec_B1() {

        C_UmuKbn umuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk("17806000297");

        exClassificationEquals(umuKbn, C_UmuKbn.NONE, "ＤＳ解約有無区分");
    }

    @Test
    @TestOrder(20)
    public void testExec_B2() {

        C_UmuKbn umuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk("17806000091");

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "ＤＳ解約有無区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_B3() {

        C_UmuKbn umuKbn = checkDsKaiyaku.kaiyakuUkeUmuChk("17806000105");

        exClassificationEquals(umuKbn, C_UmuKbn.ARI, "ＤＳ解約有無区分");
    }

}
