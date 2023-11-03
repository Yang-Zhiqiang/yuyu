package yuyu.common.base.format;

import static org.junit.Assert.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * BizDateFormatUtilクラスの、<br />
 * toFormatedYmd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDateFormatUtilTest_toFormatedYmd_02{

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    public void test001(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiCommaYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015.08.14", pBizDateFormat);
    }

    @Test
    public void test002(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiCommaYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015.08", pBizDateFormat);
    }

    @Test
    public void test003(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.commaMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("08.14", pBizDateFormat);
    }

    @Test
    public void test004(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015", pBizDateFormat);
    }

    @Test
    public void test005(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolCommaYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27.08.14", pBizDateFormat);
    }

    @Test
    public void test006(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolCommaYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27.08", pBizDateFormat);
    }

    @Test
    public void test007(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27", pBizDateFormat);
    }

    @Test
    public void test008(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiCommaYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27.08.14", pBizDateFormat);
    }

    @Test
    public void test009(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiCommaYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27.08", pBizDateFormat);
    }

    @Test
    public void test010(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27", pBizDateFormat);
    }

    @Test
    public void test011(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiSlashYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015/08/14", pBizDateFormat);
    }

    @Test
    public void test012(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiSlashYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015/08", pBizDateFormat);
    }

    @Test
    public void test013(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.slashMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("08/14", pBizDateFormat);
    }

    @Test
    public void test014(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolSlashYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27/08/14", pBizDateFormat);
    }

    @Test
    public void test015(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolSlashYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27/08", pBizDateFormat);
    }

    @Test
    public void test016(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiSlashYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27/08/14", pBizDateFormat);
    }

    @Test
    public void test017(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiSlashYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27/08", pBizDateFormat);
    }

    @Test
    public void test018(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiKanjiYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015年08月14日", pBizDateFormat);
    }

    @Test
    public void test019(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiKanjiYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015年08月", pBizDateFormat);
    }

    @Test
    public void test020(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.kanjiMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("08月14日", pBizDateFormat);
    }

    @Test
    public void test021(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.seirekiKanjiYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("2015年", pBizDateFormat);
    }

    @Test
    public void test022(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolKanjiYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27年08月14日", pBizDateFormat);
    }

    @Test
    public void test023(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolKanjiYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27年08月", pBizDateFormat);
    }

    @Test
    public void test024(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiSymbolKanjiYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("H27年", pBizDateFormat);
    }

    @Test
    public void test025(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiKanjiYMDFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27年08月14日", pBizDateFormat);
    }

    @Test
    public void test026(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiKanjiYMFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27年08月", pBizDateFormat);
    }

    @Test
    public void test027(){

        BizDate pBizDate = BizDate.valueOf("20150814");
        BizDateFormatter pBizDateFormatter = BizDateFormatter.warekiKanjiKanjiYFormat;

        String pBizDateFormat = BizDateFormatUtil.toFormatedYmd(pBizDate, pBizDateFormatter);

        assertEquals("平成27年", pBizDateFormat);
    }

}
