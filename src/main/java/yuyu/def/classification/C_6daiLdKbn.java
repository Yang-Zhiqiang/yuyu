
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ６大生活習慣病追加給付型区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_6daiLdKbn</td><td colspan="3">６大生活習慣病追加給付型区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>なし型</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>なし型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり型</td></tr>
 * </table>
 */
public class C_6daiLdKbn extends Classification<C_6daiLdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_6daiLdKbn BLNK = new C_6daiLdKbn("0");

    public static final C_6daiLdKbn ARI = new C_6daiLdKbn("1");

    public static final C_6daiLdKbn NONE = new C_6daiLdKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        addPattern(PATTERN_NOBLNK, NONE, "NONE", true);
        addPattern(PATTERN_NOBLNK, ARI, "ARI", false);


        lock(C_6daiLdKbn.class);
    }

    private C_6daiLdKbn(String value) {
        super(value);
    }

    public static C_6daiLdKbn valueOf(String value) {
        return valueOf(C_6daiLdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_6daiLdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_6daiLdKbn.class, patternId, value);
    }
}
