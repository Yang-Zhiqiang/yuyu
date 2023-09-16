
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 自動支払状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Jshrjk</td><td colspan="3">自動支払状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAITYUU}</td><td>&quot;1&quot;</td><td>自動支払中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISITYUU}</td><td>&quot;2&quot;</td><td>自動支払停止中</td></tr>
 * </table>
 */
public class C_Jshrjk extends Classification<C_Jshrjk> {

    private static final long serialVersionUID = 1L;


    public static final C_Jshrjk BLNK = new C_Jshrjk("0");

    public static final C_Jshrjk SIHARAITYUU = new C_Jshrjk("1");

    public static final C_Jshrjk TEISITYUU = new C_Jshrjk("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAITYUU, "SIHARAITYUU", false);
        addPattern(PATTERN_DEFAULT, TEISITYUU, "TEISITYUU", false);


        lock(C_Jshrjk.class);
    }

    private C_Jshrjk(String value) {
        super(value);
    }

    public static C_Jshrjk valueOf(String value) {
        return valueOf(C_Jshrjk.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Jshrjk.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Jshrjk.class, patternId, value);
    }
}
