
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 指定代理請求人指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StdrskstKbn</td><td colspan="3">指定代理請求人指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKANASI}</td><td>&quot;0&quot;</td><td>付加なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;9&quot;</td><td>指定あり</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #HUKANASI}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;9&quot;</td><td>指定あり</td></tr>
 * </table>
 */
public class C_StdrskstKbn extends Classification<C_StdrskstKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StdrskstKbn HUKANASI = new C_StdrskstKbn("0");

    public static final C_StdrskstKbn NONE = new C_StdrskstKbn("1");

    public static final C_StdrskstKbn ARI = new C_StdrskstKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, HUKANASI, "HUKANASI", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        addPattern(PATTERN_SELECT, HUKANASI, "HUKANASI", true);
        addPattern(PATTERN_SELECT, NONE, "NONE", false);
        addPattern(PATTERN_SELECT, ARI, "ARI", false);


        lock(C_StdrskstKbn.class);
    }

    private C_StdrskstKbn(String value) {
        super(value);
    }

    public static C_StdrskstKbn valueOf(String value) {
        return valueOf(C_StdrskstKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StdrskstKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StdrskstKbn.class, patternId, value);
    }
}
