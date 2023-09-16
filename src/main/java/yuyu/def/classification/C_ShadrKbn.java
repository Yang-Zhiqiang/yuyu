
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送付先住所区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShadrKbn</td><td colspan="3">送付先住所区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;0&quot;</td><td>送付先を指定</td></tr>
 *  <tr><td align="center">○</td><td>{@link #TRKSUMI}</td><td>&quot;1&quot;</td><td>当社ご登録の住所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIN}</td><td>&quot;2&quot;</td><td>新住所</td></tr>
 * </table>
 */
public class C_ShadrKbn extends Classification<C_ShadrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShadrKbn SITEI = new C_ShadrKbn("0");

    public static final C_ShadrKbn TRKSUMI = new C_ShadrKbn("1");

    public static final C_ShadrKbn SIN = new C_ShadrKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);
        addPattern(PATTERN_DEFAULT, TRKSUMI, "TRKSUMI", true);
        addPattern(PATTERN_DEFAULT, SIN, "SIN", false);


        lock(C_ShadrKbn.class);
    }

    private C_ShadrKbn(String value) {
        super(value);
    }

    public static C_ShadrKbn valueOf(String value) {
        return valueOf(C_ShadrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShadrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShadrKbn.class, patternId, value);
    }
}
