
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * DB反映区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Dbhanei</td><td colspan="3">DB反映区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SUMI}</td><td>&quot;0&quot;</td><td>反映済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>未反映</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KANJI1 KANJI1}<br />(漢字１文字)</td><td align="center">○</td><td>{@link #SUMI}</td><td>&quot;0&quot;</td><td>済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>未</td></tr>
 * </table>
 */
public class C_Dbhanei extends Classification<C_Dbhanei> {

    private static final long serialVersionUID = 1L;


    public static final C_Dbhanei SUMI = new C_Dbhanei("0");

    public static final C_Dbhanei NONE = new C_Dbhanei("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KANJI1 = "2";


    static {

        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        addPattern(PATTERN_KANJI1, SUMI, "SUMI", true);
        addPattern(PATTERN_KANJI1, NONE, "NONE", false);


        lock(C_Dbhanei.class);
    }

    private C_Dbhanei(String value) {
        super(value);
    }

    public static C_Dbhanei valueOf(String value) {
        return valueOf(C_Dbhanei.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Dbhanei.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Dbhanei.class, patternId, value);
    }
}
