
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 肯定否定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteihiteiKbn</td><td colspan="3">肯定否定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAI}</td><td>&quot;1&quot;</td><td>はい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IIE}</td><td>&quot;2&quot;</td><td>いいえ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #HAI}</td><td>&quot;1&quot;</td><td>はい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IIE}</td><td>&quot;2&quot;</td><td>いいえ</td></tr>
 * </table>
 */
public class C_KouteihiteiKbn extends Classification<C_KouteihiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteihiteiKbn BLNK = new C_KouteihiteiKbn("0");

    public static final C_KouteihiteiKbn HAI = new C_KouteihiteiKbn("1");

    public static final C_KouteihiteiKbn IIE = new C_KouteihiteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HAI, "HAI", false);
        addPattern(PATTERN_DEFAULT, IIE, "IIE", false);


        addPattern(PATTERN_NOBLNK, HAI, "HAI", false);
        addPattern(PATTERN_NOBLNK, IIE, "IIE", false);


        lock(C_KouteihiteiKbn.class);
    }

    private C_KouteihiteiKbn(String value) {
        super(value);
    }

    public static C_KouteihiteiKbn valueOf(String value) {
        return valueOf(C_KouteihiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteihiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteihiteiKbn.class, patternId, value);
    }
}
