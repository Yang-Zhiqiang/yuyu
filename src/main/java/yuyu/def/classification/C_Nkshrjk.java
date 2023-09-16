
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nkshrjk</td><td colspan="3">年金支払状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAITYUU}</td><td>&quot;1&quot;</td><td>年金支払中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;2&quot;</td><td>年金終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;3&quot;</td><td>時効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEIKYUU}</td><td>&quot;4&quot;</td><td>初回年金未請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTORIKESI}</td><td>&quot;5&quot;</td><td>年金取消</td></tr>
 * </table>
 */
public class C_Nkshrjk extends Classification<C_Nkshrjk> {

    private static final long serialVersionUID = 1L;


    public static final C_Nkshrjk BLNK = new C_Nkshrjk("0");

    public static final C_Nkshrjk SIHARAITYUU = new C_Nkshrjk("1");

    public static final C_Nkshrjk SYUURYOU = new C_Nkshrjk("2");

    public static final C_Nkshrjk JIKOU = new C_Nkshrjk("3");

    public static final C_Nkshrjk MISEIKYUU = new C_Nkshrjk("4");

    public static final C_Nkshrjk NKTORIKESI = new C_Nkshrjk("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAITYUU, "SIHARAITYUU", false);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);
        addPattern(PATTERN_DEFAULT, MISEIKYUU, "MISEIKYUU", false);
        addPattern(PATTERN_DEFAULT, NKTORIKESI, "NKTORIKESI", false);


        lock(C_Nkshrjk.class);
    }

    private C_Nkshrjk(String value) {
        super(value);
    }

    public static C_Nkshrjk valueOf(String value) {
        return valueOf(C_Nkshrjk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nkshrjk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nkshrjk.class, patternId, value);
    }
}
