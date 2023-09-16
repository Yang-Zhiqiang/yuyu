
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykjkKbn</td><td colspan="3">契約状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HARAIKOMI}</td><td>&quot;1&quot;</td><td>払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIBARAI}</td><td>&quot;2&quot;</td><td>一時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIPMATI}</td><td>&quot;3&quot;</td><td>１Ｐ待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;4&quot;</td><td>払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTYOU}</td><td>&quot;5&quot;</td><td>延長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;6&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;7&quot;</td><td>失効中</td></tr>
 * </table>
 */
public class C_KykjkKbn extends Classification<C_KykjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykjkKbn HARAIKOMI = new C_KykjkKbn("1");

    public static final C_KykjkKbn ITIJIBARAI = new C_KykjkKbn("2");

    public static final C_KykjkKbn ITIPMATI = new C_KykjkKbn("3");

    public static final C_KykjkKbn HARAIZUMI = new C_KykjkKbn("4");

    public static final C_KykjkKbn ENTYOU = new C_KykjkKbn("5");

    public static final C_KykjkKbn PMEN = new C_KykjkKbn("6");

    public static final C_KykjkKbn SIKKOU = new C_KykjkKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HARAIKOMI, "HARAIKOMI", true);
        addPattern(PATTERN_DEFAULT, ITIJIBARAI, "ITIJIBARAI", false);
        addPattern(PATTERN_DEFAULT, ITIPMATI, "ITIPMATI", false);
        addPattern(PATTERN_DEFAULT, HARAIZUMI, "HARAIZUMI", false);
        addPattern(PATTERN_DEFAULT, ENTYOU, "ENTYOU", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);


        lock(C_KykjkKbn.class);
    }

    private C_KykjkKbn(String value) {
        super(value);
    }

    public static C_KykjkKbn valueOf(String value) {
        return valueOf(C_KykjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykjkKbn.class, patternId, value);
    }
}
