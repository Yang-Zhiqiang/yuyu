package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.transaction.Transactional;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.date.exception.WarekiOutOfRangeException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 日付フォーマットユーティリティクラスの画面表示用年月編集メソッド（String）{@link DateFormatUtil#viewYM(String)} テスト用クラスです。<br />
 */
public class DateFormatUtilTest_viewYM_2 {
    private String     dateBD;
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
    public void testNormalParam46(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_SYMBOL);
        dateBD = "200203";
        result = DateFormatUtil.viewYM(dateBD);
        exStringEquals(result, "H14.03", "画面表示用年月編集処理結果");
    }

    @Test
    public void testNormalParam47(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.SEIREKI);
        dateBD = "200203";
        result = DateFormatUtil.viewYM(dateBD);
        exStringEquals(result, "2002.03", "画面表示用年月編集処理結果");
    }

    @Test
    public void testIllegalParam138(){
        dateBD = null;
        result = DateFormatUtil.viewYM(dateBD);
        exStringEquals(result, "", "画面表示用年月編集処理結果");
    }

    @Test
    public void testIllegalParam139(){
        dateBD = "20021";
        result = DateFormatUtil.viewYM(dateBD);
        exStringEquals(result, "", "画面表示用年月編集処理結果");
    }

    @Test(expected = WarekiOutOfRangeException.class)
    public void testIllegalParam140(){
        bizDateConfig.setSeirekiWarekiKbn(SeirekiWarekiKbn.WAREKI_INPUT);
        dateBD = "100011";
        result = DateFormatUtil.viewYM(dateBD);
    }
}
