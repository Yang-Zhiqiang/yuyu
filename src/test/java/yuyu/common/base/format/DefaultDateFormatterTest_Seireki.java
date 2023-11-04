package yuyu.common.base.format;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.date.exception.InvalidDateException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 標準書式用日付編集のメソッド{@link DefaultDateFormatter()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)

public class DefaultDateFormatterTest_Seireki {

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDateConfig bizDateConfig = BizDateConfig.getInstance();
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testFormatYMDKanjiSeireki_A1(){

        BizDate pBizDate = BizDate.valueOf("00000000");

        try {
            String pBizDateFormat = DefaultDateFormatter.formatYMDKanji(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "00000000(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }

    }

    @Test
    @TestOrder(20)
    public void testFormatYMSeireki_A1(){

        BizDate pBizDate = BizDate.valueOf("99999999");

        try {
            String pBizDateFormat = DefaultDateFormatter.formatYM(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "99999999(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }
    }


    @Test
    @TestOrder(30)
    public void testFormatYMSeireki_A2(){

        String pBizDate = "999999";

        try {
            String pBizDateFormat = DefaultDateFormatter.formatYM(pBizDate);

        } catch(InvalidDateException e){
            exStringEquals(e.getMessage(), "99999901(BizDate) は暦上外の日付です。", "エラーメッセージ");

        }

    }

}
