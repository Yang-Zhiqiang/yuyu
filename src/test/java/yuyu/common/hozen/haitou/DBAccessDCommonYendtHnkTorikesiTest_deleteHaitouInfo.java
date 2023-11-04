package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（円建変更取消） 配当情報削除 {@link DBAccessDCommonYendtHnkTorikesi#deleteHaitouInfo(
 * String)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonYendtHnkTorikesiTest_deleteHaitouInfo {

    @Test
    @TestOrder(10)
    public void testDeleteHaitouInfo_A1() {

        DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(DBAccessDCommonYendtHnkTorikesi.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnkTorikesi.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnkTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testDeleteHaitouInfo_A2() {

        DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(DBAccessDCommonYendtHnkTorikesi.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo("18806000324");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnkTorikesi.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnkTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード削除時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "削除対象のレコード件数が不正", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testDeleteHaitouInfo_A3() {

        DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(DBAccessDCommonYendtHnkTorikesi.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo("18806000335");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnkTorikesi.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnkTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード削除時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "削除対象のレコード件数が不正", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testDeleteHaitouInfo_A4() {

        DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(DBAccessDCommonYendtHnkTorikesi.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo("18806000346");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHaitouKanri> KhHaitouKanriList = hozenDomManager.getKhHaitouKanriBySyono("18806000346");
        exNumericEquals(KhHaitouKanriList.size(), 0, "件数");

        List<IT_KhTumitateDKanri> khTumitateDKanriList = hozenDomManager.getKhTumitateDKanriBySyono("18806000346");
        exNumericEquals(khTumitateDKanriList.size(), 0, "件数");

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnkTorikesi.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnkTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testDeleteHaitouInfo_A5() {

        DBAccessDCommonYendtHnkTorikesi dbAccessDCommonYendtHnkTorikesi = SWAKInjector.getInstance(DBAccessDCommonYendtHnkTorikesi.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnkTorikesi.deleteHaitouInfo("18806000357");

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhHaitouKanri> KhHaitouKanriList = hozenDomManager.getKhHaitouKanriBySyono("18806000357");
        exNumericEquals(KhHaitouKanriList.size(), 0, "件数");

        List<IT_KhTumitateDKanri> khTumitateDKanriList = hozenDomManager.getKhTumitateDKanriBySyono("18806000357");
        exNumericEquals(khTumitateDKanriList.size(), 0, "件数");

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnkTorikesi.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnkTorikesi.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

}
