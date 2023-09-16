
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効状態処理可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukoujyotaikahiKbn</td><td colspan="3">有効状態処理可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUUIARI}</td><td>&quot;1&quot;</td><td>処理可能注意有</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUUINASHI}</td><td>&quot;2&quot;</td><td>処理可能注意無</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;3&quot;</td><td>処理不可</td></tr>
 * </table>
 */
public class C_YuukoujyotaikahiKbn extends Classification<C_YuukoujyotaikahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukoujyotaikahiKbn BLNK = new C_YuukoujyotaikahiKbn("0");

    public static final C_YuukoujyotaikahiKbn SYORITYUUIARI = new C_YuukoujyotaikahiKbn("1");

    public static final C_YuukoujyotaikahiKbn SYORITYUUINASHI = new C_YuukoujyotaikahiKbn("2");

    public static final C_YuukoujyotaikahiKbn HUKA = new C_YuukoujyotaikahiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORITYUUIARI, "SYORITYUUIARI", false);
        addPattern(PATTERN_DEFAULT, SYORITYUUINASHI, "SYORITYUUINASHI", false);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);


        lock(C_YuukoujyotaikahiKbn.class);
    }

    private C_YuukoujyotaikahiKbn(String value) {
        super(value);
    }

    public static C_YuukoujyotaikahiKbn valueOf(String value) {
        return valueOf(C_YuukoujyotaikahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukoujyotaikahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukoujyotaikahiKbn.class, patternId, value);
    }
}
