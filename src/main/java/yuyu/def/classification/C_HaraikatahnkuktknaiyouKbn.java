
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 払方変更受付内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaraikatahnkuktknaiyouKbn</td><td colspan="3">払方変更受付内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUHENKOU}</td><td>&quot;1&quot;</td><td>払込回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIROHENKOU}</td><td>&quot;2&quot;</td><td>払込経路変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUKEIROHENKOU}</td><td>&quot;3&quot;</td><td>払込回数変更・払込経路変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISUUKOUZAHENKOU}</td><td>&quot;4&quot;</td><td>払込回数変更・口座情報変更</td></tr>
 * </table>
 */
public class C_HaraikatahnkuktknaiyouKbn extends Classification<C_HaraikatahnkuktknaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaraikatahnkuktknaiyouKbn BLNK = new C_HaraikatahnkuktknaiyouKbn("0");

    public static final C_HaraikatahnkuktknaiyouKbn KAISUUHENKOU = new C_HaraikatahnkuktknaiyouKbn("1");

    public static final C_HaraikatahnkuktknaiyouKbn KEIROHENKOU = new C_HaraikatahnkuktknaiyouKbn("2");

    public static final C_HaraikatahnkuktknaiyouKbn KAISUUKEIROHENKOU = new C_HaraikatahnkuktknaiyouKbn("3");

    public static final C_HaraikatahnkuktknaiyouKbn KAISUUKOUZAHENKOU = new C_HaraikatahnkuktknaiyouKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAISUUHENKOU, "KAISUUHENKOU", false);
        addPattern(PATTERN_DEFAULT, KEIROHENKOU, "KEIROHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAISUUKEIROHENKOU, "KAISUUKEIROHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAISUUKOUZAHENKOU, "KAISUUKOUZAHENKOU", false);


        lock(C_HaraikatahnkuktknaiyouKbn.class);
    }

    private C_HaraikatahnkuktknaiyouKbn(String value) {
        super(value);
    }

    public static C_HaraikatahnkuktknaiyouKbn valueOf(String value) {
        return valueOf(C_HaraikatahnkuktknaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaraikatahnkuktknaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaraikatahnkuktknaiyouKbn.class, patternId, value);
    }
}
