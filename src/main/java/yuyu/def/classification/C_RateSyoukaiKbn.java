
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * レート照会区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RateSyoukaiKbn</td><td colspan="3">レート照会区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PRATE}</td><td>&quot;1&quot;</td><td>Ｐレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VRATE}</td><td>&quot;2&quot;</td><td>Ｖレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRATE}</td><td>&quot;3&quot;</td><td>Ｄレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WRATE}</td><td>&quot;4&quot;</td><td>Ｗレート照会</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PRATE}</td><td>&quot;1&quot;</td><td>Ｐレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VRATE}</td><td>&quot;2&quot;</td><td>Ｖレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRATE}</td><td>&quot;3&quot;</td><td>Ｄレート照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WRATE}</td><td>&quot;4&quot;</td><td>Ｗレート照会</td></tr>
 * </table>
 */
public class C_RateSyoukaiKbn extends Classification<C_RateSyoukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RateSyoukaiKbn NONE = new C_RateSyoukaiKbn("0");

    public static final C_RateSyoukaiKbn PRATE = new C_RateSyoukaiKbn("1");

    public static final C_RateSyoukaiKbn VRATE = new C_RateSyoukaiKbn("2");

    public static final C_RateSyoukaiKbn DRATE = new C_RateSyoukaiKbn("3");

    public static final C_RateSyoukaiKbn WRATE = new C_RateSyoukaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, PRATE, "PRATE", false);
        addPattern(PATTERN_DEFAULT, VRATE, "VRATE", false);
        addPattern(PATTERN_DEFAULT, DRATE, "DRATE", false);
        addPattern(PATTERN_DEFAULT, WRATE, "WRATE", false);


        addPattern(PATTERN_SELECT, NONE, "NONE", true);
        addPattern(PATTERN_SELECT, PRATE, "PRATE", false);
        addPattern(PATTERN_SELECT, VRATE, "VRATE", false);
        addPattern(PATTERN_SELECT, DRATE, "DRATE", false);
        addPattern(PATTERN_SELECT, WRATE, "WRATE", false);


        lock(C_RateSyoukaiKbn.class);
    }

    private C_RateSyoukaiKbn(String value) {
        super(value);
    }

    public static C_RateSyoukaiKbn valueOf(String value) {
        return valueOf(C_RateSyoukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RateSyoukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RateSyoukaiKbn.class, patternId, value);
    }
}
