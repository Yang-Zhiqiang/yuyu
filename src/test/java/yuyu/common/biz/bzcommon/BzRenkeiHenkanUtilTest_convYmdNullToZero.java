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
 * {@link BzRenkeiHenkanUtil#convYmdNullToZero(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convYmdNullToZero {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmdNullToZero_A1() {

        bzRenkeiHenkanUtil.convYmdNullToZero(null);

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate(), BizDate.MIN_VALUE, "メンバ変数．年月日変換情報（日付）");

        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString()
                , BizDate.MIN_VALUE.toString()
                , "メンバ変数．年月日変換情報（文字列）");

        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }

    @Test
    @TestOrder(20)
    public void testConvYmdNullToZero_A2() {

        bzRenkeiHenkanUtil.convYmdNullToZero(BizDate.valueOf("20160102"));

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate()
                , BizDate.valueOf("20160102")
                , "メンバ変数．年月日変換情報（日付）");

        exStringEquals(bzRenkeiHenkanUtil.getConvYmdString(), "20160102", "メンバ変数．年月日変換情報（文字列）");

        exClassificationEquals(bzRenkeiHenkanUtil.getErrorKbn(), C_ErrorKbn.OK, "メンバ変数．エラー区分");
    }
}
