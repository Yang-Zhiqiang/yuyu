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
 * 日付フォーマットユーティリティクラスのドット区切り日付ゼロ埋め編集メソッド（String）{@link DateFormatUtil#viewYMD(String)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_viewYMD_2 {
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
    @TestOrder(10)
    public void testNormalParam41(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateStr = "20021105";

        result = DateFormatUtil.viewYMD(dateStr);
        exStringEquals(result, "H14.11.05", "ドット編集処理結果");
    }



    @Test
    @TestOrder(20)
    public void testNormalParam77(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateStr = "20021105";

        result = DateFormatUtil.viewYMD(dateStr);
        exStringEquals(result, "2002.11.05", "ドット編集処理結果");
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(30)
    public void testIllegalParam126(){
        dateStr = null;
        result = DateFormatUtil.viewYMD(dateStr);
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(40)
    public void testIllegalParam127(){
        dateStr = "";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.viewYMD(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット編集処理結果");
            throw bae;
        }
    }

    @Test(expected =  CommonBizAppException.class)
    @TestOrder(50)
    public void testIllegalParam128(){
        dateStr = "200211050";
        String errMsg = null;
        String expMsg = "システム整合性エラーです。入力桁数が不正です。";
        try{
            result = DateFormatUtil.viewYMD(dateStr);
        }catch(CommonBizAppException bae){
            errMsg = bae.getMessage();
            exStringEquals(errMsg, expMsg, "ドット編集処理結果");
            throw bae;
        }
    }

    @Test(expected = InvalidDateException.class)
    @TestOrder(60)
    public void testIllegalParam129(){
        dateStr = "99999999";
        result = DateFormatUtil.viewYMD(dateStr);
    }

    @Test(expected = DateParseException.class)
    @TestOrder(70)
    public void testIllegalParam130(){
        dateStr = "aaaaaaaa";
        result = DateFormatUtil.viewYMD(dateStr);
    }

    @Test(expected = WarekiOutOfRangeException.class)
    @TestOrder(80)
    public void testIllegalParam131(){
        dateStr = "10001105";
        result = DateFormatUtil.viewYMD(dateStr);
    }



}
