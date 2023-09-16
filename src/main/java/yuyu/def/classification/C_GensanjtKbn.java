
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 減算状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GensanjtKbn</td><td colspan="3">減算状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YOTEI}</td><td>&quot;0&quot;</td><td>減算予定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;1&quot;</td><td>減算済</td></tr>
 * </table>
 */
public class C_GensanjtKbn extends Classification<C_GensanjtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GensanjtKbn YOTEI = new C_GensanjtKbn("0");

    public static final C_GensanjtKbn SUMI = new C_GensanjtKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YOTEI, "YOTEI", true);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        lock(C_GensanjtKbn.class);
    }

    private C_GensanjtKbn(String value) {
        super(value);
    }

    public static C_GensanjtKbn valueOf(String value) {
        return valueOf(C_GensanjtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GensanjtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GensanjtKbn.class, patternId, value);
    }
}
