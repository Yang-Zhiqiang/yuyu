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
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editHrkkaisuu(HT_MosKihon)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editHrkkaisuu {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private EditPalRenkeiKoumoku editPalRenkeiKoumoku;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＰＡＬ連携項目編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData(){
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_editHrkkaisuu.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ007", testDataAndTblMap);
        } catch (Exception e) {
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
    public void testEditHrkkaisuu_A1() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003001").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "2", "払込回数区分");
    }

    @Test
    @TestOrder(20)
    public void testEditHrkkaisuu_A2() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003002").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "1", "払込回数区分");
    }

    @Test
    @TestOrder(30)
    public void testEditHrkkaisuu_A3() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003003").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "3", "払込回数区分");
    }

    @Test
    @TestOrder(40)
    public void testEditHrkkaisuu_A4() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003004").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "3", "払込回数区分");
    }

    @Test
    @TestOrder(50)
    public void testEditHrkkaisuu_A5() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003005").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "2", "払込回数区分");
    }

    @Test
    @TestOrder(60)
    public void testEditHrkkaisuu_A6() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003006").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "1", "払込回数区分");
    }

    @Test
    @TestOrder(70)
    public void testEditHrkkaisuu_A7() {
        HT_MosKihon pMosKihon = sinkeiyakuDomManager.getMosKihonsByUktkid("00000003007").get(0);

        String hrkkaisuu = editPalRenkeiKoumoku.editHrkkaisuu(pMosKihon);

        exStringEquals(hrkkaisuu, "0", "払込回数区分");
    }

}
