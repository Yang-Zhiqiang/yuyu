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
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ連携項目編集クラスのメソッド
 * {@link EditPalRenkeiKoumoku#editSisyaketteiYmd(HT_SyoriCTL)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_editSisyaketteiYmd {

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
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_editSisyaketteiYmd.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ006", testDataAndTblMap);
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
    public void testEditSisyaketteiYmd_A1() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029016");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "20190502", "支社決定処理年月日");
    }

    @Test
    @TestOrder(20)
    public void testEditSisyaketteiYmd_A2() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029024");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "20190402", "支社決定処理年月日");
    }

    @Test
    @TestOrder(30)
    public void testEditSisyaketteiYmd_A3() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029032");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "20190403", "支社決定処理年月日");
    }

    @Test
    @TestOrder(40)
    public void testEditSisyaketteiYmd_A4() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029040");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "00000000", "支社決定処理年月日");
    }

    @Test
    @TestOrder(50)
    public void testEditSisyaketteiYmd_A5() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029057");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "00000000", "支社決定処理年月日");
    }

    @Test
    @TestOrder(60)
    public void testEditSisyaketteiYmd_A6() {
        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860029065");

        String sisyaketteiYmd = editPalRenkeiKoumoku.editSisyaketteiYmd(syoriCTL);

        exStringEquals(sisyaketteiYmd, "00000000", "支社決定処理年月日");
    }

}
