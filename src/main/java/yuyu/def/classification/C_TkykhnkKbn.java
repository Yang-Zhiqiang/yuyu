
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkykhnkKbn</td><td colspan="3">特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;3&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_TkykhnkKbn extends Classification<C_TkykhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkykhnkKbn BLNK = new C_TkykhnkKbn("0");

    public static final C_TkykhnkKbn HUKA = new C_TkykhnkKbn("1");

    public static final C_TkykhnkKbn HENKOU = new C_TkykhnkKbn("2");

    public static final C_TkykhnkKbn KAIYAKU = new C_TkykhnkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_TkykhnkKbn.class);
    }

    private C_TkykhnkKbn(String value) {
        super(value);
    }

    public static C_TkykhnkKbn valueOf(String value) {
        return valueOf(C_TkykhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkykhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkykhnkKbn.class, patternId, value);
    }
}
