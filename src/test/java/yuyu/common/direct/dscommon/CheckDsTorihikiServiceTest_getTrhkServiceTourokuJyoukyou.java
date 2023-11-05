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
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ取引サービス共通チェッククラスのメソッド {@link CheckDsTorihikiService#getTrhkServiceTourokuJyoukyou(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsTorihikiServiceTest_getTrhkServiceTourokuJyoukyou {

    @Inject
    private CheckDsTorihikiService checkDsTorihikiService;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ取引サービス共通チェック";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDsTorihikiServiceTest_getTrhkServiceTourokuJyoukyou.class,
                fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void testGetTrhkServiceTourokuJyoukyou_A1() {

        String syono = "18806010017";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(20)
    public void testGetTrhkServiceTourokuJyoukyou_A2() {

        String syono = "18806010028";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testGetTrhkServiceTourokuJyoukyou_A3() {

        String syono = "18806010039";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            C_UmuKbn.ARI, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(40)
    public void testGetTrhkServiceTourokuJyoukyou_A4() {

        String syono = "18806010040";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @TestOrder(50)
    public void testGetTrhkServiceTourokuJyoukyou_A5() {

        String syono = "18806010051";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.OK, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            C_UmuKbn.NONE, "ＤＳ解約サービス登録有無");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testGetTrhkServiceTourokuJyoukyou_A6() {

        String syono = "18806010062";
        GetTrhkServiceTourokuJyoukyouBean retBean = checkDsTorihikiService.getTrhkServiceTourokuJyoukyou(syono);
        exClassificationEquals(retBean.getErrorkbn(), C_ErrorKbn.ERROR, "エラー区分");
        exClassificationEquals(retBean.getDsKaiykServiceTourokuUmu(),
            null, "ＤＳ解約サービス登録有無");
    }
}