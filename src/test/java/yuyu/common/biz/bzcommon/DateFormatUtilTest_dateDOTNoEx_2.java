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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集(例外なし)処理メソッド（String）{@link DateFormatUtil#dateDOTNoEx(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOTNoEx_2 {
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
    @TestOrder(1400)
    public void testNormalParam33(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1820)
    public void testNormalParam51(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "2002.11. 5", "ドット編集処理結果");
    }


    @Test
    @TestOrder(1830)
    public void testNormalParam74(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1840)
    public void testNormalParam75(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }


    @Test
    @TestOrder(1410)
    public void testIllegalParam100(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, null, "ドット編集処理結果");
    }

    @Test
    @TestOrder(1420)
    public void testIllegalParam101(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1430)
    public void testIllegalParam102(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "200211050", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1440)
    public void testIllegalParam103(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "99999999";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "99999999", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1450)
    public void testIllegalParam104(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "aaaaaaaa", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1460)
    public void testIllegalParam105(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "10001105";
        result = DateFormatUtil.dateDOTNoEx(dateStr);
        exStringEquals(result, "10001105", "ドット編集処理結果");
    }

}
