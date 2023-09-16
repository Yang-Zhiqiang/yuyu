
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷ編集出力順位 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Gwhensyuuoutjyuni</td><td colspan="3">ＧＷ編集出力順位</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOUGAI}</td><td>&quot;0&quot;</td><td>優先順位対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI1}</td><td>&quot;1&quot;</td><td>第１優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2}</td><td>&quot;2&quot;</td><td>第２優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI3}</td><td>&quot;3&quot;</td><td>第３優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI4}</td><td>&quot;4&quot;</td><td>第４優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI5}</td><td>&quot;5&quot;</td><td>第５優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI6}</td><td>&quot;6&quot;</td><td>第６優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI7}</td><td>&quot;7&quot;</td><td>第７優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI8}</td><td>&quot;8&quot;</td><td>第８優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI9}</td><td>&quot;9&quot;</td><td>第９優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI10}</td><td>&quot;10&quot;</td><td>第１０優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI11}</td><td>&quot;11&quot;</td><td>第１１優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI12}</td><td>&quot;12&quot;</td><td>第１２優先順位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI13}</td><td>&quot;13&quot;</td><td>第１３優先順位</td></tr>
 * </table>
 */
public class C_Gwhensyuuoutjyuni extends Classification<C_Gwhensyuuoutjyuni> {

    private static final long serialVersionUID = 1L;


    public static final C_Gwhensyuuoutjyuni TAISYOUGAI = new C_Gwhensyuuoutjyuni("0");

    public static final C_Gwhensyuuoutjyuni DAI1 = new C_Gwhensyuuoutjyuni("1");

    public static final C_Gwhensyuuoutjyuni DAI2 = new C_Gwhensyuuoutjyuni("2");

    public static final C_Gwhensyuuoutjyuni DAI3 = new C_Gwhensyuuoutjyuni("3");

    public static final C_Gwhensyuuoutjyuni DAI4 = new C_Gwhensyuuoutjyuni("4");

    public static final C_Gwhensyuuoutjyuni DAI5 = new C_Gwhensyuuoutjyuni("5");

    public static final C_Gwhensyuuoutjyuni DAI6 = new C_Gwhensyuuoutjyuni("6");

    public static final C_Gwhensyuuoutjyuni DAI7 = new C_Gwhensyuuoutjyuni("7");

    public static final C_Gwhensyuuoutjyuni DAI8 = new C_Gwhensyuuoutjyuni("8");

    public static final C_Gwhensyuuoutjyuni DAI9 = new C_Gwhensyuuoutjyuni("9");

    public static final C_Gwhensyuuoutjyuni DAI10 = new C_Gwhensyuuoutjyuni("10");

    public static final C_Gwhensyuuoutjyuni DAI11 = new C_Gwhensyuuoutjyuni("11");

    public static final C_Gwhensyuuoutjyuni DAI12 = new C_Gwhensyuuoutjyuni("12");

    public static final C_Gwhensyuuoutjyuni DAI13 = new C_Gwhensyuuoutjyuni("13");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", true);
        addPattern(PATTERN_DEFAULT, DAI1, "DAI1", false);
        addPattern(PATTERN_DEFAULT, DAI2, "DAI2", false);
        addPattern(PATTERN_DEFAULT, DAI3, "DAI3", false);
        addPattern(PATTERN_DEFAULT, DAI4, "DAI4", false);
        addPattern(PATTERN_DEFAULT, DAI5, "DAI5", false);
        addPattern(PATTERN_DEFAULT, DAI6, "DAI6", false);
        addPattern(PATTERN_DEFAULT, DAI7, "DAI7", false);
        addPattern(PATTERN_DEFAULT, DAI8, "DAI8", false);
        addPattern(PATTERN_DEFAULT, DAI9, "DAI9", false);
        addPattern(PATTERN_DEFAULT, DAI10, "DAI10", false);
        addPattern(PATTERN_DEFAULT, DAI11, "DAI11", false);
        addPattern(PATTERN_DEFAULT, DAI12, "DAI12", false);
        addPattern(PATTERN_DEFAULT, DAI13, "DAI13", false);


        lock(C_Gwhensyuuoutjyuni.class);
    }

    private C_Gwhensyuuoutjyuni(String value) {
        super(value);
    }

    public static C_Gwhensyuuoutjyuni valueOf(String value) {
        return valueOf(C_Gwhensyuuoutjyuni.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Gwhensyuuoutjyuni.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Gwhensyuuoutjyuni.class, patternId, value);
    }
}
