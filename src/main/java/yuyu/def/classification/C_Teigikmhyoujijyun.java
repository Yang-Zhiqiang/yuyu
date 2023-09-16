
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 定義項目表示順 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Teigikmhyoujijyun</td><td colspan="3">定義項目表示順</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIRST}</td><td>&quot;1&quot;</td><td>１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SECOND}</td><td>&quot;2&quot;</td><td>２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRD}</td><td>&quot;3&quot;</td><td>３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FOURTH}</td><td>&quot;4&quot;</td><td>４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIFTH}</td><td>&quot;5&quot;</td><td>５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIXTH}</td><td>&quot;6&quot;</td><td>６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEVENTH}</td><td>&quot;7&quot;</td><td>７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGHTH}</td><td>&quot;8&quot;</td><td>８</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINTH}</td><td>&quot;9&quot;</td><td>９</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTH}</td><td>&quot;10&quot;</td><td>１０</td></tr>
 * </table>
 */
public class C_Teigikmhyoujijyun extends Classification<C_Teigikmhyoujijyun> {

    private static final long serialVersionUID = 1L;


    public static final C_Teigikmhyoujijyun BLNK = new C_Teigikmhyoujijyun("0");

    public static final C_Teigikmhyoujijyun FIRST = new C_Teigikmhyoujijyun("1");

    public static final C_Teigikmhyoujijyun SECOND = new C_Teigikmhyoujijyun("2");

    public static final C_Teigikmhyoujijyun THIRD = new C_Teigikmhyoujijyun("3");

    public static final C_Teigikmhyoujijyun FOURTH = new C_Teigikmhyoujijyun("4");

    public static final C_Teigikmhyoujijyun FIFTH = new C_Teigikmhyoujijyun("5");

    public static final C_Teigikmhyoujijyun SIXTH = new C_Teigikmhyoujijyun("6");

    public static final C_Teigikmhyoujijyun SEVENTH = new C_Teigikmhyoujijyun("7");

    public static final C_Teigikmhyoujijyun EIGHTH = new C_Teigikmhyoujijyun("8");

    public static final C_Teigikmhyoujijyun NINTH = new C_Teigikmhyoujijyun("9");

    public static final C_Teigikmhyoujijyun TENTH = new C_Teigikmhyoujijyun("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FIRST, "FIRST", false);
        addPattern(PATTERN_DEFAULT, SECOND, "SECOND", false);
        addPattern(PATTERN_DEFAULT, THIRD, "THIRD", false);
        addPattern(PATTERN_DEFAULT, FOURTH, "FOURTH", false);
        addPattern(PATTERN_DEFAULT, FIFTH, "FIFTH", false);
        addPattern(PATTERN_DEFAULT, SIXTH, "SIXTH", false);
        addPattern(PATTERN_DEFAULT, SEVENTH, "SEVENTH", false);
        addPattern(PATTERN_DEFAULT, EIGHTH, "EIGHTH", false);
        addPattern(PATTERN_DEFAULT, NINTH, "NINTH", false);
        addPattern(PATTERN_DEFAULT, TENTH, "TENTH", false);


        lock(C_Teigikmhyoujijyun.class);
    }

    private C_Teigikmhyoujijyun(String value) {
        super(value);
    }

    public static C_Teigikmhyoujijyun valueOf(String value) {
        return valueOf(C_Teigikmhyoujijyun.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Teigikmhyoujijyun.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Teigikmhyoujijyun.class, patternId, value);
    }
}
