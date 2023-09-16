
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特定保険種類通算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkthknsyruitsnKbn</td><td colspan="3">特定保険種類通算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SNTKTUUKHIJYNSYSNHKN}</td><td>&quot;1&quot;</td><td>選択通貨建平準払終身保険</td></tr>
 * </table>
 */
public class C_TkthknsyruitsnKbn extends Classification<C_TkthknsyruitsnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkthknsyruitsnKbn BLNK = new C_TkthknsyruitsnKbn("0");

    public static final C_TkthknsyruitsnKbn SNTKTUUKHIJYNSYSNHKN = new C_TkthknsyruitsnKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SNTKTUUKHIJYNSYSNHKN, "SNTKTUUKHIJYNSYSNHKN", false);


        lock(C_TkthknsyruitsnKbn.class);
    }

    private C_TkthknsyruitsnKbn(String value) {
        super(value);
    }

    public static C_TkthknsyruitsnKbn valueOf(String value) {
        return valueOf(C_TkthknsyruitsnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkthknsyruitsnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkthknsyruitsnKbn.class, patternId, value);
    }
}
