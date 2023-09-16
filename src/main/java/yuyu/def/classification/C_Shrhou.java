
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払方法 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Shrhou</td><td colspan="3">支払方法</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOU}</td><td>&quot;1&quot;</td><td>銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKE}</td><td>&quot;3&quot;</td><td>仮受（店頭）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YTGINKOU}</td><td>&quot;5&quot;</td><td>ゆうちょ銀行</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELBLNK SELBLNK}<br />(選択（ブランクあり）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOU}</td><td>&quot;1&quot;</td><td>銀行</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #GINKOU}</td><td>&quot;1&quot;</td><td>銀行</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOU}</td><td>&quot;1&quot;</td><td>銀行</td></tr>
 * </table>
 */
public class C_Shrhou extends Classification<C_Shrhou> {

    private static final long serialVersionUID = 1L;


    public static final C_Shrhou BLNK = new C_Shrhou("0");

    public static final C_Shrhou GINKOU = new C_Shrhou("1");

    public static final C_Shrhou KARIUKE = new C_Shrhou("3");

    public static final C_Shrhou YTGINKOU = new C_Shrhou("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELBLNK = "2";

    public static final String PATTERN_SELECT = "3";

    public static final String PATTERN_TORIKOMI = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GINKOU, "GINKOU", false);
        addPattern(PATTERN_DEFAULT, KARIUKE, "KARIUKE", false);
        addPattern(PATTERN_DEFAULT, YTGINKOU, "YTGINKOU", false);


        addPattern(PATTERN_SELBLNK, BLNK, "BLNK", true);
        addPattern(PATTERN_SELBLNK, GINKOU, "GINKOU", false);


        addPattern(PATTERN_SELECT, GINKOU, "GINKOU", true);


        addPattern(PATTERN_TORIKOMI, BLNK, "BLNK", true);
        addPattern(PATTERN_TORIKOMI, GINKOU, "GINKOU", false);


        lock(C_Shrhou.class);
    }

    private C_Shrhou(String value) {
        super(value);
    }

    public static C_Shrhou valueOf(String value) {
        return valueOf(C_Shrhou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Shrhou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Shrhou.class, patternId, value);
    }
}
