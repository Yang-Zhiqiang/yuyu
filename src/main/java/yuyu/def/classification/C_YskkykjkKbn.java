
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 将来予測用契約状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YskkykjkKbn</td><td colspan="3">将来予測用契約状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKOMI}</td><td>&quot;1&quot;</td><td>払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;2&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;5&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;8&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;9&quot;</td><td>一時払</td></tr>
 * </table>
 */
public class C_YskkykjkKbn extends Classification<C_YskkykjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YskkykjkKbn BLNK = new C_YskkykjkKbn("0");

    public static final C_YskkykjkKbn HARAIKOMI = new C_YskkykjkKbn("1");

    public static final C_YskkykjkKbn HARAIMAN = new C_YskkykjkKbn("2");

    public static final C_YskkykjkKbn PMEN = new C_YskkykjkKbn("5");

    public static final C_YskkykjkKbn MANKI = new C_YskkykjkKbn("8");

    public static final C_YskkykjkKbn ITIJI = new C_YskkykjkKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HARAIKOMI, "HARAIKOMI", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);


        lock(C_YskkykjkKbn.class);
    }

    private C_YskkykjkKbn(String value) {
        super(value);
    }

    public static C_YskkykjkKbn valueOf(String value) {
        return valueOf(C_YskkykjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YskkykjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YskkykjkKbn.class, patternId, value);
    }
}
