
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金時効区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BknJkuKbn</td><td colspan="3">備金時効区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINBI}</td><td>&quot;1&quot;</td><td>新備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIBI}</td><td>&quot;2&quot;</td><td>再備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISAIBI}</td><td>&quot;3&quot;</td><td>再々備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISAISAIBI}</td><td>&quot;4&quot;</td><td>再々々備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;5&quot;</td><td>時効</td></tr>
 * </table>
 */
public class C_BknJkuKbn extends Classification<C_BknJkuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BknJkuKbn BLNK = new C_BknJkuKbn("0");

    public static final C_BknJkuKbn SINBI = new C_BknJkuKbn("1");

    public static final C_BknJkuKbn SAIBI = new C_BknJkuKbn("2");

    public static final C_BknJkuKbn SAISAIBI = new C_BknJkuKbn("3");

    public static final C_BknJkuKbn SAISAISAIBI = new C_BknJkuKbn("4");

    public static final C_BknJkuKbn JIKOU = new C_BknJkuKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINBI, "SINBI", false);
        addPattern(PATTERN_DEFAULT, SAIBI, "SAIBI", false);
        addPattern(PATTERN_DEFAULT, SAISAIBI, "SAISAIBI", false);
        addPattern(PATTERN_DEFAULT, SAISAISAIBI, "SAISAISAIBI", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);


        lock(C_BknJkuKbn.class);
    }

    private C_BknJkuKbn(String value) {
        super(value);
    }

    public static C_BknJkuKbn valueOf(String value) {
        return valueOf(C_BknJkuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BknJkuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BknJkuKbn.class, patternId, value);
    }
}
