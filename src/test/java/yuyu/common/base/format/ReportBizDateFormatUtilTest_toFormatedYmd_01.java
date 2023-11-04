package yuyu.common.base.format;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * ReportBizDateFormatUtilTestクラスの、<br />
 * toFormatedYmd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class ReportBizDateFormatUtilTest_toFormatedYmd_01{

    @Test(expected = Exception.class)
    public void test001(){

        BizDate pBizDate = BizDate.valueOf("");
        BizDateFormatUtil.toFormatedYmd(pBizDate);
    }
}
