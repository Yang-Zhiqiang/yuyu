
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * マスキング区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MskKbn</td><td colspan="3">マスキング区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HIHYOUJI}</td><td>&quot;1&quot;</td><td>非表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASKING}</td><td>&quot;2&quot;</td><td>マスキング</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;3&quot;</td><td>マスキングしない</td></tr>
 * </table>
 */
public class C_MskKbn extends Classification<C_MskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MskKbn HIHYOUJI = new C_MskKbn("1");

    public static final C_MskKbn MASKING = new C_MskKbn("2");

    public static final C_MskKbn NONE = new C_MskKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HIHYOUJI, "HIHYOUJI", true);
        addPattern(PATTERN_DEFAULT, MASKING, "MASKING", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_MskKbn.class);
    }

    private C_MskKbn(String value) {
        super(value);
    }

    public static C_MskKbn valueOf(String value) {
        return valueOf(C_MskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MskKbn.class, patternId, value);
    }
}
