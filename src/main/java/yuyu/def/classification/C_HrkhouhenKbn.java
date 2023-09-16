
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 払方変更内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkhouhenKbn</td><td colspan="3">払方変更内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA2CREDIT}</td><td>&quot;1&quot;</td><td>口座振替⇒クレジットカード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT2KOUZA}</td><td>&quot;2&quot;</td><td>クレジットカード⇒口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAHEN}</td><td>&quot;3&quot;</td><td>口座の変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHEN}</td><td>&quot;4&quot;</td><td>クレジットカードの変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKNOMI}</td><td>&quot;5&quot;</td><td>払込回数の変更のみ</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #KOUZA2CREDIT}</td><td>&quot;1&quot;</td><td>口座振替⇒クレジットカード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT2KOUZA}</td><td>&quot;2&quot;</td><td>クレジットカード⇒口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAHEN}</td><td>&quot;3&quot;</td><td>口座の変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHEN}</td><td>&quot;4&quot;</td><td>クレジットカードの変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKNOMI}</td><td>&quot;5&quot;</td><td>払込回数の変更のみ</td></tr>
 * </table>
 */
public class C_HrkhouhenKbn extends Classification<C_HrkhouhenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkhouhenKbn BLNK = new C_HrkhouhenKbn("0");

    public static final C_HrkhouhenKbn KOUZA2CREDIT = new C_HrkhouhenKbn("1");

    public static final C_HrkhouhenKbn CREDIT2KOUZA = new C_HrkhouhenKbn("2");

    public static final C_HrkhouhenKbn KOUZAHEN = new C_HrkhouhenKbn("3");

    public static final C_HrkhouhenKbn CREDITHEN = new C_HrkhouhenKbn("4");

    public static final C_HrkhouhenKbn HRKNOMI = new C_HrkhouhenKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUZA2CREDIT, "KOUZA2CREDIT", false);
        addPattern(PATTERN_DEFAULT, CREDIT2KOUZA, "CREDIT2KOUZA", false);
        addPattern(PATTERN_DEFAULT, KOUZAHEN, "KOUZAHEN", false);
        addPattern(PATTERN_DEFAULT, CREDITHEN, "CREDITHEN", false);
        addPattern(PATTERN_DEFAULT, HRKNOMI, "HRKNOMI", false);


        addPattern(PATTERN_NOBLNK, KOUZA2CREDIT, "KOUZA2CREDIT", false);
        addPattern(PATTERN_NOBLNK, CREDIT2KOUZA, "CREDIT2KOUZA", false);
        addPattern(PATTERN_NOBLNK, KOUZAHEN, "KOUZAHEN", false);
        addPattern(PATTERN_NOBLNK, CREDITHEN, "CREDITHEN", false);
        addPattern(PATTERN_NOBLNK, HRKNOMI, "HRKNOMI", false);


        lock(C_HrkhouhenKbn.class);
    }

    private C_HrkhouhenKbn(String value) {
        super(value);
    }

    public static C_HrkhouhenKbn valueOf(String value) {
        return valueOf(C_HrkhouhenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkhouhenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkhouhenKbn.class, patternId, value);
    }
}
