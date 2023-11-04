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
 * 日付フォーマットユーティリティクラスのドット区切り日付編集メソッド（String）{@link DateFormatUtil#dateDOT(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateDOT_2 {
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
    @TestOrder(1300)
    public void testNormalParam31(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1800)
    public void testNormalParam49(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "2002.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1810)
    public void testNormalParam70(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test
    @TestOrder(1820)
    public void testNormalParam71(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "20021105";
        result = DateFormatUtil.dateDOT(dateStr);
        exStringEquals(result, "H14.11. 5", "ドット編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(1310)
    public void testIllegalParam92(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = null;
        result = DateFormatUtil.dateDOT(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1320)
    public void testIllegalParam93(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOT(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット編集処理結果");
            throw bae;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(1330)
    public void testIllegalParam94(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.dateDOT(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(1340)
    public void testIllegalParam95(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "99999999";
        result = DateFormatUtil.dateDOT(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(1350)
    public void testIllegalParam96(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.dateDOT(dateStr);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(1360)
    public void testIllegalParam97(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateStr = "10001105";
        result = DateFormatUtil.dateDOT(dateStr);
    }


}
