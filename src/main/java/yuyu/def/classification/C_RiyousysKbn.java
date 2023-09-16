
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 利用元システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RiyousysKbn</td><td colspan="3">利用元システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUU}</td><td>&quot;1&quot;</td><td>保険募集</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECT}</td><td>&quot;2&quot;</td><td>ダイレクト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ASBOX}</td><td>&quot;3&quot;</td><td>AS-BOX</td></tr>
 * </table>
 */
public class C_RiyousysKbn extends Classification<C_RiyousysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RiyousysKbn BLNK = new C_RiyousysKbn("0");

    public static final C_RiyousysKbn BOSYUU = new C_RiyousysKbn("1");

    public static final C_RiyousysKbn DIRECT = new C_RiyousysKbn("2");

    public static final C_RiyousysKbn ASBOX = new C_RiyousysKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BOSYUU, "BOSYUU", false);
        addPattern(PATTERN_DEFAULT, DIRECT, "DIRECT", false);
        addPattern(PATTERN_DEFAULT, ASBOX, "ASBOX", false);


        lock(C_RiyousysKbn.class);
    }

    private C_RiyousysKbn(String value) {
        super(value);
    }

    public static C_RiyousysKbn valueOf(String value) {
        return valueOf(C_RiyousysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RiyousysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RiyousysKbn.class, patternId, value);
    }
}
