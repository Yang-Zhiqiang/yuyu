package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convYmdZeroToNull(Object)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convYmdZeroToNull {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmdZeroToNull_A1() {

        bzRenkeiHenkanUtil.convYmdZeroToNull(null);

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testConvYmdZeroToNull_A2() {

        bzRenkeiHenkanUtil.convYmdZeroToNull("");

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testConvYmdZeroToNull_A3() {

        bzRenkeiHenkanUtil.convYmdZeroToNull("00000000");

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testConvYmdZeroToNull_A4() {

        bzRenkeiHenkanUtil.convYmdZeroToNull("2015011");

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testConvYmdZeroToNull_A5() {

        bzRenkeiHenkanUtil.convYmdZeroToNull("20150101");

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate()
                , BizDate.valueOf("20150101")
                , "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), "20150101", "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testConvYmdZeroToNull_A6() {

        bzRenkeiHenkanUtil.convYmdZeroToNull("201501012");

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }
}
