
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 守秘要否 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyuhiYouhi</td><td colspan="3">守秘要否</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUYOU}</td><td>&quot;0&quot;</td><td>守秘不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>守秘要</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_YOU YOU}<br />(守秘要のみ)</td><td align="center">○</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>守秘要</td></tr>
 * </table>
 */
public class C_SyuhiYouhi extends Classification<C_SyuhiYouhi> {

    private static final long serialVersionUID = 1L;


    public static final C_SyuhiYouhi HUYOU = new C_SyuhiYouhi("0");

    public static final C_SyuhiYouhi YOU = new C_SyuhiYouhi("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_YOU = "2";


    static {

        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        addPattern(PATTERN_YOU, YOU, "YOU", true);


        lock(C_SyuhiYouhi.class);
    }

    private C_SyuhiYouhi(String value) {
        super(value);
    }

    public static C_SyuhiYouhi valueOf(String value) {
        return valueOf(C_SyuhiYouhi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyuhiYouhi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyuhiYouhi.class, patternId, value);
    }
}
