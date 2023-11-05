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
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集処理メソッド（String）{@link DateFormatUtil#dateYmKANJINoEx(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJINoEx_2{
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
    @TestOrder(1190)
    public void testNormalParam29(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }
    @Test
    @TestOrder(1780)
    public void testNormalParam47(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "2002年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1790)
    public void testNormalParam66(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1800)
    public void testNormalParam67(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1210)
    public void testIllegalParam84(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, null, "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1220)
    public void testIllegalParam85(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1230)
    public void testIllegalParam86(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "200211050", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1240)
    public void testIllegalParam87(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "999999";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "999999", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1250)
    public void testIllegalParam88(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaa";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "aaaaaa", "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1260)
    public void testIllegalParam89(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "100011";
        result = DateFormatUtil.dateYmKANJINoEx(dateStr);
        exStringEquals(result, "100011", "漢字日付編集処理結果");
    }

}
