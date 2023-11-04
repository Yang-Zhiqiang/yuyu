package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
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
 * 契約保全 配当 配当共通ＤＢアクセス 配当管理情報リスト取得（主契約、配当金作成区分指定）
 * {@link DBAccessDCommon#getHaitouKanriListSyuHaitoukinskskbn(String, C_HaitoukinsksKbn[])} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonTest_getHaitouKanriListSyuHaitoukinskskbn {

    @Test
    @TestOrder(10)
    public void testGetHaitouKanriListSyuHaitoukinskskbn_A1() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_HaitoukinsksKbn[] haitoukinsksKbn = new C_HaitoukinsksKbn[] { C_HaitoukinsksKbn.KARIWARIATE3,
            C_HaitoukinsksKbn.KARIWARIATE4 };

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanriListSyuHaitoukinskskbn(null, haitoukinsksKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanriList());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(20)
    public void testGetHaitouKanriListSyuHaitoukinskskbn_A2() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanriListSyuHaitoukinskskbn("18806000081", null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanriList());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(30)
    public void testGetHaitouKanriListSyuHaitoukinskskbn_A3() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_HaitoukinsksKbn[] haitoukinsksKbn = new C_HaitoukinsksKbn[] { C_HaitoukinsksKbn.KARIWARIATE3,
            C_HaitoukinsksKbn.KARIWARIATE4 };

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanriListSyuHaitoukinskskbn("18806000070", haitoukinsksKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        assertNull(dbAccessDCommon.getKhHaitouKanriList());
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }

    @Test
    @TestOrder(40)
    public void testGetHaitouKanriListSyuHaitoukinskskbn_A4() {

        DBAccessDCommon dbAccessDCommon = SWAKInjector.getInstance(DBAccessDCommon.class);

        C_HaitoukinsksKbn[] haitoukinsksKbn = new C_HaitoukinsksKbn[] { C_HaitoukinsksKbn.KARIWARIATE3,
            C_HaitoukinsksKbn.KARIWARIATE4 };

        C_ErrorKbn errorKbn = dbAccessDCommon.getHaitouKanriListSyuHaitoukinskskbn("18806000081", haitoukinsksKbn);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        List<IT_KhHaitouKanri> khHaitouKanriList = dbAccessDCommon.getKhHaitouKanriList();
        exNumericEquals(khHaitouKanriList.size(), 3, "件数");
        IT_KhHaitouKanri khHaitouKanri1 = khHaitouKanriList.get(0);
        exStringEquals(khHaitouKanri1.getSyono(), "18806000081", "証券番号");
        exDateYEquals(khHaitouKanri1.getHaitounendo(), BizDateY.valueOf(2013), "配当年度");
        exNumericEquals(khHaitouKanri1.getRenno(), 10, "連番");
        exClassificationEquals(khHaitouKanri1.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE4, "配当金作成区分");
        exClassificationEquals(khHaitouKanri1.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        IT_KhHaitouKanri khHaitouKanri2 = khHaitouKanriList.get(1);
        exStringEquals(khHaitouKanri2.getSyono(), "18806000081", "証券番号");
        exDateYEquals(khHaitouKanri2.getHaitounendo(), BizDateY.valueOf(2014), "配当年度");
        exNumericEquals(khHaitouKanri2.getRenno(), 9, "連番");
        exClassificationEquals(khHaitouKanri2.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE3, "配当金作成区分");
        exClassificationEquals(khHaitouKanri2.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        IT_KhHaitouKanri khHaitouKanri3 = khHaitouKanriList.get(2);
        exStringEquals(khHaitouKanri3.getSyono(), "18806000081", "証券番号");
        exDateYEquals(khHaitouKanri3.getHaitounendo(), BizDateY.valueOf(2015), "配当年度");
        exNumericEquals(khHaitouKanri3.getRenno(), 10, "連番");
        exClassificationEquals(khHaitouKanri3.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE3, "配当金作成区分");
        exClassificationEquals(khHaitouKanri3.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommon.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommon.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");
    }
}
