
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * YesNo区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YesNoKbn</td><td colspan="3">YesNo区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NO}</td><td>&quot;0&quot;</td><td>No</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YES}</td><td>&quot;1&quot;</td><td>Yes</td></tr>
 * </table>
 */
public class C_YesNoKbn extends Classification<C_YesNoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YesNoKbn NO = new C_YesNoKbn("0");

    public static final C_YesNoKbn YES = new C_YesNoKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NO, "NO", true);
        addPattern(PATTERN_DEFAULT, YES, "YES", false);


        lock(C_YesNoKbn.class);
    }

    private C_YesNoKbn(String value) {
        super(value);
    }

    public static C_YesNoKbn valueOf(String value) {
        return valueOf(C_YesNoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YesNoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YesNoKbn.class, patternId, value);
    }
}
