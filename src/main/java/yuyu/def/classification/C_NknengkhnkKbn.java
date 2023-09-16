
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金年額変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NknengkhnkKbn</td><td colspan="3">年金年額変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HNKNONE}</td><td>&quot;1&quot;</td><td>変更なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZOUGAKU}</td><td>&quot;2&quot;</td><td>増額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;3&quot;</td><td>減額</td></tr>
 * </table>
 */
public class C_NknengkhnkKbn extends Classification<C_NknengkhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NknengkhnkKbn HNKNONE = new C_NknengkhnkKbn("1");

    public static final C_NknengkhnkKbn ZOUGAKU = new C_NknengkhnkKbn("2");

    public static final C_NknengkhnkKbn GENGAKU = new C_NknengkhnkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HNKNONE, "HNKNONE", true);
        addPattern(PATTERN_DEFAULT, ZOUGAKU, "ZOUGAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);


        lock(C_NknengkhnkKbn.class);
    }

    private C_NknengkhnkKbn(String value) {
        super(value);
    }

    public static C_NknengkhnkKbn valueOf(String value) {
        return valueOf(C_NknengkhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NknengkhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NknengkhnkKbn.class, patternId, value);
    }
}
