
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 有効区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YuukouKbn</td><td colspan="3">有効区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DISABLE}</td><td>&quot;0&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENABLE}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BYDATE}</td><td>&quot;2&quot;</td><td>有効開始日指定</td></tr>
 * </table>
 */
public class C_YuukouKbn extends Classification<C_YuukouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YuukouKbn DISABLE = new C_YuukouKbn("0");

    public static final C_YuukouKbn ENABLE = new C_YuukouKbn("1");

    public static final C_YuukouKbn BYDATE = new C_YuukouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DISABLE, "DISABLE", true);
        addPattern(PATTERN_DEFAULT, ENABLE, "ENABLE", false);
        addPattern(PATTERN_DEFAULT, BYDATE, "BYDATE", false);


        lock(C_YuukouKbn.class);
    }

    private C_YuukouKbn(String value) {
        super(value);
    }

    public static C_YuukouKbn valueOf(String value) {
        return valueOf(C_YuukouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YuukouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YuukouKbn.class, patternId, value);
    }
}
