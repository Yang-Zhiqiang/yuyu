package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
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
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 配当 配当共通ＤＢアクセス（減額） 配当情報追加 {@link DBAccessDCommonGengaku#insertHaitouInfo(BizDate,
 * BizCurrency, BizCurrency, BizCurrency, KhHaitouKanriKeyinfoBean, KhozenCommonParam)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DBAccessDCommonGengakuTest_insertHaitouInfo {

    @Inject
    private BaseUserInfo baseUserInfo;

    @Test
    @TestOrder(10)
    public void testInsertHaitouInfo_A1() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(null, BizCurrency.valueOf(101),
            BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(20)
    public void testInsertHaitouInfo_A2() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);
        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126), null,
            BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(30)
    public void testInsertHaitouInfo_A3() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), null, BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(40)
    public void testInsertHaitouInfo_A4() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), null, khHaitouKanriKeyinfoBean, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(50)
    public void testInsertHaitouInfo_A5() {

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(60)
    public void testInsertHaitouInfo_A6() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), null, khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(70)
    public void testInsertHaitouInfo_A7() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono(null);
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "入力値エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "入力項目にnullが含まれる", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(80)
    public void testInsertHaitouInfo_A8() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000184");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.BLNK);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(90)
    public void testInsertHaitouInfo_A9() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000195");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.BLNK);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "エラー区分");
        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "レコード追加時エラー", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "計算元レコードと最新レコードが一致しない", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(100)
    public void testInsertHaitouInfo_A10() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000209");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.SEISIKI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18806000209", BizDateY.valueOf(2015),
            2, C_HaitoukinsksKbn.SEISIKI, C_HaitoumeisaiKbn.SYU);

        assertNull(khHaitouKanriResult);

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @TestOrder(110)
    public void testInsertHaitouInfo_A11() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000210");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.YENDTHNKSEISIKI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18806000210", BizDateY.valueOf(2015),
            2, C_HaitoukinsksKbn.YENDTHNKSEISIKI, C_HaitoumeisaiKbn.SYU);

        assertNull(khHaitouKanriResult);

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testInsertHaitouInfo_A12() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("18806000221");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIDSIHARAI);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("18806000221", BizDateY.valueOf(2015),
            2, C_HaitoukinsksKbn.KARIDSIHARAI, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exClassificationEquals(khHaitouKanriResult.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult.getKariwariatedshrymd(), BizDate.valueOf(20181126), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedruigk(), BizCurrency.valueOf(101), "仮割当Ｄ累計額");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedgngkkngk(), BizCurrency.valueOf(102), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedshrgk(), BizCurrency.valueOf(103), "仮割当Ｄ支払額");
        exStringEquals(khHaitouKanriResult.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommonGengaku.getKhHaitouKanri();
        exStringEquals(khHaitouKanri.getKbnkey(), "02", "区分キー");
        exStringEquals(khHaitouKanri.getSyono(), "18806000221", "証券番号");
        exDateYEquals(khHaitouKanri.getHaitounendo(), BizDateY.valueOf(2015), "配当年度");
        exNumericEquals(khHaitouKanri.getRenno(), 2, "連番");
        exClassificationEquals(khHaitouKanri.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIDSIHARAI, "配当金作成区分");
        exClassificationEquals(khHaitouKanri.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(khHaitouKanri.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exClassificationEquals(khHaitouKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanri.getKariwariatedshrymd(), BizDate.valueOf(20181126), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedruigk(), BizCurrency.valueOf(101), "仮割当Ｄ累計額");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedgngkkngk(), BizCurrency.valueOf(102), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedshrgk(), BizCurrency.valueOf(103), "仮割当Ｄ支払額");
        exStringEquals(khHaitouKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testInsertHaitouInfo_A13() {

        baseUserInfo.getUser().setUserId("user001");

        DBAccessDCommonGengaku dbAccessDCommonGengaku = SWAKInjector.getInstance(DBAccessDCommonGengaku.class);

        KhHaitouKanriKeyinfoBean khHaitouKanriKeyinfoBean = SWAKInjector.getInstance(KhHaitouKanriKeyinfoBean.class);

        khHaitouKanriKeyinfoBean.setSyono("60806000011");
        khHaitouKanriKeyinfoBean.setHaitounendo(BizDateY.valueOf(2015));
        khHaitouKanriKeyinfoBean.setRenno(1);
        khHaitouKanriKeyinfoBean.setHaitoukinsksKbn(C_HaitoukinsksKbn.KARIWARIATE1);
        khHaitouKanriKeyinfoBean.setHaitoumeisaiKbn(C_HaitoumeisaiKbn.SYU);

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("kinoutest");

        C_ErrorKbn errorKbn = dbAccessDCommonGengaku.insertHaitouInfo(BizDate.valueOf(20181126),
            BizCurrency.valueOf(101), BizCurrency.valueOf(102), BizCurrency.valueOf(103), khHaitouKanriKeyinfoBean,
            khozenCommonParam);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "エラー区分");

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KhHaitouKanri khHaitouKanriResult = hozenDomManager.getKhHaitouKanri("60806000011", BizDateY.valueOf(2015),
            2, C_HaitoukinsksKbn.KARIDSIHARAI, C_HaitoumeisaiKbn.SYU);
        exDateYEquals(khHaitouKanriResult.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exClassificationEquals(khHaitouKanriResult.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanriResult.getKariwariatedshrymd(), BizDate.valueOf(20181126), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedruigk(), BizCurrency.valueOf(101), "仮割当Ｄ累計額");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedgngkkngk(), BizCurrency.valueOf(102), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(khHaitouKanriResult.getKariwariatedshrgk(), BizCurrency.valueOf(103), "仮割当Ｄ支払額");
        exStringEquals(khHaitouKanriResult.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanriResult.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

        HaitouErrorInfo haitouErrorInfo = dbAccessDCommonGengaku.getErrorInfo().get(0);
        exStringEquals(haitouErrorInfo.getKinouId(), dbAccessDCommonGengaku.getClass().getSimpleName(), "機能ID");
        exStringEquals(haitouErrorInfo.getErrorInfo1(), "NoError", "エラー情報１（大分類）");
        exStringEquals(haitouErrorInfo.getErrorInfo2(), "NoError", "エラー情報２（小分類）");

        IT_KhHaitouKanri khHaitouKanri = dbAccessDCommonGengaku.getKhHaitouKanri();
        exStringEquals(khHaitouKanri.getKbnkey(), "01", "区分キー");
        exStringEquals(khHaitouKanri.getSyono(), "60806000011", "証券番号");
        exDateYEquals(khHaitouKanri.getHaitounendo(), BizDateY.valueOf(2015), "配当年度");
        exNumericEquals(khHaitouKanri.getRenno(), 2, "連番");
        exClassificationEquals(khHaitouKanri.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIDSIHARAI, "配当金作成区分");
        exClassificationEquals(khHaitouKanri.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(khHaitouKanri.getFstkariwariatednendo(), BizDateY.valueOf(2014), "初回仮割当Ｄ年度");
        exClassificationEquals(khHaitouKanri.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.NAITEI, "内定確定区分");
        exDateEquals(khHaitouKanri.getKariwariatedshrymd(), BizDate.valueOf(20181126), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedruigk(), BizCurrency.valueOf(101), "仮割当Ｄ累計額");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedgngkkngk(), BizCurrency.valueOf(102), "仮割当Ｄ減額金額");
        exBizCalcbleEquals(khHaitouKanri.getKariwariatedshrgk(), BizCurrency.valueOf(103), "仮割当Ｄ支払額");
        exStringEquals(khHaitouKanri.getGyoumuKousinKinou(), "kinoutest", "業務用更新機能ＩＤ");
        exStringEquals(khHaitouKanri.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");

    }
}
