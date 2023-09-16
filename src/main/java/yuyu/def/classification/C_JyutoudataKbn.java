
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 充当データ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JyutoudataKbn</td><td colspan="3">充当データ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #P}</td><td>&quot;1&quot;</td><td>Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;2&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENREIKIN}</td><td>&quot;3&quot;</td><td>その他返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;4&quot;</td><td>払済</td></tr>
 * </table>
 */
public class C_JyutoudataKbn extends Classification<C_JyutoudataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JyutoudataKbn BLNK = new C_JyutoudataKbn("0");

    public static final C_JyutoudataKbn P = new C_JyutoudataKbn("1");

    public static final C_JyutoudataKbn PMEN = new C_JyutoudataKbn("2");

    public static final C_JyutoudataKbn SONOTAHENREIKIN = new C_JyutoudataKbn("3");

    public static final C_JyutoudataKbn HARAIZUMI = new C_JyutoudataKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, P, "P", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENREIKIN, "SONOTAHENREIKIN", false);
        addPattern(PATTERN_DEFAULT, HARAIZUMI, "HARAIZUMI", false);


        lock(C_JyutoudataKbn.class);
    }

    private C_JyutoudataKbn(String value) {
        super(value);
    }

    public static C_JyutoudataKbn valueOf(String value) {
        return valueOf(C_JyutoudataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JyutoudataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JyutoudataKbn.class, patternId, value);
    }
}
