package yuyu.common.biz.bzcommon;

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
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 住所情報取得クラスのメソッド {@link BzGetAdrData#execAdrKanjiByPostalcd(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class BzGetAdrDataTest_execAdrKanjiByPostalcd extends AbstractTest {

    @Inject
    private BzGetAdrData bzGetAdrData;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_住所情報取得";
    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(BzGetAdrDataTest_execAdrKanjiByPostalcd.class, fileName,
                sheetName);

            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllAddress());
    }

    @Test
    @TestOrder(10)
    public void testExec_Kj_001_10() {

        String postalCd = null;

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(20)
    public void testExec_Kj_001_20() {

        String postalCd = "";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(30)
    public void testExec_Kj_001_30() {

        String postalCd = "116023";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(40)
    public void testExec_Kj_001_40() {

        String postalCd = "11602345";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(50)
    public void testExec_Kj_001_50() {

        String postalCd = "1160235";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.ERROR, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(60)
    public void testExec_Kj_001_60() {

        String postalCd = "0010015";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北１５条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(70)
    public void testExec_Kj_001_70() {

        String postalCd = "0010027";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(80)
    public void testExec_Kj_001_80() {

        String postalCd = "0010028";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(90)
    public void testExec_Kj_001_90() {

        String postalCd = "0010029";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(100)
    public void testExec_Kj_001_100() {

        String postalCd = "0010030";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(110)
    public void testExec_Kj_001_110() {

        String postalCd = "0010031";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(120)
    public void testExec_Kj_001_120() {

        String postalCd = "0010032";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(130)
    public void testExec_Kj_001_130() {

        String postalCd = "0010033";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(140)
    public void testExec_Kj_001_140() {

        String postalCd = "0010034";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(150)
    public void testExec_Kj_001_150() {

        String postalCd = "0010035";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北２７条西", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(160)
    public void testExec_Kj_001_160() {

        String postalCd = "0010036";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "８９", "住所（漢字）３");
    }

    @Test
    @TestOrder(170)
    public void testExec_Kj_001_170() {

        String postalCd = "0010037";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(180)
    public void testExec_Kj_001_180() {

        String postalCd = "0010038";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５６",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(190)
    public void testExec_Kj_001_190() {

        String postalCd = "0010039";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７８",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "９０", "住所（漢字）３");
    }

    @Test
    @TestOrder(200)
    public void testExec_Kj_001_200() {

        String postalCd = "0010040";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７８",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }

    @Test
    @TestOrder(210)
    public void testExec_Kj_001_210() {

        String postalCd = "0010041";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "海道札幌市北区北２７条西１２３４５６７８９０１２３４５６",
            "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
    @Test
    @TestOrder(220)
    public void testExec_Kj_001_220() {

        String postalCd = "0010042";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区北２７条西", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
    @Test
    @TestOrder(230)
    public void testExec_Kj_001_230() {

        String postalCd = "0010043";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区北２７条西", "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
    @Test
    @TestOrder(240)
    public void testExec_Kj_001_240() {

        String postalCd = "0010044";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７",
            "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "８９０１", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
    @Test
    @TestOrder(250)
    public void testExec_Kj_001_250() {

        String postalCd = "0010045";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５６７",
            "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
    @Test
    @TestOrder(260)
    public void testExec_Kj_001_260() {

        String postalCd = "0010046";

        bzGetAdrData.execAdrKanjiByPostalcd(postalCd);

        exClassificationEquals(bzGetAdrData.getErrorKbn(), C_ErrorKbn.OK, "エラー区分");
        exStringEquals(bzGetAdrData.getAdrKanji1(), "北海道札幌市北区北２７条西１２３４５６７８９０１２３４５",
            "住所（漢字）１");
        exStringEquals(bzGetAdrData.getAdrKanji2(), "", "住所（漢字）２");
        exStringEquals(bzGetAdrData.getAdrKanji3(), "", "住所（漢字）３");
    }
}
