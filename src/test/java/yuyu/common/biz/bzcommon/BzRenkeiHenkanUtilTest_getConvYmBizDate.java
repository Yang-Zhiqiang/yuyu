package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#getConvYmBizDate(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_getConvYmBizDate {

    @Inject
    private BzRenkeiHenkanUtil<?, ?> bzRenkeiHenkanUtil;

    @Test
    @TestOrder(10)
    public void testConvYmBizDate_A1() {

        bzRenkeiHenkanUtil.convYmNullToZero(BizDateYM.valueOf("201601"));

        exDateYMEquals(bzRenkeiHenkanUtil.getConvYmBizDate()
                , BizDateYM.valueOf("201601")
                , "メンバ変数．年月日変換情報（日付）");
    }
}
