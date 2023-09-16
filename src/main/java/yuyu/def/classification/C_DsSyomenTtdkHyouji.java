
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ書面手続表示 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSyomenTtdkHyouji</td><td colspan="3">ＤＳ書面手続表示</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISETTEI}</td><td>&quot;0&quot;</td><td>未設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOMENTTDK}</td><td>&quot;1&quot;</td><td>書面手続き</td></tr>
 * </table>
 */
public class C_DsSyomenTtdkHyouji extends Classification<C_DsSyomenTtdkHyouji> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSyomenTtdkHyouji MISETTEI = new C_DsSyomenTtdkHyouji("0");

    public static final C_DsSyomenTtdkHyouji SYOMENTTDK = new C_DsSyomenTtdkHyouji("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISETTEI, "MISETTEI", true);
        addPattern(PATTERN_DEFAULT, SYOMENTTDK, "SYOMENTTDK", false);


        lock(C_DsSyomenTtdkHyouji.class);
    }

    private C_DsSyomenTtdkHyouji(String value) {
        super(value);
    }

    public static C_DsSyomenTtdkHyouji valueOf(String value) {
        return valueOf(C_DsSyomenTtdkHyouji.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSyomenTtdkHyouji.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSyomenTtdkHyouji.class, patternId, value);
    }
}
