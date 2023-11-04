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
 * 日付フォーマットユーティリティクラスの漢字年月日区切りの日付編集処理メソッド（String） {@link DateFormatUtil#dateKANJI(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateKANJI_2{
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
    @TestOrder(830)
    public void testNormalParam23(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJI(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1720)
    public void testNormalParam41(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJI(dateStr);
        exStringEquals(result, "2002年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1730)
    public void testNormalParam54(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJI(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1740)
    public void testNormalParam55(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "20021105";
        result = DateFormatUtil.dateKANJI(dateStr);
        exStringEquals(result, "平成14年11月 5日", "漢字日付編集処理結果");
    }


    @Test(expected = NullPointerException.class)
    @TestOrder(850)
    public void testIllegalParam60(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateKANJI(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(860)
    public void testIllegalParam61(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJI(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字日付編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(870)
    public void testIllegalParam62(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateKANJI(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "漢字日付編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(880)
    public void testIllegalParam63(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "99999999";
        result = DateFormatUtil.dateKANJI(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(890)
    public void testIllegalParam64(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateKANJI(dateStr);
    }


    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(900)
    public void testIllegalParam65(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "10001105";
        result = DateFormatUtil.dateKANJI(dateStr);
    }


}
