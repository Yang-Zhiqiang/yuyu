
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備解消処理状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HbksshorijtKbn</td><td colspan="3">不備解消処理状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISYORI}</td><td>&quot;0&quot;</td><td>未処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORIZUMI}</td><td>&quot;1&quot;</td><td>処理済</td></tr>
 * </table>
 */
public class C_HbksshorijtKbn extends Classification<C_HbksshorijtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HbksshorijtKbn MISYORI = new C_HbksshorijtKbn("0");

    public static final C_HbksshorijtKbn SYORIZUMI = new C_HbksshorijtKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISYORI, "MISYORI", true);
        addPattern(PATTERN_DEFAULT, SYORIZUMI, "SYORIZUMI", false);


        lock(C_HbksshorijtKbn.class);
    }

    private C_HbksshorijtKbn(String value) {
        super(value);
    }

    public static C_HbksshorijtKbn valueOf(String value) {
        return valueOf(C_HbksshorijtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HbksshorijtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HbksshorijtKbn.class, patternId, value);
    }
}
