
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険年度区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknnendoKbn</td><td colspan="3">保険年度区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO}</td><td>&quot;1&quot;</td><td>初年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOWTOFIVE}</td><td>&quot;2&quot;</td><td>２から５年度目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIXTOTEN}</td><td>&quot;3&quot;</td><td>６から１０年度目</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MORETHANELEVEN}</td><td>&quot;4&quot;</td><td>１１年度目以降</td></tr>
 * </table>
 */
public class C_HknnendoKbn extends Classification<C_HknnendoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknnendoKbn BLNK = new C_HknnendoKbn("0");

    public static final C_HknnendoKbn SYONENDO = new C_HknnendoKbn("1");

    public static final C_HknnendoKbn TOWTOFIVE = new C_HknnendoKbn("2");

    public static final C_HknnendoKbn SIXTOTEN = new C_HknnendoKbn("3");

    public static final C_HknnendoKbn MORETHANELEVEN = new C_HknnendoKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYONENDO, "SYONENDO", false);
        addPattern(PATTERN_DEFAULT, TOWTOFIVE, "TOWTOFIVE", false);
        addPattern(PATTERN_DEFAULT, SIXTOTEN, "SIXTOTEN", false);
        addPattern(PATTERN_DEFAULT, MORETHANELEVEN, "MORETHANELEVEN", false);


        lock(C_HknnendoKbn.class);
    }

    private C_HknnendoKbn(String value) {
        super(value);
    }

    public static C_HknnendoKbn valueOf(String value) {
        return valueOf(C_HknnendoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknnendoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknnendoKbn.class, patternId, value);
    }
}
