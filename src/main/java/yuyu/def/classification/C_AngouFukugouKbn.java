
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 暗号復号区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AngouFukugouKbn</td><td colspan="3">暗号復号区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ANGOU}</td><td>&quot;1&quot;</td><td>暗号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FUKUGOU}</td><td>&quot;2&quot;</td><td>復号</td></tr>
 * </table>
 */
public class C_AngouFukugouKbn extends Classification<C_AngouFukugouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AngouFukugouKbn ANGOU = new C_AngouFukugouKbn("1");

    public static final C_AngouFukugouKbn FUKUGOU = new C_AngouFukugouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ANGOU, "ANGOU", true);
        addPattern(PATTERN_DEFAULT, FUKUGOU, "FUKUGOU", false);


        lock(C_AngouFukugouKbn.class);
    }

    private C_AngouFukugouKbn(String value) {
        super(value);
    }

    public static C_AngouFukugouKbn valueOf(String value) {
        return valueOf(C_AngouFukugouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AngouFukugouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AngouFukugouKbn.class, patternId, value);
    }
}
