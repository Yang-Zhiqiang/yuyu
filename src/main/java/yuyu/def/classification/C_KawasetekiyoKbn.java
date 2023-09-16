
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 為替適用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KawasetekiyoKbn</td><td colspan="3">為替適用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTM}</td><td>&quot;TTM&quot;</td><td>仲値</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTB}</td><td>&quot;TTB&quot;</td><td>買値</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTS}</td><td>&quot;TTS&quot;</td><td>売値</td></tr>
 * </table>
 */
public class C_KawasetekiyoKbn extends Classification<C_KawasetekiyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KawasetekiyoKbn BLNK = new C_KawasetekiyoKbn("0");

    public static final C_KawasetekiyoKbn TTM = new C_KawasetekiyoKbn("TTM");

    public static final C_KawasetekiyoKbn TTB = new C_KawasetekiyoKbn("TTB");

    public static final C_KawasetekiyoKbn TTS = new C_KawasetekiyoKbn("TTS");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TTM, "TTM", false);
        addPattern(PATTERN_DEFAULT, TTB, "TTB", false);
        addPattern(PATTERN_DEFAULT, TTS, "TTS", false);


        lock(C_KawasetekiyoKbn.class);
    }

    private C_KawasetekiyoKbn(String value) {
        super(value);
    }

    public static C_KawasetekiyoKbn valueOf(String value) {
        return valueOf(C_KawasetekiyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KawasetekiyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KawasetekiyoKbn.class, patternId, value);
    }
}
