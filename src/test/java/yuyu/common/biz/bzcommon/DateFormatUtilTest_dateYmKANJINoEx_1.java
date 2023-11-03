package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import yuyu.testinfr.TestOrder;

/**
 * 日付フォーマットユーティリティクラスの漢字年月区切りの日付編集処理メソッド（BizDateYM）{@link DateFormatUtil#dateYmKANJINoEx(BizDateYM)} テスト用クラスです。<br />
 */

@RunWith(SWAKTestRunner.class)
public class DateFormatUtilTest_dateYmKANJINoEx_1{
    private BizDateYM   dateBDYM;
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
    @TestOrder(1150)
    public void testNormalParam28(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1770)
    public void testNormalParam46(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, "2002年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1780)
    public void testNormalParam64(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1790)
    public void testNormalParam65(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBDYM = BizDateYM.valueOf("200211");
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, "平成14年11月", "漢字日付編集処理結果");
    }

    @Test
    @TestOrder(1170)
    public void testIllegalParam82(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_KANJI);
        dateBDYM = null;
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, null, "漢字日付編集処理結果");
    }


    @Test
    @TestOrder(1180)
    public void testIllegalParam83(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBDYM = BizDateYM.valueOf("100011");
        result = DateFormatUtil.dateYmKANJINoEx(dateBDYM);
        exStringEquals(result, "100011", "漢字日付編集処理結果");
    }


}
