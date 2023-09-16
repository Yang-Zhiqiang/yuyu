
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 返戻金支払備金区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrshrbknKbn</td><td colspan="3">返戻金支払備金区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BIKIN}</td><td>&quot;2&quot;</td><td>備金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MBR}</td><td>&quot;3&quot;</td><td>未払金</td></tr>
 * </table>
 */
public class C_HrshrbknKbn extends Classification<C_HrshrbknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrshrbknKbn BLNK = new C_HrshrbknKbn("0");

    public static final C_HrshrbknKbn SIHARAI = new C_HrshrbknKbn("1");

    public static final C_HrshrbknKbn BIKIN = new C_HrshrbknKbn("2");

    public static final C_HrshrbknKbn MBR = new C_HrshrbknKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, BIKIN, "BIKIN", false);
        addPattern(PATTERN_DEFAULT, MBR, "MBR", false);


        lock(C_HrshrbknKbn.class);
    }

    private C_HrshrbknKbn(String value) {
        super(value);
    }

    public static C_HrshrbknKbn valueOf(String value) {
        return valueOf(C_HrshrbknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrshrbknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrshrbknKbn.class, patternId, value);
    }
}
