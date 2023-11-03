package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convYmNullToZero(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convYmNullToZero {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmNullToZero_A1() {

        bzRenkeiHenkanUtil.convYmNullToZero(null);

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate()
                , BizDateYM.valueOf("000000")
                , "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), "000000", "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testConvYmNullToZero_A2() {

        bzRenkeiHenkanUtil.convYmNullToZero(BizDateYM.valueOf("201601"));

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate()
                , BizDateYM.valueOf("201601")
                , "メンバ変数．年月日変換情報（日付）");
        exStringEquals(bzRenkeiHenkanUtil.getConvYmString(), "201601", "メンバ変数．年月日変換情報（文字列）");
        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }
}
