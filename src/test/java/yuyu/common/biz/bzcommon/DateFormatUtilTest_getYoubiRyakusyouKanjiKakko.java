package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの曜日取得処理{@link DateFormatUtil#getYoubiRyakusyouKanjiKakko(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_getYoubiRyakusyouKanjiKakko{
    private BizDate     dateBD;

    private String      result;

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @Test
    @TestOrder(710)
    public void testNormalParam15(){
        dateBD = BizDate.valueOf("20021103");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（日）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(720)
    public void testNormalParam16(){
        dateBD = BizDate.valueOf("20021104");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（月）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(730)
    public void testNormalParam17(){
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（火）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(740)
    public void testNormalParam18(){
        dateBD = BizDate.valueOf("20021106");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（水）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(750)
    public void testNormalParam19(){
        dateBD = BizDate.valueOf("20021107");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（木）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(760)
    public void testNormalParam20(){
        dateBD = BizDate.valueOf("20021108");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（金）", "曜日取得処理結果");
    }

    @Test
    @TestOrder(770)
    public void testNormalParam21(){
        dateBD = BizDate.valueOf("20021109");

        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
        exStringEquals(result, "（土）", "曜日取得処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(780)
    public void testIllegalParam57(){
        dateBD = null;
        result = DateFormatUtil.getYoubiRyakusyouKanjiKakko(dateBD);
    }

}