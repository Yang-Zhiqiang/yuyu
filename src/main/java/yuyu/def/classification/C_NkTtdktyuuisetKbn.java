
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金手続注意設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkTtdktyuuisetKbn</td><td colspan="3">年金手続注意設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;2&quot;</td><td>解除</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RADIO RADIO}<br />(画面用)</td><td align="center">○</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;2&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_NkTtdktyuuisetKbn extends Classification<C_NkTtdktyuuisetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkTtdktyuuisetKbn BLNK = new C_NkTtdktyuuisetKbn("0");

    public static final C_NkTtdktyuuisetKbn SETTEI = new C_NkTtdktyuuisetKbn("1");

    public static final C_NkTtdktyuuisetKbn KAIJYO = new C_NkTtdktyuuisetKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);


        addPattern(PATTERN_RADIO, SETTEI, "SETTEI", true);
        addPattern(PATTERN_RADIO, KAIJYO, "KAIJYO", false);


        lock(C_NkTtdktyuuisetKbn.class);
    }

    private C_NkTtdktyuuisetKbn(String value) {
        super(value);
    }

    public static C_NkTtdktyuuisetKbn valueOf(String value) {
        return valueOf(C_NkTtdktyuuisetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkTtdktyuuisetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkTtdktyuuisetKbn.class, patternId, value);
    }
}
