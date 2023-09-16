
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 電話確認実施区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TelkknKbn</td><td colspan="3">電話確認実施区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISSI}</td><td>&quot;1&quot;</td><td>実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOURYAKU}</td><td>&quot;2&quot;</td><td>省略</td></tr>
 * </table>
 */
public class C_TelkknKbn extends Classification<C_TelkknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TelkknKbn BLNK = new C_TelkknKbn("0");

    public static final C_TelkknKbn JISSI = new C_TelkknKbn("1");

    public static final C_TelkknKbn SYOURYAKU = new C_TelkknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JISSI, "JISSI", false);
        addPattern(PATTERN_DEFAULT, SYOURYAKU, "SYOURYAKU", false);


        lock(C_TelkknKbn.class);
    }

    private C_TelkknKbn(String value) {
        super(value);
    }

    public static C_TelkknKbn valueOf(String value) {
        return valueOf(C_TelkknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TelkknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TelkknKbn.class, patternId, value);
    }
}
