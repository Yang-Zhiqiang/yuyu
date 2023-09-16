
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NstkhKbn</td><td colspan="3">年金支払特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUHUKA}</td><td>&quot;1&quot;</td><td>特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIYOUHENKOU}</td><td>&quot;2&quot;</td><td>内容変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;3&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_NstkhKbn extends Classification<C_NstkhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NstkhKbn BLNK = new C_NstkhKbn("0");

    public static final C_NstkhKbn TOKUYAKUHUKA = new C_NstkhKbn("1");

    public static final C_NstkhKbn NAIYOUHENKOU = new C_NstkhKbn("2");

    public static final C_NstkhKbn KAIYAKU = new C_NstkhKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOKUYAKUHUKA, "TOKUYAKUHUKA", false);
        addPattern(PATTERN_DEFAULT, NAIYOUHENKOU, "NAIYOUHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_NstkhKbn.class);
    }

    private C_NstkhKbn(String value) {
        super(value);
    }

    public static C_NstkhKbn valueOf(String value) {
        return valueOf(C_NstkhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NstkhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NstkhKbn.class, patternId, value);
    }
}
