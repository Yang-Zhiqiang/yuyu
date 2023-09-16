
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SetteiKbn</td><td colspan="3">設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;2&quot;</td><td>解除</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;2&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_SetteiKbn extends Classification<C_SetteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SetteiKbn BLNK = new C_SetteiKbn("0");

    public static final C_SetteiKbn SETTEI = new C_SetteiKbn("1");

    public static final C_SetteiKbn KAIJO = new C_SetteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);


        addPattern(PATTERN_NOBLNK, SETTEI, "SETTEI", true);
        addPattern(PATTERN_NOBLNK, KAIJO, "KAIJO", false);


        lock(C_SetteiKbn.class);
    }

    private C_SetteiKbn(String value) {
        super(value);
    }

    public static C_SetteiKbn valueOf(String value) {
        return valueOf(C_SetteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SetteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SetteiKbn.class, patternId, value);
    }
}
