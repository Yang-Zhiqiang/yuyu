package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 配当管理情報取得（項目指定）{@link DBAccessDCommon#getHaitouKanri(String, C_Hrkkaisuu,
 * Integer, C_HrkkknsmnKbn, Integer, C_HasuusyoriKbn)} {@link DBAccessDCommon#getHaitouKanri(KhHaitouKanriKeyinfoBean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getHaitouKanri {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_配当共通ＤＢアクセス";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DBAccessDCommonTest_getHaitouKanri.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void testGetHaitouKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            null, BizDateY.valueOf(2015), 1, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testGetHaitouKanri_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            "18806000014", null, 1, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testGetHaitouKanri_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            "18806000014", BizDateY.valueOf(2015), null, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testGetHaitouKanri_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            "18806000014", BizDateY.valueOf(2015), 1, null, C_HaitoumeisaiKbn.SYU);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testGetHaitouKanri_A5() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            "18806000014", BizDateY.valueOf(2015), 1, C_HaitoukinsksKbn.KARIWARIATE2, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(60)
    public void testGetHaitouKanri_A6() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(
            "18806000014", BizDateY.valueOf(2015), 1, C_HaitoukinsksKbn.KARIWARIATE2, C_HaitoumeisaiKbn.SYU);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommon.getKhHaitouKanri();
        exStringEquals(khHaitouKanri.getSyono(), "18806000014", "証券番号");
        exDateYEquals(khHaitouKanri.getHaitounendo(), BizDateY.valueOf(2015), "配当年度");
        exNumericEquals(khHaitouKanri.getRenno(), 1, "連番");
        exClassificationEquals(khHaitouKanri.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE2, "配当金作成区分");
        exClassificationEquals(khHaitouKanri.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(70)
    public void testGetHaitouKanri_B1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(80)
    public void testGetHaitouKanri_B2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono(null);
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE2);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(khHaitouKanriKeyinfoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(90)
    public void testGetHaitouKanri_B3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000014");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE2);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanri(khHaitouKanriKeyinfoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommon.getKhHaitouKanri();
        exStringEquals(khHaitouKanri.getSyono(), "18806000014", "証券番号");
        exDateYEquals(khHaitouKanri.getHaitounendo(), BizDateY.valueOf(2015), "配当年度");
        exNumericEquals(khHaitouKanri.getRenno(), 1, "連番");
        exClassificationEquals(khHaitouKanri.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE2, "配当金作成区分");
        exClassificationEquals(khHaitouKanri.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

}