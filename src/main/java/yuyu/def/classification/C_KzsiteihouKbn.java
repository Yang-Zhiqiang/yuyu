
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 口座指定方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzsiteihouKbn</td><td colspan="3">口座指定方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動支払口座使用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>下記指定口座使用</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SITEI SITEI}<br />(指定口座使用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>下記指定口座使用</td></tr>
 * </table>
 */
public class C_KzsiteihouKbn extends Classification<C_KzsiteihouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzsiteihouKbn BLNK = new C_KzsiteihouKbn("0");

    public static final C_KzsiteihouKbn JIDOU = new C_KzsiteihouKbn("1");

    public static final C_KzsiteihouKbn SITEI = new C_KzsiteihouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SITEI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIDOU, "JIDOU", false);
        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);


        addPattern(PATTERN_SITEI, BLNK, "BLNK", false);
        addPattern(PATTERN_SITEI, SITEI, "SITEI", false);


        lock(C_KzsiteihouKbn.class);
    }

    private C_KzsiteihouKbn(String value) {
        super(value);
    }

    public static C_KzsiteihouKbn valueOf(String value) {
        return valueOf(C_KzsiteihouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzsiteihouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzsiteihouKbn.class, patternId, value);
    }
}
