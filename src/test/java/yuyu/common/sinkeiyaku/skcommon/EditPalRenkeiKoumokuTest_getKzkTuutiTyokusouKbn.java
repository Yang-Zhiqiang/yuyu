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
 * {@link EditPalRenkeiKoumoku#getKzkTuutiTyokusouKbn(HT_SyoriCTL)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditPalRenkeiKoumokuTest_getKzkTuutiTyokusouKbn {

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
            testDataAndTblMap = testDataMaker.getInData(EditPalRenkeiKoumokuTest_getKzkTuutiTyokusouKbn.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ012", testDataAndTblMap);
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
    public void testGetKzkTuutiTyokusouKbn_A1() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(20)
    public void testGetKzkTuutiTyokusouKbn_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(30)
    public void testGetKzkTuutiTyokusouKbn_A3() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(40)
    public void testGetKzkTuutiTyokusouKbn_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000041");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(50)
    public void testGetKzkTuutiTyokusouKbn_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000058");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(60)
    public void testGetKzkTuutiTyokusouKbn_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000066");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(70)
    public void testGetKzkTuutiTyokusouKbn_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000074");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(80)
    public void testGetKzkTuutiTyokusouKbn_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000082");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(90)
    public void testGetKzkTuutiTyokusouKbn_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000090");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(100)
    public void testGetKzkTuutiTyokusouKbn_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000108");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(110)
    public void testGetKzkTuutiTyokusouKbn_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000116");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(120)
    public void testGetKzkTuutiTyokusouKbn_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000124");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(130)
    public void testGetKzkTuutiTyokusouKbn_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000132");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "3", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(140)
    public void testGetKzkTuutiTyokusouKbn_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000140");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "1", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(150)
    public void testGetKzkTuutiTyokusouKbn_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000157");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "2", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(160)
    public void testGetKzkTuutiTyokusouKbn_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000165");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "9", "ご家族通知直送区分");
    }

    @Test
    @TestOrder(170)
    public void testGetKzkTuutiTyokusouKbn_A17() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000173");

        String kzkTuutiTyokusouKbn = editPalRenkeiKoumoku.getKzkTuutiTyokusouKbn(syoriCTL);

        exStringEquals(kzkTuutiTyokusouKbn, "", "ご家族通知直送区分");
    }
}
