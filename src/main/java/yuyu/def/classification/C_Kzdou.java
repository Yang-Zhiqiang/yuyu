
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 口座名義人同一区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kzdou</td><td colspan="3">口座名義人同一区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITU}</td><td>&quot;1&quot;</td><td>同一</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>指定</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #DOUITU}</td><td>&quot;1&quot;</td><td>同一</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>指定</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOSITEI NOSITEI}<br />(指定なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUITU}</td><td>&quot;1&quot;</td><td>同一</td></tr>
 * </table>
 */
public class C_Kzdou extends Classification<C_Kzdou> {

    private static final long serialVersionUID = 1L;


    public static final C_Kzdou BLNK = new C_Kzdou("0");

    public static final C_Kzdou DOUITU = new C_Kzdou("1");

    public static final C_Kzdou SITEI = new C_Kzdou("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_NOSITEI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DOUITU, "DOUITU", false);
        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);


        addPattern(PATTERN_SELECT, DOUITU, "DOUITU", true);
        addPattern(PATTERN_SELECT, SITEI, "SITEI", false);


        addPattern(PATTERN_NOSITEI, BLNK, "BLNK", true);
        addPattern(PATTERN_NOSITEI, DOUITU, "DOUITU", false);


        lock(C_Kzdou.class);
    }

    private C_Kzdou(String value) {
        super(value);
    }

    public static C_Kzdou valueOf(String value) {
        return valueOf(C_Kzdou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kzdou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kzdou.class, patternId, value);
    }
}
