
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷ手数料区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GwtsryKbn</td><td colspan="3">ＧＷ手数料区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_NONE}</td><td>&quot;1&quot;</td><td>速報連動なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_NTJ}</td><td>&quot;2&quot;</td><td>日次速報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_KSN}</td><td>&quot;3&quot;</td><td>決算用速報</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_PATTERN1 PATTERN1}<br />(パターン１)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_NONE}</td><td>&quot;1&quot;</td><td>速報連動なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_NTJ}</td><td>&quot;2&quot;</td><td>日次速報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_KSN}</td><td>&quot;3&quot;</td><td>決算用速報</td></tr>
 * </table>
 */
public class C_GwtsryKbn extends Classification<C_GwtsryKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GwtsryKbn BLNK = new C_GwtsryKbn("0");

    public static final C_GwtsryKbn SOKUHOU_NONE = new C_GwtsryKbn("1");

    public static final C_GwtsryKbn SOKUHOU_NTJ = new C_GwtsryKbn("2");

    public static final C_GwtsryKbn SOKUHOU_KSN = new C_GwtsryKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_PATTERN1 = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOKUHOU_NONE, "SOKUHOU_NONE", false);
        addPattern(PATTERN_DEFAULT, SOKUHOU_NTJ, "SOKUHOU_NTJ", false);
        addPattern(PATTERN_DEFAULT, SOKUHOU_KSN, "SOKUHOU_KSN", false);


        addPattern(PATTERN_PATTERN1, BLNK, "BLNK", true);
        addPattern(PATTERN_PATTERN1, SOKUHOU_NONE, "SOKUHOU_NONE", false);
        addPattern(PATTERN_PATTERN1, SOKUHOU_NTJ, "SOKUHOU_NTJ", false);
        addPattern(PATTERN_PATTERN1, SOKUHOU_KSN, "SOKUHOU_KSN", false);


        lock(C_GwtsryKbn.class);
    }

    private C_GwtsryKbn(String value) {
        super(value);
    }

    public static C_GwtsryKbn valueOf(String value) {
        return valueOf(C_GwtsryKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GwtsryKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GwtsryKbn.class, patternId, value);
    }
}
