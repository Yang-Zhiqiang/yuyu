package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#getConvYmdBizDate()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_getConvYmdBizDate {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmdBizDate_A1() {

        bzRenkeiHenkanUtil.convYmdNullToZero(BizDate.valueOf("20160102"));

        exDateEquals(bzRenkeiHenkanUtil.getConvYmdBizDate()
                , BizDate.valueOf("20160102")
                , "メンバ変数．年月日変換情報（日付）");
    }
}
