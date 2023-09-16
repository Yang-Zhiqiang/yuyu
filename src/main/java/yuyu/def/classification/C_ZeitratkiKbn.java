
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 税取扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZeitratkiKbn</td><td colspan="3">税取扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;1&quot;</td><td>一時所得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKU}</td><td>&quot;2&quot;</td><td>相続税</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZOUYO}</td><td>&quot;3&quot;</td><td>贈与税</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZASSYOTOKU}</td><td>&quot;5&quot;</td><td>雑所得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENSENBUNRI}</td><td>&quot;6&quot;</td><td>源泉分離課税</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIKAZEI}</td><td>&quot;9&quot;</td><td>非課税</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SISAN SISAN}<br />(試算用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;1&quot;</td><td>一時所得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKU}</td><td>&quot;2&quot;</td><td>相続税</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZOUYO}</td><td>&quot;3&quot;</td><td>贈与税</td></tr>
 * </table>
 */
public class C_ZeitratkiKbn extends Classification<C_ZeitratkiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZeitratkiKbn BLNK = new C_ZeitratkiKbn("0");

    public static final C_ZeitratkiKbn ITIJI = new C_ZeitratkiKbn("1");

    public static final C_ZeitratkiKbn SOUZOKU = new C_ZeitratkiKbn("2");

    public static final C_ZeitratkiKbn ZOUYO = new C_ZeitratkiKbn("3");

    public static final C_ZeitratkiKbn ZASSYOTOKU = new C_ZeitratkiKbn("5");

    public static final C_ZeitratkiKbn GENSENBUNRI = new C_ZeitratkiKbn("6");

    public static final C_ZeitratkiKbn HIKAZEI = new C_ZeitratkiKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SISAN = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, SOUZOKU, "SOUZOKU", false);
        addPattern(PATTERN_DEFAULT, ZOUYO, "ZOUYO", false);
        addPattern(PATTERN_DEFAULT, ZASSYOTOKU, "ZASSYOTOKU", false);
        addPattern(PATTERN_DEFAULT, GENSENBUNRI, "GENSENBUNRI", false);
        addPattern(PATTERN_DEFAULT, HIKAZEI, "HIKAZEI", false);


        addPattern(PATTERN_SISAN, BLNK, "BLNK", true);
        addPattern(PATTERN_SISAN, ITIJI, "ITIJI", false);
        addPattern(PATTERN_SISAN, SOUZOKU, "SOUZOKU", false);
        addPattern(PATTERN_SISAN, ZOUYO, "ZOUYO", false);


        lock(C_ZeitratkiKbn.class);
    }

    private C_ZeitratkiKbn(String value) {
        super(value);
    }

    public static C_ZeitratkiKbn valueOf(String value) {
        return valueOf(C_ZeitratkiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZeitratkiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZeitratkiKbn.class, patternId, value);
    }
}
