
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗データ承認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StydatasyouninresultKbn</td><td colspan="3">進捗データ承認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OK}</td><td>&quot;1&quot;</td><td>ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;2&quot;</td><td>ＮＧ</td></tr>
 * </table>
 */
public class C_StydatasyouninresultKbn extends Classification<C_StydatasyouninresultKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StydatasyouninresultKbn BLNK = new C_StydatasyouninresultKbn("0");

    public static final C_StydatasyouninresultKbn OK = new C_StydatasyouninresultKbn("1");

    public static final C_StydatasyouninresultKbn NG = new C_StydatasyouninresultKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OK, "OK", false);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);


        lock(C_StydatasyouninresultKbn.class);
    }

    private C_StydatasyouninresultKbn(String value) {
        super(value);
    }

    public static C_StydatasyouninresultKbn valueOf(String value) {
        return valueOf(C_StydatasyouninresultKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StydatasyouninresultKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StydatasyouninresultKbn.class, patternId, value);
    }
}
