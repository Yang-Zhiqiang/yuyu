
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 満期受取人人数 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Mnkuktnin</td><td colspan="3">満期受取人人数</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HITORI}</td><td>&quot;1&quot;</td><td>１人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTARI}</td><td>&quot;2&quot;</td><td>２人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANNIN}</td><td>&quot;3&quot;</td><td>３人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YONIN}</td><td>&quot;4&quot;</td><td>４人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GONIN}</td><td>&quot;5&quot;</td><td>５人</td></tr>
 * </table>
 */
public class C_Mnkuktnin extends Classification<C_Mnkuktnin> {

    private static final long serialVersionUID = 1L;


    public static final C_Mnkuktnin BLNK = new C_Mnkuktnin("0");

    public static final C_Mnkuktnin HITORI = new C_Mnkuktnin("1");

    public static final C_Mnkuktnin HUTARI = new C_Mnkuktnin("2");

    public static final C_Mnkuktnin SANNIN = new C_Mnkuktnin("3");

    public static final C_Mnkuktnin YONIN = new C_Mnkuktnin("4");

    public static final C_Mnkuktnin GONIN = new C_Mnkuktnin("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HITORI, "HITORI", false);
        addPattern(PATTERN_DEFAULT, HUTARI, "HUTARI", false);
        addPattern(PATTERN_DEFAULT, SANNIN, "SANNIN", false);
        addPattern(PATTERN_DEFAULT, YONIN, "YONIN", false);
        addPattern(PATTERN_DEFAULT, GONIN, "GONIN", false);


        lock(C_Mnkuktnin.class);
    }

    private C_Mnkuktnin(String value) {
        super(value);
    }

    public static C_Mnkuktnin valueOf(String value) {
        return valueOf(C_Mnkuktnin.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Mnkuktnin.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Mnkuktnin.class, patternId, value);
    }
}
