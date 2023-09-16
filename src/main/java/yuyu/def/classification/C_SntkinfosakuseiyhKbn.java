
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報作成要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkinfosakuseiyhKbn</td><td colspan="3">選択情報作成要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SAKUSEIYOU}</td><td>&quot;1&quot;</td><td>作成する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIHUYOU}</td><td>&quot;2&quot;</td><td>作成不要</td></tr>
 * </table>
 */
public class C_SntkinfosakuseiyhKbn extends Classification<C_SntkinfosakuseiyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkinfosakuseiyhKbn SAKUSEIYOU = new C_SntkinfosakuseiyhKbn("1");

    public static final C_SntkinfosakuseiyhKbn SAKUSEIHUYOU = new C_SntkinfosakuseiyhKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SAKUSEIYOU, "SAKUSEIYOU", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIHUYOU, "SAKUSEIHUYOU", false);


        lock(C_SntkinfosakuseiyhKbn.class);
    }

    private C_SntkinfosakuseiyhKbn(String value) {
        super(value);
    }

    public static C_SntkinfosakuseiyhKbn valueOf(String value) {
        return valueOf(C_SntkinfosakuseiyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkinfosakuseiyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkinfosakuseiyhKbn.class, patternId, value);
    }
}
