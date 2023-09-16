
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 調書見出し区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyousyomidasiKbn</td><td colspan="3">調書見出し区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTR}</td><td>&quot;1&quot;</td><td>受取人別</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJKN}</td><td>&quot;2&quot;</td><td>一時金</td></tr>
 * </table>
 */
public class C_TyousyomidasiKbn extends Classification<C_TyousyomidasiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyousyomidasiKbn BLNK = new C_TyousyomidasiKbn("0");

    public static final C_TyousyomidasiKbn UKTR = new C_TyousyomidasiKbn("1");

    public static final C_TyousyomidasiKbn ITJKN = new C_TyousyomidasiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UKTR, "UKTR", false);
        addPattern(PATTERN_DEFAULT, ITJKN, "ITJKN", false);


        lock(C_TyousyomidasiKbn.class);
    }

    private C_TyousyomidasiKbn(String value) {
        super(value);
    }

    public static C_TyousyomidasiKbn valueOf(String value) {
        return valueOf(C_TyousyomidasiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyousyomidasiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyousyomidasiKbn.class, patternId, value);
    }
}
