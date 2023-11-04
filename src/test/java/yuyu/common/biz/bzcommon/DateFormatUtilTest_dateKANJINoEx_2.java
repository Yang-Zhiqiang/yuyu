package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集処理メソッド（String）{@link DateFormatUtil#dateKANJINoEx(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJINoEx_2{
    private String      dateStr;
    private String      result;

    private static SeirekiWarekiKbn sysSrkWrkKbn;
    private static final BizDateConfig bizDateConfig = BizDateConfig.getInstance();

    @Before
    public void resetDefaultVal(){
        this.result = null;
    }

    @BeforeClass
    @Transactional
    public static void getSysSrkWrkKbn(){
        sysSrkWrkKbn = bizDateConfig.getSeirekiWarekiKbn();
    }

    @AfterClass
    @Transactional
    public static void setSysSrkWrkKbn(){
        bizDateConfig.setSeirekiWarekiKbn(sysSrkWrkKbn);
    }

    @Test
    @TestOrder(950)
    public void testNormalParam25(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1740)
    public void testNormalParam43(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "2002年11月 5日", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1750)
    public void testNormalParam58(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1760)
    public void testNormalParam59(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(970)
    public void testIllegalParam68(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, null, "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(980)
    public void testIllegalParam69(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(990)
    public void testIllegalParam70(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "200211050", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1000)
    public void testIllegalParam71(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "99999999", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1010)
    public void testIllegalParam72(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "aaaaaaaa", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1020)
    public void testIllegalParam73(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "10001105";
        result = DateFormatUtil.dateKANJINoEx(dateStr);
        exStringEquals(result, "10001105", "漢字日付編集処理結果");
    }

}
