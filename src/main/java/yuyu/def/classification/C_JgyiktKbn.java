
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 事業一括区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JgyiktKbn</td><td colspan="3">事業一括区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 * </table>
 */
public class C_JgyiktKbn extends Classification<C_JgyiktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JgyiktKbn BLNK = new C_JgyiktKbn("0");

    public static final C_JgyiktKbn ARI = new C_JgyiktKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_JgyiktKbn.class);
    }

    private C_JgyiktKbn(String value) {
        super(value);
    }

    public static C_JgyiktKbn valueOf(String value) {
        return valueOf(C_JgyiktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JgyiktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JgyiktKbn.class, patternId, value);
    }
}
