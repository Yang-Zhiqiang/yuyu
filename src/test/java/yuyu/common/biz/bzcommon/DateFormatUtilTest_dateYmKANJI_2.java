package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.date.exception.DateParseException;
import jp.co.slcs.swak.date.exception.InvalidDateException;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集処理メソッド（String）{@link DateFormatUtil#dateYmKANJI(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJI_2{
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
    @TestOrder(1070)
    public void testNormalParam27(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJI(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1760)
    public void testNormalParam45(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJI(dateStr);
        exStringEquals(result, "2002年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1770)
    public void testNormalParam62(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJI(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1780)
    public void testNormalParam63(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211";
        result = DateFormatUtil.dateYmKANJI(dateStr);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(1090)
    public void testIllegalParam76(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateYmKANJI(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1100)
    public void testIllegalParam77(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYmKANJI(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字日付編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1110)
    public void testIllegalParam78(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateYmKANJI(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字日付編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(1120)
    public void testIllegalParam79(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "999999";
        result = DateFormatUtil.dateYmKANJI(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(1130)
    public void testIllegalParam80(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaa";
        result = DateFormatUtil.dateYmKANJI(dateStr);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(1140)
    public void testIllegalParam81(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "100011";
        result = DateFormatUtil.dateYmKANJI(dateStr);
    }


}
