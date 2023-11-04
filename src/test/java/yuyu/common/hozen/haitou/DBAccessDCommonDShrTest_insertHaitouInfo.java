package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（配当金支払） 配当情報追加 {@link DBAccessDCommonDShr#insertHaitouInfo(
 * BizDate, BizCurrency, KhTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn, KhozenCommonParam)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonDShrTest_insertHaitouInfo {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testInsertHaitouInfo_A1() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000298");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(null, BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ZENHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testInsertHaitouInfo_A2() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000298");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), null,
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ZENHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testInsertHaitouInfo_A3() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            null, C_TumitateDSakuseiKbn.ZENHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testInsertHaitouInfo_A4() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000298");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testInsertHaitouInfo_A5() {

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000265");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(1);

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ZENHIKIDASI, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(60)
    public void testInsertHaitouInfo_A6() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000298");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.SEISIKI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "積立Ｄ作成区分不正", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(70)
    public void testInsertHaitouInfo_A7() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono(null);
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ZENHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(80)
    public void testInsertHaitouInfo_A8() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000298");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ITIBUHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(90)
    public void testInsertHaitouInfo_A9() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000302");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ZENHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testInsertHaitouInfo_A10() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonDShr dbAccessDCommonDShr = SWAKInjector.getInstance(DBAccessDCommonDShr.class);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000313");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20180928));
        khTumitateDKanriKeyinfoBean.setRenno(5);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonDShr.insertHaitouInfo(BizDate.valueOf(20181210), BizCurrency.valueOf(301),
            khTumitateDKanriKeyinfoBean, C_TumitateDSakuseiKbn.ITIBUHIKIDASI, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonDShr.getErrorInfo().get(0);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhTumitateDKanri khTumitateDKanri = hozenDomManager.getKhTumitateDKanri("18806000313",
            BizDate.valueOf(20180928), 6);
        exClassificationEquals(khTumitateDKanri.getTumitatedskskbn(), C_TumitateDSakuseiKbn.ITIBUHIKIDASI, "積立Ｄ作成区分");
        exBizCalcbleEquals(khTumitateDKanri.getTumitated(), BizCurrency.valueOf(301), "積立Ｄ");
        exClassificationEquals(khTumitateDKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exStringEquals(khTumitateDKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khTumitateDKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonDShr.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }
}
