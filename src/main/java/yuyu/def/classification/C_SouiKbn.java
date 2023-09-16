
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 相違区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SouiKbn</td><td colspan="3">相違区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NASI}</td><td>&quot;0&quot;</td><td>相違なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>相違あり</td></tr>
 * </table>
 */
public class C_SouiKbn extends Classification<C_SouiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SouiKbn NASI = new C_SouiKbn("0");

    public static final C_SouiKbn ARI = new C_SouiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NASI, "NASI", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_SouiKbn.class);
    }

    private C_SouiKbn(String value) {
        super(value);
    }

    public static C_SouiKbn valueOf(String value) {
        return valueOf(C_SouiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SouiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SouiKbn.class, patternId, value);
    }
}
