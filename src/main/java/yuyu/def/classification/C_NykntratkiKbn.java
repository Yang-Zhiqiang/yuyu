
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金取扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NykntratkiKbn</td><td colspan="3">入金取扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAKUGO}</td><td>&quot;1&quot;</td><td>諾後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUJI}</td><td>&quot;2&quot;</td><td>同時</td></tr>
 * </table>
 */
public class C_NykntratkiKbn extends Classification<C_NykntratkiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NykntratkiKbn BLNK = new C_NykntratkiKbn("0");

    public static final C_NykntratkiKbn DAKUGO = new C_NykntratkiKbn("1");

    public static final C_NykntratkiKbn DOUJI = new C_NykntratkiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAKUGO, "DAKUGO", false);
        addPattern(PATTERN_DEFAULT, DOUJI, "DOUJI", false);


        lock(C_NykntratkiKbn.class);
    }

    private C_NykntratkiKbn(String value) {
        super(value);
    }

    public static C_NykntratkiKbn valueOf(String value) {
        return valueOf(C_NykntratkiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NykntratkiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NykntratkiKbn.class, patternId, value);
    }
}
