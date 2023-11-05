package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 積立Ｄ管理情報リスト取得（積立Ｄ作成区分指定）
 * {@link DBAccessDCommon#getTumitateDKanriListTumitatedskskbn(String, C_TumitateDSakuseiKbn[])}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getTumitateDKanriListTumitatedskskbn {

    @Test
    @TestOrder(10)
    public void testGetTumitateDKanriListTumitatedskskbn_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanriListTumitatedskskbn(null, tumitateDSakuseiKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanriList());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testGetTumitateDKanriListTumitatedskskbn_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanriListTumitatedskskbn("18806000081", null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanriList());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testGetTumitateDKanriListTumitatedskskbn_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanriListTumitatedskskbn("18806000070", tumitateDSakuseiKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(dbAccessDCommon.getKhTumitateDKanriList().size(), 0, "件数");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testGetTumitateDKanriListTumitatedskskbn_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getTumitateDKanriListTumitatedskskbn("18806000081", tumitateDSakuseiKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        List<IT_KhTumitateDKanri> khTumitateDKanriList = dbAccessDCommon.getKhTumitateDKanriList();
        exNumericEquals(khTumitateDKanriList.size(), 3, "件数");
        IT_KhTumitateDKanri khTumitateDKanri1 =khTumitateDKanriList.get(0);
        exStringEquals(khTumitateDKanri1.getSyono(), "18806000081", "証券番号");
        exDateEquals(khTumitateDKanri1.getTumitatedtumitateymd(), BizDate.valueOf(20180301), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri1.getRenno(), 10, "連番");
        IT_KhTumitateDKanri khTumitateDKanri2 =khTumitateDKanriList.get(1);
        exStringEquals(khTumitateDKanri2.getSyono(), "18806000081", "証券番号");
        exDateEquals(khTumitateDKanri2.getTumitatedtumitateymd(), BizDate.valueOf(20180301), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri2.getRenno(), 9, "連番");
        IT_KhTumitateDKanri khTumitateDKanri3 =khTumitateDKanriList.get(2);
        exStringEquals(khTumitateDKanri3.getSyono(), "18806000081", "証券番号");
        exDateEquals(khTumitateDKanri3.getTumitatedtumitateymd(), BizDate.valueOf(20180228), "積立Ｄ積立年月日");
        exNumericEquals(khTumitateDKanri3.getRenno(), 10, "連番");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }
}
