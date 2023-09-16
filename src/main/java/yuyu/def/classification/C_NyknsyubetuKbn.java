
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyknsyubetuKbn</td><td colspan="3">入金種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;2&quot;</td><td>口座振替扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;3&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENIENCE}</td><td>&quot;4&quot;</td><td>コンビニ払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SINKEIYAKU SINKEIYAKU}<br />(新契約用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;2&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;3&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENIENCE}</td><td>&quot;4&quot;</td><td>コンビニ払</td></tr>
 * </table>
 */
public class C_NyknsyubetuKbn extends Classification<C_NyknsyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyknsyubetuKbn BLNK = new C_NyknsyubetuKbn("0");

    public static final C_NyknsyubetuKbn HURIKOMI = new C_NyknsyubetuKbn("1");

    public static final C_NyknsyubetuKbn KOUHURI = new C_NyknsyubetuKbn("2");

    public static final C_NyknsyubetuKbn CREDIT = new C_NyknsyubetuKbn("3");

    public static final C_NyknsyubetuKbn CONVENIENCE = new C_NyknsyubetuKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_SINKEIYAKU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HURIKOMI, "HURIKOMI", false);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);
        addPattern(PATTERN_DEFAULT, CONVENIENCE, "CONVENIENCE", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, HURIKOMI, "HURIKOMI", true);


        addPattern(PATTERN_SINKEIYAKU, BLNK, "BLNK", true);
        addPattern(PATTERN_SINKEIYAKU, HURIKOMI, "HURIKOMI", false);
        addPattern(PATTERN_SINKEIYAKU, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_SINKEIYAKU, CREDIT, "CREDIT", false);
        addPattern(PATTERN_SINKEIYAKU, CONVENIENCE, "CONVENIENCE", false);


        lock(C_NyknsyubetuKbn.class);
    }

    private C_NyknsyubetuKbn(String value) {
        super(value);
    }

    public static C_NyknsyubetuKbn valueOf(String value) {
        return valueOf(C_NyknsyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyknsyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyknsyubetuKbn.class, patternId, value);
    }
}
