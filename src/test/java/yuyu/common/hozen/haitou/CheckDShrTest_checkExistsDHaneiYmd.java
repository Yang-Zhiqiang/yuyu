package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当支払チェッククラスのメソッド {@link CheckDShr#checkExistsDHaneiYmd(String , BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDShrTest_checkExistsDHaneiYmd {

    private C_ErrorKbn errorKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当支払チェック";

    private final static String sheetName = "INデータ";

    @Inject
    CheckDShr checkDShr;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(CheckDShrTest_checkExistsDHaneiYmd.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHaitouKanri());
        hozenDomManager.delete(hozenDomManager.getAllKhTumitateDKanri());
    }

    @Test
    @TestOrder(10)
    public void testCheckExistsDHaneiYmd_A1() {

        errorKbn = checkDShr.checkExistsDHaneiYmd(null, BizDate.valueOf(20181130));

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), null, "配当金反映日有無");

    }

    @Test
    @TestOrder(20)
    public void testCheckExistsDHaneiYmd_A2() {

        errorKbn = checkDShr.checkExistsDHaneiYmd("", BizDate.valueOf(20181130));

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), null, "配当金反映日有無");

    }

    @Test
    @TestOrder(30)
    public void testCheckExistsDHaneiYmd_A3() {

        errorKbn = checkDShr.checkExistsDHaneiYmd("11807111185", null);

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), null, "配当金反映日有無");

    }

    @Test
    @TestOrder(40)
    public void testCheckExistsDHaneiYmd_A4() {

        errorKbn = checkDShr.checkExistsDHaneiYmd(null, null);

        exClassificationEquals( errorKbn, C_ErrorKbn.ERROR, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "入力エラー", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "必須の入力項目にnullが含まれる", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), null, "配当金反映日有無");

    }


    @Test
    @TestOrder(50)
    public void testCheckExistsDHaneiYmd_A5() {

        errorKbn = checkDShr.checkExistsDHaneiYmd("11807111185", BizDate.valueOf(20181130));

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), C_UmuKbn.NONE, "配当金反映日有無");

    }

    @Test
    @TestOrder(60)
    public void testCheckExistsDHaneiYmd_A6() {

        errorKbn = checkDShr.checkExistsDHaneiYmd("11807111336", BizDate.valueOf(20181130));

        exClassificationEquals( errorKbn, C_ErrorKbn.OK, "結果区分");
        List<HaitouErrorInfo> HaitouErrorInfoLst = checkDShr.getErrorInfo();

        exNumericEquals(HaitouErrorInfoLst.size(), 1, "エラー情報のサイズ");
        exStringEquals(HaitouErrorInfoLst.get(0).getKinouId(), checkDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(HaitouErrorInfoLst.get(0).getErrorInfo2(), "NoError", "エラー情報２（小分類）");
        exClassificationEquals( checkDShr.getDHaneiYmdUmu(), C_UmuKbn.ARI, "配当金反映日有無");

    }
}
