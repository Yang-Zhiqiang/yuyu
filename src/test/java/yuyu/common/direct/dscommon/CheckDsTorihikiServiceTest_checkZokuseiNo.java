package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_DsZokuseinochkkekkaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ取引サービス共通チェッククラスのメソッド {@link CheckDsTorihikiService#checkZokuseiNo(String, BizDate, String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckDsTorihikiServiceTest_checkZokuseiNo {

    @Inject
    private CheckDsTorihikiService checkDsTorihikiService;

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1010)
    public void testCheckZokuseiNo_A1() {
        try {
            checkDsTorihikiService.checkZokuseiNo("12345", BizDate.valueOf(20180202), "101-2002-3003");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。暗証番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1020)
    public void testCheckZokuseiNo_A2() {
        try {
            checkDsTorihikiService.checkZokuseiNo("1234", null, "101-2002-3003");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。生年月日にnullが設定されています。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1030)
    public void testCheckZokuseiNo_A3() {
        try {
            checkDsTorihikiService.checkZokuseiNo("1234", BizDate.valueOf(19900531), "101-202-303-404");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。電話番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test
    @TestOrder(1040)
    public void testCheckZokuseiNo_A4() {

        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("0205",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1050)
    public void testCheckZokuseiNo_A5() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("0231",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1060)
    public void testCheckZokuseiNo_A6() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("1114",
            BizDate.valueOf(20021129), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1070)
    public void testCheckZokuseiNo_A7() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("2914",
            BizDate.valueOf(20021129), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1080)
    public void testCheckZokuseiNo_A8() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("1990",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1090)
    public void testCheckZokuseiNo_A9() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("9051",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1100)
    public void testCheckZokuseiNo_A10() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("9005",
            BizDate.valueOf(19900506), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1110)
    public void testCheckZokuseiNo_A11() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("9006",
            BizDate.valueOf(19900506), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1120)
    public void testCheckZokuseiNo_A12() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("0531",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1130)
    public void testCheckZokuseiNo_A13() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("3105",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.SEIYMD,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1140)
    public void testCheckZokuseiNo_A14() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("3003",
            BizDate.valueOf(19900531), "101-2003-003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(), C_DsZokuseinochkkekkaKbn.TELNO,
            "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1150)
    public void testCheckZokuseiNo_A15() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("2222",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(),
            C_DsZokuseinochkkekkaKbn.ZENKETADOUTI, "ＤＳ属性番号チェック結果区分");
    }

    @Test
    @TestOrder(1160)
    public void testCheckZokuseiNo_A16() {
        CheckZokuseinoResultBean checkZokuseinoResultBean = checkDsTorihikiService.checkZokuseiNo("2221",
            BizDate.valueOf(19900531), "101-2002-3003");

        exClassificationEquals(checkZokuseinoResultBean.getChkkekkaKbn(), C_ChkkekkaKbn.SEIJYOU, "チェック結果区分");
        exClassificationEquals(checkZokuseinoResultBean.getDsZokuseinochkkekkaKbn(),
            C_DsZokuseinochkkekkaKbn.BLNK, "ＤＳ属性番号チェック結果区分");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1170)
    public void testCheckZokuseiNo_A17() {
        try {
            checkDsTorihikiService.checkZokuseiNo("123", BizDate.valueOf(20180202), "101-2002-3003");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。暗証番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1180)
    public void testCheckZokuseiNo_A18() {
        try {
            checkDsTorihikiService.checkZokuseiNo("123a", BizDate.valueOf(20180202), "101-2002-3003");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。暗証番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1190)
    public void testCheckZokuseiNo_A19() {
        try {
            checkDsTorihikiService.checkZokuseiNo("", BizDate.valueOf(20180202), "101-2002-3003");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。暗証番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1200)
    public void testCheckZokuseiNo_A20() {
        try {
            checkDsTorihikiService.checkZokuseiNo("1234", BizDate.valueOf(20180202), "101-202-303");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。電話番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1210)
    public void testCheckZokuseiNo_A21() {
        try {
            checkDsTorihikiService.checkZokuseiNo("1234", BizDate.valueOf(20180202), "101-2002-aaa");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。電話番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1220)
    public void testCheckZokuseiNo_A22() {
        try {
            checkDsTorihikiService.checkZokuseiNo("1234", BizDate.valueOf(20180202), "");
        } catch (Exception e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。電話番号の数字・桁数が不正です。",
                "システムエラー");
            throw e;
        }
    }
}