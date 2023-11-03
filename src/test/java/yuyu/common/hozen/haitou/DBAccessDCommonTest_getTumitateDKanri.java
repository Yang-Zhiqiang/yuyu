package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 積立Ｄ管理情報取得（項目指定）{@link DBAccessDCommon#getTumitateDKanri(
 * String, BizDate, Integer)} {@link DBAccessDCommon#getTumitateDKanri(KhTumitateDKanriKeyinfoBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getTumitateDKanri {

    @Test
    @TestOrder(10)
    public void testGetTumitateDKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri(null, BizDate.valueOf(20180301), 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testGetTumitateDKanri_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri("18806000014", null, 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testGetTumitateDKanri_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri("18806000014", BizDate.valueOf(20180301), null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testGetTumitateDKanri_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri("18806000014", BizDate.valueOf(20180301), 10);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhTumitateDKanri khTumitateDKanri = dbAccessDCommon.getKhTumitateDKanri();
        exStringEquals(khTumitateDKanri.getSyono(), "18806000014", "証券番号");
        exDateEquals(khTumitateDKanri.getTumitatedtumitateymd(), BizDate.valueOf(20180301), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri.getRenno(), 10, "連番");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(50)
    public void testGetTumitateDKanri_B1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(60)
    public void testGetTumitateDKanri_B2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono(null);
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180301));
        khTumitateDKanriKeyinfoBean.setRenno(10);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri(khTumitateDKanriKeyinfoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(70)
    public void testGetTumitateDKanri_B3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000014");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180301));
        khTumitateDKanriKeyinfoBean.setRenno(10);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanri(khTumitateDKanriKeyinfoBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhTumitateDKanri khTumitateDKanri = dbAccessDCommon.getKhTumitateDKanri();
        exStringEquals(khTumitateDKanri.getSyono(), "18806000014", "証券番号");
        exDateEquals(khTumitateDKanri.getTumitatedtumitateymd(), BizDate.valueOf(20180301), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri.getRenno(), 10, "連番");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }
}