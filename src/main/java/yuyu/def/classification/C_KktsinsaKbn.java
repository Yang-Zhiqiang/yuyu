
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 告知診査区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KktsinsaKbn</td><td colspan="3">告知診査区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKTSINSA_ZUMI}</td><td>&quot;1&quot;</td><td>告知(診査）済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MI_KKTSINSA}</td><td>&quot;2&quot;</td><td>未告知(診査）</td></tr>
 * </table>
 */
public class C_KktsinsaKbn extends Classification<C_KktsinsaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KktsinsaKbn BLNK = new C_KktsinsaKbn("0");

    public static final C_KktsinsaKbn KKTSINSA_ZUMI = new C_KktsinsaKbn("1");

    public static final C_KktsinsaKbn MI_KKTSINSA = new C_KktsinsaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KKTSINSA_ZUMI, "KKTSINSA_ZUMI", false);
        addPattern(PATTERN_DEFAULT, MI_KKTSINSA, "MI_KKTSINSA", false);


        lock(C_KktsinsaKbn.class);
    }

    private C_KktsinsaKbn(String value) {
        super(value);
    }

    public static C_KktsinsaKbn valueOf(String value) {
        return valueOf(C_KktsinsaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KktsinsaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KktsinsaKbn.class, patternId, value);
    }
}
