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
 * 契約保全 配当 配当共通ＤＢアクセス 最新積立Ｄ管理情報取得
 * {@link DBAccessDCommon#getSaisinTumitateDKanri(String)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getSaisinTumitateDKanri {

    @Test
    @TestOrder(10)
    public void testGetSaisinTumitateDKanri_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getSaisinTumitateDKanri(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testGetSaisinTumitateDKanri_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getSaisinTumitateDKanri("18806000047");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testGetSaisinTumitateDKanri_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getSaisinTumitateDKanri("18806000014");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhTumitateDKanri khTumitateDKanri =dbAccessDCommon.getKhTumitateDKanri();
        exStringEquals(khTumitateDKanri.getSyono(), "18806000014", "証券番号");
        exDateEquals(khTumitateDKanri.getTumitatedtumitateymd(), BizDate.valueOf(20180301), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri.getRenno(), 10, "連番");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

}
