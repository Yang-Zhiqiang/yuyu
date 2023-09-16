
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 参照権限有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SansyoukngnumuKbn</td><td colspan="3">参照権限有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MICHK}</td><td>&quot;0&quot;</td><td>未チェック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>権限あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;2&quot;</td><td>権限なし</td></tr>
 * </table>
 */
public class C_SansyoukngnumuKbn extends Classification<C_SansyoukngnumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SansyoukngnumuKbn MICHK = new C_SansyoukngnumuKbn("0");

    public static final C_SansyoukngnumuKbn ARI = new C_SansyoukngnumuKbn("1");

    public static final C_SansyoukngnumuKbn NONE = new C_SansyoukngnumuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MICHK, "MICHK", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_SansyoukngnumuKbn.class);
    }

    private C_SansyoukngnumuKbn(String value) {
        super(value);
    }

    public static C_SansyoukngnumuKbn valueOf(String value) {
        return valueOf(C_SansyoukngnumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SansyoukngnumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SansyoukngnumuKbn.class, patternId, value);
    }
}
