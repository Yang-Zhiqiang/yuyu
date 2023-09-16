
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 充当種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JyutousyuruiKbn</td><td colspan="3">充当種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENIZENJYUTO}</td><td>&quot;1&quot;</td><td>前年度以前充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUJYUTO}</td><td>&quot;2&quot;</td><td>当年度充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUJYUTO_ZENIZEN}</td><td>&quot;3&quot;</td><td>当年度充当（前年度以前入金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;4&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENJYUUTOU}</td><td>&quot;5&quot;</td><td>Ｐ免充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIZUMI}</td><td>&quot;9&quot;</td><td>払済</td></tr>
 * </table>
 */
public class C_JyutousyuruiKbn extends Classification<C_JyutousyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JyutousyuruiKbn BLNK = new C_JyutousyuruiKbn("0");

    public static final C_JyutousyuruiKbn ZENIZENJYUTO = new C_JyutousyuruiKbn("1");

    public static final C_JyutousyuruiKbn TOUJYUTO = new C_JyutousyuruiKbn("2");

    public static final C_JyutousyuruiKbn TOUJYUTO_ZENIZEN = new C_JyutousyuruiKbn("3");

    public static final C_JyutousyuruiKbn HUKKATU = new C_JyutousyuruiKbn("4");

    public static final C_JyutousyuruiKbn PMENJYUUTOU = new C_JyutousyuruiKbn("5");

    public static final C_JyutousyuruiKbn HARAIZUMI = new C_JyutousyuruiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENIZENJYUTO, "ZENIZENJYUTO", false);
        addPattern(PATTERN_DEFAULT, TOUJYUTO, "TOUJYUTO", false);
        addPattern(PATTERN_DEFAULT, TOUJYUTO_ZENIZEN, "TOUJYUTO_ZENIZEN", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, PMENJYUUTOU, "PMENJYUUTOU", false);
        addPattern(PATTERN_DEFAULT, HARAIZUMI, "HARAIZUMI", false);


        lock(C_JyutousyuruiKbn.class);
    }

    private C_JyutousyuruiKbn(String value) {
        super(value);
    }

    public static C_JyutousyuruiKbn valueOf(String value) {
        return valueOf(C_JyutousyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JyutousyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JyutousyuruiKbn.class, patternId, value);
    }
}
