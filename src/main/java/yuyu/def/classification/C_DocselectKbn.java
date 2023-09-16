
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ドキュメント選択区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DocselectKbn</td><td colspan="3">ドキュメント選択区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONSLCT}</td><td>&quot;0&quot;</td><td>選択不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINGLE}</td><td>&quot;1&quot;</td><td>単一</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MULTI}</td><td>&quot;2&quot;</td><td>複数</td></tr>
 * </table>
 */
public class C_DocselectKbn extends Classification<C_DocselectKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DocselectKbn NONSLCT = new C_DocselectKbn("0");

    public static final C_DocselectKbn SINGLE = new C_DocselectKbn("1");

    public static final C_DocselectKbn MULTI = new C_DocselectKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONSLCT, "NONSLCT", true);
        addPattern(PATTERN_DEFAULT, SINGLE, "SINGLE", false);
        addPattern(PATTERN_DEFAULT, MULTI, "MULTI", false);


        lock(C_DocselectKbn.class);
    }

    private C_DocselectKbn(String value) {
        super(value);
    }

    public static C_DocselectKbn valueOf(String value) {
        return valueOf(C_DocselectKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DocselectKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DocselectKbn.class, patternId, value);
    }
}
