
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ並走区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchHeisouKbn</td><td colspan="3">バッチ並走区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #None}</td><td>&quot;0&quot;</td><td>制御なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BL}</td><td>&quot;1&quot;</td><td>禁止リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WL}</td><td>&quot;2&quot;</td><td>許可リスト</td></tr>
 * </table>
 */
public class C_BatchHeisouKbn extends Classification<C_BatchHeisouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchHeisouKbn None = new C_BatchHeisouKbn("0");

    public static final C_BatchHeisouKbn BL = new C_BatchHeisouKbn("1");

    public static final C_BatchHeisouKbn WL = new C_BatchHeisouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, None, "None", true);
        addPattern(PATTERN_DEFAULT, BL, "BL", false);
        addPattern(PATTERN_DEFAULT, WL, "WL", false);


        lock(C_BatchHeisouKbn.class);
    }

    private C_BatchHeisouKbn(String value) {
        super(value);
    }

    public static C_BatchHeisouKbn valueOf(String value) {
        return valueOf(C_BatchHeisouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchHeisouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchHeisouKbn.class, patternId, value);
    }
}
