
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 日本語理解力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NihongorikaiKbn</td><td colspan="3">日本語理解力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>なし</td></tr>
 * </table>
 */
public class C_NihongorikaiKbn extends Classification<C_NihongorikaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NihongorikaiKbn BLNK = new C_NihongorikaiKbn("0");

    public static final C_NihongorikaiKbn ARI = new C_NihongorikaiKbn("1");

    public static final C_NihongorikaiKbn NONE = new C_NihongorikaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_NihongorikaiKbn.class);
    }

    private C_NihongorikaiKbn(String value) {
        super(value);
    }

    public static C_NihongorikaiKbn valueOf(String value) {
        return valueOf(C_NihongorikaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NihongorikaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NihongorikaiKbn.class, patternId, value);
    }
}
