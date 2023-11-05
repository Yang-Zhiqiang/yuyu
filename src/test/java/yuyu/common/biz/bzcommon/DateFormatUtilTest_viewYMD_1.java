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
 * 日付フォーマットユーティリティクラスのドット区切り日付ゼロ埋め編集メソッド（BizDate）{@link DateFormatUtil#viewYMD(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_viewYMD_1 {
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
    @TestOrder(10)
    public void testNormalParam40(){

        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = BizDate.valueOf("20021105");

        result = DateFormatUtil.viewYMD(dateBD);
        exStringEquals(result, "H14.11.05", "ドット編集処理結果");
    }


    @Test
    @TestOrder(1760)
    public void testNormalParam76(){

        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.viewYMD(dateBD);
        exStringEquals(result, "2002.11.05", "ドット編集処理結果");
    }


    @Test(expected = FormatException.class)
    @TestOrder(30)
    public void testIllegalParam124(){
        dateBD = null;
        result = DateFormatUtil.viewYMD(dateBD);
    }
    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(40)
    public void testIllegalParam125(){
        dateBD = BizDate.valueOf("10001105");

        result = DateFormatUtil.viewYMD(dateBD);
    }


}
