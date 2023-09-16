
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申出移行区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MousideIkouKbn</td><td colspan="3">申出移行区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>移行無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENSYUUSIN}</td><td>&quot;1&quot;</td><td>円建終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENNENKIN}</td><td>&quot;2&quot;</td><td>円建年金保険</td></tr>
 * </table>
 */
public class C_MousideIkouKbn extends Classification<C_MousideIkouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MousideIkouKbn NONE = new C_MousideIkouKbn("0");

    public static final C_MousideIkouKbn YENSYUUSIN = new C_MousideIkouKbn("1");

    public static final C_MousideIkouKbn YENNENKIN = new C_MousideIkouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, YENSYUUSIN, "YENSYUUSIN", false);
        addPattern(PATTERN_DEFAULT, YENNENKIN, "YENNENKIN", false);


        lock(C_MousideIkouKbn.class);
    }

    private C_MousideIkouKbn(String value) {
        super(value);
    }

    public static C_MousideIkouKbn valueOf(String value) {
        return valueOf(C_MousideIkouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MousideIkouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MousideIkouKbn.class, patternId, value);
    }
}
