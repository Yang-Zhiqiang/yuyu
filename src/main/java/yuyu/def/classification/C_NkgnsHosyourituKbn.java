
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金原資最低保証率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkgnsHosyourituKbn</td><td colspan="3">年金原資最低保証率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RITU100}</td><td>&quot;100&quot;</td><td>１００％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RITU105}</td><td>&quot;105&quot;</td><td>１０５％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RITU110}</td><td>&quot;110&quot;</td><td>１１０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RITU115}</td><td>&quot;115&quot;</td><td>１１５％</td></tr>
 * </table>
 */
public class C_NkgnsHosyourituKbn extends Classification<C_NkgnsHosyourituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkgnsHosyourituKbn BLNK = new C_NkgnsHosyourituKbn("0");

    public static final C_NkgnsHosyourituKbn RITU100 = new C_NkgnsHosyourituKbn("100");

    public static final C_NkgnsHosyourituKbn RITU105 = new C_NkgnsHosyourituKbn("105");

    public static final C_NkgnsHosyourituKbn RITU110 = new C_NkgnsHosyourituKbn("110");

    public static final C_NkgnsHosyourituKbn RITU115 = new C_NkgnsHosyourituKbn("115");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RITU100, "RITU100", false);
        addPattern(PATTERN_DEFAULT, RITU105, "RITU105", false);
        addPattern(PATTERN_DEFAULT, RITU110, "RITU110", false);
        addPattern(PATTERN_DEFAULT, RITU115, "RITU115", false);


        lock(C_NkgnsHosyourituKbn.class);
    }

    private C_NkgnsHosyourituKbn(String value) {
        super(value);
    }

    public static C_NkgnsHosyourituKbn valueOf(String value) {
        return valueOf(C_NkgnsHosyourituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkgnsHosyourituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkgnsHosyourituKbn.class, patternId, value);
    }
}
