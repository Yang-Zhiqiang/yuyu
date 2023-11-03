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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集メソッド（BizDate）{@link DateFormatUtil#dateDOT(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOT_1 {
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
    @TestOrder(1270)
    public void testNormalParam30(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOT(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1790)
    public void testNormalParam48(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOT(dateBD);
        exStringEquals(result, "2002.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1800)
    public void testNormalParam68(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOT(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1810)
    public void testNormalParam69(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOT(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test(expected = FormatException.class)
    @TestOrder(1280)
    public void testIllegalParam90(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = null;
        result = DateFormatUtil.dateDOT(dateBD);
    }
    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(1290)
    public void testIllegalParam91(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateDOT(dateBD);
    }

}
