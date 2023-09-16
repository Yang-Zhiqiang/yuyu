
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチログ表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchLogHyoujiKbn</td><td colspan="3">バッチログ表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOUGAI}</td><td>&quot;1&quot;</td><td>対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUMU_BATCH}</td><td>&quot;2&quot;</td><td>業務バッチのみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEM_BATCH}</td><td>&quot;3&quot;</td><td>システムバッチのみ</td></tr>
 * </table>
 */
public class C_BatchLogHyoujiKbn extends Classification<C_BatchLogHyoujiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchLogHyoujiKbn TAISYOUGAI = new C_BatchLogHyoujiKbn("1");

    public static final C_BatchLogHyoujiKbn GYOUMU_BATCH = new C_BatchLogHyoujiKbn("2");

    public static final C_BatchLogHyoujiKbn SYSTEM_BATCH = new C_BatchLogHyoujiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", true);
        addPattern(PATTERN_DEFAULT, GYOUMU_BATCH, "GYOUMU_BATCH", false);
        addPattern(PATTERN_DEFAULT, SYSTEM_BATCH, "SYSTEM_BATCH", false);


        lock(C_BatchLogHyoujiKbn.class);
    }

    private C_BatchLogHyoujiKbn(String value) {
        super(value);
    }

    public static C_BatchLogHyoujiKbn valueOf(String value) {
        return valueOf(C_BatchLogHyoujiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchLogHyoujiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchLogHyoujiKbn.class, patternId, value);
    }
}
