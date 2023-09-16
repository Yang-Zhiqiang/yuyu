
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 経過区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeikaKbn</td><td colspan="3">経過区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YOKOKUKIKAN}</td><td>&quot;0&quot;</td><td>予告期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKKIKANTYOUKA}</td><td>&quot;1&quot;</td><td>有効期間超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKOKUKIKAN_WEB}</td><td>&quot;2&quot;</td><td>予告期間（Ｗｅｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKKIKANTYOUKA_WEB}</td><td>&quot;3&quot;</td><td>有効期間超過（Ｗｅｂ）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">&nbsp;</td><td>{@link #YOKOKUKIKAN}</td><td>&quot;0&quot;</td><td>予告期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKKIKANTYOUKA}</td><td>&quot;1&quot;</td><td>有効期間超過かつ自動不成立対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOKOKUKIKAN_WEB}</td><td>&quot;2&quot;</td><td>予告期間（Ｗｅｂ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YKKIKANTYOUKA_WEB}</td><td>&quot;3&quot;</td><td>有効期間超過かつ自動不成立対象外（Ｗｅｂ）</td></tr>
 * </table>
 */
public class C_KeikaKbn extends Classification<C_KeikaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeikaKbn YOKOKUKIKAN = new C_KeikaKbn("0");

    public static final C_KeikaKbn YKKIKANTYOUKA = new C_KeikaKbn("1");

    public static final C_KeikaKbn YOKOKUKIKAN_WEB = new C_KeikaKbn("2");

    public static final C_KeikaKbn YKKIKANTYOUKA_WEB = new C_KeikaKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REPORT = "2";


    static {

        addPattern(PATTERN_DEFAULT, YOKOKUKIKAN, "YOKOKUKIKAN", true);
        addPattern(PATTERN_DEFAULT, YKKIKANTYOUKA, "YKKIKANTYOUKA", false);
        addPattern(PATTERN_DEFAULT, YOKOKUKIKAN_WEB, "YOKOKUKIKAN_WEB", false);
        addPattern(PATTERN_DEFAULT, YKKIKANTYOUKA_WEB, "YKKIKANTYOUKA_WEB", false);


        addPattern(PATTERN_REPORT, YOKOKUKIKAN, "YOKOKUKIKAN", false);
        addPattern(PATTERN_REPORT, YKKIKANTYOUKA, "YKKIKANTYOUKA", false);
        addPattern(PATTERN_REPORT, YOKOKUKIKAN_WEB, "YOKOKUKIKAN_WEB", false);
        addPattern(PATTERN_REPORT, YKKIKANTYOUKA_WEB, "YKKIKANTYOUKA_WEB", false);


        lock(C_KeikaKbn.class);
    }

    private C_KeikaKbn(String value) {
        super(value);
    }

    public static C_KeikaKbn valueOf(String value) {
        return valueOf(C_KeikaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeikaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeikaKbn.class, patternId, value);
    }
}
