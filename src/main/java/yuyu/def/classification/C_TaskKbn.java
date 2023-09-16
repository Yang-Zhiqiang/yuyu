
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * タスク区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TaskKbn</td><td colspan="3">タスク区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人タスク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUYUU}</td><td>&quot;2&quot;</td><td>共有タスク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;3&quot;</td><td>全タスク</td></tr>
 * </table>
 */
public class C_TaskKbn extends Classification<C_TaskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TaskKbn BLNK = new C_TaskKbn("0");

    public static final C_TaskKbn KOJIN = new C_TaskKbn("1");

    public static final C_TaskKbn KYOUYUU = new C_TaskKbn("2");

    public static final C_TaskKbn ALL = new C_TaskKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", false);
        addPattern(PATTERN_DEFAULT, KYOUYUU, "KYOUYUU", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_TaskKbn.class);
    }

    private C_TaskKbn(String value) {
        super(value);
    }

    public static C_TaskKbn valueOf(String value) {
        return valueOf(C_TaskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TaskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TaskKbn.class, patternId, value);
    }
}
