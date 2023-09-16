
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 初回保険料払込経路区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FstphrkkeiroKbn</td><td colspan="3">初回保険料払込経路区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;2&quot;</td><td>口座振替扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;3&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENIENCE}</td><td>&quot;4&quot;</td><td>コンビニ払</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURI}</td><td>&quot;2&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;3&quot;</td><td>クレジットカード扱い</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKMOUSIKOMI SKMOUSIKOMI}<br />(申込書入力用)</td><td align="center">○</td><td>{@link #HURIKOMI}</td><td>&quot;1&quot;</td><td>振込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;3&quot;</td><td>クレジットカード扱い</td></tr>
 * </table>
 */
public class C_FstphrkkeiroKbn extends Classification<C_FstphrkkeiroKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FstphrkkeiroKbn BLNK = new C_FstphrkkeiroKbn("0");

    public static final C_FstphrkkeiroKbn HURIKOMI = new C_FstphrkkeiroKbn("1");

    public static final C_FstphrkkeiroKbn KOUHURI = new C_FstphrkkeiroKbn("2");

    public static final C_FstphrkkeiroKbn CREDIT = new C_FstphrkkeiroKbn("3");

    public static final C_FstphrkkeiroKbn CONVENIENCE = new C_FstphrkkeiroKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKSELECT = "2";

    public static final String PATTERN_SKMOUSIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HURIKOMI, "HURIKOMI", false);
        addPattern(PATTERN_DEFAULT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);
        addPattern(PATTERN_DEFAULT, CONVENIENCE, "CONVENIENCE", false);


        addPattern(PATTERN_SKSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSELECT, HURIKOMI, "HURIKOMI", false);
        addPattern(PATTERN_SKSELECT, KOUHURI, "KOUHURI", false);
        addPattern(PATTERN_SKSELECT, CREDIT, "CREDIT", false);


        addPattern(PATTERN_SKMOUSIKOMI, HURIKOMI, "HURIKOMI", true);
        addPattern(PATTERN_SKMOUSIKOMI, CREDIT, "CREDIT", false);


        lock(C_FstphrkkeiroKbn.class);
    }

    private C_FstphrkkeiroKbn(String value) {
        super(value);
    }

    public static C_FstphrkkeiroKbn valueOf(String value) {
        return valueOf(C_FstphrkkeiroKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FstphrkkeiroKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FstphrkkeiroKbn.class, patternId, value);
    }
}
