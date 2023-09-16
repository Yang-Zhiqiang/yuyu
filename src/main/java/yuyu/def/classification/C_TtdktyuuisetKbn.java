
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手続注意設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TtdktyuuisetKbn</td><td colspan="3">手続注意設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKAIJYO}</td><td>&quot;2&quot;</td><td>全解除</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RADIO RADIO}<br />(画面用)</td><td align="center">○</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKAIJYO}</td><td>&quot;2&quot;</td><td>全解除</td></tr>
 * </table>
 */
public class C_TtdktyuuisetKbn extends Classification<C_TtdktyuuisetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TtdktyuuisetKbn BLNK = new C_TtdktyuuisetKbn("0");

    public static final C_TtdktyuuisetKbn SETTEI = new C_TtdktyuuisetKbn("1");

    public static final C_TtdktyuuisetKbn ZENKAIJYO = new C_TtdktyuuisetKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);
        addPattern(PATTERN_DEFAULT, ZENKAIJYO, "ZENKAIJYO", false);


        addPattern(PATTERN_RADIO, SETTEI, "SETTEI", true);
        addPattern(PATTERN_RADIO, ZENKAIJYO, "ZENKAIJYO", false);


        lock(C_TtdktyuuisetKbn.class);
    }

    private C_TtdktyuuisetKbn(String value) {
        super(value);
    }

    public static C_TtdktyuuisetKbn valueOf(String value) {
        return valueOf(C_TtdktyuuisetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TtdktyuuisetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TtdktyuuisetKbn.class, patternId, value);
    }
}
