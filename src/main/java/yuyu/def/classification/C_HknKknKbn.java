
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknKknKbn</td><td colspan="3">保険期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI1HKNKKN}</td><td>&quot;1&quot;</td><td>第１保険期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2HKNKKN}</td><td>&quot;2&quot;</td><td>第２保険期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI3HKNKKN}</td><td>&quot;3&quot;</td><td>第３保険期間</td></tr>
 * </table>
 */
public class C_HknKknKbn extends Classification<C_HknKknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknKknKbn BLNK = new C_HknKknKbn("0");

    public static final C_HknKknKbn DAI1HKNKKN = new C_HknKknKbn("1");

    public static final C_HknKknKbn DAI2HKNKKN = new C_HknKknKbn("2");

    public static final C_HknKknKbn DAI3HKNKKN = new C_HknKknKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DAI1HKNKKN, "DAI1HKNKKN", false);
        addPattern(PATTERN_DEFAULT, DAI2HKNKKN, "DAI2HKNKKN", false);
        addPattern(PATTERN_DEFAULT, DAI3HKNKKN, "DAI3HKNKKN", false);


        lock(C_HknKknKbn.class);
    }

    private C_HknKknKbn(String value) {
        super(value);
    }

    public static C_HknKknKbn valueOf(String value) {
        return valueOf(C_HknKknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknKknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknKknKbn.class, patternId, value);
    }
}
