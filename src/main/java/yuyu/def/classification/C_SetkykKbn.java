
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * セット契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SetkykKbn</td><td colspan="3">セット契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETKYK}</td><td>&quot;1&quot;</td><td>セット契約</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_HYOUJI HYOUJI}<br />(表示)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETKYK}</td><td>&quot;1&quot;</td><td>○</td></tr>
 * </table>
 */
public class C_SetkykKbn extends Classification<C_SetkykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SetkykKbn BLNK = new C_SetkykKbn("0");

    public static final C_SetkykKbn SETKYK = new C_SetkykKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETKYK, "SETKYK", false);


        addPattern(PATTERN_HYOUJI, BLNK, "BLNK", true);
        addPattern(PATTERN_HYOUJI, SETKYK, "SETKYK", false);


        lock(C_SetkykKbn.class);
    }

    private C_SetkykKbn(String value) {
        super(value);
    }

    public static C_SetkykKbn valueOf(String value) {
        return valueOf(C_SetkykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SetkykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SetkykKbn.class, patternId, value);
    }
}
