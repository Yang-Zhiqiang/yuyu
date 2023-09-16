
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オーソリ状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AuthorijkKbn</td><td colspan="3">オーソリ状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>オーソリ不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAIMATI}</td><td>&quot;1&quot;</td><td>オーソリ依頼待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAITYUU}</td><td>&quot;2&quot;</td><td>オーソリ依頼中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OK}</td><td>&quot;3&quot;</td><td>オーソリＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;4&quot;</td><td>オーソリＮＧ</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会画面用)</td><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAIMATI}</td><td>&quot;1&quot;</td><td>オーソリ依頼待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAITYUU}</td><td>&quot;2&quot;</td><td>オーソリ依頼中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OK}</td><td>&quot;3&quot;</td><td>オーソリＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;4&quot;</td><td>オーソリＮＧ</td></tr>
 * </table>
 */
public class C_AuthorijkKbn extends Classification<C_AuthorijkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AuthorijkKbn HUYOU = new C_AuthorijkKbn("0");

    public static final C_AuthorijkKbn IRAIMATI = new C_AuthorijkKbn("1");

    public static final C_AuthorijkKbn IRAITYUU = new C_AuthorijkKbn("2");

    public static final C_AuthorijkKbn OK = new C_AuthorijkKbn("3");

    public static final C_AuthorijkKbn NG = new C_AuthorijkKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", true);
        addPattern(PATTERN_DEFAULT, IRAIMATI, "IRAIMATI", false);
        addPattern(PATTERN_DEFAULT, IRAITYUU, "IRAITYUU", false);
        addPattern(PATTERN_DEFAULT, OK, "OK", false);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);


        addPattern(PATTERN_SYOUKAI, HUYOU, "HUYOU", false);
        addPattern(PATTERN_SYOUKAI, IRAIMATI, "IRAIMATI", false);
        addPattern(PATTERN_SYOUKAI, IRAITYUU, "IRAITYUU", false);
        addPattern(PATTERN_SYOUKAI, OK, "OK", false);
        addPattern(PATTERN_SYOUKAI, NG, "NG", false);


        lock(C_AuthorijkKbn.class);
    }

    private C_AuthorijkKbn(String value) {
        super(value);
    }

    public static C_AuthorijkKbn valueOf(String value) {
        return valueOf(C_AuthorijkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AuthorijkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AuthorijkKbn.class, patternId, value);
    }
}
