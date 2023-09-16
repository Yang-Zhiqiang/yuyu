
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＩＯＥタイプ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IoeTypeKbn</td><td colspan="3">ＩＯＥタイプ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #RAY}</td><td>&quot;R&quot;</td><td>普保Ⅱ連動</td></tr>
 * </table>
 */
public class C_IoeTypeKbn extends Classification<C_IoeTypeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IoeTypeKbn RAY = new C_IoeTypeKbn("R");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, RAY, "RAY", true);


        lock(C_IoeTypeKbn.class);
    }

    private C_IoeTypeKbn(String value) {
        super(value);
    }

    public static C_IoeTypeKbn valueOf(String value) {
        return valueOf(C_IoeTypeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IoeTypeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IoeTypeKbn.class, patternId, value);
    }
}
