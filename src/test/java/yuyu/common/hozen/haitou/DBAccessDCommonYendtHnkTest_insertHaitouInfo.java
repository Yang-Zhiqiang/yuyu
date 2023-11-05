package yuyu.common.hozen.haitou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（円建変更） 配当情報追加 {@link DBAccessDCommonYendtHnk#insertHaitouInfo(String,
 * BizDate, BizCurrency, BizCurrency, BizCurrency, C_NaiteiKakuteiKbn, BizDateY, KhHaitouKanriKeyinfoBean,
 * KhTumitateDKanriKeyinfoBean, KhozenCommonParam)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonYendtHnkTest_insertHaitouInfo {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testInsertHaitouInfo_A1() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo(null, BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testInsertHaitouInfo_A2() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", null,
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testInsertHaitouInfo_A3() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            null, BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testInsertHaitouInfo_A4() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), null, BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testInsertHaitouInfo_A5() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), null, C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(60)
    public void testInsertHaitouInfo_A6() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), null,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(70)
    public void testInsertHaitouInfo_A7() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            null, null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(80)
    public void testInsertHaitouInfo_A8() {

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), null, null, null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(90)
    public void testInsertHaitouInfo_A9() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono(null);
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.BLNK);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(100)
    public void testInsertHaitouInfo_A10() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000232");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.BLNK);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(110)
    public void testInsertHaitouInfo_A11() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000243");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.BLNK);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000232", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(120)
    public void testInsertHaitouInfo_A12() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000254");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(2);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono(null);
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(1);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000254", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, khTumitateDKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(130)
    public void testInsertHaitouInfo_A13() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000265");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(2);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000265");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(1);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000265", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, khTumitateDKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(140)
    public void testInsertHaitouInfo_A14() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000276");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(2);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000276");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(1);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000276", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, khTumitateDKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testInsertHaitouInfo_A15() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000287");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(2);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("18806000287");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(2);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000287", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, khTumitateDKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult1 = hozenDomManager.getKhHaitouKanri("18806000287", BizDateY.valueOf(2015),
            3, C_HaitoukinsksKbn.YENDTHNKKARIWARIATE, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult1.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult1.getTounendod(), BizCurrency.valueOf(201), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult1.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult1.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanriResult1.getKariwariatedruigk(), BizCurrency.valueOf(202), "仮割当Ｄ累計額");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhHaitouKanri khHaitouKanriResult2 = hozenDomManager.getKhHaitouKanri("18806000287", BizDateY.valueOf(2015),
            4, C_HaitoukinsksKbn.YENDTHNKSEISIKI, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult2.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult2.getTounendod(), BizCurrency.valueOf(202), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult2.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult2.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhTumitateDKanri khTumitateDKanri = hozenDomManager.getKhTumitateDKanri("18806000287",
            BizDate.valueOf(20181101), 1);
        exClassificationEquals(khTumitateDKanri.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI, "積立Ｄ作成区分");
        exBizCalcbleEquals(khTumitateDKanri.getTumitated(), BizCurrency.valueOf(203), "積立Ｄ");
        exClassificationEquals(khTumitateDKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exStringEquals(khTumitateDKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khTumitateDKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testInsertHaitouInfo_A16() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("18806000298", BizDate.valueOf(20181101),
            BizCurrency.valueOf(201), BizCurrency.valueOf(202), BizCurrency.valueOf(203), C_NaiteiKakuteiKbn.NAITEI,
            BizDateY.valueOf(2015), null, null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult1 = hozenDomManager.getKhHaitouKanri("18806000298", BizDateY.valueOf(2015),
            1, C_HaitoukinsksKbn.YENDTHNKKARIWARIATE, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult1.getFstkariwariatednendo(), BizDateY.valueOf(2015), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult1.getTounendod(), BizCurrency.valueOf(201), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult1.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult1.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanriResult1.getKariwariatedruigk(), BizCurrency.valueOf(202), "仮割当Ｄ累計額");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhHaitouKanri khHaitouKanriResult2 = hozenDomManager.getKhHaitouKanri("18806000298", BizDateY.valueOf(2015),
            2, C_HaitoukinsksKbn.YENDTHNKSEISIKI, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult2.getFstkariwariatednendo(), BizDateY.valueOf(2015), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult2.getTounendod(), BizCurrency.valueOf(0), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult2.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult2.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhTumitateDKanri khTumitateDKanri = hozenDomManager.getKhTumitateDKanri("18806000298",
            BizDate.valueOf(20181101), 1);
        exClassificationEquals(khTumitateDKanri.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI, "積立Ｄ作成区分");
        exBizCalcbleEquals(khTumitateDKanri.getTumitated(), BizCurrency.valueOf(203), "積立Ｄ");
        exClassificationEquals(khTumitateDKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exStringEquals(khTumitateDKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khTumitateDKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testInsertHaitouInfo_A17() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonYendtHnk dbAccessDCommonYendtHnk = SWAKInjector.getInstance(DBAccessDCommonYendtHnk.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("58806209084");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(2);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhTumitateDKanriKeyinfoBean khTumitateDKanriKeyinfoBean = SWAKInjector.getInstance(KhTumitateDKanriKeyinfoBean.class);
        khTumitateDKanriKeyinfoBean.setSyono("58806209084");
        khTumitateDKanriKeyinfoBean.setTumitatedtumitateymd(BizDate.valueOf(20181010));
        khTumitateDKanriKeyinfoBean.setRenno(2);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonYendtHnk.insertHaitouInfo("58806209084", BizDate.valueOf(20181101),
            BizCurrency.valueOf(-1000), BizCurrency.valueOf(-1000), BizCurrency.valueOf(0), C_NaiteiKakuteiKbn.KAKUTEI,
            BizDateY.valueOf(2015), khHaitouKanriKeyinfoBean, khTumitateDKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult1 = hozenDomManager.getKhHaitouKanri("58806209084", BizDateY.valueOf(2015),
            3, C_HaitoukinsksKbn.YENDTHNKKARIWARIATE, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult1.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult1.getTounendod(), BizCurrency.valueOf(-1000), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult1.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult1.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanriResult1.getKariwariatedruigk(), BizCurrency.valueOf(-1000), "仮割当Ｄ累計額");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult1.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhHaitouKanri khHaitouKanriResult2 = hozenDomManager.getKhHaitouKanri("58806209084", BizDateY.valueOf(2015),
            4, C_HaitoukinsksKbn.YENDTHNKSEISIKI, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult2.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(khHaitouKanriResult2.getTounendod(), BizCurrency.valueOf(0), "当年度Ｄ");
        exClassificationEquals(khHaitouKanriResult2.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult2.getKariwariatedshrymd(), BizDate.valueOf(20181101), "仮割当Ｄ支払年月日");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult2.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        IT_KhTumitateDKanri khTumitateDKanri = hozenDomManager.getKhTumitateDKanri("58806209084",
            BizDate.valueOf(20181101), 1);
        exClassificationEquals(khTumitateDKanri.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI, "積立Ｄ作成区分");
        exBizCalcbleEquals(khTumitateDKanri.getTumitated(), BizCurrency.valueOf(0), "積立Ｄ");
        exClassificationEquals(khTumitateDKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exStringEquals(khTumitateDKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khTumitateDKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonYendtHnk.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonYendtHnk.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

}
