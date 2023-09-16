
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ起動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchKidouKbn</td><td colspan="3">バッチ起動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>バッチ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAMEN}</td><td>&quot;2&quot;</td><td>画面</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>Job</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAMEN}</td><td>&quot;2&quot;</td><td>Web</td></tr>
 * </table>
 */
public class C_BatchKidouKbn extends Classification<C_BatchKidouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchKidouKbn BATCH = new C_BatchKidouKbn("1");

    public static final C_BatchKidouKbn GAMEN = new C_BatchKidouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", true);
        addPattern(PATTERN_DEFAULT, GAMEN, "GAMEN", false);


        addPattern(PATTERN_SYOUKAI, BATCH, "BATCH", false);
        addPattern(PATTERN_SYOUKAI, GAMEN, "GAMEN", false);


        lock(C_BatchKidouKbn.class);
    }

    private C_BatchKidouKbn(String value) {
        super(value);
    }

    public static C_BatchKidouKbn valueOf(String value) {
        return valueOf(C_BatchKidouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchKidouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchKidouKbn.class, patternId, value);
    }
}
