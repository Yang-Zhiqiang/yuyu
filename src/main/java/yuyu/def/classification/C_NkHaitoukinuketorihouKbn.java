
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金配当金受取方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkHaitoukinuketorihouKbn</td><td colspan="3">年金配当金受取方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>無配当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIMASI}</td><td>&quot;1&quot;</td><td>年金買増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMITATE}</td><td>&quot;2&quot;</td><td>積立配当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;3&quot;</td><td>年金受取</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SIHARAI SIHARAI}<br />(支払用)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;3&quot;</td><td>年金とともに受取り</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIMASI}</td><td>&quot;1&quot;</td><td>年金買増し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMITATE}</td><td>&quot;2&quot;</td><td>積立</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NENKIN NENKIN}<br />(年金用)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>無配当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIMASI}</td><td>&quot;1&quot;</td><td>年金買増し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMITATE}</td><td>&quot;2&quot;</td><td>積立て</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;3&quot;</td><td>年金とともに受取り</td></tr>
 * </table>
 */
public class C_NkHaitoukinuketorihouKbn extends Classification<C_NkHaitoukinuketorihouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkHaitoukinuketorihouKbn NONE = new C_NkHaitoukinuketorihouKbn("0");

    public static final C_NkHaitoukinuketorihouKbn KAIMASI = new C_NkHaitoukinuketorihouKbn("1");

    public static final C_NkHaitoukinuketorihouKbn TUMITATE = new C_NkHaitoukinuketorihouKbn("2");

    public static final C_NkHaitoukinuketorihouKbn NENKIN = new C_NkHaitoukinuketorihouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SIHARAI = "2";

    public static final String PATTERN_NENKIN = "3";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KAIMASI, "KAIMASI", false);
        addPattern(PATTERN_DEFAULT, TUMITATE, "TUMITATE", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);


        addPattern(PATTERN_SIHARAI, NONE, "NONE", true);
        addPattern(PATTERN_SIHARAI, NENKIN, "NENKIN", false);
        addPattern(PATTERN_SIHARAI, KAIMASI, "KAIMASI", false);
        addPattern(PATTERN_SIHARAI, TUMITATE, "TUMITATE", false);


        addPattern(PATTERN_NENKIN, NONE, "NONE", true);
        addPattern(PATTERN_NENKIN, KAIMASI, "KAIMASI", false);
        addPattern(PATTERN_NENKIN, TUMITATE, "TUMITATE", false);
        addPattern(PATTERN_NENKIN, NENKIN, "NENKIN", false);


        lock(C_NkHaitoukinuketorihouKbn.class);
    }

    private C_NkHaitoukinuketorihouKbn(String value) {
        super(value);
    }

    public static C_NkHaitoukinuketorihouKbn valueOf(String value) {
        return valueOf(C_NkHaitoukinuketorihouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkHaitoukinuketorihouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkHaitoukinuketorihouKbn.class, patternId, value);
    }
}
