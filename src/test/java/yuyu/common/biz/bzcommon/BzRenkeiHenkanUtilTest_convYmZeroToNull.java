package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convYmZeroToNull(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convYmZeroToNull {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmZeroToNull_A1() {

        bzRenkeiHenkanUtil.convYmZeroToNull(null);

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testConvYmZeroToNull_A2() {

        bzRenkeiHenkanUtil.convYmZeroToNull("");

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(30)
    public void testConvYmZeroToNull_A3() {

        bzRenkeiHenkanUtil.convYmZeroToNull("000000");

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate(), null, "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), null, "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(40)
    public void testConvYmZeroToNull_A4() {

        bzRenkeiHenkanUtil.convYmZeroToNull("20151");

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate(), null, "メンバ変数．年月日変換情報（日付）");

        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), null, "メンバ変数．年月日変換情報（文字列）");

        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(50)
    public void testConvYmZeroToNull_A5() {

        bzRenkeiHenkanUtil.convYmZeroToNull("201501");

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate()
                , BizDateYM.valueOf("201501")
                , "メンバ変数．年月日変換情報（日付）");

        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), "201501", "メンバ変数．年月日変換情報（文字列）");

        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(60)
    public void testConvYmZeroToNull_A6() {

        bzRenkeiHenkanUtil.convYmZeroToNull("2015011");

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate(), null, "メンバ変数．年月日変換情報（日付）");

        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), null, "メンバ変数．年月日変換情報（文字列）");

        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.ERROR, "メンバ変数．エラー区分");
    }
}
