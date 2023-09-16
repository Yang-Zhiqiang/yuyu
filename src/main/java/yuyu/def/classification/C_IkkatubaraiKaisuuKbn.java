
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 一括払回数区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IkkatubaraiKaisuuKbn</td><td colspan="3">一括払回数区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU2}</td><td>&quot;2&quot;</td><td>２か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU3}</td><td>&quot;3&quot;</td><td>３か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU4}</td><td>&quot;4&quot;</td><td>４か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU5}</td><td>&quot;5&quot;</td><td>５か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU6}</td><td>&quot;6&quot;</td><td>６か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU7}</td><td>&quot;7&quot;</td><td>７か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU8}</td><td>&quot;8&quot;</td><td>８か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU9}</td><td>&quot;9&quot;</td><td>９か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU10}</td><td>&quot;10&quot;</td><td>１０か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU11}</td><td>&quot;11&quot;</td><td>１１か月一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU12}</td><td>&quot;12&quot;</td><td>１２か月一括払</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_TEIKI TEIKI}<br />(定期一括払回数)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU2}</td><td>&quot;2&quot;</td><td>２か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU3}</td><td>&quot;3&quot;</td><td>３か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU4}</td><td>&quot;4&quot;</td><td>４か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU5}</td><td>&quot;5&quot;</td><td>５か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU6}</td><td>&quot;6&quot;</td><td>６か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU7}</td><td>&quot;7&quot;</td><td>７か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU8}</td><td>&quot;8&quot;</td><td>８か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU9}</td><td>&quot;9&quot;</td><td>９か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU10}</td><td>&quot;10&quot;</td><td>１０か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU11}</td><td>&quot;11&quot;</td><td>１１か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU12}</td><td>&quot;12&quot;</td><td>１２か月定期一括払</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_TEIKI_SELECT TEIKI_SELECT}<br />(定期一括払回数（選択）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU6}</td><td>&quot;6&quot;</td><td>６か月定期一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU12}</td><td>&quot;12&quot;</td><td>１２か月定期一括払</td></tr>
 * </table>
 */
public class C_IkkatubaraiKaisuuKbn extends Classification<C_IkkatubaraiKaisuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IkkatubaraiKaisuuKbn BLNK = new C_IkkatubaraiKaisuuKbn("0");

    public static final C_IkkatubaraiKaisuuKbn IKKATU2 = new C_IkkatubaraiKaisuuKbn("2");

    public static final C_IkkatubaraiKaisuuKbn IKKATU3 = new C_IkkatubaraiKaisuuKbn("3");

    public static final C_IkkatubaraiKaisuuKbn IKKATU4 = new C_IkkatubaraiKaisuuKbn("4");

    public static final C_IkkatubaraiKaisuuKbn IKKATU5 = new C_IkkatubaraiKaisuuKbn("5");

    public static final C_IkkatubaraiKaisuuKbn IKKATU6 = new C_IkkatubaraiKaisuuKbn("6");

    public static final C_IkkatubaraiKaisuuKbn IKKATU7 = new C_IkkatubaraiKaisuuKbn("7");

    public static final C_IkkatubaraiKaisuuKbn IKKATU8 = new C_IkkatubaraiKaisuuKbn("8");

    public static final C_IkkatubaraiKaisuuKbn IKKATU9 = new C_IkkatubaraiKaisuuKbn("9");

    public static final C_IkkatubaraiKaisuuKbn IKKATU10 = new C_IkkatubaraiKaisuuKbn("10");

    public static final C_IkkatubaraiKaisuuKbn IKKATU11 = new C_IkkatubaraiKaisuuKbn("11");

    public static final C_IkkatubaraiKaisuuKbn IKKATU12 = new C_IkkatubaraiKaisuuKbn("12");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TEIKI = "2";

    public static final String PATTERN_TEIKI_SELECT = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IKKATU2, "IKKATU2", false);
        addPattern(PATTERN_DEFAULT, IKKATU3, "IKKATU3", false);
        addPattern(PATTERN_DEFAULT, IKKATU4, "IKKATU4", false);
        addPattern(PATTERN_DEFAULT, IKKATU5, "IKKATU5", false);
        addPattern(PATTERN_DEFAULT, IKKATU6, "IKKATU6", false);
        addPattern(PATTERN_DEFAULT, IKKATU7, "IKKATU7", false);
        addPattern(PATTERN_DEFAULT, IKKATU8, "IKKATU8", false);
        addPattern(PATTERN_DEFAULT, IKKATU9, "IKKATU9", false);
        addPattern(PATTERN_DEFAULT, IKKATU10, "IKKATU10", false);
        addPattern(PATTERN_DEFAULT, IKKATU11, "IKKATU11", false);
        addPattern(PATTERN_DEFAULT, IKKATU12, "IKKATU12", false);


        addPattern(PATTERN_TEIKI, BLNK, "BLNK", true);
        addPattern(PATTERN_TEIKI, IKKATU2, "IKKATU2", false);
        addPattern(PATTERN_TEIKI, IKKATU3, "IKKATU3", false);
        addPattern(PATTERN_TEIKI, IKKATU4, "IKKATU4", false);
        addPattern(PATTERN_TEIKI, IKKATU5, "IKKATU5", false);
        addPattern(PATTERN_TEIKI, IKKATU6, "IKKATU6", false);
        addPattern(PATTERN_TEIKI, IKKATU7, "IKKATU7", false);
        addPattern(PATTERN_TEIKI, IKKATU8, "IKKATU8", false);
        addPattern(PATTERN_TEIKI, IKKATU9, "IKKATU9", false);
        addPattern(PATTERN_TEIKI, IKKATU10, "IKKATU10", false);
        addPattern(PATTERN_TEIKI, IKKATU11, "IKKATU11", false);
        addPattern(PATTERN_TEIKI, IKKATU12, "IKKATU12", false);


        addPattern(PATTERN_TEIKI_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_TEIKI_SELECT, IKKATU6, "IKKATU6", false);
        addPattern(PATTERN_TEIKI_SELECT, IKKATU12, "IKKATU12", false);


        lock(C_IkkatubaraiKaisuuKbn.class);
    }

    private C_IkkatubaraiKaisuuKbn(String value) {
        super(value);
    }

    public static C_IkkatubaraiKaisuuKbn valueOf(String value) {
        return valueOf(C_IkkatubaraiKaisuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IkkatubaraiKaisuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IkkatubaraiKaisuuKbn.class, patternId, value);
    }
}
