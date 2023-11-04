package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 契約保全 配当 配当共通ＤＢアクセス 基準日直前配当管理情報取得（主契約）
 * {@link DBAccessDCommon#getKijyunymdTykzenHaitouKanriSyu(String, BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getKijyunymdTykzenHaitouKanriSyu {

    @Test
    @TestOrder(10)
    public void testGetKijyunymdTykzenHaitouKanriSyu_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getKijyunymdTykzenHaitouKanriSyu(null, BizDate.valueOf(20180823));

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testGetKijyunymdTykzenHaitouKanriSyu_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getKijyunymdTykzenHaitouKanriSyu("18806000058", null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testGetKijyunymdTykzenHaitouKanriSyu_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getKijyunymdTykzenHaitouKanriSyu("18806000069", BizDate.valueOf(20180823));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanri());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testGetKijyunymdTykzenHaitouKanriSyu_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getKijyunymdTykzenHaitouKanriSyu("18806000058", BizDate.valueOf(20180823));

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommon.getKhHaitouKanri();
        exStringEquals(khHaitouKanri.getSyono(), "18806000058", "証券番号");
        exDateYEquals(khHaitouKanri.getHaitounendo(), BizDateY.valueOf(2013), "配当年度");
        exNumericEquals(khHaitouKanri.getRenno(), 10, "連番");
        exClassificationEquals(khHaitouKanri.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE2, "配当金作成区分");
        exClassificationEquals(khHaitouKanri.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }
}

