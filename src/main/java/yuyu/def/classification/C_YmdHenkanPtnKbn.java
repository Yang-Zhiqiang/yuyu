
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 日付変換パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YmdHenkanPtnKbn</td><td colspan="3">日付変換パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NULLPTN}</td><td>&quot;0&quot;</td><td>nullパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEROPTN}</td><td>&quot;1&quot;</td><td>0埋めパターン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUPTN}</td><td>&quot;2&quot;</td><td>9埋めパターン</td></tr>
 * </table>
 */
public class C_YmdHenkanPtnKbn extends Classification<C_YmdHenkanPtnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YmdHenkanPtnKbn NULLPTN = new C_YmdHenkanPtnKbn("0");

    public static final C_YmdHenkanPtnKbn ZEROPTN = new C_YmdHenkanPtnKbn("1");

    public static final C_YmdHenkanPtnKbn KYUUPTN = new C_YmdHenkanPtnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NULLPTN, "NULLPTN", true);
        addPattern(PATTERN_DEFAULT, ZEROPTN, "ZEROPTN", false);
        addPattern(PATTERN_DEFAULT, KYUUPTN, "KYUUPTN", false);


        lock(C_YmdHenkanPtnKbn.class);
    }

    private C_YmdHenkanPtnKbn(String value) {
        super(value);
    }

    public static C_YmdHenkanPtnKbn valueOf(String value) {
        return valueOf(C_YmdHenkanPtnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YmdHenkanPtnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YmdHenkanPtnKbn.class, patternId, value);
    }
}
