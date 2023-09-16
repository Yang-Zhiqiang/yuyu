
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 複数商品有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HukusuusyouhnumuKbn</td><td colspan="3">複数商品有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_GAMEN GAMEN}<br />(画面表示用)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>複数商品あり</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>○</td></tr>
 * </table>
 */
public class C_HukusuusyouhnumuKbn extends Classification<C_HukusuusyouhnumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HukusuusyouhnumuKbn NONE = new C_HukusuusyouhnumuKbn("0");

    public static final C_HukusuusyouhnumuKbn ARI = new C_HukusuusyouhnumuKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_GAMEN = "2";

    public static final String PATTERN_REPORT = "3";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        addPattern(PATTERN_GAMEN, NONE, "NONE", true);
        addPattern(PATTERN_GAMEN, ARI, "ARI", false);


        addPattern(PATTERN_REPORT, NONE, "NONE", true);
        addPattern(PATTERN_REPORT, ARI, "ARI", false);


        lock(C_HukusuusyouhnumuKbn.class);
    }

    private C_HukusuusyouhnumuKbn(String value) {
        super(value);
    }

    public static C_HukusuusyouhnumuKbn valueOf(String value) {
        return valueOf(C_HukusuusyouhnumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HukusuusyouhnumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HukusuusyouhnumuKbn.class, patternId, value);
    }
}
