
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 差戻し先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SasimodosisakiKbn</td><td colspan="3">差戻し先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKU}</td><td>&quot;1&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKEN}</td><td>&quot;2&quot;</td><td>点検</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TENKEN TENKEN}<br />(点検)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKU}</td><td>&quot;1&quot;</td><td>入力</td></tr>
 * </table>
 */
public class C_SasimodosisakiKbn extends Classification<C_SasimodosisakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SasimodosisakiKbn BLNK = new C_SasimodosisakiKbn("0");

    public static final C_SasimodosisakiKbn NYUURYOKU = new C_SasimodosisakiKbn("1");

    public static final C_SasimodosisakiKbn TENKEN = new C_SasimodosisakiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TENKEN = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUURYOKU, "NYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, TENKEN, "TENKEN", false);


        addPattern(PATTERN_TENKEN, BLNK, "BLNK", true);
        addPattern(PATTERN_TENKEN, NYUURYOKU, "NYUURYOKU", false);


        lock(C_SasimodosisakiKbn.class);
    }

    private C_SasimodosisakiKbn(String value) {
        super(value);
    }

    public static C_SasimodosisakiKbn valueOf(String value) {
        return valueOf(C_SasimodosisakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SasimodosisakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SasimodosisakiKbn.class, patternId, value);
    }
}
