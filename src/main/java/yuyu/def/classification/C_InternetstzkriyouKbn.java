
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * インターネット接続利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_InternetstzkriyouKbn</td><td colspan="3">インターネット接続利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>利用なし</td></tr>
 *  <tr><td align="center">○</td><td>{@link #ARI}</td><td>&quot;2&quot;</td><td>利用あり</td></tr>
 * </table>
 */
public class C_InternetstzkriyouKbn extends Classification<C_InternetstzkriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_InternetstzkriyouKbn BLNK = new C_InternetstzkriyouKbn("0");

    public static final C_InternetstzkriyouKbn NONE = new C_InternetstzkriyouKbn("1");

    public static final C_InternetstzkriyouKbn ARI = new C_InternetstzkriyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", true);


        lock(C_InternetstzkriyouKbn.class);
    }

    private C_InternetstzkriyouKbn(String value) {
        super(value);
    }

    public static C_InternetstzkriyouKbn valueOf(String value) {
        return valueOf(C_InternetstzkriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_InternetstzkriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_InternetstzkriyouKbn.class, patternId, value);
    }
}
