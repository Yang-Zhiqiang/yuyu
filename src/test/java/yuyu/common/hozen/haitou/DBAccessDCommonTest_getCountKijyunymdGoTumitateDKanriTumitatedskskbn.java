package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス 基準日後積立Ｄ管理情報件数取得（積立Ｄ作成区分指定）
 * {@link DBAccessDCommon#getCountKijyunymdGoTumitateDKanriTumitatedskskbn(String, C_TumitateDSakuseiKbn[], BizDate)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getCountKijyunymdGoTumitateDKanriTumitatedskskbn {

    @Test
    @TestOrder(10)
    public void testGetCountKijyunymdGoTumitateDKanriTumitatedskskbn_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn(null,
            tumitateDSakuseiKbn, BizDate.valueOf(20180830));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanriCount());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testGetCountKijyunymdGoTumitateDKanriTumitatedskskbn_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn("18806000117",null,
            BizDate.valueOf(20180830));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanriCount());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testGetCountKijyunymdGoTumitateDKanriTumitatedskskbn_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn("18806000117",
            tumitateDSakuseiKbn, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhTumitateDKanriCount());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testGetCountKijyunymdGoTumitateDKanriTumitatedskskbn_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn("18806000106",
            tumitateDSakuseiKbn, BizDate.valueOf(20180830));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(dbAccessDCommon.getKhTumitateDKanriCount(), 0, "積立Ｄ管理ＴＢＬエンティティ件数");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testGetCountKijyunymdGoTumitateDKanriTumitatedskskbn_A5() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_TumitateDSakuseiKbn[] tumitateDSakuseiKbn = new C_TumitateDSakuseiKbn[] {
            C_TumitateDSakuseiKbn.RISOKUKURIIRE, C_TumitateDSakuseiKbn.SEISIKI };

        C_ErrorKbn errorKbn = dbAccessDCommon.getCountKijyunymdGoTumitateDKanriTumitatedskskbn("18806000117",
            tumitateDSakuseiKbn, BizDate.valueOf(20180830));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        exNumericEquals(dbAccessDCommon.getKhTumitateDKanriCount(), 3, "積立Ｄ管理ＴＢＬエンティティ件数");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

}
