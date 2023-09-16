
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険期間分類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknkknBunruiKbn</td><td colspan="3">保険期間分類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRD}</td><td>&quot;1&quot;</td><td>第１～第３保険期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SECOND}</td><td>&quot;2&quot;</td><td>第１、第２保険期間</td></tr>
 * </table>
 */
public class C_HknkknBunruiKbn extends Classification<C_HknkknBunruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknkknBunruiKbn NONE = new C_HknkknBunruiKbn("0");

    public static final C_HknkknBunruiKbn THIRD = new C_HknkknBunruiKbn("1");

    public static final C_HknkknBunruiKbn SECOND = new C_HknkknBunruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, THIRD, "THIRD", false);
        addPattern(PATTERN_DEFAULT, SECOND, "SECOND", false);


        lock(C_HknkknBunruiKbn.class);
    }

    private C_HknkknBunruiKbn(String value) {
        super(value);
    }

    public static C_HknkknBunruiKbn valueOf(String value) {
        return valueOf(C_HknkknBunruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknkknBunruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknkknBunruiKbn.class, patternId, value);
    }
}
