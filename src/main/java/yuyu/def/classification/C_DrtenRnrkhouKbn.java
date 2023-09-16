
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店連絡方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtenRnrkhouKbn</td><td colspan="3">代理店連絡方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #FAX}</td><td>&quot;1&quot;</td><td>ＦＡＸ・メール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMURNRK}</td><td>&quot;2&quot;</td><td>事務連絡システム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIT}</td><td>&quot;3&quot;</td><td>ＮＩＴペーパーレスシステム</td></tr>
 * </table>
 */
public class C_DrtenRnrkhouKbn extends Classification<C_DrtenRnrkhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtenRnrkhouKbn FAX = new C_DrtenRnrkhouKbn("1");

    public static final C_DrtenRnrkhouKbn JIMURNRK = new C_DrtenRnrkhouKbn("2");

    public static final C_DrtenRnrkhouKbn NIT = new C_DrtenRnrkhouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, FAX, "FAX", true);
        addPattern(PATTERN_DEFAULT, JIMURNRK, "JIMURNRK", false);
        addPattern(PATTERN_DEFAULT, NIT, "NIT", false);


        lock(C_DrtenRnrkhouKbn.class);
    }

    private C_DrtenRnrkhouKbn(String value) {
        super(value);
    }

    public static C_DrtenRnrkhouKbn valueOf(String value) {
        return valueOf(C_DrtenRnrkhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtenRnrkhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtenRnrkhouKbn.class, patternId, value);
    }
}
