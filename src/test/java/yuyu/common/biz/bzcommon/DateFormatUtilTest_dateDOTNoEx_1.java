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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(例外なし)処理メソッド（BizDate）{@link DateFormatUtil#dateDOTNoEx(BizDate)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTNoEx_1 {
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
    @TestOrder(1370)
    public void testNormalParam32(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1810)
    public void testNormalParam50(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, "2002.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1820)
    public void testNormalParam72(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1830)
    public void testNormalParam73(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("20021105");
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1380)
    public void testIllegalParam98(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBD = null;
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, null, "ドット編集処理結果");
    }

    @Test
    @TestOrder(1390)
    public void testIllegalParam99(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = BizDate.valueOf("10001105");
        result = DateFormatUtil.dateDOTNoEx(dateBD);
        exStringEquals(result, "10001105", "ドット編集処理結果");
    }

}
