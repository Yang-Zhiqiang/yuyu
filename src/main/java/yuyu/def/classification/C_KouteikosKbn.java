
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程更新区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteikosKbn</td><td colspan="3">工程更新区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIATE}</td><td>&quot;1&quot;</td><td>割当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIATE_KJ}</td><td>&quot;2&quot;</td><td>割当解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;3&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;4&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;5&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;6&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_KouteikosKbn extends Classification<C_KouteikosKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteikosKbn BLNK = new C_KouteikosKbn("0");

    public static final C_KouteikosKbn WARIATE = new C_KouteikosKbn("1");

    public static final C_KouteikosKbn WARIATE_KJ = new C_KouteikosKbn("2");

    public static final C_KouteikosKbn TS = new C_KouteikosKbn("3");

    public static final C_KouteikosKbn HORYUU = new C_KouteikosKbn("4");

    public static final C_KouteikosKbn SONOTA = new C_KouteikosKbn("5");

    public static final C_KouteikosKbn KANRYOU = new C_KouteikosKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WARIATE, "WARIATE", false);
        addPattern(PATTERN_DEFAULT, WARIATE_KJ, "WARIATE_KJ", false);
        addPattern(PATTERN_DEFAULT, TS, "TS", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_KouteikosKbn.class);
    }

    private C_KouteikosKbn(String value) {
        super(value);
    }

    public static C_KouteikosKbn valueOf(String value) {
        return valueOf(C_KouteikosKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteikosKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteikosKbn.class, patternId, value);
    }
}
