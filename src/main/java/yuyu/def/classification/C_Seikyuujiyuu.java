
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Seikyuujiyuu</td><td colspan="3">請求事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUU}</td><td>&quot;2&quot;</td><td>請求支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;3&quot;</td><td>死亡支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMI}</td><td>&quot;4&quot;</td><td>年金取込</td></tr>
 * </table>
 */
public class C_Seikyuujiyuu extends Classification<C_Seikyuujiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Seikyuujiyuu BLNK = new C_Seikyuujiyuu("0");

    public static final C_Seikyuujiyuu JIDOU = new C_Seikyuujiyuu("1");

    public static final C_Seikyuujiyuu SEIKYUU = new C_Seikyuujiyuu("2");

    public static final C_Seikyuujiyuu SIBOU = new C_Seikyuujiyuu("3");

    public static final C_Seikyuujiyuu TORIKOMI = new C_Seikyuujiyuu("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIDOU, "JIDOU", false);
        addPattern(PATTERN_DEFAULT, SEIKYUU, "SEIKYUU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, TORIKOMI, "TORIKOMI", false);


        lock(C_Seikyuujiyuu.class);
    }

    private C_Seikyuujiyuu(String value) {
        super(value);
    }

    public static C_Seikyuujiyuu valueOf(String value) {
        return valueOf(C_Seikyuujiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Seikyuujiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Seikyuujiyuu.class, patternId, value);
    }
}
