package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ時間ユーティリティのメソッド {@link DsTimeUtil#hourMinSecChange()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsTimeUtilTest_hourMinSecChange {

    @Inject
    private DsTimeUtil dsTimeUtil;

    @Test
    @TestOrder(110)
    public void testHourMinSecChange_A1() {

        HourMinSecChangeBean hourMinSecChangeBean = dsTimeUtil.hourMinSecChange(9100);

        exNumericEquals(hourMinSecChangeBean.getHour(), 2, "時");
        exNumericEquals(hourMinSecChangeBean.getMin(), 31, "分");
        exNumericEquals(hourMinSecChangeBean.getSec(), 40, "秒");

    }
}
