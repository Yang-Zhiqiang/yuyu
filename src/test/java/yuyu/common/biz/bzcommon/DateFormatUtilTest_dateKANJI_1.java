package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.date.exception.FormatException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集処理メソッド（BizDate） {@link DateFormatUtil#dateKANJI(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJI_1{
    private BizDate     dateBD;
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
    @TestOrder(790)
    public void testNormalParam22(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJI(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1710)
    public void testNormalParam40(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJI(dateBD);
        exStringEquals(result, "2002年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1720)
    public void testNormalParam52(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJI(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1730)
    public void testNormalParam53(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJI(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(810)
    public void testIllegalParam58(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = null;
        result = DateFormatUtil.dateKANJI(dateBD);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(820)
    public void testIllegalParam59(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateKANJI(dateBD);
    }


}
