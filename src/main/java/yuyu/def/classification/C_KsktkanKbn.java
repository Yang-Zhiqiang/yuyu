
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 強制決定判定完了区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KsktkanKbn</td><td colspan="3">強制決定判定完了区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSKTTAISYOUGAI}</td><td>&quot;1&quot;</td><td>強制決定対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSKTTAISYOU}</td><td>&quot;2&quot;</td><td>強制決定対象</td></tr>
 * </table>
 */
public class C_KsktkanKbn extends Classification<C_KsktkanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KsktkanKbn NONE = new C_KsktkanKbn("0");

    public static final C_KsktkanKbn KSKTTAISYOUGAI = new C_KsktkanKbn("1");

    public static final C_KsktkanKbn KSKTTAISYOU = new C_KsktkanKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KSKTTAISYOUGAI, "KSKTTAISYOUGAI", false);
        addPattern(PATTERN_DEFAULT, KSKTTAISYOU, "KSKTTAISYOU", false);


        lock(C_KsktkanKbn.class);
    }

    private C_KsktkanKbn(String value) {
        super(value);
    }

    public static C_KsktkanKbn valueOf(String value) {
        return valueOf(C_KsktkanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KsktkanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KsktkanKbn.class, patternId, value);
    }
}
