
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集紹介区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BosyuusykKbn</td><td colspan="3">募集紹介区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUU}</td><td>&quot;1&quot;</td><td>募集</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;2&quot;</td><td>紹介</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNNKDNN}</td><td>&quot;3&quot;</td><td>保険仲立人</td></tr>
 * </table>
 */
public class C_BosyuusykKbn extends Classification<C_BosyuusykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BosyuusykKbn BLNK = new C_BosyuusykKbn("0");

    public static final C_BosyuusykKbn BOSYUU = new C_BosyuusykKbn("1");

    public static final C_BosyuusykKbn SYOUKAI = new C_BosyuusykKbn("2");

    public static final C_BosyuusykKbn HKNNKDNN = new C_BosyuusykKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYUU, "BOSYUU", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HKNNKDNN, "HKNNKDNN", false);


        lock(C_BosyuusykKbn.class);
    }

    private C_BosyuusykKbn(String value) {
        super(value);
    }

    public static C_BosyuusykKbn valueOf(String value) {
        return valueOf(C_BosyuusykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BosyuusykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BosyuusykKbn.class, patternId, value);
    }
}
