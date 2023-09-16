
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 直線補間方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyksenhokanhouKbn</td><td colspan="3">直線補間方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RATE}</td><td>&quot;1&quot;</td><td>レート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JITUGAKU}</td><td>&quot;2&quot;</td><td>実額</td></tr>
 * </table>
 */
public class C_TyksenhokanhouKbn extends Classification<C_TyksenhokanhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyksenhokanhouKbn BLNK = new C_TyksenhokanhouKbn("0");

    public static final C_TyksenhokanhouKbn RATE = new C_TyksenhokanhouKbn("1");

    public static final C_TyksenhokanhouKbn JITUGAKU = new C_TyksenhokanhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RATE, "RATE", false);
        addPattern(PATTERN_DEFAULT, JITUGAKU, "JITUGAKU", false);


        lock(C_TyksenhokanhouKbn.class);
    }

    private C_TyksenhokanhouKbn(String value) {
        super(value);
    }

    public static C_TyksenhokanhouKbn valueOf(String value) {
        return valueOf(C_TyksenhokanhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyksenhokanhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyksenhokanhouKbn.class, patternId, value);
    }
}
