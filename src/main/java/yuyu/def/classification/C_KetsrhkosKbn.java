
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定成立保留更新区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KetsrhkosKbn</td><td colspan="3">決定成立保留更新区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KOS_NONE}</td><td>&quot;0&quot;</td><td>更新なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETHORYU_HUBI}</td><td>&quot;1&quot;</td><td>決定保留不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRHORYU_HUBI}</td><td>&quot;2&quot;</td><td>成立保留不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHON_HUBI}</td><td>&quot;3&quot;</td><td>基本不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARNING}</td><td>&quot;4&quot;</td><td>ワーニング</td></tr>
 * </table>
 */
public class C_KetsrhkosKbn extends Classification<C_KetsrhkosKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KetsrhkosKbn KOS_NONE = new C_KetsrhkosKbn("0");

    public static final C_KetsrhkosKbn KETHORYU_HUBI = new C_KetsrhkosKbn("1");

    public static final C_KetsrhkosKbn SRHORYU_HUBI = new C_KetsrhkosKbn("2");

    public static final C_KetsrhkosKbn KIHON_HUBI = new C_KetsrhkosKbn("3");

    public static final C_KetsrhkosKbn WARNING = new C_KetsrhkosKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KOS_NONE, "KOS_NONE", true);
        addPattern(PATTERN_DEFAULT, KETHORYU_HUBI, "KETHORYU_HUBI", false);
        addPattern(PATTERN_DEFAULT, SRHORYU_HUBI, "SRHORYU_HUBI", false);
        addPattern(PATTERN_DEFAULT, KIHON_HUBI, "KIHON_HUBI", false);
        addPattern(PATTERN_DEFAULT, WARNING, "WARNING", false);


        lock(C_KetsrhkosKbn.class);
    }

    private C_KetsrhkosKbn(String value) {
        super(value);
    }

    public static C_KetsrhkosKbn valueOf(String value) {
        return valueOf(C_KetsrhkosKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KetsrhkosKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KetsrhkosKbn.class, patternId, value);
    }
}
