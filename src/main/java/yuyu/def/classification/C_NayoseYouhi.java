
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ要否 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NayoseYouhi</td><td colspan="3">名寄せ要否</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 * </table>
 */
public class C_NayoseYouhi extends Classification<C_NayoseYouhi> {

    private static final long serialVersionUID = 1L;


    public static final C_NayoseYouhi HUYOU = new C_NayoseYouhi("0");

    public static final C_NayoseYouhi YOU = new C_NayoseYouhi("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        lock(C_NayoseYouhi.class);
    }

    private C_NayoseYouhi(String value) {
        super(value);
    }

    public static C_NayoseYouhi valueOf(String value) {
        return valueOf(C_NayoseYouhi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NayoseYouhi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NayoseYouhi.class, patternId, value);
    }
}