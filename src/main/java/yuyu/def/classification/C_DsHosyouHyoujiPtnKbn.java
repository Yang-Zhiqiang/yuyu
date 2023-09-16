
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ保障内容表示パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsHosyouHyoujiPtnKbn</td><td colspan="3">ＤＳ保障内容表示パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OOMIDASIPTN}</td><td>&quot;1&quot;</td><td>大見出し表示パターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUMIDASIPTN}</td><td>&quot;2&quot;</td><td>中見出し表示パターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VALUEPTN}</td><td>&quot;3&quot;</td><td>値表示パターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUSYAKUPTN}</td><td>&quot;4&quot;</td><td>注釈表示パターン</td></tr>
 * </table>
 */
public class C_DsHosyouHyoujiPtnKbn extends Classification<C_DsHosyouHyoujiPtnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsHosyouHyoujiPtnKbn BLNK = new C_DsHosyouHyoujiPtnKbn("0");

    public static final C_DsHosyouHyoujiPtnKbn OOMIDASIPTN = new C_DsHosyouHyoujiPtnKbn("1");

    public static final C_DsHosyouHyoujiPtnKbn TYUUMIDASIPTN = new C_DsHosyouHyoujiPtnKbn("2");

    public static final C_DsHosyouHyoujiPtnKbn VALUEPTN = new C_DsHosyouHyoujiPtnKbn("3");

    public static final C_DsHosyouHyoujiPtnKbn TYUUSYAKUPTN = new C_DsHosyouHyoujiPtnKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OOMIDASIPTN, "OOMIDASIPTN", false);
        addPattern(PATTERN_DEFAULT, TYUUMIDASIPTN, "TYUUMIDASIPTN", false);
        addPattern(PATTERN_DEFAULT, VALUEPTN, "VALUEPTN", false);
        addPattern(PATTERN_DEFAULT, TYUUSYAKUPTN, "TYUUSYAKUPTN", false);


        lock(C_DsHosyouHyoujiPtnKbn.class);
    }

    private C_DsHosyouHyoujiPtnKbn(String value) {
        super(value);
    }

    public static C_DsHosyouHyoujiPtnKbn valueOf(String value) {
        return valueOf(C_DsHosyouHyoujiPtnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsHosyouHyoujiPtnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsHosyouHyoujiPtnKbn.class, patternId, value);
    }
}
