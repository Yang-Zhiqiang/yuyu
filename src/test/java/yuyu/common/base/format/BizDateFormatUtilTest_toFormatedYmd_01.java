package yuyu.common.base.format;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * BizDateFormatUtilクラスの、<br />
 * toFormatedYmd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDateFormatUtilTest_toFormatedYmd_01{

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    public void test001(){

        BizDate pBizDate = BizDate.valueOf("20150814");

        BizDateConfig.getInstance().setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate);

        assertEquals("2015/08/14", pBizDateFormat);
    }

    @Test
    public void test002(){

        BizDate pBizDate = BizDate.valueOf("20150814");

        BizDateConfig.getInstance().setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate);

        assertEquals("H27/08/14", pBizDateFormat);
    }

    @Test
    public void test003(){

        BizDate pBizDate = BizDate.valueOf("20150814");

        BizDateConfig.getInstance().setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate);

        assertEquals("H27/08/14", pBizDateFormat);
    }

    @Test
    public void test004(){

        BizDate pBizDate = BizDate.valueOf("20150814");

        BizDateConfig.getInstance().setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate);

        assertEquals("H27/08/14", pBizDateFormat);
    }

    @Test
    public void test005(){
        //        BizDate pBizDate = BizDate.valueOf("20150814");
        //
        //        // ※bizdate-config.xmlにある西暦和暦区分値は変更されない。
        //        String pSeirekiWarekiKbn = "";
        //        BizDateConfig.getInstance().setSeirekiWarekiKbn(pSeirekiWarekiKbn);
        //
        //        try {
        //            BizDateFormatUtil.toFormatedYmd(pBizDate);
        //        } catch (RuntimeException e) {
        //            assertEquals("西暦和暦区分が不正です。 設定値 = " + pSeirekiWarekiKbn, e.getMessage());
        //            throw e;
        //        }
    }

}
