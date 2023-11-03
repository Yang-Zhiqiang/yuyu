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
 * {@link EditPalRenkeiKoumoku#getKzktrkServiceKbn(HT_SyoriCTL)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getKzktrkServiceKbn {

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
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_getKzktrkServiceKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ009", testDataAndTblMap);
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
    public void testKzktrkServiceKbn_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");

        String kzktrkServiceKbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

        exStringEquals(kzktrkServiceKbn, "0", "ご家族登録サービス区分");
    }

    @Test
    @TestOrder(20)
    public void testKzktrkServiceKbn_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");

        String kzktrkServiceKbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

        exStringEquals(kzktrkServiceKbn, "1", "ご家族登録サービス区分");
    }

    @Test
    @TestOrder(30)
    public void testKzktrkServiceKbn_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000181");

        String kzktrkServiceKbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

        exStringEquals(kzktrkServiceKbn, "2", "ご家族登録サービス区分");
    }

    @Test
    @TestOrder(40)
    public void testKzktrkServiceKbn_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");

        String kzktrkServiceKbn = editPalRenkeiKoumoku.getKzktrkServiceKbn(syoriCTL);

        exStringEquals(kzktrkServiceKbn, "0", "ご家族登録サービス区分");
    }

}
