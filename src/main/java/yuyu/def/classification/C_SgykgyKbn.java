
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 専業兼業区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SgykgyKbn</td><td colspan="3">専業兼業区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENGYOU}</td><td>&quot;1&quot;</td><td>専業</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENGYOU}</td><td>&quot;2&quot;</td><td>兼業</td></tr>
 * </table>
 */
public class C_SgykgyKbn extends Classification<C_SgykgyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SgykgyKbn BLNK = new C_SgykgyKbn("0");

    public static final C_SgykgyKbn SENGYOU = new C_SgykgyKbn("1");

    public static final C_SgykgyKbn KENGYOU = new C_SgykgyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SENGYOU, "SENGYOU", false);
        addPattern(PATTERN_DEFAULT, KENGYOU, "KENGYOU", false);


        lock(C_SgykgyKbn.class);
    }

    private C_SgykgyKbn(String value) {
        super(value);
    }

    public static C_SgykgyKbn valueOf(String value) {
        return valueOf(C_SgykgyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SgykgyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SgykgyKbn.class, patternId, value);
    }
}
