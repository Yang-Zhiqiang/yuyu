
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 初診再診区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyosaiKbn</td><td colspan="3">初診再診区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SOYSIN}</td><td>&quot;1&quot;</td><td>初診</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISIN}</td><td>&quot;2&quot;</td><td>再診</td></tr>
 * </table>
 */
public class C_SyosaiKbn extends Classification<C_SyosaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyosaiKbn SOYSIN = new C_SyosaiKbn("1");

    public static final C_SyosaiKbn SAISIN = new C_SyosaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SOYSIN, "SOYSIN", true);
        addPattern(PATTERN_DEFAULT, SAISIN, "SAISIN", false);


        lock(C_SyosaiKbn.class);
    }

    private C_SyosaiKbn(String value) {
        super(value);
    }

    public static C_SyosaiKbn valueOf(String value) {
        return valueOf(C_SyosaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyosaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyosaiKbn.class, patternId, value);
    }
}
