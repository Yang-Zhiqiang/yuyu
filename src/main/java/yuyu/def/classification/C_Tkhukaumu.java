
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特約付加有無 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tkhukaumu</td><td colspan="3">特約付加有無</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>付加しない</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランク無し)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>付加しない</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK2 NOBLNK2}<br />(ブランク無し（初期値付加しない）)</td><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加する</td></tr>
 *  <tr><td align="center">○</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>付加しない</td></tr>
 * </table>
 */
public class C_Tkhukaumu extends Classification<C_Tkhukaumu> {

    private static final long serialVersionUID = 1L;


    public static final C_Tkhukaumu BLNK = new C_Tkhukaumu("0");

    public static final C_Tkhukaumu HUKA = new C_Tkhukaumu("1");

    public static final C_Tkhukaumu NONE = new C_Tkhukaumu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_NOBLNK2 = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        addPattern(PATTERN_NOBLNK, HUKA, "HUKA", true);
        addPattern(PATTERN_NOBLNK, NONE, "NONE", false);


        addPattern(PATTERN_NOBLNK2, HUKA, "HUKA", false);
        addPattern(PATTERN_NOBLNK2, NONE, "NONE", true);


        lock(C_Tkhukaumu.class);
    }

    private C_Tkhukaumu(String value) {
        super(value);
    }

    public static C_Tkhukaumu valueOf(String value) {
        return valueOf(C_Tkhukaumu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tkhukaumu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tkhukaumu.class, patternId, value);
    }
}
