
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * カード情報変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CardinfohnkKbn</td><td colspan="3">カード情報変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HNKNONE}</td><td>&quot;0&quot;</td><td>変更なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNKARI}</td><td>&quot;1&quot;</td><td>変更あり</td></tr>
 * </table>
 */
public class C_CardinfohnkKbn extends Classification<C_CardinfohnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CardinfohnkKbn HNKNONE = new C_CardinfohnkKbn("0");

    public static final C_CardinfohnkKbn HNKARI = new C_CardinfohnkKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HNKNONE, "HNKNONE", true);
        addPattern(PATTERN_DEFAULT, HNKARI, "HNKARI", false);


        lock(C_CardinfohnkKbn.class);
    }

    private C_CardinfohnkKbn(String value) {
        super(value);
    }

    public static C_CardinfohnkKbn valueOf(String value) {
        return valueOf(C_CardinfohnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CardinfohnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CardinfohnkKbn.class, patternId, value);
    }
}
