
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 住所同一区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AdrdouKbn</td><td colspan="3">住所同一区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDOUITU}</td><td>&quot;1&quot;</td><td>契約者と同一</td></tr>
 * </table>
 */
public class C_AdrdouKbn extends Classification<C_AdrdouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AdrdouKbn NONE = new C_AdrdouKbn("0");

    public static final C_AdrdouKbn KYKDOUITU = new C_AdrdouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KYKDOUITU, "KYKDOUITU", false);


        lock(C_AdrdouKbn.class);
    }

    private C_AdrdouKbn(String value) {
        super(value);
    }

    public static C_AdrdouKbn valueOf(String value) {
        return valueOf(C_AdrdouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AdrdouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AdrdouKbn.class, patternId, value);
    }
}
