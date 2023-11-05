package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集処理メソッド（BizDate）{@link DateFormatUtil#dateKANJINoEx(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJINoEx_1{
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
    @TestOrder(910)
    public void testNormalParam24(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1730)
    public void testNormalParam42(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, "2002年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1740)
    public void testNormalParam56(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1750)
    public void testNormalParam57(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(930)
    public void testIllegalParam66(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = null;
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, null, "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(940)
    public void testIllegalParam67(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateKANJINoEx(dateBD);
        exStringEquals(result, "10001105", "漢字日付編集処理結果");
    }

}
