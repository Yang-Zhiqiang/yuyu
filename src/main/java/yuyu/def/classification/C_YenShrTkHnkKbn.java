
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 円支払特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YenShrTkHnkKbn</td><td colspan="3">円支払特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUHUKA}</td><td>&quot;1&quot;</td><td>特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_YenShrTkHnkKbn extends Classification<C_YenShrTkHnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YenShrTkHnkKbn BLNK = new C_YenShrTkHnkKbn("0");

    public static final C_YenShrTkHnkKbn TOKUYAKUHUKA = new C_YenShrTkHnkKbn("1");

    public static final C_YenShrTkHnkKbn KAIYAKU = new C_YenShrTkHnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOKUYAKUHUKA, "TOKUYAKUHUKA", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_YenShrTkHnkKbn.class);
    }

    private C_YenShrTkHnkKbn(String value) {
        super(value);
    }

    public static C_YenShrTkHnkKbn valueOf(String value) {
        return valueOf(C_YenShrTkHnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YenShrTkHnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YenShrTkHnkKbn.class, patternId, value);
    }
}
