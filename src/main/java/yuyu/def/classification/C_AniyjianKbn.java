
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案内要事案区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AniyjianKbn</td><td colspan="3">案内要事案区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANIYJIAN}</td><td>&quot;1&quot;</td><td>案内要事案</td></tr>
 * </table>
 */
public class C_AniyjianKbn extends Classification<C_AniyjianKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AniyjianKbn BLNK = new C_AniyjianKbn("0");

    public static final C_AniyjianKbn ANIYJIAN = new C_AniyjianKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ANIYJIAN, "ANIYJIAN", false);


        lock(C_AniyjianKbn.class);
    }

    private C_AniyjianKbn(String value) {
        super(value);
    }

    public static C_AniyjianKbn valueOf(String value) {
        return valueOf(C_AniyjianKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AniyjianKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AniyjianKbn.class, patternId, value);
    }
}
