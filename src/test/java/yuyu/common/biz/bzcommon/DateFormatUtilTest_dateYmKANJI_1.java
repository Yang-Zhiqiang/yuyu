package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateYM;
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
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集処理メソッド（BizDateYM）{@link DateFormatUtil#dateYmKANJI(BizDateYM)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJI_1{
    private BizDateYM   dateBDYM;
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
    @TestOrder(1030)
    public void testNormalParam26(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1750)
    public void testNormalParam44(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
        exStringEquals(result, "2002年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1760)
    public void testNormalParam60(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1770)
    public void testNormalParam61(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(1050)
    public void testIllegalParam74(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBDYM = null;
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(1060)
    public void testIllegalParam75(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBDYM = BizDateYM.valueOf("100011");
        result = DateFormatUtil.dateYmKANJI(dateBDYM);
    }

}
